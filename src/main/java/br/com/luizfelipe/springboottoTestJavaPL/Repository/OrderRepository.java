package br.com.luizfelipe.springboottoTestJavaPL.Repository;

import br.com.luizfelipe.springboottoTestJavaPL.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
