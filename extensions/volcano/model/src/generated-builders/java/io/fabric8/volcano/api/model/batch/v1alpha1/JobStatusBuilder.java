package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobStatusBuilder extends JobStatusFluent<JobStatusBuilder> implements VisitableBuilder<JobStatus,JobStatusBuilder>{

  JobStatusFluent<?> fluent;

  public JobStatusBuilder() {
    this(new JobStatus());
  }
  
  public JobStatusBuilder(JobStatusFluent<?> fluent) {
    this(fluent, new JobStatus());
  }
  
  public JobStatusBuilder(JobStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobStatusBuilder(JobStatusFluent<?> fluent,JobStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobStatus build() {
    JobStatus buildable = new JobStatus(fluent.buildConditions(), fluent.getControlledResources(), fluent.getFailed(), fluent.getMinAvailable(), fluent.getPending(), fluent.getRetryCount(), fluent.getRunning(), fluent.getRunningDuration(), fluent.buildState(), fluent.getSucceeded(), fluent.getTaskStatusCount(), fluent.getTerminating(), fluent.getUnknown(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}