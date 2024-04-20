package cn.hutool.core.net;

import cn.hutool.core.util.StrUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络相关工具
 *
 * @author qi.wei
 */
public class NetExtUtil extends NetUtil{

	private static String localIp;

	public NetExtUtil() {}

	/**
	 * 获取本地IP地址
	 * com.alibaba.nacos.client.naming.local.ip
	 * @param key
	 * @return
	 */
	/**
	 * 根据ip地址计算出long型的数据
	 *
	 * @param key IP V4 地址
	 * @return IP地址字符串
	 * @see NetExtUtil#getLocalIPByKey(String)
	 */
	public static String getLocalIPByKey(String key) {
		try {
			if (StrUtil.isNotBlank(localIp)) {
				return localIp;
			} else {
				String ip = System.getProperty(key, InetAddress.getLocalHost().getHostAddress());
				localIp = ip;
				return ip;
			}
		} catch (UnknownHostException var1) {
			return "Unknown";
		}
	}

}
