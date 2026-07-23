package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginI18nBuilder extends ConsolePluginI18nFluent<ConsolePluginI18nBuilder> implements VisitableBuilder<ConsolePluginI18n,ConsolePluginI18nBuilder>{

  ConsolePluginI18nFluent<?> fluent;

  public ConsolePluginI18nBuilder() {
    this(new ConsolePluginI18n());
  }
  
  public ConsolePluginI18nBuilder(ConsolePluginI18nFluent<?> fluent) {
    this(fluent, new ConsolePluginI18n());
  }
  
  public ConsolePluginI18nBuilder(ConsolePluginI18n instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginI18nBuilder(ConsolePluginI18nFluent<?> fluent,ConsolePluginI18n instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginI18n build() {
    ConsolePluginI18n buildable = new ConsolePluginI18n(fluent.getLoadType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}