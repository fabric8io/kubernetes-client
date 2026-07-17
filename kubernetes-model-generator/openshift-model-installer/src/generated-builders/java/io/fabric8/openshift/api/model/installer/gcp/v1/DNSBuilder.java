package io.fabric8.openshift.api.model.installer.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSBuilder extends DNSFluent<DNSBuilder> implements VisitableBuilder<DNS,DNSBuilder>{

  DNSFluent<?> fluent;

  public DNSBuilder() {
    this(new DNS());
  }
  
  public DNSBuilder(DNSFluent<?> fluent) {
    this(fluent, new DNS());
  }
  
  public DNSBuilder(DNS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSBuilder(DNSFluent<?> fluent,DNS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNS build() {
    DNS buildable = new DNS(fluent.buildPrivateZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}