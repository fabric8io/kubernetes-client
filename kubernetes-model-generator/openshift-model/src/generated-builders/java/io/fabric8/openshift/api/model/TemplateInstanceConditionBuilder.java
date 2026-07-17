package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateInstanceConditionBuilder extends TemplateInstanceConditionFluent<TemplateInstanceConditionBuilder> implements VisitableBuilder<TemplateInstanceCondition,TemplateInstanceConditionBuilder>{

  TemplateInstanceConditionFluent<?> fluent;

  public TemplateInstanceConditionBuilder() {
    this(new TemplateInstanceCondition());
  }
  
  public TemplateInstanceConditionBuilder(TemplateInstanceConditionFluent<?> fluent) {
    this(fluent, new TemplateInstanceCondition());
  }
  
  public TemplateInstanceConditionBuilder(TemplateInstanceCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateInstanceConditionBuilder(TemplateInstanceConditionFluent<?> fluent,TemplateInstanceCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateInstanceCondition build() {
    TemplateInstanceCondition buildable = new TemplateInstanceCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}