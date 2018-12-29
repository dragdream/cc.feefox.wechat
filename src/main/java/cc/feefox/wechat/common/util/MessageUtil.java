/**
  * @ClassName: MessageUtil 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 下午5:43:36
  * 
  */
package cc.feefox.wechat.common.util;

import com.thoughtworks.xstream.XStream;

import cc.feefox.wechat.common.util.XmlUtil.XStreamFactroy;
import cc.feefox.wechat.message.model.Article;
import cc.feefox.wechat.message.model.BaseMessage;
import cc.feefox.wechat.message.model.ImageMessage;
import cc.feefox.wechat.message.model.NewsMessage;
import cc.feefox.wechat.message.model.TextMessage;

/**
 * @Package: cc.feefox.wechat.common.util 
 * @author: cc   
 * @date: 2018年8月18日 下午5:43:36 
 */
public class MessageUtil {

	
	/**
	 * 将java对象转换为xml
	 * 
	 * @param msg
	 * @return
	 */
	public static String baseMessageToXml(BaseMessage msg) {
		String result = "";
		if (msg != null) {
			XStream xs = XStreamFactroy.init(true);
			xs.alias("xml", msg.getClass());
			result = xs.toXML(msg);
		}
		return result;
	}

	/**
	 * 文本消息
	 * 
	 * @param text
	 * @return
	 */
	public static String textMessageToXml(TextMessage text) {
		String result = "";
		if (text != null) {
			XStream xs = XStreamFactroy.init(true);
			xs.alias("xml", TextMessage.class);
			result = xs.toXML(text);
		}
		return result;
	}

	/**
	 * 图片消息
	 * 
	 * @param image
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage image) {
		String result = "";
		if (image != null) {
			XStream xs = XStreamFactroy.init(true);
			xs.alias("xml", ImageMessage.class);
			result = xs.toXML(image);
		}
		return result;
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * MessageUtil.java
	 * @param message
	 * @return
	 */
	public static String newsMessagegToXml(NewsMessage message) {
		String result = "";
		if (message != null) {
			XStream xs = XStreamFactroy.init(true);
			xs.alias("xml", NewsMessage.class);
			xs.alias("item", new Article().getClass());
			result = xs.toXML(message);
		}
		return result;
	}
	
}
