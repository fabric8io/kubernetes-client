package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePlatformFailureDomainSpecBuilder extends VSpherePlatformFailureDomainSpecFluent<VSpherePlatformFailureDomainSpecBuilder> implements VisitableBuilder<VSpherePlatformFailureDomainSpec,VSpherePlatformFailureDomainSpecBuilder>{

  VSpherePlatformFailureDomainSpecFluent<?> fluent;

  public VSpherePlatformFailureDomainSpecBuilder() {
    this(new VSpherePlatformFailureDomainSpec());
  }
  
  public VSpherePlatformFailureDomainSpecBuilder(VSpherePlatformFailureDomainSpecFluent<?> fluent) {
    this(fluent, new VSpherePlatformFailureDomainSpec());
  }
  
  public VSpherePlatformFailureDomainSpecBuilder(VSpherePlatformFailureDomainSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePlatformFailureDomainSpecBuilder(VSpherePlatformFailureDomainSpecFluent<?> fluent,VSpherePlatformFailureDomainSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePlatformFailureDomainSpec build() {
    VSpherePlatformFailureDomainSpec buildable = new VSpherePlatformFailureDomainSpec(fluent.getName(), fluent.getRegion(), fluent.buildRegionAffinity(), fluent.getServer(), fluent.buildTopology(), fluent.getZone(), fluent.buildZoneAffinity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}