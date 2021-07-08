package com.joshua.config.auth;

import com.joshua.config.auth.dto.OAuthAttributes;
import com.joshua.config.auth.dto.SessionUser;
import com.joshua.domain.members.Member;
import com.joshua.repository.members.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

//이 클래스에서는 구글 로그인 이후 가져온 사용자의 정보 (email, name, picture 등)들을 기반으로
//가입 및 정보 수정, 세션 저장등의 기능을 지원한다.

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
            //현재 로그인 진행중인 서비스를 구분하는 코드. (구글인지 네이버인지 등을 구분해준다.)
            //구글만 사용하는 불필요한 값일 수 있으나, 이후 네이버 로그인 연동시에 네이버 로그인 인지, 구글 로그인 인지 구븐하기 위해 사용한다.

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                                        .getUserInfoEndpoint().getUserNameAttributeName();
            //OAuth2 로그인 진행 시 키가 되는 필드값을 이야기한다. Primary Key와 같은 의미다.
            //구글의 경우 기본적으로 코드를 지원하지만, 네이버 카카오등은 기본 지원하지 않는다. (구글의 기본 코드는 "sub" 이다.)
            //이후 네이버 로그인과 구글 로그인을 동시 지원할 때 사용된다.

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
            //OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스이다.
            //이후 네이버 등 다른 소셜 로그인도 이 클래스를 사용한다.

        Member member = saveOrUpdate(attributes);

        httpSession.setAttribute("user", new SessionUser(member));
                //SessionUser : 세션에 사용자 정보를 저장하기 위한 Dto 클래스다.
                //
        /** 왜 User 클래스를 쓰지않고, 새로 만들어서 쓰는가!?
         * 세션에 저장하기위해 User 클래스를 세션에 저장하려고 하니, User클래스에 직렬화를 구현하지 않았다는 에러가 뜨게된다.
         * 그렇다고 User클래스에 직렬화 코드를 넣으면 안된다. 왜냐하면 User클래스가 엔터티 이기 때문이다.
         * 엔터티 클래스에는 언제 다른 엔티티와 관계가 형성될지 모른다.
         * 직렬화 기능을 가진 세션 Dto를 하나 추가로 만드는 것이 이후 운영 및 유지보수 때 많은 도움이 된다.
         */

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey()))
        , attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    //업데이트 기능까지 넣은 것이다.
    private Member saveOrUpdate (OAuthAttributes attributes) {
        Member member = memberRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return memberRepository.save(member);
    }
}
