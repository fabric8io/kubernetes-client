package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosPatchActionsBuilder extends PodHttpChaosPatchActionsFluent<PodHttpChaosPatchActionsBuilder> implements VisitableBuilder<PodHttpChaosPatchActions,PodHttpChaosPatchActionsBuilder>{

  PodHttpChaosPatchActionsFluent<?> fluent;

  public PodHttpChaosPatchActionsBuilder() {
    this(new PodHttpChaosPatchActions());
  }
  
  public PodHttpChaosPatchActionsBuilder(PodHttpChaosPatchActionsFluent<?> fluent) {
    this(fluent, new PodHttpChaosPatchActions());
  }
  
  public PodHttpChaosPatchActionsBuilder(PodHttpChaosPatchActions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosPatchActionsBuilder(PodHttpChaosPatchActionsFluent<?> fluent,PodHttpChaosPatchActions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosPatchActions build() {
    PodHttpChaosPatchActions buildable = new PodHttpChaosPatchActions(fluent.buildBody(), fluent.getHeaders(), fluent.getQueries());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}