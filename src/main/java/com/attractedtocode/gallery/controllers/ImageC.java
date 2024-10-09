package com.attractedtocode.gallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.attractedtocode.gallery.services.ImageS;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.attractedtocode.gallery.models.ImageE;



@Controller
public class ImageC {
    @Autowired
    private ImageS iS;
    @Autowired
    private AlbumS aS;

    @GetMapping("/albums/images/{id}")
    public String getAlbumImages(Model m, @PathVariable("id") int id) {
        m.addAttribute("images", iS.getImagesByAlbum(id));
        return "albums_view";
        
    }

    @GetMapping("/albums/images/newest/{id}")
    public String getNewestAlbumImages(Model m, @PathVariable("id") int id) {
        m.addAttribute("images", iS.getNewestImagesByAlbum(id));
        return "albums_view";
        
    }

    @GetMapping("/albums/images/view/{id}")
    public String viewImage(Model m, @PathVariable("id") int id) {
        m.addAttribute("imageO", iS.getImageById(id));
        return "images_view";
    }

    @PostMapping("/images/save")
    public String saveImage(@ModelAttribute("imageO") ImageE imageO, RedirectAttributes ra, MultipartFile[] files) {
        ImageE toSave = imageO;

        //Start Ascync task to upload images;
        try {
            iS.saveImage(toSave);
            ra.addFlashAttribute("mOk", "Image has been added to Gallery!");
            return "redirect:/albums/images/" + toSave.getAlbum().getId();
        } catch (Exception e) {
            ra.addFlashAttribute("mNo", "Error Saving Image to gallery: " + e.getMessage());
            ra.addFlashAttribute("imageO", toSave);
            return "redirect:/albums/images/new";
        }
    }

    @GetMapping("/albums/images/new")
    public String newImage(Model m) {
        m.addAttribute("imageO", new ImageE());
        m.addAttribute("albums", aS.getAlbums());
        return "images_form";
    }
    
    @GetMapping("/images/delete/{aid}/{iid}")
    public String deleteImage(@PathVariable("aid") int id, @Pathvariable("iid") int id, RedirectAttributes ra) {
        iS.delete(id);
        ra.addAttribute("mOk", "Image has been deleted!");
        return "redirect:/albums/images/" + aid;
    }
    
    
}
