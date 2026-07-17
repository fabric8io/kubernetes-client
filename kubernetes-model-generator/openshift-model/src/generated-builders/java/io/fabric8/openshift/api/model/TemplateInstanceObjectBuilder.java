package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateInstanceObjectBuilder extends TemplateInstanceObjectFluent<TemplateInstanceObjectBuilder> implements VisitableBuilder<TemplateInstanceObject,TemplateInstanceObjectBuilder>{

  TemplateInstanceObjectFluent<?> fluent;

  public TemplateInstanceObjectBuilder() {
    this(new TemplateInstanceObject());
  }
  
  public TemplateInstanceObjectBuilder(TemplateInstanceObjectFluent<?> fluent) {
    this(fluent, new TemplateInstanceObject());
  }
  
  public TemplateInstanceObjectBuilder(TemplateInstanceObject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateInstanceObjectBuilder(TemplateInstanceObjectFluent<?> fluent,TemplateInstanceObject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateInstanceObject build() {
    TemplateInstanceObject buildable = new TemplateInstanceObject(fluent.buildRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}