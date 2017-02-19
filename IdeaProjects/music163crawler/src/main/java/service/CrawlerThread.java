package service;

/**
 * Created by ScorpionOrange on 2017/02/20.
 */
import model.Song;
import model.WebPage;
import model.WebPage.PageType;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

public class CrawlerThread implements Runnable {

    public static final String BASE_URL = "http://music.163.com/";
    public static final String text = "{\"username\": \"\", \"rememberLogin\": \"true\", \"password\": \"\"}";
    private CrawlerService crawlerService;

    public CrawlerThread() {
        super();
    }

    public CrawlerThread(CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }

    @Override
    public void run() {
        while (true) {
            WebPage webPage = crawlerService.getUnCrawlPage(); // TODO: 更好的退出机制
            if (webPage == null)
                return; // 拿不到url，说明没有需要爬的url，直接退出
            try {
                if (fetchHtml(webPage))
                    parse(webPage); // TODO: 如果获取页面失败，考虑重连机制，这里继续爬下个页面
            } catch (Exception e) { }
        }
    }

    private boolean fetchHtml(WebPage webPage) throws IOException {
        Connection.Response response = Jsoup.connect(webPage.getUrl()).timeout(3000).execute();
        webPage.setHtml(response.body());
        return response.statusCode() / 100 == 2 ? true : false;
    }

    private void parse(WebPage webPage) throws Exception {
        if (PageType.playlists.equals(webPage.getType()))
            parsePlaylists(webPage).forEach(page -> crawlerService.savePage(page));
        if (PageType.playlist.equals(webPage.getType()))
            parsePlaylist(webPage).forEach(page -> crawlerService.savePage(page));
        if (PageType.song.equals(webPage.getType()))
            crawlerService.saveSong(parseSong(webPage));
    }

    private List<WebPage> parsePlaylists(WebPage webPage) {
        // 解析歌单列表页面
        return null;
    }

    private List<WebPage> parsePlaylist(WebPage webPage) {
        //解析歌单页面
        return null;
    }

    private Song parseSong(WebPage webPage) throws Exception {
        // 解析歌曲页面
        return null;
    }



}
