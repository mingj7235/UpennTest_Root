package com.joshua.config.auth.dto;

import com.joshua.domain.members.Member;
import com.joshua.domain.members.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    //OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 반환해야만 한다.
    public static OAuthAttributes of (String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle (userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle (String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //User 엔터티 생성
    /**
     * OAuthAttributes에서 엔터티를 생성하는 시점은 처음 가입할 때다.
     * 가입할 때의 기본권한을 GUEST로 주기위해서 role 빌더값에는 Role.GUEST를 사용한다.
     *
     */

    public Member toEntity () {
        return Member.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }

}
