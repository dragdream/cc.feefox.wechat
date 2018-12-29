/**
  * @ClassName: WechatMsgService 
  * @Description: TODO
  * @author: cc
  * @date: 2018年8月18日 下午1:27:05
  * 
  */
package cc.feefox.wechat.message.service.interfaces;

import java.util.Map;

import cc.feefox.wechat.common.result.WeChatResult;
import cc.feefox.wechat.message.model.BaseMessage;

/**
 * @Package: cc.feefox.wechat.message.service 
 * @author: cc   
 * @date: 2018年8月18日 下午1:27:05 
 */
public interface WechatMsgService {

	/**
	 * 用户发送的为文本消息
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return  返回需要该消息回复的xml格式类型的字符串
	 */
	WeChatResult textMsgInfo(Map<String, String> params, BaseMessage msgInfo);

	/** 
	 * 用户发送的为图片消息
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult imageMsgInfo(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 用户发送的为链接消息
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult linkMsgInfo(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 用户发送的为地理位置消息
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult locationMsgInfo(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 用户发送的为音频消息
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult voiceMsgInfo(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 用户发送的为短视频消息
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult shortVideo(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 用户发送的为视频消息
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult videoMsgInfo(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 用户关注事件
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult subscribe(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 用户取消关注事件
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult unsubscribe(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 用户已关注时的事件推送
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult scan(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 上报地理位置事件
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult eventLocation(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 点击菜单拉取消息时的事件推送 (自定义菜单的click在这里做响应)
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult eventClick(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 点击菜单跳转链接时的事件推送 (自定义菜单的view在这里做响应)
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult eventView(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 客服创建会话事件
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult kfCreateSession(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 客服关闭会话事件
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult kfCloseSession(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 客服转接会话事件
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 * @return
	 */
	WeChatResult kfSwitchSession(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 事件类型默认返回
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 */
	void eventDefaultReply(Map<String, String> params, BaseMessage msgInfo);

	/**
	 * 默认执行的消息
	 * WechatMsgService.java
	 * @param params
	 * @param msgInfo
	 */
	void defaultMsgInfo(Map<String, String> params, BaseMessage msgInfo);

	
}
