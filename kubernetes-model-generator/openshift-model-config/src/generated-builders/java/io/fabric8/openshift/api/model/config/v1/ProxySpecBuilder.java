package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProxySpecBuilder extends ProxySpecFluent<ProxySpecBuilder> implements VisitableBuilder<ProxySpec,ProxySpecBuilder>{

  ProxySpecFluent<?> fluent;

  public ProxySpecBuilder() {
    this(new ProxySpec());
  }
  
  public ProxySpecBuilder(ProxySpecFluent<?> fluent) {
    this(fluent, new ProxySpec());
  }
  
  public ProxySpecBuilder(ProxySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProxySpecBuilder(ProxySpecFluent<?> fluent,ProxySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProxySpec build() {
    ProxySpec buildable = new ProxySpec(fluent.getHttpProxy(), fluent.getHttpsProxy(), fluent.getNoProxy(), fluent.getReadinessEndpoints(), fluent.buildTrustedCA());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}