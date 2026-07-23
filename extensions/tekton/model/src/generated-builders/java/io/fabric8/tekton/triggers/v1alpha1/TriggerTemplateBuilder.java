package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerTemplateBuilder extends TriggerTemplateFluent<TriggerTemplateBuilder> implements VisitableBuilder<TriggerTemplate,TriggerTemplateBuilder>{

  TriggerTemplateFluent<?> fluent;

  public TriggerTemplateBuilder() {
    this(new TriggerTemplate());
  }
  
  public TriggerTemplateBuilder(TriggerTemplateFluent<?> fluent) {
    this(fluent, new TriggerTemplate());
  }
  
  public TriggerTemplateBuilder(TriggerTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerTemplateBuilder(TriggerTemplateFluent<?> fluent,TriggerTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerTemplate build() {
    TriggerTemplate buildable = new TriggerTemplate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}