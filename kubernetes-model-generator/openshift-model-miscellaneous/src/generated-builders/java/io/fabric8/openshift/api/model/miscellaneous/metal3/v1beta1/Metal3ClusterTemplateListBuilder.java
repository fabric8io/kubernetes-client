package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterTemplateListBuilder extends Metal3ClusterTemplateListFluent<Metal3ClusterTemplateListBuilder> implements VisitableBuilder<Metal3ClusterTemplateList,Metal3ClusterTemplateListBuilder>{

  Metal3ClusterTemplateListFluent<?> fluent;

  public Metal3ClusterTemplateListBuilder() {
    this(new Metal3ClusterTemplateList());
  }
  
  public Metal3ClusterTemplateListBuilder(Metal3ClusterTemplateListFluent<?> fluent) {
    this(fluent, new Metal3ClusterTemplateList());
  }
  
  public Metal3ClusterTemplateListBuilder(Metal3ClusterTemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterTemplateListBuilder(Metal3ClusterTemplateListFluent<?> fluent,Metal3ClusterTemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3ClusterTemplateList build() {
    Metal3ClusterTemplateList buildable = new Metal3ClusterTemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}