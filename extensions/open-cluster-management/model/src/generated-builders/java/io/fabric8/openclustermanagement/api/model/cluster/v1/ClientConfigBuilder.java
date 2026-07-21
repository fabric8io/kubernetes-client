package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClientConfigBuilder extends ClientConfigFluent<ClientConfigBuilder> implements VisitableBuilder<ClientConfig,ClientConfigBuilder>{

  ClientConfigFluent<?> fluent;

  public ClientConfigBuilder() {
    this(new ClientConfig());
  }
  
  public ClientConfigBuilder(ClientConfigFluent<?> fluent) {
    this(fluent, new ClientConfig());
  }
  
  public ClientConfigBuilder(ClientConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClientConfigBuilder(ClientConfigFluent<?> fluent,ClientConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClientConfig build() {
    ClientConfig buildable = new ClientConfig(fluent.getCaBundle(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}