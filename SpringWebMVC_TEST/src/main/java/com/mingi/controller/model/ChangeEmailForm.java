package com.mingi.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeEmailForm {
	
	private String oldEmailAddress;
	private String newEmailAddress;
	private String UnauthorizedField;
}
