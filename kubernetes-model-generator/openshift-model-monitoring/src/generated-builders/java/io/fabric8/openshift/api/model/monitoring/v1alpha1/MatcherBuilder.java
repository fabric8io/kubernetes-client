package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MatcherBuilder extends MatcherFluent<MatcherBuilder> implements VisitableBuilder<Matcher,MatcherBuilder>{

  MatcherFluent<?> fluent;

  public MatcherBuilder() {
    this(new Matcher());
  }
  
  public MatcherBuilder(MatcherFluent<?> fluent) {
    this(fluent, new Matcher());
  }
  
  public MatcherBuilder(Matcher instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MatcherBuilder(MatcherFluent<?> fluent,Matcher instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Matcher build() {
    Matcher buildable = new Matcher(fluent.getMatchType(), fluent.getName(), fluent.getRegex(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}