import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pparthenis.project.ApplicationStartup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Panagiotis Parthenis
 */
public class Examples {

  private static final Logger LOGGER = LogManager.getLogger(ApplicationStartup.class);

  public static void main(String[] args) throws IOException {
    String query = "{\n" +
        "  allOwnersContainsName(name:\"kostas\") {\n" +
        "    name\n" +
        "  }\n" +
        "}";

    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("query", query);
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8000/graphql?query={query}", String.class, uriParams);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
    String originalJson = response.getBody();
    JsonNode tree = objectMapper.readTree(originalJson);
    String formattedJson = objectMapper.writeValueAsString(tree);

    LOGGER.info(formattedJson);
  }
}
