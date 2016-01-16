package com.hongbao.dragonutil;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

public class DragonCommonMethod {

	public static String getRemoteAddr(HttpServletRequest request){
		  String ip = request.getHeader("x-forwarded-for");  
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getHeader("Proxy-Client-IP");  
		    }  
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getHeader("WL-Proxy-Client-IP");  
		    }  
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getRemoteAddr();  
		    }  
		    return ip;
	}
	
	public static Date getZeroDateTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(1970, 0, 1, 0, 0, 0);
		return calendar.getTime();
	}
	
	public static boolean isEmptyString(String str){
		if(str == null || str.equals("")){
			return true;
		}
		return false;
	}
	public static boolean isNumeric(String str){
		if(str.isEmpty()){
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNumMatcher = pattern.matcher(str);
		if(isNumMatcher.matches()){
			return true;
		}else{
			return false;
		}
	}
	
	public static String generateGuid(){
		UUID guidUuid = UUID.randomUUID();
		String guidString = guidUuid.toString().replace("-", "");
		return guidString;
	}
	
	
	public static String getImageFormat(Object o){
		  try {
	            ImageInputStream iis = ImageIO.createImageInputStream(o);
	            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
	            if (!iter.hasNext()) {
	                return null;
	            }
	    
	            ImageReader reader = iter.next();
	            iis.close();
	            return reader.getFormatName();
	        } catch (IOException e) {
	        }
	        return null;
	}
	
	public static void cutImage(int w, int h,int srcX,int srcY,String originFilePath,String resultFilePath,String contentType) throws IOException {
		
		 // 读取图片文件  
		FileInputStream is = new FileInputStream(originFilePath);  

        Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(contentType);  

        ImageReader reader = it.next();  

        // 获取图片流  
        ImageInputStream iis = ImageIO.createImageInputStream(is);  

        reader.setInput(iis, true);  

        ImageReadParam param = reader.getDefaultReadParam();  

        Rectangle rect = new Rectangle(srcX, srcY, w, h);  

        // 提供一个 BufferedImage，将其用作解码像素数据的目标。  
        param.setSourceRegion(rect);  

        BufferedImage bi = reader.read(0, param);  

        // 保存新图片  
        ImageIO.write(bi, contentType, new File(resultFilePath));  
        
		is.close();
		iis.close();

	 }
	
	 public static void resize(int w, int h,String originFilePath,String resultFilePath,String contentType) throws IOException {
		 BufferedImage image = null;
		 if(contentType.equals("png")){
			 image = new BufferedImage(w, h,BufferedImage.TYPE_INT_ARGB );
		 }else{
			 image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );
		 }
	     File file = new File(originFilePath);// 读入文件  
	     BufferedImage img = ImageIO.read(file);
	    
	     
	     image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图  
	     File destFile = new File(resultFilePath);  
	     if(contentType.equals("jpg") || contentType.equals("jpeg")){
		       FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流  
		        // 可以正常实现bmp、png、gif转jpg  
		        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(img);
		        param.setQuality(0.95f, false);
		        encoder.encode(image); // JPEG编码  

		        out.close();  
	     }else{
		        ImageIO.write(image, contentType, destFile);
		       
	     }

	    }
	 
	 public static void copyFile(String oldPath,String newPath) throws IOException{
		 InputStream inputStream = new FileInputStream(oldPath);
		 FileOutputStream outputStream = new FileOutputStream(newPath);
		 byte[] buffer = new byte[1024 * 5];
		 int byteRead = 0;
		 while((byteRead = inputStream.read(buffer) )!= -1){
			 outputStream.write(buffer,0,byteRead);
		 }
		 inputStream.close();
		 outputStream.close();
	 }
}
