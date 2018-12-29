/**
  * @ClassName: CustomServiceImpl 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月23日 下午6:10:13
  * 
  */
package cc.feefox.wechat.customer.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cc.feefox.wechat.common.constant.MessagegConstant;
import cc.feefox.wechat.common.constant.WechatConstant;
import cc.feefox.wechat.common.json.JsonConfig;
import cc.feefox.wechat.common.util.HttpUtil;
import cc.feefox.wechat.common.util.StringUtils;
import cc.feefox.wechat.customer.CustomerBaseMessage;
import cc.feefox.wechat.customer.MediaMessage;
import cc.feefox.wechat.customer.MusicMessage;
import cc.feefox.wechat.customer.NewsMessage;
import cc.feefox.wechat.customer.TextMessage;
import cc.feefox.wechat.customer.VideoMessage;
import cc.feefox.wechat.customer.service.interfaces.CustomService;
import net.sf.json.JSONObject;

/**
 * @Package: cc.feefox.wechat.customer.service.impl 
 * @author: cc   
 * @date: 2018年8月23日 下午6:10:13 
 */
@Service
public class CustomServiceImpl implements CustomService {
	
	
	public static Logger log = Logger.getLogger(CustomService.class);

	// 客服消息接口
	private static String CUSTOME_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	public static Map<String, CustomerBaseMessage> bulidMessageMap = new HashMap<String, CustomerBaseMessage>();

	static {
		bulidMessageMap.put(MessagegConstant.RESP_MESSAGE_TYPE_TEXT, new TextMessage());
		bulidMessageMap.put(MessagegConstant.RESP_MESSAGE_TYPE_NEWS, new NewsMessage());
		bulidMessageMap.put(MessagegConstant.RESP_MESSAGE_TYPE_IMAGE, new MediaMessage());
		bulidMessageMap.put(MessagegConstant.RESP_MESSAGE_TYPE_VOICE, new MediaMessage());
		bulidMessageMap.put(MessagegConstant.RESP_MESSAGE_TYPE_VIDEO, new VideoMessage());
		bulidMessageMap.put(MessagegConstant.RESP_MESSAGE_TYPE_MUSIC, new MusicMessage());
	}


	/* 关注回复消息
	 * @param params
	 * @return
	 */
	@Override
	public String handlerCustomerMessage_subscribe(Map<String, String> params) {
		
		String text = JsonConfig.getJsonResource("datas/subscribe").toString();
		JSONObject json = JSONObject.fromObject(text);
		json.put("touser", params.get("FromUserName"));
		sendCustomerMessage(json);
		return null;
	}

	/* 小程序卡片
	 * @param params
	 * @return
	 */
	@Override
	public String handlerCustomerMessage_miniprogrampage(Map<String, String> params) {
		
		// 小程序卡片
		String strJson = JsonConfig.getJsonResource("datas/miniprogrampage").toString();
		JSONObject json = JSONObject.fromObject(strJson);
		json.put("touser", params.get("FromUserName"));
		sendCustomerMessage(json);
		return CUSTOME_URL;
	}
	
	/* 处理微信发来的客服请求
	 * @param json
	 */
	@Override
	public void handleKefuMessage(JSONObject json) {
		sendCustomerMessage(json);
	}
	
	/*;
	 * 发送客服消息
	 * 
	 * @param obj 消息对象
	 * @return 是否发送成功
	 */
	public static boolean sendCustomerMessage(Object obj) {

		boolean bo = false;
		String url = CUSTOME_URL.replace("ACCESS_TOKEN", WechatConstant.ACCESS_TOKEN);
		JSONObject json = JSONObject.fromObject(obj);
		System.out.println(json);
		JSONObject jsonObject = HttpUtil.httpsRequest(url, "POST", json.toString());
		if (null != jsonObject) {
			if (StringUtils.isNotNull(jsonObject.getString("errcode")) && jsonObject.getString("errcode").equals("0")) {
				bo = true;
			}
		}
		return bo;
	}

}
