package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectorSyncSetSpecBuilder extends SelectorSyncSetSpecFluent<SelectorSyncSetSpecBuilder> implements VisitableBuilder<SelectorSyncSetSpec,SelectorSyncSetSpecBuilder>{

  SelectorSyncSetSpecFluent<?> fluent;

  public SelectorSyncSetSpecBuilder() {
    this(new SelectorSyncSetSpec());
  }
  
  public SelectorSyncSetSpecBuilder(SelectorSyncSetSpecFluent<?> fluent) {
    this(fluent, new SelectorSyncSetSpec());
  }
  
  public SelectorSyncSetSpecBuilder(SelectorSyncSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectorSyncSetSpecBuilder(SelectorSyncSetSpecFluent<?> fluent,SelectorSyncSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelectorSyncSetSpec build() {
    SelectorSyncSetSpec buildable = new SelectorSyncSetSpec(fluent.getApplyBehavior(), fluent.buildClusterDeploymentSelector(), fluent.getEnableResourceTemplates(), fluent.buildPatches(), fluent.getResourceApplyMode(), fluent.getResources(), fluent.buildSecretMappings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}