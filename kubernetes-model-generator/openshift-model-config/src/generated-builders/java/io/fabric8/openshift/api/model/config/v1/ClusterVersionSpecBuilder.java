package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionSpecBuilder extends ClusterVersionSpecFluent<ClusterVersionSpecBuilder> implements VisitableBuilder<ClusterVersionSpec,ClusterVersionSpecBuilder>{

  ClusterVersionSpecFluent<?> fluent;

  public ClusterVersionSpecBuilder() {
    this(new ClusterVersionSpec());
  }
  
  public ClusterVersionSpecBuilder(ClusterVersionSpecFluent<?> fluent) {
    this(fluent, new ClusterVersionSpec());
  }
  
  public ClusterVersionSpecBuilder(ClusterVersionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionSpecBuilder(ClusterVersionSpecFluent<?> fluent,ClusterVersionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionSpec build() {
    ClusterVersionSpec buildable = new ClusterVersionSpec(fluent.buildCapabilities(), fluent.getChannel(), fluent.getClusterID(), fluent.buildDesiredUpdate(), fluent.buildOverrides(), fluent.buildSignatureStores(), fluent.getUpstream());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}