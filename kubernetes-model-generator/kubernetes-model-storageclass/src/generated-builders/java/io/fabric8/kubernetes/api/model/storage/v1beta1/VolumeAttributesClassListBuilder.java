package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeAttributesClassListBuilder extends VolumeAttributesClassListFluent<VolumeAttributesClassListBuilder> implements VisitableBuilder<VolumeAttributesClassList,VolumeAttributesClassListBuilder>{

  VolumeAttributesClassListFluent<?> fluent;

  public VolumeAttributesClassListBuilder() {
    this(new VolumeAttributesClassList());
  }
  
  public VolumeAttributesClassListBuilder(VolumeAttributesClassListFluent<?> fluent) {
    this(fluent, new VolumeAttributesClassList());
  }
  
  public VolumeAttributesClassListBuilder(VolumeAttributesClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeAttributesClassListBuilder(VolumeAttributesClassListFluent<?> fluent,VolumeAttributesClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeAttributesClassList build() {
    VolumeAttributesClassList buildable = new VolumeAttributesClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}