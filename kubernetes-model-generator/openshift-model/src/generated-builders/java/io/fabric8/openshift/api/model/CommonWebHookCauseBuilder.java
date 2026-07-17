package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CommonWebHookCauseBuilder extends CommonWebHookCauseFluent<CommonWebHookCauseBuilder> implements VisitableBuilder<CommonWebHookCause,CommonWebHookCauseBuilder>{

  CommonWebHookCauseFluent<?> fluent;

  public CommonWebHookCauseBuilder() {
    this(new CommonWebHookCause());
  }
  
  public CommonWebHookCauseBuilder(CommonWebHookCauseFluent<?> fluent) {
    this(fluent, new CommonWebHookCause());
  }
  
  public CommonWebHookCauseBuilder(CommonWebHookCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CommonWebHookCauseBuilder(CommonWebHookCauseFluent<?> fluent,CommonWebHookCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CommonWebHookCause build() {
    CommonWebHookCause buildable = new CommonWebHookCause(fluent.buildRevision(), fluent.getSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}