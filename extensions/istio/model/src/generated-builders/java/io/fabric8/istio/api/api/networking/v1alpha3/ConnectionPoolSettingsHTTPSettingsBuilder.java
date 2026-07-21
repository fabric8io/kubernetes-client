package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConnectionPoolSettingsHTTPSettingsBuilder extends ConnectionPoolSettingsHTTPSettingsFluent<ConnectionPoolSettingsHTTPSettingsBuilder> implements VisitableBuilder<ConnectionPoolSettingsHTTPSettings,ConnectionPoolSettingsHTTPSettingsBuilder>{

  ConnectionPoolSettingsHTTPSettingsFluent<?> fluent;

  public ConnectionPoolSettingsHTTPSettingsBuilder() {
    this(new ConnectionPoolSettingsHTTPSettings());
  }
  
  public ConnectionPoolSettingsHTTPSettingsBuilder(ConnectionPoolSettingsHTTPSettingsFluent<?> fluent) {
    this(fluent, new ConnectionPoolSettingsHTTPSettings());
  }
  
  public ConnectionPoolSettingsHTTPSettingsBuilder(ConnectionPoolSettingsHTTPSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConnectionPoolSettingsHTTPSettingsBuilder(ConnectionPoolSettingsHTTPSettingsFluent<?> fluent,ConnectionPoolSettingsHTTPSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConnectionPoolSettingsHTTPSettings build() {
    ConnectionPoolSettingsHTTPSettings buildable = new ConnectionPoolSettingsHTTPSettings(fluent.getH2UpgradePolicy(), fluent.getHttp1MaxPendingRequests(), fluent.getHttp2MaxRequests(), fluent.getIdleTimeout(), fluent.getMaxConcurrentStreams(), fluent.getMaxRequestsPerConnection(), fluent.getMaxRetries(), fluent.getUseClientProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}