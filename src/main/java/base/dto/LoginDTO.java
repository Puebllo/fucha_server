package base.dto;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import base.enums.LanguageCodeEnum;
import base.enums.UserTypeEnum;
import base.serializers.ByteArraySerializer;

public class LoginDTO implements Serializable{
	
	
	private static final long serialVersionUID = 7812941932008661980L;
	
	public String login;
	public String onLoginResponse;
	public UserTypeEnum userTypeEnum;
	public LanguageCodeEnum languageCodeEnum;
	
	public byte[] avatar;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getOnLoginResponse() {
		return onLoginResponse;
	}
	public void setOnLoginResponse(String onLoginResponse) {
		this.onLoginResponse = onLoginResponse;
	}
	
	public UserTypeEnum getUserTypeEnum() {
		return userTypeEnum;
	}
	public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
		this.userTypeEnum = userTypeEnum;
	}
	
    public LanguageCodeEnum getLanguageCodeEnum() {
        return languageCodeEnum;
    }
    public void setLanguageCodeEnum(LanguageCodeEnum languageCodeEnum) {
        this.languageCodeEnum = languageCodeEnum;
    }
    
    @JsonSerialize(using = ByteArraySerializer.class)
    public byte[] getAvatar() {
        return avatar;
    }
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

}
