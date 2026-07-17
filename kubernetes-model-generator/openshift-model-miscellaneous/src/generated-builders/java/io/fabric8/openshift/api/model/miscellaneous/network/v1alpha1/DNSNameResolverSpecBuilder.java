package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSNameResolverSpecBuilder extends DNSNameResolverSpecFluent<DNSNameResolverSpecBuilder> implements VisitableBuilder<DNSNameResolverSpec,DNSNameResolverSpecBuilder>{

  DNSNameResolverSpecFluent<?> fluent;

  public DNSNameResolverSpecBuilder() {
    this(new DNSNameResolverSpec());
  }
  
  public DNSNameResolverSpecBuilder(DNSNameResolverSpecFluent<?> fluent) {
    this(fluent, new DNSNameResolverSpec());
  }
  
  public DNSNameResolverSpecBuilder(DNSNameResolverSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSNameResolverSpecBuilder(DNSNameResolverSpecFluent<?> fluent,DNSNameResolverSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSNameResolverSpec build() {
    DNSNameResolverSpec buildable = new DNSNameResolverSpec(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}