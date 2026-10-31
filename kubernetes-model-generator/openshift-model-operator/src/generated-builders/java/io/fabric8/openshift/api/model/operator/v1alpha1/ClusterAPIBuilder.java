package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPIBuilder extends ClusterAPIFluent<ClusterAPIBuilder> implements VisitableBuilder<ClusterAPI,ClusterAPIBuilder>{

  ClusterAPIFluent<?> fluent;

  public ClusterAPIBuilder() {
    this(new ClusterAPI());
  }
  
  public ClusterAPIBuilder(ClusterAPIFluent<?> fluent) {
    this(fluent, new ClusterAPI());
  }
  
  public ClusterAPIBuilder(ClusterAPI instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPIBuilder(ClusterAPIFluent<?> fluent,ClusterAPI instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPI build() {
    ClusterAPI buildable = new ClusterAPI(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}