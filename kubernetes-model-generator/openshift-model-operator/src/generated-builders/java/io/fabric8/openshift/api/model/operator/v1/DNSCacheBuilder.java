package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSCacheBuilder extends DNSCacheFluent<DNSCacheBuilder> implements VisitableBuilder<DNSCache,DNSCacheBuilder>{

  DNSCacheFluent<?> fluent;

  public DNSCacheBuilder() {
    this(new DNSCache());
  }
  
  public DNSCacheBuilder(DNSCacheFluent<?> fluent) {
    this(fluent, new DNSCache());
  }
  
  public DNSCacheBuilder(DNSCache instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSCacheBuilder(DNSCacheFluent<?> fluent,DNSCache instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSCache build() {
    DNSCache buildable = new DNSCache(fluent.getNegativeTTL(), fluent.getPositiveTTL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}