package com.example.mongo.mongodemo.common;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Company {
    private ObjectId id;
    private String name;
    private String desc;
    List<Project> projects = new ArrayList<>();

    public Company(String name, String desc, List<Project> projects) {
        this.name = name;
        this.desc = desc;
        this.projects.addAll(projects);
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
