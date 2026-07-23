package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CommonSpecBuilder extends CommonSpecFluent<CommonSpecBuilder> implements VisitableBuilder<CommonSpec,CommonSpecBuilder>{

  CommonSpecFluent<?> fluent;

  public CommonSpecBuilder() {
    this(new CommonSpec());
  }
  
  public CommonSpecBuilder(CommonSpecFluent<?> fluent) {
    this(fluent, new CommonSpec());
  }
  
  public CommonSpecBuilder(CommonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CommonSpecBuilder(CommonSpecFluent<?> fluent,CommonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CommonSpec build() {
    CommonSpec buildable = new CommonSpec(fluent.getCompletionDeadlineSeconds(), fluent.getMountTrustedCA(), fluent.getNodeSelector(), fluent.buildOutput(), fluent.buildPostCommit(), fluent.buildResources(), fluent.buildRevision(), fluent.getServiceAccount(), fluent.buildSource(), fluent.buildStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}