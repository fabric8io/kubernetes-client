package io.fabric8.openshift.api.model.operatorhub.v2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorConditionListBuilder extends OperatorConditionListFluent<OperatorConditionListBuilder> implements VisitableBuilder<OperatorConditionList,OperatorConditionListBuilder>{

  OperatorConditionListFluent<?> fluent;

  public OperatorConditionListBuilder() {
    this(new OperatorConditionList());
  }
  
  public OperatorConditionListBuilder(OperatorConditionListFluent<?> fluent) {
    this(fluent, new OperatorConditionList());
  }
  
  public OperatorConditionListBuilder(OperatorConditionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorConditionListBuilder(OperatorConditionListFluent<?> fluent,OperatorConditionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorConditionList build() {
    OperatorConditionList buildable = new OperatorConditionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}