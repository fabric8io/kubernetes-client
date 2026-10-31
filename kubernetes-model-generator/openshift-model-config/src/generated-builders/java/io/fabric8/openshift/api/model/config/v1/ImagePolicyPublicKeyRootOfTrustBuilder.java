package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePolicyPublicKeyRootOfTrustBuilder extends ImagePolicyPublicKeyRootOfTrustFluent<ImagePolicyPublicKeyRootOfTrustBuilder> implements VisitableBuilder<ImagePolicyPublicKeyRootOfTrust,ImagePolicyPublicKeyRootOfTrustBuilder>{

  ImagePolicyPublicKeyRootOfTrustFluent<?> fluent;

  public ImagePolicyPublicKeyRootOfTrustBuilder() {
    this(new ImagePolicyPublicKeyRootOfTrust());
  }
  
  public ImagePolicyPublicKeyRootOfTrustBuilder(ImagePolicyPublicKeyRootOfTrustFluent<?> fluent) {
    this(fluent, new ImagePolicyPublicKeyRootOfTrust());
  }
  
  public ImagePolicyPublicKeyRootOfTrustBuilder(ImagePolicyPublicKeyRootOfTrust instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePolicyPublicKeyRootOfTrustBuilder(ImagePolicyPublicKeyRootOfTrustFluent<?> fluent,ImagePolicyPublicKeyRootOfTrust instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePolicyPublicKeyRootOfTrust build() {
    ImagePolicyPublicKeyRootOfTrust buildable = new ImagePolicyPublicKeyRootOfTrust(fluent.getKeyData(), fluent.getRekorKeyData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}