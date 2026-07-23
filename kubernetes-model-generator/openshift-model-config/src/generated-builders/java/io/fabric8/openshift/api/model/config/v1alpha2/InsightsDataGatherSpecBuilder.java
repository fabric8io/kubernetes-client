package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsDataGatherSpecBuilder extends InsightsDataGatherSpecFluent<InsightsDataGatherSpecBuilder> implements VisitableBuilder<InsightsDataGatherSpec,InsightsDataGatherSpecBuilder>{

  InsightsDataGatherSpecFluent<?> fluent;

  public InsightsDataGatherSpecBuilder() {
    this(new InsightsDataGatherSpec());
  }
  
  public InsightsDataGatherSpecBuilder(InsightsDataGatherSpecFluent<?> fluent) {
    this(fluent, new InsightsDataGatherSpec());
  }
  
  public InsightsDataGatherSpecBuilder(InsightsDataGatherSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsDataGatherSpecBuilder(InsightsDataGatherSpecFluent<?> fluent,InsightsDataGatherSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsDataGatherSpec build() {
    InsightsDataGatherSpec buildable = new InsightsDataGatherSpec(fluent.buildGatherConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}