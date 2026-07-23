package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateInstanceBuilder extends TemplateInstanceFluent<TemplateInstanceBuilder> implements VisitableBuilder<TemplateInstance,TemplateInstanceBuilder>{

  TemplateInstanceFluent<?> fluent;

  public TemplateInstanceBuilder() {
    this(new TemplateInstance());
  }
  
  public TemplateInstanceBuilder(TemplateInstanceFluent<?> fluent) {
    this(fluent, new TemplateInstance());
  }
  
  public TemplateInstanceBuilder(TemplateInstance instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateInstanceBuilder(TemplateInstanceFluent<?> fluent,TemplateInstance instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateInstance build() {
    TemplateInstance buildable = new TemplateInstance(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}