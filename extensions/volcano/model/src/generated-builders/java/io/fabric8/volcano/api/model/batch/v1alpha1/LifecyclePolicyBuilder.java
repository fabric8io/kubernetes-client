package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LifecyclePolicyBuilder extends LifecyclePolicyFluent<LifecyclePolicyBuilder> implements VisitableBuilder<LifecyclePolicy,LifecyclePolicyBuilder>{

  LifecyclePolicyFluent<?> fluent;

  public LifecyclePolicyBuilder() {
    this(new LifecyclePolicy());
  }
  
  public LifecyclePolicyBuilder(LifecyclePolicyFluent<?> fluent) {
    this(fluent, new LifecyclePolicy());
  }
  
  public LifecyclePolicyBuilder(LifecyclePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LifecyclePolicyBuilder(LifecyclePolicyFluent<?> fluent,LifecyclePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LifecyclePolicy build() {
    LifecyclePolicy buildable = new LifecyclePolicy(fluent.getAction(), fluent.getEvent(), fluent.getEvents(), fluent.getExitCode(), fluent.getTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}