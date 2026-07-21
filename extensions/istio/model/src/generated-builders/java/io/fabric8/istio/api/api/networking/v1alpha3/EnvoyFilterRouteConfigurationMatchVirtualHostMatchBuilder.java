package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder extends EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent<EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder> implements VisitableBuilder<EnvoyFilterRouteConfigurationMatchVirtualHostMatch,EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder>{

  EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent<?> fluent;

  public EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder() {
    this(new EnvoyFilterRouteConfigurationMatchVirtualHostMatch());
  }
  
  public EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder(EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterRouteConfigurationMatchVirtualHostMatch());
  }
  
  public EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder(EnvoyFilterRouteConfigurationMatchVirtualHostMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder(EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent<?> fluent,EnvoyFilterRouteConfigurationMatchVirtualHostMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterRouteConfigurationMatchVirtualHostMatch build() {
    EnvoyFilterRouteConfigurationMatchVirtualHostMatch buildable = new EnvoyFilterRouteConfigurationMatchVirtualHostMatch(fluent.getDomainName(), fluent.getName(), fluent.buildRoute());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}