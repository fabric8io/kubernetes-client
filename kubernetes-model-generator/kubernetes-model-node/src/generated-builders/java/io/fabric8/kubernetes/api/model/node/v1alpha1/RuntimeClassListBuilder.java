package io.fabric8.kubernetes.api.model.node.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuntimeClassListBuilder extends RuntimeClassListFluent<RuntimeClassListBuilder> implements VisitableBuilder<RuntimeClassList,RuntimeClassListBuilder>{

  RuntimeClassListFluent<?> fluent;

  public RuntimeClassListBuilder() {
    this(new RuntimeClassList());
  }
  
  public RuntimeClassListBuilder(RuntimeClassListFluent<?> fluent) {
    this(fluent, new RuntimeClassList());
  }
  
  public RuntimeClassListBuilder(RuntimeClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuntimeClassListBuilder(RuntimeClassListFluent<?> fluent,RuntimeClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuntimeClassList build() {
    RuntimeClassList buildable = new RuntimeClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}