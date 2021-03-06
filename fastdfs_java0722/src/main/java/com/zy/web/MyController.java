package com.zy.web;

import com.zy.util.FastdfsUtils;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 生活很好，记得微笑🙂
 */
@Controller
public class MyController {



    @RequestMapping("/upload.json")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile){
        try {
            String name = multipartFile.getOriginalFilename();
            String s = name.substring(name.lastIndexOf(".")+1);
            byte[] bytes = multipartFile.getBytes();

            FastdfsUtils fastdfsUtils=new FastdfsUtils();
            fastdfsUtils.upload(bytes,s);

            StringBuilder builder=new StringBuilder("http://192.168.10.88:82/");
            if (builder!=null){
                for (int i = 0; i < bytes.length; i++) {
                    builder.append(bytes[i]);
                    if (i==0){
                        builder.append("/");
                    }
                }
            }

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(" /fileupload.json")
    @ResponseBody
    public Map<String,Object> fileupload(@RequestParam("file") MultipartFile multipartFile){
        Map<String,Object> map=new HashMap<>();


        try {
            String name = multipartFile.getOriginalFilename();
            String s = name.substring(name.lastIndexOf("."));
            byte[] bytes = multipartFile.getBytes();

            FastdfsUtils fastdfsUtils=new FastdfsUtils();
            fastdfsUtils.upload(bytes,s);

            StringBuilder builder=new StringBuilder("http://192.168.10.88:82/");
            if (builder!=null){
                for (int i = 0; i < bytes.length; i++) {
                    builder.append(bytes[i]);
                    if (i==0){
                        builder.append("/");
                    }
                }
            }
            String url  =   builder.toString();
            map.put("status",200);
            map.put("msg","success");
            map.put("url",url);
            return  map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status",500);
        map.put("msg","fail");

        return  map;

    }



}
