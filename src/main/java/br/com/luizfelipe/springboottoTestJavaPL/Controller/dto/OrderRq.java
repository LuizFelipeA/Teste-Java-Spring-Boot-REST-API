package br.com.luizfelipe.springboottoTestJavaPL.Controller.dto;

import br.com.luizfelipe.springboottoTestJavaPL.Enum.CanalVenda;
import br.com.luizfelipe.springboottoTestJavaPL.Enum.Status;

public class OrderRq {

    private Integer id_user;
    private Long id_product;
    private Double price;
    private CanalVenda canal_de_venda;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CanalVenda getCanal_de_venda() {
        return canal_de_venda;
    }

    public void setCanal_de_venda(CanalVenda canal_de_venda) {
        this.canal_de_venda = canal_de_venda;
    }
}
