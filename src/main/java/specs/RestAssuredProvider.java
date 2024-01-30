package specs;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class RestAssuredProvider {

  public static final String BASE_URL = System.getProperty("base.url");

  public static void setBaseSpec() {

    RestAssured.requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setRelaxedHTTPSValidation()
            .setContentType(ContentType.JSON)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .build();
  }
}
