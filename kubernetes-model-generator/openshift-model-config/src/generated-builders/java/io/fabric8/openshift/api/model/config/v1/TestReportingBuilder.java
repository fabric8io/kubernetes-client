package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TestReportingBuilder extends TestReportingFluent<TestReportingBuilder> implements VisitableBuilder<TestReporting,TestReportingBuilder>{

  TestReportingFluent<?> fluent;

  public TestReportingBuilder() {
    this(new TestReporting());
  }
  
  public TestReportingBuilder(TestReportingFluent<?> fluent) {
    this(fluent, new TestReporting());
  }
  
  public TestReportingBuilder(TestReporting instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TestReportingBuilder(TestReportingFluent<?> fluent,TestReporting instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TestReporting build() {
    TestReporting buildable = new TestReporting(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}