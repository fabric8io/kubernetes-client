package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PinnedImageSetBuilder extends PinnedImageSetFluent<PinnedImageSetBuilder> implements VisitableBuilder<PinnedImageSet,PinnedImageSetBuilder>{

  PinnedImageSetFluent<?> fluent;

  public PinnedImageSetBuilder() {
    this(new PinnedImageSet());
  }
  
  public PinnedImageSetBuilder(PinnedImageSetFluent<?> fluent) {
    this(fluent, new PinnedImageSet());
  }
  
  public PinnedImageSetBuilder(PinnedImageSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PinnedImageSetBuilder(PinnedImageSetFluent<?> fluent,PinnedImageSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PinnedImageSet build() {
    PinnedImageSet buildable = new PinnedImageSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}