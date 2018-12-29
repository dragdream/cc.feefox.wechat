package cc.feefox.wechat.kf;

/**
 * 客服回复消息
 */
public class ResKefu extends Kefu{
	
    private String  touser ;//普通用户openid
    private String   msgtype;//	消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
    private String   content	;//文本消息内容
    private String   media_id;//发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
    private String   thumb_media_id	;//缩略图的媒体ID
    private String   title;//图文消息/视频消息/音乐消息的标题
    private String   description;//图文消息/视频消息/音乐消息的描述
    private String   musicurl;//音乐链接
    private String   hqmusicurl;//高品质音乐链接，wifi环境优先使用该链接播放音乐
    private String   url;//图文消息被点击后跳转的链接
    private String   picurl;//图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80

}
