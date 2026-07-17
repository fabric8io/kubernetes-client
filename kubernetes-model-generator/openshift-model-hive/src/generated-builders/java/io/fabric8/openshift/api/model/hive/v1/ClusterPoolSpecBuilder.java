package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPoolSpecBuilder extends ClusterPoolSpecFluent<ClusterPoolSpecBuilder> implements VisitableBuilder<ClusterPoolSpec,ClusterPoolSpecBuilder>{

  ClusterPoolSpecFluent<?> fluent;

  public ClusterPoolSpecBuilder() {
    this(new ClusterPoolSpec());
  }
  
  public ClusterPoolSpecBuilder(ClusterPoolSpecFluent<?> fluent) {
    this(fluent, new ClusterPoolSpec());
  }
  
  public ClusterPoolSpecBuilder(ClusterPoolSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPoolSpecBuilder(ClusterPoolSpecFluent<?> fluent,ClusterPoolSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPoolSpec build() {
    ClusterPoolSpec buildable = new ClusterPoolSpec(fluent.getAnnotations(), fluent.getBaseDomain(), fluent.buildClaimLifetime(), fluent.getHibernateAfter(), fluent.buildHibernationConfig(), fluent.buildImageSetRef(), fluent.getInstallAttemptsLimit(), fluent.buildInstallConfigSecretTemplateRef(), fluent.buildInstallerEnv(), fluent.buildInventory(), fluent.getLabels(), fluent.getMaxConcurrent(), fluent.getMaxSize(), fluent.buildPlatform(), fluent.buildPullSecretRef(), fluent.getRunningCount(), fluent.getSize(), fluent.getSkipMachinePools());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}