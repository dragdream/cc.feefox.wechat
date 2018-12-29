/**
  * @ClassName: CustomService 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月21日 上午10:37:34
  * 
  */
package cc.feefox.wechat.customer.service.interfaces;

import java.util.Map;

import net.sf.json.JSONObject;

/**
 * @Package: cc.feefox.wechat.customer.service.interfaces 
 * @author: cc   
 * @date: 2018年8月21日 上午10:37:34 
 */
public interface CustomService {
	
	/*
	 * 关注回复消息
	 */
	public String handlerCustomerMessage_subscribe(Map<String, String> params);
	
	/*
	 * 小程序卡片
	 */
	public String handlerCustomerMessage_miniprogrampage(Map<String, String> params);

	/**
	 * CustomService.java
	 * @param json
	 */
	public void handleKefuMessage(JSONObject json);
}
