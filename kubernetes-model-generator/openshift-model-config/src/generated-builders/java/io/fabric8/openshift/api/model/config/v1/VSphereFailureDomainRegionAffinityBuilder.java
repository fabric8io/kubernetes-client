package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereFailureDomainRegionAffinityBuilder extends VSphereFailureDomainRegionAffinityFluent<VSphereFailureDomainRegionAffinityBuilder> implements VisitableBuilder<VSphereFailureDomainRegionAffinity,VSphereFailureDomainRegionAffinityBuilder>{

  VSphereFailureDomainRegionAffinityFluent<?> fluent;

  public VSphereFailureDomainRegionAffinityBuilder() {
    this(new VSphereFailureDomainRegionAffinity());
  }
  
  public VSphereFailureDomainRegionAffinityBuilder(VSphereFailureDomainRegionAffinityFluent<?> fluent) {
    this(fluent, new VSphereFailureDomainRegionAffinity());
  }
  
  public VSphereFailureDomainRegionAffinityBuilder(VSphereFailureDomainRegionAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereFailureDomainRegionAffinityBuilder(VSphereFailureDomainRegionAffinityFluent<?> fluent,VSphereFailureDomainRegionAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereFailureDomainRegionAffinity build() {
    VSphereFailureDomainRegionAffinity buildable = new VSphereFailureDomainRegionAffinity(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}