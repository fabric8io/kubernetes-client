package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdditionalImageStoreBuilder extends AdditionalImageStoreFluent<AdditionalImageStoreBuilder> implements VisitableBuilder<AdditionalImageStore,AdditionalImageStoreBuilder>{

  AdditionalImageStoreFluent<?> fluent;

  public AdditionalImageStoreBuilder() {
    this(new AdditionalImageStore());
  }
  
  public AdditionalImageStoreBuilder(AdditionalImageStoreFluent<?> fluent) {
    this(fluent, new AdditionalImageStore());
  }
  
  public AdditionalImageStoreBuilder(AdditionalImageStore instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdditionalImageStoreBuilder(AdditionalImageStoreFluent<?> fluent,AdditionalImageStore instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdditionalImageStore build() {
    AdditionalImageStore buildable = new AdditionalImageStore(fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}