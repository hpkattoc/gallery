package com.attractedtocode.gallery.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attractedtocode.gallery.models.AlbumE;
import com.attractedtocode.gallery.repos.AlbumR;

@Service
public class AlbumS {
    @Autowired
    private AlbumR aR;

    public void saveAlbum(AlbumE album) {
        aR.save(album);
    }

    public List<AlbumE> getAlbums() {
        return aR.findAll();
    }

    public List<AlbumE> getAlbumsFromNewest(){
        return aR.findAllByOrderByIdDesc();
    }

    public AlbumE getAlbumById(int id) {
        return aR.findById(id).orElse(null);
    }

    public void deleteAlbum(int id) {
        aR.deleteById(id);
    }

    public AlbumE updateAlbum(AlbumE album) {
        return aR.save(album);
    }
    
    public List<AlbumE> getAlbumsFromOldest() {
        return aR.findAllByOrderByIdAsc();
    }

    public List<AlbumE> getAlbumsInNameOrder(){
        return aR.findAllByOrderByNameAsc();
    }

    public List<AlbumE> getAlbumsBetweenDate(LocalDate from, LocalDate to) {
        return aR.findByCreationDateIsBetween(from , to);
    }

    public List<AlbumE> getAlbumsContainingTitle(String name) {
        return aR.findByNameContainsIgnoreCase(name);
    }
}
