package repository;

/**
 * Created by ScorpionOrange on 2017/02/20.
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Song;

public interface SongRepository extends JpaRepository<Song, String> {

    List<Song> findByCommentCountGreaterThan(Long commentCount);

}
