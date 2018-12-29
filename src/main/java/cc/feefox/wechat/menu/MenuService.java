package cc.feefox.wechat.menu;

import org.apache.log4j.Logger;

import cc.feefox.wechat.common.util.HttpUtil;
import net.sf.json.JSONObject;

/**
 * 菜单创建
 * 
 * @Package: cc.feefox.wechat.menu 
 * @author: cc   
 * @date: 2018年8月22日 下午9:12:30
 */
public class MenuService {

	public static Logger log = Logger.getLogger(MenuService.class);

	/**
	 * 菜单创建（POST） 限100（次/天）
	 */
	public static String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 菜单查询
	 */
	public static String MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 
	 * @param jsonMenu 
	 * json格式
	 * @return 状态 0 表示成功、其他表示失败
	 */
	public static Integer createMenu(String jsonMenu, String access_token) {
		int result = 0;
		if (access_token != null) {
			// 拼装创建菜单的url
			String url = MENU_CREATE.replace("ACCESS_TOKEN", access_token);
			// 调用接口创建菜单
			JSONObject jsonObject = null;
			try {
				jsonObject = HttpUtil.httpsRequest(url, "POST", jsonMenu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (null != jsonObject) {
				if (0 != jsonObject.getInt("errcode")) {
					result = jsonObject.getInt("errcode");
					log.error("创建菜单失败 errcode:" + jsonObject.getInt("errcode")
							+ "，errmsg:" + jsonObject.getString("errmsg"));
				}
			}
		}
		return result;
	}

}
