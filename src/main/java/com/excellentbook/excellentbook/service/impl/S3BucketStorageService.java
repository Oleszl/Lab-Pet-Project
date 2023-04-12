package com.excellentbook.excellentbook.service.impl;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class S3BucketStorageService {
    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    public void uploadFile(String path, MultipartFile file) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/png");
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucketName, path, file.getInputStream(), metadata);
        } catch (IOException ioe) {
            log.error("IOException: {}", ioe.getMessage());
        } catch (AmazonServiceException serviceException) {
            log.info("AmazonServiceException: {}", serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            log.info("AmazonClientException Message: {}", clientException.getMessage());
            throw clientException;
        }
    }

}