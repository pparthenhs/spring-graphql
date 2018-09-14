package pparthenis.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pparthenis.project.configuration.InitializeConfiguration;
import pparthenis.project.model.domain.Car;
import pparthenis.project.model.domain.Owner;
import pparthenis.project.model.repository.CarRepo;
import pparthenis.project.model.repository.OwnerRepo;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

  private static final Logger LOGGER = LogManager.getLogger(ApplicationStartup.class);

  @Autowired
  private CarRepo carRepo;

  @Autowired
  private OwnerRepo ownerRepo;

  @Autowired
  private InitializeConfiguration initializeConfiguration;

  public void onApplicationEvent(ApplicationReadyEvent event) {

    if (initializeConfiguration.isDatabase()) {

      Owner owner = new Owner();
      owner.setName("panos parthenis");
      ownerRepo.insert(owner);

      Car car = new Car();
      car.setColor("black");
      car.setMark("Reno");
      car.setOwner(owner);
      car.setLabel("FDS-1355");
      carRepo.insert(car);

      LOGGER.info("initialize database");
    } else {
      LOGGER.info("not initialize database");
    }

    //Dataloader
    /*
        BatchLoader<String, Car> carBatchLoader = new BatchLoader<String, Car>() {
      @Override
      public CompletionStage<List<Car>> load(List<String> list) {
        return CompletableFuture.supplyAsync(() -> {
          return carRepo.findCarsByIdIn(list);
        });
      }
    };

    DataLoader<String, Car> carLoader = new DataLoader(carBatchLoader);

    carLoader.load("5b9a1aff93184239b2eb2b4c");

     */

  }
}
