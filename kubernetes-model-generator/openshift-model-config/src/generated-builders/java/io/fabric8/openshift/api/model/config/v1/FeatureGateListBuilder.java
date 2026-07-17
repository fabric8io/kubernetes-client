package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGateListBuilder extends FeatureGateListFluent<FeatureGateListBuilder> implements VisitableBuilder<FeatureGateList,FeatureGateListBuilder>{

  FeatureGateListFluent<?> fluent;

  public FeatureGateListBuilder() {
    this(new FeatureGateList());
  }
  
  public FeatureGateListBuilder(FeatureGateListFluent<?> fluent) {
    this(fluent, new FeatureGateList());
  }
  
  public FeatureGateListBuilder(FeatureGateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGateListBuilder(FeatureGateListFluent<?> fluent,FeatureGateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGateList build() {
    FeatureGateList buildable = new FeatureGateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}