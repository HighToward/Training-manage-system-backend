package com.company.training.controller;

// import com.company.training.common.Result; // <-- Remove this incorrect import
import com.company.training.entity.vo.Result; // <-- Add the correct import
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    // 从配置文件读取文件上传目录
    @Value("${file.upload-dir:uploads}") // 默认值为 uploads
    private String uploadDir;

    @PostMapping("/video")
    public Result<String> uploadVideo(@RequestParam("file") MultipartFile file) {
        logger.info("接收到视频上传请求，原始文件名: {}, 大小: {} bytes", file.getOriginalFilename(), file.getSize());
        logger.info("配置文件中 uploadDir: {}", uploadDir);

        if (file.isEmpty()) {
            logger.warn("上传失败: 文件为空。");
            return Result.error("上传文件不能为空");
        }

        try {
            File uploadPath = new File(uploadDir);
            logger.info("尝试使用的上传目录绝对路径: {}", uploadPath.getAbsolutePath());

            if (!uploadPath.exists()) {
                logger.info("上传目录不存在，尝试创建: {}", uploadPath.getAbsolutePath());
                if (uploadPath.mkdirs()) {
                    logger.info("目录创建成功: {}", uploadPath.getAbsolutePath());
                } else {
                    logger.error("创建上传目录失败: {}. 请检查路径和权限。", uploadPath.getAbsolutePath());
                    return Result.error("服务器错误: 无法创建上传目录。");
                }
            } else {
                logger.info("上传目录已存在: {}", uploadPath.getAbsolutePath());
            }

            logger.info("目录是否是文件夹: {}", uploadPath.isDirectory());
            logger.info("目录是否可读: {}", uploadPath.canRead());
            logger.info("目录是否可写: {}", uploadPath.canWrite());

            if (!uploadPath.isDirectory() || !uploadPath.canWrite()) {
                logger.error("上传目录无效或不可写: {}", uploadPath.getAbsolutePath());
                return Result.error("服务器配置错误: 上传目录无效或不可写。");
            }

            String originalFilename = file.getOriginalFilename();
            String fileExtension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
            File dest = new File(uploadPath, uniqueFileName);

            logger.info("准备将文件保存到: {}", dest.getAbsolutePath());
            file.transferTo(dest); // 核心保存操作

            if (dest.exists() && dest.length() > 0) {
                logger.info("文件成功保存到: {}, 大小: {} bytes", dest.getAbsolutePath(), dest.length());
                String fileUrl = "/uploads/" + uniqueFileName; // URL路径与WebConfig中的映射对应
                logger.info("返回给前端的文件URL: {}", fileUrl);
                return Result.success(fileUrl);
            } else {
                logger.error("调用 transferTo 后，文件不存在或大小为0: {}", dest.getAbsolutePath());
                return Result.error("文件保存操作失败，请检查服务器日志。");
            }

        } catch (IOException e) {
            logger.error("文件上传时发生IO异常: {}", e.getMessage(), e);
            return Result.error("文件上传失败: " + e.getMessage());
        } catch (Exception e) {
            logger.error("处理上传请求时发生未知错误: {}", e.getMessage(), e);
            return Result.error("服务器内部错误，请稍后重试。");
        }
    }

    // 可以添加其他文件类型的上传方法
    // @PostMapping("/image")
    // public Result<String> uploadImage(@RequestParam("file") MultipartFile file) { ... }
}