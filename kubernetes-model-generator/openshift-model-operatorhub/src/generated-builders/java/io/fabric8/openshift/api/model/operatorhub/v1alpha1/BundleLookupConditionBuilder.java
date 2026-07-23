package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BundleLookupConditionBuilder extends BundleLookupConditionFluent<BundleLookupConditionBuilder> implements VisitableBuilder<BundleLookupCondition,BundleLookupConditionBuilder>{

  BundleLookupConditionFluent<?> fluent;

  public BundleLookupConditionBuilder() {
    this(new BundleLookupCondition());
  }
  
  public BundleLookupConditionBuilder(BundleLookupConditionFluent<?> fluent) {
    this(fluent, new BundleLookupCondition());
  }
  
  public BundleLookupConditionBuilder(BundleLookupCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BundleLookupConditionBuilder(BundleLookupConditionFluent<?> fluent,BundleLookupCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BundleLookupCondition build() {
    BundleLookupCondition buildable = new BundleLookupCondition(fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}