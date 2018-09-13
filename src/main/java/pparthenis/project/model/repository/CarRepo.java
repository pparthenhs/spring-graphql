package pparthenis.project.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pparthenis.project.model.domain.Car;
import pparthenis.project.model.domain.Owner;

/**
 * @author Panagiotis Parthenis
 */
@Repository
public interface CarRepo extends MongoRepository<Car, String>{

    long countByOwnerAndColor(Owner owner, String color);
}
