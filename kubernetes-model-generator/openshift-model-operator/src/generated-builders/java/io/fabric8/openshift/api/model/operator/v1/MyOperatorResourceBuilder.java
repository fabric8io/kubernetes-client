package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MyOperatorResourceBuilder extends MyOperatorResourceFluent<MyOperatorResourceBuilder> implements VisitableBuilder<MyOperatorResource,MyOperatorResourceBuilder>{

  MyOperatorResourceFluent<?> fluent;

  public MyOperatorResourceBuilder() {
    this(new MyOperatorResource());
  }
  
  public MyOperatorResourceBuilder(MyOperatorResourceFluent<?> fluent) {
    this(fluent, new MyOperatorResource());
  }
  
  public MyOperatorResourceBuilder(MyOperatorResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MyOperatorResourceBuilder(MyOperatorResourceFluent<?> fluent,MyOperatorResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MyOperatorResource build() {
    MyOperatorResource buildable = new MyOperatorResource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}