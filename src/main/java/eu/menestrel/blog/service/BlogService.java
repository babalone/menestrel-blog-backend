package eu.menestrel.blog.service;

import eu.menestrel.blog.model.Author;
import eu.menestrel.blog.model.BlogPost;
import eu.menestrel.blog.repository.PostRepository;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class BlogService {

  @Autowired
  private PostRepository postRepository;

  public List<BlogPost> getAllPosts() {

    return postRepository.findAll(Sort.by("createdTime"));
  }
}
