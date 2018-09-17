package pparthenis.project.service;

import org.springframework.stereotype.Service;
import pparthenis.project.model.domain.Owner;

import java.util.List;

/**
 * @author Panagiotis Parthenis
 */
@Service
public interface CarService<C, ID> {

  List<C> findAllCars ();

  long countByOwnerAndColor (Owner owner, String color);
}
