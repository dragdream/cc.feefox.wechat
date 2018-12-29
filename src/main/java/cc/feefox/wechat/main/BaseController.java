package cc.feefox.wechat.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @Package: cc.feefox.wechat.main 
 * @author: cc   
 * @date: 2018年8月18日 下午12:17:55
 */
public class BaseController {

	protected static final String _CSRF_RANDOM_TOKEN = "_CSRF_RANDOM_TOKEN";

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
}
