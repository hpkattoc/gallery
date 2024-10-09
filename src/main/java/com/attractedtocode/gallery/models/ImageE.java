package com.attractedtocode.gallery.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class ImageE {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String imageUrl;
    private AlbumE album;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime uploadDate;

    public ImageE() {
    }

    public ImageE(String imageUrl, AlbumE album, LocalDateTime uploadDate) {
        this.imageUrl = imageUrl;
        this.album = album;
        this.uploadDate = uploadDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AlbumE getAlbum() {
        return album;
    }

    public void setAlbum(AlbumE album) {
        this.album = album;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImageE{");
        sb.append("id=").append(id);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", album=").append(album.getName());
        sb.append(", uploadDate=").append(uploadDate);
        sb.append('}');
        return sb.toString();
    }


}
