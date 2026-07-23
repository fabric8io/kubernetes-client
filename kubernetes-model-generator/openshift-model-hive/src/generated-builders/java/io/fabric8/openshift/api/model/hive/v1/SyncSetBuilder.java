package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncSetBuilder extends SyncSetFluent<SyncSetBuilder> implements VisitableBuilder<SyncSet,SyncSetBuilder>{

  SyncSetFluent<?> fluent;

  public SyncSetBuilder() {
    this(new SyncSet());
  }
  
  public SyncSetBuilder(SyncSetFluent<?> fluent) {
    this(fluent, new SyncSet());
  }
  
  public SyncSetBuilder(SyncSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncSetBuilder(SyncSetFluent<?> fluent,SyncSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncSet build() {
    SyncSet buildable = new SyncSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}