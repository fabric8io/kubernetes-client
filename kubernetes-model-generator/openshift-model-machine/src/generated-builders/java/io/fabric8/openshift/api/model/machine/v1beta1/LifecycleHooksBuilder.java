package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LifecycleHooksBuilder extends LifecycleHooksFluent<LifecycleHooksBuilder> implements VisitableBuilder<LifecycleHooks,LifecycleHooksBuilder>{

  LifecycleHooksFluent<?> fluent;

  public LifecycleHooksBuilder() {
    this(new LifecycleHooks());
  }
  
  public LifecycleHooksBuilder(LifecycleHooksFluent<?> fluent) {
    this(fluent, new LifecycleHooks());
  }
  
  public LifecycleHooksBuilder(LifecycleHooks instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LifecycleHooksBuilder(LifecycleHooksFluent<?> fluent,LifecycleHooks instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LifecycleHooks build() {
    LifecycleHooks buildable = new LifecycleHooks(fluent.buildPreDrain(), fluent.buildPreTerminate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}