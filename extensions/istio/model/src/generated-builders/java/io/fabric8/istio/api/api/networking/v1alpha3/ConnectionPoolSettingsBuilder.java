package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConnectionPoolSettingsBuilder extends ConnectionPoolSettingsFluent<ConnectionPoolSettingsBuilder> implements VisitableBuilder<ConnectionPoolSettings,ConnectionPoolSettingsBuilder>{

  ConnectionPoolSettingsFluent<?> fluent;

  public ConnectionPoolSettingsBuilder() {
    this(new ConnectionPoolSettings());
  }
  
  public ConnectionPoolSettingsBuilder(ConnectionPoolSettingsFluent<?> fluent) {
    this(fluent, new ConnectionPoolSettings());
  }
  
  public ConnectionPoolSettingsBuilder(ConnectionPoolSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConnectionPoolSettingsBuilder(ConnectionPoolSettingsFluent<?> fluent,ConnectionPoolSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConnectionPoolSettings build() {
    ConnectionPoolSettings buildable = new ConnectionPoolSettings(fluent.buildHttp(), fluent.buildTcp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}