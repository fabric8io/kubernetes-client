package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobSinkSpecBuilder extends JobSinkSpecFluent<JobSinkSpecBuilder> implements VisitableBuilder<JobSinkSpec,JobSinkSpecBuilder>{

  JobSinkSpecFluent<?> fluent;

  public JobSinkSpecBuilder() {
    this(new JobSinkSpec());
  }
  
  public JobSinkSpecBuilder(JobSinkSpecFluent<?> fluent) {
    this(fluent, new JobSinkSpec());
  }
  
  public JobSinkSpecBuilder(JobSinkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobSinkSpecBuilder(JobSinkSpecFluent<?> fluent,JobSinkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobSinkSpec build() {
    JobSinkSpec buildable = new JobSinkSpec(fluent.getJob());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}