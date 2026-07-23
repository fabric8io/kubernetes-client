package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGateAttributesBuilder extends FeatureGateAttributesFluent<FeatureGateAttributesBuilder> implements VisitableBuilder<FeatureGateAttributes,FeatureGateAttributesBuilder>{

  FeatureGateAttributesFluent<?> fluent;

  public FeatureGateAttributesBuilder() {
    this(new FeatureGateAttributes());
  }
  
  public FeatureGateAttributesBuilder(FeatureGateAttributesFluent<?> fluent) {
    this(fluent, new FeatureGateAttributes());
  }
  
  public FeatureGateAttributesBuilder(FeatureGateAttributes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGateAttributesBuilder(FeatureGateAttributesFluent<?> fluent,FeatureGateAttributes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGateAttributes build() {
    FeatureGateAttributes buildable = new FeatureGateAttributes(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}