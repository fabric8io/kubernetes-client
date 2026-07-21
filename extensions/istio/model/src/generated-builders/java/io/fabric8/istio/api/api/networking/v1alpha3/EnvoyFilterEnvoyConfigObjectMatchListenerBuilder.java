package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterEnvoyConfigObjectMatchListenerBuilder extends EnvoyFilterEnvoyConfigObjectMatchListenerFluent<EnvoyFilterEnvoyConfigObjectMatchListenerBuilder> implements VisitableBuilder<EnvoyFilterEnvoyConfigObjectMatchListener,EnvoyFilterEnvoyConfigObjectMatchListenerBuilder>{

  EnvoyFilterEnvoyConfigObjectMatchListenerFluent<?> fluent;

  public EnvoyFilterEnvoyConfigObjectMatchListenerBuilder() {
    this(new EnvoyFilterEnvoyConfigObjectMatchListener());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchListenerBuilder(EnvoyFilterEnvoyConfigObjectMatchListenerFluent<?> fluent) {
    this(fluent, new EnvoyFilterEnvoyConfigObjectMatchListener());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchListenerBuilder(EnvoyFilterEnvoyConfigObjectMatchListener instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchListenerBuilder(EnvoyFilterEnvoyConfigObjectMatchListenerFluent<?> fluent,EnvoyFilterEnvoyConfigObjectMatchListener instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterEnvoyConfigObjectMatchListener build() {
    EnvoyFilterEnvoyConfigObjectMatchListener buildable = new EnvoyFilterEnvoyConfigObjectMatchListener(fluent.buildListener());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}