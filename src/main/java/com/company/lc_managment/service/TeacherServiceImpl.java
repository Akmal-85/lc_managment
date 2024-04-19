package com.company.lc_managment.service;

import com.company.lc_managment.dto.GroupDTO;
import com.company.lc_managment.dto.TeacherDTO;
import com.company.lc_managment.entity.Group;
import com.company.lc_managment.entity.Teacher;
import com.company.lc_managment.entity.User;
import com.company.lc_managment.exception.RestException;
import com.company.lc_managment.repository.TeacherRepository;
import com.company.lc_managment.service.auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final AuthServiceImpl authService;
    private final  GroupServiceImpl groupService;

    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO) {
        TeacherDTO teacherById = getTeacherById(Math.toIntExact(teacherDTO.getUserId()));
        if(teacherById!=null) throw  RestException.restThrow("Teacher already exist");
        Teacher teacher = mapToTeacher(teacherDTO);
        Teacher saveTeacher = teacherRepository.save(teacher);

        return mapToTeacherDTO(saveTeacher);
    }

    public Teacher mapToTeacher(TeacherDTO teacherDTO) {
        return Teacher.builder()
                .salary(teacherDTO.getSalary())
                .dateOfStartingWork(teacherDTO.getDateOfStartingWork())
                .build();
    }

    @Override
    public List<TeacherDTO> getAllTeacher() {
        List<Teacher> all = teacherRepository.findAll();
        return all.stream().map(this::mapToTeacherDTO).toList();
    }

    @Override
    public TeacherDTO getTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findById(id.longValue()).orElseThrow(() -> RestException.restThrow("Not found"));
        return mapToTeacherDTO(teacher);
    }


    @Override
    public boolean deleteTeacher(Integer id) {
        teacherRepository.deleteById(id.longValue());
        return true;
    }

    @Override
    public TeacherDTO editTeacher(Integer id, TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.findById(id.longValue()).orElseThrow(() -> RestException.restThrow("Not found"));
        User user = authService.findUserById(Math.toIntExact(teacherDTO.getUserId())).orElseThrow();
        Group [] groups = mapGroupsById(teacherDTO.getGroupList());
        teacher.setUser(user);
        teacher.setGroups(groups);
        teacher.setSalary(teacherDTO.getSalary());
        return teacherDTO;
    }

    private Group[] mapGroupsById(int[] groupList) {
        Group [] newGroup = new Group[groupList.length];
        for (int i = 0; i < groupList.length; i++) {
            GroupDTO byId = groupService.getById(groupList[i]);
            Group group = groupService.mapToGroup(byId);
            newGroup[i]=group;
        }
        return newGroup;

    }

    private TeacherDTO mapToTeacherDTO(Teacher teacher) {

        int[] groupsIDs = getInts(teacher);
        return  TeacherDTO.builder()
                .salary(teacher.getSalary())
                .dateOfStartingWork(teacher.getDateOfStartingWork())
                .groupList(groupsIDs)
                .userId(teacher.getUser().getId())
                .build();


    }

    private static int[] getInts(Teacher teacher) {
        int [] groupsIDs = new int[teacher.getGroups().length];
        int i =0;
        for (Group group : teacher.getGroups()) {
            groupsIDs[i++]= Math.toIntExact(group.getId());

        }
        return groupsIDs;
    }



}
