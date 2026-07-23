package io.fabric8.openshift.api.model.operatorhub.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorGroupListBuilder extends OperatorGroupListFluent<OperatorGroupListBuilder> implements VisitableBuilder<OperatorGroupList,OperatorGroupListBuilder>{

  OperatorGroupListFluent<?> fluent;

  public OperatorGroupListBuilder() {
    this(new OperatorGroupList());
  }
  
  public OperatorGroupListBuilder(OperatorGroupListFluent<?> fluent) {
    this(fluent, new OperatorGroupList());
  }
  
  public OperatorGroupListBuilder(OperatorGroupList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorGroupListBuilder(OperatorGroupListFluent<?> fluent,OperatorGroupList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorGroupList build() {
    OperatorGroupList buildable = new OperatorGroupList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}