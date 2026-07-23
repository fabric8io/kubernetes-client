package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkChaosSpecBuilder extends NetworkChaosSpecFluent<NetworkChaosSpecBuilder> implements VisitableBuilder<NetworkChaosSpec,NetworkChaosSpecBuilder>{

  NetworkChaosSpecFluent<?> fluent;

  public NetworkChaosSpecBuilder() {
    this(new NetworkChaosSpec());
  }
  
  public NetworkChaosSpecBuilder(NetworkChaosSpecFluent<?> fluent) {
    this(fluent, new NetworkChaosSpec());
  }
  
  public NetworkChaosSpecBuilder(NetworkChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkChaosSpecBuilder(NetworkChaosSpecFluent<?> fluent,NetworkChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkChaosSpec build() {
    NetworkChaosSpec buildable = new NetworkChaosSpec(fluent.getAction(), fluent.buildBandwidth(), fluent.buildCorrupt(), fluent.buildDelay(), fluent.getDevice(), fluent.getDirection(), fluent.buildDuplicate(), fluent.getDuration(), fluent.getExternalTargets(), fluent.buildLoss(), fluent.getMode(), fluent.buildRate(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.buildTarget(), fluent.getTargetDevice(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}