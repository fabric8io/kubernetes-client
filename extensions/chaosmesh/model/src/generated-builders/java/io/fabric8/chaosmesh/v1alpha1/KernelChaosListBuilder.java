package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KernelChaosListBuilder extends KernelChaosListFluent<KernelChaosListBuilder> implements VisitableBuilder<KernelChaosList,KernelChaosListBuilder>{

  KernelChaosListFluent<?> fluent;

  public KernelChaosListBuilder() {
    this(new KernelChaosList());
  }
  
  public KernelChaosListBuilder(KernelChaosListFluent<?> fluent) {
    this(fluent, new KernelChaosList());
  }
  
  public KernelChaosListBuilder(KernelChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KernelChaosListBuilder(KernelChaosListFluent<?> fluent,KernelChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KernelChaosList build() {
    KernelChaosList buildable = new KernelChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}