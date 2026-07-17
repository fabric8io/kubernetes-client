package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSNameResolverResolvedNameBuilder extends DNSNameResolverResolvedNameFluent<DNSNameResolverResolvedNameBuilder> implements VisitableBuilder<DNSNameResolverResolvedName,DNSNameResolverResolvedNameBuilder>{

  DNSNameResolverResolvedNameFluent<?> fluent;

  public DNSNameResolverResolvedNameBuilder() {
    this(new DNSNameResolverResolvedName());
  }
  
  public DNSNameResolverResolvedNameBuilder(DNSNameResolverResolvedNameFluent<?> fluent) {
    this(fluent, new DNSNameResolverResolvedName());
  }
  
  public DNSNameResolverResolvedNameBuilder(DNSNameResolverResolvedName instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSNameResolverResolvedNameBuilder(DNSNameResolverResolvedNameFluent<?> fluent,DNSNameResolverResolvedName instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSNameResolverResolvedName build() {
    DNSNameResolverResolvedName buildable = new DNSNameResolverResolvedName(fluent.getConditions(), fluent.getDnsName(), fluent.getResolutionFailures(), fluent.buildResolvedAddresses());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}