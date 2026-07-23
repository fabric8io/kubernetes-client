package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterCSIDriverBuilder extends ClusterCSIDriverFluent<ClusterCSIDriverBuilder> implements VisitableBuilder<ClusterCSIDriver,ClusterCSIDriverBuilder>{

  ClusterCSIDriverFluent<?> fluent;

  public ClusterCSIDriverBuilder() {
    this(new ClusterCSIDriver());
  }
  
  public ClusterCSIDriverBuilder(ClusterCSIDriverFluent<?> fluent) {
    this(fluent, new ClusterCSIDriver());
  }
  
  public ClusterCSIDriverBuilder(ClusterCSIDriver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterCSIDriverBuilder(ClusterCSIDriverFluent<?> fluent,ClusterCSIDriver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterCSIDriver build() {
    ClusterCSIDriver buildable = new ClusterCSIDriver(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}