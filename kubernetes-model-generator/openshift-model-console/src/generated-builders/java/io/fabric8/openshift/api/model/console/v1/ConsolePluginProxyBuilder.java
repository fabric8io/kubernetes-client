package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginProxyBuilder extends ConsolePluginProxyFluent<ConsolePluginProxyBuilder> implements VisitableBuilder<ConsolePluginProxy,ConsolePluginProxyBuilder>{

  ConsolePluginProxyFluent<?> fluent;

  public ConsolePluginProxyBuilder() {
    this(new ConsolePluginProxy());
  }
  
  public ConsolePluginProxyBuilder(ConsolePluginProxyFluent<?> fluent) {
    this(fluent, new ConsolePluginProxy());
  }
  
  public ConsolePluginProxyBuilder(ConsolePluginProxy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginProxyBuilder(ConsolePluginProxyFluent<?> fluent,ConsolePluginProxy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginProxy build() {
    ConsolePluginProxy buildable = new ConsolePluginProxy(fluent.getAlias(), fluent.getAuthorization(), fluent.getCaCertificate(), fluent.buildEndpoint());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}