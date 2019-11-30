package eu.menestrel.blog.repository;

import eu.menestrel.blog.model.Author;
import eu.menestrel.blog.model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<BlogPost, String> {
  BlogPost findByTitle(String id);
  BlogPost findByAuthors(Author author);
  BlogPost findByTags(String tag);
}
