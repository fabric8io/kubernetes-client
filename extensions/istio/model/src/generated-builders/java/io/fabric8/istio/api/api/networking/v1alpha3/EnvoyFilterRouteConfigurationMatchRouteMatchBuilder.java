package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterRouteConfigurationMatchRouteMatchBuilder extends EnvoyFilterRouteConfigurationMatchRouteMatchFluent<EnvoyFilterRouteConfigurationMatchRouteMatchBuilder> implements VisitableBuilder<EnvoyFilterRouteConfigurationMatchRouteMatch,EnvoyFilterRouteConfigurationMatchRouteMatchBuilder>{

  EnvoyFilterRouteConfigurationMatchRouteMatchFluent<?> fluent;

  public EnvoyFilterRouteConfigurationMatchRouteMatchBuilder() {
    this(new EnvoyFilterRouteConfigurationMatchRouteMatch());
  }
  
  public EnvoyFilterRouteConfigurationMatchRouteMatchBuilder(EnvoyFilterRouteConfigurationMatchRouteMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterRouteConfigurationMatchRouteMatch());
  }
  
  public EnvoyFilterRouteConfigurationMatchRouteMatchBuilder(EnvoyFilterRouteConfigurationMatchRouteMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterRouteConfigurationMatchRouteMatchBuilder(EnvoyFilterRouteConfigurationMatchRouteMatchFluent<?> fluent,EnvoyFilterRouteConfigurationMatchRouteMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterRouteConfigurationMatchRouteMatch build() {
    EnvoyFilterRouteConfigurationMatchRouteMatch buildable = new EnvoyFilterRouteConfigurationMatchRouteMatch(fluent.getAction(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}