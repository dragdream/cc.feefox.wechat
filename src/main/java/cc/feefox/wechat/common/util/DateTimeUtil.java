/**
  * @ClassName: DateTimeUtil 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 下午4:09:39
  * 
  */
package cc.feefox.wechat.common.util;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @Package: cc.feefox.wechat.common.util 
 * @author: cc   
 * @date: 2018年8月18日 下午4:09:39 
 */
public class DateTimeUtil {

	public static final String YMDHMS_DATEFORMA = "yyyy-MM-dd HH:mm:ss";

	/**
	 * DateTimeUtil.java
	 * @return
	 */
	public static long currentTime() {
		return System.currentTimeMillis();
	}

	/**
	 * 格式化日期
	 * @param time
	 * @param format
	 * @return
	 */
	public static String formatDate(long time, String format) {
		return FastDateFormat.getInstance(format).format(new Date(time));
	}
}
