package com.hongbao.dragonutil.oss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class DragonOssClient {

	
	private OSSClient client = null;
	public DragonOssClient(String endPoint,String accessKeyId,String accessKeySecret){
		this.client = new OSSClient(endPoint,accessKeyId, accessKeySecret);
		
		
	}
	
	
	
	
	public OSSClient getClient() {
		return client;
	}




	public void setClient(OSSClient client) {
		this.client = client;
	}



	public void putObject(String bucketName,String key,String filePath,ObjectMetadata metaData) throws FileNotFoundException{
	    // 初始化OSSClient

	    // 获取指定文件的输入流
	    File file = new File(filePath);
	    InputStream content = new FileInputStream(file);

	    // 上传Object.
	    PutObjectResult result = client.putObject(bucketName, key, content, metaData);

	    // 打印ETag
	    System.out.println(result.getETag());
	}

	public void putObject(String bucketName, String key, String filePath) throws FileNotFoundException {
		
		File file = new File(filePath);
	    ObjectMetadata meta = new ObjectMetadata();
	    meta.setContentLength(file.length());
	    
	    this.putObject(bucketName, key, filePath, meta);

	}
	
	
	public void getObject(String bucketName, String key,String tmpFilePath) throws IOException {

	    // 初始化OSSClient
	    // 获取Object，返回结果为OSSObject对象
	    OSSObject object = client.getObject(bucketName, key);
	    // 获取Object的输入流
	    InputStream objectContent = object.getObjectContent();
	    // 处理Object
	    FileOutputStream fos = new FileOutputStream(tmpFilePath);
	    
	    byte[] buffer = new byte[1024*5];
	    int byteRead = 0;
	    while( (byteRead = objectContent.read(buffer) ) != -1){
	    	fos.write(buffer, 0, byteRead);
	    }
	    
	    fos.close();
	    


	    // 关闭流
	    objectContent.close();
	}
	
	
}
