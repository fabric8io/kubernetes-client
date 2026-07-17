package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProxyStatusBuilder extends ProxyStatusFluent<ProxyStatusBuilder> implements VisitableBuilder<ProxyStatus,ProxyStatusBuilder>{

  ProxyStatusFluent<?> fluent;

  public ProxyStatusBuilder() {
    this(new ProxyStatus());
  }
  
  public ProxyStatusBuilder(ProxyStatusFluent<?> fluent) {
    this(fluent, new ProxyStatus());
  }
  
  public ProxyStatusBuilder(ProxyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProxyStatusBuilder(ProxyStatusFluent<?> fluent,ProxyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProxyStatus build() {
    ProxyStatus buildable = new ProxyStatus(fluent.getHttpProxy(), fluent.getHttpsProxy(), fluent.getNoProxy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}