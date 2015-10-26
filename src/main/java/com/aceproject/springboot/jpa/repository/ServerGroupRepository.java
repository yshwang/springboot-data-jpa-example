package com.aceproject.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceproject.springboot.jpa.domain.ServerGroup;

public interface ServerGroupRepository extends
		JpaRepository<ServerGroup, String> {

}
