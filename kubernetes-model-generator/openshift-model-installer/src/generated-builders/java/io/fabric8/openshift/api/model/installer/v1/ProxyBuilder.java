package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProxyBuilder extends ProxyFluent<ProxyBuilder> implements VisitableBuilder<Proxy,ProxyBuilder>{

  ProxyFluent<?> fluent;

  public ProxyBuilder() {
    this(new Proxy());
  }
  
  public ProxyBuilder(ProxyFluent<?> fluent) {
    this(fluent, new Proxy());
  }
  
  public ProxyBuilder(Proxy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProxyBuilder(ProxyFluent<?> fluent,Proxy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Proxy build() {
    Proxy buildable = new Proxy(fluent.getHttpProxy(), fluent.getHttpsProxy(), fluent.getNoProxy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}