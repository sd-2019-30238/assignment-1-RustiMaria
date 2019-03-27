package assignment.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfiguration {

	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_USER = "USER";

	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

	static {
		init();
	}

	private static void init() {

		// Configure For "ADMIN" Role.
		List<String> urlPatterns1 = new ArrayList<String>();

		urlPatterns1.add("/userInfo");
		urlPatterns1.add("/adminTask");

		mapConfig.put(ROLE_ADMIN, urlPatterns1);

		// Configure For "USER" Role.
		List<String> urlPatterns2 = new ArrayList<String>();

		urlPatterns2.add("/userInfo");
		
		mapConfig.put(ROLE_USER, urlPatterns2);

	}

	public static Set<String> getAllAppRoles() {
		return mapConfig.keySet();
	}

	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}

}
