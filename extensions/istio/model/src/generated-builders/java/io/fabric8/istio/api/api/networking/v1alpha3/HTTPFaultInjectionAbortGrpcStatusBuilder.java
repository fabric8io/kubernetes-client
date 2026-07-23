package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPFaultInjectionAbortGrpcStatusBuilder extends HTTPFaultInjectionAbortGrpcStatusFluent<HTTPFaultInjectionAbortGrpcStatusBuilder> implements VisitableBuilder<HTTPFaultInjectionAbortGrpcStatus,HTTPFaultInjectionAbortGrpcStatusBuilder>{

  HTTPFaultInjectionAbortGrpcStatusFluent<?> fluent;

  public HTTPFaultInjectionAbortGrpcStatusBuilder() {
    this(new HTTPFaultInjectionAbortGrpcStatus());
  }
  
  public HTTPFaultInjectionAbortGrpcStatusBuilder(HTTPFaultInjectionAbortGrpcStatusFluent<?> fluent) {
    this(fluent, new HTTPFaultInjectionAbortGrpcStatus());
  }
  
  public HTTPFaultInjectionAbortGrpcStatusBuilder(HTTPFaultInjectionAbortGrpcStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPFaultInjectionAbortGrpcStatusBuilder(HTTPFaultInjectionAbortGrpcStatusFluent<?> fluent,HTTPFaultInjectionAbortGrpcStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPFaultInjectionAbortGrpcStatus build() {
    HTTPFaultInjectionAbortGrpcStatus buildable = new HTTPFaultInjectionAbortGrpcStatus(fluent.getGrpcStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}