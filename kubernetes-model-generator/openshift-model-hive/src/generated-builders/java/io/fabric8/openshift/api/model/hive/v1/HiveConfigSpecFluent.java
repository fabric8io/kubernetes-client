package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.openshift.api.model.hive.metricsconfig.v1.MetricsConfig;
import io.fabric8.openshift.api.model.hive.metricsconfig.v1.MetricsConfigBuilder;
import io.fabric8.openshift.api.model.hive.metricsconfig.v1.MetricsConfigFluent;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HiveConfigSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.HiveConfigSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<LocalObjectReferenceBuilder> additionalCertificateAuthoritiesSecretRef = new ArrayList<LocalObjectReferenceBuilder>();
  private Map<String,Object> additionalProperties;
  private ArgoCDConfigBuilder argoCDConfig;
  private AWSPrivateLinkConfigBuilder awsPrivateLink;
  private BackupConfigBuilder backup;
  private String clusterVersionPollInterval;
  private ControllersConfigBuilder controllersConfig;
  private String deleteProtection;
  private ArrayList<DeploymentConfigBuilder> deploymentConfig = new ArrayList<DeploymentConfigBuilder>();
  private Boolean deprovisionsDisabled;
  private List<String> disabledControllers = new ArrayList<String>();
  private Boolean exportMetrics;
  private FailedProvisionConfigBuilder failedProvisionConfig;
  private FeatureGateSelectionBuilder featureGates;
  private LocalObjectReferenceBuilder globalPullSecretRef;
  private String logLevel;
  private String machinePoolPollInterval;
  private Boolean maintenanceMode;
  private ArrayList<ManageDNSConfigBuilder> managedDomains = new ArrayList<ManageDNSConfigBuilder>();
  private MetricsConfigBuilder metricsConfig;
  private PrivateLinkConfigBuilder privateLink;
  private ReleaseImageVerificationConfigMapReferenceBuilder releaseImageVerificationConfigMapRef;
  private ServiceProviderCredentialsBuilder serviceProviderCredentialsConfig;
  private String syncSetReapplyInterval;
  private String targetNamespace;

  public HiveConfigSpecFluent() {
  }
  
  public HiveConfigSpecFluent(HiveConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalCertificateAuthoritiesSecretRef(Collection<LocalObjectReference> items) {
    if (this.additionalCertificateAuthoritiesSecretRef == null) {
      this.additionalCertificateAuthoritiesSecretRef = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("additionalCertificateAuthoritiesSecretRef").add(builder);
        this.additionalCertificateAuthoritiesSecretRef.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDeploymentConfig(Collection<DeploymentConfig> items) {
    if (this.deploymentConfig == null) {
      this.deploymentConfig = new ArrayList();
    }
    for (DeploymentConfig item : items) {
        DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
        _visitables.get("deploymentConfig").add(builder);
        this.deploymentConfig.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDisabledControllers(Collection<String> items) {
    if (this.disabledControllers == null) {
      this.disabledControllers = new ArrayList();
    }
    for (String item : items) {
      this.disabledControllers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToManagedDomains(Collection<ManageDNSConfig> items) {
    if (this.managedDomains == null) {
      this.managedDomains = new ArrayList();
    }
    for (ManageDNSConfig item : items) {
        ManageDNSConfigBuilder builder = new ManageDNSConfigBuilder(item);
        _visitables.get("managedDomains").add(builder);
        this.managedDomains.add(builder);
    }
    return (A) this;
  }
  
  public AdditionalCertificateAuthoritiesSecretRefNested<A> addNewAdditionalCertificateAuthoritiesSecretRef() {
    return new AdditionalCertificateAuthoritiesSecretRefNested(-1, null);
  }
  
  public A addNewAdditionalCertificateAuthoritiesSecretRef(String name) {
    return (A) this.addToAdditionalCertificateAuthoritiesSecretRef(new LocalObjectReference(name));
  }
  
  public AdditionalCertificateAuthoritiesSecretRefNested<A> addNewAdditionalCertificateAuthoritiesSecretRefLike(LocalObjectReference item) {
    return new AdditionalCertificateAuthoritiesSecretRefNested(-1, item);
  }
  
  public DeploymentConfigNested<A> addNewDeploymentConfig() {
    return new DeploymentConfigNested(-1, null);
  }
  
  public DeploymentConfigNested<A> addNewDeploymentConfigLike(DeploymentConfig item) {
    return new DeploymentConfigNested(-1, item);
  }
  
  public ManagedDomainsNested<A> addNewManagedDomain() {
    return new ManagedDomainsNested(-1, null);
  }
  
  public ManagedDomainsNested<A> addNewManagedDomainLike(ManageDNSConfig item) {
    return new ManagedDomainsNested(-1, item);
  }
  
  public A addToAdditionalCertificateAuthoritiesSecretRef(LocalObjectReference... items) {
    if (this.additionalCertificateAuthoritiesSecretRef == null) {
      this.additionalCertificateAuthoritiesSecretRef = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("additionalCertificateAuthoritiesSecretRef").add(builder);
        this.additionalCertificateAuthoritiesSecretRef.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalCertificateAuthoritiesSecretRef(int index,LocalObjectReference item) {
    if (this.additionalCertificateAuthoritiesSecretRef == null) {
      this.additionalCertificateAuthoritiesSecretRef = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= additionalCertificateAuthoritiesSecretRef.size()) {
        _visitables.get("additionalCertificateAuthoritiesSecretRef").add(builder);
        additionalCertificateAuthoritiesSecretRef.add(builder);
    } else {
        _visitables.get("additionalCertificateAuthoritiesSecretRef").add(builder);
        additionalCertificateAuthoritiesSecretRef.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToDeploymentConfig(DeploymentConfig... items) {
    if (this.deploymentConfig == null) {
      this.deploymentConfig = new ArrayList();
    }
    for (DeploymentConfig item : items) {
        DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
        _visitables.get("deploymentConfig").add(builder);
        this.deploymentConfig.add(builder);
    }
    return (A) this;
  }
  
  public A addToDeploymentConfig(int index,DeploymentConfig item) {
    if (this.deploymentConfig == null) {
      this.deploymentConfig = new ArrayList();
    }
    DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
    if (index < 0 || index >= deploymentConfig.size()) {
        _visitables.get("deploymentConfig").add(builder);
        deploymentConfig.add(builder);
    } else {
        _visitables.get("deploymentConfig").add(builder);
        deploymentConfig.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDisabledControllers(String... items) {
    if (this.disabledControllers == null) {
      this.disabledControllers = new ArrayList();
    }
    for (String item : items) {
      this.disabledControllers.add(item);
    }
    return (A) this;
  }
  
  public A addToDisabledControllers(int index,String item) {
    if (this.disabledControllers == null) {
      this.disabledControllers = new ArrayList();
    }
    this.disabledControllers.add(index, item);
    return (A) this;
  }
  
  public A addToManagedDomains(ManageDNSConfig... items) {
    if (this.managedDomains == null) {
      this.managedDomains = new ArrayList();
    }
    for (ManageDNSConfig item : items) {
        ManageDNSConfigBuilder builder = new ManageDNSConfigBuilder(item);
        _visitables.get("managedDomains").add(builder);
        this.managedDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addToManagedDomains(int index,ManageDNSConfig item) {
    if (this.managedDomains == null) {
      this.managedDomains = new ArrayList();
    }
    ManageDNSConfigBuilder builder = new ManageDNSConfigBuilder(item);
    if (index < 0 || index >= managedDomains.size()) {
        _visitables.get("managedDomains").add(builder);
        managedDomains.add(builder);
    } else {
        _visitables.get("managedDomains").add(builder);
        managedDomains.add(index, builder);
    }
    return (A) this;
  }
  
  public List<LocalObjectReference> buildAdditionalCertificateAuthoritiesSecretRef() {
    return this.additionalCertificateAuthoritiesSecretRef != null ? build(additionalCertificateAuthoritiesSecretRef) : null;
  }
  
  public LocalObjectReference buildAdditionalCertificateAuthoritiesSecretRef(int index) {
    return this.additionalCertificateAuthoritiesSecretRef.get(index).build();
  }
  
  public ArgoCDConfig buildArgoCDConfig() {
    return this.argoCDConfig != null ? this.argoCDConfig.build() : null;
  }
  
  public AWSPrivateLinkConfig buildAwsPrivateLink() {
    return this.awsPrivateLink != null ? this.awsPrivateLink.build() : null;
  }
  
  public BackupConfig buildBackup() {
    return this.backup != null ? this.backup.build() : null;
  }
  
  public ControllersConfig buildControllersConfig() {
    return this.controllersConfig != null ? this.controllersConfig.build() : null;
  }
  
  public List<DeploymentConfig> buildDeploymentConfig() {
    return this.deploymentConfig != null ? build(deploymentConfig) : null;
  }
  
  public DeploymentConfig buildDeploymentConfig(int index) {
    return this.deploymentConfig.get(index).build();
  }
  
  public FailedProvisionConfig buildFailedProvisionConfig() {
    return this.failedProvisionConfig != null ? this.failedProvisionConfig.build() : null;
  }
  
  public FeatureGateSelection buildFeatureGates() {
    return this.featureGates != null ? this.featureGates.build() : null;
  }
  
  public LocalObjectReference buildFirstAdditionalCertificateAuthoritiesSecretRef() {
    return this.additionalCertificateAuthoritiesSecretRef.get(0).build();
  }
  
  public DeploymentConfig buildFirstDeploymentConfig() {
    return this.deploymentConfig.get(0).build();
  }
  
  public ManageDNSConfig buildFirstManagedDomain() {
    return this.managedDomains.get(0).build();
  }
  
  public LocalObjectReference buildGlobalPullSecretRef() {
    return this.globalPullSecretRef != null ? this.globalPullSecretRef.build() : null;
  }
  
  public LocalObjectReference buildLastAdditionalCertificateAuthoritiesSecretRef() {
    return this.additionalCertificateAuthoritiesSecretRef.get(additionalCertificateAuthoritiesSecretRef.size() - 1).build();
  }
  
  public DeploymentConfig buildLastDeploymentConfig() {
    return this.deploymentConfig.get(deploymentConfig.size() - 1).build();
  }
  
  public ManageDNSConfig buildLastManagedDomain() {
    return this.managedDomains.get(managedDomains.size() - 1).build();
  }
  
  public ManageDNSConfig buildManagedDomain(int index) {
    return this.managedDomains.get(index).build();
  }
  
  public List<ManageDNSConfig> buildManagedDomains() {
    return this.managedDomains != null ? build(managedDomains) : null;
  }
  
  public LocalObjectReference buildMatchingAdditionalCertificateAuthoritiesSecretRef(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : additionalCertificateAuthoritiesSecretRef) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeploymentConfig buildMatchingDeploymentConfig(Predicate<DeploymentConfigBuilder> predicate) {
      for (DeploymentConfigBuilder item : deploymentConfig) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ManageDNSConfig buildMatchingManagedDomain(Predicate<ManageDNSConfigBuilder> predicate) {
      for (ManageDNSConfigBuilder item : managedDomains) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetricsConfig buildMetricsConfig() {
    return this.metricsConfig != null ? this.metricsConfig.build() : null;
  }
  
  public PrivateLinkConfig buildPrivateLink() {
    return this.privateLink != null ? this.privateLink.build() : null;
  }
  
  public ReleaseImageVerificationConfigMapReference buildReleaseImageVerificationConfigMapRef() {
    return this.releaseImageVerificationConfigMapRef != null ? this.releaseImageVerificationConfigMapRef.build() : null;
  }
  
  public ServiceProviderCredentials buildServiceProviderCredentialsConfig() {
    return this.serviceProviderCredentialsConfig != null ? this.serviceProviderCredentialsConfig.build() : null;
  }
  
  protected void copyInstance(HiveConfigSpec instance) {
    instance = instance != null ? instance : new HiveConfigSpec();
    if (instance != null) {
        this.withAdditionalCertificateAuthoritiesSecretRef(instance.getAdditionalCertificateAuthoritiesSecretRef());
        this.withArgoCDConfig(instance.getArgoCDConfig());
        this.withAwsPrivateLink(instance.getAwsPrivateLink());
        this.withBackup(instance.getBackup());
        this.withClusterVersionPollInterval(instance.getClusterVersionPollInterval());
        this.withControllersConfig(instance.getControllersConfig());
        this.withDeleteProtection(instance.getDeleteProtection());
        this.withDeploymentConfig(instance.getDeploymentConfig());
        this.withDeprovisionsDisabled(instance.getDeprovisionsDisabled());
        this.withDisabledControllers(instance.getDisabledControllers());
        this.withExportMetrics(instance.getExportMetrics());
        this.withFailedProvisionConfig(instance.getFailedProvisionConfig());
        this.withFeatureGates(instance.getFeatureGates());
        this.withGlobalPullSecretRef(instance.getGlobalPullSecretRef());
        this.withLogLevel(instance.getLogLevel());
        this.withMachinePoolPollInterval(instance.getMachinePoolPollInterval());
        this.withMaintenanceMode(instance.getMaintenanceMode());
        this.withManagedDomains(instance.getManagedDomains());
        this.withMetricsConfig(instance.getMetricsConfig());
        this.withPrivateLink(instance.getPrivateLink());
        this.withReleaseImageVerificationConfigMapRef(instance.getReleaseImageVerificationConfigMapRef());
        this.withServiceProviderCredentialsConfig(instance.getServiceProviderCredentialsConfig());
        this.withSyncSetReapplyInterval(instance.getSyncSetReapplyInterval());
        this.withTargetNamespace(instance.getTargetNamespace());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalCertificateAuthoritiesSecretRefNested<A> editAdditionalCertificateAuthoritiesSecretRef(int index) {
    if (additionalCertificateAuthoritiesSecretRef.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalCertificateAuthoritiesSecretRef"));
    }
    return this.setNewAdditionalCertificateAuthoritiesSecretRefLike(index, this.buildAdditionalCertificateAuthoritiesSecretRef(index));
  }
  
  public ArgoCDConfigNested<A> editArgoCDConfig() {
    return this.withNewArgoCDConfigLike(Optional.ofNullable(this.buildArgoCDConfig()).orElse(null));
  }
  
  public AwsPrivateLinkNested<A> editAwsPrivateLink() {
    return this.withNewAwsPrivateLinkLike(Optional.ofNullable(this.buildAwsPrivateLink()).orElse(null));
  }
  
  public BackupNested<A> editBackup() {
    return this.withNewBackupLike(Optional.ofNullable(this.buildBackup()).orElse(null));
  }
  
  public ControllersConfigNested<A> editControllersConfig() {
    return this.withNewControllersConfigLike(Optional.ofNullable(this.buildControllersConfig()).orElse(null));
  }
  
  public DeploymentConfigNested<A> editDeploymentConfig(int index) {
    if (deploymentConfig.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "deploymentConfig"));
    }
    return this.setNewDeploymentConfigLike(index, this.buildDeploymentConfig(index));
  }
  
  public FailedProvisionConfigNested<A> editFailedProvisionConfig() {
    return this.withNewFailedProvisionConfigLike(Optional.ofNullable(this.buildFailedProvisionConfig()).orElse(null));
  }
  
  public FeatureGatesNested<A> editFeatureGates() {
    return this.withNewFeatureGatesLike(Optional.ofNullable(this.buildFeatureGates()).orElse(null));
  }
  
  public AdditionalCertificateAuthoritiesSecretRefNested<A> editFirstAdditionalCertificateAuthoritiesSecretRef() {
    if (additionalCertificateAuthoritiesSecretRef.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalCertificateAuthoritiesSecretRef"));
    }
    return this.setNewAdditionalCertificateAuthoritiesSecretRefLike(0, this.buildAdditionalCertificateAuthoritiesSecretRef(0));
  }
  
  public DeploymentConfigNested<A> editFirstDeploymentConfig() {
    if (deploymentConfig.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "deploymentConfig"));
    }
    return this.setNewDeploymentConfigLike(0, this.buildDeploymentConfig(0));
  }
  
  public ManagedDomainsNested<A> editFirstManagedDomain() {
    if (managedDomains.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "managedDomains"));
    }
    return this.setNewManagedDomainLike(0, this.buildManagedDomain(0));
  }
  
  public GlobalPullSecretRefNested<A> editGlobalPullSecretRef() {
    return this.withNewGlobalPullSecretRefLike(Optional.ofNullable(this.buildGlobalPullSecretRef()).orElse(null));
  }
  
  public AdditionalCertificateAuthoritiesSecretRefNested<A> editLastAdditionalCertificateAuthoritiesSecretRef() {
    int index = additionalCertificateAuthoritiesSecretRef.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalCertificateAuthoritiesSecretRef"));
    }
    return this.setNewAdditionalCertificateAuthoritiesSecretRefLike(index, this.buildAdditionalCertificateAuthoritiesSecretRef(index));
  }
  
  public DeploymentConfigNested<A> editLastDeploymentConfig() {
    int index = deploymentConfig.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "deploymentConfig"));
    }
    return this.setNewDeploymentConfigLike(index, this.buildDeploymentConfig(index));
  }
  
  public ManagedDomainsNested<A> editLastManagedDomain() {
    int index = managedDomains.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "managedDomains"));
    }
    return this.setNewManagedDomainLike(index, this.buildManagedDomain(index));
  }
  
  public ManagedDomainsNested<A> editManagedDomain(int index) {
    if (managedDomains.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "managedDomains"));
    }
    return this.setNewManagedDomainLike(index, this.buildManagedDomain(index));
  }
  
  public AdditionalCertificateAuthoritiesSecretRefNested<A> editMatchingAdditionalCertificateAuthoritiesSecretRef(Predicate<LocalObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalCertificateAuthoritiesSecretRef.size();i++) {
      if (predicate.test(additionalCertificateAuthoritiesSecretRef.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalCertificateAuthoritiesSecretRef"));
    }
    return this.setNewAdditionalCertificateAuthoritiesSecretRefLike(index, this.buildAdditionalCertificateAuthoritiesSecretRef(index));
  }
  
  public DeploymentConfigNested<A> editMatchingDeploymentConfig(Predicate<DeploymentConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < deploymentConfig.size();i++) {
      if (predicate.test(deploymentConfig.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "deploymentConfig"));
    }
    return this.setNewDeploymentConfigLike(index, this.buildDeploymentConfig(index));
  }
  
  public ManagedDomainsNested<A> editMatchingManagedDomain(Predicate<ManageDNSConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < managedDomains.size();i++) {
      if (predicate.test(managedDomains.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "managedDomains"));
    }
    return this.setNewManagedDomainLike(index, this.buildManagedDomain(index));
  }
  
  public MetricsConfigNested<A> editMetricsConfig() {
    return this.withNewMetricsConfigLike(Optional.ofNullable(this.buildMetricsConfig()).orElse(null));
  }
  
  public ArgoCDConfigNested<A> editOrNewArgoCDConfig() {
    return this.withNewArgoCDConfigLike(Optional.ofNullable(this.buildArgoCDConfig()).orElse(new ArgoCDConfigBuilder().build()));
  }
  
  public ArgoCDConfigNested<A> editOrNewArgoCDConfigLike(ArgoCDConfig item) {
    return this.withNewArgoCDConfigLike(Optional.ofNullable(this.buildArgoCDConfig()).orElse(item));
  }
  
  public AwsPrivateLinkNested<A> editOrNewAwsPrivateLink() {
    return this.withNewAwsPrivateLinkLike(Optional.ofNullable(this.buildAwsPrivateLink()).orElse(new AWSPrivateLinkConfigBuilder().build()));
  }
  
  public AwsPrivateLinkNested<A> editOrNewAwsPrivateLinkLike(AWSPrivateLinkConfig item) {
    return this.withNewAwsPrivateLinkLike(Optional.ofNullable(this.buildAwsPrivateLink()).orElse(item));
  }
  
  public BackupNested<A> editOrNewBackup() {
    return this.withNewBackupLike(Optional.ofNullable(this.buildBackup()).orElse(new BackupConfigBuilder().build()));
  }
  
  public BackupNested<A> editOrNewBackupLike(BackupConfig item) {
    return this.withNewBackupLike(Optional.ofNullable(this.buildBackup()).orElse(item));
  }
  
  public ControllersConfigNested<A> editOrNewControllersConfig() {
    return this.withNewControllersConfigLike(Optional.ofNullable(this.buildControllersConfig()).orElse(new ControllersConfigBuilder().build()));
  }
  
  public ControllersConfigNested<A> editOrNewControllersConfigLike(ControllersConfig item) {
    return this.withNewControllersConfigLike(Optional.ofNullable(this.buildControllersConfig()).orElse(item));
  }
  
  public FailedProvisionConfigNested<A> editOrNewFailedProvisionConfig() {
    return this.withNewFailedProvisionConfigLike(Optional.ofNullable(this.buildFailedProvisionConfig()).orElse(new FailedProvisionConfigBuilder().build()));
  }
  
  public FailedProvisionConfigNested<A> editOrNewFailedProvisionConfigLike(FailedProvisionConfig item) {
    return this.withNewFailedProvisionConfigLike(Optional.ofNullable(this.buildFailedProvisionConfig()).orElse(item));
  }
  
  public FeatureGatesNested<A> editOrNewFeatureGates() {
    return this.withNewFeatureGatesLike(Optional.ofNullable(this.buildFeatureGates()).orElse(new FeatureGateSelectionBuilder().build()));
  }
  
  public FeatureGatesNested<A> editOrNewFeatureGatesLike(FeatureGateSelection item) {
    return this.withNewFeatureGatesLike(Optional.ofNullable(this.buildFeatureGates()).orElse(item));
  }
  
  public GlobalPullSecretRefNested<A> editOrNewGlobalPullSecretRef() {
    return this.withNewGlobalPullSecretRefLike(Optional.ofNullable(this.buildGlobalPullSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public GlobalPullSecretRefNested<A> editOrNewGlobalPullSecretRefLike(LocalObjectReference item) {
    return this.withNewGlobalPullSecretRefLike(Optional.ofNullable(this.buildGlobalPullSecretRef()).orElse(item));
  }
  
  public MetricsConfigNested<A> editOrNewMetricsConfig() {
    return this.withNewMetricsConfigLike(Optional.ofNullable(this.buildMetricsConfig()).orElse(new MetricsConfigBuilder().build()));
  }
  
  public MetricsConfigNested<A> editOrNewMetricsConfigLike(MetricsConfig item) {
    return this.withNewMetricsConfigLike(Optional.ofNullable(this.buildMetricsConfig()).orElse(item));
  }
  
  public PrivateLinkNested<A> editOrNewPrivateLink() {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(new PrivateLinkConfigBuilder().build()));
  }
  
  public PrivateLinkNested<A> editOrNewPrivateLinkLike(PrivateLinkConfig item) {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(item));
  }
  
  public ReleaseImageVerificationConfigMapRefNested<A> editOrNewReleaseImageVerificationConfigMapRef() {
    return this.withNewReleaseImageVerificationConfigMapRefLike(Optional.ofNullable(this.buildReleaseImageVerificationConfigMapRef()).orElse(new ReleaseImageVerificationConfigMapReferenceBuilder().build()));
  }
  
  public ReleaseImageVerificationConfigMapRefNested<A> editOrNewReleaseImageVerificationConfigMapRefLike(ReleaseImageVerificationConfigMapReference item) {
    return this.withNewReleaseImageVerificationConfigMapRefLike(Optional.ofNullable(this.buildReleaseImageVerificationConfigMapRef()).orElse(item));
  }
  
  public ServiceProviderCredentialsConfigNested<A> editOrNewServiceProviderCredentialsConfig() {
    return this.withNewServiceProviderCredentialsConfigLike(Optional.ofNullable(this.buildServiceProviderCredentialsConfig()).orElse(new ServiceProviderCredentialsBuilder().build()));
  }
  
  public ServiceProviderCredentialsConfigNested<A> editOrNewServiceProviderCredentialsConfigLike(ServiceProviderCredentials item) {
    return this.withNewServiceProviderCredentialsConfigLike(Optional.ofNullable(this.buildServiceProviderCredentialsConfig()).orElse(item));
  }
  
  public PrivateLinkNested<A> editPrivateLink() {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(null));
  }
  
  public ReleaseImageVerificationConfigMapRefNested<A> editReleaseImageVerificationConfigMapRef() {
    return this.withNewReleaseImageVerificationConfigMapRefLike(Optional.ofNullable(this.buildReleaseImageVerificationConfigMapRef()).orElse(null));
  }
  
  public ServiceProviderCredentialsConfigNested<A> editServiceProviderCredentialsConfig() {
    return this.withNewServiceProviderCredentialsConfigLike(Optional.ofNullable(this.buildServiceProviderCredentialsConfig()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    HiveConfigSpecFluent that = (HiveConfigSpecFluent) o;
    if (!(Objects.equals(additionalCertificateAuthoritiesSecretRef, that.additionalCertificateAuthoritiesSecretRef))) {
      return false;
    }
    if (!(Objects.equals(argoCDConfig, that.argoCDConfig))) {
      return false;
    }
    if (!(Objects.equals(awsPrivateLink, that.awsPrivateLink))) {
      return false;
    }
    if (!(Objects.equals(backup, that.backup))) {
      return false;
    }
    if (!(Objects.equals(clusterVersionPollInterval, that.clusterVersionPollInterval))) {
      return false;
    }
    if (!(Objects.equals(controllersConfig, that.controllersConfig))) {
      return false;
    }
    if (!(Objects.equals(deleteProtection, that.deleteProtection))) {
      return false;
    }
    if (!(Objects.equals(deploymentConfig, that.deploymentConfig))) {
      return false;
    }
    if (!(Objects.equals(deprovisionsDisabled, that.deprovisionsDisabled))) {
      return false;
    }
    if (!(Objects.equals(disabledControllers, that.disabledControllers))) {
      return false;
    }
    if (!(Objects.equals(exportMetrics, that.exportMetrics))) {
      return false;
    }
    if (!(Objects.equals(failedProvisionConfig, that.failedProvisionConfig))) {
      return false;
    }
    if (!(Objects.equals(featureGates, that.featureGates))) {
      return false;
    }
    if (!(Objects.equals(globalPullSecretRef, that.globalPullSecretRef))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(machinePoolPollInterval, that.machinePoolPollInterval))) {
      return false;
    }
    if (!(Objects.equals(maintenanceMode, that.maintenanceMode))) {
      return false;
    }
    if (!(Objects.equals(managedDomains, that.managedDomains))) {
      return false;
    }
    if (!(Objects.equals(metricsConfig, that.metricsConfig))) {
      return false;
    }
    if (!(Objects.equals(privateLink, that.privateLink))) {
      return false;
    }
    if (!(Objects.equals(releaseImageVerificationConfigMapRef, that.releaseImageVerificationConfigMapRef))) {
      return false;
    }
    if (!(Objects.equals(serviceProviderCredentialsConfig, that.serviceProviderCredentialsConfig))) {
      return false;
    }
    if (!(Objects.equals(syncSetReapplyInterval, that.syncSetReapplyInterval))) {
      return false;
    }
    if (!(Objects.equals(targetNamespace, that.targetNamespace))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getClusterVersionPollInterval() {
    return this.clusterVersionPollInterval;
  }
  
  public String getDeleteProtection() {
    return this.deleteProtection;
  }
  
  public Boolean getDeprovisionsDisabled() {
    return this.deprovisionsDisabled;
  }
  
  public String getDisabledController(int index) {
    return this.disabledControllers.get(index);
  }
  
  public List<String> getDisabledControllers() {
    return this.disabledControllers;
  }
  
  public Boolean getExportMetrics() {
    return this.exportMetrics;
  }
  
  public String getFirstDisabledController() {
    return this.disabledControllers.get(0);
  }
  
  public String getLastDisabledController() {
    return this.disabledControllers.get(disabledControllers.size() - 1);
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getMachinePoolPollInterval() {
    return this.machinePoolPollInterval;
  }
  
  public Boolean getMaintenanceMode() {
    return this.maintenanceMode;
  }
  
  public String getMatchingDisabledController(Predicate<String> predicate) {
      for (String item : disabledControllers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getSyncSetReapplyInterval() {
    return this.syncSetReapplyInterval;
  }
  
  public String getTargetNamespace() {
    return this.targetNamespace;
  }
  
  public boolean hasAdditionalCertificateAuthoritiesSecretRef() {
    return this.additionalCertificateAuthoritiesSecretRef != null && !(this.additionalCertificateAuthoritiesSecretRef.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArgoCDConfig() {
    return this.argoCDConfig != null;
  }
  
  public boolean hasAwsPrivateLink() {
    return this.awsPrivateLink != null;
  }
  
  public boolean hasBackup() {
    return this.backup != null;
  }
  
  public boolean hasClusterVersionPollInterval() {
    return this.clusterVersionPollInterval != null;
  }
  
  public boolean hasControllersConfig() {
    return this.controllersConfig != null;
  }
  
  public boolean hasDeleteProtection() {
    return this.deleteProtection != null;
  }
  
  public boolean hasDeploymentConfig() {
    return this.deploymentConfig != null && !(this.deploymentConfig.isEmpty());
  }
  
  public boolean hasDeprovisionsDisabled() {
    return this.deprovisionsDisabled != null;
  }
  
  public boolean hasDisabledControllers() {
    return this.disabledControllers != null && !(this.disabledControllers.isEmpty());
  }
  
  public boolean hasExportMetrics() {
    return this.exportMetrics != null;
  }
  
  public boolean hasFailedProvisionConfig() {
    return this.failedProvisionConfig != null;
  }
  
  public boolean hasFeatureGates() {
    return this.featureGates != null;
  }
  
  public boolean hasGlobalPullSecretRef() {
    return this.globalPullSecretRef != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasMachinePoolPollInterval() {
    return this.machinePoolPollInterval != null;
  }
  
  public boolean hasMaintenanceMode() {
    return this.maintenanceMode != null;
  }
  
  public boolean hasManagedDomains() {
    return this.managedDomains != null && !(this.managedDomains.isEmpty());
  }
  
  public boolean hasMatchingAdditionalCertificateAuthoritiesSecretRef(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : additionalCertificateAuthoritiesSecretRef) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDeploymentConfig(Predicate<DeploymentConfigBuilder> predicate) {
      for (DeploymentConfigBuilder item : deploymentConfig) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDisabledController(Predicate<String> predicate) {
      for (String item : disabledControllers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingManagedDomain(Predicate<ManageDNSConfigBuilder> predicate) {
      for (ManageDNSConfigBuilder item : managedDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetricsConfig() {
    return this.metricsConfig != null;
  }
  
  public boolean hasPrivateLink() {
    return this.privateLink != null;
  }
  
  public boolean hasReleaseImageVerificationConfigMapRef() {
    return this.releaseImageVerificationConfigMapRef != null;
  }
  
  public boolean hasServiceProviderCredentialsConfig() {
    return this.serviceProviderCredentialsConfig != null;
  }
  
  public boolean hasSyncSetReapplyInterval() {
    return this.syncSetReapplyInterval != null;
  }
  
  public boolean hasTargetNamespace() {
    return this.targetNamespace != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalCertificateAuthoritiesSecretRef, argoCDConfig, awsPrivateLink, backup, clusterVersionPollInterval, controllersConfig, deleteProtection, deploymentConfig, deprovisionsDisabled, disabledControllers, exportMetrics, failedProvisionConfig, featureGates, globalPullSecretRef, logLevel, machinePoolPollInterval, maintenanceMode, managedDomains, metricsConfig, privateLink, releaseImageVerificationConfigMapRef, serviceProviderCredentialsConfig, syncSetReapplyInterval, targetNamespace, additionalProperties);
  }
  
  public A removeAllFromAdditionalCertificateAuthoritiesSecretRef(Collection<LocalObjectReference> items) {
    if (this.additionalCertificateAuthoritiesSecretRef == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("additionalCertificateAuthoritiesSecretRef").remove(builder);
        this.additionalCertificateAuthoritiesSecretRef.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDeploymentConfig(Collection<DeploymentConfig> items) {
    if (this.deploymentConfig == null) {
      return (A) this;
    }
    for (DeploymentConfig item : items) {
        DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
        _visitables.get("deploymentConfig").remove(builder);
        this.deploymentConfig.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDisabledControllers(Collection<String> items) {
    if (this.disabledControllers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disabledControllers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromManagedDomains(Collection<ManageDNSConfig> items) {
    if (this.managedDomains == null) {
      return (A) this;
    }
    for (ManageDNSConfig item : items) {
        ManageDNSConfigBuilder builder = new ManageDNSConfigBuilder(item);
        _visitables.get("managedDomains").remove(builder);
        this.managedDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalCertificateAuthoritiesSecretRef(LocalObjectReference... items) {
    if (this.additionalCertificateAuthoritiesSecretRef == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("additionalCertificateAuthoritiesSecretRef").remove(builder);
        this.additionalCertificateAuthoritiesSecretRef.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromDeploymentConfig(DeploymentConfig... items) {
    if (this.deploymentConfig == null) {
      return (A) this;
    }
    for (DeploymentConfig item : items) {
        DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
        _visitables.get("deploymentConfig").remove(builder);
        this.deploymentConfig.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDisabledControllers(String... items) {
    if (this.disabledControllers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disabledControllers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromManagedDomains(ManageDNSConfig... items) {
    if (this.managedDomains == null) {
      return (A) this;
    }
    for (ManageDNSConfig item : items) {
        ManageDNSConfigBuilder builder = new ManageDNSConfigBuilder(item);
        _visitables.get("managedDomains").remove(builder);
        this.managedDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdditionalCertificateAuthoritiesSecretRef(Predicate<LocalObjectReferenceBuilder> predicate) {
    if (additionalCertificateAuthoritiesSecretRef == null) {
      return (A) this;
    }
    Iterator<LocalObjectReferenceBuilder> each = additionalCertificateAuthoritiesSecretRef.iterator();
    List visitables = _visitables.get("additionalCertificateAuthoritiesSecretRef");
    while (each.hasNext()) {
        LocalObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDeploymentConfig(Predicate<DeploymentConfigBuilder> predicate) {
    if (deploymentConfig == null) {
      return (A) this;
    }
    Iterator<DeploymentConfigBuilder> each = deploymentConfig.iterator();
    List visitables = _visitables.get("deploymentConfig");
    while (each.hasNext()) {
        DeploymentConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromManagedDomains(Predicate<ManageDNSConfigBuilder> predicate) {
    if (managedDomains == null) {
      return (A) this;
    }
    Iterator<ManageDNSConfigBuilder> each = managedDomains.iterator();
    List visitables = _visitables.get("managedDomains");
    while (each.hasNext()) {
        ManageDNSConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalCertificateAuthoritiesSecretRefNested<A> setNewAdditionalCertificateAuthoritiesSecretRefLike(int index,LocalObjectReference item) {
    return new AdditionalCertificateAuthoritiesSecretRefNested(index, item);
  }
  
  public DeploymentConfigNested<A> setNewDeploymentConfigLike(int index,DeploymentConfig item) {
    return new DeploymentConfigNested(index, item);
  }
  
  public ManagedDomainsNested<A> setNewManagedDomainLike(int index,ManageDNSConfig item) {
    return new ManagedDomainsNested(index, item);
  }
  
  public A setToAdditionalCertificateAuthoritiesSecretRef(int index,LocalObjectReference item) {
    if (this.additionalCertificateAuthoritiesSecretRef == null) {
      this.additionalCertificateAuthoritiesSecretRef = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= additionalCertificateAuthoritiesSecretRef.size()) {
        _visitables.get("additionalCertificateAuthoritiesSecretRef").add(builder);
        additionalCertificateAuthoritiesSecretRef.add(builder);
    } else {
        _visitables.get("additionalCertificateAuthoritiesSecretRef").add(builder);
        additionalCertificateAuthoritiesSecretRef.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDeploymentConfig(int index,DeploymentConfig item) {
    if (this.deploymentConfig == null) {
      this.deploymentConfig = new ArrayList();
    }
    DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
    if (index < 0 || index >= deploymentConfig.size()) {
        _visitables.get("deploymentConfig").add(builder);
        deploymentConfig.add(builder);
    } else {
        _visitables.get("deploymentConfig").add(builder);
        deploymentConfig.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDisabledControllers(int index,String item) {
    if (this.disabledControllers == null) {
      this.disabledControllers = new ArrayList();
    }
    this.disabledControllers.set(index, item);
    return (A) this;
  }
  
  public A setToManagedDomains(int index,ManageDNSConfig item) {
    if (this.managedDomains == null) {
      this.managedDomains = new ArrayList();
    }
    ManageDNSConfigBuilder builder = new ManageDNSConfigBuilder(item);
    if (index < 0 || index >= managedDomains.size()) {
        _visitables.get("managedDomains").add(builder);
        managedDomains.add(builder);
    } else {
        _visitables.get("managedDomains").add(builder);
        managedDomains.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalCertificateAuthoritiesSecretRef == null) && !(additionalCertificateAuthoritiesSecretRef.isEmpty())) {
        sb.append("additionalCertificateAuthoritiesSecretRef:");
        sb.append(additionalCertificateAuthoritiesSecretRef);
        sb.append(",");
    }
    if (!(argoCDConfig == null)) {
        sb.append("argoCDConfig:");
        sb.append(argoCDConfig);
        sb.append(",");
    }
    if (!(awsPrivateLink == null)) {
        sb.append("awsPrivateLink:");
        sb.append(awsPrivateLink);
        sb.append(",");
    }
    if (!(backup == null)) {
        sb.append("backup:");
        sb.append(backup);
        sb.append(",");
    }
    if (!(clusterVersionPollInterval == null)) {
        sb.append("clusterVersionPollInterval:");
        sb.append(clusterVersionPollInterval);
        sb.append(",");
    }
    if (!(controllersConfig == null)) {
        sb.append("controllersConfig:");
        sb.append(controllersConfig);
        sb.append(",");
    }
    if (!(deleteProtection == null)) {
        sb.append("deleteProtection:");
        sb.append(deleteProtection);
        sb.append(",");
    }
    if (!(deploymentConfig == null) && !(deploymentConfig.isEmpty())) {
        sb.append("deploymentConfig:");
        sb.append(deploymentConfig);
        sb.append(",");
    }
    if (!(deprovisionsDisabled == null)) {
        sb.append("deprovisionsDisabled:");
        sb.append(deprovisionsDisabled);
        sb.append(",");
    }
    if (!(disabledControllers == null) && !(disabledControllers.isEmpty())) {
        sb.append("disabledControllers:");
        sb.append(disabledControllers);
        sb.append(",");
    }
    if (!(exportMetrics == null)) {
        sb.append("exportMetrics:");
        sb.append(exportMetrics);
        sb.append(",");
    }
    if (!(failedProvisionConfig == null)) {
        sb.append("failedProvisionConfig:");
        sb.append(failedProvisionConfig);
        sb.append(",");
    }
    if (!(featureGates == null)) {
        sb.append("featureGates:");
        sb.append(featureGates);
        sb.append(",");
    }
    if (!(globalPullSecretRef == null)) {
        sb.append("globalPullSecretRef:");
        sb.append(globalPullSecretRef);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(machinePoolPollInterval == null)) {
        sb.append("machinePoolPollInterval:");
        sb.append(machinePoolPollInterval);
        sb.append(",");
    }
    if (!(maintenanceMode == null)) {
        sb.append("maintenanceMode:");
        sb.append(maintenanceMode);
        sb.append(",");
    }
    if (!(managedDomains == null) && !(managedDomains.isEmpty())) {
        sb.append("managedDomains:");
        sb.append(managedDomains);
        sb.append(",");
    }
    if (!(metricsConfig == null)) {
        sb.append("metricsConfig:");
        sb.append(metricsConfig);
        sb.append(",");
    }
    if (!(privateLink == null)) {
        sb.append("privateLink:");
        sb.append(privateLink);
        sb.append(",");
    }
    if (!(releaseImageVerificationConfigMapRef == null)) {
        sb.append("releaseImageVerificationConfigMapRef:");
        sb.append(releaseImageVerificationConfigMapRef);
        sb.append(",");
    }
    if (!(serviceProviderCredentialsConfig == null)) {
        sb.append("serviceProviderCredentialsConfig:");
        sb.append(serviceProviderCredentialsConfig);
        sb.append(",");
    }
    if (!(syncSetReapplyInterval == null)) {
        sb.append("syncSetReapplyInterval:");
        sb.append(syncSetReapplyInterval);
        sb.append(",");
    }
    if (!(targetNamespace == null)) {
        sb.append("targetNamespace:");
        sb.append(targetNamespace);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalCertificateAuthoritiesSecretRef(List<LocalObjectReference> additionalCertificateAuthoritiesSecretRef) {
    if (this.additionalCertificateAuthoritiesSecretRef != null) {
      this._visitables.get("additionalCertificateAuthoritiesSecretRef").clear();
    }
    if (additionalCertificateAuthoritiesSecretRef != null) {
        this.additionalCertificateAuthoritiesSecretRef = new ArrayList();
        for (LocalObjectReference item : additionalCertificateAuthoritiesSecretRef) {
          this.addToAdditionalCertificateAuthoritiesSecretRef(item);
        }
    } else {
      this.additionalCertificateAuthoritiesSecretRef = null;
    }
    return (A) this;
  }
  
  public A withAdditionalCertificateAuthoritiesSecretRef(LocalObjectReference... additionalCertificateAuthoritiesSecretRef) {
    if (this.additionalCertificateAuthoritiesSecretRef != null) {
        this.additionalCertificateAuthoritiesSecretRef.clear();
        _visitables.remove("additionalCertificateAuthoritiesSecretRef");
    }
    if (additionalCertificateAuthoritiesSecretRef != null) {
      for (LocalObjectReference item : additionalCertificateAuthoritiesSecretRef) {
        this.addToAdditionalCertificateAuthoritiesSecretRef(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withArgoCDConfig(ArgoCDConfig argoCDConfig) {
    this._visitables.remove("argoCDConfig");
    if (argoCDConfig != null) {
        this.argoCDConfig = new ArgoCDConfigBuilder(argoCDConfig);
        this._visitables.get("argoCDConfig").add(this.argoCDConfig);
    } else {
        this.argoCDConfig = null;
        this._visitables.get("argoCDConfig").remove(this.argoCDConfig);
    }
    return (A) this;
  }
  
  public A withAwsPrivateLink(AWSPrivateLinkConfig awsPrivateLink) {
    this._visitables.remove("awsPrivateLink");
    if (awsPrivateLink != null) {
        this.awsPrivateLink = new AWSPrivateLinkConfigBuilder(awsPrivateLink);
        this._visitables.get("awsPrivateLink").add(this.awsPrivateLink);
    } else {
        this.awsPrivateLink = null;
        this._visitables.get("awsPrivateLink").remove(this.awsPrivateLink);
    }
    return (A) this;
  }
  
  public A withBackup(BackupConfig backup) {
    this._visitables.remove("backup");
    if (backup != null) {
        this.backup = new BackupConfigBuilder(backup);
        this._visitables.get("backup").add(this.backup);
    } else {
        this.backup = null;
        this._visitables.get("backup").remove(this.backup);
    }
    return (A) this;
  }
  
  public A withClusterVersionPollInterval(String clusterVersionPollInterval) {
    this.clusterVersionPollInterval = clusterVersionPollInterval;
    return (A) this;
  }
  
  public A withControllersConfig(ControllersConfig controllersConfig) {
    this._visitables.remove("controllersConfig");
    if (controllersConfig != null) {
        this.controllersConfig = new ControllersConfigBuilder(controllersConfig);
        this._visitables.get("controllersConfig").add(this.controllersConfig);
    } else {
        this.controllersConfig = null;
        this._visitables.get("controllersConfig").remove(this.controllersConfig);
    }
    return (A) this;
  }
  
  public A withDeleteProtection(String deleteProtection) {
    this.deleteProtection = deleteProtection;
    return (A) this;
  }
  
  public A withDeploymentConfig(List<DeploymentConfig> deploymentConfig) {
    if (this.deploymentConfig != null) {
      this._visitables.get("deploymentConfig").clear();
    }
    if (deploymentConfig != null) {
        this.deploymentConfig = new ArrayList();
        for (DeploymentConfig item : deploymentConfig) {
          this.addToDeploymentConfig(item);
        }
    } else {
      this.deploymentConfig = null;
    }
    return (A) this;
  }
  
  public A withDeploymentConfig(DeploymentConfig... deploymentConfig) {
    if (this.deploymentConfig != null) {
        this.deploymentConfig.clear();
        _visitables.remove("deploymentConfig");
    }
    if (deploymentConfig != null) {
      for (DeploymentConfig item : deploymentConfig) {
        this.addToDeploymentConfig(item);
      }
    }
    return (A) this;
  }
  
  public A withDeprovisionsDisabled() {
    return withDeprovisionsDisabled(true);
  }
  
  public A withDeprovisionsDisabled(Boolean deprovisionsDisabled) {
    this.deprovisionsDisabled = deprovisionsDisabled;
    return (A) this;
  }
  
  public A withDisabledControllers(List<String> disabledControllers) {
    if (disabledControllers != null) {
        this.disabledControllers = new ArrayList();
        for (String item : disabledControllers) {
          this.addToDisabledControllers(item);
        }
    } else {
      this.disabledControllers = null;
    }
    return (A) this;
  }
  
  public A withDisabledControllers(String... disabledControllers) {
    if (this.disabledControllers != null) {
        this.disabledControllers.clear();
        _visitables.remove("disabledControllers");
    }
    if (disabledControllers != null) {
      for (String item : disabledControllers) {
        this.addToDisabledControllers(item);
      }
    }
    return (A) this;
  }
  
  public A withExportMetrics() {
    return withExportMetrics(true);
  }
  
  public A withExportMetrics(Boolean exportMetrics) {
    this.exportMetrics = exportMetrics;
    return (A) this;
  }
  
  public A withFailedProvisionConfig(FailedProvisionConfig failedProvisionConfig) {
    this._visitables.remove("failedProvisionConfig");
    if (failedProvisionConfig != null) {
        this.failedProvisionConfig = new FailedProvisionConfigBuilder(failedProvisionConfig);
        this._visitables.get("failedProvisionConfig").add(this.failedProvisionConfig);
    } else {
        this.failedProvisionConfig = null;
        this._visitables.get("failedProvisionConfig").remove(this.failedProvisionConfig);
    }
    return (A) this;
  }
  
  public A withFeatureGates(FeatureGateSelection featureGates) {
    this._visitables.remove("featureGates");
    if (featureGates != null) {
        this.featureGates = new FeatureGateSelectionBuilder(featureGates);
        this._visitables.get("featureGates").add(this.featureGates);
    } else {
        this.featureGates = null;
        this._visitables.get("featureGates").remove(this.featureGates);
    }
    return (A) this;
  }
  
  public A withGlobalPullSecretRef(LocalObjectReference globalPullSecretRef) {
    this._visitables.remove("globalPullSecretRef");
    if (globalPullSecretRef != null) {
        this.globalPullSecretRef = new LocalObjectReferenceBuilder(globalPullSecretRef);
        this._visitables.get("globalPullSecretRef").add(this.globalPullSecretRef);
    } else {
        this.globalPullSecretRef = null;
        this._visitables.get("globalPullSecretRef").remove(this.globalPullSecretRef);
    }
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withMachinePoolPollInterval(String machinePoolPollInterval) {
    this.machinePoolPollInterval = machinePoolPollInterval;
    return (A) this;
  }
  
  public A withMaintenanceMode() {
    return withMaintenanceMode(true);
  }
  
  public A withMaintenanceMode(Boolean maintenanceMode) {
    this.maintenanceMode = maintenanceMode;
    return (A) this;
  }
  
  public A withManagedDomains(List<ManageDNSConfig> managedDomains) {
    if (this.managedDomains != null) {
      this._visitables.get("managedDomains").clear();
    }
    if (managedDomains != null) {
        this.managedDomains = new ArrayList();
        for (ManageDNSConfig item : managedDomains) {
          this.addToManagedDomains(item);
        }
    } else {
      this.managedDomains = null;
    }
    return (A) this;
  }
  
  public A withManagedDomains(ManageDNSConfig... managedDomains) {
    if (this.managedDomains != null) {
        this.managedDomains.clear();
        _visitables.remove("managedDomains");
    }
    if (managedDomains != null) {
      for (ManageDNSConfig item : managedDomains) {
        this.addToManagedDomains(item);
      }
    }
    return (A) this;
  }
  
  public A withMetricsConfig(MetricsConfig metricsConfig) {
    this._visitables.remove("metricsConfig");
    if (metricsConfig != null) {
        this.metricsConfig = new MetricsConfigBuilder(metricsConfig);
        this._visitables.get("metricsConfig").add(this.metricsConfig);
    } else {
        this.metricsConfig = null;
        this._visitables.get("metricsConfig").remove(this.metricsConfig);
    }
    return (A) this;
  }
  
  public ArgoCDConfigNested<A> withNewArgoCDConfig() {
    return new ArgoCDConfigNested(null);
  }
  
  public A withNewArgoCDConfig(Boolean enabled,String namespace) {
    return (A) this.withArgoCDConfig(new ArgoCDConfig(enabled, namespace));
  }
  
  public ArgoCDConfigNested<A> withNewArgoCDConfigLike(ArgoCDConfig item) {
    return new ArgoCDConfigNested(item);
  }
  
  public AwsPrivateLinkNested<A> withNewAwsPrivateLink() {
    return new AwsPrivateLinkNested(null);
  }
  
  public AwsPrivateLinkNested<A> withNewAwsPrivateLinkLike(AWSPrivateLinkConfig item) {
    return new AwsPrivateLinkNested(item);
  }
  
  public BackupNested<A> withNewBackup() {
    return new BackupNested(null);
  }
  
  public BackupNested<A> withNewBackupLike(BackupConfig item) {
    return new BackupNested(item);
  }
  
  public ControllersConfigNested<A> withNewControllersConfig() {
    return new ControllersConfigNested(null);
  }
  
  public ControllersConfigNested<A> withNewControllersConfigLike(ControllersConfig item) {
    return new ControllersConfigNested(item);
  }
  
  public FailedProvisionConfigNested<A> withNewFailedProvisionConfig() {
    return new FailedProvisionConfigNested(null);
  }
  
  public FailedProvisionConfigNested<A> withNewFailedProvisionConfigLike(FailedProvisionConfig item) {
    return new FailedProvisionConfigNested(item);
  }
  
  public FeatureGatesNested<A> withNewFeatureGates() {
    return new FeatureGatesNested(null);
  }
  
  public FeatureGatesNested<A> withNewFeatureGatesLike(FeatureGateSelection item) {
    return new FeatureGatesNested(item);
  }
  
  public GlobalPullSecretRefNested<A> withNewGlobalPullSecretRef() {
    return new GlobalPullSecretRefNested(null);
  }
  
  public A withNewGlobalPullSecretRef(String name) {
    return (A) this.withGlobalPullSecretRef(new LocalObjectReference(name));
  }
  
  public GlobalPullSecretRefNested<A> withNewGlobalPullSecretRefLike(LocalObjectReference item) {
    return new GlobalPullSecretRefNested(item);
  }
  
  public MetricsConfigNested<A> withNewMetricsConfig() {
    return new MetricsConfigNested(null);
  }
  
  public MetricsConfigNested<A> withNewMetricsConfigLike(MetricsConfig item) {
    return new MetricsConfigNested(item);
  }
  
  public PrivateLinkNested<A> withNewPrivateLink() {
    return new PrivateLinkNested(null);
  }
  
  public PrivateLinkNested<A> withNewPrivateLinkLike(PrivateLinkConfig item) {
    return new PrivateLinkNested(item);
  }
  
  public ReleaseImageVerificationConfigMapRefNested<A> withNewReleaseImageVerificationConfigMapRef() {
    return new ReleaseImageVerificationConfigMapRefNested(null);
  }
  
  public A withNewReleaseImageVerificationConfigMapRef(String name,String namespace) {
    return (A) this.withReleaseImageVerificationConfigMapRef(new ReleaseImageVerificationConfigMapReference(name, namespace));
  }
  
  public ReleaseImageVerificationConfigMapRefNested<A> withNewReleaseImageVerificationConfigMapRefLike(ReleaseImageVerificationConfigMapReference item) {
    return new ReleaseImageVerificationConfigMapRefNested(item);
  }
  
  public ServiceProviderCredentialsConfigNested<A> withNewServiceProviderCredentialsConfig() {
    return new ServiceProviderCredentialsConfigNested(null);
  }
  
  public ServiceProviderCredentialsConfigNested<A> withNewServiceProviderCredentialsConfigLike(ServiceProviderCredentials item) {
    return new ServiceProviderCredentialsConfigNested(item);
  }
  
  public A withPrivateLink(PrivateLinkConfig privateLink) {
    this._visitables.remove("privateLink");
    if (privateLink != null) {
        this.privateLink = new PrivateLinkConfigBuilder(privateLink);
        this._visitables.get("privateLink").add(this.privateLink);
    } else {
        this.privateLink = null;
        this._visitables.get("privateLink").remove(this.privateLink);
    }
    return (A) this;
  }
  
  public A withReleaseImageVerificationConfigMapRef(ReleaseImageVerificationConfigMapReference releaseImageVerificationConfigMapRef) {
    this._visitables.remove("releaseImageVerificationConfigMapRef");
    if (releaseImageVerificationConfigMapRef != null) {
        this.releaseImageVerificationConfigMapRef = new ReleaseImageVerificationConfigMapReferenceBuilder(releaseImageVerificationConfigMapRef);
        this._visitables.get("releaseImageVerificationConfigMapRef").add(this.releaseImageVerificationConfigMapRef);
    } else {
        this.releaseImageVerificationConfigMapRef = null;
        this._visitables.get("releaseImageVerificationConfigMapRef").remove(this.releaseImageVerificationConfigMapRef);
    }
    return (A) this;
  }
  
  public A withServiceProviderCredentialsConfig(ServiceProviderCredentials serviceProviderCredentialsConfig) {
    this._visitables.remove("serviceProviderCredentialsConfig");
    if (serviceProviderCredentialsConfig != null) {
        this.serviceProviderCredentialsConfig = new ServiceProviderCredentialsBuilder(serviceProviderCredentialsConfig);
        this._visitables.get("serviceProviderCredentialsConfig").add(this.serviceProviderCredentialsConfig);
    } else {
        this.serviceProviderCredentialsConfig = null;
        this._visitables.get("serviceProviderCredentialsConfig").remove(this.serviceProviderCredentialsConfig);
    }
    return (A) this;
  }
  
  public A withSyncSetReapplyInterval(String syncSetReapplyInterval) {
    this.syncSetReapplyInterval = syncSetReapplyInterval;
    return (A) this;
  }
  
  public A withTargetNamespace(String targetNamespace) {
    this.targetNamespace = targetNamespace;
    return (A) this;
  }
  public class AdditionalCertificateAuthoritiesSecretRefNested<N> extends LocalObjectReferenceFluent<AdditionalCertificateAuthoritiesSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
    int index;
  
    AdditionalCertificateAuthoritiesSecretRefNested(int index,LocalObjectReference item) {
      this.index = index;
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.setToAdditionalCertificateAuthoritiesSecretRef(index, builder.build());
    }
    
    public N endAdditionalCertificateAuthoritiesSecretRef() {
      return and();
    }
    
  }
  public class ArgoCDConfigNested<N> extends ArgoCDConfigFluent<ArgoCDConfigNested<N>> implements Nested<N>{
  
    ArgoCDConfigBuilder builder;
  
    ArgoCDConfigNested(ArgoCDConfig item) {
      this.builder = new ArgoCDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withArgoCDConfig(builder.build());
    }
    
    public N endArgoCDConfig() {
      return and();
    }
    
  }
  public class AwsPrivateLinkNested<N> extends AWSPrivateLinkConfigFluent<AwsPrivateLinkNested<N>> implements Nested<N>{
  
    AWSPrivateLinkConfigBuilder builder;
  
    AwsPrivateLinkNested(AWSPrivateLinkConfig item) {
      this.builder = new AWSPrivateLinkConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withAwsPrivateLink(builder.build());
    }
    
    public N endAwsPrivateLink() {
      return and();
    }
    
  }
  public class BackupNested<N> extends BackupConfigFluent<BackupNested<N>> implements Nested<N>{
  
    BackupConfigBuilder builder;
  
    BackupNested(BackupConfig item) {
      this.builder = new BackupConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withBackup(builder.build());
    }
    
    public N endBackup() {
      return and();
    }
    
  }
  public class ControllersConfigNested<N> extends ControllersConfigFluent<ControllersConfigNested<N>> implements Nested<N>{
  
    ControllersConfigBuilder builder;
  
    ControllersConfigNested(ControllersConfig item) {
      this.builder = new ControllersConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withControllersConfig(builder.build());
    }
    
    public N endControllersConfig() {
      return and();
    }
    
  }
  public class DeploymentConfigNested<N> extends DeploymentConfigFluent<DeploymentConfigNested<N>> implements Nested<N>{
  
    DeploymentConfigBuilder builder;
    int index;
  
    DeploymentConfigNested(int index,DeploymentConfig item) {
      this.index = index;
      this.builder = new DeploymentConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.setToDeploymentConfig(index, builder.build());
    }
    
    public N endDeploymentConfig() {
      return and();
    }
    
  }
  public class FailedProvisionConfigNested<N> extends FailedProvisionConfigFluent<FailedProvisionConfigNested<N>> implements Nested<N>{
  
    FailedProvisionConfigBuilder builder;
  
    FailedProvisionConfigNested(FailedProvisionConfig item) {
      this.builder = new FailedProvisionConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withFailedProvisionConfig(builder.build());
    }
    
    public N endFailedProvisionConfig() {
      return and();
    }
    
  }
  public class FeatureGatesNested<N> extends FeatureGateSelectionFluent<FeatureGatesNested<N>> implements Nested<N>{
  
    FeatureGateSelectionBuilder builder;
  
    FeatureGatesNested(FeatureGateSelection item) {
      this.builder = new FeatureGateSelectionBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withFeatureGates(builder.build());
    }
    
    public N endFeatureGates() {
      return and();
    }
    
  }
  public class GlobalPullSecretRefNested<N> extends LocalObjectReferenceFluent<GlobalPullSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    GlobalPullSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withGlobalPullSecretRef(builder.build());
    }
    
    public N endGlobalPullSecretRef() {
      return and();
    }
    
  }
  public class ManagedDomainsNested<N> extends ManageDNSConfigFluent<ManagedDomainsNested<N>> implements Nested<N>{
  
    ManageDNSConfigBuilder builder;
    int index;
  
    ManagedDomainsNested(int index,ManageDNSConfig item) {
      this.index = index;
      this.builder = new ManageDNSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.setToManagedDomains(index, builder.build());
    }
    
    public N endManagedDomain() {
      return and();
    }
    
  }
  public class MetricsConfigNested<N> extends MetricsConfigFluent<MetricsConfigNested<N>> implements Nested<N>{
  
    MetricsConfigBuilder builder;
  
    MetricsConfigNested(MetricsConfig item) {
      this.builder = new MetricsConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withMetricsConfig(builder.build());
    }
    
    public N endMetricsConfig() {
      return and();
    }
    
  }
  public class PrivateLinkNested<N> extends PrivateLinkConfigFluent<PrivateLinkNested<N>> implements Nested<N>{
  
    PrivateLinkConfigBuilder builder;
  
    PrivateLinkNested(PrivateLinkConfig item) {
      this.builder = new PrivateLinkConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withPrivateLink(builder.build());
    }
    
    public N endPrivateLink() {
      return and();
    }
    
  }
  public class ReleaseImageVerificationConfigMapRefNested<N> extends ReleaseImageVerificationConfigMapReferenceFluent<ReleaseImageVerificationConfigMapRefNested<N>> implements Nested<N>{
  
    ReleaseImageVerificationConfigMapReferenceBuilder builder;
  
    ReleaseImageVerificationConfigMapRefNested(ReleaseImageVerificationConfigMapReference item) {
      this.builder = new ReleaseImageVerificationConfigMapReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withReleaseImageVerificationConfigMapRef(builder.build());
    }
    
    public N endReleaseImageVerificationConfigMapRef() {
      return and();
    }
    
  }
  public class ServiceProviderCredentialsConfigNested<N> extends ServiceProviderCredentialsFluent<ServiceProviderCredentialsConfigNested<N>> implements Nested<N>{
  
    ServiceProviderCredentialsBuilder builder;
  
    ServiceProviderCredentialsConfigNested(ServiceProviderCredentials item) {
      this.builder = new ServiceProviderCredentialsBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withServiceProviderCredentialsConfig(builder.build());
    }
    
    public N endServiceProviderCredentialsConfig() {
      return and();
    }
    
  }
}