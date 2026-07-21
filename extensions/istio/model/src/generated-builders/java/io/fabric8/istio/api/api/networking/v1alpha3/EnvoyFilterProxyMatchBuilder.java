package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterProxyMatchBuilder extends EnvoyFilterProxyMatchFluent<EnvoyFilterProxyMatchBuilder> implements VisitableBuilder<EnvoyFilterProxyMatch,EnvoyFilterProxyMatchBuilder>{

  EnvoyFilterProxyMatchFluent<?> fluent;

  public EnvoyFilterProxyMatchBuilder() {
    this(new EnvoyFilterProxyMatch());
  }
  
  public EnvoyFilterProxyMatchBuilder(EnvoyFilterProxyMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterProxyMatch());
  }
  
  public EnvoyFilterProxyMatchBuilder(EnvoyFilterProxyMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterProxyMatchBuilder(EnvoyFilterProxyMatchFluent<?> fluent,EnvoyFilterProxyMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterProxyMatch build() {
    EnvoyFilterProxyMatch buildable = new EnvoyFilterProxyMatch(fluent.getMetadata(), fluent.getProxyVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}