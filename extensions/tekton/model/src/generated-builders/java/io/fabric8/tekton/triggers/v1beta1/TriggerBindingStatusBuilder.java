package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerBindingStatusBuilder extends TriggerBindingStatusFluent<TriggerBindingStatusBuilder> implements VisitableBuilder<TriggerBindingStatus,TriggerBindingStatusBuilder>{

  TriggerBindingStatusFluent<?> fluent;

  public TriggerBindingStatusBuilder() {
    this(new TriggerBindingStatus());
  }
  
  public TriggerBindingStatusBuilder(TriggerBindingStatusFluent<?> fluent) {
    this(fluent, new TriggerBindingStatus());
  }
  
  public TriggerBindingStatusBuilder(TriggerBindingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerBindingStatusBuilder(TriggerBindingStatusFluent<?> fluent,TriggerBindingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerBindingStatus build() {
    TriggerBindingStatus buildable = new TriggerBindingStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}