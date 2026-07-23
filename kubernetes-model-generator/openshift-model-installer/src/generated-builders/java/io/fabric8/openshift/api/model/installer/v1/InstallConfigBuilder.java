package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallConfigBuilder extends InstallConfigFluent<InstallConfigBuilder> implements VisitableBuilder<InstallConfig,InstallConfigBuilder>{

  InstallConfigFluent<?> fluent;

  public InstallConfigBuilder() {
    this(new InstallConfig());
  }
  
  public InstallConfigBuilder(InstallConfigFluent<?> fluent) {
    this(fluent, new InstallConfig());
  }
  
  public InstallConfigBuilder(InstallConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallConfigBuilder(InstallConfigFluent<?> fluent,InstallConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallConfig build() {
    InstallConfig buildable = new InstallConfig(fluent.getAdditionalTrustBundle(), fluent.getAdditionalTrustBundlePolicy(), fluent.getApiVersion(), fluent.buildArbiter(), fluent.getBaseDomain(), fluent.buildBootstrapInPlace(), fluent.buildCapabilities(), fluent.buildCompute(), fluent.buildControlPlane(), fluent.getCpuPartitioningMode(), fluent.getCredentialsMode(), fluent.getFeatureGates(), fluent.getFeatureSet(), fluent.getFips(), fluent.buildImageContentSources(), fluent.buildImageDigestSources(), fluent.getKind(), fluent.buildMetadata(), fluent.buildNetworking(), fluent.buildOperatorPublishingStrategy(), fluent.buildPlatform(), fluent.buildProxy(), fluent.getPublish(), fluent.getPullSecret(), fluent.getSshKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}