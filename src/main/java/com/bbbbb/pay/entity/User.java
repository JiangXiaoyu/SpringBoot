package com.bbbbb.pay.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "t_tbbbbb_user")
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private String name;

	private String nickName;
}