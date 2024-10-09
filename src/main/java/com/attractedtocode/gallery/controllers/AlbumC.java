package com.attractedtocode.gallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.attractedtocode.gallery.models.AlbumE;
import com.attractedtocode.gallery.services.AlbumS;





@Controller
public class AlbumC {
    @Autowired
    private AlbumS aS;

    @GetMapping({"/", "/gallery"})
    public String viewGallery(Model m) {
        m.addAttribute("albums", aS.getAlbums());
        return "index";
    }

    @GetMapping("/albums/new")
    public String newAlbum(Model m) {
        if(!m.containsAttribute("albumO")){
            m.addAttribute("albumO", new AlbumE());
        }
        return "albums_form";
    }

    @GetMapping("/albums/view/{id}")
    public String viewAlbum(Model m, @PathVariable("id") int id) {
        AlbumE albumO = aS.getAlbumById(id);
        m.addAttribute("albumO", albumO);
        return "albums_view";
    }

    @GetMapping("/albums/edit/{id}")
    public String editAlbum(Model m, @PathVariable("id") int id) {
        AlbumE albumO = aS.getAlbumById(id);
        m.addAttribute("albumO", albumO);
        return "albums_form";
    }

    @GetMapping("/albums/delete/{id}")
    public String deleteAlbum(RedirectAttributes ra, @PathVariable("id") int id) {
        aS.deleteAlbum(id);
        ra.addFlashAttribute("mOk", "Album deleted successfully");
        return "redirect:/gallery";
    }
    
    @PostMapping("/albums/save")
    public String saveAlbum(@ModelAttribute("albumO") AlbumE albumO, RedirectAttributes ra) {
        try {
            aS.saveAlbum(albumO);
            ra.addFlashAttribute("mOk", "Album saved successfully");
            return "redirect:/gallery";
        } catch (Exception e) {
            ra.addFlashAttribute("albumO", albumO);
            ra.addFlashAttribute("mNo", "Error Saving Album. Please Try Different Name!");
            return "redirect:/albums/new";
        }
    }
    

    
}
