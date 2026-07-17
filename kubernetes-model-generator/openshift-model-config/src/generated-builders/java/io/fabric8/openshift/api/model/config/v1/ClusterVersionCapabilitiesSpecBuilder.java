package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionCapabilitiesSpecBuilder extends ClusterVersionCapabilitiesSpecFluent<ClusterVersionCapabilitiesSpecBuilder> implements VisitableBuilder<ClusterVersionCapabilitiesSpec,ClusterVersionCapabilitiesSpecBuilder>{

  ClusterVersionCapabilitiesSpecFluent<?> fluent;

  public ClusterVersionCapabilitiesSpecBuilder() {
    this(new ClusterVersionCapabilitiesSpec());
  }
  
  public ClusterVersionCapabilitiesSpecBuilder(ClusterVersionCapabilitiesSpecFluent<?> fluent) {
    this(fluent, new ClusterVersionCapabilitiesSpec());
  }
  
  public ClusterVersionCapabilitiesSpecBuilder(ClusterVersionCapabilitiesSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionCapabilitiesSpecBuilder(ClusterVersionCapabilitiesSpecFluent<?> fluent,ClusterVersionCapabilitiesSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionCapabilitiesSpec build() {
    ClusterVersionCapabilitiesSpec buildable = new ClusterVersionCapabilitiesSpec(fluent.getAdditionalEnabledCapabilities(), fluent.getBaselineCapabilitySet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}