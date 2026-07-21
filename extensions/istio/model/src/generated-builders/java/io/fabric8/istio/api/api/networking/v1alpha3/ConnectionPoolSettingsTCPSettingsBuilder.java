package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConnectionPoolSettingsTCPSettingsBuilder extends ConnectionPoolSettingsTCPSettingsFluent<ConnectionPoolSettingsTCPSettingsBuilder> implements VisitableBuilder<ConnectionPoolSettingsTCPSettings,ConnectionPoolSettingsTCPSettingsBuilder>{

  ConnectionPoolSettingsTCPSettingsFluent<?> fluent;

  public ConnectionPoolSettingsTCPSettingsBuilder() {
    this(new ConnectionPoolSettingsTCPSettings());
  }
  
  public ConnectionPoolSettingsTCPSettingsBuilder(ConnectionPoolSettingsTCPSettingsFluent<?> fluent) {
    this(fluent, new ConnectionPoolSettingsTCPSettings());
  }
  
  public ConnectionPoolSettingsTCPSettingsBuilder(ConnectionPoolSettingsTCPSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConnectionPoolSettingsTCPSettingsBuilder(ConnectionPoolSettingsTCPSettingsFluent<?> fluent,ConnectionPoolSettingsTCPSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConnectionPoolSettingsTCPSettings build() {
    ConnectionPoolSettingsTCPSettings buildable = new ConnectionPoolSettingsTCPSettings(fluent.getConnectTimeout(), fluent.getIdleTimeout(), fluent.getMaxConnectionDuration(), fluent.getMaxConnections(), fluent.buildTcpKeepalive());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}