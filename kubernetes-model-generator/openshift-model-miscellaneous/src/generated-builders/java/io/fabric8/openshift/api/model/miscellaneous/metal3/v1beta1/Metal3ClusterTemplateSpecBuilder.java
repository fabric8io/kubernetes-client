package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterTemplateSpecBuilder extends Metal3ClusterTemplateSpecFluent<Metal3ClusterTemplateSpecBuilder> implements VisitableBuilder<Metal3ClusterTemplateSpec,Metal3ClusterTemplateSpecBuilder>{

  Metal3ClusterTemplateSpecFluent<?> fluent;

  public Metal3ClusterTemplateSpecBuilder() {
    this(new Metal3ClusterTemplateSpec());
  }
  
  public Metal3ClusterTemplateSpecBuilder(Metal3ClusterTemplateSpecFluent<?> fluent) {
    this(fluent, new Metal3ClusterTemplateSpec());
  }
  
  public Metal3ClusterTemplateSpecBuilder(Metal3ClusterTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterTemplateSpecBuilder(Metal3ClusterTemplateSpecFluent<?> fluent,Metal3ClusterTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3ClusterTemplateSpec build() {
    Metal3ClusterTemplateSpec buildable = new Metal3ClusterTemplateSpec(fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}