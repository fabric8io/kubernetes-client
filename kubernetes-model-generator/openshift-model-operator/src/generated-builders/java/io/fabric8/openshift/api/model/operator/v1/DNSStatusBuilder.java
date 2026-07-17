package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSStatusBuilder extends DNSStatusFluent<DNSStatusBuilder> implements VisitableBuilder<DNSStatus,DNSStatusBuilder>{

  DNSStatusFluent<?> fluent;

  public DNSStatusBuilder() {
    this(new DNSStatus());
  }
  
  public DNSStatusBuilder(DNSStatusFluent<?> fluent) {
    this(fluent, new DNSStatus());
  }
  
  public DNSStatusBuilder(DNSStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSStatusBuilder(DNSStatusFluent<?> fluent,DNSStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSStatus build() {
    DNSStatus buildable = new DNSStatus(fluent.getClusterDomain(), fluent.getClusterIP(), fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}