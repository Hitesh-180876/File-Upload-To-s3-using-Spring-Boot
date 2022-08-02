package com.aws.Uploading.To.S3.controller;

import com.aws.Uploading.To.S3.entity.File;
import com.aws.Uploading.To.S3.repository.UrlRepository;
import com.aws.Uploading.To.S3.service.AwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;

@RestController
public class Controller {





    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private AwsS3Service awsS3Service;
    @PostMapping("/file")

//    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file){
//        String publicUrl = awsS3Service.uploadFile(file);
//        Map<String, String> response = new HashMap<>();
//
//        response.put("publicUrl:", publicUrl);
//        return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
//
//

        public ResponseEntity<String> files(@RequestParam("file") MultipartFile file,
                                                    @RequestParam("fileType") String fileType,
                                                        @RequestParam("project") String projectName){
            File fileObj = new File();
            String url  = awsS3Service.files(file);
            HttpStatus status = HttpStatus.CREATED;
            fileObj.setFiletype(fileType);
            fileObj.setProject(projectName);
            fileObj.setUrl(url);
            urlRepository.save(fileObj);


//          HashMap<String, String> header = new HashMap<>();
            MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
            header.put("server", Collections.singletonList("My Server"));

            ResponseEntity<String> response = new ResponseEntity<>(url, header, status);



            return response;

//        ResponseEntity<Map<String, String>> response = new ResponseEntity<>()

    }
}
