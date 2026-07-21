package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPCommonSpecBuilder extends HTTPCommonSpecFluent<HTTPCommonSpecBuilder> implements VisitableBuilder<HTTPCommonSpec,HTTPCommonSpecBuilder>{

  HTTPCommonSpecFluent<?> fluent;

  public HTTPCommonSpecBuilder() {
    this(new HTTPCommonSpec());
  }
  
  public HTTPCommonSpecBuilder(HTTPCommonSpecFluent<?> fluent) {
    this(fluent, new HTTPCommonSpec());
  }
  
  public HTTPCommonSpecBuilder(HTTPCommonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPCommonSpecBuilder(HTTPCommonSpecFluent<?> fluent,HTTPCommonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPCommonSpec build() {
    HTTPCommonSpec buildable = new HTTPCommonSpec(fluent.getCode(), fluent.getMethod(), fluent.getPath(), fluent.getPort(), fluent.getProxyPorts(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}