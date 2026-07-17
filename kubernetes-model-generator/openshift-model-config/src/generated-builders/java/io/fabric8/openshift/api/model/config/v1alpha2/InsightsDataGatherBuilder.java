package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsDataGatherBuilder extends InsightsDataGatherFluent<InsightsDataGatherBuilder> implements VisitableBuilder<InsightsDataGather,InsightsDataGatherBuilder>{

  InsightsDataGatherFluent<?> fluent;

  public InsightsDataGatherBuilder() {
    this(new InsightsDataGather());
  }
  
  public InsightsDataGatherBuilder(InsightsDataGatherFluent<?> fluent) {
    this(fluent, new InsightsDataGather());
  }
  
  public InsightsDataGatherBuilder(InsightsDataGather instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsDataGatherBuilder(InsightsDataGatherFluent<?> fluent,InsightsDataGather instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsDataGather build() {
    InsightsDataGather buildable = new InsightsDataGather(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}