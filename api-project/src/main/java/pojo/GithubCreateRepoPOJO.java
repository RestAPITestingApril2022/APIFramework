package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubCreateRepoPOJO {
	private String name;
	@JsonProperty(value = "private")
	private boolean privateVal;
	
	public boolean isPrivateVal() {
		return privateVal;
	}

	public void setPrivateVal(boolean privateVal) {
		this.privateVal = privateVal;
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
