package pparthenis.project.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Panagiotis Parthenis
 */
@Service
public interface BaseService<O, ID> {

  List<O> retrieveAll();

  Optional<O> retrieveOne(ID id);

  O createOne(O o);
}
