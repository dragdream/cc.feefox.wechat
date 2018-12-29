/**
  * @ClassName: WeChatMessageResp 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 下午3:32:43
  * 
  */
package cc.feefox.wechat.common.result;

/**
 * 微信返回结果
 * @Package: cc.feefox.wechat.common.param.response 
 * @author: cc   
 * @date: 2018年8月18日 下午3:32:43 
 */
public class WeChatResult {

	public static final int NEWSMSG = 1; // 图文消息
	
	private boolean success;
	private int type;
	private Object object;
	private String msg;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static int getNewsmsg() {
		return NEWSMSG;
	}
	
	
}
