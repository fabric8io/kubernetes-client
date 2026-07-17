package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmbeddedPersistentVolumeClaimBuilder extends EmbeddedPersistentVolumeClaimFluent<EmbeddedPersistentVolumeClaimBuilder> implements VisitableBuilder<EmbeddedPersistentVolumeClaim,EmbeddedPersistentVolumeClaimBuilder>{

  EmbeddedPersistentVolumeClaimFluent<?> fluent;

  public EmbeddedPersistentVolumeClaimBuilder() {
    this(new EmbeddedPersistentVolumeClaim());
  }
  
  public EmbeddedPersistentVolumeClaimBuilder(EmbeddedPersistentVolumeClaimFluent<?> fluent) {
    this(fluent, new EmbeddedPersistentVolumeClaim());
  }
  
  public EmbeddedPersistentVolumeClaimBuilder(EmbeddedPersistentVolumeClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmbeddedPersistentVolumeClaimBuilder(EmbeddedPersistentVolumeClaimFluent<?> fluent,EmbeddedPersistentVolumeClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmbeddedPersistentVolumeClaim build() {
    EmbeddedPersistentVolumeClaim buildable = new EmbeddedPersistentVolumeClaim(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.getSpec(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}