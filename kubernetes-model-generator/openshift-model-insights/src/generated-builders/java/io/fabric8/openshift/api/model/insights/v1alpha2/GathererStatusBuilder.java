package io.fabric8.openshift.api.model.insights.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GathererStatusBuilder extends GathererStatusFluent<GathererStatusBuilder> implements VisitableBuilder<GathererStatus,GathererStatusBuilder>{

  GathererStatusFluent<?> fluent;

  public GathererStatusBuilder() {
    this(new GathererStatus());
  }
  
  public GathererStatusBuilder(GathererStatusFluent<?> fluent) {
    this(fluent, new GathererStatus());
  }
  
  public GathererStatusBuilder(GathererStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GathererStatusBuilder(GathererStatusFluent<?> fluent,GathererStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GathererStatus build() {
    GathererStatus buildable = new GathererStatus(fluent.getConditions(), fluent.getLastGatherSeconds(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}