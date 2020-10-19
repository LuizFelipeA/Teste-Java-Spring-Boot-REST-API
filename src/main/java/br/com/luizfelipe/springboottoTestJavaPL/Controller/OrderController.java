package br.com.luizfelipe.springboottoTestJavaPL.Controller;

import br.com.luizfelipe.springboottoTestJavaPL.Controller.dto.OrderRq;
import br.com.luizfelipe.springboottoTestJavaPL.Controller.dto.OrderRs;
import br.com.luizfelipe.springboottoTestJavaPL.Enum.Status;
import br.com.luizfelipe.springboottoTestJavaPL.Model.Order;
import br.com.luizfelipe.springboottoTestJavaPL.Repository.OrderCustomRepository;
import br.com.luizfelipe.springboottoTestJavaPL.Repository.OrderRepository;
import br.com.luizfelipe.springboottoTestJavaPL.Repository.ProductRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderCustomRepository orderCustomRepository;

    public OrderController(OrderRepository orderRepository, ProductRepository productRepository, OrderCustomRepository orderCustomRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderCustomRepository = orderCustomRepository;
    }

    @PostMapping("/")
    @ApiOperation(value = "Register a order")
    public ResponseEntity<OrderRs> saveOrder(@RequestBody OrderRq order) {

        try {
            var or = new OrderRs();
            var o = new Order();
            o.setId_user(order.getId_user());
            o.setId_product(order.getId_product());
            var canalVenda = order.getCanal_de_venda();

            /*
                !!
                   Preço do produto sempre será de acordo com o id do produto passado e não com o que foi passado no body
                   Porém, coloquei no body por que foi pedido no enunciado
                !!
            */
            var product = productRepository.findById(order.getId_product());
            var price = product.get().getPrice();

            if(canalVenda.toString() == "e_commerce") {
                double perc = 5.37 / 100;
                double totalValue = price + (perc * price);

                o.setPrice(totalValue);
                o.setStatus(Status.valueOf(Status.aguardando_entrega.toString()));
            }else if(canalVenda.toString() == "loja_fisica") {
                o.setStatus(Status.valueOf(Status.entregue.toString()));
                o.setPrice(price);

            }else if(canalVenda.toString() == "parceiros") {
                double orignValue = price + 10.34;
                double perc = 8.78 / 100;
                double totalValue = orignValue + (perc * orignValue);

                o.setPrice(totalValue);
                o.setStatus(Status.valueOf(Status.aguardando_retirada_parceiro.toString()));
            }else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            orderRepository.save(o);

            return new ResponseEntity<>(or.converter(o), HttpStatus.CREATED);

        }catch(Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/")
    @ApiOperation(value= "Query custom orders")
    public List<OrderRs> getOrder(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "id_user", required = false) Integer id_user,
            @RequestParam(value = "id_product", required = false) Long id_product,
            @RequestParam(value = "status", required = false) Status status,
            @RequestParam(value = "price", required = false) Double price
    ) throws Exception {
        try {
            return this.orderCustomRepository.find(id, id_user, id_product, status, price)
                    .stream()
                    .map(OrderRs::converter)
                    .collect(Collectors.toList());
        } catch(Exception ex) {
            throw new Exception("Internal Server Error: " + ex);
        }
    }
}
