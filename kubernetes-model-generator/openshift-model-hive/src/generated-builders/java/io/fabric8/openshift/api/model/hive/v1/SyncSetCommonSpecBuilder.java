package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncSetCommonSpecBuilder extends SyncSetCommonSpecFluent<SyncSetCommonSpecBuilder> implements VisitableBuilder<SyncSetCommonSpec,SyncSetCommonSpecBuilder>{

  SyncSetCommonSpecFluent<?> fluent;

  public SyncSetCommonSpecBuilder() {
    this(new SyncSetCommonSpec());
  }
  
  public SyncSetCommonSpecBuilder(SyncSetCommonSpecFluent<?> fluent) {
    this(fluent, new SyncSetCommonSpec());
  }
  
  public SyncSetCommonSpecBuilder(SyncSetCommonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncSetCommonSpecBuilder(SyncSetCommonSpecFluent<?> fluent,SyncSetCommonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncSetCommonSpec build() {
    SyncSetCommonSpec buildable = new SyncSetCommonSpec(fluent.getApplyBehavior(), fluent.getEnableResourceTemplates(), fluent.buildPatches(), fluent.getResourceApplyMode(), fluent.getResources(), fluent.buildSecretMappings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}