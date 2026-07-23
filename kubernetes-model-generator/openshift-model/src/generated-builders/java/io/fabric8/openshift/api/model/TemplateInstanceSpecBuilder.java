package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateInstanceSpecBuilder extends TemplateInstanceSpecFluent<TemplateInstanceSpecBuilder> implements VisitableBuilder<TemplateInstanceSpec,TemplateInstanceSpecBuilder>{

  TemplateInstanceSpecFluent<?> fluent;

  public TemplateInstanceSpecBuilder() {
    this(new TemplateInstanceSpec());
  }
  
  public TemplateInstanceSpecBuilder(TemplateInstanceSpecFluent<?> fluent) {
    this(fluent, new TemplateInstanceSpec());
  }
  
  public TemplateInstanceSpecBuilder(TemplateInstanceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateInstanceSpecBuilder(TemplateInstanceSpecFluent<?> fluent,TemplateInstanceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateInstanceSpec build() {
    TemplateInstanceSpec buildable = new TemplateInstanceSpec(fluent.buildRequester(), fluent.buildSecret(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}