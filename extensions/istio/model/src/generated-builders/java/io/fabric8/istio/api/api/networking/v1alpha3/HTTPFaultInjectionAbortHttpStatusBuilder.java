package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPFaultInjectionAbortHttpStatusBuilder extends HTTPFaultInjectionAbortHttpStatusFluent<HTTPFaultInjectionAbortHttpStatusBuilder> implements VisitableBuilder<HTTPFaultInjectionAbortHttpStatus,HTTPFaultInjectionAbortHttpStatusBuilder>{

  HTTPFaultInjectionAbortHttpStatusFluent<?> fluent;

  public HTTPFaultInjectionAbortHttpStatusBuilder() {
    this(new HTTPFaultInjectionAbortHttpStatus());
  }
  
  public HTTPFaultInjectionAbortHttpStatusBuilder(HTTPFaultInjectionAbortHttpStatusFluent<?> fluent) {
    this(fluent, new HTTPFaultInjectionAbortHttpStatus());
  }
  
  public HTTPFaultInjectionAbortHttpStatusBuilder(HTTPFaultInjectionAbortHttpStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPFaultInjectionAbortHttpStatusBuilder(HTTPFaultInjectionAbortHttpStatusFluent<?> fluent,HTTPFaultInjectionAbortHttpStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPFaultInjectionAbortHttpStatus build() {
    HTTPFaultInjectionAbortHttpStatus buildable = new HTTPFaultInjectionAbortHttpStatus(fluent.getHttpStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}