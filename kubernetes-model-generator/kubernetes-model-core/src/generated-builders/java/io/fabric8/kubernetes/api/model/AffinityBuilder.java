package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AffinityBuilder extends AffinityFluent<AffinityBuilder> implements VisitableBuilder<Affinity,AffinityBuilder>{

  AffinityFluent<?> fluent;

  public AffinityBuilder() {
    this(new Affinity());
  }
  
  public AffinityBuilder(AffinityFluent<?> fluent) {
    this(fluent, new Affinity());
  }
  
  public AffinityBuilder(Affinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AffinityBuilder(AffinityFluent<?> fluent,Affinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Affinity build() {
    Affinity buildable = new Affinity(fluent.buildNodeAffinity(), fluent.buildPodAffinity(), fluent.buildPodAntiAffinity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}