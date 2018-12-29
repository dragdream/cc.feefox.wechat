package cc.feefox.wechat.token;

import cc.feefox.wechat.common.util.HttpUtil;
import net.sf.json.JSONObject;

/**
 * 
 * @Package: cc.feefox.wechat.token
 * @author: cc
 * @date: 2018年8月20日 上午10:45:43
 */
public class GetAccessToken {

//	public final static String access_token_url = "https://api.weixin.qq.com/sns/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public static AccessToken getInterfaceToken(String appid, String appsecret) throws Exception {
		AccessToken accessToken = null;
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		new HttpUtil();
		JSONObject jsonObject = HttpUtil.httpRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setAccess_token(jsonObject.getString("access_token"));
				accessToken.setExpires_in(jsonObject.getInt("expires_in"));
			} catch (Exception e) {
				accessToken = null;
				System.out.println(e.getMessage());
			}
		}
		return accessToken;

	}
}