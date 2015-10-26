package com.aceproject.springboot.jpa.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.aceproject.springboot.jpa.domain.ServerGroup;
import com.aceproject.springboot.jpa.repository.ServerGroupRepository;

@Service
public class ServerGroupService {
	
    @Resource
    private ServerGroupRepository serverGroupRepository;

    @Transactional
    public void saveServerGroup(ServerGroup servergroup) {
    	serverGroupRepository.save(servergroup);
    }

    public List<ServerGroup> findServerGroups() {
        return serverGroupRepository.findAll();
    }

    public ServerGroup findOne(String groupCode) {
        return serverGroupRepository.findOne(groupCode);
    }
}
