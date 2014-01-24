package com.sismics.music.core.listener.async;

import java.text.MessageFormat;

import com.sismics.music.core.model.jpa.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;
import com.sismics.music.core.dao.file.html.FaviconDownloader;
import com.sismics.music.core.event.FaviconUpdateRequestedEvent;
import com.sismics.music.core.util.DirectoryUtil;
import com.sismics.music.core.util.TransactionUtil;

/**
 * Listener on a feed favicon update request.
 * 
 * @author jtremeaux
 */
public class FaviconUpdateRequestedAsyncListener {
    /**
     * Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(FaviconUpdateRequestedAsyncListener.class);

    /**
     * Process the event.
     * 
     * @param faviconUpdateRequestedEvent OPML imported event
     * @throws Exception
     */
    @Subscribe
    public void onFaviconUpdateRequested(final FaviconUpdateRequestedEvent faviconUpdateRequestedEvent) throws Exception {
        if (log.isInfoEnabled()) {
            log.info(MessageFormat.format("Favicon update requested event: {0}", faviconUpdateRequestedEvent.toString()));
        }
        
        final Track feed = faviconUpdateRequestedEvent.getFeed();
       
        TransactionUtil.handle(new Runnable() {
            @Override
            public void run() {
                String faviconDirectory = DirectoryUtil.getFaviconDirectory().getPath();
                FaviconDownloader downloader = new FaviconDownloader();
                
                // Try with the feed URL
                String localFilename = downloader.downloadFaviconFromPage(feed.getUrl(), faviconDirectory, feed.getId());
                if (localFilename == null) {
                    // If nothing is found, try again with the RSS URL
                    downloader.downloadFaviconFromPage(feed.getRssUrl(), faviconDirectory, feed.getId());
                }
            }
        });
    }
}
