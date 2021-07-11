package com.joshua.config.auth.dto;

import com.joshua.domain.members.Location;
import com.joshua.domain.members.Member;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;
   // private Location location;

    public SessionUser(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
     //   this.location = member.getLocation();
    }
}
