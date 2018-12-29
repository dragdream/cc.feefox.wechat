package cc.feefox.wechat.token;

import cc.feefox.wechat.common.constant.WechatConstant;

/**
 * 定时获取accesstoken
 * @Package: cc.feefox.wechat.token
 * @author: cc
 * @date: 2018年8月20日 上午10:44:10
 */
public class TokenThread implements Runnable {

	public static AccessToken accesstoken = null;

	public void run() {

		while (true) {
			try {
				accesstoken = GetAccessToken.getInterfaceToken(WechatConstant.APPID, WechatConstant.APPSECRET);
				if (null != accesstoken) {
					WechatConstant.ACCESS_TOKEN = accesstoken.getAccess_token();
					System.out.println("获取accesstoken成功，accesstoken：" + accesstoken.getAccess_token() + " 有效时间为"
							+ accesstoken.getExpires_in());
					Thread.sleep((accesstoken.getExpires_in() - 200) * 1000);// 休眠7000秒
				} else {
					Thread.sleep(60 * 1000);
				}
			} catch (Exception e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}
}