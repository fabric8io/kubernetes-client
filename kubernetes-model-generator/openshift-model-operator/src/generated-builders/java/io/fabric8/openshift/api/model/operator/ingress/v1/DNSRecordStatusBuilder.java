package io.fabric8.openshift.api.model.operator.ingress.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSRecordStatusBuilder extends DNSRecordStatusFluent<DNSRecordStatusBuilder> implements VisitableBuilder<DNSRecordStatus,DNSRecordStatusBuilder>{

  DNSRecordStatusFluent<?> fluent;

  public DNSRecordStatusBuilder() {
    this(new DNSRecordStatus());
  }
  
  public DNSRecordStatusBuilder(DNSRecordStatusFluent<?> fluent) {
    this(fluent, new DNSRecordStatus());
  }
  
  public DNSRecordStatusBuilder(DNSRecordStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSRecordStatusBuilder(DNSRecordStatusFluent<?> fluent,DNSRecordStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSRecordStatus build() {
    DNSRecordStatus buildable = new DNSRecordStatus(fluent.getObservedGeneration(), fluent.buildZones());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}