package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodAffinityBuilder extends PodAffinityFluent<PodAffinityBuilder> implements VisitableBuilder<PodAffinity,PodAffinityBuilder>{

  PodAffinityFluent<?> fluent;

  public PodAffinityBuilder() {
    this(new PodAffinity());
  }
  
  public PodAffinityBuilder(PodAffinityFluent<?> fluent) {
    this(fluent, new PodAffinity());
  }
  
  public PodAffinityBuilder(PodAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodAffinityBuilder(PodAffinityFluent<?> fluent,PodAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodAffinity build() {
    PodAffinity buildable = new PodAffinity(fluent.buildPreferredDuringSchedulingIgnoredDuringExecution(), fluent.buildRequiredDuringSchedulingIgnoredDuringExecution());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}