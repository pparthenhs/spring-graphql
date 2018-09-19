package pparthenis.project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.model.repository.OwnerRepo;
import pparthenis.project.service.OwnerService;

import java.util.List;
import java.util.Optional;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class OwnerServiceImplemetation implements OwnerService<Owner, String> {

  @Autowired
  private OwnerRepo ownerRepo;

  @Override
  public List<Owner> retrieveAll() {
    return ownerRepo.findAll();
  }

  @Override
  public Optional<Owner> retrieveOne(String s) {
    return ownerRepo.findById(s);
  }

  @Override
  public Owner createOne(Owner o) {
    return ownerRepo.insert(o);
  }

}
