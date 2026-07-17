package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HiveConfigSpecBuilder extends HiveConfigSpecFluent<HiveConfigSpecBuilder> implements VisitableBuilder<HiveConfigSpec,HiveConfigSpecBuilder>{

  HiveConfigSpecFluent<?> fluent;

  public HiveConfigSpecBuilder() {
    this(new HiveConfigSpec());
  }
  
  public HiveConfigSpecBuilder(HiveConfigSpecFluent<?> fluent) {
    this(fluent, new HiveConfigSpec());
  }
  
  public HiveConfigSpecBuilder(HiveConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HiveConfigSpecBuilder(HiveConfigSpecFluent<?> fluent,HiveConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HiveConfigSpec build() {
    HiveConfigSpec buildable = new HiveConfigSpec(fluent.buildAdditionalCertificateAuthoritiesSecretRef(), fluent.buildArgoCDConfig(), fluent.buildAwsPrivateLink(), fluent.buildBackup(), fluent.getClusterVersionPollInterval(), fluent.buildControllersConfig(), fluent.getDeleteProtection(), fluent.buildDeploymentConfig(), fluent.getDeprovisionsDisabled(), fluent.getDisabledControllers(), fluent.getExportMetrics(), fluent.buildFailedProvisionConfig(), fluent.buildFeatureGates(), fluent.buildGlobalPullSecretRef(), fluent.getLogLevel(), fluent.getMachinePoolPollInterval(), fluent.getMaintenanceMode(), fluent.buildManagedDomains(), fluent.buildMetricsConfig(), fluent.buildPrivateLink(), fluent.buildReleaseImageVerificationConfigMapRef(), fluent.buildServiceProviderCredentialsConfig(), fluent.getSyncSetReapplyInterval(), fluent.getTargetNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}