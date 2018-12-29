package cc.feefox.wechat.customer;

/**
 * 发送客服消息基类
 * @author caspar.chen
 * @version 1.0
 */
public class CustomerBaseMessage {
	
	/**
	 * 普通用户openid
	 */
	private String touser;
	
	/**
	 * 消息类型
	 */
	private String msgtype;
	
	
	private Object obj;


	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
