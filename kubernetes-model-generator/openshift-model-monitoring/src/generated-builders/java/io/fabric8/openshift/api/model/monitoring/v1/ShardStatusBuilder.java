package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ShardStatusBuilder extends ShardStatusFluent<ShardStatusBuilder> implements VisitableBuilder<ShardStatus,ShardStatusBuilder>{

  ShardStatusFluent<?> fluent;

  public ShardStatusBuilder() {
    this(new ShardStatus());
  }
  
  public ShardStatusBuilder(ShardStatusFluent<?> fluent) {
    this(fluent, new ShardStatus());
  }
  
  public ShardStatusBuilder(ShardStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ShardStatusBuilder(ShardStatusFluent<?> fluent,ShardStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ShardStatus build() {
    ShardStatus buildable = new ShardStatus(fluent.getAvailableReplicas(), fluent.getReplicas(), fluent.getShardID(), fluent.getUnavailableReplicas(), fluent.getUpdatedReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}