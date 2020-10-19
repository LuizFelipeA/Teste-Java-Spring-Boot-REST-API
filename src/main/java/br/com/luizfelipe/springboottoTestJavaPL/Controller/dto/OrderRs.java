package br.com.luizfelipe.springboottoTestJavaPL.Controller.dto;

import br.com.luizfelipe.springboottoTestJavaPL.Enum.CanalVenda;
import br.com.luizfelipe.springboottoTestJavaPL.Enum.Status;
import br.com.luizfelipe.springboottoTestJavaPL.Model.Order;

public class OrderRs {

    private Integer id_user;
    private Long id_product;
    private Status status;
    private Double price;

    public static OrderRs converter(Order o) {
        var order = new OrderRs();
        order.setId_user(o.getId_user());
        order.setId_product(o.getId_product());
        order.setStatus(o.getStatus());
        order.setPrice(o.getPrice());

        return order;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
