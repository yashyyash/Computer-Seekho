package com.seekho.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "image_master")
public class ImageMaster
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int imageId;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "album_id")
    private int albumId;

    @Column(name = "is_album_cover")
    private boolean isAlbumCover = false;

    @Column(name = "image_is_active")
    private boolean imageIsActive;

    // Getters and Setters
    public int getImageId() { return imageId; }
    public void setImageId(int imageId) { this.imageId = imageId; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public int getAlbumId() { return albumId; }
    public void setAlbumId(int albumId) { this.albumId = albumId; }

    public boolean isAlbumCover() { return isAlbumCover; }
    public void setAlbumCover(boolean albumCover) { isAlbumCover = albumCover; }

    public boolean isImageIsActive() { return imageIsActive; }
    public void setImageIsActive(boolean imageIsActive) { this.imageIsActive = imageIsActive; }
}
