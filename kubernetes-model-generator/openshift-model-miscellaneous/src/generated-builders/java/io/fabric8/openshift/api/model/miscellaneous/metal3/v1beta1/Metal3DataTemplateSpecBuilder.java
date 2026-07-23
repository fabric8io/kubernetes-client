package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataTemplateSpecBuilder extends Metal3DataTemplateSpecFluent<Metal3DataTemplateSpecBuilder> implements VisitableBuilder<Metal3DataTemplateSpec,Metal3DataTemplateSpecBuilder>{

  Metal3DataTemplateSpecFluent<?> fluent;

  public Metal3DataTemplateSpecBuilder() {
    this(new Metal3DataTemplateSpec());
  }
  
  public Metal3DataTemplateSpecBuilder(Metal3DataTemplateSpecFluent<?> fluent) {
    this(fluent, new Metal3DataTemplateSpec());
  }
  
  public Metal3DataTemplateSpecBuilder(Metal3DataTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataTemplateSpecBuilder(Metal3DataTemplateSpecFluent<?> fluent,Metal3DataTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataTemplateSpec build() {
    Metal3DataTemplateSpec buildable = new Metal3DataTemplateSpec(fluent.getClusterName(), fluent.buildMetaData(), fluent.buildNetworkData(), fluent.getTemplateReference());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}