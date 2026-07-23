package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TunedMatchBuilder extends TunedMatchFluent<TunedMatchBuilder> implements VisitableBuilder<TunedMatch,TunedMatchBuilder>{

  TunedMatchFluent<?> fluent;

  public TunedMatchBuilder() {
    this(new TunedMatch());
  }
  
  public TunedMatchBuilder(TunedMatchFluent<?> fluent) {
    this(fluent, new TunedMatch());
  }
  
  public TunedMatchBuilder(TunedMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TunedMatchBuilder(TunedMatchFluent<?> fluent,TunedMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TunedMatch build() {
    TunedMatch buildable = new TunedMatch(fluent.getLabel(), fluent.buildMatch(), fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}