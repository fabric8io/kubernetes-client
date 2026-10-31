package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageSigstoreVerificationPolicyBuilder extends ImageSigstoreVerificationPolicyFluent<ImageSigstoreVerificationPolicyBuilder> implements VisitableBuilder<ImageSigstoreVerificationPolicy,ImageSigstoreVerificationPolicyBuilder>{

  ImageSigstoreVerificationPolicyFluent<?> fluent;

  public ImageSigstoreVerificationPolicyBuilder() {
    this(new ImageSigstoreVerificationPolicy());
  }
  
  public ImageSigstoreVerificationPolicyBuilder(ImageSigstoreVerificationPolicyFluent<?> fluent) {
    this(fluent, new ImageSigstoreVerificationPolicy());
  }
  
  public ImageSigstoreVerificationPolicyBuilder(ImageSigstoreVerificationPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageSigstoreVerificationPolicyBuilder(ImageSigstoreVerificationPolicyFluent<?> fluent,ImageSigstoreVerificationPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageSigstoreVerificationPolicy build() {
    ImageSigstoreVerificationPolicy buildable = new ImageSigstoreVerificationPolicy(fluent.buildRootOfTrust(), fluent.buildSignedIdentity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}