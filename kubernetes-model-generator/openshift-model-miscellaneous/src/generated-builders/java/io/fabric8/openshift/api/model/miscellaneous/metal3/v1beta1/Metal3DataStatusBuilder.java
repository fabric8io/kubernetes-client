package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataStatusBuilder extends Metal3DataStatusFluent<Metal3DataStatusBuilder> implements VisitableBuilder<Metal3DataStatus,Metal3DataStatusBuilder>{

  Metal3DataStatusFluent<?> fluent;

  public Metal3DataStatusBuilder() {
    this(new Metal3DataStatus());
  }
  
  public Metal3DataStatusBuilder(Metal3DataStatusFluent<?> fluent) {
    this(fluent, new Metal3DataStatus());
  }
  
  public Metal3DataStatusBuilder(Metal3DataStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataStatusBuilder(Metal3DataStatusFluent<?> fluent,Metal3DataStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataStatus build() {
    Metal3DataStatus buildable = new Metal3DataStatus(fluent.getErrorMessage(), fluent.getReady());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}