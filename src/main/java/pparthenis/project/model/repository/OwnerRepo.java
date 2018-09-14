package pparthenis.project.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pparthenis.project.model.domain.Owner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panagiotis Parthenis
 */
@Repository
public interface OwnerRepo extends MongoRepository<Owner, String> {

  List<Owner> findOwnersByIdIn(List<String> keys);
}
