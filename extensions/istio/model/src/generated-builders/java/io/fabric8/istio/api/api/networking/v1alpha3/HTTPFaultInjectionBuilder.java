package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPFaultInjectionBuilder extends HTTPFaultInjectionFluent<HTTPFaultInjectionBuilder> implements VisitableBuilder<HTTPFaultInjection,HTTPFaultInjectionBuilder>{

  HTTPFaultInjectionFluent<?> fluent;

  public HTTPFaultInjectionBuilder() {
    this(new HTTPFaultInjection());
  }
  
  public HTTPFaultInjectionBuilder(HTTPFaultInjectionFluent<?> fluent) {
    this(fluent, new HTTPFaultInjection());
  }
  
  public HTTPFaultInjectionBuilder(HTTPFaultInjection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPFaultInjectionBuilder(HTTPFaultInjectionFluent<?> fluent,HTTPFaultInjection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPFaultInjection build() {
    HTTPFaultInjection buildable = new HTTPFaultInjection(fluent.buildAbort(), fluent.buildDelay());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}