package pparthenis.project.service;

import org.springframework.stereotype.Service;
import pparthenis.project.model.domain.Owner;

/**
 * @author Panagiotis Parthenis
 */
@Service
public interface CarService<C,ID> extends BaseService<C, ID> {

 long countByOwnerAndColor (Owner owner, String color);
}
