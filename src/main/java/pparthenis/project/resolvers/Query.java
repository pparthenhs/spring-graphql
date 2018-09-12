package pparthenis.project.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Car;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.model.repository.CarRepo;
import pparthenis.project.model.repository.OwnerRepo;

import java.util.List;
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
}
