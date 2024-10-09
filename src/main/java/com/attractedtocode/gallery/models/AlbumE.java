package com.attractedtocode.gallery.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class AlbumE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    private String coverImage;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<ImageE> images;

    public AlbumE() {
    }

    public AlbumE(String name, String coverImage, LocalDateTime creationDate, List<ImageE> images) {
        this.name = name;
        this.coverImage = coverImage;
        this.creationDate = creationDate;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<ImageE> getImages() {
        return images;
    }

    public void setImages(List<ImageE> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "AlbumE [id=" + id + ", name=" + name + ", creationDate=" + creationDate
                + ", images=" + images.size() + "]";
    }

}
