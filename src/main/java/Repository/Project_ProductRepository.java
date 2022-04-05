package Repository;

import Entity.Project_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Project_ProductRepository extends JpaRepository<Project_Product, Integer> {
}
