/**
  * @ClassName: IOUtil 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月20日 下午1:10:34
  * 
  */
package cc.feefox.wechat.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import cc.feefox.wechat.common.constant.SystemConstant;

/**
 * @Package: cc.feefox.wechat.common.util 
 * @author: cc   
 * @date: 2018年8月20日 下午1:10:34 
 */
public class IOUtil {
	
	/**
	 * 将输入流转换为字符串
	 * 
	 * @param is
	 *            待转换为字符串的输入流
	 * @return 由输入流转换String的字符串
	 * @throws IOException
	 */
	public static String inputStreamToString(InputStream inputStream, String encoding) throws IOException {
		if(StringUtils.isEmpty(encoding)) {
			encoding = SystemConstant.DEFAULT_CHARACTER_ENCODING;
		}
		return IOUtils.toString(inputStream, encoding);
	}

	/**
	 * 编码
	 * 
	 * @param source
	 * @param encode
	 * @return
	 */
	public static String urlEncode(String source, String encode) {
		String result = source;
		try {
			result = URLEncoder.encode(source, encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
