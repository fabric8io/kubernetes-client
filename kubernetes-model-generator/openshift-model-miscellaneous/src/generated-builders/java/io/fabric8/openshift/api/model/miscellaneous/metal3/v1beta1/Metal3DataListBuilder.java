package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataListBuilder extends Metal3DataListFluent<Metal3DataListBuilder> implements VisitableBuilder<Metal3DataList,Metal3DataListBuilder>{

  Metal3DataListFluent<?> fluent;

  public Metal3DataListBuilder() {
    this(new Metal3DataList());
  }
  
  public Metal3DataListBuilder(Metal3DataListFluent<?> fluent) {
    this(fluent, new Metal3DataList());
  }
  
  public Metal3DataListBuilder(Metal3DataList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataListBuilder(Metal3DataListFluent<?> fluent,Metal3DataList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataList build() {
    Metal3DataList buildable = new Metal3DataList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}