/**
  * @ClassName: MessageSendService 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月20日 下午12:17:52
  * 
  */
package cc.feefox.wechat.message.service.interfaces;

import java.util.List;
import java.util.Map;

import cc.feefox.wechat.common.result.MassMsgResult;
import cc.feefox.wechat.common.result.WeChatResult;
import cc.feefox.wechat.message.model.BaseMessage;

/**
 * @Package: cc.feefox.wechat.message.service 
 * @author: cc   
 * @date: 2018年8月20日 下午12:17:52 
 */
public interface MessageSendService {

	/**
	 * MessageSendService.java
	 * @param string
	 * @param openids
	 * @param string2
	 */
	MassMsgResult sendTextToOpenid(String access_token, List<String> openids, String text);

	/**
	 * MessageSendService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult sendTicketMessage(Map<String, String> params, BaseMessage msgInfo);
	
	

}
