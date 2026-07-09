package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupBuilder extends PodGroupFluent<PodGroupBuilder> implements VisitableBuilder<PodGroup,PodGroupBuilder>{

  PodGroupFluent<?> fluent;

  public PodGroupBuilder() {
    this(new PodGroup());
  }
  
  public PodGroupBuilder(PodGroupFluent<?> fluent) {
    this(fluent, new PodGroup());
  }
  
  public PodGroupBuilder(PodGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupBuilder(PodGroupFluent<?> fluent,PodGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroup build() {
    PodGroup buildable = new PodGroup(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}