package com.jt.enterprise.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="resources")
public class Resources {
	@Id
	@GeneratedValue
    private Long id;

    private Long pid;

    private String name;

    private String type;

    private Integer orders;

    private String url;

    private String descs;

    private Date createTime;

    private Date updateTime;

}