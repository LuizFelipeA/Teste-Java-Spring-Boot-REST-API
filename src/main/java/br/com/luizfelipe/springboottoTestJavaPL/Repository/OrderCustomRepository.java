package br.com.luizfelipe.springboottoTestJavaPL.Repository;

import br.com.luizfelipe.springboottoTestJavaPL.Enum.Status;
import br.com.luizfelipe.springboottoTestJavaPL.Model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderCustomRepository {

    private final EntityManager em;

    public OrderCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Order> find(Long id, Integer id_user, Long id_product, Status status, Double price) {

        String query = "SELECT O FROM Order AS O ";
        String condicao = "WHERE ";

        if(id != null) {
            query += condicao + "O.id = :id";
            condicao = " AND ";
        }
        if(id_user != null) {
            query += condicao + "O.id_user = :id_user";
            condicao = " AND ";
        }
        if(id_product != null) {
            query += condicao + "O.id_product = :id_product";
            condicao = " AND ";
        }
        if(status != null) {
            query += condicao + "O.status = :status";
            condicao = " AND ";
        }
        if(price != null) {
            query += condicao + "O.price = :price";
        }

        var q = em.createQuery(query, Order.class);

        if(id != null) {
            q.setParameter("id", id);
        }
        if(id_user != null) {
            q.setParameter("id_user", id_user);
        }
        if(id_product != null) {
            q.setParameter("id_product", id_product);
        }
        if(status != null) {
            q.setParameter("status", status);
        }
        if(price != null) {
            q.setParameter("price", price);
        }

        return q.getResultList();
    }
}
