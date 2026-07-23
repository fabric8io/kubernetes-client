package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerContextBuilder extends TriggerContextFluent<TriggerContextBuilder> implements VisitableBuilder<TriggerContext,TriggerContextBuilder>{

  TriggerContextFluent<?> fluent;

  public TriggerContextBuilder() {
    this(new TriggerContext());
  }
  
  public TriggerContextBuilder(TriggerContextFluent<?> fluent) {
    this(fluent, new TriggerContext());
  }
  
  public TriggerContextBuilder(TriggerContext instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerContextBuilder(TriggerContextFluent<?> fluent,TriggerContext instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerContext build() {
    TriggerContext buildable = new TriggerContext(fluent.getEventId(), fluent.getEventUrl(), fluent.getTriggerId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}