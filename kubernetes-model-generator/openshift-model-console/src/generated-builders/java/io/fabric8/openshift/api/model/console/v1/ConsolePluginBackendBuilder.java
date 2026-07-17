package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginBackendBuilder extends ConsolePluginBackendFluent<ConsolePluginBackendBuilder> implements VisitableBuilder<ConsolePluginBackend,ConsolePluginBackendBuilder>{

  ConsolePluginBackendFluent<?> fluent;

  public ConsolePluginBackendBuilder() {
    this(new ConsolePluginBackend());
  }
  
  public ConsolePluginBackendBuilder(ConsolePluginBackendFluent<?> fluent) {
    this(fluent, new ConsolePluginBackend());
  }
  
  public ConsolePluginBackendBuilder(ConsolePluginBackend instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginBackendBuilder(ConsolePluginBackendFluent<?> fluent,ConsolePluginBackend instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginBackend build() {
    ConsolePluginBackend buildable = new ConsolePluginBackend(fluent.buildService(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}