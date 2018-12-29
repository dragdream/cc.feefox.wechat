/**
  * @ClassName: PostMessageService 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 上午11:44:15
  * 
  */
package cc.feefox.wechat.message.service.interfaces;

import java.util.Map;

/**
 * @Package: cc.feefox.wechat.message.service.interfaces 
 * @author: cc   
 * @date: 2018年8月18日 上午11:44:15 
 */
public interface MessageHandleService {

	public String handleMessage(Map<String, String> params) throws Exception ;
}
 