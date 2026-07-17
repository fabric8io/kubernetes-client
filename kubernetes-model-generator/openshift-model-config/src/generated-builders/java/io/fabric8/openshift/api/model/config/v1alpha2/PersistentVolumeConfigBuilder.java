package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeConfigBuilder extends PersistentVolumeConfigFluent<PersistentVolumeConfigBuilder> implements VisitableBuilder<PersistentVolumeConfig,PersistentVolumeConfigBuilder>{

  PersistentVolumeConfigFluent<?> fluent;

  public PersistentVolumeConfigBuilder() {
    this(new PersistentVolumeConfig());
  }
  
  public PersistentVolumeConfigBuilder(PersistentVolumeConfigFluent<?> fluent) {
    this(fluent, new PersistentVolumeConfig());
  }
  
  public PersistentVolumeConfigBuilder(PersistentVolumeConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeConfigBuilder(PersistentVolumeConfigFluent<?> fluent,PersistentVolumeConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeConfig build() {
    PersistentVolumeConfig buildable = new PersistentVolumeConfig(fluent.buildClaim(), fluent.getMountPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}