package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginServiceBuilder extends ConsolePluginServiceFluent<ConsolePluginServiceBuilder> implements VisitableBuilder<ConsolePluginService,ConsolePluginServiceBuilder>{

  ConsolePluginServiceFluent<?> fluent;

  public ConsolePluginServiceBuilder() {
    this(new ConsolePluginService());
  }
  
  public ConsolePluginServiceBuilder(ConsolePluginServiceFluent<?> fluent) {
    this(fluent, new ConsolePluginService());
  }
  
  public ConsolePluginServiceBuilder(ConsolePluginService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginServiceBuilder(ConsolePluginServiceFluent<?> fluent,ConsolePluginService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginService build() {
    ConsolePluginService buildable = new ConsolePluginService(fluent.getBasePath(), fluent.getName(), fluent.getNamespace(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}