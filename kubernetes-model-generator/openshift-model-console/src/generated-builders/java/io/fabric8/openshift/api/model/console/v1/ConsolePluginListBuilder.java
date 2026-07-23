package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsolePluginListBuilder extends ConsolePluginListFluent<ConsolePluginListBuilder> implements VisitableBuilder<ConsolePluginList,ConsolePluginListBuilder>{

  ConsolePluginListFluent<?> fluent;

  public ConsolePluginListBuilder() {
    this(new ConsolePluginList());
  }
  
  public ConsolePluginListBuilder(ConsolePluginListFluent<?> fluent) {
    this(fluent, new ConsolePluginList());
  }
  
  public ConsolePluginListBuilder(ConsolePluginList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsolePluginListBuilder(ConsolePluginListFluent<?> fluent,ConsolePluginList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsolePluginList build() {
    ConsolePluginList buildable = new ConsolePluginList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}