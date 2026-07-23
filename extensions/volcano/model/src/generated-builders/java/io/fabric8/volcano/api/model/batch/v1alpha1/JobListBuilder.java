package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobListBuilder extends JobListFluent<JobListBuilder> implements VisitableBuilder<JobList,JobListBuilder>{

  JobListFluent<?> fluent;

  public JobListBuilder() {
    this(new JobList());
  }
  
  public JobListBuilder(JobListFluent<?> fluent) {
    this(fluent, new JobList());
  }
  
  public JobListBuilder(JobList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobListBuilder(JobListFluent<?> fluent,JobList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobList build() {
    JobList buildable = new JobList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}