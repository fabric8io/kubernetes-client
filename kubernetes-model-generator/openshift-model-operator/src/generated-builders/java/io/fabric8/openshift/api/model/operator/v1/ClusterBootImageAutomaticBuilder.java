package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterBootImageAutomaticBuilder extends ClusterBootImageAutomaticFluent<ClusterBootImageAutomaticBuilder> implements VisitableBuilder<ClusterBootImageAutomatic,ClusterBootImageAutomaticBuilder>{

  ClusterBootImageAutomaticFluent<?> fluent;

  public ClusterBootImageAutomaticBuilder() {
    this(new ClusterBootImageAutomatic());
  }
  
  public ClusterBootImageAutomaticBuilder(ClusterBootImageAutomaticFluent<?> fluent) {
    this(fluent, new ClusterBootImageAutomatic());
  }
  
  public ClusterBootImageAutomaticBuilder(ClusterBootImageAutomatic instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterBootImageAutomaticBuilder(ClusterBootImageAutomaticFluent<?> fluent,ClusterBootImageAutomatic instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterBootImageAutomatic build() {
    ClusterBootImageAutomatic buildable = new ClusterBootImageAutomatic(fluent.getOcpVersion(), fluent.getRhcosVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}