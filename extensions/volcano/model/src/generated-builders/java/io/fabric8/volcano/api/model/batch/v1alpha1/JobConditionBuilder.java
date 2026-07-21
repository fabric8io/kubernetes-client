package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobConditionBuilder extends JobConditionFluent<JobConditionBuilder> implements VisitableBuilder<JobCondition,JobConditionBuilder>{

  JobConditionFluent<?> fluent;

  public JobConditionBuilder() {
    this(new JobCondition());
  }
  
  public JobConditionBuilder(JobConditionFluent<?> fluent) {
    this(fluent, new JobCondition());
  }
  
  public JobConditionBuilder(JobCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobConditionBuilder(JobConditionFluent<?> fluent,JobCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobCondition build() {
    JobCondition buildable = new JobCondition(fluent.getLastTransitionTime(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}