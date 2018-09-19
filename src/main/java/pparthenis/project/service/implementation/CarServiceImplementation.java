package pparthenis.project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Car;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.model.repository.CarRepo;
import pparthenis.project.service.CarService;
import pparthenis.project.service.GenericService;

import java.util.List;
import java.util.Optional;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class CarServiceImplementation implements GenericService<Car, String>, CarService<Car, String> {

  @Autowired
  private CarRepo carRepo;

  @Override
  public List<Car> retrieveAll() {
    return carRepo.findAll();
  }

  @Override
  public Optional<Car> retrieveOne(String id) {
    return carRepo.findById(id);
  }

  @Override
  public Car createOne(Car o) {
    return carRepo.insert(o);
  }

  @Override
  public long countByOwnerAndColor(Owner owner, String color) {
    return carRepo.countByOwnerAndColor(owner,color);
  }

}
