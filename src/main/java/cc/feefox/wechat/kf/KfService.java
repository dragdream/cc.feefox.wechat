/**
  * @ClassName: kfService 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月28日 下午5:16:08
  * 
  */
package cc.feefox.wechat.kf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.feefox.wechat.common.util.HttpUtil;
import net.sf.json.JSONObject;

/**
 * @Package: cc.feefox.wechat.kf 
 * @author: cc   
 * @date: 2018年8月28日 下午5:16:08 
 */
public class KfService {

	
	  private static Logger log = LoggerFactory.getLogger(KfService.class);

	    //添加客服
	    private static String kfaccount_add_url ="https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
//	    https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN

	    //修改客服信息
	    private static String kfaccount_update_url="https://api.weixin.qq.com/customservice/kefu/update?access_token=ACCESS_TOKEN";

	    //删除客服
	    private static String kfaccount_delete_url="https://api.weixin.qq.com/customservice/kefu/del?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";

	    //设置客服帐号的头像
	    //暂时不做。

	    //获取所有客服账号
	    private static String kfaccount_get_url="https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";


	    public static void add(Kefu kefu, String accessToken) {

	        // 拼装添加客服的url
	        String url = kfaccount_add_url.replace("ACCESS_TOKEN", accessToken);
	        // 将客服对象转换成json字符串
	        String jsonKefu = JSONObject.fromObject(kefu).toString();
	        System.err.println(jsonKefu);
	        // 调用接口
	        JSONObject jsonObject = null;
			try {
				jsonObject = HttpUtil.httpRequestKF(url, "POST", jsonKefu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        if (null != jsonObject) {
	            if (0 != jsonObject.getInt("errcode")) {
	                log.error("添加客服失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
	            }
	        }else {
	            log.error("jsonObject为空");
	        }
	    }

	
	    public static void update(Kefu kefu, String accessToken) {
	        // 拼装添加客服的url
	        String url = kfaccount_update_url.replace("ACCESS_TOKEN", accessToken);
	        // 将客服对象转换成json字符串
	        String jsonKefu = JSONObject.fromObject(kefu).toString();
	        // 调用接口
	        JSONObject jsonObject = null;
			try {
				jsonObject = HttpUtil.httpRequestKF(url, "POST", jsonKefu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        if (null != jsonObject) {
	            if (0 != jsonObject.getInt("errcode")) {
	                log.error("编辑客服失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
	            }
	        }else {
	            log.error("jsonObject为空");
	        }
	    }

	 
	    public static void delete(String kf_account,String accessToken) {
	        // 拼装删除客服的url
	        String url = kfaccount_delete_url.replace("ACCESS_TOKEN", accessToken).replace("KFACCOUNT",kf_account);

	        // 调用接口
	        JSONObject jsonObject = null;
			try {
				jsonObject = HttpUtil.httpRequestKF(url, "GET", null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        if (null != jsonObject) {
	            if (0 != jsonObject.getInt("errcode")) {
	                log.error("删除客服失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
	            }
	        }else {
	            log.error("jsonObject为空");
	        }
	    }
	    
	    public JSONObject get(String accessToken) {
	        // 拼装查询客服的url
	        String url = kfaccount_get_url.replace("ACCESS_TOKEN", accessToken);

	        // 调用接口
	        JSONObject jsonObject = null;
			try {
				jsonObject = HttpUtil.httpRequestKF(url, "GET", null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (null != jsonObject) {
	            if (0 != jsonObject.getInt("errcode")) {
	                log.error("查询客服失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
	            }
	        }else {
	            log.error("jsonObject为空");
	        }

	        return jsonObject;
	    }
}
