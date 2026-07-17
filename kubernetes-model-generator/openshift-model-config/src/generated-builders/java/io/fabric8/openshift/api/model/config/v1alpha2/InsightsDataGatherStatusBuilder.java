package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsDataGatherStatusBuilder extends InsightsDataGatherStatusFluent<InsightsDataGatherStatusBuilder> implements VisitableBuilder<InsightsDataGatherStatus,InsightsDataGatherStatusBuilder>{

  InsightsDataGatherStatusFluent<?> fluent;

  public InsightsDataGatherStatusBuilder() {
    this(new InsightsDataGatherStatus());
  }
  
  public InsightsDataGatherStatusBuilder(InsightsDataGatherStatusFluent<?> fluent) {
    this(fluent, new InsightsDataGatherStatus());
  }
  
  public InsightsDataGatherStatusBuilder(InsightsDataGatherStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsDataGatherStatusBuilder(InsightsDataGatherStatusFluent<?> fluent,InsightsDataGatherStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsDataGatherStatus build() {
    InsightsDataGatherStatus buildable = new InsightsDataGatherStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}