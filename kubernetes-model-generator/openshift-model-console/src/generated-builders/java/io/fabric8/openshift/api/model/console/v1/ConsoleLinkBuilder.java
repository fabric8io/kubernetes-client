package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleLinkBuilder extends ConsoleLinkFluent<ConsoleLinkBuilder> implements VisitableBuilder<ConsoleLink,ConsoleLinkBuilder>{

  ConsoleLinkFluent<?> fluent;

  public ConsoleLinkBuilder() {
    this(new ConsoleLink());
  }
  
  public ConsoleLinkBuilder(ConsoleLinkFluent<?> fluent) {
    this(fluent, new ConsoleLink());
  }
  
  public ConsoleLinkBuilder(ConsoleLink instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleLinkBuilder(ConsoleLinkFluent<?> fluent,ConsoleLink instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleLink build() {
    ConsoleLink buildable = new ConsoleLink(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}