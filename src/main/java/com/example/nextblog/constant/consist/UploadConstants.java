package com.example.nextblog.constant.consist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 图片上传路径常量
 * @date: 2019/8/24 15:16
 */
@Component
public class UploadConstants {
    // 用户头像数据库路径
    public static String UPLOAD_AUTHOR_IMG = "/upload/author_img/";
    // 文章图片数据库路径
    public static String FILE_UPLOAD_DIC = "/upload/article/";


    @Value("${upload.uploadAuthorImg}")
    public void setUploadAuthorImg(String uploadAuthorImg) {
        UploadConstants.UPLOAD_AUTHOR_IMG = uploadAuthorImg;
    }

    @Value("${upload.fileUploadDic}")
    public void setFileUploadDic(String fileUploadDic) {
        UploadConstants.FILE_UPLOAD_DIC = fileUploadDic;
    }
}
