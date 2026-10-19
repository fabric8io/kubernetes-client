package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EVPNConfigBuilder extends EVPNConfigFluent<EVPNConfigBuilder> implements VisitableBuilder<EVPNConfig,EVPNConfigBuilder>{

  EVPNConfigFluent<?> fluent;

  public EVPNConfigBuilder() {
    this(new EVPNConfig());
  }
  
  public EVPNConfigBuilder(EVPNConfigFluent<?> fluent) {
    this(fluent, new EVPNConfig());
  }
  
  public EVPNConfigBuilder(EVPNConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EVPNConfigBuilder(EVPNConfigFluent<?> fluent,EVPNConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EVPNConfig build() {
    EVPNConfig buildable = new EVPNConfig(fluent.buildIpVRF(), fluent.buildMacVRF(), fluent.getVtep());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}