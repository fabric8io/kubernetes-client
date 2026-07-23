package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteClusterConditionBuilder extends RemoteClusterConditionFluent<RemoteClusterConditionBuilder> implements VisitableBuilder<RemoteClusterCondition,RemoteClusterConditionBuilder>{

  RemoteClusterConditionFluent<?> fluent;

  public RemoteClusterConditionBuilder() {
    this(new RemoteClusterCondition());
  }
  
  public RemoteClusterConditionBuilder(RemoteClusterConditionFluent<?> fluent) {
    this(fluent, new RemoteClusterCondition());
  }
  
  public RemoteClusterConditionBuilder(RemoteClusterCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteClusterConditionBuilder(RemoteClusterConditionFluent<?> fluent,RemoteClusterCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteClusterCondition build() {
    RemoteClusterCondition buildable = new RemoteClusterCondition(fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}