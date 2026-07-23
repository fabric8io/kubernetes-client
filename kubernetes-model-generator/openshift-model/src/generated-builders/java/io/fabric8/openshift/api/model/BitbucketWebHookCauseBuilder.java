package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BitbucketWebHookCauseBuilder extends BitbucketWebHookCauseFluent<BitbucketWebHookCauseBuilder> implements VisitableBuilder<BitbucketWebHookCause,BitbucketWebHookCauseBuilder>{

  BitbucketWebHookCauseFluent<?> fluent;

  public BitbucketWebHookCauseBuilder() {
    this(new BitbucketWebHookCause());
  }
  
  public BitbucketWebHookCauseBuilder(BitbucketWebHookCauseFluent<?> fluent) {
    this(fluent, new BitbucketWebHookCause());
  }
  
  public BitbucketWebHookCauseBuilder(BitbucketWebHookCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BitbucketWebHookCauseBuilder(BitbucketWebHookCauseFluent<?> fluent,BitbucketWebHookCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BitbucketWebHookCause build() {
    BitbucketWebHookCause buildable = new BitbucketWebHookCause(fluent.buildRevision(), fluent.getSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}