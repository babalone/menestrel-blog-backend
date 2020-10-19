package eu.menestrel.blog.repository;

import eu.menestrel.blog.model.Author;
import eu.menestrel.blog.model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<BlogPost, String> {
  BlogPost findByTitle(String id); // Title is chosen as id for posts; risky choice, because can't be changed
  BlogPost findByAuthors(Author author); // TODO: wrong return type, but works for one post
  BlogPost findByTags(String tag); // TODO: wrong return type, but works for one post
}
