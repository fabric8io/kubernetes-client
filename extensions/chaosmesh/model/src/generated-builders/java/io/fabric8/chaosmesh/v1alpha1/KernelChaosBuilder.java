package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KernelChaosBuilder extends KernelChaosFluent<KernelChaosBuilder> implements VisitableBuilder<KernelChaos,KernelChaosBuilder>{

  KernelChaosFluent<?> fluent;

  public KernelChaosBuilder() {
    this(new KernelChaos());
  }
  
  public KernelChaosBuilder(KernelChaosFluent<?> fluent) {
    this(fluent, new KernelChaos());
  }
  
  public KernelChaosBuilder(KernelChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KernelChaosBuilder(KernelChaosFluent<?> fluent,KernelChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KernelChaos build() {
    KernelChaos buildable = new KernelChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}