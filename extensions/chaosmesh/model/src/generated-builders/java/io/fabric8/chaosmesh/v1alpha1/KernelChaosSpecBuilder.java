package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KernelChaosSpecBuilder extends KernelChaosSpecFluent<KernelChaosSpecBuilder> implements VisitableBuilder<KernelChaosSpec,KernelChaosSpecBuilder>{

  KernelChaosSpecFluent<?> fluent;

  public KernelChaosSpecBuilder() {
    this(new KernelChaosSpec());
  }
  
  public KernelChaosSpecBuilder(KernelChaosSpecFluent<?> fluent) {
    this(fluent, new KernelChaosSpec());
  }
  
  public KernelChaosSpecBuilder(KernelChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KernelChaosSpecBuilder(KernelChaosSpecFluent<?> fluent,KernelChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KernelChaosSpec build() {
    KernelChaosSpec buildable = new KernelChaosSpec(fluent.getContainerNames(), fluent.getDuration(), fluent.buildFailKernRequest(), fluent.getMode(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}