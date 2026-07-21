package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StringMatchPrefixBuilder extends StringMatchPrefixFluent<StringMatchPrefixBuilder> implements VisitableBuilder<StringMatchPrefix,StringMatchPrefixBuilder>{

  StringMatchPrefixFluent<?> fluent;

  public StringMatchPrefixBuilder() {
    this(new StringMatchPrefix());
  }
  
  public StringMatchPrefixBuilder(StringMatchPrefixFluent<?> fluent) {
    this(fluent, new StringMatchPrefix());
  }
  
  public StringMatchPrefixBuilder(StringMatchPrefix instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StringMatchPrefixBuilder(StringMatchPrefixFluent<?> fluent,StringMatchPrefix instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StringMatchPrefix build() {
    StringMatchPrefix buildable = new StringMatchPrefix(fluent.getPrefix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}