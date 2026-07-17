package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSNameResolverListBuilder extends DNSNameResolverListFluent<DNSNameResolverListBuilder> implements VisitableBuilder<DNSNameResolverList,DNSNameResolverListBuilder>{

  DNSNameResolverListFluent<?> fluent;

  public DNSNameResolverListBuilder() {
    this(new DNSNameResolverList());
  }
  
  public DNSNameResolverListBuilder(DNSNameResolverListFluent<?> fluent) {
    this(fluent, new DNSNameResolverList());
  }
  
  public DNSNameResolverListBuilder(DNSNameResolverList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSNameResolverListBuilder(DNSNameResolverListFluent<?> fluent,DNSNameResolverList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSNameResolverList build() {
    DNSNameResolverList buildable = new DNSNameResolverList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}