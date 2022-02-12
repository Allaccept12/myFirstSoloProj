package solo.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import solo.project1.domain.Account;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Account, Long> {

    @Query("select distinct p from Account p left join fetch p.comments where p.id = :postId")
    Optional<List<Account>> findPostWithAllComment(@Param("postId") Long postId);

    @Query("select p from Account p order by p.createdTime desc ")
    List<Account> findAll();

    @Query("select p from Account p where p.id =:postId")
    Account customFindById(@Param("postId") long postId);
}
