package com.sismics.music.core.dao.dbi.criteria;

/**
 * Track criteria.
 *
 * @author jtremeaux
 */
public class TrackCriteria {
    /**
     * Album ID.
     */
    private String albumId;

    /**
     * Playlist user ID.
     */
    private String userId;

    /**
     * Playlist ID.
     */
    private String playlistId;

    /**
     * Title (like).
     */
    private String titleLike;

    /**
     * Getter of albumId.
     *
     * @return albumId
     */
    public String getAlbumId() {
        return this.albumId;
    }

    /**
     * Setter of id.
     *
     * @param albumId albumId
     * @return Criteria
     */
    public TrackCriteria setAlbumId(String albumId) {
        this.albumId = albumId;
        return this;
    }
    
    /**
     * Getter of userId.
     *
     * @return userId
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * Setter of id.
     *
     * @param userId userId
     * @return Criteria
     */
    public TrackCriteria setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
    /**
     * Getter of playlistId.
     *
     * @return playlistId
     */
    public String getPlaylistId() {
        return this.playlistId;
    }

    /**
     * Setter of id.
     *
     * @param playlistId playlistId
     * @return Criteria
     */
    public TrackCriteria setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
        return this;
    }

    /**
     * Getter of titleLike.
     *
     * @return titleLike
     */
    public String getTitleLike() {
        return this.titleLike;
    }

    /**
     * Setter of titleLike.
     *
     * @param titleLike titleLike
     * @return Criteria
     */
    public TrackCriteria setTitleLike(String titleLike) {
        this.titleLike = titleLike;
        return this;
    }
}