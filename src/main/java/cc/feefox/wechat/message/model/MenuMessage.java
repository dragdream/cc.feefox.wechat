package cc.feefox.wechat.message.model;

/**
 * 事件消息
 * @Package: cc.feefox.wechat.message.model 
 * @author: cc   
 * @date: 2018年8月18日 下午2:51:27
 */
public class MenuMessage extends BaseMessage {
	
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
