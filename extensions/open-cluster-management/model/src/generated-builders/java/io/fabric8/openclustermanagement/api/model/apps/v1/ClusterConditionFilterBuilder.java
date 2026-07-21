package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterConditionFilterBuilder extends ClusterConditionFilterFluent<ClusterConditionFilterBuilder> implements VisitableBuilder<ClusterConditionFilter,ClusterConditionFilterBuilder>{

  ClusterConditionFilterFluent<?> fluent;

  public ClusterConditionFilterBuilder() {
    this(new ClusterConditionFilter());
  }
  
  public ClusterConditionFilterBuilder(ClusterConditionFilterFluent<?> fluent) {
    this(fluent, new ClusterConditionFilter());
  }
  
  public ClusterConditionFilterBuilder(ClusterConditionFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterConditionFilterBuilder(ClusterConditionFilterFluent<?> fluent,ClusterConditionFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterConditionFilter build() {
    ClusterConditionFilter buildable = new ClusterConditionFilter(fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}