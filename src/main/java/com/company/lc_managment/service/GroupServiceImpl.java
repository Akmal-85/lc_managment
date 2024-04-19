package com.company.lc_managment.service;

import com.company.lc_managment.dto.GroupDTO;
import com.company.lc_managment.dto.GroupEditDTO;
import com.company.lc_managment.entity.Group;
import com.company.lc_managment.enums.DaysOfWeek;
import com.company.lc_managment.enums.Types;
import com.company.lc_managment.exception.RestException;
import com.company.lc_managment.repository.GroupRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CourseService courseService;
    private final TeacherServiceImpl teacherService;

    @Override
    public GroupDTO addGroup(GroupDTO groupDTO) {
        Group group = mapToGroup(groupDTO);
        groupRepository.save(group);
        return groupDTO;
    }

    @Override
    public List<GroupDTO> listGroup() {
        List<Group> allGroup = groupRepository.findAll();

        return allGroup.stream().map(this::mapToGroupDTO).toList();
    }

    public Group mapToGroup(GroupDTO groupDTO){
        return Group.builder()
                .course(courseService.getCourseById(groupDTO.getCourseId()))
                .daysOfWeek(DaysOfWeek.valueOf(groupDTO.getDaysOfWeek()))
                .types(Types.valueOf(groupDTO.getTypes()))
                .build();
    }

    private GroupDTO mapToGroupDTO(Group group) {

          return GroupDTO.builder()
                .types(group.getTypes().name())
                .courseId(Math.toIntExact(group.getCourse().getId()))
                .daysOfWeek(group.getDaysOfWeek().name())
                .build();
    }
    @Override
    public GroupDTO getById(Integer id) {
        Group group = groupRepository.findById(id.longValue()).orElseThrow(() -> RestException.restThrow("Not found"));
        return mapToGroupDTO(group);
    }

    @Override
    public GroupDTO getByCourseId(Integer courseId) {
        Group byCourseId = groupRepository.findByCourse_Id(courseId.longValue());

        return mapToGroupDTO(byCourseId);
    }

    @Override
    public GroupDTO getByDay(String day) {
        Group byDaysOfWeek = groupRepository.findByDaysOfWeek(DaysOfWeek.valueOf(day));

        return mapToGroupDTO(byDaysOfWeek);
    }

    @Override
    public GroupDTO getByTeacherId(Integer id) {
        Group byTeacherId = groupRepository.findByTeacherId(id.longValue());

        return mapToGroupDTO(byTeacherId) ;
    }


    @Override
    public GroupEditDTO editGroup(Integer id, GroupEditDTO groupEditDTO) {
        Group group = groupRepository.findById(id.longValue()).orElseThrow(() -> RestException.restThrow("not Found"));

        group.setTeacher(teacherService.mapToTeacher(teacherService.getTeacherById(groupEditDTO.getCourseId())));
        group.setCourse(courseService.getCourseById(groupEditDTO.getCourseId()));
        group.setTypes(Types.valueOf(groupEditDTO.getTypes()));
        group.setDaysOfWeek(DaysOfWeek.valueOf(groupEditDTO.getDaysOfWeek()));
        return groupEditDTO;

    }



    @Override
    public boolean deleteGroup(Integer id) {
        groupRepository.deleteById(id.longValue());
        return true;
    }
}
