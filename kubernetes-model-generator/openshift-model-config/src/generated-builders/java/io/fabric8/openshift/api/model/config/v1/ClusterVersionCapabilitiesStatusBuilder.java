package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionCapabilitiesStatusBuilder extends ClusterVersionCapabilitiesStatusFluent<ClusterVersionCapabilitiesStatusBuilder> implements VisitableBuilder<ClusterVersionCapabilitiesStatus,ClusterVersionCapabilitiesStatusBuilder>{

  ClusterVersionCapabilitiesStatusFluent<?> fluent;

  public ClusterVersionCapabilitiesStatusBuilder() {
    this(new ClusterVersionCapabilitiesStatus());
  }
  
  public ClusterVersionCapabilitiesStatusBuilder(ClusterVersionCapabilitiesStatusFluent<?> fluent) {
    this(fluent, new ClusterVersionCapabilitiesStatus());
  }
  
  public ClusterVersionCapabilitiesStatusBuilder(ClusterVersionCapabilitiesStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionCapabilitiesStatusBuilder(ClusterVersionCapabilitiesStatusFluent<?> fluent,ClusterVersionCapabilitiesStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionCapabilitiesStatus build() {
    ClusterVersionCapabilitiesStatus buildable = new ClusterVersionCapabilitiesStatus(fluent.getEnabledCapabilities(), fluent.getKnownCapabilities());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}