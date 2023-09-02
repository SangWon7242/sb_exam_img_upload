package com.ll.exam.app10.app.base.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@SuperBuilder
// @MappedSuperclass : 엔티티끼리 상속할 때 부모 클래스에 이걸 걸어준다. 없으면 안됨.
@MappedSuperclass
@NoArgsConstructor(access = PROTECTED)
// 이걸(@EntityListeners) 해주면은 생성자 메서드에 의해 알아서 값이 들어감
// 이걸 하려면은 Application에 @EnableJpaAuditing 추가 해야 한다.
@EntityListeners(AuditingEntityListener.class)
@ToString
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  @CreatedDate
  private LocalDateTime createDate; // private LocalDateTime createDate = LocalDateTime.now() --> 알아서 들어감;
  @LastModifiedDate
  private LocalDateTime modifyDate;
}
