package io.fabric8.volcano.api.model.batch.v1alpha1;

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
    JobSpec buildable = new JobSpec(fluent.getMaxRetry(), fluent.getMinAvailable(), fluent.getMinSuccess(), fluent.getPlugins(), fluent.buildPolicies(), fluent.getPriorityClassName(), fluent.getQueue(), fluent.getRunningEstimate(), fluent.getSchedulerName(), fluent.buildTasks(), fluent.getTtlSecondsAfterFinished(), fluent.buildVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}