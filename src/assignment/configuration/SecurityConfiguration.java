package assignment.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfiguration {

	public static final String ROLE_ADMIN = "ADMIN";

	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

	static {
		init();
	}

	private static void init() {

		// Configure For "ADMIN" Role.
		List<String> urlPatterns = new ArrayList<String>();

		urlPatterns.add("/userInfo");
		urlPatterns.add("/adminTask");

		mapConfig.put(ROLE_ADMIN, urlPatterns);

	}

	public static Set<String> getAllAppRoles() {
		return mapConfig.keySet();
	}

	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}

}
