package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Route53KubernetesAuthBuilder extends Route53KubernetesAuthFluent<Route53KubernetesAuthBuilder> implements VisitableBuilder<Route53KubernetesAuth,Route53KubernetesAuthBuilder>{

  Route53KubernetesAuthFluent<?> fluent;

  public Route53KubernetesAuthBuilder() {
    this(new Route53KubernetesAuth());
  }
  
  public Route53KubernetesAuthBuilder(Route53KubernetesAuthFluent<?> fluent) {
    this(fluent, new Route53KubernetesAuth());
  }
  
  public Route53KubernetesAuthBuilder(Route53KubernetesAuth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Route53KubernetesAuthBuilder(Route53KubernetesAuthFluent<?> fluent,Route53KubernetesAuth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Route53KubernetesAuth build() {
    Route53KubernetesAuth buildable = new Route53KubernetesAuth(fluent.buildServiceAccountRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}