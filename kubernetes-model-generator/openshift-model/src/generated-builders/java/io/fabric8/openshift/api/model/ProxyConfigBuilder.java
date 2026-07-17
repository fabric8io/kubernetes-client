package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProxyConfigBuilder extends ProxyConfigFluent<ProxyConfigBuilder> implements VisitableBuilder<ProxyConfig,ProxyConfigBuilder>{

  ProxyConfigFluent<?> fluent;

  public ProxyConfigBuilder() {
    this(new ProxyConfig());
  }
  
  public ProxyConfigBuilder(ProxyConfigFluent<?> fluent) {
    this(fluent, new ProxyConfig());
  }
  
  public ProxyConfigBuilder(ProxyConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProxyConfigBuilder(ProxyConfigFluent<?> fluent,ProxyConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProxyConfig build() {
    ProxyConfig buildable = new ProxyConfig(fluent.getHttpProxy(), fluent.getHttpsProxy(), fluent.getNoProxy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}