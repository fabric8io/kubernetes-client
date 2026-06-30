package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QuantityBuilder extends QuantityFluent<QuantityBuilder> implements VisitableBuilder<Quantity,QuantityBuilder>{

  QuantityFluent<?> fluent;

  public QuantityBuilder() {
    this(new Quantity());
  }
  
  public QuantityBuilder(QuantityFluent<?> fluent) {
    this(fluent, new Quantity());
  }
  
  public QuantityBuilder(Quantity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QuantityBuilder(QuantityFluent<?> fluent,Quantity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Quantity build() {
    Quantity buildable = new Quantity(fluent.getAmount());
    buildable.setFormat(fluent.getFormat());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}