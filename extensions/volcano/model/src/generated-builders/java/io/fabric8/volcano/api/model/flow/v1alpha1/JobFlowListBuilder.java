package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobFlowListBuilder extends JobFlowListFluent<JobFlowListBuilder> implements VisitableBuilder<JobFlowList,JobFlowListBuilder>{

  JobFlowListFluent<?> fluent;

  public JobFlowListBuilder() {
    this(new JobFlowList());
  }
  
  public JobFlowListBuilder(JobFlowListFluent<?> fluent) {
    this(fluent, new JobFlowList());
  }
  
  public JobFlowListBuilder(JobFlowList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobFlowListBuilder(JobFlowListFluent<?> fluent,JobFlowList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobFlowList build() {
    JobFlowList buildable = new JobFlowList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}