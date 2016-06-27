package com.theironyard.controllers;

import com.theironyard.entities.AnonFile;
import com.theironyard.services.AnonFileRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Ben on 6/27/16.
 */
@Controller
public class AnonFileController {

    @Autowired
    AnonFileRepository files;

    @PostConstruct
    public void init() throws SQLException {
        Server.createWebServer().start();
    }

    @RequestMapping(path="/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, String comment, Boolean permFile) throws IOException {
        File dir = new File("public/files");
        dir.mkdirs();

        File uploadedFile = File.createTempFile("file", file.getOriginalFilename(), dir);
        FileOutputStream fos = new FileOutputStream(uploadedFile);
        fos.write(file.getBytes());

        AnonFile anonFile = new AnonFile(file.getOriginalFilename(), uploadedFile.getName(), comment, permFile);
        if (comment == null) {
            anonFile.setComment(file.getOriginalFilename());
        }
        if(permFile != null) {
            anonFile.setPermFile(true);
        } else {
            anonFile.setPermFile(false);
        }

        files.save(anonFile);
        int count = files.countByPermFileFalse();

        if (files.countByPermFileFalse() > 2) {

            AnonFile deleteAnonFile =(files.findFirstByPermFileFalseOrderByIdAsc());
            files.delete(deleteAnonFile);
            File deleteFile = new File("/public/files/" + deleteAnonFile.getRealFileName());
            deleteFile.delete();
        }
        return "redirect:/";

    }
}
