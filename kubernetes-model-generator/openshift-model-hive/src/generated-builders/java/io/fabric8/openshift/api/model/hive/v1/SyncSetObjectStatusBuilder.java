package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncSetObjectStatusBuilder extends SyncSetObjectStatusFluent<SyncSetObjectStatusBuilder> implements VisitableBuilder<SyncSetObjectStatus,SyncSetObjectStatusBuilder>{

  SyncSetObjectStatusFluent<?> fluent;

  public SyncSetObjectStatusBuilder() {
    this(new SyncSetObjectStatus());
  }
  
  public SyncSetObjectStatusBuilder(SyncSetObjectStatusFluent<?> fluent) {
    this(fluent, new SyncSetObjectStatus());
  }
  
  public SyncSetObjectStatusBuilder(SyncSetObjectStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncSetObjectStatusBuilder(SyncSetObjectStatusFluent<?> fluent,SyncSetObjectStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncSetObjectStatus build() {
    SyncSetObjectStatus buildable = new SyncSetObjectStatus(fluent.buildConditions(), fluent.getName(), fluent.buildPatches(), fluent.getResourceApplyMode(), fluent.buildResources(), fluent.buildSecrets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}