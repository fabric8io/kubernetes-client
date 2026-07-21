package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerSpecBuilder extends TriggerSpecFluent<TriggerSpecBuilder> implements VisitableBuilder<TriggerSpec,TriggerSpecBuilder>{

  TriggerSpecFluent<?> fluent;

  public TriggerSpecBuilder() {
    this(new TriggerSpec());
  }
  
  public TriggerSpecBuilder(TriggerSpecFluent<?> fluent) {
    this(fluent, new TriggerSpec());
  }
  
  public TriggerSpecBuilder(TriggerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerSpecBuilder(TriggerSpecFluent<?> fluent,TriggerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerSpec build() {
    TriggerSpec buildable = new TriggerSpec(fluent.buildBindings(), fluent.buildInterceptors(), fluent.getName(), fluent.getServiceAccountName(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}