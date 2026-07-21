package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterEventBuilder extends ClusterEventFluent<ClusterEventBuilder> implements VisitableBuilder<ClusterEvent,ClusterEventBuilder>{

  ClusterEventFluent<?> fluent;

  public ClusterEventBuilder() {
    this(new ClusterEvent());
  }
  
  public ClusterEventBuilder(ClusterEventFluent<?> fluent) {
    this(fluent, new ClusterEvent());
  }
  
  public ClusterEventBuilder(ClusterEvent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterEventBuilder(ClusterEventFluent<?> fluent,ClusterEvent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterEvent build() {
    ClusterEvent buildable = new ClusterEvent(fluent.getAutomationStartTime(), fluent.getEventTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}