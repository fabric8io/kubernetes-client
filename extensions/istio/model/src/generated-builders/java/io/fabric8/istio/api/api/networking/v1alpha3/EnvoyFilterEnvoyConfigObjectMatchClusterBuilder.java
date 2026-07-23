package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterEnvoyConfigObjectMatchClusterBuilder extends EnvoyFilterEnvoyConfigObjectMatchClusterFluent<EnvoyFilterEnvoyConfigObjectMatchClusterBuilder> implements VisitableBuilder<EnvoyFilterEnvoyConfigObjectMatchCluster,EnvoyFilterEnvoyConfigObjectMatchClusterBuilder>{

  EnvoyFilterEnvoyConfigObjectMatchClusterFluent<?> fluent;

  public EnvoyFilterEnvoyConfigObjectMatchClusterBuilder() {
    this(new EnvoyFilterEnvoyConfigObjectMatchCluster());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchClusterBuilder(EnvoyFilterEnvoyConfigObjectMatchClusterFluent<?> fluent) {
    this(fluent, new EnvoyFilterEnvoyConfigObjectMatchCluster());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchClusterBuilder(EnvoyFilterEnvoyConfigObjectMatchCluster instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchClusterBuilder(EnvoyFilterEnvoyConfigObjectMatchClusterFluent<?> fluent,EnvoyFilterEnvoyConfigObjectMatchCluster instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterEnvoyConfigObjectMatchCluster build() {
    EnvoyFilterEnvoyConfigObjectMatchCluster buildable = new EnvoyFilterEnvoyConfigObjectMatchCluster(fluent.buildCluster());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}