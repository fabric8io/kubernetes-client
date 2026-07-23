package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import java.lang.Boolean;
import java.lang.Integer;
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
public class ClusterDeploymentSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String baseDomain;
  private LocalObjectReferenceBuilder boundServiceAccountSigningKeySecretRef;
  private ArrayList<CertificateBundleSpecBuilder> certificateBundles = new ArrayList<CertificateBundleSpecBuilder>();
  private ClusterInstallLocalReferenceBuilder clusterInstallRef;
  private ClusterMetadataBuilder clusterMetadata;
  private String clusterName;
  private ClusterPoolReferenceBuilder clusterPoolRef;
  private ControlPlaneConfigSpecBuilder controlPlaneConfig;
  private String hibernateAfter;
  private ArrayList<ClusterIngressBuilder> ingress = new ArrayList<ClusterIngressBuilder>();
  private Integer installAttemptsLimit;
  private Boolean installed;
  private Boolean manageDNS;
  private PlatformBuilder platform;
  private String powerState;
  private Boolean preserveOnDelete;
  private ProvisioningBuilder provisioning;
  private LocalObjectReferenceBuilder pullSecretRef;

  public ClusterDeploymentSpecFluent() {
  }
  
  public ClusterDeploymentSpecFluent(ClusterDeploymentSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToCertificateBundles(Collection<CertificateBundleSpec> items) {
    if (this.certificateBundles == null) {
      this.certificateBundles = new ArrayList();
    }
    for (CertificateBundleSpec item : items) {
        CertificateBundleSpecBuilder builder = new CertificateBundleSpecBuilder(item);
        _visitables.get("certificateBundles").add(builder);
        this.certificateBundles.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIngress(Collection<ClusterIngress> items) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    for (ClusterIngress item : items) {
        ClusterIngressBuilder builder = new ClusterIngressBuilder(item);
        _visitables.get("ingress").add(builder);
        this.ingress.add(builder);
    }
    return (A) this;
  }
  
  public CertificateBundlesNested<A> addNewCertificateBundle() {
    return new CertificateBundlesNested(-1, null);
  }
  
  public CertificateBundlesNested<A> addNewCertificateBundleLike(CertificateBundleSpec item) {
    return new CertificateBundlesNested(-1, item);
  }
  
  public IngressNested<A> addNewIngress() {
    return new IngressNested(-1, null);
  }
  
  public IngressNested<A> addNewIngressLike(ClusterIngress item) {
    return new IngressNested(-1, item);
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
  
  public A addToCertificateBundles(CertificateBundleSpec... items) {
    if (this.certificateBundles == null) {
      this.certificateBundles = new ArrayList();
    }
    for (CertificateBundleSpec item : items) {
        CertificateBundleSpecBuilder builder = new CertificateBundleSpecBuilder(item);
        _visitables.get("certificateBundles").add(builder);
        this.certificateBundles.add(builder);
    }
    return (A) this;
  }
  
  public A addToCertificateBundles(int index,CertificateBundleSpec item) {
    if (this.certificateBundles == null) {
      this.certificateBundles = new ArrayList();
    }
    CertificateBundleSpecBuilder builder = new CertificateBundleSpecBuilder(item);
    if (index < 0 || index >= certificateBundles.size()) {
        _visitables.get("certificateBundles").add(builder);
        certificateBundles.add(builder);
    } else {
        _visitables.get("certificateBundles").add(builder);
        certificateBundles.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIngress(ClusterIngress... items) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    for (ClusterIngress item : items) {
        ClusterIngressBuilder builder = new ClusterIngressBuilder(item);
        _visitables.get("ingress").add(builder);
        this.ingress.add(builder);
    }
    return (A) this;
  }
  
  public A addToIngress(int index,ClusterIngress item) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    ClusterIngressBuilder builder = new ClusterIngressBuilder(item);
    if (index < 0 || index >= ingress.size()) {
        _visitables.get("ingress").add(builder);
        ingress.add(builder);
    } else {
        _visitables.get("ingress").add(builder);
        ingress.add(index, builder);
    }
    return (A) this;
  }
  
  public LocalObjectReference buildBoundServiceAccountSigningKeySecretRef() {
    return this.boundServiceAccountSigningKeySecretRef != null ? this.boundServiceAccountSigningKeySecretRef.build() : null;
  }
  
  public CertificateBundleSpec buildCertificateBundle(int index) {
    return this.certificateBundles.get(index).build();
  }
  
  public List<CertificateBundleSpec> buildCertificateBundles() {
    return this.certificateBundles != null ? build(certificateBundles) : null;
  }
  
  public ClusterInstallLocalReference buildClusterInstallRef() {
    return this.clusterInstallRef != null ? this.clusterInstallRef.build() : null;
  }
  
  public ClusterMetadata buildClusterMetadata() {
    return this.clusterMetadata != null ? this.clusterMetadata.build() : null;
  }
  
  public ClusterPoolReference buildClusterPoolRef() {
    return this.clusterPoolRef != null ? this.clusterPoolRef.build() : null;
  }
  
  public ControlPlaneConfigSpec buildControlPlaneConfig() {
    return this.controlPlaneConfig != null ? this.controlPlaneConfig.build() : null;
  }
  
  public CertificateBundleSpec buildFirstCertificateBundle() {
    return this.certificateBundles.get(0).build();
  }
  
  public ClusterIngress buildFirstIngress() {
    return this.ingress.get(0).build();
  }
  
  public List<ClusterIngress> buildIngress() {
    return this.ingress != null ? build(ingress) : null;
  }
  
  public ClusterIngress buildIngress(int index) {
    return this.ingress.get(index).build();
  }
  
  public CertificateBundleSpec buildLastCertificateBundle() {
    return this.certificateBundles.get(certificateBundles.size() - 1).build();
  }
  
  public ClusterIngress buildLastIngress() {
    return this.ingress.get(ingress.size() - 1).build();
  }
  
  public CertificateBundleSpec buildMatchingCertificateBundle(Predicate<CertificateBundleSpecBuilder> predicate) {
      for (CertificateBundleSpecBuilder item : certificateBundles) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterIngress buildMatchingIngress(Predicate<ClusterIngressBuilder> predicate) {
      for (ClusterIngressBuilder item : ingress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Platform buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  public Provisioning buildProvisioning() {
    return this.provisioning != null ? this.provisioning.build() : null;
  }
  
  public LocalObjectReference buildPullSecretRef() {
    return this.pullSecretRef != null ? this.pullSecretRef.build() : null;
  }
  
  protected void copyInstance(ClusterDeploymentSpec instance) {
    instance = instance != null ? instance : new ClusterDeploymentSpec();
    if (instance != null) {
        this.withBaseDomain(instance.getBaseDomain());
        this.withBoundServiceAccountSigningKeySecretRef(instance.getBoundServiceAccountSigningKeySecretRef());
        this.withCertificateBundles(instance.getCertificateBundles());
        this.withClusterInstallRef(instance.getClusterInstallRef());
        this.withClusterMetadata(instance.getClusterMetadata());
        this.withClusterName(instance.getClusterName());
        this.withClusterPoolRef(instance.getClusterPoolRef());
        this.withControlPlaneConfig(instance.getControlPlaneConfig());
        this.withHibernateAfter(instance.getHibernateAfter());
        this.withIngress(instance.getIngress());
        this.withInstallAttemptsLimit(instance.getInstallAttemptsLimit());
        this.withInstalled(instance.getInstalled());
        this.withManageDNS(instance.getManageDNS());
        this.withPlatform(instance.getPlatform());
        this.withPowerState(instance.getPowerState());
        this.withPreserveOnDelete(instance.getPreserveOnDelete());
        this.withProvisioning(instance.getProvisioning());
        this.withPullSecretRef(instance.getPullSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BoundServiceAccountSigningKeySecretRefNested<A> editBoundServiceAccountSigningKeySecretRef() {
    return this.withNewBoundServiceAccountSigningKeySecretRefLike(Optional.ofNullable(this.buildBoundServiceAccountSigningKeySecretRef()).orElse(null));
  }
  
  public CertificateBundlesNested<A> editCertificateBundle(int index) {
    if (certificateBundles.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "certificateBundles"));
    }
    return this.setNewCertificateBundleLike(index, this.buildCertificateBundle(index));
  }
  
  public ClusterInstallRefNested<A> editClusterInstallRef() {
    return this.withNewClusterInstallRefLike(Optional.ofNullable(this.buildClusterInstallRef()).orElse(null));
  }
  
  public ClusterMetadataNested<A> editClusterMetadata() {
    return this.withNewClusterMetadataLike(Optional.ofNullable(this.buildClusterMetadata()).orElse(null));
  }
  
  public ClusterPoolRefNested<A> editClusterPoolRef() {
    return this.withNewClusterPoolRefLike(Optional.ofNullable(this.buildClusterPoolRef()).orElse(null));
  }
  
  public ControlPlaneConfigNested<A> editControlPlaneConfig() {
    return this.withNewControlPlaneConfigLike(Optional.ofNullable(this.buildControlPlaneConfig()).orElse(null));
  }
  
  public CertificateBundlesNested<A> editFirstCertificateBundle() {
    if (certificateBundles.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "certificateBundles"));
    }
    return this.setNewCertificateBundleLike(0, this.buildCertificateBundle(0));
  }
  
  public IngressNested<A> editFirstIngress() {
    if (ingress.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ingress"));
    }
    return this.setNewIngressLike(0, this.buildIngress(0));
  }
  
  public IngressNested<A> editIngress(int index) {
    if (ingress.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public CertificateBundlesNested<A> editLastCertificateBundle() {
    int index = certificateBundles.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "certificateBundles"));
    }
    return this.setNewCertificateBundleLike(index, this.buildCertificateBundle(index));
  }
  
  public IngressNested<A> editLastIngress() {
    int index = ingress.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public CertificateBundlesNested<A> editMatchingCertificateBundle(Predicate<CertificateBundleSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < certificateBundles.size();i++) {
      if (predicate.test(certificateBundles.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "certificateBundles"));
    }
    return this.setNewCertificateBundleLike(index, this.buildCertificateBundle(index));
  }
  
  public IngressNested<A> editMatchingIngress(Predicate<ClusterIngressBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ingress.size();i++) {
      if (predicate.test(ingress.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public BoundServiceAccountSigningKeySecretRefNested<A> editOrNewBoundServiceAccountSigningKeySecretRef() {
    return this.withNewBoundServiceAccountSigningKeySecretRefLike(Optional.ofNullable(this.buildBoundServiceAccountSigningKeySecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public BoundServiceAccountSigningKeySecretRefNested<A> editOrNewBoundServiceAccountSigningKeySecretRefLike(LocalObjectReference item) {
    return this.withNewBoundServiceAccountSigningKeySecretRefLike(Optional.ofNullable(this.buildBoundServiceAccountSigningKeySecretRef()).orElse(item));
  }
  
  public ClusterInstallRefNested<A> editOrNewClusterInstallRef() {
    return this.withNewClusterInstallRefLike(Optional.ofNullable(this.buildClusterInstallRef()).orElse(new ClusterInstallLocalReferenceBuilder().build()));
  }
  
  public ClusterInstallRefNested<A> editOrNewClusterInstallRefLike(ClusterInstallLocalReference item) {
    return this.withNewClusterInstallRefLike(Optional.ofNullable(this.buildClusterInstallRef()).orElse(item));
  }
  
  public ClusterMetadataNested<A> editOrNewClusterMetadata() {
    return this.withNewClusterMetadataLike(Optional.ofNullable(this.buildClusterMetadata()).orElse(new ClusterMetadataBuilder().build()));
  }
  
  public ClusterMetadataNested<A> editOrNewClusterMetadataLike(ClusterMetadata item) {
    return this.withNewClusterMetadataLike(Optional.ofNullable(this.buildClusterMetadata()).orElse(item));
  }
  
  public ClusterPoolRefNested<A> editOrNewClusterPoolRef() {
    return this.withNewClusterPoolRefLike(Optional.ofNullable(this.buildClusterPoolRef()).orElse(new ClusterPoolReferenceBuilder().build()));
  }
  
  public ClusterPoolRefNested<A> editOrNewClusterPoolRefLike(ClusterPoolReference item) {
    return this.withNewClusterPoolRefLike(Optional.ofNullable(this.buildClusterPoolRef()).orElse(item));
  }
  
  public ControlPlaneConfigNested<A> editOrNewControlPlaneConfig() {
    return this.withNewControlPlaneConfigLike(Optional.ofNullable(this.buildControlPlaneConfig()).orElse(new ControlPlaneConfigSpecBuilder().build()));
  }
  
  public ControlPlaneConfigNested<A> editOrNewControlPlaneConfigLike(ControlPlaneConfigSpec item) {
    return this.withNewControlPlaneConfigLike(Optional.ofNullable(this.buildControlPlaneConfig()).orElse(item));
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new PlatformBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(Platform item) {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(item));
  }
  
  public ProvisioningNested<A> editOrNewProvisioning() {
    return this.withNewProvisioningLike(Optional.ofNullable(this.buildProvisioning()).orElse(new ProvisioningBuilder().build()));
  }
  
  public ProvisioningNested<A> editOrNewProvisioningLike(Provisioning item) {
    return this.withNewProvisioningLike(Optional.ofNullable(this.buildProvisioning()).orElse(item));
  }
  
  public PullSecretRefNested<A> editOrNewPullSecretRef() {
    return this.withNewPullSecretRefLike(Optional.ofNullable(this.buildPullSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public PullSecretRefNested<A> editOrNewPullSecretRefLike(LocalObjectReference item) {
    return this.withNewPullSecretRefLike(Optional.ofNullable(this.buildPullSecretRef()).orElse(item));
  }
  
  public PlatformNested<A> editPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(null));
  }
  
  public ProvisioningNested<A> editProvisioning() {
    return this.withNewProvisioningLike(Optional.ofNullable(this.buildProvisioning()).orElse(null));
  }
  
  public PullSecretRefNested<A> editPullSecretRef() {
    return this.withNewPullSecretRefLike(Optional.ofNullable(this.buildPullSecretRef()).orElse(null));
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
    ClusterDeploymentSpecFluent that = (ClusterDeploymentSpecFluent) o;
    if (!(Objects.equals(baseDomain, that.baseDomain))) {
      return false;
    }
    if (!(Objects.equals(boundServiceAccountSigningKeySecretRef, that.boundServiceAccountSigningKeySecretRef))) {
      return false;
    }
    if (!(Objects.equals(certificateBundles, that.certificateBundles))) {
      return false;
    }
    if (!(Objects.equals(clusterInstallRef, that.clusterInstallRef))) {
      return false;
    }
    if (!(Objects.equals(clusterMetadata, that.clusterMetadata))) {
      return false;
    }
    if (!(Objects.equals(clusterName, that.clusterName))) {
      return false;
    }
    if (!(Objects.equals(clusterPoolRef, that.clusterPoolRef))) {
      return false;
    }
    if (!(Objects.equals(controlPlaneConfig, that.controlPlaneConfig))) {
      return false;
    }
    if (!(Objects.equals(hibernateAfter, that.hibernateAfter))) {
      return false;
    }
    if (!(Objects.equals(ingress, that.ingress))) {
      return false;
    }
    if (!(Objects.equals(installAttemptsLimit, that.installAttemptsLimit))) {
      return false;
    }
    if (!(Objects.equals(installed, that.installed))) {
      return false;
    }
    if (!(Objects.equals(manageDNS, that.manageDNS))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(powerState, that.powerState))) {
      return false;
    }
    if (!(Objects.equals(preserveOnDelete, that.preserveOnDelete))) {
      return false;
    }
    if (!(Objects.equals(provisioning, that.provisioning))) {
      return false;
    }
    if (!(Objects.equals(pullSecretRef, that.pullSecretRef))) {
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
  
  public String getBaseDomain() {
    return this.baseDomain;
  }
  
  public String getClusterName() {
    return this.clusterName;
  }
  
  public String getHibernateAfter() {
    return this.hibernateAfter;
  }
  
  public Integer getInstallAttemptsLimit() {
    return this.installAttemptsLimit;
  }
  
  public Boolean getInstalled() {
    return this.installed;
  }
  
  public Boolean getManageDNS() {
    return this.manageDNS;
  }
  
  public String getPowerState() {
    return this.powerState;
  }
  
  public Boolean getPreserveOnDelete() {
    return this.preserveOnDelete;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseDomain() {
    return this.baseDomain != null;
  }
  
  public boolean hasBoundServiceAccountSigningKeySecretRef() {
    return this.boundServiceAccountSigningKeySecretRef != null;
  }
  
  public boolean hasCertificateBundles() {
    return this.certificateBundles != null && !(this.certificateBundles.isEmpty());
  }
  
  public boolean hasClusterInstallRef() {
    return this.clusterInstallRef != null;
  }
  
  public boolean hasClusterMetadata() {
    return this.clusterMetadata != null;
  }
  
  public boolean hasClusterName() {
    return this.clusterName != null;
  }
  
  public boolean hasClusterPoolRef() {
    return this.clusterPoolRef != null;
  }
  
  public boolean hasControlPlaneConfig() {
    return this.controlPlaneConfig != null;
  }
  
  public boolean hasHibernateAfter() {
    return this.hibernateAfter != null;
  }
  
  public boolean hasIngress() {
    return this.ingress != null && !(this.ingress.isEmpty());
  }
  
  public boolean hasInstallAttemptsLimit() {
    return this.installAttemptsLimit != null;
  }
  
  public boolean hasInstalled() {
    return this.installed != null;
  }
  
  public boolean hasManageDNS() {
    return this.manageDNS != null;
  }
  
  public boolean hasMatchingCertificateBundle(Predicate<CertificateBundleSpecBuilder> predicate) {
      for (CertificateBundleSpecBuilder item : certificateBundles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngress(Predicate<ClusterIngressBuilder> predicate) {
      for (ClusterIngressBuilder item : ingress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasPowerState() {
    return this.powerState != null;
  }
  
  public boolean hasPreserveOnDelete() {
    return this.preserveOnDelete != null;
  }
  
  public boolean hasProvisioning() {
    return this.provisioning != null;
  }
  
  public boolean hasPullSecretRef() {
    return this.pullSecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseDomain, boundServiceAccountSigningKeySecretRef, certificateBundles, clusterInstallRef, clusterMetadata, clusterName, clusterPoolRef, controlPlaneConfig, hibernateAfter, ingress, installAttemptsLimit, installed, manageDNS, platform, powerState, preserveOnDelete, provisioning, pullSecretRef, additionalProperties);
  }
  
  public A removeAllFromCertificateBundles(Collection<CertificateBundleSpec> items) {
    if (this.certificateBundles == null) {
      return (A) this;
    }
    for (CertificateBundleSpec item : items) {
        CertificateBundleSpecBuilder builder = new CertificateBundleSpecBuilder(item);
        _visitables.get("certificateBundles").remove(builder);
        this.certificateBundles.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIngress(Collection<ClusterIngress> items) {
    if (this.ingress == null) {
      return (A) this;
    }
    for (ClusterIngress item : items) {
        ClusterIngressBuilder builder = new ClusterIngressBuilder(item);
        _visitables.get("ingress").remove(builder);
        this.ingress.remove(builder);
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
  
  public A removeFromCertificateBundles(CertificateBundleSpec... items) {
    if (this.certificateBundles == null) {
      return (A) this;
    }
    for (CertificateBundleSpec item : items) {
        CertificateBundleSpecBuilder builder = new CertificateBundleSpecBuilder(item);
        _visitables.get("certificateBundles").remove(builder);
        this.certificateBundles.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIngress(ClusterIngress... items) {
    if (this.ingress == null) {
      return (A) this;
    }
    for (ClusterIngress item : items) {
        ClusterIngressBuilder builder = new ClusterIngressBuilder(item);
        _visitables.get("ingress").remove(builder);
        this.ingress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCertificateBundles(Predicate<CertificateBundleSpecBuilder> predicate) {
    if (certificateBundles == null) {
      return (A) this;
    }
    Iterator<CertificateBundleSpecBuilder> each = certificateBundles.iterator();
    List visitables = _visitables.get("certificateBundles");
    while (each.hasNext()) {
        CertificateBundleSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIngress(Predicate<ClusterIngressBuilder> predicate) {
    if (ingress == null) {
      return (A) this;
    }
    Iterator<ClusterIngressBuilder> each = ingress.iterator();
    List visitables = _visitables.get("ingress");
    while (each.hasNext()) {
        ClusterIngressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CertificateBundlesNested<A> setNewCertificateBundleLike(int index,CertificateBundleSpec item) {
    return new CertificateBundlesNested(index, item);
  }
  
  public IngressNested<A> setNewIngressLike(int index,ClusterIngress item) {
    return new IngressNested(index, item);
  }
  
  public A setToCertificateBundles(int index,CertificateBundleSpec item) {
    if (this.certificateBundles == null) {
      this.certificateBundles = new ArrayList();
    }
    CertificateBundleSpecBuilder builder = new CertificateBundleSpecBuilder(item);
    if (index < 0 || index >= certificateBundles.size()) {
        _visitables.get("certificateBundles").add(builder);
        certificateBundles.add(builder);
    } else {
        _visitables.get("certificateBundles").add(builder);
        certificateBundles.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIngress(int index,ClusterIngress item) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    ClusterIngressBuilder builder = new ClusterIngressBuilder(item);
    if (index < 0 || index >= ingress.size()) {
        _visitables.get("ingress").add(builder);
        ingress.add(builder);
    } else {
        _visitables.get("ingress").add(builder);
        ingress.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(baseDomain == null)) {
        sb.append("baseDomain:");
        sb.append(baseDomain);
        sb.append(",");
    }
    if (!(boundServiceAccountSigningKeySecretRef == null)) {
        sb.append("boundServiceAccountSigningKeySecretRef:");
        sb.append(boundServiceAccountSigningKeySecretRef);
        sb.append(",");
    }
    if (!(certificateBundles == null) && !(certificateBundles.isEmpty())) {
        sb.append("certificateBundles:");
        sb.append(certificateBundles);
        sb.append(",");
    }
    if (!(clusterInstallRef == null)) {
        sb.append("clusterInstallRef:");
        sb.append(clusterInstallRef);
        sb.append(",");
    }
    if (!(clusterMetadata == null)) {
        sb.append("clusterMetadata:");
        sb.append(clusterMetadata);
        sb.append(",");
    }
    if (!(clusterName == null)) {
        sb.append("clusterName:");
        sb.append(clusterName);
        sb.append(",");
    }
    if (!(clusterPoolRef == null)) {
        sb.append("clusterPoolRef:");
        sb.append(clusterPoolRef);
        sb.append(",");
    }
    if (!(controlPlaneConfig == null)) {
        sb.append("controlPlaneConfig:");
        sb.append(controlPlaneConfig);
        sb.append(",");
    }
    if (!(hibernateAfter == null)) {
        sb.append("hibernateAfter:");
        sb.append(hibernateAfter);
        sb.append(",");
    }
    if (!(ingress == null) && !(ingress.isEmpty())) {
        sb.append("ingress:");
        sb.append(ingress);
        sb.append(",");
    }
    if (!(installAttemptsLimit == null)) {
        sb.append("installAttemptsLimit:");
        sb.append(installAttemptsLimit);
        sb.append(",");
    }
    if (!(installed == null)) {
        sb.append("installed:");
        sb.append(installed);
        sb.append(",");
    }
    if (!(manageDNS == null)) {
        sb.append("manageDNS:");
        sb.append(manageDNS);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(powerState == null)) {
        sb.append("powerState:");
        sb.append(powerState);
        sb.append(",");
    }
    if (!(preserveOnDelete == null)) {
        sb.append("preserveOnDelete:");
        sb.append(preserveOnDelete);
        sb.append(",");
    }
    if (!(provisioning == null)) {
        sb.append("provisioning:");
        sb.append(provisioning);
        sb.append(",");
    }
    if (!(pullSecretRef == null)) {
        sb.append("pullSecretRef:");
        sb.append(pullSecretRef);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBaseDomain(String baseDomain) {
    this.baseDomain = baseDomain;
    return (A) this;
  }
  
  public A withBoundServiceAccountSigningKeySecretRef(LocalObjectReference boundServiceAccountSigningKeySecretRef) {
    this._visitables.remove("boundServiceAccountSigningKeySecretRef");
    if (boundServiceAccountSigningKeySecretRef != null) {
        this.boundServiceAccountSigningKeySecretRef = new LocalObjectReferenceBuilder(boundServiceAccountSigningKeySecretRef);
        this._visitables.get("boundServiceAccountSigningKeySecretRef").add(this.boundServiceAccountSigningKeySecretRef);
    } else {
        this.boundServiceAccountSigningKeySecretRef = null;
        this._visitables.get("boundServiceAccountSigningKeySecretRef").remove(this.boundServiceAccountSigningKeySecretRef);
    }
    return (A) this;
  }
  
  public A withCertificateBundles(List<CertificateBundleSpec> certificateBundles) {
    if (this.certificateBundles != null) {
      this._visitables.get("certificateBundles").clear();
    }
    if (certificateBundles != null) {
        this.certificateBundles = new ArrayList();
        for (CertificateBundleSpec item : certificateBundles) {
          this.addToCertificateBundles(item);
        }
    } else {
      this.certificateBundles = null;
    }
    return (A) this;
  }
  
  public A withCertificateBundles(CertificateBundleSpec... certificateBundles) {
    if (this.certificateBundles != null) {
        this.certificateBundles.clear();
        _visitables.remove("certificateBundles");
    }
    if (certificateBundles != null) {
      for (CertificateBundleSpec item : certificateBundles) {
        this.addToCertificateBundles(item);
      }
    }
    return (A) this;
  }
  
  public A withClusterInstallRef(ClusterInstallLocalReference clusterInstallRef) {
    this._visitables.remove("clusterInstallRef");
    if (clusterInstallRef != null) {
        this.clusterInstallRef = new ClusterInstallLocalReferenceBuilder(clusterInstallRef);
        this._visitables.get("clusterInstallRef").add(this.clusterInstallRef);
    } else {
        this.clusterInstallRef = null;
        this._visitables.get("clusterInstallRef").remove(this.clusterInstallRef);
    }
    return (A) this;
  }
  
  public A withClusterMetadata(ClusterMetadata clusterMetadata) {
    this._visitables.remove("clusterMetadata");
    if (clusterMetadata != null) {
        this.clusterMetadata = new ClusterMetadataBuilder(clusterMetadata);
        this._visitables.get("clusterMetadata").add(this.clusterMetadata);
    } else {
        this.clusterMetadata = null;
        this._visitables.get("clusterMetadata").remove(this.clusterMetadata);
    }
    return (A) this;
  }
  
  public A withClusterName(String clusterName) {
    this.clusterName = clusterName;
    return (A) this;
  }
  
  public A withClusterPoolRef(ClusterPoolReference clusterPoolRef) {
    this._visitables.remove("clusterPoolRef");
    if (clusterPoolRef != null) {
        this.clusterPoolRef = new ClusterPoolReferenceBuilder(clusterPoolRef);
        this._visitables.get("clusterPoolRef").add(this.clusterPoolRef);
    } else {
        this.clusterPoolRef = null;
        this._visitables.get("clusterPoolRef").remove(this.clusterPoolRef);
    }
    return (A) this;
  }
  
  public A withControlPlaneConfig(ControlPlaneConfigSpec controlPlaneConfig) {
    this._visitables.remove("controlPlaneConfig");
    if (controlPlaneConfig != null) {
        this.controlPlaneConfig = new ControlPlaneConfigSpecBuilder(controlPlaneConfig);
        this._visitables.get("controlPlaneConfig").add(this.controlPlaneConfig);
    } else {
        this.controlPlaneConfig = null;
        this._visitables.get("controlPlaneConfig").remove(this.controlPlaneConfig);
    }
    return (A) this;
  }
  
  public A withHibernateAfter(String hibernateAfter) {
    this.hibernateAfter = hibernateAfter;
    return (A) this;
  }
  
  public A withIngress(List<ClusterIngress> ingress) {
    if (this.ingress != null) {
      this._visitables.get("ingress").clear();
    }
    if (ingress != null) {
        this.ingress = new ArrayList();
        for (ClusterIngress item : ingress) {
          this.addToIngress(item);
        }
    } else {
      this.ingress = null;
    }
    return (A) this;
  }
  
  public A withIngress(ClusterIngress... ingress) {
    if (this.ingress != null) {
        this.ingress.clear();
        _visitables.remove("ingress");
    }
    if (ingress != null) {
      for (ClusterIngress item : ingress) {
        this.addToIngress(item);
      }
    }
    return (A) this;
  }
  
  public A withInstallAttemptsLimit(Integer installAttemptsLimit) {
    this.installAttemptsLimit = installAttemptsLimit;
    return (A) this;
  }
  
  public A withInstalled() {
    return withInstalled(true);
  }
  
  public A withInstalled(Boolean installed) {
    this.installed = installed;
    return (A) this;
  }
  
  public A withManageDNS() {
    return withManageDNS(true);
  }
  
  public A withManageDNS(Boolean manageDNS) {
    this.manageDNS = manageDNS;
    return (A) this;
  }
  
  public BoundServiceAccountSigningKeySecretRefNested<A> withNewBoundServiceAccountSigningKeySecretRef() {
    return new BoundServiceAccountSigningKeySecretRefNested(null);
  }
  
  public A withNewBoundServiceAccountSigningKeySecretRef(String name) {
    return (A) this.withBoundServiceAccountSigningKeySecretRef(new LocalObjectReference(name));
  }
  
  public BoundServiceAccountSigningKeySecretRefNested<A> withNewBoundServiceAccountSigningKeySecretRefLike(LocalObjectReference item) {
    return new BoundServiceAccountSigningKeySecretRefNested(item);
  }
  
  public ClusterInstallRefNested<A> withNewClusterInstallRef() {
    return new ClusterInstallRefNested(null);
  }
  
  public A withNewClusterInstallRef(String group,String kind,String name,String version) {
    return (A) this.withClusterInstallRef(new ClusterInstallLocalReference(group, kind, name, version));
  }
  
  public ClusterInstallRefNested<A> withNewClusterInstallRefLike(ClusterInstallLocalReference item) {
    return new ClusterInstallRefNested(item);
  }
  
  public ClusterMetadataNested<A> withNewClusterMetadata() {
    return new ClusterMetadataNested(null);
  }
  
  public ClusterMetadataNested<A> withNewClusterMetadataLike(ClusterMetadata item) {
    return new ClusterMetadataNested(item);
  }
  
  public ClusterPoolRefNested<A> withNewClusterPoolRef() {
    return new ClusterPoolRefNested(null);
  }
  
  public ClusterPoolRefNested<A> withNewClusterPoolRefLike(ClusterPoolReference item) {
    return new ClusterPoolRefNested(item);
  }
  
  public ControlPlaneConfigNested<A> withNewControlPlaneConfig() {
    return new ControlPlaneConfigNested(null);
  }
  
  public ControlPlaneConfigNested<A> withNewControlPlaneConfigLike(ControlPlaneConfigSpec item) {
    return new ControlPlaneConfigNested(item);
  }
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(Platform item) {
    return new PlatformNested(item);
  }
  
  public ProvisioningNested<A> withNewProvisioning() {
    return new ProvisioningNested(null);
  }
  
  public ProvisioningNested<A> withNewProvisioningLike(Provisioning item) {
    return new ProvisioningNested(item);
  }
  
  public PullSecretRefNested<A> withNewPullSecretRef() {
    return new PullSecretRefNested(null);
  }
  
  public A withNewPullSecretRef(String name) {
    return (A) this.withPullSecretRef(new LocalObjectReference(name));
  }
  
  public PullSecretRefNested<A> withNewPullSecretRefLike(LocalObjectReference item) {
    return new PullSecretRefNested(item);
  }
  
  public A withPlatform(Platform platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new PlatformBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
  }
  
  public A withPowerState(String powerState) {
    this.powerState = powerState;
    return (A) this;
  }
  
  public A withPreserveOnDelete() {
    return withPreserveOnDelete(true);
  }
  
  public A withPreserveOnDelete(Boolean preserveOnDelete) {
    this.preserveOnDelete = preserveOnDelete;
    return (A) this;
  }
  
  public A withProvisioning(Provisioning provisioning) {
    this._visitables.remove("provisioning");
    if (provisioning != null) {
        this.provisioning = new ProvisioningBuilder(provisioning);
        this._visitables.get("provisioning").add(this.provisioning);
    } else {
        this.provisioning = null;
        this._visitables.get("provisioning").remove(this.provisioning);
    }
    return (A) this;
  }
  
  public A withPullSecretRef(LocalObjectReference pullSecretRef) {
    this._visitables.remove("pullSecretRef");
    if (pullSecretRef != null) {
        this.pullSecretRef = new LocalObjectReferenceBuilder(pullSecretRef);
        this._visitables.get("pullSecretRef").add(this.pullSecretRef);
    } else {
        this.pullSecretRef = null;
        this._visitables.get("pullSecretRef").remove(this.pullSecretRef);
    }
    return (A) this;
  }
  public class BoundServiceAccountSigningKeySecretRefNested<N> extends LocalObjectReferenceFluent<BoundServiceAccountSigningKeySecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    BoundServiceAccountSigningKeySecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.withBoundServiceAccountSigningKeySecretRef(builder.build());
    }
    
    public N endBoundServiceAccountSigningKeySecretRef() {
      return and();
    }
    
  }
  public class CertificateBundlesNested<N> extends CertificateBundleSpecFluent<CertificateBundlesNested<N>> implements Nested<N>{
  
    CertificateBundleSpecBuilder builder;
    int index;
  
    CertificateBundlesNested(int index,CertificateBundleSpec item) {
      this.index = index;
      this.builder = new CertificateBundleSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.setToCertificateBundles(index, builder.build());
    }
    
    public N endCertificateBundle() {
      return and();
    }
    
  }
  public class ClusterInstallRefNested<N> extends ClusterInstallLocalReferenceFluent<ClusterInstallRefNested<N>> implements Nested<N>{
  
    ClusterInstallLocalReferenceBuilder builder;
  
    ClusterInstallRefNested(ClusterInstallLocalReference item) {
      this.builder = new ClusterInstallLocalReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.withClusterInstallRef(builder.build());
    }
    
    public N endClusterInstallRef() {
      return and();
    }
    
  }
  public class ClusterMetadataNested<N> extends ClusterMetadataFluent<ClusterMetadataNested<N>> implements Nested<N>{
  
    ClusterMetadataBuilder builder;
  
    ClusterMetadataNested(ClusterMetadata item) {
      this.builder = new ClusterMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.withClusterMetadata(builder.build());
    }
    
    public N endClusterMetadata() {
      return and();
    }
    
  }
  public class ClusterPoolRefNested<N> extends ClusterPoolReferenceFluent<ClusterPoolRefNested<N>> implements Nested<N>{
  
    ClusterPoolReferenceBuilder builder;
  
    ClusterPoolRefNested(ClusterPoolReference item) {
      this.builder = new ClusterPoolReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.withClusterPoolRef(builder.build());
    }
    
    public N endClusterPoolRef() {
      return and();
    }
    
  }
  public class ControlPlaneConfigNested<N> extends ControlPlaneConfigSpecFluent<ControlPlaneConfigNested<N>> implements Nested<N>{
  
    ControlPlaneConfigSpecBuilder builder;
  
    ControlPlaneConfigNested(ControlPlaneConfigSpec item) {
      this.builder = new ControlPlaneConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.withControlPlaneConfig(builder.build());
    }
    
    public N endControlPlaneConfig() {
      return and();
    }
    
  }
  public class IngressNested<N> extends ClusterIngressFluent<IngressNested<N>> implements Nested<N>{
  
    ClusterIngressBuilder builder;
    int index;
  
    IngressNested(int index,ClusterIngress item) {
      this.index = index;
      this.builder = new ClusterIngressBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.setToIngress(index, builder.build());
    }
    
    public N endIngress() {
      return and();
    }
    
  }
  public class PlatformNested<N> extends PlatformFluent<PlatformNested<N>> implements Nested<N>{
  
    PlatformBuilder builder;
  
    PlatformNested(Platform item) {
      this.builder = new PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
  public class ProvisioningNested<N> extends ProvisioningFluent<ProvisioningNested<N>> implements Nested<N>{
  
    ProvisioningBuilder builder;
  
    ProvisioningNested(Provisioning item) {
      this.builder = new ProvisioningBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.withProvisioning(builder.build());
    }
    
    public N endProvisioning() {
      return and();
    }
    
  }
  public class PullSecretRefNested<N> extends LocalObjectReferenceFluent<PullSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    PullSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentSpecFluent.this.withPullSecretRef(builder.build());
    }
    
    public N endPullSecretRef() {
      return and();
    }
    
  }
}