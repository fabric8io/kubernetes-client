package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClientIPConfigBuilder extends ClientIPConfigFluent<ClientIPConfigBuilder> implements VisitableBuilder<ClientIPConfig,ClientIPConfigBuilder>{

  ClientIPConfigFluent<?> fluent;

  public ClientIPConfigBuilder() {
    this(new ClientIPConfig());
  }
  
  public ClientIPConfigBuilder(ClientIPConfigFluent<?> fluent) {
    this(fluent, new ClientIPConfig());
  }
  
  public ClientIPConfigBuilder(ClientIPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClientIPConfigBuilder(ClientIPConfigFluent<?> fluent,ClientIPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClientIPConfig build() {
    ClientIPConfig buildable = new ClientIPConfig(fluent.getTimeoutSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}