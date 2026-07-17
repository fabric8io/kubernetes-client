package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePlatformVCenterSpecBuilder extends VSpherePlatformVCenterSpecFluent<VSpherePlatformVCenterSpecBuilder> implements VisitableBuilder<VSpherePlatformVCenterSpec,VSpherePlatformVCenterSpecBuilder>{

  VSpherePlatformVCenterSpecFluent<?> fluent;

  public VSpherePlatformVCenterSpecBuilder() {
    this(new VSpherePlatformVCenterSpec());
  }
  
  public VSpherePlatformVCenterSpecBuilder(VSpherePlatformVCenterSpecFluent<?> fluent) {
    this(fluent, new VSpherePlatformVCenterSpec());
  }
  
  public VSpherePlatformVCenterSpecBuilder(VSpherePlatformVCenterSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePlatformVCenterSpecBuilder(VSpherePlatformVCenterSpecFluent<?> fluent,VSpherePlatformVCenterSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePlatformVCenterSpec build() {
    VSpherePlatformVCenterSpec buildable = new VSpherePlatformVCenterSpec(fluent.getDatacenters(), fluent.getPort(), fluent.getServer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}