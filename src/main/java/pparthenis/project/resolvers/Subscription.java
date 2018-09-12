package pparthenis.project.resolvers;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.model.repository.CarRepo;
import pparthenis.project.model.repository.OwnerRepo;

import java.util.List;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class Subscription implements GraphQLSubscriptionResolver {

  @Autowired
  private OwnerRepo ownerRepo;

  public List<Owner> allOwnersSub() {
    return ownerRepo.findAll();
  }

}
