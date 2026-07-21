package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRequestSpecBuilder extends HTTPRequestSpecFluent<HTTPRequestSpecBuilder> implements VisitableBuilder<HTTPRequestSpec,HTTPRequestSpecBuilder>{

  HTTPRequestSpecFluent<?> fluent;

  public HTTPRequestSpecBuilder() {
    this(new HTTPRequestSpec());
  }
  
  public HTTPRequestSpecBuilder(HTTPRequestSpecFluent<?> fluent) {
    this(fluent, new HTTPRequestSpec());
  }
  
  public HTTPRequestSpecBuilder(HTTPRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRequestSpecBuilder(HTTPRequestSpecFluent<?> fluent,HTTPRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRequestSpec build() {
    HTTPRequestSpec buildable = new HTTPRequestSpec(fluent.getCount(), fluent.getEnableConnPool(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}