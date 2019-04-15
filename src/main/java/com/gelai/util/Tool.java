package com.gelai.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Tool {
	/**
	 * 使用md5的算法进行加密
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	
	/**
	 * 处理文件名
	 */
	public static String dateFileName(String fileName) {
		int idx = fileName.lastIndexOf(".");
		String name = fileName.substring(idx);
		String str = UUID.randomUUID().toString().replace("-", "")+name;
		return new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date())+fileName;
	}
	
	/**
	 * 目录分离
	 */
	public static String getPath(String uuidFileName) {
		//得到文件名的hashCode的值，得到的就是uuidFileName这个字符串对象在内存中的地址
		int code1 = uuidFileName.hashCode();
		//得到名为1到16的下及文件夹
		int d1 = code1 & 0xf; //一级目录
		//得到名为1到16的下下及文件夹
		int code2 = code1 >>> 4;
		int d2 = code2 & 0xf;//二级目录
		
		return "/"+d1+"/"+d2;
	}
}
