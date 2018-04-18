package com.aididi.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.aididi.security.CurrentUserHolder;

@Service
public class ProductService {
	public void checkAccess() {
		String user = CurrentUserHolder.get();
		if(Objects.equals("admin", user)) {
			throw new RuntimeException("running is not allow");
		}
		
	}
}
