package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterListenerMatchFilterChainMatchBuilder extends EnvoyFilterListenerMatchFilterChainMatchFluent<EnvoyFilterListenerMatchFilterChainMatchBuilder> implements VisitableBuilder<EnvoyFilterListenerMatchFilterChainMatch,EnvoyFilterListenerMatchFilterChainMatchBuilder>{

  EnvoyFilterListenerMatchFilterChainMatchFluent<?> fluent;

  public EnvoyFilterListenerMatchFilterChainMatchBuilder() {
    this(new EnvoyFilterListenerMatchFilterChainMatch());
  }
  
  public EnvoyFilterListenerMatchFilterChainMatchBuilder(EnvoyFilterListenerMatchFilterChainMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterListenerMatchFilterChainMatch());
  }
  
  public EnvoyFilterListenerMatchFilterChainMatchBuilder(EnvoyFilterListenerMatchFilterChainMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterListenerMatchFilterChainMatchBuilder(EnvoyFilterListenerMatchFilterChainMatchFluent<?> fluent,EnvoyFilterListenerMatchFilterChainMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterListenerMatchFilterChainMatch build() {
    EnvoyFilterListenerMatchFilterChainMatch buildable = new EnvoyFilterListenerMatchFilterChainMatch(fluent.getApplicationProtocols(), fluent.getDestinationPort(), fluent.buildFilter(), fluent.getName(), fluent.getSni(), fluent.getTransportProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}