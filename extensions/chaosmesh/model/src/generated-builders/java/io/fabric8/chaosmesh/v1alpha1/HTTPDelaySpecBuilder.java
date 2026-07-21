package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPDelaySpecBuilder extends HTTPDelaySpecFluent<HTTPDelaySpecBuilder> implements VisitableBuilder<HTTPDelaySpec,HTTPDelaySpecBuilder>{

  HTTPDelaySpecFluent<?> fluent;

  public HTTPDelaySpecBuilder() {
    this(new HTTPDelaySpec());
  }
  
  public HTTPDelaySpecBuilder(HTTPDelaySpecFluent<?> fluent) {
    this(fluent, new HTTPDelaySpec());
  }
  
  public HTTPDelaySpecBuilder(HTTPDelaySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPDelaySpecBuilder(HTTPDelaySpecFluent<?> fluent,HTTPDelaySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPDelaySpec build() {
    HTTPDelaySpec buildable = new HTTPDelaySpec(fluent.getCode(), fluent.getDelay(), fluent.getMethod(), fluent.getPath(), fluent.getPort(), fluent.getProxyPorts(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}