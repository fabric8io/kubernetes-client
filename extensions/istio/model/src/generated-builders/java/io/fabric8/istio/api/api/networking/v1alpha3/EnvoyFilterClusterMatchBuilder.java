package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterClusterMatchBuilder extends EnvoyFilterClusterMatchFluent<EnvoyFilterClusterMatchBuilder> implements VisitableBuilder<EnvoyFilterClusterMatch,EnvoyFilterClusterMatchBuilder>{

  EnvoyFilterClusterMatchFluent<?> fluent;

  public EnvoyFilterClusterMatchBuilder() {
    this(new EnvoyFilterClusterMatch());
  }
  
  public EnvoyFilterClusterMatchBuilder(EnvoyFilterClusterMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterClusterMatch());
  }
  
  public EnvoyFilterClusterMatchBuilder(EnvoyFilterClusterMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterClusterMatchBuilder(EnvoyFilterClusterMatchFluent<?> fluent,EnvoyFilterClusterMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterClusterMatch build() {
    EnvoyFilterClusterMatch buildable = new EnvoyFilterClusterMatch(fluent.getName(), fluent.getPortNumber(), fluent.getService(), fluent.getSubset());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}