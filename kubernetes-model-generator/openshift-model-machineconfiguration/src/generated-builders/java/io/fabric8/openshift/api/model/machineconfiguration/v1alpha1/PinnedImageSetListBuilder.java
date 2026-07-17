package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PinnedImageSetListBuilder extends PinnedImageSetListFluent<PinnedImageSetListBuilder> implements VisitableBuilder<PinnedImageSetList,PinnedImageSetListBuilder>{

  PinnedImageSetListFluent<?> fluent;

  public PinnedImageSetListBuilder() {
    this(new PinnedImageSetList());
  }
  
  public PinnedImageSetListBuilder(PinnedImageSetListFluent<?> fluent) {
    this(fluent, new PinnedImageSetList());
  }
  
  public PinnedImageSetListBuilder(PinnedImageSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PinnedImageSetListBuilder(PinnedImageSetListFluent<?> fluent,PinnedImageSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PinnedImageSetList build() {
    PinnedImageSetList buildable = new PinnedImageSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}