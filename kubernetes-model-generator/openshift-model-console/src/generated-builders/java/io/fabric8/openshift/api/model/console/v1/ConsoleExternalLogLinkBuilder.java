package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleExternalLogLinkBuilder extends ConsoleExternalLogLinkFluent<ConsoleExternalLogLinkBuilder> implements VisitableBuilder<ConsoleExternalLogLink,ConsoleExternalLogLinkBuilder>{

  ConsoleExternalLogLinkFluent<?> fluent;

  public ConsoleExternalLogLinkBuilder() {
    this(new ConsoleExternalLogLink());
  }
  
  public ConsoleExternalLogLinkBuilder(ConsoleExternalLogLinkFluent<?> fluent) {
    this(fluent, new ConsoleExternalLogLink());
  }
  
  public ConsoleExternalLogLinkBuilder(ConsoleExternalLogLink instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleExternalLogLinkBuilder(ConsoleExternalLogLinkFluent<?> fluent,ConsoleExternalLogLink instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleExternalLogLink build() {
    ConsoleExternalLogLink buildable = new ConsoleExternalLogLink(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}