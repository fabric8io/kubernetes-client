package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StringMatchExactBuilder extends StringMatchExactFluent<StringMatchExactBuilder> implements VisitableBuilder<StringMatchExact,StringMatchExactBuilder>{

  StringMatchExactFluent<?> fluent;

  public StringMatchExactBuilder() {
    this(new StringMatchExact());
  }
  
  public StringMatchExactBuilder(StringMatchExactFluent<?> fluent) {
    this(fluent, new StringMatchExact());
  }
  
  public StringMatchExactBuilder(StringMatchExact instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StringMatchExactBuilder(StringMatchExactFluent<?> fluent,StringMatchExact instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StringMatchExact build() {
    StringMatchExact buildable = new StringMatchExact(fluent.getExact());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}