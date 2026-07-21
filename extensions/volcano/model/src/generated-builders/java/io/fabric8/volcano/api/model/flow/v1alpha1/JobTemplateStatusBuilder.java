package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobTemplateStatusBuilder extends JobTemplateStatusFluent<JobTemplateStatusBuilder> implements VisitableBuilder<JobTemplateStatus,JobTemplateStatusBuilder>{

  JobTemplateStatusFluent<?> fluent;

  public JobTemplateStatusBuilder() {
    this(new JobTemplateStatus());
  }
  
  public JobTemplateStatusBuilder(JobTemplateStatusFluent<?> fluent) {
    this(fluent, new JobTemplateStatus());
  }
  
  public JobTemplateStatusBuilder(JobTemplateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobTemplateStatusBuilder(JobTemplateStatusFluent<?> fluent,JobTemplateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobTemplateStatus build() {
    JobTemplateStatus buildable = new JobTemplateStatus(fluent.getJobDependsOnList());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}