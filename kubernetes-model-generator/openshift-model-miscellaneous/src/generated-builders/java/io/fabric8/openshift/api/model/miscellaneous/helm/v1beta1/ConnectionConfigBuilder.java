package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConnectionConfigBuilder extends ConnectionConfigFluent<ConnectionConfigBuilder> implements VisitableBuilder<ConnectionConfig,ConnectionConfigBuilder>{

  ConnectionConfigFluent<?> fluent;

  public ConnectionConfigBuilder() {
    this(new ConnectionConfig());
  }
  
  public ConnectionConfigBuilder(ConnectionConfigFluent<?> fluent) {
    this(fluent, new ConnectionConfig());
  }
  
  public ConnectionConfigBuilder(ConnectionConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConnectionConfigBuilder(ConnectionConfigFluent<?> fluent,ConnectionConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConnectionConfig build() {
    ConnectionConfig buildable = new ConnectionConfig(fluent.getCa(), fluent.getTlsClientConfig(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}