package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPFaultInjectionAbortBuilder extends HTTPFaultInjectionAbortFluent<HTTPFaultInjectionAbortBuilder> implements VisitableBuilder<HTTPFaultInjectionAbort,HTTPFaultInjectionAbortBuilder>{

  HTTPFaultInjectionAbortFluent<?> fluent;

  public HTTPFaultInjectionAbortBuilder() {
    this(new HTTPFaultInjectionAbort());
  }
  
  public HTTPFaultInjectionAbortBuilder(HTTPFaultInjectionAbortFluent<?> fluent) {
    this(fluent, new HTTPFaultInjectionAbort());
  }
  
  public HTTPFaultInjectionAbortBuilder(HTTPFaultInjectionAbort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPFaultInjectionAbortBuilder(HTTPFaultInjectionAbortFluent<?> fluent,HTTPFaultInjectionAbort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPFaultInjectionAbort build() {
    HTTPFaultInjectionAbort buildable = new HTTPFaultInjectionAbort(fluent.buildErrorType(), fluent.buildPercentage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}