package pparthenis.project.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.transfer.CombineObject;
import pparthenis.project.transfer.Output;
import pparthenis.project.model.domain.Car;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.model.repository.CarRepo;
import pparthenis.project.model.repository.OwnerRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class Query implements GraphQLQueryResolver {

  @Autowired
  private OwnerRepo ownerRepo;

  @Autowired
  private CarRepo carRepo;

  public List<Owner> allOwners() {
    return ownerRepo.findAll();
  }

  public List<Car> allVehicles() {
    return carRepo.findAll();
  }

  public List<Owner> allOwnersLastTwo(int n) {
    return ownerRepo.findAll().subList(ownerRepo.findAll().size() - n, ownerRepo.findAll().size());
  }

  public List<Owner> allOwnersContainsName(String name) {
    return ownerRepo.findAll().stream().filter(x -> x.getName().contains(name)).collect(Collectors.toList());
  }

  public Owner hasVehicles(String id) {
    Optional<Owner> owner = ownerRepo.findById(id);
    if (owner.isPresent()) {
      if (carRepo.findAll().stream().filter(x -> x.getOwner().getId().compareTo(owner.get().getId()) == 0).count() == 0) {
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
    Optional<Owner> owner = ownerRepo.findById(combineObject.getOwnerId());

    if (owner.isPresent()) {
      long total = carRepo.countByOwnerAndColor(owner.get(), combineObject.getCarColor());
      output.setText("The owner id :" + " has " + total + "car with color" + combineObject.getCarColor());
    } else {
      output.setText("The owner id :" + "does not exist");
    }

    return output;
  }
}
