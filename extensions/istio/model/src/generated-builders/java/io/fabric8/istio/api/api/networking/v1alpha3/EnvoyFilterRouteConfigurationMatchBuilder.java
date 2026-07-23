package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterRouteConfigurationMatchBuilder extends EnvoyFilterRouteConfigurationMatchFluent<EnvoyFilterRouteConfigurationMatchBuilder> implements VisitableBuilder<EnvoyFilterRouteConfigurationMatch,EnvoyFilterRouteConfigurationMatchBuilder>{

  EnvoyFilterRouteConfigurationMatchFluent<?> fluent;

  public EnvoyFilterRouteConfigurationMatchBuilder() {
    this(new EnvoyFilterRouteConfigurationMatch());
  }
  
  public EnvoyFilterRouteConfigurationMatchBuilder(EnvoyFilterRouteConfigurationMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterRouteConfigurationMatch());
  }
  
  public EnvoyFilterRouteConfigurationMatchBuilder(EnvoyFilterRouteConfigurationMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterRouteConfigurationMatchBuilder(EnvoyFilterRouteConfigurationMatchFluent<?> fluent,EnvoyFilterRouteConfigurationMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterRouteConfigurationMatch build() {
    EnvoyFilterRouteConfigurationMatch buildable = new EnvoyFilterRouteConfigurationMatch(fluent.getGateway(), fluent.getName(), fluent.getPortName(), fluent.getPortNumber(), fluent.buildVhost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}