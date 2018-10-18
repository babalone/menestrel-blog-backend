package eu.menestrel.blog.service;

import eu.menestrel.blog.model.BlogPost;
import eu.menestrel.blog.repository.PostRepository;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class BlogService {

  @Autowired
  private PostRepository postRepository;

  public List<BlogPost> getAllPosts() {
    BlogPost blogPost = BlogPost.builder().build();
    blogPost.setTitle("some title");
    blogPost.setCreatedTime(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));

    postRepository.save(blogPost);

    return postRepository.findAll(Sort.by("createdTime"));
  }
}
