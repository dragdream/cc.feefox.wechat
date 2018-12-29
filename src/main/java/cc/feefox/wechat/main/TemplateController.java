/**
  * @ClassName: SendMessageController 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月20日 上午11:53:37
  * 
  */
package cc.feefox.wechat.main;

import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cc.feefox.wechat.common.constant.WechatConstant;
import cc.feefox.wechat.common.util.JsonUtil;
import cc.feefox.wechat.template.model.req.WechatTemplateMsg;
import cc.feefox.wechat.template.model.resp.TemplateMsgResult;
import cc.feefox.wechat.template.service.interfaces.TemplateService;

/**
 * 模版消息
 * @Package: cc.feefox.wechat.main 
 * @author: cc   
 * @date: 2018年8月20日 下午2:47:51
 */
@RestController
@RequestMapping("/wechat")
public class TemplateController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(WeChatController.class);

	@Autowired
	private TemplateService TemplateService;

	/**
	 * 消息模版上传
	 * TemplateController.java
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/template", method = { RequestMethod.GET, RequestMethod.POST })
	public TemplateMsgResult uploadTemplate() throws Exception {

		logger.info("接收到发送模版消息请求");
		TemplateMsgResult result = new TemplateMsgResult();
		// 获取access_token
		String access_token = WechatConstant.ACCESS_TOKEN;
		// 组装模版消息
		TreeMap<String,TreeMap<String,String>> params = new TreeMap<String,TreeMap<String,String>>();
		params.put("first",WechatTemplateMsg.item("您的户外旅行活动订单已经支付完成，可在我的个人中心中查看", "#000000"));
		params.put("keyword1",WechatTemplateMsg.item("8.1发现尼泊尔—人文与自然的旅行圣地", "#000000"));
		params.put("keyword2",WechatTemplateMsg.item("5000元", "#000000"));
		params.put("keyword3",WechatTemplateMsg.item("2017.1.2", "#000000"));
		params.put("keyword4",WechatTemplateMsg.item("5", "#000000"));
		params.put("remark",WechatTemplateMsg.item("请届时携带好身份证件准时到达集合地点，若临时退改将产生相应损失，敬请谅解,谢谢！", "#000000"));
		WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg();
		wechatTemplateMsg.setTemplate_id("qJmiMUVLGppOr7HuyZf6yjtOMDm26Agt6LJgidzEAfo");  
		wechatTemplateMsg.setTouser("oWnU700PB2HTtgzReJva2GzPmp0E");
		wechatTemplateMsg.setUrl("http://music.163.com/#/song?id=27867140");
		wechatTemplateMsg.setData(params);
		String data = JsonUtil.toJsonString(wechatTemplateMsg);
		result =  TemplateService.uploadNewsTemplate(access_token, data);
		logger.info("发送的模版消息："+result.toString());
		return result;
		
	}
	
}
