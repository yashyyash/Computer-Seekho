package com.seekho.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "album_master")

public class AlbumMaster
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private int albumId;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "album_description")
    private String albumDescription;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "album_is_active")
    private boolean albumIsActive = false;

    // Getters and Setters

    public int getAlbumId()
    {
        return albumId;
    }
    public void setAlbumId(int albumId)
    {
        this.albumId = albumId;
    }

    public String getAlbumName()
    {
        return albumName;
    }
    public void setAlbumName(String albumName)
    {
        this.albumName = albumName;
    }

    public String getAlbumDescription()
    {
        return albumDescription;
    }
    public void setAlbumDescription(String albumDescription)
    {
        this.albumDescription = albumDescription;
    }

    public LocalDateTime getStartDate()
    {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate)
    {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate()
    {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate)
    {
        this.endDate = endDate;
    }


    public boolean isAlbumIsActive()
    {
        return albumIsActive;
    }

    public void setAlbumIsActive(boolean albumIsActive)
    {
        this.albumIsActive = albumIsActive;
    }
}
