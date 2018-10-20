package com.aididi.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author xuzexiang
 * @Date: 2018-9-12 0012
 * @Description:
 */
@Controller
@RequestMapping(value = "/upload")
@Log4j2
public class UploadController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("file") MultipartFile file) throws Exception {
        log.info("文件类型"+file.getContentType());
        log.info("文件名称"+file.getOriginalFilename());
        log.info("文件大小"+file.getSize());
        // TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        UUID uuid = UUID.randomUUID();
        String fileName = file.getOriginalFilename();
        String suffix = null;
        if(fileName.indexOf(".")>0) {
            int index = fileName.indexOf(".");
            suffix = fileName.substring(index);

        }
        file.transferTo(new File("F:\\files\\"+uuid+suffix));
        Map<String,Object> result = new HashMap<>(16);
        result.put("contentType",file.getContentType());
        result.put("fileName",file.getOriginalFilename());
        result.put("fileSize",file.getSize());
        return result;
    }

    @PostMapping("/upload2")
    @ResponseBody
    public List<Map<String,Object>> upload2(@RequestParam("file") MultipartFile [] files) throws IOException {
        if(files==null || files.length==0){
            return null;
        }
        List<Map<String,Object>> mapList = new ArrayList<>();

        for(MultipartFile file :files){
            UUID uuid = UUID.randomUUID();
            String fileName = file.getOriginalFilename();
            String suffix = null;
            if(fileName.indexOf(".")>0) {
                int index = fileName.indexOf(".");
                suffix = fileName.substring(index);

            }
            file.transferTo(new File("F:\\files\\"+uuid+suffix));
            Map<String,Object> map = new HashMap<>(16);
            map.put("contentType",file.getContentType());
            map.put("fileName",file.getOriginalFilename());
            map.put("fileSize",file.getSize());
            mapList.add(map);
        }
        return mapList;
    }

    @PostMapping("/upload3")
    @ResponseBody
    public void upload3(String base64) throws IOException {
        // TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
        final File file = new File("F:\\files\\a.jpg");
        String []  fileNames= base64.split("base64,");
        final byte [] bytes =Base64Utils.decodeFromString(fileNames.length>1? fileNames[1]:fileNames[0]);
        FileCopyUtils.copy(bytes,file);

    }

}
