package pparthenis.project.resolvers;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.service.BaseService;

import java.util.List;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class Subscription implements GraphQLSubscriptionResolver {

  @Autowired
  private BaseService<Owner,String> ownerService;

  public List<Owner> allOwnersSub() {
    return ownerService.retrieveAll();
  }

}
