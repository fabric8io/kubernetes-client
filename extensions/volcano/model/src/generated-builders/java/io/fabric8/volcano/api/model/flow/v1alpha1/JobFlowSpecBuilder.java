package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobFlowSpecBuilder extends JobFlowSpecFluent<JobFlowSpecBuilder> implements VisitableBuilder<JobFlowSpec,JobFlowSpecBuilder>{

  JobFlowSpecFluent<?> fluent;

  public JobFlowSpecBuilder() {
    this(new JobFlowSpec());
  }
  
  public JobFlowSpecBuilder(JobFlowSpecFluent<?> fluent) {
    this(fluent, new JobFlowSpec());
  }
  
  public JobFlowSpecBuilder(JobFlowSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobFlowSpecBuilder(JobFlowSpecFluent<?> fluent,JobFlowSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobFlowSpec build() {
    JobFlowSpec buildable = new JobFlowSpec(fluent.buildFlows(), fluent.getJobRetainPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}