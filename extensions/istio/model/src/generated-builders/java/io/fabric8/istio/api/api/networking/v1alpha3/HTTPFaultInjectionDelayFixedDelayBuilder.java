package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPFaultInjectionDelayFixedDelayBuilder extends HTTPFaultInjectionDelayFixedDelayFluent<HTTPFaultInjectionDelayFixedDelayBuilder> implements VisitableBuilder<HTTPFaultInjectionDelayFixedDelay,HTTPFaultInjectionDelayFixedDelayBuilder>{

  HTTPFaultInjectionDelayFixedDelayFluent<?> fluent;

  public HTTPFaultInjectionDelayFixedDelayBuilder() {
    this(new HTTPFaultInjectionDelayFixedDelay());
  }
  
  public HTTPFaultInjectionDelayFixedDelayBuilder(HTTPFaultInjectionDelayFixedDelayFluent<?> fluent) {
    this(fluent, new HTTPFaultInjectionDelayFixedDelay());
  }
  
  public HTTPFaultInjectionDelayFixedDelayBuilder(HTTPFaultInjectionDelayFixedDelay instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPFaultInjectionDelayFixedDelayBuilder(HTTPFaultInjectionDelayFixedDelayFluent<?> fluent,HTTPFaultInjectionDelayFixedDelay instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPFaultInjectionDelayFixedDelay build() {
    HTTPFaultInjectionDelayFixedDelay buildable = new HTTPFaultInjectionDelayFixedDelay(fluent.getFixedDelay());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}