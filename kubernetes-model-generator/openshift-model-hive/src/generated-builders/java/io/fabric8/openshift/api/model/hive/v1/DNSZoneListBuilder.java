package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSZoneListBuilder extends DNSZoneListFluent<DNSZoneListBuilder> implements VisitableBuilder<DNSZoneList,DNSZoneListBuilder>{

  DNSZoneListFluent<?> fluent;

  public DNSZoneListBuilder() {
    this(new DNSZoneList());
  }
  
  public DNSZoneListBuilder(DNSZoneListFluent<?> fluent) {
    this(fluent, new DNSZoneList());
  }
  
  public DNSZoneListBuilder(DNSZoneList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSZoneListBuilder(DNSZoneListFluent<?> fluent,DNSZoneList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSZoneList build() {
    DNSZoneList buildable = new DNSZoneList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}