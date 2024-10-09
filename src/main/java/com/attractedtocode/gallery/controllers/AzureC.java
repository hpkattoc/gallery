package com.attractedtocode.gallery.controllers;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AzureC {
    
    public AzureC() {
    }

    public String upload(MultipartFile file){
        return "imageUrl";
    }
}
