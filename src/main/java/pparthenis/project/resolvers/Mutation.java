package pparthenis.project.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.model.repository.OwnerRepo;
import pparthenis.project.service.OwnerService;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private OwnerService ownerService;

  public Owner createOwner(String name) {
    Owner owner = new Owner();
    owner.setName(name);

    Object temp = ownerService.createOwner(owner);
    return (Owner) temp;
  }
}
