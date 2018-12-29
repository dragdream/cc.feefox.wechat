package cc.feefox.wechat.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cc.feefox.wechat.common.util.SignatureUtil;
import cc.feefox.wechat.common.util.StringUtils;
import cc.feefox.wechat.common.util.XmlUtil;
import cc.feefox.wechat.message.service.interfaces.MessageHandleService;

/**
 * 微信消息入口
 * 
 * @Package: cc.feefox.wechat.main
 * @author: cc
 * @date: 2018年8月18日 下午12:18:39
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(WeChatController.class);

	@Autowired
	private MessageHandleService messageHandleService;

	/**
	 * 校验信息是否是从微信服务器发出，处理消息
	 * 
	 * @param request
	 * @param out
	 * @throws IOException
	 */
	@RequestMapping(value = "/handler", method = { RequestMethod.GET, RequestMethod.POST })
	public void processPost() throws Exception {

		this.getRequest().setCharacterEncoding("UTF-8");
		this.getResponse().setCharacterEncoding("UTF-8");

		logger.info("开始校验信息是否是从微信服务器发出");
		boolean ispost = Objects.equals("POST", this.getRequest().getMethod().toUpperCase());
		if (ispost) {
			logger.debug("接入成功，正在处理逻辑");
			InputStream inputStream = this.getRequest().getInputStream();
			Map<String, String> params = XmlUtil.parseStreamToMap(inputStream);
			String respXml = messageHandleService.handleMessage(params);
			if (StringUtils.isNotNull(respXml)) {
				// 输出流
				this.getResponse().getWriter().write(respXml);
			}

		} else {
			// 签名
			String signature = this.getRequest().getParameter("signature");
			// 时间戳
			String timestamp = this.getRequest().getParameter("timestamp");
			// 随机数
			String nonce = this.getRequest().getParameter("nonce");
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败

			if (SignatureUtil.checkSignature(signature, timestamp, nonce)) {
				// 随机字符串
				String echostr = this.getRequest().getParameter("echostr");
				logger.debug("接入成功，echostr {}", echostr);
				this.getResponse().getWriter().write(echostr);
			}
		}
	}
}