package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerConfigurationBuilder extends ServerConfigurationFluent<ServerConfigurationBuilder> implements VisitableBuilder<ServerConfiguration,ServerConfigurationBuilder>{

  ServerConfigurationFluent<?> fluent;

  public ServerConfigurationBuilder() {
    this(new ServerConfiguration());
  }
  
  public ServerConfigurationBuilder(ServerConfigurationFluent<?> fluent) {
    this(fluent, new ServerConfiguration());
  }
  
  public ServerConfigurationBuilder(ServerConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerConfigurationBuilder(ServerConfigurationFluent<?> fluent,ServerConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerConfiguration build() {
    ServerConfiguration buildable = new ServerConfiguration(fluent.buildEndpointsExposure(), fluent.buildFeatureGates(), fluent.getImagePullSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}