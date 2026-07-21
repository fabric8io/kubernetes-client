package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobSinkStatusBuilder extends JobSinkStatusFluent<JobSinkStatusBuilder> implements VisitableBuilder<JobSinkStatus,JobSinkStatusBuilder>{

  JobSinkStatusFluent<?> fluent;

  public JobSinkStatusBuilder() {
    this(new JobSinkStatus());
  }
  
  public JobSinkStatusBuilder(JobSinkStatusFluent<?> fluent) {
    this(fluent, new JobSinkStatus());
  }
  
  public JobSinkStatusBuilder(JobSinkStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobSinkStatusBuilder(JobSinkStatusFluent<?> fluent,JobSinkStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobSinkStatus build() {
    JobSinkStatus buildable = new JobSinkStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildConditions(), fluent.buildJob(), fluent.getObservedGeneration(), fluent.buildPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}