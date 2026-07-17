package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsOperatorListBuilder extends InsightsOperatorListFluent<InsightsOperatorListBuilder> implements VisitableBuilder<InsightsOperatorList,InsightsOperatorListBuilder>{

  InsightsOperatorListFluent<?> fluent;

  public InsightsOperatorListBuilder() {
    this(new InsightsOperatorList());
  }
  
  public InsightsOperatorListBuilder(InsightsOperatorListFluent<?> fluent) {
    this(fluent, new InsightsOperatorList());
  }
  
  public InsightsOperatorListBuilder(InsightsOperatorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsOperatorListBuilder(InsightsOperatorListFluent<?> fluent,InsightsOperatorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsOperatorList build() {
    InsightsOperatorList buildable = new InsightsOperatorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}