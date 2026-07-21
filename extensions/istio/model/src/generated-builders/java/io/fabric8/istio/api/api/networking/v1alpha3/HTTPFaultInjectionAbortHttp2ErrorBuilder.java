package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPFaultInjectionAbortHttp2ErrorBuilder extends HTTPFaultInjectionAbortHttp2ErrorFluent<HTTPFaultInjectionAbortHttp2ErrorBuilder> implements VisitableBuilder<HTTPFaultInjectionAbortHttp2Error,HTTPFaultInjectionAbortHttp2ErrorBuilder>{

  HTTPFaultInjectionAbortHttp2ErrorFluent<?> fluent;

  public HTTPFaultInjectionAbortHttp2ErrorBuilder() {
    this(new HTTPFaultInjectionAbortHttp2Error());
  }
  
  public HTTPFaultInjectionAbortHttp2ErrorBuilder(HTTPFaultInjectionAbortHttp2ErrorFluent<?> fluent) {
    this(fluent, new HTTPFaultInjectionAbortHttp2Error());
  }
  
  public HTTPFaultInjectionAbortHttp2ErrorBuilder(HTTPFaultInjectionAbortHttp2Error instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPFaultInjectionAbortHttp2ErrorBuilder(HTTPFaultInjectionAbortHttp2ErrorFluent<?> fluent,HTTPFaultInjectionAbortHttp2Error instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPFaultInjectionAbortHttp2Error build() {
    HTTPFaultInjectionAbortHttp2Error buildable = new HTTPFaultInjectionAbortHttp2Error(fluent.getHttp2Error());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}