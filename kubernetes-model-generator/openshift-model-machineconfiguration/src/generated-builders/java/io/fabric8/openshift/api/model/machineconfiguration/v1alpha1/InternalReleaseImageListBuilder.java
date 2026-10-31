package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalReleaseImageListBuilder extends InternalReleaseImageListFluent<InternalReleaseImageListBuilder> implements VisitableBuilder<InternalReleaseImageList,InternalReleaseImageListBuilder>{

  InternalReleaseImageListFluent<?> fluent;

  public InternalReleaseImageListBuilder() {
    this(new InternalReleaseImageList());
  }
  
  public InternalReleaseImageListBuilder(InternalReleaseImageListFluent<?> fluent) {
    this(fluent, new InternalReleaseImageList());
  }
  
  public InternalReleaseImageListBuilder(InternalReleaseImageList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalReleaseImageListBuilder(InternalReleaseImageListFluent<?> fluent,InternalReleaseImageList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalReleaseImageList build() {
    InternalReleaseImageList buildable = new InternalReleaseImageList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}