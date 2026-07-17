package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterTemplateBuilder extends Metal3ClusterTemplateFluent<Metal3ClusterTemplateBuilder> implements VisitableBuilder<Metal3ClusterTemplate,Metal3ClusterTemplateBuilder>{

  Metal3ClusterTemplateFluent<?> fluent;

  public Metal3ClusterTemplateBuilder() {
    this(new Metal3ClusterTemplate());
  }
  
  public Metal3ClusterTemplateBuilder(Metal3ClusterTemplateFluent<?> fluent) {
    this(fluent, new Metal3ClusterTemplate());
  }
  
  public Metal3ClusterTemplateBuilder(Metal3ClusterTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterTemplateBuilder(Metal3ClusterTemplateFluent<?> fluent,Metal3ClusterTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3ClusterTemplate build() {
    Metal3ClusterTemplate buildable = new Metal3ClusterTemplate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}