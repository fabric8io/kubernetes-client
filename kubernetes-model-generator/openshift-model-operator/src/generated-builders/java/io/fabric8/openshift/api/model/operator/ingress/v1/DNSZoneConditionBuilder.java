package io.fabric8.openshift.api.model.operator.ingress.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSZoneConditionBuilder extends DNSZoneConditionFluent<DNSZoneConditionBuilder> implements VisitableBuilder<DNSZoneCondition,DNSZoneConditionBuilder>{

  DNSZoneConditionFluent<?> fluent;

  public DNSZoneConditionBuilder() {
    this(new DNSZoneCondition());
  }
  
  public DNSZoneConditionBuilder(DNSZoneConditionFluent<?> fluent) {
    this(fluent, new DNSZoneCondition());
  }
  
  public DNSZoneConditionBuilder(DNSZoneCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSZoneConditionBuilder(DNSZoneConditionFluent<?> fluent,DNSZoneCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSZoneCondition build() {
    DNSZoneCondition buildable = new DNSZoneCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}