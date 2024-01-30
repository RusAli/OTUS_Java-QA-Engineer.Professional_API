package extentions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import specs.RestAssuredProvider;

public class Extention implements BeforeEachCallback {

  @Override
  public void beforeEach(ExtensionContext extensionContext) {

    RestAssuredProvider.setBaseSpec();

  }
}
