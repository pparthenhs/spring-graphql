package pparthenis.project.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Panagioti Partheni
 */

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "initialize")
@Component
public class InitializeConfiguration {

  private boolean database;

  public boolean isDatabase() {
    return database;
  }

  public void setDatabase(boolean database) {
    this.database = database;
  }
}
