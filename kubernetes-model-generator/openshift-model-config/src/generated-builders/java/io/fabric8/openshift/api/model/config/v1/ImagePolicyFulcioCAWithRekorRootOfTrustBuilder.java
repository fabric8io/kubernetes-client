package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePolicyFulcioCAWithRekorRootOfTrustBuilder extends ImagePolicyFulcioCAWithRekorRootOfTrustFluent<ImagePolicyFulcioCAWithRekorRootOfTrustBuilder> implements VisitableBuilder<ImagePolicyFulcioCAWithRekorRootOfTrust,ImagePolicyFulcioCAWithRekorRootOfTrustBuilder>{

  ImagePolicyFulcioCAWithRekorRootOfTrustFluent<?> fluent;

  public ImagePolicyFulcioCAWithRekorRootOfTrustBuilder() {
    this(new ImagePolicyFulcioCAWithRekorRootOfTrust());
  }
  
  public ImagePolicyFulcioCAWithRekorRootOfTrustBuilder(ImagePolicyFulcioCAWithRekorRootOfTrustFluent<?> fluent) {
    this(fluent, new ImagePolicyFulcioCAWithRekorRootOfTrust());
  }
  
  public ImagePolicyFulcioCAWithRekorRootOfTrustBuilder(ImagePolicyFulcioCAWithRekorRootOfTrust instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePolicyFulcioCAWithRekorRootOfTrustBuilder(ImagePolicyFulcioCAWithRekorRootOfTrustFluent<?> fluent,ImagePolicyFulcioCAWithRekorRootOfTrust instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePolicyFulcioCAWithRekorRootOfTrust build() {
    ImagePolicyFulcioCAWithRekorRootOfTrust buildable = new ImagePolicyFulcioCAWithRekorRootOfTrust(fluent.getFulcioCAData(), fluent.buildFulcioSubject(), fluent.getRekorKeyData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}