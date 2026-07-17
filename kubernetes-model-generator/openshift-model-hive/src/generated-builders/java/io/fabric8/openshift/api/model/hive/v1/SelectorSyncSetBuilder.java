package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectorSyncSetBuilder extends SelectorSyncSetFluent<SelectorSyncSetBuilder> implements VisitableBuilder<SelectorSyncSet,SelectorSyncSetBuilder>{

  SelectorSyncSetFluent<?> fluent;

  public SelectorSyncSetBuilder() {
    this(new SelectorSyncSet());
  }
  
  public SelectorSyncSetBuilder(SelectorSyncSetFluent<?> fluent) {
    this(fluent, new SelectorSyncSet());
  }
  
  public SelectorSyncSetBuilder(SelectorSyncSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectorSyncSetBuilder(SelectorSyncSetFluent<?> fluent,SelectorSyncSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelectorSyncSet build() {
    SelectorSyncSet buildable = new SelectorSyncSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}