package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveBuilder extends ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveFluent<ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveBuilder> implements VisitableBuilder<ConnectionPoolSettingsHTTPSettingsConnectionKeepalive,ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveBuilder>{

  ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveFluent<?> fluent;

  public ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveBuilder() {
    this(new ConnectionPoolSettingsHTTPSettingsConnectionKeepalive());
  }
  
  public ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveBuilder(ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveFluent<?> fluent) {
    this(fluent, new ConnectionPoolSettingsHTTPSettingsConnectionKeepalive());
  }
  
  public ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveBuilder(ConnectionPoolSettingsHTTPSettingsConnectionKeepalive instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveBuilder(ConnectionPoolSettingsHTTPSettingsConnectionKeepaliveFluent<?> fluent,ConnectionPoolSettingsHTTPSettingsConnectionKeepalive instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConnectionPoolSettingsHTTPSettingsConnectionKeepalive build() {
    ConnectionPoolSettingsHTTPSettingsConnectionKeepalive buildable = new ConnectionPoolSettingsHTTPSettingsConnectionKeepalive(fluent.getInterval(), fluent.getTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}