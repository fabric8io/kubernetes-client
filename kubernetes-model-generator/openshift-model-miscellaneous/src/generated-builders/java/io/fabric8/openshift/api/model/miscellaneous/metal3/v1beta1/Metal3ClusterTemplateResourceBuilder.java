package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterTemplateResourceBuilder extends Metal3ClusterTemplateResourceFluent<Metal3ClusterTemplateResourceBuilder> implements VisitableBuilder<Metal3ClusterTemplateResource,Metal3ClusterTemplateResourceBuilder>{

  Metal3ClusterTemplateResourceFluent<?> fluent;

  public Metal3ClusterTemplateResourceBuilder() {
    this(new Metal3ClusterTemplateResource());
  }
  
  public Metal3ClusterTemplateResourceBuilder(Metal3ClusterTemplateResourceFluent<?> fluent) {
    this(fluent, new Metal3ClusterTemplateResource());
  }
  
  public Metal3ClusterTemplateResourceBuilder(Metal3ClusterTemplateResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterTemplateResourceBuilder(Metal3ClusterTemplateResourceFluent<?> fluent,Metal3ClusterTemplateResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3ClusterTemplateResource build() {
    Metal3ClusterTemplateResource buildable = new Metal3ClusterTemplateResource(fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}