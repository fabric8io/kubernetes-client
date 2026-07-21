package io.fabric8.openclustermanagement.api.model.shared;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PreConfiguredStorageBuilder extends PreConfiguredStorageFluent<PreConfiguredStorageBuilder> implements VisitableBuilder<PreConfiguredStorage,PreConfiguredStorageBuilder>{

  PreConfiguredStorageFluent<?> fluent;

  public PreConfiguredStorageBuilder() {
    this(new PreConfiguredStorage());
  }
  
  public PreConfiguredStorageBuilder(PreConfiguredStorageFluent<?> fluent) {
    this(fluent, new PreConfiguredStorage());
  }
  
  public PreConfiguredStorageBuilder(PreConfiguredStorage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PreConfiguredStorageBuilder(PreConfiguredStorageFluent<?> fluent,PreConfiguredStorage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PreConfiguredStorage build() {
    PreConfiguredStorage buildable = new PreConfiguredStorage(fluent.getKey(), fluent.getName(), fluent.getServiceAccountProjection(), fluent.getTlsSecretMountPath(), fluent.getTlsSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}