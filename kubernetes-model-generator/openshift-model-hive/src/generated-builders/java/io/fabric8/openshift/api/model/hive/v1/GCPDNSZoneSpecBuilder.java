package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPDNSZoneSpecBuilder extends GCPDNSZoneSpecFluent<GCPDNSZoneSpecBuilder> implements VisitableBuilder<GCPDNSZoneSpec,GCPDNSZoneSpecBuilder>{

  GCPDNSZoneSpecFluent<?> fluent;

  public GCPDNSZoneSpecBuilder() {
    this(new GCPDNSZoneSpec());
  }
  
  public GCPDNSZoneSpecBuilder(GCPDNSZoneSpecFluent<?> fluent) {
    this(fluent, new GCPDNSZoneSpec());
  }
  
  public GCPDNSZoneSpecBuilder(GCPDNSZoneSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPDNSZoneSpecBuilder(GCPDNSZoneSpecFluent<?> fluent,GCPDNSZoneSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPDNSZoneSpec build() {
    GCPDNSZoneSpec buildable = new GCPDNSZoneSpec(fluent.buildCredentialsSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}