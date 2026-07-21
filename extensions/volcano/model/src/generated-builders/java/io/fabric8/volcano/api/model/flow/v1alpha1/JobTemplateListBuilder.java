package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobTemplateListBuilder extends JobTemplateListFluent<JobTemplateListBuilder> implements VisitableBuilder<JobTemplateList,JobTemplateListBuilder>{

  JobTemplateListFluent<?> fluent;

  public JobTemplateListBuilder() {
    this(new JobTemplateList());
  }
  
  public JobTemplateListBuilder(JobTemplateListFluent<?> fluent) {
    this(fluent, new JobTemplateList());
  }
  
  public JobTemplateListBuilder(JobTemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobTemplateListBuilder(JobTemplateListFluent<?> fluent,JobTemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobTemplateList build() {
    JobTemplateList buildable = new JobTemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}