/**
  * @ClassName: MessageSendServiceImpl 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月20日 下午12:20:53
  * 
  */
package cc.feefox.wechat.message.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cc.feefox.wechat.common.constant.SystemConstant;
import cc.feefox.wechat.common.constant.WechatConstant;
import cc.feefox.wechat.common.result.MassMsgResult;
import cc.feefox.wechat.common.result.WeChatResult;
import cc.feefox.wechat.common.util.DateTimeUtil;
import cc.feefox.wechat.common.util.HttpUtil;
import cc.feefox.wechat.common.util.JsonUtil;
import cc.feefox.wechat.message.model.Article;
import cc.feefox.wechat.message.model.BaseMessage;
import cc.feefox.wechat.message.model.NewsMessage;
import cc.feefox.wechat.message.service.interfaces.MessageSendService;

/**
 * @Package: cc.feefox.wechat.message.service.impl 
 * @author: cc   
 * @date: 2018年8月20日 下午12:20:53 
 */
@Service
public class MessageSendServiceImpl implements MessageSendService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	

	/* TODO
	 * @param string
	 * @param openids
	 * @param string2
	 */
	@Override
	public MassMsgResult sendTextToOpenid(String access_token, List<String> openids, String text) {
	
		MassMsgResult result = null;

		TreeMap<String, String> params = new TreeMap<>();
		params.put("access_token", access_token);
		// post 提交的参数
		Map<String, Object> textParams = new HashMap<>();
		textParams.put("content", text);
		TreeMap<String, Object> dataParams = new TreeMap<>();
		dataParams.put("touser", openids);
		dataParams.put("text", textParams);
		dataParams.put("msgtype", "text");
		String data = JsonUtil.toJsonString(dataParams);
		System.out.println(data);
		String json = HttpUtil.HttpsDefaultExecute(SystemConstant.POST_METHOD, WechatConstant.SEND_MASS_MESSAGE_URL,
				params, data, null);
		try {
			result = JsonUtil.fromJsonString(json, MassMsgResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;

	}

	/* TODO
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	@Override
	public WeChatResult sendTicketMessage(Map<String, String> params, BaseMessage msgInfo) {
		
		WeChatResult result= new WeChatResult();
		String content = "小程序卡片测试";
		NewsMessage newsMessage = new NewsMessage();
		
		newsMessage.setToUserName(msgInfo.getToUserName());
		newsMessage.setFromUserName(msgInfo.getFromUserName());
		newsMessage.setCreateTime(DateTimeUtil.currentTime());
		newsMessage.setMsgType("news");
		
		List<Article> articleList = new ArrayList<Article>();

		Article article = new Article();
		article.setTitle(content);
		article.setDescription("我是描述信息，哈哈哈哈哈哈哈。。。");
		article.setPicUrl("http://www.iteye.com/upload/logo/user/603624/2dc5ec35-073c-35e7-9b88-274d6b39d560.jpg");
		article.setUrl("http://tuposky.iteye.com");
		articleList.add(article);
		result.setObject(articleList);
		
		logger.debug(DateTimeUtil.formatDate(newsMessage.getCreateTime(), DateTimeUtil.YMDHMS_DATEFORMA) + "关注的openid："
				+ msgInfo.getFromUserName());
		// 保存
		/**** EventKey,Ticket处理 不为空说明有参数 ****/
		if (params.get("EventKey") != null) {
			logger.debug("二维码" + params.get("EventKey"));
			/**** 逻辑处理 ****/
		}
		System.err.println(newsMessage);
		System.err.println("$$$$$$$$$$$$$");
		System.err.println(result);
		return result;
	}

}
