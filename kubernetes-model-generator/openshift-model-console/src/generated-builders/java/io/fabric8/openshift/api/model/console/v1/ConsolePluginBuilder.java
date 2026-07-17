package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginBuilder extends ConsolePluginFluent<ConsolePluginBuilder> implements VisitableBuilder<ConsolePlugin,ConsolePluginBuilder>{

  ConsolePluginFluent<?> fluent;

  public ConsolePluginBuilder() {
    this(new ConsolePlugin());
  }
  
  public ConsolePluginBuilder(ConsolePluginFluent<?> fluent) {
    this(fluent, new ConsolePlugin());
  }
  
  public ConsolePluginBuilder(ConsolePlugin instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginBuilder(ConsolePluginFluent<?> fluent,ConsolePlugin instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePlugin build() {
    ConsolePlugin buildable = new ConsolePlugin(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}