package io.fabric8.kubernetes.api.model.batch.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobTemplateSpecBuilder extends JobTemplateSpecFluent<JobTemplateSpecBuilder> implements VisitableBuilder<JobTemplateSpec,JobTemplateSpecBuilder>{

  JobTemplateSpecFluent<?> fluent;

  public JobTemplateSpecBuilder() {
    this(new JobTemplateSpec());
  }
  
  public JobTemplateSpecBuilder(JobTemplateSpecFluent<?> fluent) {
    this(fluent, new JobTemplateSpec());
  }
  
  public JobTemplateSpecBuilder(JobTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobTemplateSpecBuilder(JobTemplateSpecFluent<?> fluent,JobTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobTemplateSpec build() {
    JobTemplateSpec buildable = new JobTemplateSpec(fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}