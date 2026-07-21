package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPFaultInjectionDelayBuilder extends HTTPFaultInjectionDelayFluent<HTTPFaultInjectionDelayBuilder> implements VisitableBuilder<HTTPFaultInjectionDelay,HTTPFaultInjectionDelayBuilder>{

  HTTPFaultInjectionDelayFluent<?> fluent;

  public HTTPFaultInjectionDelayBuilder() {
    this(new HTTPFaultInjectionDelay());
  }
  
  public HTTPFaultInjectionDelayBuilder(HTTPFaultInjectionDelayFluent<?> fluent) {
    this(fluent, new HTTPFaultInjectionDelay());
  }
  
  public HTTPFaultInjectionDelayBuilder(HTTPFaultInjectionDelay instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPFaultInjectionDelayBuilder(HTTPFaultInjectionDelayFluent<?> fluent,HTTPFaultInjectionDelay instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPFaultInjectionDelay build() {
    HTTPFaultInjectionDelay buildable = new HTTPFaultInjectionDelay(fluent.buildHttpDelayType(), fluent.getPercent(), fluent.buildPercentage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}