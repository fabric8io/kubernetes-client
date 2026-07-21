package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerBindingBuilder extends TriggerBindingFluent<TriggerBindingBuilder> implements VisitableBuilder<TriggerBinding,TriggerBindingBuilder>{

  TriggerBindingFluent<?> fluent;

  public TriggerBindingBuilder() {
    this(new TriggerBinding());
  }
  
  public TriggerBindingBuilder(TriggerBindingFluent<?> fluent) {
    this(fluent, new TriggerBinding());
  }
  
  public TriggerBindingBuilder(TriggerBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerBindingBuilder(TriggerBindingFluent<?> fluent,TriggerBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerBinding build() {
    TriggerBinding buildable = new TriggerBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}