package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobRunningHistoryBuilder extends JobRunningHistoryFluent<JobRunningHistoryBuilder> implements VisitableBuilder<JobRunningHistory,JobRunningHistoryBuilder>{

  JobRunningHistoryFluent<?> fluent;

  public JobRunningHistoryBuilder() {
    this(new JobRunningHistory());
  }
  
  public JobRunningHistoryBuilder(JobRunningHistoryFluent<?> fluent) {
    this(fluent, new JobRunningHistory());
  }
  
  public JobRunningHistoryBuilder(JobRunningHistory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobRunningHistoryBuilder(JobRunningHistoryFluent<?> fluent,JobRunningHistory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobRunningHistory build() {
    JobRunningHistory buildable = new JobRunningHistory(fluent.getEndTimestamp(), fluent.getStartTimestamp(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}