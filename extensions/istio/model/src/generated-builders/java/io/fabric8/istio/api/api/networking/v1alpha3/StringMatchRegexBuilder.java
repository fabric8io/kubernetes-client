package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StringMatchRegexBuilder extends StringMatchRegexFluent<StringMatchRegexBuilder> implements VisitableBuilder<StringMatchRegex,StringMatchRegexBuilder>{

  StringMatchRegexFluent<?> fluent;

  public StringMatchRegexBuilder() {
    this(new StringMatchRegex());
  }
  
  public StringMatchRegexBuilder(StringMatchRegexFluent<?> fluent) {
    this(fluent, new StringMatchRegex());
  }
  
  public StringMatchRegexBuilder(StringMatchRegex instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StringMatchRegexBuilder(StringMatchRegexFluent<?> fluent,StringMatchRegex instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StringMatchRegex build() {
    StringMatchRegex buildable = new StringMatchRegex(fluent.getRegex());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}