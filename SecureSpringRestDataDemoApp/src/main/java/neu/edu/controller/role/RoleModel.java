package neu.edu.controller.role;

import javax.validation.constraints.NotNull;



public class RoleModel {

	private Integer roleId;

	@NotNull
	private String roleName;
	
	private String roleDesc;
	
	public RoleModel() {
		// TODO Auto-generated constructor stub
	}
	
	public RoleModel(Integer roleId) {
		// TODO Auto-generated constructor stub
		this.roleId = roleId;
	}
	
	

	public Integer getRoleId() {
		return roleId;
	}


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	
	

}
