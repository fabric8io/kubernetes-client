package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorListBuilder extends OperatorListFluent<OperatorListBuilder> implements VisitableBuilder<OperatorList,OperatorListBuilder>{

  OperatorListFluent<?> fluent;

  public OperatorListBuilder() {
    this(new OperatorList());
  }
  
  public OperatorListBuilder(OperatorListFluent<?> fluent) {
    this(fluent, new OperatorList());
  }
  
  public OperatorListBuilder(OperatorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorListBuilder(OperatorListFluent<?> fluent,OperatorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorList build() {
    OperatorList buildable = new OperatorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}