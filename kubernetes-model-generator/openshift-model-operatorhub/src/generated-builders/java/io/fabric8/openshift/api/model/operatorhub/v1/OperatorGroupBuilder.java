package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorGroupBuilder extends OperatorGroupFluent<OperatorGroupBuilder> implements VisitableBuilder<OperatorGroup,OperatorGroupBuilder>{

  OperatorGroupFluent<?> fluent;

  public OperatorGroupBuilder() {
    this(new OperatorGroup());
  }
  
  public OperatorGroupBuilder(OperatorGroupFluent<?> fluent) {
    this(fluent, new OperatorGroup());
  }
  
  public OperatorGroupBuilder(OperatorGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorGroupBuilder(OperatorGroupFluent<?> fluent,OperatorGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorGroup build() {
    OperatorGroup buildable = new OperatorGroup(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}