package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPStatusCheckBuilder extends HTTPStatusCheckFluent<HTTPStatusCheckBuilder> implements VisitableBuilder<HTTPStatusCheck,HTTPStatusCheckBuilder>{

  HTTPStatusCheckFluent<?> fluent;

  public HTTPStatusCheckBuilder() {
    this(new HTTPStatusCheck());
  }
  
  public HTTPStatusCheckBuilder(HTTPStatusCheckFluent<?> fluent) {
    this(fluent, new HTTPStatusCheck());
  }
  
  public HTTPStatusCheckBuilder(HTTPStatusCheck instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPStatusCheckBuilder(HTTPStatusCheckFluent<?> fluent,HTTPStatusCheck instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPStatusCheck build() {
    HTTPStatusCheck buildable = new HTTPStatusCheck(fluent.getBody(), fluent.buildCriteria(), fluent.getHeaders(), fluent.getMethod(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}