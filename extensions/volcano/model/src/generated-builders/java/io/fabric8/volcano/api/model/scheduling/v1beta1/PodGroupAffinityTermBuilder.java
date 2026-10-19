package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupAffinityTermBuilder extends PodGroupAffinityTermFluent<PodGroupAffinityTermBuilder> implements VisitableBuilder<PodGroupAffinityTerm,PodGroupAffinityTermBuilder>{

  PodGroupAffinityTermFluent<?> fluent;

  public PodGroupAffinityTermBuilder() {
    this(new PodGroupAffinityTerm());
  }
  
  public PodGroupAffinityTermBuilder(PodGroupAffinityTermFluent<?> fluent) {
    this(fluent, new PodGroupAffinityTerm());
  }
  
  public PodGroupAffinityTermBuilder(PodGroupAffinityTerm instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupAffinityTermBuilder(PodGroupAffinityTermFluent<?> fluent,PodGroupAffinityTerm instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupAffinityTerm build() {
    PodGroupAffinityTerm buildable = new PodGroupAffinityTerm(fluent.buildNamespaceSelector(), fluent.buildPodGroupSelector(), fluent.getTopologyTier(), fluent.getTopologyTierName(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}