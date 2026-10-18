package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalnetConfigBuilder extends LocalnetConfigFluent<LocalnetConfigBuilder> implements VisitableBuilder<LocalnetConfig,LocalnetConfigBuilder>{

  LocalnetConfigFluent<?> fluent;

  public LocalnetConfigBuilder() {
    this(new LocalnetConfig());
  }
  
  public LocalnetConfigBuilder(LocalnetConfigFluent<?> fluent) {
    this(fluent, new LocalnetConfig());
  }
  
  public LocalnetConfigBuilder(LocalnetConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalnetConfigBuilder(LocalnetConfigFluent<?> fluent,LocalnetConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalnetConfig build() {
    LocalnetConfig buildable = new LocalnetConfig(fluent.getExcludeSubnets(), fluent.buildIpam(), fluent.buildMacSecurity(), fluent.getMtu(), fluent.getPhysicalNetworkName(), fluent.getRole(), fluent.getSubnets(), fluent.buildVlan());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}