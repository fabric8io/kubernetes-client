package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobFlowStatusBuilder extends JobFlowStatusFluent<JobFlowStatusBuilder> implements VisitableBuilder<JobFlowStatus,JobFlowStatusBuilder>{

  JobFlowStatusFluent<?> fluent;

  public JobFlowStatusBuilder() {
    this(new JobFlowStatus());
  }
  
  public JobFlowStatusBuilder(JobFlowStatusFluent<?> fluent) {
    this(fluent, new JobFlowStatus());
  }
  
  public JobFlowStatusBuilder(JobFlowStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobFlowStatusBuilder(JobFlowStatusFluent<?> fluent,JobFlowStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobFlowStatus build() {
    JobFlowStatus buildable = new JobFlowStatus(fluent.getCompletedJobs(), fluent.getConditions(), fluent.getFailedJobs(), fluent.buildJobStatusList(), fluent.getPendingJobs(), fluent.getRunningJobs(), fluent.buildState(), fluent.getTerminatedJobs(), fluent.getUnKnowJobs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}