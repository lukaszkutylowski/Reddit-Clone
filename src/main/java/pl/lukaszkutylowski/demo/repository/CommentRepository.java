package pl.lukaszkutylowski.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszkutylowski.demo.model.Comment;
import pl.lukaszkutylowski.demo.model.Post;
import pl.lukaszkutylowski.demo.model.User;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
    List<Comment> findAllByUser(User user);
}
