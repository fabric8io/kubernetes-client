package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImageSetSpecBuilder extends ClusterImageSetSpecFluent<ClusterImageSetSpecBuilder> implements VisitableBuilder<ClusterImageSetSpec,ClusterImageSetSpecBuilder>{

  ClusterImageSetSpecFluent<?> fluent;

  public ClusterImageSetSpecBuilder() {
    this(new ClusterImageSetSpec());
  }
  
  public ClusterImageSetSpecBuilder(ClusterImageSetSpecFluent<?> fluent) {
    this(fluent, new ClusterImageSetSpec());
  }
  
  public ClusterImageSetSpecBuilder(ClusterImageSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImageSetSpecBuilder(ClusterImageSetSpecFluent<?> fluent,ClusterImageSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImageSetSpec build() {
    ClusterImageSetSpec buildable = new ClusterImageSetSpec(fluent.getReleaseImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}