package com.seekho.api.dto;

import java.time.LocalDateTime;

public class AlbumMasterDTO
{
    private int album_id;
    private String album_name;
    private String album_description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private boolean album_is_active;

    // Getters and Setters
    public int getAlbum_id()
    {
        return album_id;
    }
    public void setAlbum_id(int album_id)
    {
        this.album_id = album_id;
    }

    public String getAlbum_name() {
        return album_name;
    }
    public void setAlbum_name(String album_name)
    {
        this.album_name = album_name;
    }

    public String getAlbum_description()
    {
        return album_description;
    }
    public void setAlbum_description(String album_description)
    {
        this.album_description = album_description;
    }

    public LocalDateTime getStart_date()
    {
        return start_date;
    }
    public void setStart_date(LocalDateTime start_date)
    {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date()
    {
        return end_date;
    }
    public void setEnd_date(LocalDateTime end_date)
    {
        this.end_date = end_date;
    }


    public boolean isAlbum_is_active()
    {
        return album_is_active;
    }

    public void setAlbum_is_active(boolean album_is_active)
    {
        this.album_is_active = album_is_active;
    }
}
