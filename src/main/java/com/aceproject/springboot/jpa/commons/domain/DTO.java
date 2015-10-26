package com.aceproject.springboot.jpa.commons.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Data
@MappedSuperclass // 실제 테이블과 매핑되지 않음. 매핑 정보를 상속할 목적으로 쓰임
public class DTO {
	private Date crtDate;
	private Date updDate;

	/**
	 * 데이터 베이스 생성시 호출 (영속성 컨텍스트에 관리하기 직전에 호출)
	 */
	@PrePersist
	public void prePersist() {
		crtDate = new Date();
		updDate = new Date();
	}

	/**
	 * 데이터 베이스에 수정하기 직전에 호출
	 */
	@PreUpdate
	public void preUpdate() {
		updDate = new Date();
	}
}
