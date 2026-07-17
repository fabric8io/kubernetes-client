package io.fabric8.openshift.api.model.operator.ingress.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSRecordBuilder extends DNSRecordFluent<DNSRecordBuilder> implements VisitableBuilder<DNSRecord,DNSRecordBuilder>{

  DNSRecordFluent<?> fluent;

  public DNSRecordBuilder() {
    this(new DNSRecord());
  }
  
  public DNSRecordBuilder(DNSRecordFluent<?> fluent) {
    this(fluent, new DNSRecord());
  }
  
  public DNSRecordBuilder(DNSRecord instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSRecordBuilder(DNSRecordFluent<?> fluent,DNSRecord instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSRecord build() {
    DNSRecord buildable = new DNSRecord(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}