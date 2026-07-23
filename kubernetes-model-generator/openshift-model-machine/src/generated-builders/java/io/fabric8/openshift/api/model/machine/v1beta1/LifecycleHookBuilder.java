package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LifecycleHookBuilder extends LifecycleHookFluent<LifecycleHookBuilder> implements VisitableBuilder<LifecycleHook,LifecycleHookBuilder>{

  LifecycleHookFluent<?> fluent;

  public LifecycleHookBuilder() {
    this(new LifecycleHook());
  }
  
  public LifecycleHookBuilder(LifecycleHookFluent<?> fluent) {
    this(fluent, new LifecycleHook());
  }
  
  public LifecycleHookBuilder(LifecycleHook instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LifecycleHookBuilder(LifecycleHookFluent<?> fluent,LifecycleHook instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LifecycleHook build() {
    LifecycleHook buildable = new LifecycleHook(fluent.getName(), fluent.getOwner());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}