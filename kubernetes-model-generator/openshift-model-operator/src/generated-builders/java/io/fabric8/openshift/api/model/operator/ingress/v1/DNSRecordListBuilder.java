package io.fabric8.openshift.api.model.operator.ingress.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSRecordListBuilder extends DNSRecordListFluent<DNSRecordListBuilder> implements VisitableBuilder<DNSRecordList,DNSRecordListBuilder>{

  DNSRecordListFluent<?> fluent;

  public DNSRecordListBuilder() {
    this(new DNSRecordList());
  }
  
  public DNSRecordListBuilder(DNSRecordListFluent<?> fluent) {
    this(fluent, new DNSRecordList());
  }
  
  public DNSRecordListBuilder(DNSRecordList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSRecordListBuilder(DNSRecordListFluent<?> fluent,DNSRecordList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSRecordList build() {
    DNSRecordList buildable = new DNSRecordList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}