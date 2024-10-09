package com.attractedtocode.gallery.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attractedtocode.gallery.models.AlbumE;
import com.attractedtocode.gallery.models.ImageE;

@Repository
public interface ImageR extends JpaRepository<ImageE, Integer> {
    
    List<ImageE> findAll();
    List<ImageE> findAllByOrderByIdDesc();
    List<ImageE> findByAlbumByOrderByIdAsc(AlbumE album);
    List<ImageE> findByAlbumByOrderByIdDesc(AlbumE album);
    List<ImageE> findByUploadDateIsBetween(LocalDate from, LocalDate to);

}
