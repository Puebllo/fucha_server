package base.entities;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import base.enums.LanguageCodeEnum;
import base.enums.UserTypeEnum;

@Entity
@Table(name = "users", schema = "public")
public class User implements java.io.Serializable {
    public static final long serialVersionUID = 1;

    public static final String ID = "id";
    public static final String REGISTER_DATE = "registerDate";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String LOGIN = "login";
    public static final String LANGUAGE_CODE_ENUM = "languageCodeEnum";
    public static final String AVATAR = "avatar";

    public Long id;
    public LocalDateTime registerDate;
    public String email;
    public String password;
    public String login;
    public byte[] avatar;
    public UserTypeEnum userTypeEnum;
    public LanguageCodeEnum languageCodeEnum;


    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() { 
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }

    @Override
    public String toString() {
        return login;
    }

    @Column(name = "login", nullable = false)
    public String getLogin(){
        return login;
    }

    public void setLogin( String login ){
        this.login = login;
    }


    @Column(name = "password", nullable = false)
    public String getPassword(){
        return password;
    }

    public void setPassword( String password ){
        this.password = password;
    }


    @Column(name = "email", nullable = false)
    public String getEmail(){
        return email;
    }

    public void setEmail( String email ){
        this.email = email;
    }


    @Column(name = "register_date", nullable = false)
    public LocalDateTime getRegisterDate(){
        return registerDate;
    }

    public void setRegisterDate( LocalDateTime registerDate ){
        this.registerDate = registerDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type_enum", nullable = false)
    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypEnum) {
        this.userTypeEnum = userTypEnum;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "language_code_enum", nullable = false)
    public LanguageCodeEnum getLanguageCodeEnum() {
        return languageCodeEnum;
    }

    public void setLanguageCodeEnum(LanguageCodeEnum languageCodeEnum) {
        this.languageCodeEnum = languageCodeEnum;
    }

    @Column(name = "avatar")
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
    
}
