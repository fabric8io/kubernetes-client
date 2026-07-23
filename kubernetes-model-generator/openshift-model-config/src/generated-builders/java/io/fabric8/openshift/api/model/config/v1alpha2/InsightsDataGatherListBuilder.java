package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsDataGatherListBuilder extends InsightsDataGatherListFluent<InsightsDataGatherListBuilder> implements VisitableBuilder<InsightsDataGatherList,InsightsDataGatherListBuilder>{

  InsightsDataGatherListFluent<?> fluent;

  public InsightsDataGatherListBuilder() {
    this(new InsightsDataGatherList());
  }
  
  public InsightsDataGatherListBuilder(InsightsDataGatherListFluent<?> fluent) {
    this(fluent, new InsightsDataGatherList());
  }
  
  public InsightsDataGatherListBuilder(InsightsDataGatherList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsDataGatherListBuilder(InsightsDataGatherListFluent<?> fluent,InsightsDataGatherList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsDataGatherList build() {
    InsightsDataGatherList buildable = new InsightsDataGatherList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}