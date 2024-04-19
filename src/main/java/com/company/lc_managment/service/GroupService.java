package com.company.lc_managment.service;

import com.company.lc_managment.dto.GroupDTO;
import com.company.lc_managment.dto.GroupEditDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    GroupDTO addGroup(GroupDTO groupDTO);

    List<GroupDTO> listGroup();

    GroupDTO getById(Integer id);

    GroupDTO getByCourseId(Integer courseId);

    GroupDTO getByDay(String day);

    GroupDTO getByTeacherId(Integer id);

    GroupEditDTO editGroup(Integer id, GroupEditDTO groupEditDTO);

    boolean deleteGroup(Integer id);

}
