package com.example.mongo.mongodemo.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;

@Getter
@Setter
@ToString
public class Project {
    private ObjectId id;
    private String name;
    private String desc;

    public Project(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
