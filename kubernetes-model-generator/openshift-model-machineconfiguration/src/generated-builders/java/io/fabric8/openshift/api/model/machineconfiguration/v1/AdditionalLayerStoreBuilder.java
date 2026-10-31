package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdditionalLayerStoreBuilder extends AdditionalLayerStoreFluent<AdditionalLayerStoreBuilder> implements VisitableBuilder<AdditionalLayerStore,AdditionalLayerStoreBuilder>{

  AdditionalLayerStoreFluent<?> fluent;

  public AdditionalLayerStoreBuilder() {
    this(new AdditionalLayerStore());
  }
  
  public AdditionalLayerStoreBuilder(AdditionalLayerStoreFluent<?> fluent) {
    this(fluent, new AdditionalLayerStore());
  }
  
  public AdditionalLayerStoreBuilder(AdditionalLayerStore instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdditionalLayerStoreBuilder(AdditionalLayerStoreFluent<?> fluent,AdditionalLayerStore instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdditionalLayerStore build() {
    AdditionalLayerStore buildable = new AdditionalLayerStore(fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}