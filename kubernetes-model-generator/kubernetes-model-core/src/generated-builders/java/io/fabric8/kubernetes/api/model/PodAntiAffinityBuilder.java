package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodAntiAffinityBuilder extends PodAntiAffinityFluent<PodAntiAffinityBuilder> implements VisitableBuilder<PodAntiAffinity,PodAntiAffinityBuilder>{

  PodAntiAffinityFluent<?> fluent;

  public PodAntiAffinityBuilder() {
    this(new PodAntiAffinity());
  }
  
  public PodAntiAffinityBuilder(PodAntiAffinityFluent<?> fluent) {
    this(fluent, new PodAntiAffinity());
  }
  
  public PodAntiAffinityBuilder(PodAntiAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodAntiAffinityBuilder(PodAntiAffinityFluent<?> fluent,PodAntiAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodAntiAffinity build() {
    PodAntiAffinity buildable = new PodAntiAffinity(fluent.buildPreferredDuringSchedulingIgnoredDuringExecution(), fluent.buildRequiredDuringSchedulingIgnoredDuringExecution());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}