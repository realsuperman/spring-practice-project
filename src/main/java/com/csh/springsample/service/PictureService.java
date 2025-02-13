package com.csh.springsample.service;

import com.csh.springsample.domain.Picture;
import com.csh.springsample.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PictureService {
    private final S3Service s3Service;
    private final PictureRepository pictureRepository;

    public String uploadPicture(MultipartFile file){
        String filePath = s3Service.upload(file, "images");
        pictureRepository.save(Picture.builder().path(filePath).build());
        return filePath;
    }

    public List<Picture> findPicture(){
        return pictureRepository.findAll();
    }
}