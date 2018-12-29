package cc.feefox.wechat.message.model;

/**
 * 图片消息
 * 
 * @Package: cc.feefox.wechat.message.model 
 * @author: cc   
 * @date: 2018年8月18日 下午2:50:39
 */
public class ImageMessage extends BaseMessage {
	
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}