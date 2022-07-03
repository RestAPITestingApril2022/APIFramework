package utils;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.response.Response;
import pojo.GithubCreateRepoPOJO;
import pojo.GithubCreateResponseRootPOJO;

public class POJOHelper {
	public static GithubCreateRepoPOJO GetCreateRepoObject(String name, String privateVal, String description) {
		// POJO
		GithubCreateRepoPOJO obj = new GithubCreateRepoPOJO();
		obj.setName(name);
		obj.setPrivateVal(Boolean.parseBoolean(privateVal));
		obj.setDescription(description);

		return obj;
	}

	public static void ValidateCreateRepoObject(Response resp, String name, String privateVal, String description) {

		// With Pojo - deserialization
		GithubCreateResponseRootPOJO obj = resp.then().extract().as(GithubCreateResponseRootPOJO.class);
		String actualName = obj.getName();
		String actualDesc = obj.getDescription();
		boolean actualPrivateVal = obj.isPrivateVal();

		MatcherAssert.assertThat(actualName, Matchers.equalTo(name));
		MatcherAssert.assertThat(actualPrivateVal, Matchers.equalTo(Boolean.parseBoolean(privateVal)));
		MatcherAssert.assertThat(actualDesc, Matchers.equalTo(description));
	}
}
