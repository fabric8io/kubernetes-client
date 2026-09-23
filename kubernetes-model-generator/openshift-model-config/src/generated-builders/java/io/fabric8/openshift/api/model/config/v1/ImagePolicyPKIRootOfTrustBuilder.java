package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePolicyPKIRootOfTrustBuilder extends ImagePolicyPKIRootOfTrustFluent<ImagePolicyPKIRootOfTrustBuilder> implements VisitableBuilder<ImagePolicyPKIRootOfTrust,ImagePolicyPKIRootOfTrustBuilder>{

  ImagePolicyPKIRootOfTrustFluent<?> fluent;

  public ImagePolicyPKIRootOfTrustBuilder() {
    this(new ImagePolicyPKIRootOfTrust());
  }
  
  public ImagePolicyPKIRootOfTrustBuilder(ImagePolicyPKIRootOfTrustFluent<?> fluent) {
    this(fluent, new ImagePolicyPKIRootOfTrust());
  }
  
  public ImagePolicyPKIRootOfTrustBuilder(ImagePolicyPKIRootOfTrust instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePolicyPKIRootOfTrustBuilder(ImagePolicyPKIRootOfTrustFluent<?> fluent,ImagePolicyPKIRootOfTrust instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePolicyPKIRootOfTrust build() {
    ImagePolicyPKIRootOfTrust buildable = new ImagePolicyPKIRootOfTrust(fluent.getCaIntermediatesData(), fluent.getCaRootsData(), fluent.buildPkiCertificateSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}