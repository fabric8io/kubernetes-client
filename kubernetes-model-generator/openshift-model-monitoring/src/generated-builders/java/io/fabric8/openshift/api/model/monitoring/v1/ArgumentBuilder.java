package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ArgumentBuilder extends ArgumentFluent<ArgumentBuilder> implements VisitableBuilder<Argument,ArgumentBuilder>{

  ArgumentFluent<?> fluent;

  public ArgumentBuilder() {
    this(new Argument());
  }
  
  public ArgumentBuilder(ArgumentFluent<?> fluent) {
    this(fluent, new Argument());
  }
  
  public ArgumentBuilder(Argument instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ArgumentBuilder(ArgumentFluent<?> fluent,Argument instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Argument build() {
    Argument buildable = new Argument(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}