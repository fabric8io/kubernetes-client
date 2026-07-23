package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginSpecBuilder extends ConsolePluginSpecFluent<ConsolePluginSpecBuilder> implements VisitableBuilder<ConsolePluginSpec,ConsolePluginSpecBuilder>{

  ConsolePluginSpecFluent<?> fluent;

  public ConsolePluginSpecBuilder() {
    this(new ConsolePluginSpec());
  }
  
  public ConsolePluginSpecBuilder(ConsolePluginSpecFluent<?> fluent) {
    this(fluent, new ConsolePluginSpec());
  }
  
  public ConsolePluginSpecBuilder(ConsolePluginSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginSpecBuilder(ConsolePluginSpecFluent<?> fluent,ConsolePluginSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginSpec build() {
    ConsolePluginSpec buildable = new ConsolePluginSpec(fluent.buildBackend(), fluent.buildContentSecurityPolicy(), fluent.getDisplayName(), fluent.buildI18n(), fluent.buildProxy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}