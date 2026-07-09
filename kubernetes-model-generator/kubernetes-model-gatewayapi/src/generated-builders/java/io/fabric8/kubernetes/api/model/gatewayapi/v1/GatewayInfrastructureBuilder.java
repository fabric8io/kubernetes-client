package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatewayInfrastructureBuilder extends GatewayInfrastructureFluent<GatewayInfrastructureBuilder> implements VisitableBuilder<GatewayInfrastructure,GatewayInfrastructureBuilder>{

  GatewayInfrastructureFluent<?> fluent;

  public GatewayInfrastructureBuilder() {
    this(new GatewayInfrastructure());
  }
  
  public GatewayInfrastructureBuilder(GatewayInfrastructureFluent<?> fluent) {
    this(fluent, new GatewayInfrastructure());
  }
  
  public GatewayInfrastructureBuilder(GatewayInfrastructure instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatewayInfrastructureBuilder(GatewayInfrastructureFluent<?> fluent,GatewayInfrastructure instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatewayInfrastructure build() {
    GatewayInfrastructure buildable = new GatewayInfrastructure(fluent.getAnnotations(), fluent.getLabels(), fluent.buildParametersRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}