package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StringMatchBuilder extends StringMatchFluent<StringMatchBuilder> implements VisitableBuilder<StringMatch,StringMatchBuilder>{

  StringMatchFluent<?> fluent;

  public StringMatchBuilder() {
    this(new StringMatch());
  }
  
  public StringMatchBuilder(StringMatchFluent<?> fluent) {
    this(fluent, new StringMatch());
  }
  
  public StringMatchBuilder(StringMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StringMatchBuilder(StringMatchFluent<?> fluent,StringMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StringMatch build() {
    StringMatch buildable = new StringMatch(fluent.buildMatchType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}