package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeListBuilder extends PersistentVolumeListFluent<PersistentVolumeListBuilder> implements VisitableBuilder<PersistentVolumeList,PersistentVolumeListBuilder>{

  PersistentVolumeListFluent<?> fluent;

  public PersistentVolumeListBuilder() {
    this(new PersistentVolumeList());
  }
  
  public PersistentVolumeListBuilder(PersistentVolumeListFluent<?> fluent) {
    this(fluent, new PersistentVolumeList());
  }
  
  public PersistentVolumeListBuilder(PersistentVolumeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeListBuilder(PersistentVolumeListFluent<?> fluent,PersistentVolumeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeList build() {
    PersistentVolumeList buildable = new PersistentVolumeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}