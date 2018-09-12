package pparthenis.project.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.model.repository.OwnerRepo;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private OwnerRepo ownerRepo;

  public Owner createOwner(String name) {
    Owner owner = new Owner();
    owner.setName(name);

    return ownerRepo.insert(owner);
  }
}
