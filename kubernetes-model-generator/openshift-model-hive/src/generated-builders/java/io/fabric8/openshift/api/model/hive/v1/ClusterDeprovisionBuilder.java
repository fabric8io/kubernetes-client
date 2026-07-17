package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeprovisionBuilder extends ClusterDeprovisionFluent<ClusterDeprovisionBuilder> implements VisitableBuilder<ClusterDeprovision,ClusterDeprovisionBuilder>{

  ClusterDeprovisionFluent<?> fluent;

  public ClusterDeprovisionBuilder() {
    this(new ClusterDeprovision());
  }
  
  public ClusterDeprovisionBuilder(ClusterDeprovisionFluent<?> fluent) {
    this(fluent, new ClusterDeprovision());
  }
  
  public ClusterDeprovisionBuilder(ClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeprovisionBuilder(ClusterDeprovisionFluent<?> fluent,ClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeprovision build() {
    ClusterDeprovision buildable = new ClusterDeprovision(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}