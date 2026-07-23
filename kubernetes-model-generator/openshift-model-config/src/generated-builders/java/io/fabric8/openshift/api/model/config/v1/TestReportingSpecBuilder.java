package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TestReportingSpecBuilder extends TestReportingSpecFluent<TestReportingSpecBuilder> implements VisitableBuilder<TestReportingSpec,TestReportingSpecBuilder>{

  TestReportingSpecFluent<?> fluent;

  public TestReportingSpecBuilder() {
    this(new TestReportingSpec());
  }
  
  public TestReportingSpecBuilder(TestReportingSpecFluent<?> fluent) {
    this(fluent, new TestReportingSpec());
  }
  
  public TestReportingSpecBuilder(TestReportingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TestReportingSpecBuilder(TestReportingSpecFluent<?> fluent,TestReportingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TestReportingSpec build() {
    TestReportingSpec buildable = new TestReportingSpec(fluent.buildTestsForFeatureGates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}