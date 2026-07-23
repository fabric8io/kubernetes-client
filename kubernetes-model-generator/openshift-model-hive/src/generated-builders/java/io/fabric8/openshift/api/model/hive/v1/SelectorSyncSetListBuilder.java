package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectorSyncSetListBuilder extends SelectorSyncSetListFluent<SelectorSyncSetListBuilder> implements VisitableBuilder<SelectorSyncSetList,SelectorSyncSetListBuilder>{

  SelectorSyncSetListFluent<?> fluent;

  public SelectorSyncSetListBuilder() {
    this(new SelectorSyncSetList());
  }
  
  public SelectorSyncSetListBuilder(SelectorSyncSetListFluent<?> fluent) {
    this(fluent, new SelectorSyncSetList());
  }
  
  public SelectorSyncSetListBuilder(SelectorSyncSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectorSyncSetListBuilder(SelectorSyncSetListFluent<?> fluent,SelectorSyncSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelectorSyncSetList build() {
    SelectorSyncSetList buildable = new SelectorSyncSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}