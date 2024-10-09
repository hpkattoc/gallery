package com.attractedtocode.gallery.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attractedtocode.gallery.models.AlbumE;
import com.attractedtocode.gallery.models.ImageE;
import com.attractedtocode.gallery.repos.ImageR;

@Service
public class ImageS {
    @Autowired
    private ImageR iR;

    public void save(ImageE image){
        iR.save(image);
    }

    public void delete(int id){
        iR.deleteById(id);
    }

    public List<ImageE> getImages(){
        return iR.findAll();
    }

    public List<ImageE> getImagesByAlbum(AlbumE album){
        return iR.findByAlbumByOrderByIdAsc(album);
    }

    public List<ImageE> getNewestImagesByAlbum(AlbumE album){
        return iR.findByAlbumByOrderByIdDesc(album);
    }

    public ImageE update(ImageE image){
        return iR.save(image);
    }

    public ImageE getImageById(int id){
        return iR.findById(id).orElse(null);
    }

    public List<ImageE> getImagesByDatesBetween(LocalDate from, LocalDate to){
        return iR.findByUploadDateIsBetween(from, to);
    }
}
