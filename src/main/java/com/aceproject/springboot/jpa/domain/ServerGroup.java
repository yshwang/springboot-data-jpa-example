package com.aceproject.springboot.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.aceproject.springboot.jpa.commons.domain.DTO;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ServerGroup extends DTO {

	@Id
	private String groupCode;
	private int listOrder;
}
