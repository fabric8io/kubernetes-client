package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobSpecBuilder extends JobSpecFluent<JobSpecBuilder> implements VisitableBuilder<JobSpec,JobSpecBuilder>{

  JobSpecFluent<?> fluent;

  public JobSpecBuilder() {
    this(new JobSpec());
  }
  
  public JobSpecBuilder(JobSpecFluent<?> fluent) {
    this(fluent, new JobSpec());
  }
  
  public JobSpecBuilder(JobSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobSpecBuilder(JobSpecFluent<?> fluent,JobSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobSpec build() {
    JobSpec buildable = new JobSpec(fluent.getActiveDeadlineSeconds(), fluent.getBackoffLimit(), fluent.getBackoffLimitPerIndex(), fluent.getCompletionMode(), fluent.getCompletions(), fluent.getManagedBy(), fluent.getManualSelector(), fluent.getMaxFailedIndexes(), fluent.getParallelism(), fluent.buildPodFailurePolicy(), fluent.getPodReplacementPolicy(), fluent.buildSelector(), fluent.buildSuccessPolicy(), fluent.getSuspend(), fluent.buildTemplate(), fluent.getTtlSecondsAfterFinished());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}