package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateInstanceStatusBuilder extends TemplateInstanceStatusFluent<TemplateInstanceStatusBuilder> implements VisitableBuilder<TemplateInstanceStatus,TemplateInstanceStatusBuilder>{

  TemplateInstanceStatusFluent<?> fluent;

  public TemplateInstanceStatusBuilder() {
    this(new TemplateInstanceStatus());
  }
  
  public TemplateInstanceStatusBuilder(TemplateInstanceStatusFluent<?> fluent) {
    this(fluent, new TemplateInstanceStatus());
  }
  
  public TemplateInstanceStatusBuilder(TemplateInstanceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateInstanceStatusBuilder(TemplateInstanceStatusFluent<?> fluent,TemplateInstanceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateInstanceStatus build() {
    TemplateInstanceStatus buildable = new TemplateInstanceStatus(fluent.buildConditions(), fluent.buildObjects());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}