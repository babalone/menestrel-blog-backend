package eu.menestrel.blog.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

/**
 * Data representing an author.
 */
@Data
@Builder
public class Author {

  /**
   * name of the author
   */
  private Optional<String> name;

  /**
   * name of the author that will be used publicly
   */
  private String publicName;

  /**
   * A list of contact information like "e-mail", "twitter", "github", etc.
   */
  private List<Pair<String, String>> contactInformation;
}
