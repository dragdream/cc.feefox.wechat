package cc.feefox.wechat;

import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import cc.feefox.wechat.common.constant.WechatConstant;
import cc.feefox.wechat.common.json.JsonConfig;
import cc.feefox.wechat.kf.Kefu;
import cc.feefox.wechat.kf.KfService;
import cc.feefox.wechat.menu.MenuService;
import cc.feefox.wechat.template.FileService;
import cc.feefox.wechat.token.TokenThread;

@SpringBootApplication
@EnableScheduling // 这里，启用定时任务(待扩展)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		try {
			init();
			while (1 > 0) {
				if (WechatConstant.ACCESS_TOKEN != null) {
					menu();
//					upload();
//					kfList();
					break;
				}
			}
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public static void init() throws ServletException {

		// 启动线程定时获取access_token
		new Thread(new TokenThread()).start();
	}

	// 自定义菜单
	public static void menu() {

		String access_token = WechatConstant.ACCESS_TOKEN;
		String menu = JsonConfig.getJsonResource("datas/menu").toString();
		MenuService.createMenu(menu, access_token);
	}

	// 上传素材模版（根据类型调整）
	public static void upload() {
		try {
			String access_token = WechatConstant.ACCESS_TOKEN;
			String path = "/Users/cc/Desktop/Ad_wechat_7.jpg";
//	        String path = "http://118.25.62.232/images/showreel.jpg";
			FileService.addMaterialEver(path, "image", access_token);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 添加客服
	public static void kfList() {

		String accessToken = WechatConstant.ACCESS_TOKEN;

		Kefu kefu = new Kefu();
		kefu.setAccess_token(accessToken);
//		格式为：账号前缀@公众号微信号
		kefu.setKf_account("feefox@ou0pTwM2io_lD0ihQOywTSFSqwTU");
		kefu.setKf_nick("zp");
		kefu.setKf_id("1001");
		kefu.setNickname("天天客服七号");
		kefu.setMedia("6ogzp2QleC4hxbMKNAZUDBzDxksWWpHuACnvGhPpoEA");
		kefu.setPassword("kf");
		KfService.add(kefu, accessToken);
	}

}
