package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobTemplateBuilder extends JobTemplateFluent<JobTemplateBuilder> implements VisitableBuilder<JobTemplate,JobTemplateBuilder>{

  JobTemplateFluent<?> fluent;

  public JobTemplateBuilder() {
    this(new JobTemplate());
  }
  
  public JobTemplateBuilder(JobTemplateFluent<?> fluent) {
    this(fluent, new JobTemplate());
  }
  
  public JobTemplateBuilder(JobTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobTemplateBuilder(JobTemplateFluent<?> fluent,JobTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobTemplate build() {
    JobTemplate buildable = new JobTemplate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}