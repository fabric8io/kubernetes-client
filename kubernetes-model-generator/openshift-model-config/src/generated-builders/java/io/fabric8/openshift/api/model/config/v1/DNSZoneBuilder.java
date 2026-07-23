package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSZoneBuilder extends DNSZoneFluent<DNSZoneBuilder> implements VisitableBuilder<DNSZone,DNSZoneBuilder>{

  DNSZoneFluent<?> fluent;

  public DNSZoneBuilder() {
    this(new DNSZone());
  }
  
  public DNSZoneBuilder(DNSZoneFluent<?> fluent) {
    this(fluent, new DNSZone());
  }
  
  public DNSZoneBuilder(DNSZone instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSZoneBuilder(DNSZoneFluent<?> fluent,DNSZone instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSZone build() {
    DNSZone buildable = new DNSZone(fluent.getId(), fluent.getTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}