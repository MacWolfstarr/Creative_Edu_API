package com.example.edu_institute.Controller;

import com.example.edu_institute.Entity.ForGetSlipName;
import com.example.edu_institute.Entity.ForGetUpdateData;
import com.example.edu_institute.ImageUpload.FileStorageService;

import com.example.edu_institute.Repository.GetStudentSlip;
import com.example.edu_institute.Repository.SlipUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    GetStudentSlip getStudentSlip;

    @Autowired
    SlipUpdate Slip;


    @PostMapping("/uploadFile")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String StudentId, @RequestParam String UniqueClassId) {

        String Status = "Error";
        try {


            String fileName = fileStorageService.storeFile(file);
//            System.out.println(fileName);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            Status = "success";
            String random = RandomName();
            try {
                String checkName = "1";
                try {
                    while (checkName.equals("1")) {

                        ForGetSlipName getStudent = getStudentSlip.getpic(random);
                        System.out.println(getStudent.getSlip_name());

                        if (!random.equals(getStudent.getSlip_name())) {
                            checkName = "2";
                        } else {
                            random = RandomName();
                        }

                    }
                } catch (Exception e) {

                }
//                System.out.println(random + "aa");

                Path source = Paths.get("/opt/tomcat/apache-tomcat-9.0.53/webapps/uploads/" + fileName);

                // rename a file in the same directory
                Files.move(source, source.resolveSibling(random + ".jpg"));
//                ResultSet employee= databaseHandller.query();
//                databaseHandller.update("UPDATE class_has_student SET slip_name = '"+random + ".jpg"+"'  WHERE Id="+id+";");
                try {
                    System.out.println(StudentId + UniqueClassId);
//random + ".jpg",
                    ForGetUpdateData data = Slip.getid(StudentId, UniqueClassId);
                    System.out.println(data.getId());

                    if (data.getId().toString() != "") {
                        ForGetUpdateData Update = new ForGetUpdateData();
                        Update.setId(data.getId());
                        Update.setSlip_name(random + ".jpg");
                        Update.setUniqueClassId(UniqueClassId);
                        Update.setStudentId(StudentId);
                        Slip.save(Update);
//
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
//                getpic
            } catch (IOException e) {
                System.out.println(e);
//                e.printStackTrace();
            }
            return Status;
        } catch (Exception e) {
            Status = "Error";
        }


//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());

//        return "UploadFileResponse(fileName, fileDownloadUri,file.getContentType(), file.getSize())";

        return Status;
    }


    //            Machan methanin thamai random name ekak generate karanne
    String RandomName() {

        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();

    }
//         End


//    Files godak yawanawa nam meka use karanna


//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }

    //    file ekak ganna one nam meka call karanna /Untitled.png
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}