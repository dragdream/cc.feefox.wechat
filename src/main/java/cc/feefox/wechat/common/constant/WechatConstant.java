/**
  * @ClassName: WechatConstant 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 上午11:08:10
  * 
  */
package cc.feefox.wechat.common.constant;

/**
 * 微信验证信息常量 （读取wechat.properties文件）
 * 
 * @Package: cc.feefox.wechat.common.constant
 * @author: cc
 * @date: 2018年8月18日 上午11:08:10
 */
//@Component
public class WechatConstant {

//	@Value("${wechat.APPID}")
//	private static String appId;
//	
//	@Value("${wechat.APPSECRET}")
//	private static String appSecret;
//	
//	@Value("${wechat.TOKEN}")
//	private static String token;

	/*
	 * 测试账号
	 */
//	public static final String APPID = "wx6a3de67974d1dfe3";
//	public static final String APPSECRET = "16ba18ab3ea6d803b4bdc7a829a3e542";
//	public static final String TOKEN = "weixin";
	
	/*
	 * 天天快来麻将
	 */
	public static final String APPID = "wxf9f3321d5cda89d0";
	public static final String APPSECRET = "901aca5e6f81fe8402c32d01ba080ae6";
	public static final String TOKEN = "weixin";
	
	/*
	 * 通过线程定时获取ACCESS_TOKEN
	 */
	public static String ACCESS_TOKEN;
	
    // 图文内的图片地址获取接口地址
	public static final String UPLOADIMAGEURL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
    // 图文封面图片获取接口地址
	public static final String POSTIMAGEMEDIAURL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=image";
    // 图文素材上传接口地址
	public static final String POSTNEWSURL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
    // 群发接口地址
	public static final String SENDTOALLURL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
    // 预览接口地址
	public static final String SENDTOPREVIEWURL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";

	
	// 按照openid进行群发消息(OpenID最少2个，最多10000个 10000个)  
	public static final String SEND_MASS_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send";
	
	// 发送模板消息
	public static final String SEND_TEMPLATE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/template/send";
}
