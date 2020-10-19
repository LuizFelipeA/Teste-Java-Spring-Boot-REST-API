package br.com.luizfelipe.springboottoTestJavaPL.Repository;

import br.com.luizfelipe.springboottoTestJavaPL.Model.Order;
import br.com.luizfelipe.springboottoTestJavaPL.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Repository
public class UserCustomRepository {

    private final EntityManager em;

    public UserCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<User> find(String email, String name, Date birthdate) {

        String query = "SELECT U FROM User AS U ";
        String condicao = "WHERE ";

        if(email != null) {
            query += condicao + "U.Email = :email";
            condicao = " AND ";
        }
        if(name != null) {
            query += condicao + "U.Name = :email";
            condicao = " AND ";
        }
        if(birthdate != null) {
            query += condicao + "U.Birthdate = :birthdate";
            condicao = " AND ";
        }

        var q = em.createQuery(query, User.class);

        if(email != null) {
            q.setParameter("email", email);
        }
        if(name != null) {
            q.setParameter("name", name);
        }
        if(birthdate != null) {
            q.setParameter("birthdate", birthdate);
        }

        return q.getResultList();
    }
}
