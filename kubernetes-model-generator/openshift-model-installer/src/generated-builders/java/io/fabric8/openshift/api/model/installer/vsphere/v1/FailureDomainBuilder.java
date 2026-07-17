package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FailureDomainBuilder extends FailureDomainFluent<FailureDomainBuilder> implements VisitableBuilder<FailureDomain,FailureDomainBuilder>{

  FailureDomainFluent<?> fluent;

  public FailureDomainBuilder() {
    this(new FailureDomain());
  }
  
  public FailureDomainBuilder(FailureDomainFluent<?> fluent) {
    this(fluent, new FailureDomain());
  }
  
  public FailureDomainBuilder(FailureDomain instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FailureDomainBuilder(FailureDomainFluent<?> fluent,FailureDomain instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FailureDomain build() {
    FailureDomain buildable = new FailureDomain(fluent.getName(), fluent.getRegion(), fluent.getRegionType(), fluent.getServer(), fluent.buildTopology(), fluent.getZone(), fluent.getZoneType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}