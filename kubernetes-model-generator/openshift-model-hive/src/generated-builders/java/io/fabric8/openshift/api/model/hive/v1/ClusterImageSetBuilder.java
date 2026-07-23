package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImageSetBuilder extends ClusterImageSetFluent<ClusterImageSetBuilder> implements VisitableBuilder<ClusterImageSet,ClusterImageSetBuilder>{

  ClusterImageSetFluent<?> fluent;

  public ClusterImageSetBuilder() {
    this(new ClusterImageSet());
  }
  
  public ClusterImageSetBuilder(ClusterImageSetFluent<?> fluent) {
    this(fluent, new ClusterImageSet());
  }
  
  public ClusterImageSetBuilder(ClusterImageSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImageSetBuilder(ClusterImageSetFluent<?> fluent,ClusterImageSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImageSet build() {
    ClusterImageSet buildable = new ClusterImageSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}