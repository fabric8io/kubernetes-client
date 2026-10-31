package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AccessVLANConfigBuilder extends AccessVLANConfigFluent<AccessVLANConfigBuilder> implements VisitableBuilder<AccessVLANConfig,AccessVLANConfigBuilder>{

  AccessVLANConfigFluent<?> fluent;

  public AccessVLANConfigBuilder() {
    this(new AccessVLANConfig());
  }
  
  public AccessVLANConfigBuilder(AccessVLANConfigFluent<?> fluent) {
    this(fluent, new AccessVLANConfig());
  }
  
  public AccessVLANConfigBuilder(AccessVLANConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AccessVLANConfigBuilder(AccessVLANConfigFluent<?> fluent,AccessVLANConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AccessVLANConfig build() {
    AccessVLANConfig buildable = new AccessVLANConfig(fluent.getId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}