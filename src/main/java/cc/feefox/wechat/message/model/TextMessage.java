package cc.feefox.wechat.message.model;

/**
 * 文本消息
 * 
 * @Package: cc.feefox.wechat.message.model 
 * @author: cc   
 * @date: 2018年8月18日 下午2:52:48
 */
public class TextMessage extends BaseMessage {
	
    // 消息内容
    private String Content;
//    
//    private int FuncFlag;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

//	public int getFuncFlag() {
//		return FuncFlag;
//	}
//
//	public void setFuncFlag(int funcFlag) {
//		FuncFlag = funcFlag;
//	}

 
}