/**
  * @ClassName: WechatMsgServiceImpl 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 下午3:19:48
  * 
  */
package cc.feefox.wechat.message.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.feefox.wechat.common.json.JsonConfig;
import cc.feefox.wechat.common.result.WeChatResult;
import cc.feefox.wechat.common.util.DateTimeUtil;
import cc.feefox.wechat.customer.service.interfaces.CustomService;
import cc.feefox.wechat.main.WeChatController;
import cc.feefox.wechat.message.model.BaseMessage;
import cc.feefox.wechat.message.model.TextMessage;
import cc.feefox.wechat.message.service.interfaces.WechatMsgService;
import net.sf.json.JSONObject;

/**
 * @Package: cc.feefox.wechat.message.service.impl
 * @author: cc
 * @date: 2018年8月18日 下午3:19:48
 */
@Service
public class WechatMsgServiceImpl implements WechatMsgService {

	@Autowired
	private CustomService customService;

	private static final Logger logger = LoggerFactory.getLogger(WeChatController.class);

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult textMsgInfo(Map<String, String> params, BaseMessage msgInfo) {

//		ou0pTwM2io_lD0ihQOywTSFSqwTU   // 客服微信

		System.err.println(msgInfo.getFromUserName());
		String content = params.get("Content").trim();
		if ("人工".equals(content) || "人工客服".equals(content) || "客服".equals(content)) {
			logger.info("接入人工客服");
			WeChatResult result = new WeChatResult();
			TextMessage text = new TextMessage();
			text.setFromUserName(msgInfo.getFromUserName());
//			text.setMsgType("transfer_customer_service");
			result.setObject(text);
			result.setType(3);
			return result;
		} else {
			// 自动回复功能
			logger.info("文本消息");
			WeChatResult result = new WeChatResult();
			TextMessage text = new TextMessage();
			text.setContent(params.get("Content").trim());// 自动回复
			text.setCreateTime(DateTimeUtil.currentTime());
			text.setToUserName(msgInfo.getFromUserName());
			text.setFromUserName(msgInfo.getToUserName());
			text.setMsgId(msgInfo.getMsgId());
			text.setMsgType("text");
			result.setObject(text);
			System.err.println(msgInfo.getFromUserName());
			System.err.println(result.toString());
			return result;
		}

	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult imageMsgInfo(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult linkMsgInfo(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult locationMsgInfo(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult voiceMsgInfo(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult shortVideo(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult videoMsgInfo(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult subscribe(Map<String, String> params, BaseMessage msgInfo) {

		logger.info("开始调用关注回复服务");
		// 关注回复，使用客服接口
		customService.handlerCustomerMessage_subscribe(params);
		// 发送小程序卡片
		customService.handlerCustomerMessage_miniprogrampage(params);
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult unsubscribe(Map<String, String> params, BaseMessage msgInfo) {

		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult scan(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult eventLocation(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult eventClick(Map<String, String> params, BaseMessage msgInfo) {

		logger.info("CLICK_RGKF事件");
		if (params.get("EventKey").equals("CLICK_BUG")) {
			String text = JsonConfig.getJsonResource("datas/BUG").toString();

			JSONObject json = JSONObject.fromObject(text);
			json.put("touser", params.get("FromUserName"));
			customService.handleKefuMessage(json);
		}
		if (params.get("EventKey").equals("CLICK_RGKF")) {
			String text = JsonConfig.getJsonResource("datas/rgkf").toString();

			JSONObject json = JSONObject.fromObject(text);
			json.put("touser", params.get("FromUserName"));
			customService.handleKefuMessage(json);

//			String rgkfzf = JsonConfig.getJsonResource("datas/rgkfzf").toString();
//			JSONObject json02 = JSONObject.fromObject(rgkfzf);
//			json.put("touser", params.get("FromUserName"));
//			json.put("touser", params.get("FromUserName"));

		}
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult eventView(Map<String, String> params, BaseMessage msgInfo) {

		logger.info("view事件，人工客服");

//		String content = "欢迎关注我的微信公众号";
//		WeChatResult result = new WeChatResult();
//		String text = JsonConfig.getJsonResource("datas/rgkf").toString();

//		TextMessage text = new TextMessage();
//		text.setContent(content);// 自动回复
//		text.setCreateTime(DateTimeUtil.currentTime());
//		text.setToUserName(msgInfo.getFromUserName());
//		text.setFromUserName(msgInfo.getToUserName());
//		text.setMsgId(msgInfo.getMsgId());
//		text.setMsgType("text");
//		result.setObject(text);
		return null;

	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult kfCreateSession(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult kfCloseSession(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 * 
	 * @return
	 */
	@Override
	public WeChatResult kfSwitchSession(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 */
	@Override
	public void eventDefaultReply(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub

	}

	/*
	 * TODO
	 * 
	 * @param params
	 * 
	 * @param msgInfo
	 */
	@Override
	public void defaultMsgInfo(Map<String, String> params, BaseMessage msgInfo) {
		// TODO Auto-generated method stub

	}

}
