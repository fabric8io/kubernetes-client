package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterListenerMatchFilterMatchBuilder extends EnvoyFilterListenerMatchFilterMatchFluent<EnvoyFilterListenerMatchFilterMatchBuilder> implements VisitableBuilder<EnvoyFilterListenerMatchFilterMatch,EnvoyFilterListenerMatchFilterMatchBuilder>{

  EnvoyFilterListenerMatchFilterMatchFluent<?> fluent;

  public EnvoyFilterListenerMatchFilterMatchBuilder() {
    this(new EnvoyFilterListenerMatchFilterMatch());
  }
  
  public EnvoyFilterListenerMatchFilterMatchBuilder(EnvoyFilterListenerMatchFilterMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterListenerMatchFilterMatch());
  }
  
  public EnvoyFilterListenerMatchFilterMatchBuilder(EnvoyFilterListenerMatchFilterMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterListenerMatchFilterMatchBuilder(EnvoyFilterListenerMatchFilterMatchFluent<?> fluent,EnvoyFilterListenerMatchFilterMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterListenerMatchFilterMatch build() {
    EnvoyFilterListenerMatchFilterMatch buildable = new EnvoyFilterListenerMatchFilterMatch(fluent.getName(), fluent.buildSubFilter());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}