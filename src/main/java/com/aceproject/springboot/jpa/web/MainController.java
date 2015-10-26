package com.aceproject.springboot.jpa.web;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aceproject.springboot.jpa.domain.ServerGroup;
import com.aceproject.springboot.jpa.service.ServerGroupService;

@Controller
@RequestMapping("/")
public class MainController {

	@Resource
	private ServerGroupService serverGroupService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/groups")
	@ResponseBody
	public List<ServerGroup> getServerGroups() {
		return serverGroupService.findServerGroups();
	}

	@RequestMapping("/groups/insert")
	@ResponseBody
	public String insertServerGroups() {

		insert("group_1", 1);
		insert("group_2", 2);

		return "insert servergroups";
	}

	@RequestMapping("/groups/update")
	@ResponseBody
	public String updateServerGroups() {

		update("group_1", 5);

		return "update servergroups";
	}

	@Transactional
	private void update(String groupCode, int listOrder) {
		ServerGroup serverGroup = serverGroupService.findOne(groupCode);
		serverGroup.setListOrder(listOrder);
		
		serverGroupService.saveServerGroup(serverGroup);
	}

	private void insert(String groupCode, int listOrder) {
		ServerGroup serverGroup = new ServerGroup();
		serverGroup.setGroupCode(groupCode);
		serverGroup.setListOrder(listOrder);

		serverGroupService.saveServerGroup(serverGroup);
	}
}
