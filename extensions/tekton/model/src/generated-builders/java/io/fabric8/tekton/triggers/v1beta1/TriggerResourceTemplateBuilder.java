package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerResourceTemplateBuilder extends TriggerResourceTemplateFluent<TriggerResourceTemplateBuilder> implements VisitableBuilder<TriggerResourceTemplate,TriggerResourceTemplateBuilder>{

  TriggerResourceTemplateFluent<?> fluent;

  public TriggerResourceTemplateBuilder() {
    this(new TriggerResourceTemplate());
  }
  
  public TriggerResourceTemplateBuilder(TriggerResourceTemplateFluent<?> fluent) {
    this(fluent, new TriggerResourceTemplate());
  }
  
  public TriggerResourceTemplateBuilder(TriggerResourceTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerResourceTemplateBuilder(TriggerResourceTemplateFluent<?> fluent,TriggerResourceTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerResourceTemplate build() {
    TriggerResourceTemplate buildable = new TriggerResourceTemplate();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}