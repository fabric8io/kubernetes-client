package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorBuilder extends OperatorFluent<OperatorBuilder> implements VisitableBuilder<Operator,OperatorBuilder>{

  OperatorFluent<?> fluent;

  public OperatorBuilder() {
    this(new Operator());
  }
  
  public OperatorBuilder(OperatorFluent<?> fluent) {
    this(fluent, new Operator());
  }
  
  public OperatorBuilder(Operator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorBuilder(OperatorFluent<?> fluent,Operator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Operator build() {
    Operator buildable = new Operator(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}