package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterListenerMatchBuilder extends EnvoyFilterListenerMatchFluent<EnvoyFilterListenerMatchBuilder> implements VisitableBuilder<EnvoyFilterListenerMatch,EnvoyFilterListenerMatchBuilder>{

  EnvoyFilterListenerMatchFluent<?> fluent;

  public EnvoyFilterListenerMatchBuilder() {
    this(new EnvoyFilterListenerMatch());
  }
  
  public EnvoyFilterListenerMatchBuilder(EnvoyFilterListenerMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterListenerMatch());
  }
  
  public EnvoyFilterListenerMatchBuilder(EnvoyFilterListenerMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterListenerMatchBuilder(EnvoyFilterListenerMatchFluent<?> fluent,EnvoyFilterListenerMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterListenerMatch build() {
    EnvoyFilterListenerMatch buildable = new EnvoyFilterListenerMatch(fluent.buildFilterChain(), fluent.getListenerFilter(), fluent.getName(), fluent.getPortName(), fluent.getPortNumber());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}