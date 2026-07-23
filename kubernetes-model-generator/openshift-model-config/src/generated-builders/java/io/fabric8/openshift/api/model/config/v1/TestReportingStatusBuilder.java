package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TestReportingStatusBuilder extends TestReportingStatusFluent<TestReportingStatusBuilder> implements VisitableBuilder<TestReportingStatus,TestReportingStatusBuilder>{

  TestReportingStatusFluent<?> fluent;

  public TestReportingStatusBuilder() {
    this(new TestReportingStatus());
  }
  
  public TestReportingStatusBuilder(TestReportingStatusFluent<?> fluent) {
    this(fluent, new TestReportingStatus());
  }
  
  public TestReportingStatusBuilder(TestReportingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TestReportingStatusBuilder(TestReportingStatusFluent<?> fluent,TestReportingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TestReportingStatus build() {
    TestReportingStatus buildable = new TestReportingStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}