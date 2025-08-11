package io.fabric8.kubeapitest.sample;

import org.junit.jupiter.api.Test;

public class JUnitExtensionExtendingBaseTestClassTest extends BaseTestClass {

  @Test
  void simpleTest1() {
    TestCaseUtils.simpleTest(kubeConfigYaml);
  }

}
