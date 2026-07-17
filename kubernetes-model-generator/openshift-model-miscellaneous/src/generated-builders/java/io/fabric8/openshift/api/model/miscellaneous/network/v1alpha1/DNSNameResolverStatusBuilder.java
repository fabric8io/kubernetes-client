package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSNameResolverStatusBuilder extends DNSNameResolverStatusFluent<DNSNameResolverStatusBuilder> implements VisitableBuilder<DNSNameResolverStatus,DNSNameResolverStatusBuilder>{

  DNSNameResolverStatusFluent<?> fluent;

  public DNSNameResolverStatusBuilder() {
    this(new DNSNameResolverStatus());
  }
  
  public DNSNameResolverStatusBuilder(DNSNameResolverStatusFluent<?> fluent) {
    this(fluent, new DNSNameResolverStatus());
  }
  
  public DNSNameResolverStatusBuilder(DNSNameResolverStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSNameResolverStatusBuilder(DNSNameResolverStatusFluent<?> fluent,DNSNameResolverStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSNameResolverStatus build() {
    DNSNameResolverStatus buildable = new DNSNameResolverStatus(fluent.buildResolvedNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}