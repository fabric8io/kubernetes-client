package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereFailureDomainZoneAffinityBuilder extends VSphereFailureDomainZoneAffinityFluent<VSphereFailureDomainZoneAffinityBuilder> implements VisitableBuilder<VSphereFailureDomainZoneAffinity,VSphereFailureDomainZoneAffinityBuilder>{

  VSphereFailureDomainZoneAffinityFluent<?> fluent;

  public VSphereFailureDomainZoneAffinityBuilder() {
    this(new VSphereFailureDomainZoneAffinity());
  }
  
  public VSphereFailureDomainZoneAffinityBuilder(VSphereFailureDomainZoneAffinityFluent<?> fluent) {
    this(fluent, new VSphereFailureDomainZoneAffinity());
  }
  
  public VSphereFailureDomainZoneAffinityBuilder(VSphereFailureDomainZoneAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereFailureDomainZoneAffinityBuilder(VSphereFailureDomainZoneAffinityFluent<?> fluent,VSphereFailureDomainZoneAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereFailureDomainZoneAffinity build() {
    VSphereFailureDomainZoneAffinity buildable = new VSphereFailureDomainZoneAffinity(fluent.buildHostGroup(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}