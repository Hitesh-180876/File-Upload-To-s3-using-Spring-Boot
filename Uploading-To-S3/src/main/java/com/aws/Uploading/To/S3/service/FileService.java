package com.aws.Uploading.To.S3.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String files(MultipartFile file);
}
