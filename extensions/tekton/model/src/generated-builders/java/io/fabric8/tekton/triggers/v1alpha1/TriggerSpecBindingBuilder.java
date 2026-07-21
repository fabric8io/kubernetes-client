package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerSpecBindingBuilder extends TriggerSpecBindingFluent<TriggerSpecBindingBuilder> implements VisitableBuilder<TriggerSpecBinding,TriggerSpecBindingBuilder>{

  TriggerSpecBindingFluent<?> fluent;

  public TriggerSpecBindingBuilder() {
    this(new TriggerSpecBinding());
  }
  
  public TriggerSpecBindingBuilder(TriggerSpecBindingFluent<?> fluent) {
    this(fluent, new TriggerSpecBinding());
  }
  
  public TriggerSpecBindingBuilder(TriggerSpecBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerSpecBindingBuilder(TriggerSpecBindingFluent<?> fluent,TriggerSpecBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerSpecBinding build() {
    TriggerSpecBinding buildable = new TriggerSpecBinding(fluent.getApiversion(), fluent.getKind(), fluent.getName(), fluent.getRef(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}