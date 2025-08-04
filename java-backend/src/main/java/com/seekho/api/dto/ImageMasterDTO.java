package com.seekho.api.dto;

public class ImageMasterDTO
{
    private int image_id;
    private String image_path;
    private int album_id;
    private boolean is_album_cover;
    private boolean image_is_active;

    // Getters and Setters
    public int getImage_id() { return image_id; }
    public void setImage_id(int image_id) { this.image_id = image_id; }

    public String getImage_path() { return image_path; }
    public void setImage_path(String image_path) { this.image_path = image_path; }

    public int getAlbum_id() { return album_id; }
    public void setAlbum_id(int album_id) { this.album_id = album_id; }

    public boolean isIs_album_cover() { return is_album_cover; }
    public void setIs_album_cover(boolean is_album_cover) { this.is_album_cover = is_album_cover; }

    public boolean isImage_is_active() { return image_is_active; }
    public void setImage_is_active(boolean image_is_active) { this.image_is_active = image_is_active; }
}
