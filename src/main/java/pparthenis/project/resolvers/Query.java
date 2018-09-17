package pparthenis.project.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Car;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.service.CarService;
import pparthenis.project.service.OwnerService;
import pparthenis.project.transfer.CombineObject;
import pparthenis.project.transfer.Output;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class Query implements GraphQLQueryResolver {

  @Autowired
  private OwnerService ownerService;

  @Autowired
  private CarService carService;

  public List<Owner> allOwners() {
    return ownerService.findAllOwners();
  }

  public List<Car> allVehicles() {
    return carService.findAllCars();
  }

  public List<Owner> allOwnersLastTwo(int n) {
    List<Owner> temp = ownerService.findAllOwners();

    if (n < temp.size()) {
      return temp.subList(temp.size() - n, temp.size());
    } else {
      return temp;
    }
  }

  public List<Owner> allOwnersContainsName(String name) {
    List<Owner> temp = ownerService.findAllOwners();
    return temp.stream().filter(x -> x.getName().contains(name)).collect(Collectors.toList());
  }

  public Owner hasVehicles(String id) {
    Optional<Owner> owner = ownerService.findById(id);
    List<Car> temp = carService.findAllCars();
    if (owner.isPresent()) {
      if (temp.stream().filter(x -> x.getOwner().getId().compareTo(owner.get().getId()) == 0).count() == 0) {
        return null;
      } else {
        return owner.get();
      }
    } else {
      return null;
    }
  }

  public Output isGivenOwnerHasVehiclesWithGivenColor(CombineObject combineObject) {
    Output output = new Output();
    Optional<Owner> owner = ownerService.findById(combineObject.getOwnerId());

    if (owner.isPresent()) {
      long total = carService.countByOwnerAndColor(owner.get(), combineObject.getCarColor());
      output.setText("The owner id : " + combineObject.getOwnerId() + " has " + total + " car with color " + combineObject.getCarColor());
    } else {
      output.setText("The owner id : " + combineObject.getOwnerId() + "does not exist");
    }

    return output;
  }
}
