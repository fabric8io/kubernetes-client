package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionBuilder extends ClusterVersionFluent<ClusterVersionBuilder> implements VisitableBuilder<ClusterVersion,ClusterVersionBuilder>{

  ClusterVersionFluent<?> fluent;

  public ClusterVersionBuilder() {
    this(new ClusterVersion());
  }
  
  public ClusterVersionBuilder(ClusterVersionFluent<?> fluent) {
    this(fluent, new ClusterVersion());
  }
  
  public ClusterVersionBuilder(ClusterVersion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionBuilder(ClusterVersionFluent<?> fluent,ClusterVersion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersion build() {
    ClusterVersion buildable = new ClusterVersion(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}