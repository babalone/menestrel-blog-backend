package eu.menestrel.blog.model;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Data object representing a blog post.
 */
@Data
@Builder
public class BlogPost {

  /**
   * Authors of the blog post.
   */
  private List<Author> authors;

  /**
   * Time when the post was first created (UTC)
   */
  private Date createdTime;

  /**
   * Time when the last change took place (UTC)
   */
  private Date updateTime;

  /**
   * A list of tags for the post.
   */
  private List<String> tags;

  /**
   * The title of the article.
   */
  private String title;

  /**
   * The content of the blog post.
   */
  private String content;
}
