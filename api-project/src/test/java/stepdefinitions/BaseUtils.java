package stepdefinitions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseUtils {
	RequestSpecification reqSpec;
	Response resp;
	String token;
	String repoName;
}
