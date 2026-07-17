package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginProxyServiceConfigBuilder extends ConsolePluginProxyServiceConfigFluent<ConsolePluginProxyServiceConfigBuilder> implements VisitableBuilder<ConsolePluginProxyServiceConfig,ConsolePluginProxyServiceConfigBuilder>{

  ConsolePluginProxyServiceConfigFluent<?> fluent;

  public ConsolePluginProxyServiceConfigBuilder() {
    this(new ConsolePluginProxyServiceConfig());
  }
  
  public ConsolePluginProxyServiceConfigBuilder(ConsolePluginProxyServiceConfigFluent<?> fluent) {
    this(fluent, new ConsolePluginProxyServiceConfig());
  }
  
  public ConsolePluginProxyServiceConfigBuilder(ConsolePluginProxyServiceConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginProxyServiceConfigBuilder(ConsolePluginProxyServiceConfigFluent<?> fluent,ConsolePluginProxyServiceConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginProxyServiceConfig build() {
    ConsolePluginProxyServiceConfig buildable = new ConsolePluginProxyServiceConfig(fluent.getName(), fluent.getNamespace(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}