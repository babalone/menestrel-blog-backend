package eu.menestrel.blog.repository;

import eu.menestrel.blog.model.Author;
import eu.menestrel.blog.model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<BlogPost, String> {
  public BlogPost findByTitle(String id);
  public BlogPost findByAuthors(Author author);
  public BlogPost findByTags(String tag);
}
