package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PlatformStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.PlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AlibabaCloudPlatformStatusBuilder alibabaCloud;
  private AWSPlatformStatusBuilder aws;
  private AzurePlatformStatusBuilder azure;
  private BareMetalPlatformStatusBuilder baremetal;
  private EquinixMetalPlatformStatusBuilder equinixMetal;
  private ExternalPlatformStatusBuilder external;
  private GCPPlatformStatusBuilder gcp;
  private IBMCloudPlatformStatusBuilder ibmcloud;
  private KubevirtPlatformStatusBuilder kubevirt;
  private NutanixPlatformStatusBuilder nutanix;
  private OpenStackPlatformStatusBuilder openstack;
  private OvirtPlatformStatusBuilder ovirt;
  private PowerVSPlatformStatusBuilder powervs;
  private String type;
  private VSpherePlatformStatusBuilder vsphere;

  public PlatformStatusFluent() {
  }
  
  public PlatformStatusFluent(PlatformStatus instance) {
    this.copyInstance(instance);
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
  
  public AlibabaCloudPlatformStatus buildAlibabaCloud() {
    return this.alibabaCloud != null ? this.alibabaCloud.build() : null;
  }
  
  public AWSPlatformStatus buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public AzurePlatformStatus buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public BareMetalPlatformStatus buildBaremetal() {
    return this.baremetal != null ? this.baremetal.build() : null;
  }
  
  public EquinixMetalPlatformStatus buildEquinixMetal() {
    return this.equinixMetal != null ? this.equinixMetal.build() : null;
  }
  
  public ExternalPlatformStatus buildExternal() {
    return this.external != null ? this.external.build() : null;
  }
  
  public GCPPlatformStatus buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public IBMCloudPlatformStatus buildIbmcloud() {
    return this.ibmcloud != null ? this.ibmcloud.build() : null;
  }
  
  public KubevirtPlatformStatus buildKubevirt() {
    return this.kubevirt != null ? this.kubevirt.build() : null;
  }
  
  public NutanixPlatformStatus buildNutanix() {
    return this.nutanix != null ? this.nutanix.build() : null;
  }
  
  public OpenStackPlatformStatus buildOpenstack() {
    return this.openstack != null ? this.openstack.build() : null;
  }
  
  public OvirtPlatformStatus buildOvirt() {
    return this.ovirt != null ? this.ovirt.build() : null;
  }
  
  public PowerVSPlatformStatus buildPowervs() {
    return this.powervs != null ? this.powervs.build() : null;
  }
  
  public VSpherePlatformStatus buildVsphere() {
    return this.vsphere != null ? this.vsphere.build() : null;
  }
  
  protected void copyInstance(PlatformStatus instance) {
    instance = instance != null ? instance : new PlatformStatus();
    if (instance != null) {
        this.withAlibabaCloud(instance.getAlibabaCloud());
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withBaremetal(instance.getBaremetal());
        this.withEquinixMetal(instance.getEquinixMetal());
        this.withExternal(instance.getExternal());
        this.withGcp(instance.getGcp());
        this.withIbmcloud(instance.getIbmcloud());
        this.withKubevirt(instance.getKubevirt());
        this.withNutanix(instance.getNutanix());
        this.withOpenstack(instance.getOpenstack());
        this.withOvirt(instance.getOvirt());
        this.withPowervs(instance.getPowervs());
        this.withType(instance.getType());
        this.withVsphere(instance.getVsphere());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AlibabaCloudNested<A> editAlibabaCloud() {
    return this.withNewAlibabaCloudLike(Optional.ofNullable(this.buildAlibabaCloud()).orElse(null));
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public AzureNested<A> editAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(null));
  }
  
  public BaremetalNested<A> editBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(null));
  }
  
  public EquinixMetalNested<A> editEquinixMetal() {
    return this.withNewEquinixMetalLike(Optional.ofNullable(this.buildEquinixMetal()).orElse(null));
  }
  
  public ExternalNested<A> editExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(null));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public IbmcloudNested<A> editIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(null));
  }
  
  public KubevirtNested<A> editKubevirt() {
    return this.withNewKubevirtLike(Optional.ofNullable(this.buildKubevirt()).orElse(null));
  }
  
  public NutanixNested<A> editNutanix() {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(null));
  }
  
  public OpenstackNested<A> editOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(null));
  }
  
  public AlibabaCloudNested<A> editOrNewAlibabaCloud() {
    return this.withNewAlibabaCloudLike(Optional.ofNullable(this.buildAlibabaCloud()).orElse(new AlibabaCloudPlatformStatusBuilder().build()));
  }
  
  public AlibabaCloudNested<A> editOrNewAlibabaCloudLike(AlibabaCloudPlatformStatus item) {
    return this.withNewAlibabaCloudLike(Optional.ofNullable(this.buildAlibabaCloud()).orElse(item));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AWSPlatformStatusBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(AWSPlatformStatus item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new AzurePlatformStatusBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(AzurePlatformStatus item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public BaremetalNested<A> editOrNewBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(new BareMetalPlatformStatusBuilder().build()));
  }
  
  public BaremetalNested<A> editOrNewBaremetalLike(BareMetalPlatformStatus item) {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(item));
  }
  
  public EquinixMetalNested<A> editOrNewEquinixMetal() {
    return this.withNewEquinixMetalLike(Optional.ofNullable(this.buildEquinixMetal()).orElse(new EquinixMetalPlatformStatusBuilder().build()));
  }
  
  public EquinixMetalNested<A> editOrNewEquinixMetalLike(EquinixMetalPlatformStatus item) {
    return this.withNewEquinixMetalLike(Optional.ofNullable(this.buildEquinixMetal()).orElse(item));
  }
  
  public ExternalNested<A> editOrNewExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(new ExternalPlatformStatusBuilder().build()));
  }
  
  public ExternalNested<A> editOrNewExternalLike(ExternalPlatformStatus item) {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new GCPPlatformStatusBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(GCPPlatformStatus item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(new IBMCloudPlatformStatusBuilder().build()));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloudLike(IBMCloudPlatformStatus item) {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(item));
  }
  
  public KubevirtNested<A> editOrNewKubevirt() {
    return this.withNewKubevirtLike(Optional.ofNullable(this.buildKubevirt()).orElse(new KubevirtPlatformStatusBuilder().build()));
  }
  
  public KubevirtNested<A> editOrNewKubevirtLike(KubevirtPlatformStatus item) {
    return this.withNewKubevirtLike(Optional.ofNullable(this.buildKubevirt()).orElse(item));
  }
  
  public NutanixNested<A> editOrNewNutanix() {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(new NutanixPlatformStatusBuilder().build()));
  }
  
  public NutanixNested<A> editOrNewNutanixLike(NutanixPlatformStatus item) {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(item));
  }
  
  public OpenstackNested<A> editOrNewOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(new OpenStackPlatformStatusBuilder().build()));
  }
  
  public OpenstackNested<A> editOrNewOpenstackLike(OpenStackPlatformStatus item) {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(item));
  }
  
  public OvirtNested<A> editOrNewOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(new OvirtPlatformStatusBuilder().build()));
  }
  
  public OvirtNested<A> editOrNewOvirtLike(OvirtPlatformStatus item) {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(item));
  }
  
  public PowervsNested<A> editOrNewPowervs() {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(new PowerVSPlatformStatusBuilder().build()));
  }
  
  public PowervsNested<A> editOrNewPowervsLike(PowerVSPlatformStatus item) {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(item));
  }
  
  public VsphereNested<A> editOrNewVsphere() {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(new VSpherePlatformStatusBuilder().build()));
  }
  
  public VsphereNested<A> editOrNewVsphereLike(VSpherePlatformStatus item) {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(item));
  }
  
  public OvirtNested<A> editOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(null));
  }
  
  public PowervsNested<A> editPowervs() {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(null));
  }
  
  public VsphereNested<A> editVsphere() {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(null));
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
    PlatformStatusFluent that = (PlatformStatusFluent) o;
    if (!(Objects.equals(alibabaCloud, that.alibabaCloud))) {
      return false;
    }
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(baremetal, that.baremetal))) {
      return false;
    }
    if (!(Objects.equals(equinixMetal, that.equinixMetal))) {
      return false;
    }
    if (!(Objects.equals(external, that.external))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(ibmcloud, that.ibmcloud))) {
      return false;
    }
    if (!(Objects.equals(kubevirt, that.kubevirt))) {
      return false;
    }
    if (!(Objects.equals(nutanix, that.nutanix))) {
      return false;
    }
    if (!(Objects.equals(openstack, that.openstack))) {
      return false;
    }
    if (!(Objects.equals(ovirt, that.ovirt))) {
      return false;
    }
    if (!(Objects.equals(powervs, that.powervs))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(vsphere, that.vsphere))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlibabaCloud() {
    return this.alibabaCloud != null;
  }
  
  public boolean hasAws() {
    return this.aws != null;
  }
  
  public boolean hasAzure() {
    return this.azure != null;
  }
  
  public boolean hasBaremetal() {
    return this.baremetal != null;
  }
  
  public boolean hasEquinixMetal() {
    return this.equinixMetal != null;
  }
  
  public boolean hasExternal() {
    return this.external != null;
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public boolean hasIbmcloud() {
    return this.ibmcloud != null;
  }
  
  public boolean hasKubevirt() {
    return this.kubevirt != null;
  }
  
  public boolean hasNutanix() {
    return this.nutanix != null;
  }
  
  public boolean hasOpenstack() {
    return this.openstack != null;
  }
  
  public boolean hasOvirt() {
    return this.ovirt != null;
  }
  
  public boolean hasPowervs() {
    return this.powervs != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasVsphere() {
    return this.vsphere != null;
  }
  
  public int hashCode() {
    return Objects.hash(alibabaCloud, aws, azure, baremetal, equinixMetal, external, gcp, ibmcloud, kubevirt, nutanix, openstack, ovirt, powervs, type, vsphere, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(alibabaCloud == null)) {
        sb.append("alibabaCloud:");
        sb.append(alibabaCloud);
        sb.append(",");
    }
    if (!(aws == null)) {
        sb.append("aws:");
        sb.append(aws);
        sb.append(",");
    }
    if (!(azure == null)) {
        sb.append("azure:");
        sb.append(azure);
        sb.append(",");
    }
    if (!(baremetal == null)) {
        sb.append("baremetal:");
        sb.append(baremetal);
        sb.append(",");
    }
    if (!(equinixMetal == null)) {
        sb.append("equinixMetal:");
        sb.append(equinixMetal);
        sb.append(",");
    }
    if (!(external == null)) {
        sb.append("external:");
        sb.append(external);
        sb.append(",");
    }
    if (!(gcp == null)) {
        sb.append("gcp:");
        sb.append(gcp);
        sb.append(",");
    }
    if (!(ibmcloud == null)) {
        sb.append("ibmcloud:");
        sb.append(ibmcloud);
        sb.append(",");
    }
    if (!(kubevirt == null)) {
        sb.append("kubevirt:");
        sb.append(kubevirt);
        sb.append(",");
    }
    if (!(nutanix == null)) {
        sb.append("nutanix:");
        sb.append(nutanix);
        sb.append(",");
    }
    if (!(openstack == null)) {
        sb.append("openstack:");
        sb.append(openstack);
        sb.append(",");
    }
    if (!(ovirt == null)) {
        sb.append("ovirt:");
        sb.append(ovirt);
        sb.append(",");
    }
    if (!(powervs == null)) {
        sb.append("powervs:");
        sb.append(powervs);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(vsphere == null)) {
        sb.append("vsphere:");
        sb.append(vsphere);
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
  
  public A withAlibabaCloud(AlibabaCloudPlatformStatus alibabaCloud) {
    this._visitables.remove("alibabaCloud");
    if (alibabaCloud != null) {
        this.alibabaCloud = new AlibabaCloudPlatformStatusBuilder(alibabaCloud);
        this._visitables.get("alibabaCloud").add(this.alibabaCloud);
    } else {
        this.alibabaCloud = null;
        this._visitables.get("alibabaCloud").remove(this.alibabaCloud);
    }
    return (A) this;
  }
  
  public A withAws(AWSPlatformStatus aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AWSPlatformStatusBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(AzurePlatformStatus azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new AzurePlatformStatusBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withBaremetal(BareMetalPlatformStatus baremetal) {
    this._visitables.remove("baremetal");
    if (baremetal != null) {
        this.baremetal = new BareMetalPlatformStatusBuilder(baremetal);
        this._visitables.get("baremetal").add(this.baremetal);
    } else {
        this.baremetal = null;
        this._visitables.get("baremetal").remove(this.baremetal);
    }
    return (A) this;
  }
  
  public A withEquinixMetal(EquinixMetalPlatformStatus equinixMetal) {
    this._visitables.remove("equinixMetal");
    if (equinixMetal != null) {
        this.equinixMetal = new EquinixMetalPlatformStatusBuilder(equinixMetal);
        this._visitables.get("equinixMetal").add(this.equinixMetal);
    } else {
        this.equinixMetal = null;
        this._visitables.get("equinixMetal").remove(this.equinixMetal);
    }
    return (A) this;
  }
  
  public A withExternal(ExternalPlatformStatus external) {
    this._visitables.remove("external");
    if (external != null) {
        this.external = new ExternalPlatformStatusBuilder(external);
        this._visitables.get("external").add(this.external);
    } else {
        this.external = null;
        this._visitables.get("external").remove(this.external);
    }
    return (A) this;
  }
  
  public A withGcp(GCPPlatformStatus gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new GCPPlatformStatusBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withIbmcloud(IBMCloudPlatformStatus ibmcloud) {
    this._visitables.remove("ibmcloud");
    if (ibmcloud != null) {
        this.ibmcloud = new IBMCloudPlatformStatusBuilder(ibmcloud);
        this._visitables.get("ibmcloud").add(this.ibmcloud);
    } else {
        this.ibmcloud = null;
        this._visitables.get("ibmcloud").remove(this.ibmcloud);
    }
    return (A) this;
  }
  
  public A withKubevirt(KubevirtPlatformStatus kubevirt) {
    this._visitables.remove("kubevirt");
    if (kubevirt != null) {
        this.kubevirt = new KubevirtPlatformStatusBuilder(kubevirt);
        this._visitables.get("kubevirt").add(this.kubevirt);
    } else {
        this.kubevirt = null;
        this._visitables.get("kubevirt").remove(this.kubevirt);
    }
    return (A) this;
  }
  
  public AlibabaCloudNested<A> withNewAlibabaCloud() {
    return new AlibabaCloudNested(null);
  }
  
  public AlibabaCloudNested<A> withNewAlibabaCloudLike(AlibabaCloudPlatformStatus item) {
    return new AlibabaCloudNested(item);
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(AWSPlatformStatus item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(AzurePlatformStatus item) {
    return new AzureNested(item);
  }
  
  public BaremetalNested<A> withNewBaremetal() {
    return new BaremetalNested(null);
  }
  
  public BaremetalNested<A> withNewBaremetalLike(BareMetalPlatformStatus item) {
    return new BaremetalNested(item);
  }
  
  public EquinixMetalNested<A> withNewEquinixMetal() {
    return new EquinixMetalNested(null);
  }
  
  public A withNewEquinixMetal(String apiServerInternalIP,String ingressIP) {
    return (A) this.withEquinixMetal(new EquinixMetalPlatformStatus(apiServerInternalIP, ingressIP));
  }
  
  public EquinixMetalNested<A> withNewEquinixMetalLike(EquinixMetalPlatformStatus item) {
    return new EquinixMetalNested(item);
  }
  
  public ExternalNested<A> withNewExternal() {
    return new ExternalNested(null);
  }
  
  public ExternalNested<A> withNewExternalLike(ExternalPlatformStatus item) {
    return new ExternalNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(GCPPlatformStatus item) {
    return new GcpNested(item);
  }
  
  public IbmcloudNested<A> withNewIbmcloud() {
    return new IbmcloudNested(null);
  }
  
  public IbmcloudNested<A> withNewIbmcloudLike(IBMCloudPlatformStatus item) {
    return new IbmcloudNested(item);
  }
  
  public KubevirtNested<A> withNewKubevirt() {
    return new KubevirtNested(null);
  }
  
  public A withNewKubevirt(String apiServerInternalIP,String ingressIP) {
    return (A) this.withKubevirt(new KubevirtPlatformStatus(apiServerInternalIP, ingressIP));
  }
  
  public KubevirtNested<A> withNewKubevirtLike(KubevirtPlatformStatus item) {
    return new KubevirtNested(item);
  }
  
  public NutanixNested<A> withNewNutanix() {
    return new NutanixNested(null);
  }
  
  public NutanixNested<A> withNewNutanixLike(NutanixPlatformStatus item) {
    return new NutanixNested(item);
  }
  
  public OpenstackNested<A> withNewOpenstack() {
    return new OpenstackNested(null);
  }
  
  public OpenstackNested<A> withNewOpenstackLike(OpenStackPlatformStatus item) {
    return new OpenstackNested(item);
  }
  
  public OvirtNested<A> withNewOvirt() {
    return new OvirtNested(null);
  }
  
  public OvirtNested<A> withNewOvirtLike(OvirtPlatformStatus item) {
    return new OvirtNested(item);
  }
  
  public PowervsNested<A> withNewPowervs() {
    return new PowervsNested(null);
  }
  
  public PowervsNested<A> withNewPowervsLike(PowerVSPlatformStatus item) {
    return new PowervsNested(item);
  }
  
  public VsphereNested<A> withNewVsphere() {
    return new VsphereNested(null);
  }
  
  public VsphereNested<A> withNewVsphereLike(VSpherePlatformStatus item) {
    return new VsphereNested(item);
  }
  
  public A withNutanix(NutanixPlatformStatus nutanix) {
    this._visitables.remove("nutanix");
    if (nutanix != null) {
        this.nutanix = new NutanixPlatformStatusBuilder(nutanix);
        this._visitables.get("nutanix").add(this.nutanix);
    } else {
        this.nutanix = null;
        this._visitables.get("nutanix").remove(this.nutanix);
    }
    return (A) this;
  }
  
  public A withOpenstack(OpenStackPlatformStatus openstack) {
    this._visitables.remove("openstack");
    if (openstack != null) {
        this.openstack = new OpenStackPlatformStatusBuilder(openstack);
        this._visitables.get("openstack").add(this.openstack);
    } else {
        this.openstack = null;
        this._visitables.get("openstack").remove(this.openstack);
    }
    return (A) this;
  }
  
  public A withOvirt(OvirtPlatformStatus ovirt) {
    this._visitables.remove("ovirt");
    if (ovirt != null) {
        this.ovirt = new OvirtPlatformStatusBuilder(ovirt);
        this._visitables.get("ovirt").add(this.ovirt);
    } else {
        this.ovirt = null;
        this._visitables.get("ovirt").remove(this.ovirt);
    }
    return (A) this;
  }
  
  public A withPowervs(PowerVSPlatformStatus powervs) {
    this._visitables.remove("powervs");
    if (powervs != null) {
        this.powervs = new PowerVSPlatformStatusBuilder(powervs);
        this._visitables.get("powervs").add(this.powervs);
    } else {
        this.powervs = null;
        this._visitables.get("powervs").remove(this.powervs);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withVsphere(VSpherePlatformStatus vsphere) {
    this._visitables.remove("vsphere");
    if (vsphere != null) {
        this.vsphere = new VSpherePlatformStatusBuilder(vsphere);
        this._visitables.get("vsphere").add(this.vsphere);
    } else {
        this.vsphere = null;
        this._visitables.get("vsphere").remove(this.vsphere);
    }
    return (A) this;
  }
  public class AlibabaCloudNested<N> extends AlibabaCloudPlatformStatusFluent<AlibabaCloudNested<N>> implements Nested<N>{
  
    AlibabaCloudPlatformStatusBuilder builder;
  
    AlibabaCloudNested(AlibabaCloudPlatformStatus item) {
      this.builder = new AlibabaCloudPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withAlibabaCloud(builder.build());
    }
    
    public N endAlibabaCloud() {
      return and();
    }
    
  }
  public class AwsNested<N> extends AWSPlatformStatusFluent<AwsNested<N>> implements Nested<N>{
  
    AWSPlatformStatusBuilder builder;
  
    AwsNested(AWSPlatformStatus item) {
      this.builder = new AWSPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends AzurePlatformStatusFluent<AzureNested<N>> implements Nested<N>{
  
    AzurePlatformStatusBuilder builder;
  
    AzureNested(AzurePlatformStatus item) {
      this.builder = new AzurePlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class BaremetalNested<N> extends BareMetalPlatformStatusFluent<BaremetalNested<N>> implements Nested<N>{
  
    BareMetalPlatformStatusBuilder builder;
  
    BaremetalNested(BareMetalPlatformStatus item) {
      this.builder = new BareMetalPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withBaremetal(builder.build());
    }
    
    public N endBaremetal() {
      return and();
    }
    
  }
  public class EquinixMetalNested<N> extends EquinixMetalPlatformStatusFluent<EquinixMetalNested<N>> implements Nested<N>{
  
    EquinixMetalPlatformStatusBuilder builder;
  
    EquinixMetalNested(EquinixMetalPlatformStatus item) {
      this.builder = new EquinixMetalPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withEquinixMetal(builder.build());
    }
    
    public N endEquinixMetal() {
      return and();
    }
    
  }
  public class ExternalNested<N> extends ExternalPlatformStatusFluent<ExternalNested<N>> implements Nested<N>{
  
    ExternalPlatformStatusBuilder builder;
  
    ExternalNested(ExternalPlatformStatus item) {
      this.builder = new ExternalPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withExternal(builder.build());
    }
    
    public N endExternal() {
      return and();
    }
    
  }
  public class GcpNested<N> extends GCPPlatformStatusFluent<GcpNested<N>> implements Nested<N>{
  
    GCPPlatformStatusBuilder builder;
  
    GcpNested(GCPPlatformStatus item) {
      this.builder = new GCPPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class IbmcloudNested<N> extends IBMCloudPlatformStatusFluent<IbmcloudNested<N>> implements Nested<N>{
  
    IBMCloudPlatformStatusBuilder builder;
  
    IbmcloudNested(IBMCloudPlatformStatus item) {
      this.builder = new IBMCloudPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withIbmcloud(builder.build());
    }
    
    public N endIbmcloud() {
      return and();
    }
    
  }
  public class KubevirtNested<N> extends KubevirtPlatformStatusFluent<KubevirtNested<N>> implements Nested<N>{
  
    KubevirtPlatformStatusBuilder builder;
  
    KubevirtNested(KubevirtPlatformStatus item) {
      this.builder = new KubevirtPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withKubevirt(builder.build());
    }
    
    public N endKubevirt() {
      return and();
    }
    
  }
  public class NutanixNested<N> extends NutanixPlatformStatusFluent<NutanixNested<N>> implements Nested<N>{
  
    NutanixPlatformStatusBuilder builder;
  
    NutanixNested(NutanixPlatformStatus item) {
      this.builder = new NutanixPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withNutanix(builder.build());
    }
    
    public N endNutanix() {
      return and();
    }
    
  }
  public class OpenstackNested<N> extends OpenStackPlatformStatusFluent<OpenstackNested<N>> implements Nested<N>{
  
    OpenStackPlatformStatusBuilder builder;
  
    OpenstackNested(OpenStackPlatformStatus item) {
      this.builder = new OpenStackPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withOpenstack(builder.build());
    }
    
    public N endOpenstack() {
      return and();
    }
    
  }
  public class OvirtNested<N> extends OvirtPlatformStatusFluent<OvirtNested<N>> implements Nested<N>{
  
    OvirtPlatformStatusBuilder builder;
  
    OvirtNested(OvirtPlatformStatus item) {
      this.builder = new OvirtPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withOvirt(builder.build());
    }
    
    public N endOvirt() {
      return and();
    }
    
  }
  public class PowervsNested<N> extends PowerVSPlatformStatusFluent<PowervsNested<N>> implements Nested<N>{
  
    PowerVSPlatformStatusBuilder builder;
  
    PowervsNested(PowerVSPlatformStatus item) {
      this.builder = new PowerVSPlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withPowervs(builder.build());
    }
    
    public N endPowervs() {
      return and();
    }
    
  }
  public class VsphereNested<N> extends VSpherePlatformStatusFluent<VsphereNested<N>> implements Nested<N>{
  
    VSpherePlatformStatusBuilder builder;
  
    VsphereNested(VSpherePlatformStatus item) {
      this.builder = new VSpherePlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withVsphere(builder.build());
    }
    
    public N endVsphere() {
      return and();
    }
    
  }
}