package solo.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.project1.domain.Comment;


public interface CommentRepository extends JpaRepository<Comment,Long> {


}
