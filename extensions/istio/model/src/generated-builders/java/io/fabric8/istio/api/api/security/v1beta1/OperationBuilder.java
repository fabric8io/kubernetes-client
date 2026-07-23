package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperationBuilder extends OperationFluent<OperationBuilder> implements VisitableBuilder<Operation,OperationBuilder>{

  OperationFluent<?> fluent;

  public OperationBuilder() {
    this(new Operation());
  }
  
  public OperationBuilder(OperationFluent<?> fluent) {
    this(fluent, new Operation());
  }
  
  public OperationBuilder(Operation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperationBuilder(OperationFluent<?> fluent,Operation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Operation build() {
    Operation buildable = new Operation(fluent.getHosts(), fluent.getMethods(), fluent.getNotHosts(), fluent.getNotMethods(), fluent.getNotPaths(), fluent.getNotPorts(), fluent.getPaths(), fluent.getPorts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}