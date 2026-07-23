package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterCSIDriverSpecBuilder extends ClusterCSIDriverSpecFluent<ClusterCSIDriverSpecBuilder> implements VisitableBuilder<ClusterCSIDriverSpec,ClusterCSIDriverSpecBuilder>{

  ClusterCSIDriverSpecFluent<?> fluent;

  public ClusterCSIDriverSpecBuilder() {
    this(new ClusterCSIDriverSpec());
  }
  
  public ClusterCSIDriverSpecBuilder(ClusterCSIDriverSpecFluent<?> fluent) {
    this(fluent, new ClusterCSIDriverSpec());
  }
  
  public ClusterCSIDriverSpecBuilder(ClusterCSIDriverSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterCSIDriverSpecBuilder(ClusterCSIDriverSpecFluent<?> fluent,ClusterCSIDriverSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterCSIDriverSpec build() {
    ClusterCSIDriverSpec buildable = new ClusterCSIDriverSpec(fluent.buildDriverConfig(), fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getStorageClassState(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}