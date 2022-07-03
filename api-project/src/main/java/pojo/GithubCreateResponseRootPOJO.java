package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubCreateResponseRootPOJO {
	private float id;
	private String name;
	private String full_name;
	
	@JsonProperty(value = "private")
	private boolean privateVal;
	
	GithubOwnerPOJO owner;
	
	private String html_url;
	private String description;

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public boolean isPrivateVal() {
		return privateVal;
	}

	public void setPrivateVal(boolean privateVal) {
		this.privateVal = privateVal;
	}

	public GithubOwnerPOJO getOwner() {
		return owner;
	}

	public void setOwnerObject(GithubOwnerPOJO ownerObject) {
		owner = ownerObject;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}