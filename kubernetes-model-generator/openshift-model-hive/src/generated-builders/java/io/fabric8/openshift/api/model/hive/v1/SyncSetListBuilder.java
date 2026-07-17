package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncSetListBuilder extends SyncSetListFluent<SyncSetListBuilder> implements VisitableBuilder<SyncSetList,SyncSetListBuilder>{

  SyncSetListFluent<?> fluent;

  public SyncSetListBuilder() {
    this(new SyncSetList());
  }
  
  public SyncSetListBuilder(SyncSetListFluent<?> fluent) {
    this(fluent, new SyncSetList());
  }
  
  public SyncSetListBuilder(SyncSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncSetListBuilder(SyncSetListFluent<?> fluent,SyncSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncSetList build() {
    SyncSetList buildable = new SyncSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}