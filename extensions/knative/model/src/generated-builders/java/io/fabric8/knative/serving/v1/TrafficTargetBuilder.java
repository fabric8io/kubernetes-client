package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficTargetBuilder extends TrafficTargetFluent<TrafficTargetBuilder> implements VisitableBuilder<TrafficTarget,TrafficTargetBuilder>{

  TrafficTargetFluent<?> fluent;

  public TrafficTargetBuilder() {
    this(new TrafficTarget());
  }
  
  public TrafficTargetBuilder(TrafficTargetFluent<?> fluent) {
    this(fluent, new TrafficTarget());
  }
  
  public TrafficTargetBuilder(TrafficTarget instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficTargetBuilder(TrafficTargetFluent<?> fluent,TrafficTarget instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficTarget build() {
    TrafficTarget buildable = new TrafficTarget(fluent.getConfigurationName(), fluent.getLatestRevision(), fluent.getPercent(), fluent.getRevisionName(), fluent.getTag(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}