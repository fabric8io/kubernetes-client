package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder extends ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent<ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder> implements VisitableBuilder<ConnectionPoolSettingsTCPSettingsTcpKeepalive,ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder>{

  ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent<?> fluent;

  public ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder() {
    this(new ConnectionPoolSettingsTCPSettingsTcpKeepalive());
  }
  
  public ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder(ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent<?> fluent) {
    this(fluent, new ConnectionPoolSettingsTCPSettingsTcpKeepalive());
  }
  
  public ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder(ConnectionPoolSettingsTCPSettingsTcpKeepalive instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConnectionPoolSettingsTCPSettingsTcpKeepaliveBuilder(ConnectionPoolSettingsTCPSettingsTcpKeepaliveFluent<?> fluent,ConnectionPoolSettingsTCPSettingsTcpKeepalive instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConnectionPoolSettingsTCPSettingsTcpKeepalive build() {
    ConnectionPoolSettingsTCPSettingsTcpKeepalive buildable = new ConnectionPoolSettingsTCPSettingsTcpKeepalive(fluent.getInterval(), fluent.getProbes(), fluent.getTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}