package com.edu.basic;

import com.edu.basic.service.FileStorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootTest(classes = BasicApplication.class)
@RunWith(SpringRunner.class)
public class BasicApplicationTest {

    @Autowired
    private FileStorageService fileStorageService;

    @Test
    public void testUploadImage() throws Exception {
        // 本地图片文件路径
        String filePath = "E:/WORKS/java/projects/ChargingStationManage/basic/src/main/resources/u668.jpg";
        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException("File not found: " + filePath);
        }

        // 读取文件
        InputStream inputStream = new FileInputStream(file);

        String fileName = file.getName();
        System.out.println("Uploading file: " + fileName);

        // 上传文件
        String uploadedFilePath = fileStorageService.uploadImgFile("test", fileName, inputStream);

        // 验证文件上传
        System.out.println("Uploaded file path: " + uploadedFilePath);
    }
}
