package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Route53AuthBuilder extends Route53AuthFluent<Route53AuthBuilder> implements VisitableBuilder<Route53Auth,Route53AuthBuilder>{

  Route53AuthFluent<?> fluent;

  public Route53AuthBuilder() {
    this(new Route53Auth());
  }
  
  public Route53AuthBuilder(Route53AuthFluent<?> fluent) {
    this(fluent, new Route53Auth());
  }
  
  public Route53AuthBuilder(Route53Auth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Route53AuthBuilder(Route53AuthFluent<?> fluent,Route53Auth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Route53Auth build() {
    Route53Auth buildable = new Route53Auth(fluent.buildKubernetes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}