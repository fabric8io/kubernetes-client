package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterLogForwarderSpecBuilder extends ClusterLogForwarderSpecFluent<ClusterLogForwarderSpecBuilder> implements VisitableBuilder<ClusterLogForwarderSpec,ClusterLogForwarderSpecBuilder>{

  ClusterLogForwarderSpecFluent<?> fluent;

  public ClusterLogForwarderSpecBuilder() {
    this(new ClusterLogForwarderSpec());
  }
  
  public ClusterLogForwarderSpecBuilder(ClusterLogForwarderSpecFluent<?> fluent) {
    this(fluent, new ClusterLogForwarderSpec());
  }
  
  public ClusterLogForwarderSpecBuilder(ClusterLogForwarderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterLogForwarderSpecBuilder(ClusterLogForwarderSpecFluent<?> fluent,ClusterLogForwarderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterLogForwarderSpec build() {
    ClusterLogForwarderSpec buildable = new ClusterLogForwarderSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}