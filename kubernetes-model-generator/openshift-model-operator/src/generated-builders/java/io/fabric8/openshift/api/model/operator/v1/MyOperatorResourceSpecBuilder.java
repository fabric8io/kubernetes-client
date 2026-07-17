package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MyOperatorResourceSpecBuilder extends MyOperatorResourceSpecFluent<MyOperatorResourceSpecBuilder> implements VisitableBuilder<MyOperatorResourceSpec,MyOperatorResourceSpecBuilder>{

  MyOperatorResourceSpecFluent<?> fluent;

  public MyOperatorResourceSpecBuilder() {
    this(new MyOperatorResourceSpec());
  }
  
  public MyOperatorResourceSpecBuilder(MyOperatorResourceSpecFluent<?> fluent) {
    this(fluent, new MyOperatorResourceSpec());
  }
  
  public MyOperatorResourceSpecBuilder(MyOperatorResourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MyOperatorResourceSpecBuilder(MyOperatorResourceSpecFluent<?> fluent,MyOperatorResourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MyOperatorResourceSpec build() {
    MyOperatorResourceSpec buildable = new MyOperatorResourceSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}