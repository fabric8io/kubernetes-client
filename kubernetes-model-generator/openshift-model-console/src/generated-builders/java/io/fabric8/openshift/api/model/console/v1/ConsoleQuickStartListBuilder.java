package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleQuickStartListBuilder extends ConsoleQuickStartListFluent<ConsoleQuickStartListBuilder> implements VisitableBuilder<ConsoleQuickStartList,ConsoleQuickStartListBuilder>{

  ConsoleQuickStartListFluent<?> fluent;

  public ConsoleQuickStartListBuilder() {
    this(new ConsoleQuickStartList());
  }
  
  public ConsoleQuickStartListBuilder(ConsoleQuickStartListFluent<?> fluent) {
    this(fluent, new ConsoleQuickStartList());
  }
  
  public ConsoleQuickStartListBuilder(ConsoleQuickStartList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleQuickStartListBuilder(ConsoleQuickStartListFluent<?> fluent,ConsoleQuickStartList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleQuickStartList build() {
    ConsoleQuickStartList buildable = new ConsoleQuickStartList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}