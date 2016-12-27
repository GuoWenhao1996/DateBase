package com.gwh.PersonalMoneyMS.Util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class JiaMi {
	/*
	 * 自行编写MD5加密，使数据库中的用户密码不可直接看到，增强安全性 输入str：获取要加密的字符串 输出s：加密好的字符串
	 */
	public static String getMD5(String str) {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md5.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			String s = new BigInteger(1, md5.digest()).toString(16);
			return s;
		} catch (Exception e) {
			System.out.println("MD5加密出现错误\n"+e.toString());
			return "";
		}
	}
}
