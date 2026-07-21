package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobStateBuilder extends JobStateFluent<JobStateBuilder> implements VisitableBuilder<JobState,JobStateBuilder>{

  JobStateFluent<?> fluent;

  public JobStateBuilder() {
    this(new JobState());
  }
  
  public JobStateBuilder(JobStateFluent<?> fluent) {
    this(fluent, new JobState());
  }
  
  public JobStateBuilder(JobState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobStateBuilder(JobStateFluent<?> fluent,JobState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobState build() {
    JobState buildable = new JobState(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getPhase(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}