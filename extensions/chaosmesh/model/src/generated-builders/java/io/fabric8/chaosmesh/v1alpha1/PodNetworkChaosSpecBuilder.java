package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkChaosSpecBuilder extends PodNetworkChaosSpecFluent<PodNetworkChaosSpecBuilder> implements VisitableBuilder<PodNetworkChaosSpec,PodNetworkChaosSpecBuilder>{

  PodNetworkChaosSpecFluent<?> fluent;

  public PodNetworkChaosSpecBuilder() {
    this(new PodNetworkChaosSpec());
  }
  
  public PodNetworkChaosSpecBuilder(PodNetworkChaosSpecFluent<?> fluent) {
    this(fluent, new PodNetworkChaosSpec());
  }
  
  public PodNetworkChaosSpecBuilder(PodNetworkChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkChaosSpecBuilder(PodNetworkChaosSpecFluent<?> fluent,PodNetworkChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkChaosSpec build() {
    PodNetworkChaosSpec buildable = new PodNetworkChaosSpec(fluent.buildIpsets(), fluent.buildIptables(), fluent.buildTcs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}