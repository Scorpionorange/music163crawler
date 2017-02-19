package repository;

/**
 * Created by ScorpionOrange on 2017/02/20.
 */
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import model.WebPage;
import model.WebPage.Status;

public interface WebPageRepository extends JpaRepository<WebPage, String> {

    WebPage findTopByStatus(Status status);

    @Modifying
    @Transactional
    @Query("update WebPage w set w.status = ?1")
    void resetStatus(Status status);

}
