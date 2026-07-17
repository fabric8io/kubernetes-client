package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterServiceVersionSpecBuilder extends ClusterServiceVersionSpecFluent<ClusterServiceVersionSpecBuilder> implements VisitableBuilder<ClusterServiceVersionSpec,ClusterServiceVersionSpecBuilder>{

  ClusterServiceVersionSpecFluent<?> fluent;

  public ClusterServiceVersionSpecBuilder() {
    this(new ClusterServiceVersionSpec());
  }
  
  public ClusterServiceVersionSpecBuilder(ClusterServiceVersionSpecFluent<?> fluent) {
    this(fluent, new ClusterServiceVersionSpec());
  }
  
  public ClusterServiceVersionSpecBuilder(ClusterServiceVersionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterServiceVersionSpecBuilder(ClusterServiceVersionSpecFluent<?> fluent,ClusterServiceVersionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterServiceVersionSpec build() {
    ClusterServiceVersionSpec buildable = new ClusterServiceVersionSpec(fluent.getAnnotations(), fluent.buildApiservicedefinitions(), fluent.buildCleanup(), fluent.buildCustomresourcedefinitions(), fluent.getDescription(), fluent.getDisplayName(), fluent.buildIcon(), fluent.buildInstall(), fluent.buildInstallModes(), fluent.getKeywords(), fluent.getLabels(), fluent.buildLinks(), fluent.buildMaintainers(), fluent.getMaturity(), fluent.getMinKubeVersion(), fluent.getNativeAPIs(), fluent.buildProvider(), fluent.buildRelatedImages(), fluent.getRelease(), fluent.getReplaces(), fluent.buildSelector(), fluent.getSkips(), fluent.getVersion(), fluent.buildWebhookdefinitions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}