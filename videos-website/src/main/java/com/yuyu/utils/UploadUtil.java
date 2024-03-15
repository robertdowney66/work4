package com.yuyu.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;

@Slf4j
/**
 * 上传文件或者视频的工具类
 */
public class UploadUtil {
    /**
     * 该字段为域名
     */
    public static final String ALI_DOMAIN = "https://robertdowney.oss-cn-fuzhou.aliyuncs.com/";

    public static String uploadImage(MultipartFile file) throws IOException {
        // 获取文件原始名
        String originalFilename = file.getOriginalFilename();
        String ext = "." + FilenameUtils.getExtension(originalFilename);
        // 定义一个文件唯一标识码（UUID）
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileName = uuid + ext;

        // 地域节点
        String endpoint = "http://oss-cn-fuzhou.aliyuncs.com";
        String accessKeyId = "****";
        String accessKeySecret = "****";
        // OSS客户端对象
        OSS ossclient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        ossclient.putObject(
                //仓库名
                "robertdowney",
                //文件名
                fileName,
                file.getInputStream()
        );
        ossclient.shutdown();
        return ALI_DOMAIN + fileName;
    }

}
