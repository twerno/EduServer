package net.twerno.eduserver.security;

import java.util.UUID;

public class SaltHelper {
	
	public static String getSalt() {
		return UUID.randomUUID().toString();
	}
}
