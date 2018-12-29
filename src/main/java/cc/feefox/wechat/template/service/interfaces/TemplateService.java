/**
  * @ClassName: TemplateService 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月20日 下午2:49:18
  * 
  */
package cc.feefox.wechat.template.service.interfaces;

import cc.feefox.wechat.template.model.resp.TemplateMsgResult;

/**
 * @Package: cc.feefox.wechat.template.service.interfaces 
 * @author: cc   
 * @date: 2018年8月20日 下午2:49:18 
 */
public interface TemplateService {

	/**
	 * TemplateService.java
	 * @param string
	 * @param data
	 * @return
	 */
	TemplateMsgResult uploadNewsTemplate(String access_token, String data);


}
