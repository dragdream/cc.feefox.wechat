/**
  * @ClassName: StringUtils 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 上午11:24:02
  * 
  */
package cc.feefox.wechat.common.util;

/**
 * @Package: cc.feefox.wechat.common.util 
 * @author: cc   
 * @date: 2018年8月18日 上午11:24:02 
 */
public class StringUtils {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0)
			return true;
		for (int i = 0; i < strLen; i++)
			if (!Character.isWhitespace(str.charAt(i)))
				return false;
 
		return true;
	}
	
	/**
	 * 判断对象是否为空
	 * 方法描述 如果对象为非空返回true 否则返回false
	 * StringUtils.java
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj) {
		
		if(obj != null) {
			return true;
		}
		return false;

    }

}
