package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobFlowBuilder extends JobFlowFluent<JobFlowBuilder> implements VisitableBuilder<JobFlow,JobFlowBuilder>{

  JobFlowFluent<?> fluent;

  public JobFlowBuilder() {
    this(new JobFlow());
  }
  
  public JobFlowBuilder(JobFlowFluent<?> fluent) {
    this(fluent, new JobFlow());
  }
  
  public JobFlowBuilder(JobFlow instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobFlowBuilder(JobFlowFluent<?> fluent,JobFlow instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobFlow build() {
    JobFlow buildable = new JobFlow(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}