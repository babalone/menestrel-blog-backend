package eu.menestrel.blog;

import eu.menestrel.blog.controller.BlogController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(BlogController.class);
  }

}
