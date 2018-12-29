package cc.feefox.wechat.kf;

/**
 * 客服的基类
 */
public class Kefu {

    private String access_token;//调用接口凭证
    private String kf_account ; //完整客服账号，格式为：账号前缀@公众号微信号
    private String  kf_nick;//客服昵称
    private String kf_id ;//客服工号
    private String  nickname;//	客服昵称，最长6个汉字或12个英文字符
    private String  password;//客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
    private String  media;//该参数仅在设置客服头像时出现，是form-data中媒体文件标识，有filename、filelength、content-type等信息

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getMedia() {
        return media;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getKf_account() {
        return kf_account;
    }

    public String getKf_nick() {
        return kf_nick;
    }

    public String getKf_id() {
        return kf_id;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }

    public void setKf_nick(String kf_nick) {
        this.kf_nick = kf_nick;
    }

    public void setKf_id(String kf_id) {
        this.kf_id = kf_id;
    }
}