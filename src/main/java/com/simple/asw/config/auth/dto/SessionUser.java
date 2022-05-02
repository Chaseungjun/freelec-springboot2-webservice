package com.simple.asw.config.auth.dto;

import com.simple.asw.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { // 인증된 사용자 정보를 저장, 직렬화 필요(직렬화 기능을 가진 세션DTO를 만듦)
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
