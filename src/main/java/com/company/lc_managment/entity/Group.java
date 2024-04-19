package com.company.lc_managment.entity;

import com.company.lc_managment.enums.DaysOfWeek;
import com.company.lc_managment.enums.Types;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Course course;
    @Enumerated(EnumType.STRING)
    private DaysOfWeek daysOfWeek;
    @Enumerated(EnumType.STRING)
    private Types types;
    @OneToMany
    private List<Student> student;
    @ManyToOne
    private Teacher teacher;
}
