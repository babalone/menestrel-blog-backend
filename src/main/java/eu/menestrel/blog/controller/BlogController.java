package eu.menestrel.blog.controller;

import eu.menestrel.blog.model.BlogPost;
import eu.menestrel.blog.service.BlogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/blog")
public class BlogController {

  @Autowired
  private BlogService blogService;

  @GET
  @Produces("application/json")
  public List<BlogPost> getAllPosts() {
    return blogService.getAllPosts();
  }
}
