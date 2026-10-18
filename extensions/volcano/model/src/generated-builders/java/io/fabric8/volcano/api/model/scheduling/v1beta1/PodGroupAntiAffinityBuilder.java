package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupAntiAffinityBuilder extends PodGroupAntiAffinityFluent<PodGroupAntiAffinityBuilder> implements VisitableBuilder<PodGroupAntiAffinity,PodGroupAntiAffinityBuilder>{

  PodGroupAntiAffinityFluent<?> fluent;

  public PodGroupAntiAffinityBuilder() {
    this(new PodGroupAntiAffinity());
  }
  
  public PodGroupAntiAffinityBuilder(PodGroupAntiAffinityFluent<?> fluent) {
    this(fluent, new PodGroupAntiAffinity());
  }
  
  public PodGroupAntiAffinityBuilder(PodGroupAntiAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupAntiAffinityBuilder(PodGroupAntiAffinityFluent<?> fluent,PodGroupAntiAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupAntiAffinity build() {
    PodGroupAntiAffinity buildable = new PodGroupAntiAffinity(fluent.buildPreferred(), fluent.buildRequired());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}