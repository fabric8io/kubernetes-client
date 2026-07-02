package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodAffinityTermBuilder extends PodAffinityTermFluent<PodAffinityTermBuilder> implements VisitableBuilder<PodAffinityTerm,PodAffinityTermBuilder>{

  PodAffinityTermFluent<?> fluent;

  public PodAffinityTermBuilder() {
    this(new PodAffinityTerm());
  }
  
  public PodAffinityTermBuilder(PodAffinityTermFluent<?> fluent) {
    this(fluent, new PodAffinityTerm());
  }
  
  public PodAffinityTermBuilder(PodAffinityTerm instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodAffinityTermBuilder(PodAffinityTermFluent<?> fluent,PodAffinityTerm instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodAffinityTerm build() {
    PodAffinityTerm buildable = new PodAffinityTerm(fluent.buildLabelSelector(), fluent.getMatchLabelKeys(), fluent.getMismatchLabelKeys(), fluent.buildNamespaceSelector(), fluent.getNamespaces(), fluent.getTopologyKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}