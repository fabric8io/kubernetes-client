package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataTemplateStatusBuilder extends Metal3DataTemplateStatusFluent<Metal3DataTemplateStatusBuilder> implements VisitableBuilder<Metal3DataTemplateStatus,Metal3DataTemplateStatusBuilder>{

  Metal3DataTemplateStatusFluent<?> fluent;

  public Metal3DataTemplateStatusBuilder() {
    this(new Metal3DataTemplateStatus());
  }
  
  public Metal3DataTemplateStatusBuilder(Metal3DataTemplateStatusFluent<?> fluent) {
    this(fluent, new Metal3DataTemplateStatus());
  }
  
  public Metal3DataTemplateStatusBuilder(Metal3DataTemplateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataTemplateStatusBuilder(Metal3DataTemplateStatusFluent<?> fluent,Metal3DataTemplateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataTemplateStatus build() {
    Metal3DataTemplateStatus buildable = new Metal3DataTemplateStatus(fluent.getIndexes(), fluent.getLastUpdated());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}