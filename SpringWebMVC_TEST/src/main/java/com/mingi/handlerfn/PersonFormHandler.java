package com.mingi.handlerfn;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@Component
public class PersonFormHandler {
	
	public ServerResponse renderPersonForm(ServerRequest request) {
		return ok().render("handlerfn/person");
	}
}
