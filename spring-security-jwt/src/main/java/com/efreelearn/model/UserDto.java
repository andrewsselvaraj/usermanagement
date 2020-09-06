package com.efreelearn.model;

public class UserDto {

    private String username;
    private String password;
	private String primaryskill;
    private String status;
    public String getPrimaryskill() {
		return primaryskill;
	}

	public void setPrimaryskill(String primaryskill) {
		this.primaryskill = primaryskill;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 
}
