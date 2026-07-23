package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPAbortSpecBuilder extends HTTPAbortSpecFluent<HTTPAbortSpecBuilder> implements VisitableBuilder<HTTPAbortSpec,HTTPAbortSpecBuilder>{

  HTTPAbortSpecFluent<?> fluent;

  public HTTPAbortSpecBuilder() {
    this(new HTTPAbortSpec());
  }
  
  public HTTPAbortSpecBuilder(HTTPAbortSpecFluent<?> fluent) {
    this(fluent, new HTTPAbortSpec());
  }
  
  public HTTPAbortSpecBuilder(HTTPAbortSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPAbortSpecBuilder(HTTPAbortSpecFluent<?> fluent,HTTPAbortSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPAbortSpec build() {
    HTTPAbortSpec buildable = new HTTPAbortSpec(fluent.getCode(), fluent.getMethod(), fluent.getPath(), fluent.getPort(), fluent.getProxyPorts(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}