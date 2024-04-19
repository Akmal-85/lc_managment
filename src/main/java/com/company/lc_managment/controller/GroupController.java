package com.company.lc_managment.controller;

import com.company.lc_managment.dto.ApiResult;
import com.company.lc_managment.dto.GroupDTO;
import com.company.lc_managment.dto.GroupEditDTO;
import com.company.lc_managment.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GroupController.BASE_PATH)
public interface GroupController {
    String BASE_PATH = AppConstants.BASE_PATH;
    String ADD_PATH = "/addGroup";
    String GET_ALL_PATH = "/group";
    String GET_BY_ID = "/group/{id}";
    String GET_BY_COURSE_ID = "/groupCourse/{id}";

    String GET_BY_DAY_PATH = "/groupByDay/{day}";
    String GET_BY_TEACHER_ID = "/groupByTeacherId/{id}";

    String EDIT_BY_ID_PATH = "/group/{id}";
    String DELETE_BY_ID_PATH = "/group/{id}";

    @PostMapping(ADD_PATH)
    ApiResult<GroupDTO> addGroup(@Valid @RequestBody GroupDTO groupDTO);

    @GetMapping(GET_ALL_PATH)
    ApiResult<List<GroupDTO>> getAllGroup();

    @GetMapping(GET_BY_ID)
    ApiResult<GroupDTO> getGroupById(@PathVariable Integer id);

    @GetMapping(GET_BY_COURSE_ID)
    ApiResult<GroupDTO> getGroupByCourseId(@PathVariable Integer id);

    @GetMapping(GET_BY_DAY_PATH)
    ApiResult<GroupDTO> getGroupByDay(@PathVariable String day);

    @GetMapping(GET_BY_TEACHER_ID)
    ApiResult<GroupDTO> getGroupByTeacherId(@PathVariable Integer id);

    @PostMapping(EDIT_BY_ID_PATH)
    ApiResult<GroupEditDTO> editGroupById(@PathVariable Integer id, @RequestBody GroupEditDTO groupEditDTO);

    @DeleteMapping(DELETE_BY_ID_PATH)
    ApiResult<?> deleteGroupById(@PathVariable Integer id);


}
