package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReleaseImageVerificationConfigMapReferenceBuilder extends ReleaseImageVerificationConfigMapReferenceFluent<ReleaseImageVerificationConfigMapReferenceBuilder> implements VisitableBuilder<ReleaseImageVerificationConfigMapReference,ReleaseImageVerificationConfigMapReferenceBuilder>{

  ReleaseImageVerificationConfigMapReferenceFluent<?> fluent;

  public ReleaseImageVerificationConfigMapReferenceBuilder() {
    this(new ReleaseImageVerificationConfigMapReference());
  }
  
  public ReleaseImageVerificationConfigMapReferenceBuilder(ReleaseImageVerificationConfigMapReferenceFluent<?> fluent) {
    this(fluent, new ReleaseImageVerificationConfigMapReference());
  }
  
  public ReleaseImageVerificationConfigMapReferenceBuilder(ReleaseImageVerificationConfigMapReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReleaseImageVerificationConfigMapReferenceBuilder(ReleaseImageVerificationConfigMapReferenceFluent<?> fluent,ReleaseImageVerificationConfigMapReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReleaseImageVerificationConfigMapReference build() {
    ReleaseImageVerificationConfigMapReference buildable = new ReleaseImageVerificationConfigMapReference(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}