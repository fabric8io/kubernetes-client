package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleExternalLogLinkListBuilder extends ConsoleExternalLogLinkListFluent<ConsoleExternalLogLinkListBuilder> implements VisitableBuilder<ConsoleExternalLogLinkList,ConsoleExternalLogLinkListBuilder>{

  ConsoleExternalLogLinkListFluent<?> fluent;

  public ConsoleExternalLogLinkListBuilder() {
    this(new ConsoleExternalLogLinkList());
  }
  
  public ConsoleExternalLogLinkListBuilder(ConsoleExternalLogLinkListFluent<?> fluent) {
    this(fluent, new ConsoleExternalLogLinkList());
  }
  
  public ConsoleExternalLogLinkListBuilder(ConsoleExternalLogLinkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleExternalLogLinkListBuilder(ConsoleExternalLogLinkListFluent<?> fluent,ConsoleExternalLogLinkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleExternalLogLinkList build() {
    ConsoleExternalLogLinkList buildable = new ConsoleExternalLogLinkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}