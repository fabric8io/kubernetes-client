package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodScalableListBuilder extends PodScalableListFluent<PodScalableListBuilder> implements VisitableBuilder<PodScalableList,PodScalableListBuilder>{

  PodScalableListFluent<?> fluent;

  public PodScalableListBuilder() {
    this(new PodScalableList());
  }
  
  public PodScalableListBuilder(PodScalableListFluent<?> fluent) {
    this(fluent, new PodScalableList());
  }
  
  public PodScalableListBuilder(PodScalableList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodScalableListBuilder(PodScalableListFluent<?> fluent,PodScalableList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodScalableList build() {
    PodScalableList buildable = new PodScalableList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}