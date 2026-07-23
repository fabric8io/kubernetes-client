package io.fabric8.openshift.api.model.installer.powervs.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegionBuilder extends RegionFluent<RegionBuilder> implements VisitableBuilder<Region,RegionBuilder>{

  RegionFluent<?> fluent;

  public RegionBuilder() {
    this(new Region());
  }
  
  public RegionBuilder(RegionFluent<?> fluent) {
    this(fluent, new Region());
  }
  
  public RegionBuilder(Region instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegionBuilder(RegionFluent<?> fluent,Region instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Region build() {
    Region buildable = new Region(fluent.getCOSRegion(), fluent.getDescription(), fluent.getVPCRegion(), fluent.getVPCZones(), fluent.getZones());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}