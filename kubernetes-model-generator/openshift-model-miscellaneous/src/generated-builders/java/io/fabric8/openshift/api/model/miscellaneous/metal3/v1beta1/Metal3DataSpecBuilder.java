package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataSpecBuilder extends Metal3DataSpecFluent<Metal3DataSpecBuilder> implements VisitableBuilder<Metal3DataSpec,Metal3DataSpecBuilder>{

  Metal3DataSpecFluent<?> fluent;

  public Metal3DataSpecBuilder() {
    this(new Metal3DataSpec());
  }
  
  public Metal3DataSpecBuilder(Metal3DataSpecFluent<?> fluent) {
    this(fluent, new Metal3DataSpec());
  }
  
  public Metal3DataSpecBuilder(Metal3DataSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataSpecBuilder(Metal3DataSpecFluent<?> fluent,Metal3DataSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataSpec build() {
    Metal3DataSpec buildable = new Metal3DataSpec(fluent.buildClaim(), fluent.getIndex(), fluent.getMetaData(), fluent.getNetworkData(), fluent.buildTemplate(), fluent.getTemplateReference());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}