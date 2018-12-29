/**
  * @ClassName: TemplateServiceImpl 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月20日 下午2:55:19
  * 
  */
package cc.feefox.wechat.template.service.impl;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

import cc.feefox.wechat.common.constant.SystemConstant;
import cc.feefox.wechat.common.constant.WechatConstant;
import cc.feefox.wechat.common.util.HttpUtil;
import cc.feefox.wechat.common.util.JsonUtil;
import cc.feefox.wechat.template.model.resp.TemplateMsgResult;
import cc.feefox.wechat.template.service.interfaces.TemplateService;

/**
 * @Package: cc.feefox.wechat.template.service.impl 
 * @author: cc   
 * @date: 2018年8月20日 下午2:55:19 
 */
@Service
public class TemplateServiceImpl implements TemplateService {

	/* TODO
	 * @param string
	 * @param data
	 * @return
	 */
	@Override
	public TemplateMsgResult uploadNewsTemplate(String access_token, String data) {
		
		TemplateMsgResult templateMsgResult = null;
		TreeMap<String, String> params = new TreeMap<>();
		params.put("access_token", access_token);
		String result = HttpUtil.HttpsDefaultExecute(SystemConstant.POST_METHOD, WechatConstant.SEND_TEMPLATE_MESSAGE,
				params, data, null);
		templateMsgResult = JsonUtil.fromJsonString(result, TemplateMsgResult.class);
		return templateMsgResult;
	}

}
