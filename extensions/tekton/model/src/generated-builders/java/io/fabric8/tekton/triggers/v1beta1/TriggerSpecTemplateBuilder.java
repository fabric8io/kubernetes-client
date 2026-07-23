package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerSpecTemplateBuilder extends TriggerSpecTemplateFluent<TriggerSpecTemplateBuilder> implements VisitableBuilder<TriggerSpecTemplate,TriggerSpecTemplateBuilder>{

  TriggerSpecTemplateFluent<?> fluent;

  public TriggerSpecTemplateBuilder() {
    this(new TriggerSpecTemplate());
  }
  
  public TriggerSpecTemplateBuilder(TriggerSpecTemplateFluent<?> fluent) {
    this(fluent, new TriggerSpecTemplate());
  }
  
  public TriggerSpecTemplateBuilder(TriggerSpecTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerSpecTemplateBuilder(TriggerSpecTemplateFluent<?> fluent,TriggerSpecTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerSpecTemplate build() {
    TriggerSpecTemplate buildable = new TriggerSpecTemplate(fluent.getApiversion(), fluent.getRef(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}