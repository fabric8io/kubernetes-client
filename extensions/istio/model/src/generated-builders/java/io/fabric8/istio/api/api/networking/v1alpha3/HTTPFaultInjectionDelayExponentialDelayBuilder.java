package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPFaultInjectionDelayExponentialDelayBuilder extends HTTPFaultInjectionDelayExponentialDelayFluent<HTTPFaultInjectionDelayExponentialDelayBuilder> implements VisitableBuilder<HTTPFaultInjectionDelayExponentialDelay,HTTPFaultInjectionDelayExponentialDelayBuilder>{

  HTTPFaultInjectionDelayExponentialDelayFluent<?> fluent;

  public HTTPFaultInjectionDelayExponentialDelayBuilder() {
    this(new HTTPFaultInjectionDelayExponentialDelay());
  }
  
  public HTTPFaultInjectionDelayExponentialDelayBuilder(HTTPFaultInjectionDelayExponentialDelayFluent<?> fluent) {
    this(fluent, new HTTPFaultInjectionDelayExponentialDelay());
  }
  
  public HTTPFaultInjectionDelayExponentialDelayBuilder(HTTPFaultInjectionDelayExponentialDelay instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPFaultInjectionDelayExponentialDelayBuilder(HTTPFaultInjectionDelayExponentialDelayFluent<?> fluent,HTTPFaultInjectionDelayExponentialDelay instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPFaultInjectionDelayExponentialDelay build() {
    HTTPFaultInjectionDelayExponentialDelay buildable = new HTTPFaultInjectionDelayExponentialDelay(fluent.getExponentialDelay());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}