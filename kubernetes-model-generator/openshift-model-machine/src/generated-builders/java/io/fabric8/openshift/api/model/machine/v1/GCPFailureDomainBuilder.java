package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPFailureDomainBuilder extends GCPFailureDomainFluent<GCPFailureDomainBuilder> implements VisitableBuilder<GCPFailureDomain,GCPFailureDomainBuilder>{

  GCPFailureDomainFluent<?> fluent;

  public GCPFailureDomainBuilder() {
    this(new GCPFailureDomain());
  }
  
  public GCPFailureDomainBuilder(GCPFailureDomainFluent<?> fluent) {
    this(fluent, new GCPFailureDomain());
  }
  
  public GCPFailureDomainBuilder(GCPFailureDomain instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPFailureDomainBuilder(GCPFailureDomainFluent<?> fluent,GCPFailureDomain instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPFailureDomain build() {
    GCPFailureDomain buildable = new GCPFailureDomain(fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}