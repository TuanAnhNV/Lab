package com.tean.lab.Lab.controller;

import com.tean.lab.Lab.config.GoogleDriveConfig;
import com.tean.lab.Lab.service.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/google-drive")
public class GoogleDriveController {

    @Autowired
    private GoogleDriveConfig googleDriveService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("folderId") String folderId) throws IOException {
        // Chuyển đổi MultipartFile thành File
        File convFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        }

        return googleDriveService.uploadFile(file, folderId);
    }

    @GetMapping("/folder")
    public String getFolderIdByName() throws IOException, GeneralSecurityException {
        return googleDriveService.getfiles();
    }
}
