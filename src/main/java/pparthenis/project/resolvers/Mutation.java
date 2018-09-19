package pparthenis.project.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.service.GenericService;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private GenericService<Owner,String> ownerService;

  public Owner createOwner(String name) {
    Owner owner = new Owner();
    owner.setName(name);

    Object temp = ownerService.createOne(owner);
    return (Owner) temp;
  }
}
