package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatherStatusBuilder extends GatherStatusFluent<GatherStatusBuilder> implements VisitableBuilder<GatherStatus,GatherStatusBuilder>{

  GatherStatusFluent<?> fluent;

  public GatherStatusBuilder() {
    this(new GatherStatus());
  }
  
  public GatherStatusBuilder(GatherStatusFluent<?> fluent) {
    this(fluent, new GatherStatus());
  }
  
  public GatherStatusBuilder(GatherStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatherStatusBuilder(GatherStatusFluent<?> fluent,GatherStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatherStatus build() {
    GatherStatus buildable = new GatherStatus(fluent.buildGatherers(), fluent.getLastGatherDuration(), fluent.getLastGatherTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}