package eu.menestrel.blog.service;

import eu.menestrel.blog.model.BlogPost;
import eu.menestrel.blog.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class BlogService {

  private final PostRepository postRepository;

  @Autowired
  public BlogService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<BlogPost> getAllPosts() {

    return postRepository.findAll(Sort.by("createdTime"));
  }
}
