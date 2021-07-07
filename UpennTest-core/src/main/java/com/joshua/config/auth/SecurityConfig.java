package com.joshua.config.auth;

import com.joshua.domain.members.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화 시켜준다. 이것을 사용해야한다. enable!!!
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    //configure 메소드 : WebSecurityConfigureAdapter에서 제공되는 메소드로, 말그대로 설정에 대한 내용들이다.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기위해 해당 옵션들을 disable 해야한다.
                .and()
                    .authorizeRequests()
                        //URL별 권한 관리를 설정하는 옵션의 시작점이다.
                        //authorizeRequests가 선언되어야만, antMachers옵션을 사용가능하다.

                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/**").hasRole(Role.USER.name())
                        //antMatchers : 권한 관리 대상을 지정하는 옵션이다.
                        //URL, HTTP메소드 별로 관리가 가능하다.
                        //"/"등 첫번째 antMatchers의 URL들은 permitAll()옵션을 통해 전체 열람 권한을 주었다.
                        //POST 메소드 이면서 "/api/v1/**" 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 설정함.

                    .anyRequest().authenticated()
                        //anyRequest : 설정된 값들 이외의 나머지 URL들을 나타낸다.
                        //authenticated() : 나머지 URL들은 모두 인증된 사용자들에게만 허용하게 한다.
                        //인증된 사용자들, 즉, 로그인한 사용자들을 의미한다.

                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                        //로그아웃 기능에 대한 여러 설정의 진입점이다.
                        //로그아웃 성공 시 "/" 주소로 이동한다 즉, 홈페이지로 이동하도록 설정한 것이다.

                .and()
                    .oauth2Login()
                        //OAuth2 로그인 기능에 대한 여러 설정의 진입점이다.

                        .userInfoEndpoint()
                            //OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당한다.

                            .userService(customOAuth2UserService);
                                //소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다.
                                //리소스 서버 (즉, 소설 서비스들...구글, 네이버) 들에서 사용자 정보를 가져온 상태에서 추가로
                                //진행하고자 하는 기능을 명시할 수 있다.

    }
}
