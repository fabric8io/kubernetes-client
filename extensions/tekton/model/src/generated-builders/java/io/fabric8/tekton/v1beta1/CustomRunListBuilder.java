package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomRunListBuilder extends CustomRunListFluent<CustomRunListBuilder> implements VisitableBuilder<CustomRunList,CustomRunListBuilder>{

  CustomRunListFluent<?> fluent;

  public CustomRunListBuilder() {
    this(new CustomRunList());
  }
  
  public CustomRunListBuilder(CustomRunListFluent<?> fluent) {
    this(fluent, new CustomRunList());
  }
  
  public CustomRunListBuilder(CustomRunList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomRunListBuilder(CustomRunListFluent<?> fluent,CustomRunList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomRunList build() {
    CustomRunList buildable = new CustomRunList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}