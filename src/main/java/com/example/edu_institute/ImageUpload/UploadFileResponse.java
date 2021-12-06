package com.example.edu_institute.ImageUpload;

public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileName;
        this.fileType = fileType;
        this.size = size;

        System.out.println(fileName+fileName+fileType+size);

    }

    // Getters and Setters (Omitted for brevity)
}