package eu.menestrel.blog.controller;

import eu.menestrel.blog.model.Author;
import eu.menestrel.blog.model.BlogPost;
import eu.menestrel.blog.repository.PostRepository;
import eu.menestrel.blog.service.BlogService;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/blog")
public class BlogController {

  @Autowired
  private BlogService blogService;

  @Autowired
  private PostRepository postRepository;

  @GET
  @Produces("application/json")
  public List<BlogPost> getAllPosts() {
    return blogService.getAllPosts();
  }

  @GET
  @Path("/generatePost")
  public void getCreatePosts() {
    BlogPost blogPost = BlogPost.builder().build();
    List<Pair<String, String>> contactInformations = new ArrayList<>(5);
    contactInformations.add(Pair.of("twitter", "@babalone"));
    contactInformations.add(Pair.of("e-mail", "blog@bazzinga.eu"));

    List<Author> authors = new ArrayList<>(1);
    authors.add(
        Author.builder()
            .name(Optional.of("Stephan Spielmann"))
            .publicName("Stephan Spielmann")
            .contactInformation(contactInformations)
            .build());

    blogPost.setAuthors(authors);
    blogPost.setTitle("The start");
    blogPost.setCreatedTime(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
    blogPost.setUpdateTime(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
    List<String> tags = new ArrayList<>(5);
    tags.add("blog");
    tags.add("architecture");
    tags.add("java");
    tags.add("react");
    tags.add("spring");
    tags.add("mongodb");
    blogPost.setTags(tags);
    blogPost.setContent(
        "My intention for this blog at the moment is to have a location where I"
            + "can post things that I learn and that may help other"
            + " people. I think it will be about programming and IT most of "
            + "the time but maybe also a bit about electronics, bicycles, politics.");
    postRepository.save(blogPost);
  }

  @GET
  @Path("/deletePosts")
  public void getDeleteePosts() {
    postRepository.deleteAll();
  }
}