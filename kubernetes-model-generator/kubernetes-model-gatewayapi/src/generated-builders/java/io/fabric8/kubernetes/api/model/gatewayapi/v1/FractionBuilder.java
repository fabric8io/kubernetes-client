package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FractionBuilder extends FractionFluent<FractionBuilder> implements VisitableBuilder<Fraction,FractionBuilder>{

  FractionFluent<?> fluent;

  public FractionBuilder() {
    this(new Fraction());
  }
  
  public FractionBuilder(FractionFluent<?> fluent) {
    this(fluent, new Fraction());
  }
  
  public FractionBuilder(Fraction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FractionBuilder(FractionFluent<?> fluent,Fraction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Fraction build() {
    Fraction buildable = new Fraction(fluent.getDenominator(), fluent.getNumerator());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}