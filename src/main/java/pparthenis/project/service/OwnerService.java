package pparthenis.project.service;

import org.springframework.stereotype.Service;
import pparthenis.project.model.domain.Owner;

import java.util.List;
import java.util.Optional;

/**
 * @author Panagiotis Parthenis
 */
@Service
public interface OwnerService<O, ID> {

  List<O> findAllOwners();

  Optional<O> findById (ID id);

  O createOwner(O o);
}
