package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSNameResolverBuilder extends DNSNameResolverFluent<DNSNameResolverBuilder> implements VisitableBuilder<DNSNameResolver,DNSNameResolverBuilder>{

  DNSNameResolverFluent<?> fluent;

  public DNSNameResolverBuilder() {
    this(new DNSNameResolver());
  }
  
  public DNSNameResolverBuilder(DNSNameResolverFluent<?> fluent) {
    this(fluent, new DNSNameResolver());
  }
  
  public DNSNameResolverBuilder(DNSNameResolver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSNameResolverBuilder(DNSNameResolverFluent<?> fluent,DNSNameResolver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSNameResolver build() {
    DNSNameResolver buildable = new DNSNameResolver(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}