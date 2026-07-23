package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WeightedPodAffinityTermBuilder extends WeightedPodAffinityTermFluent<WeightedPodAffinityTermBuilder> implements VisitableBuilder<WeightedPodAffinityTerm,WeightedPodAffinityTermBuilder>{

  WeightedPodAffinityTermFluent<?> fluent;

  public WeightedPodAffinityTermBuilder() {
    this(new WeightedPodAffinityTerm());
  }
  
  public WeightedPodAffinityTermBuilder(WeightedPodAffinityTermFluent<?> fluent) {
    this(fluent, new WeightedPodAffinityTerm());
  }
  
  public WeightedPodAffinityTermBuilder(WeightedPodAffinityTerm instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WeightedPodAffinityTermBuilder(WeightedPodAffinityTermFluent<?> fluent,WeightedPodAffinityTerm instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WeightedPodAffinityTerm build() {
    WeightedPodAffinityTerm buildable = new WeightedPodAffinityTerm(fluent.buildPodAffinityTerm(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}