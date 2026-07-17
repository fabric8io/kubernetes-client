package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncSetSpecBuilder extends SyncSetSpecFluent<SyncSetSpecBuilder> implements VisitableBuilder<SyncSetSpec,SyncSetSpecBuilder>{

  SyncSetSpecFluent<?> fluent;

  public SyncSetSpecBuilder() {
    this(new SyncSetSpec());
  }
  
  public SyncSetSpecBuilder(SyncSetSpecFluent<?> fluent) {
    this(fluent, new SyncSetSpec());
  }
  
  public SyncSetSpecBuilder(SyncSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncSetSpecBuilder(SyncSetSpecFluent<?> fluent,SyncSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncSetSpec build() {
    SyncSetSpec buildable = new SyncSetSpec(fluent.getApplyBehavior(), fluent.buildClusterDeploymentRefs(), fluent.getEnableResourceTemplates(), fluent.buildPatches(), fluent.getResourceApplyMode(), fluent.getResources(), fluent.buildSecretMappings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}