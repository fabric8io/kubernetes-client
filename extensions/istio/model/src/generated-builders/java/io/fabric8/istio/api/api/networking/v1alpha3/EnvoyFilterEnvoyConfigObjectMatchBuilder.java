package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterEnvoyConfigObjectMatchBuilder extends EnvoyFilterEnvoyConfigObjectMatchFluent<EnvoyFilterEnvoyConfigObjectMatchBuilder> implements VisitableBuilder<EnvoyFilterEnvoyConfigObjectMatch,EnvoyFilterEnvoyConfigObjectMatchBuilder>{

  EnvoyFilterEnvoyConfigObjectMatchFluent<?> fluent;

  public EnvoyFilterEnvoyConfigObjectMatchBuilder() {
    this(new EnvoyFilterEnvoyConfigObjectMatch());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchBuilder(EnvoyFilterEnvoyConfigObjectMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterEnvoyConfigObjectMatch());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchBuilder(EnvoyFilterEnvoyConfigObjectMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchBuilder(EnvoyFilterEnvoyConfigObjectMatchFluent<?> fluent,EnvoyFilterEnvoyConfigObjectMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterEnvoyConfigObjectMatch build() {
    EnvoyFilterEnvoyConfigObjectMatch buildable = new EnvoyFilterEnvoyConfigObjectMatch(fluent.buildObjectTypes(), fluent.getContext(), fluent.buildProxy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}