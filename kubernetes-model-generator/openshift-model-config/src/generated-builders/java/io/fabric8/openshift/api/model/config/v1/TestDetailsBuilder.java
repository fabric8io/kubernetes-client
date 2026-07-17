package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TestDetailsBuilder extends TestDetailsFluent<TestDetailsBuilder> implements VisitableBuilder<TestDetails,TestDetailsBuilder>{

  TestDetailsFluent<?> fluent;

  public TestDetailsBuilder() {
    this(new TestDetails());
  }
  
  public TestDetailsBuilder(TestDetailsFluent<?> fluent) {
    this(fluent, new TestDetails());
  }
  
  public TestDetailsBuilder(TestDetails instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TestDetailsBuilder(TestDetailsFluent<?> fluent,TestDetails instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TestDetails build() {
    TestDetails buildable = new TestDetails(fluent.getTestName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}