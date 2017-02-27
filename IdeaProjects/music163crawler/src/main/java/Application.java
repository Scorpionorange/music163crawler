/**
 * Created by ScorpionOrange on 2017/02/20.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.logging.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
@EnableAsync
@EnableCaching
public class Application {

    public static void main(String[] args) throws IOException,
                                                  URISyntaxException,
                                                  IllegalAccessException {
        SpringApplication.run(Application.class);
    }
}
