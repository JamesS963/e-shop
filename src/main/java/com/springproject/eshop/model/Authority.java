package com.springproject.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import com.springproject.eshop.security.Role;

import lombok.Data;

@Entity
@Data
public class Authority implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AUTHORITY_ID", unique = true, nullable = false)
	private Long authorityId;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Override
	public String getAuthority() {
		return role.getAuthority();
	}

}
