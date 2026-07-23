package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeClaimListBuilder extends PersistentVolumeClaimListFluent<PersistentVolumeClaimListBuilder> implements VisitableBuilder<PersistentVolumeClaimList,PersistentVolumeClaimListBuilder>{

  PersistentVolumeClaimListFluent<?> fluent;

  public PersistentVolumeClaimListBuilder() {
    this(new PersistentVolumeClaimList());
  }
  
  public PersistentVolumeClaimListBuilder(PersistentVolumeClaimListFluent<?> fluent) {
    this(fluent, new PersistentVolumeClaimList());
  }
  
  public PersistentVolumeClaimListBuilder(PersistentVolumeClaimList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeClaimListBuilder(PersistentVolumeClaimListFluent<?> fluent,PersistentVolumeClaimList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeClaimList build() {
    PersistentVolumeClaimList buildable = new PersistentVolumeClaimList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}