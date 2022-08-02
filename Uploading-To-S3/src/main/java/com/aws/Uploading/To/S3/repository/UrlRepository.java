package com.aws.Uploading.To.S3.repository;

import com.aws.Uploading.To.S3.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<File, Integer> {
}
