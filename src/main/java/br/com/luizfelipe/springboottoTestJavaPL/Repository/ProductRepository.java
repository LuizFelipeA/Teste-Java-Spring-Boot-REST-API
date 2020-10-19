package br.com.luizfelipe.springboottoTestJavaPL.Repository;

import br.com.luizfelipe.springboottoTestJavaPL.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
