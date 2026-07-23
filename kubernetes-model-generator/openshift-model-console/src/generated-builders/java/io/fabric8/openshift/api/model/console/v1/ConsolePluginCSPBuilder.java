package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginCSPBuilder extends ConsolePluginCSPFluent<ConsolePluginCSPBuilder> implements VisitableBuilder<ConsolePluginCSP,ConsolePluginCSPBuilder>{

  ConsolePluginCSPFluent<?> fluent;

  public ConsolePluginCSPBuilder() {
    this(new ConsolePluginCSP());
  }
  
  public ConsolePluginCSPBuilder(ConsolePluginCSPFluent<?> fluent) {
    this(fluent, new ConsolePluginCSP());
  }
  
  public ConsolePluginCSPBuilder(ConsolePluginCSP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginCSPBuilder(ConsolePluginCSPFluent<?> fluent,ConsolePluginCSP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginCSP build() {
    ConsolePluginCSP buildable = new ConsolePluginCSP(fluent.getDirective(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}