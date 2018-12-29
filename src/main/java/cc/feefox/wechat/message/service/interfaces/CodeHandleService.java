/**
  * @ClassName: CodeHandleService 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 下午2:11:19
  * 
  */
package cc.feefox.wechat.message.service.interfaces;

import java.util.Map;

import cc.feefox.wechat.common.result.WeChatResult;
import cc.feefox.wechat.message.model.BaseMessage;

/**
 * @Package: cc.feefox.wechat.message.service 
 * @author: cc   
 * @date: 2018年8月18日 下午2:11:19 
 */
public interface CodeHandleService {

	public WeChatResult handleCode(Map<String, String> params, BaseMessage msgInfo);
}
