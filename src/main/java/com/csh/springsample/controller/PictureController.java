package com.csh.springsample.controller;

import com.csh.springsample.domain.Picture;
import com.csh.springsample.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class PictureController {
    private final PictureService pictureService;

    @PostMapping("upload")
    public String uploadPicture(@RequestParam("file") MultipartFile file){
        return pictureService.uploadPicture(file);
    }

    @GetMapping("find")
    public List<Picture> findPicture(){
        return pictureService.findPicture();
    }
}