package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdditionalArtifactStoreBuilder extends AdditionalArtifactStoreFluent<AdditionalArtifactStoreBuilder> implements VisitableBuilder<AdditionalArtifactStore,AdditionalArtifactStoreBuilder>{

  AdditionalArtifactStoreFluent<?> fluent;

  public AdditionalArtifactStoreBuilder() {
    this(new AdditionalArtifactStore());
  }
  
  public AdditionalArtifactStoreBuilder(AdditionalArtifactStoreFluent<?> fluent) {
    this(fluent, new AdditionalArtifactStore());
  }
  
  public AdditionalArtifactStoreBuilder(AdditionalArtifactStore instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdditionalArtifactStoreBuilder(AdditionalArtifactStoreFluent<?> fluent,AdditionalArtifactStore instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdditionalArtifactStore build() {
    AdditionalArtifactStore buildable = new AdditionalArtifactStore(fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}