package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.GroupDTO;
import com.company.lc_managment.dto.GroupEditDTO;
import com.company.lc_managment.service.GroupService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GroupControllerImpl implements GroupController {

    private final GroupService groupService;

    @Override
    public ApiResult<GroupDTO> addGroup(GroupDTO groupDTO) {
        GroupDTO group = groupService.addGroup(groupDTO);
        return ApiResult.successResponse(group);
    }

    @Override
    public ApiResult<List<GroupDTO>> getAllGroup() {
        return ApiResult.successResponse(groupService.listGroup());
    }

    @Override
    public ApiResult<GroupDTO> getGroupById(Integer id) {
        return ApiResult.successResponse(groupService.getById(id));
    }

    @Override
    public ApiResult<GroupDTO> getGroupByCourseId(Integer id) {
        return ApiResult.successResponse(groupService.getByCourseId(id));
    }

    @Override
    public ApiResult<GroupDTO> getGroupByDay(String day) {
        return ApiResult.successResponse(groupService.getByDay(day));
    }

    @Override
    public ApiResult<GroupDTO> getGroupByTeacherId(Integer id) {
        return ApiResult.successResponse(groupService.getByTeacherId(id));
    }

    @Override
    public ApiResult<GroupEditDTO> editGroupById(Integer id, GroupEditDTO groupEditDTO) {

        return ApiResult.successResponse(groupService.editGroup(id, groupEditDTO));
    }

    @Override
    public ApiResult<?> deleteGroupById(Integer id) {
        boolean isDelete =groupService.deleteGroup(id);
        return isDelete? ApiResult.successResponse("delete") : ApiResult.errorResponse(400,"not delete");
    }
}
