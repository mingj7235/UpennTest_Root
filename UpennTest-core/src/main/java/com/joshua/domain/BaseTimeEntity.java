package com.joshua.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 해당 클래스를 상속할경우, 이 클래스의 필드들도 컬럼으로 인식하도록한다.
//즉, Entity가 이 클래스를 상속할경우에는 여기에 선언된 필드들도 함께 테이블의 컬럼이 되는것!
@EntityListeners(AuditingEntityListener.class) //해당 클래스에 Auditing 기능을 포함시킨다.
public class BaseTimeEntity {

    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;


}