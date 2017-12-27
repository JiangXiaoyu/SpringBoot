package com.bwoil.pay.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="t_bwoil_bank")
public class Bank {
	@Id	
	@GeneratedValue
	private Integer id;
	
	private String code;
	
	private String name;
	
	private Date createTime;
	
}
