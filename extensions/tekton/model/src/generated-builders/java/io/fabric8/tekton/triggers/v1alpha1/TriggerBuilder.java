package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerBuilder extends TriggerFluent<TriggerBuilder> implements VisitableBuilder<Trigger,TriggerBuilder>{

  TriggerFluent<?> fluent;

  public TriggerBuilder() {
    this(new Trigger());
  }
  
  public TriggerBuilder(TriggerFluent<?> fluent) {
    this(fluent, new Trigger());
  }
  
  public TriggerBuilder(Trigger instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerBuilder(TriggerFluent<?> fluent,Trigger instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Trigger build() {
    Trigger buildable = new Trigger(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}