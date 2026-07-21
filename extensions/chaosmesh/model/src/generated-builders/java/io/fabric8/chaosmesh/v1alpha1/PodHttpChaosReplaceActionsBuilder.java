package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosReplaceActionsBuilder extends PodHttpChaosReplaceActionsFluent<PodHttpChaosReplaceActionsBuilder> implements VisitableBuilder<PodHttpChaosReplaceActions,PodHttpChaosReplaceActionsBuilder>{

  PodHttpChaosReplaceActionsFluent<?> fluent;

  public PodHttpChaosReplaceActionsBuilder() {
    this(new PodHttpChaosReplaceActions());
  }
  
  public PodHttpChaosReplaceActionsBuilder(PodHttpChaosReplaceActionsFluent<?> fluent) {
    this(fluent, new PodHttpChaosReplaceActions());
  }
  
  public PodHttpChaosReplaceActionsBuilder(PodHttpChaosReplaceActions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosReplaceActionsBuilder(PodHttpChaosReplaceActionsFluent<?> fluent,PodHttpChaosReplaceActions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosReplaceActions build() {
    PodHttpChaosReplaceActions buildable = new PodHttpChaosReplaceActions(fluent.getBody(), fluent.getCode(), fluent.getHeaders(), fluent.getMethod(), fluent.getPath(), fluent.getQueries());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}