package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterListenerMatchSubFilterMatchBuilder extends EnvoyFilterListenerMatchSubFilterMatchFluent<EnvoyFilterListenerMatchSubFilterMatchBuilder> implements VisitableBuilder<EnvoyFilterListenerMatchSubFilterMatch,EnvoyFilterListenerMatchSubFilterMatchBuilder>{

  EnvoyFilterListenerMatchSubFilterMatchFluent<?> fluent;

  public EnvoyFilterListenerMatchSubFilterMatchBuilder() {
    this(new EnvoyFilterListenerMatchSubFilterMatch());
  }
  
  public EnvoyFilterListenerMatchSubFilterMatchBuilder(EnvoyFilterListenerMatchSubFilterMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterListenerMatchSubFilterMatch());
  }
  
  public EnvoyFilterListenerMatchSubFilterMatchBuilder(EnvoyFilterListenerMatchSubFilterMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterListenerMatchSubFilterMatchBuilder(EnvoyFilterListenerMatchSubFilterMatchFluent<?> fluent,EnvoyFilterListenerMatchSubFilterMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterListenerMatchSubFilterMatch build() {
    EnvoyFilterListenerMatchSubFilterMatch buildable = new EnvoyFilterListenerMatchSubFilterMatch(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}