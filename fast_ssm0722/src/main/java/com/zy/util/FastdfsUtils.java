package com.zy.util;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * 生活很好，记得微笑🙂
 */

public class FastdfsUtils {
    //声明
    TrackerClient trackerClient=null;
    TrackerServer trackerServer=null;
    StorageClient storageClient=null;
    StorageServer storageServer=null;

    public FastdfsUtils(){
        try {
            //加载配置
            ClientGlobal.init("client.conf");
            System.out.println(ClientGlobal.configInfo());
            //创建
            trackerClient =new TrackerClient();
            //得到server
            trackerServer  = trackerClient.getConnection();
            //storage
            storageClient=new StorageClient(trackerServer,storageServer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }


    public String[] upload(String localname,String ext){

        try {
            return storageClient.upload_appender_file(localname,ext,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String[] upload(byte[] bytes,String ext){

        try {
            return storageClient.upload_file(bytes,ext,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }


}
