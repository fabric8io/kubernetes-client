package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleListBuilder extends ConsoleListFluent<ConsoleListBuilder> implements VisitableBuilder<ConsoleList,ConsoleListBuilder>{

  ConsoleListFluent<?> fluent;

  public ConsoleListBuilder() {
    this(new ConsoleList());
  }
  
  public ConsoleListBuilder(ConsoleListFluent<?> fluent) {
    this(fluent, new ConsoleList());
  }
  
  public ConsoleListBuilder(ConsoleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleListBuilder(ConsoleListFluent<?> fluent,ConsoleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleList build() {
    ConsoleList buildable = new ConsoleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}