package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryStatusBuilder extends ImageRegistryStatusFluent<ImageRegistryStatusBuilder> implements VisitableBuilder<ImageRegistryStatus,ImageRegistryStatusBuilder>{

  ImageRegistryStatusFluent<?> fluent;

  public ImageRegistryStatusBuilder() {
    this(new ImageRegistryStatus());
  }
  
  public ImageRegistryStatusBuilder(ImageRegistryStatusFluent<?> fluent) {
    this(fluent, new ImageRegistryStatus());
  }
  
  public ImageRegistryStatusBuilder(ImageRegistryStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryStatusBuilder(ImageRegistryStatusFluent<?> fluent,ImageRegistryStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryStatus build() {
    ImageRegistryStatus buildable = new ImageRegistryStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.buildStorage(), fluent.getStorageManaged(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}