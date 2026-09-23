package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterBootImageManualBuilder extends ClusterBootImageManualFluent<ClusterBootImageManualBuilder> implements VisitableBuilder<ClusterBootImageManual,ClusterBootImageManualBuilder>{

  ClusterBootImageManualFluent<?> fluent;

  public ClusterBootImageManualBuilder() {
    this(new ClusterBootImageManual());
  }
  
  public ClusterBootImageManualBuilder(ClusterBootImageManualFluent<?> fluent) {
    this(fluent, new ClusterBootImageManual());
  }
  
  public ClusterBootImageManualBuilder(ClusterBootImageManual instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterBootImageManualBuilder(ClusterBootImageManualFluent<?> fluent,ClusterBootImageManual instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterBootImageManual build() {
    ClusterBootImageManual buildable = new ClusterBootImageManual(fluent.getMode(), fluent.getOcpVersion(), fluent.getRhcosVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}