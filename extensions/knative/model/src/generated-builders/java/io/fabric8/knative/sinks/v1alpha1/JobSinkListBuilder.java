package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobSinkListBuilder extends JobSinkListFluent<JobSinkListBuilder> implements VisitableBuilder<JobSinkList,JobSinkListBuilder>{

  JobSinkListFluent<?> fluent;

  public JobSinkListBuilder() {
    this(new JobSinkList());
  }
  
  public JobSinkListBuilder(JobSinkListFluent<?> fluent) {
    this(fluent, new JobSinkList());
  }
  
  public JobSinkListBuilder(JobSinkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobSinkListBuilder(JobSinkListFluent<?> fluent,JobSinkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobSinkList build() {
    JobSinkList buildable = new JobSinkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}