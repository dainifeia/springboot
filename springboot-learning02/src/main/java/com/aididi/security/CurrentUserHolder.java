package com.aididi.security;

public class CurrentUserHolder {
	private static final ThreadLocal<String> local = new ThreadLocal<String>(); 
	
	public static String get() {
		return local.get()==null ? "unknow":local.get();
		
	}
	
	public static void set(String user) {
		local.set(user);
	}
}
