package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorPKIListBuilder extends OperatorPKIListFluent<OperatorPKIListBuilder> implements VisitableBuilder<OperatorPKIList,OperatorPKIListBuilder>{

  OperatorPKIListFluent<?> fluent;

  public OperatorPKIListBuilder() {
    this(new OperatorPKIList());
  }
  
  public OperatorPKIListBuilder(OperatorPKIListFluent<?> fluent) {
    this(fluent, new OperatorPKIList());
  }
  
  public OperatorPKIListBuilder(OperatorPKIList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorPKIListBuilder(OperatorPKIListFluent<?> fluent,OperatorPKIList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorPKIList build() {
    OperatorPKIList buildable = new OperatorPKIList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}