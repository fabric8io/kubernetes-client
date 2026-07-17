package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateBuilder extends TemplateFluent<TemplateBuilder> implements VisitableBuilder<Template,TemplateBuilder>{

  TemplateFluent<?> fluent;

  public TemplateBuilder() {
    this(new Template());
  }
  
  public TemplateBuilder(TemplateFluent<?> fluent) {
    this(fluent, new Template());
  }
  
  public TemplateBuilder(Template instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateBuilder(TemplateFluent<?> fluent,Template instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Template build() {
    Template buildable = new Template(fluent.getApiVersion(), fluent.getKind(), fluent.getLabels(), fluent.getMessage(), fluent.buildMetadata(), fluent.getObjects(), fluent.buildParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}