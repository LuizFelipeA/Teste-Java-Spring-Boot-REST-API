package br.com.luizfelipe.springboottoTestJavaPL.Model;

import br.com.luizfelipe.springboottoTestJavaPL.Enum.Status;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name = "Id_User")
    private Integer id_user;

    @Column(name = "Id_Product")
    private Long id_product;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 100)
    private Status status;

    @Column(name = "Price")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
