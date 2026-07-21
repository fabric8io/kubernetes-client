package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder extends EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent<EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder> implements VisitableBuilder<EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration,EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder>{

  EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent<?> fluent;

  public EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder() {
    this(new EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder(EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent<?> fluent) {
    this(fluent, new EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder(EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationBuilder(EnvoyFilterEnvoyConfigObjectMatchRouteConfigurationFluent<?> fluent,EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration build() {
    EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration buildable = new EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration(fluent.buildRouteConfiguration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}