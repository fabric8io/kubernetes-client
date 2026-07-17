package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterListBuilder extends Metal3ClusterListFluent<Metal3ClusterListBuilder> implements VisitableBuilder<Metal3ClusterList,Metal3ClusterListBuilder>{

  Metal3ClusterListFluent<?> fluent;

  public Metal3ClusterListBuilder() {
    this(new Metal3ClusterList());
  }
  
  public Metal3ClusterListBuilder(Metal3ClusterListFluent<?> fluent) {
    this(fluent, new Metal3ClusterList());
  }
  
  public Metal3ClusterListBuilder(Metal3ClusterList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterListBuilder(Metal3ClusterListFluent<?> fluent,Metal3ClusterList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3ClusterList build() {
    Metal3ClusterList buildable = new Metal3ClusterList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}