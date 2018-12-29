package cc.feefox.wechat.message.model;

/**
 * 音频消息
 * 
 * @Package: cc.feefox.wechat.message.model 
 * @author: cc   
 * @date: 2018年8月18日 下午2:53:00
 */
public class VoiceMessage extends BaseMessage {
	
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}