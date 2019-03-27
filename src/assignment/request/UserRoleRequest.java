package assignment.request;

import java.security.Principal;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
 
public class UserRoleRequest extends HttpServletRequestWrapper {
 
    private String user;
    private String role;
    private HttpServletRequest realRequest;
 
    public UserRoleRequest(String user, String role, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.role = role;
        this.realRequest = request;
    }
 
    @Override
    public boolean isUserInRole(String role) {
        if (role == null) {
            return this.realRequest.isUserInRole(role);
        }
        return role.contains(role);
    }
 
    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }
 
        return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };
    }
}

