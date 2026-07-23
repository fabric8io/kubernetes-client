package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSListBuilder extends DNSListFluent<DNSListBuilder> implements VisitableBuilder<DNSList,DNSListBuilder>{

  DNSListFluent<?> fluent;

  public DNSListBuilder() {
    this(new DNSList());
  }
  
  public DNSListBuilder(DNSListFluent<?> fluent) {
    this(fluent, new DNSList());
  }
  
  public DNSListBuilder(DNSList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSListBuilder(DNSListFluent<?> fluent,DNSList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSList build() {
    DNSList buildable = new DNSList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}