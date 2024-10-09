package com.attractedtocode.gallery.repos;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attractedtocode.gallery.models.AlbumE;

@Repository
public interface AlbumR extends JpaRepository<AlbumE, Integer> {
    List<AlbumE> findAll();
    List<AlbumE> findAllByOrderByIdDesc();
    List<AlbumE> findAllByOrderByIdAsc();
    Optional<AlbumE> findById(int id);
    AlbumE findFirstByNameIgnoreCase(String name);
    List<AlbumE> findByNameContainsIgnoreCase(String name);
    List<AlbumE> findByCreationDateIsBetween(LocalDate from, LocalDate to);
    List<AlbumE> findAllByOrderByNameAsc();
}
