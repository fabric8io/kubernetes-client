package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerBindingSpecBuilder extends TriggerBindingSpecFluent<TriggerBindingSpecBuilder> implements VisitableBuilder<TriggerBindingSpec,TriggerBindingSpecBuilder>{

  TriggerBindingSpecFluent<?> fluent;

  public TriggerBindingSpecBuilder() {
    this(new TriggerBindingSpec());
  }
  
  public TriggerBindingSpecBuilder(TriggerBindingSpecFluent<?> fluent) {
    this(fluent, new TriggerBindingSpec());
  }
  
  public TriggerBindingSpecBuilder(TriggerBindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerBindingSpecBuilder(TriggerBindingSpecFluent<?> fluent,TriggerBindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerBindingSpec build() {
    TriggerBindingSpec buildable = new TriggerBindingSpec(fluent.buildParams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}