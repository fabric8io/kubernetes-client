package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VRFConfigBuilder extends VRFConfigFluent<VRFConfigBuilder> implements VisitableBuilder<VRFConfig,VRFConfigBuilder>{

  VRFConfigFluent<?> fluent;

  public VRFConfigBuilder() {
    this(new VRFConfig());
  }
  
  public VRFConfigBuilder(VRFConfigFluent<?> fluent) {
    this(fluent, new VRFConfig());
  }
  
  public VRFConfigBuilder(VRFConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VRFConfigBuilder(VRFConfigFluent<?> fluent,VRFConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VRFConfig build() {
    VRFConfig buildable = new VRFConfig(fluent.getRouteTarget(), fluent.getVni());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}