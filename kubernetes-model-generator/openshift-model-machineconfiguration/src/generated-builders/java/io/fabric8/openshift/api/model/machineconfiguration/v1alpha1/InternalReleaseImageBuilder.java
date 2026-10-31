package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalReleaseImageBuilder extends InternalReleaseImageFluent<InternalReleaseImageBuilder> implements VisitableBuilder<InternalReleaseImage,InternalReleaseImageBuilder>{

  InternalReleaseImageFluent<?> fluent;

  public InternalReleaseImageBuilder() {
    this(new InternalReleaseImage());
  }
  
  public InternalReleaseImageBuilder(InternalReleaseImageFluent<?> fluent) {
    this(fluent, new InternalReleaseImage());
  }
  
  public InternalReleaseImageBuilder(InternalReleaseImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalReleaseImageBuilder(InternalReleaseImageFluent<?> fluent,InternalReleaseImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalReleaseImage build() {
    InternalReleaseImage buildable = new InternalReleaseImage(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}