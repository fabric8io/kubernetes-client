package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobSinkBuilder extends JobSinkFluent<JobSinkBuilder> implements VisitableBuilder<JobSink,JobSinkBuilder>{

  JobSinkFluent<?> fluent;

  public JobSinkBuilder() {
    this(new JobSink());
  }
  
  public JobSinkBuilder(JobSinkFluent<?> fluent) {
    this(fluent, new JobSink());
  }
  
  public JobSinkBuilder(JobSink instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobSinkBuilder(JobSinkFluent<?> fluent,JobSink instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobSink build() {
    JobSink buildable = new JobSink(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}