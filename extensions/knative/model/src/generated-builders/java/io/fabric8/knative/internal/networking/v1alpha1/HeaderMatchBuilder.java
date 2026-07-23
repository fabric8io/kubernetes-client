package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HeaderMatchBuilder extends HeaderMatchFluent<HeaderMatchBuilder> implements VisitableBuilder<HeaderMatch,HeaderMatchBuilder>{

  HeaderMatchFluent<?> fluent;

  public HeaderMatchBuilder() {
    this(new HeaderMatch());
  }
  
  public HeaderMatchBuilder(HeaderMatchFluent<?> fluent) {
    this(fluent, new HeaderMatch());
  }
  
  public HeaderMatchBuilder(HeaderMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HeaderMatchBuilder(HeaderMatchFluent<?> fluent,HeaderMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HeaderMatch build() {
    HeaderMatch buildable = new HeaderMatch(fluent.getExact());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}