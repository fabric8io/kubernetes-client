package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginProxyEndpointBuilder extends ConsolePluginProxyEndpointFluent<ConsolePluginProxyEndpointBuilder> implements VisitableBuilder<ConsolePluginProxyEndpoint,ConsolePluginProxyEndpointBuilder>{

  ConsolePluginProxyEndpointFluent<?> fluent;

  public ConsolePluginProxyEndpointBuilder() {
    this(new ConsolePluginProxyEndpoint());
  }
  
  public ConsolePluginProxyEndpointBuilder(ConsolePluginProxyEndpointFluent<?> fluent) {
    this(fluent, new ConsolePluginProxyEndpoint());
  }
  
  public ConsolePluginProxyEndpointBuilder(ConsolePluginProxyEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginProxyEndpointBuilder(ConsolePluginProxyEndpointFluent<?> fluent,ConsolePluginProxyEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginProxyEndpoint build() {
    ConsolePluginProxyEndpoint buildable = new ConsolePluginProxyEndpoint(fluent.buildService(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}