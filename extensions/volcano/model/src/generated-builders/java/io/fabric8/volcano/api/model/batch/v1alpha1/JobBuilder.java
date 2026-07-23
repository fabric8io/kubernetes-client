package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobBuilder extends JobFluent<JobBuilder> implements VisitableBuilder<Job,JobBuilder>{

  JobFluent<?> fluent;

  public JobBuilder() {
    this(new Job());
  }
  
  public JobBuilder(JobFluent<?> fluent) {
    this(fluent, new Job());
  }
  
  public JobBuilder(Job instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobBuilder(JobFluent<?> fluent,Job instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Job build() {
    Job buildable = new Job(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}