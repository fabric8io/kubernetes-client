package io.fabric8.openclustermanagement.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveredClusterConditionBuilder extends DiscoveredClusterConditionFluent<DiscoveredClusterConditionBuilder> implements VisitableBuilder<DiscoveredClusterCondition,DiscoveredClusterConditionBuilder>{

  DiscoveredClusterConditionFluent<?> fluent;

  public DiscoveredClusterConditionBuilder() {
    this(new DiscoveredClusterCondition());
  }
  
  public DiscoveredClusterConditionBuilder(DiscoveredClusterConditionFluent<?> fluent) {
    this(fluent, new DiscoveredClusterCondition());
  }
  
  public DiscoveredClusterConditionBuilder(DiscoveredClusterCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveredClusterConditionBuilder(DiscoveredClusterConditionFluent<?> fluent,DiscoveredClusterCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveredClusterCondition build() {
    DiscoveredClusterCondition buildable = new DiscoveredClusterCondition(fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}