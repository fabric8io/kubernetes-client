package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VLANConfigBuilder extends VLANConfigFluent<VLANConfigBuilder> implements VisitableBuilder<VLANConfig,VLANConfigBuilder>{

  VLANConfigFluent<?> fluent;

  public VLANConfigBuilder() {
    this(new VLANConfig());
  }
  
  public VLANConfigBuilder(VLANConfigFluent<?> fluent) {
    this(fluent, new VLANConfig());
  }
  
  public VLANConfigBuilder(VLANConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VLANConfigBuilder(VLANConfigFluent<?> fluent,VLANConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VLANConfig build() {
    VLANConfig buildable = new VLANConfig(fluent.buildAccess(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}