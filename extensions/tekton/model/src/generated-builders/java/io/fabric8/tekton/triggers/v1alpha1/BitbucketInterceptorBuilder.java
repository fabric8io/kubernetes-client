package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BitbucketInterceptorBuilder extends BitbucketInterceptorFluent<BitbucketInterceptorBuilder> implements VisitableBuilder<BitbucketInterceptor,BitbucketInterceptorBuilder>{

  BitbucketInterceptorFluent<?> fluent;

  public BitbucketInterceptorBuilder() {
    this(new BitbucketInterceptor());
  }
  
  public BitbucketInterceptorBuilder(BitbucketInterceptorFluent<?> fluent) {
    this(fluent, new BitbucketInterceptor());
  }
  
  public BitbucketInterceptorBuilder(BitbucketInterceptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BitbucketInterceptorBuilder(BitbucketInterceptorFluent<?> fluent,BitbucketInterceptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BitbucketInterceptor build() {
    BitbucketInterceptor buildable = new BitbucketInterceptor(fluent.getEventTypes(), fluent.buildSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}