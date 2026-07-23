package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSNameResolverResolvedAddressBuilder extends DNSNameResolverResolvedAddressFluent<DNSNameResolverResolvedAddressBuilder> implements VisitableBuilder<DNSNameResolverResolvedAddress,DNSNameResolverResolvedAddressBuilder>{

  DNSNameResolverResolvedAddressFluent<?> fluent;

  public DNSNameResolverResolvedAddressBuilder() {
    this(new DNSNameResolverResolvedAddress());
  }
  
  public DNSNameResolverResolvedAddressBuilder(DNSNameResolverResolvedAddressFluent<?> fluent) {
    this(fluent, new DNSNameResolverResolvedAddress());
  }
  
  public DNSNameResolverResolvedAddressBuilder(DNSNameResolverResolvedAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSNameResolverResolvedAddressBuilder(DNSNameResolverResolvedAddressFluent<?> fluent,DNSNameResolverResolvedAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSNameResolverResolvedAddress build() {
    DNSNameResolverResolvedAddress buildable = new DNSNameResolverResolvedAddress(fluent.getIp(), fluent.getLastLookupTime(), fluent.getTtlSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}