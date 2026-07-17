package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSZoneSpecBuilder extends DNSZoneSpecFluent<DNSZoneSpecBuilder> implements VisitableBuilder<DNSZoneSpec,DNSZoneSpecBuilder>{

  DNSZoneSpecFluent<?> fluent;

  public DNSZoneSpecBuilder() {
    this(new DNSZoneSpec());
  }
  
  public DNSZoneSpecBuilder(DNSZoneSpecFluent<?> fluent) {
    this(fluent, new DNSZoneSpec());
  }
  
  public DNSZoneSpecBuilder(DNSZoneSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSZoneSpecBuilder(DNSZoneSpecFluent<?> fluent,DNSZoneSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSZoneSpec build() {
    DNSZoneSpec buildable = new DNSZoneSpec(fluent.buildAws(), fluent.buildAzure(), fluent.buildGcp(), fluent.getLinkToParentDomain(), fluent.getPreserveOnDelete(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}