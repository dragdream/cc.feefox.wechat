/**
  * @ClassName: SendMessageController 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月20日 上午11:53:37
  * 
  */
package cc.feefox.wechat.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cc.feefox.wechat.common.constant.WechatConstant;
import cc.feefox.wechat.common.result.MassMsgResult;
import cc.feefox.wechat.common.result.WeChatResult;
import cc.feefox.wechat.common.util.MessageUtil;
import cc.feefox.wechat.message.model.BaseMessage;
import cc.feefox.wechat.message.model.NewsMessage;
import cc.feefox.wechat.message.service.interfaces.MessageSendService;

/**
 * 消息推送
 * 
 * @Package: cc.feefox.wechat.main
 * @author: cc
 * @date: 2018年8月20日 上午11:53:37
 */
@RestController
@RequestMapping("/wechat")
public class MessageController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(WeChatController.class);

	@Autowired
	private MessageSendService messagesendService;

	/**
	 * 群发消息
	 * MessageController.java
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sendTextByOpenid", method = { RequestMethod.GET, RequestMethod.POST })
	public MassMsgResult sendTextByOpenid() throws Exception {

		MassMsgResult result = new MassMsgResult();
		// 获取access_token
		String access_token = WechatConstant.ACCESS_TOKEN;

		// 获取消息
		String text = "什么是幸福，幸福就是自己的一种愉快的心理状态和感受。时时、事事都能使自己快乐的人才是最幸福的人。最快乐的人，就是最幸福的人。笑口常开的人，是最幸福的";

		// 获取用户列表
		List<String> openids = new ArrayList<>();
		openids.add("oWnU70wblcEk5oxFWwluJbW8shwc");
		openids.add("oWnU700PB2HTtgzReJva2GzPmp0E");
		result = messagesendService.sendTextToOpenid(access_token, openids, text);
		logger.debug(" send by openid msg {} ", result.getErrmsg());
		return result;
	}
	
	/**
	 * 发送小程序卡片消息（图文）
	 * MessageController.java
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sendTicketByOpenid", method = { RequestMethod.GET, RequestMethod.POST })
	public String sendTicketByOpenid(Map<String, String> params) throws Exception {
		
//		String result = null;
		// 获取access_token
//		String access_token = WechatConstant.ACCESS_TOKEN;
		
//		if (params != null && params.size() > 0) {
//			BaseMessage msgInfo = new BaseMessage();
//			String createTime = params.get("CreateTime");
//			String msgId = params.get("MsgId");
//			msgInfo.setCreateTime(
//					(createTime != null && !"".equals(createTime)) ? Integer.parseInt(createTime) : 0);
//			msgInfo.setFromUserName(params.get("FromUserName"));
//			msgInfo.setMsgId((msgId != null && !"".equals(msgId)) ? Long.parseLong(msgId) : 0);
//			msgInfo.setToUserName(params.get("ToUserName"));
//			WeChatResult resp = messagesendService.sendTicketMessage(params, msgInfo);
//			NewsMessage message = (NewsMessage) resp.getObject();
//			result = MessageUtil.newsMessagegToXml(message);
//			
//		}
//		return result;
		
		logger.info("开始处理【message】信息");

		String result = null;

		if (params != null && params.size() > 0) {
			BaseMessage msgInfo = new BaseMessage();
			String createTime = params.get("CreateTime");
			String msgId = params.get("MsgId");
			msgInfo.setCreateTime((createTime != null && !"".equals(createTime)) ? Integer.parseInt(createTime) : 0);
			msgInfo.setFromUserName(params.get("FromUserName"));
			msgInfo.setMsgId((msgId != null && !"".equals(msgId)) ? Long.parseLong(msgId) : 0);
			msgInfo.setToUserName(params.get("ToUserName"));
//			WeChatResult resp = codeHandleService.handleCode(params, msgInfo);
			WeChatResult resp = messagesendService.sendTicketMessage(params, msgInfo);
			NewsMessage message = (NewsMessage) resp.getObject();
			result = MessageUtil.newsMessagegToXml(message);	
		}
		return result;
	}
	
}
