package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePlatformNodeNetworkingBuilder extends VSpherePlatformNodeNetworkingFluent<VSpherePlatformNodeNetworkingBuilder> implements VisitableBuilder<VSpherePlatformNodeNetworking,VSpherePlatformNodeNetworkingBuilder>{

  VSpherePlatformNodeNetworkingFluent<?> fluent;

  public VSpherePlatformNodeNetworkingBuilder() {
    this(new VSpherePlatformNodeNetworking());
  }
  
  public VSpherePlatformNodeNetworkingBuilder(VSpherePlatformNodeNetworkingFluent<?> fluent) {
    this(fluent, new VSpherePlatformNodeNetworking());
  }
  
  public VSpherePlatformNodeNetworkingBuilder(VSpherePlatformNodeNetworking instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePlatformNodeNetworkingBuilder(VSpherePlatformNodeNetworkingFluent<?> fluent,VSpherePlatformNodeNetworking instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePlatformNodeNetworking build() {
    VSpherePlatformNodeNetworking buildable = new VSpherePlatformNodeNetworking(fluent.buildExternal(), fluent.buildInternal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}