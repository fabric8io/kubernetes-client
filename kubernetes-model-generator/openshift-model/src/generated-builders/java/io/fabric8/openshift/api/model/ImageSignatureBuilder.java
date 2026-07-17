package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageSignatureBuilder extends ImageSignatureFluent<ImageSignatureBuilder> implements VisitableBuilder<ImageSignature,ImageSignatureBuilder>{

  ImageSignatureFluent<?> fluent;

  public ImageSignatureBuilder() {
    this(new ImageSignature());
  }
  
  public ImageSignatureBuilder(ImageSignatureFluent<?> fluent) {
    this(fluent, new ImageSignature());
  }
  
  public ImageSignatureBuilder(ImageSignature instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageSignatureBuilder(ImageSignatureFluent<?> fluent,ImageSignature instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageSignature build() {
    ImageSignature buildable = new ImageSignature(fluent.getApiVersion(), fluent.buildConditions(), fluent.getContent(), fluent.getCreated(), fluent.getImageIdentity(), fluent.buildIssuedBy(), fluent.buildIssuedTo(), fluent.getKind(), fluent.buildMetadata(), fluent.getSignedClaims(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}