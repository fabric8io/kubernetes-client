package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TopologyAffinitySpecBuilder extends TopologyAffinitySpecFluent<TopologyAffinitySpecBuilder> implements VisitableBuilder<TopologyAffinitySpec,TopologyAffinitySpecBuilder>{

  TopologyAffinitySpecFluent<?> fluent;

  public TopologyAffinitySpecBuilder() {
    this(new TopologyAffinitySpec());
  }
  
  public TopologyAffinitySpecBuilder(TopologyAffinitySpecFluent<?> fluent) {
    this(fluent, new TopologyAffinitySpec());
  }
  
  public TopologyAffinitySpecBuilder(TopologyAffinitySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TopologyAffinitySpecBuilder(TopologyAffinitySpecFluent<?> fluent,TopologyAffinitySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TopologyAffinitySpec build() {
    TopologyAffinitySpec buildable = new TopologyAffinitySpec(fluent.buildPodGroupAntiAffinity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}