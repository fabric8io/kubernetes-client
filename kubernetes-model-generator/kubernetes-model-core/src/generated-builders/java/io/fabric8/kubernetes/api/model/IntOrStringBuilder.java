package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntOrStringBuilder extends IntOrStringFluent<IntOrStringBuilder> implements VisitableBuilder<IntOrString,IntOrStringBuilder>{

  IntOrStringFluent<?> fluent;

  public IntOrStringBuilder() {
    this(new IntOrString());
  }
  
  public IntOrStringBuilder(IntOrStringFluent<?> fluent) {
    this(fluent, new IntOrString());
  }
  
  public IntOrStringBuilder(IntOrString instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntOrStringBuilder(IntOrStringFluent<?> fluent,IntOrString instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntOrString build() {
    IntOrString buildable = new IntOrString(fluent.getValue());
    return buildable;
  }
  
}