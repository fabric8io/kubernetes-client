package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRetryBuilder extends HTTPRetryFluent<HTTPRetryBuilder> implements VisitableBuilder<HTTPRetry,HTTPRetryBuilder>{

  HTTPRetryFluent<?> fluent;

  public HTTPRetryBuilder() {
    this(new HTTPRetry());
  }
  
  public HTTPRetryBuilder(HTTPRetryFluent<?> fluent) {
    this(fluent, new HTTPRetry());
  }
  
  public HTTPRetryBuilder(HTTPRetry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRetryBuilder(HTTPRetryFluent<?> fluent,HTTPRetry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRetry build() {
    HTTPRetry buildable = new HTTPRetry(fluent.getAttempts(), fluent.getPerTryTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}