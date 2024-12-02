package com.mingi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountForm {
	
	@NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Email is required")
    private String email;

    // 기본 생성자
    public AccountForm() {}

    // 생성자
    public AccountForm(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
