package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.installer.aws.v1.MachinePool;
import io.fabric8.openshift.api.model.installer.aws.v1.MachinePoolBuilder;
import io.fabric8.openshift.api.model.installer.aws.v1.MachinePoolFluent;
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
public class MachinePoolPlatformFluent<A extends io.fabric8.openshift.api.model.installer.v1.MachinePoolPlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MachinePoolBuilder aws;
  private Object azure;
  private io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePoolBuilder baremetal;
  private io.fabric8.openshift.api.model.installer.gcp.v1.MachinePoolBuilder gcp;
  private io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePoolBuilder ibmcloud;
  private io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePoolBuilder nutanix;
  private io.fabric8.openshift.api.model.installer.openstack.v1.MachinePoolBuilder openstack;
  private io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePoolBuilder ovirt;
  private io.fabric8.openshift.api.model.installer.powervc.v1.MachinePoolBuilder powervc;
  private io.fabric8.openshift.api.model.installer.powervs.v1.MachinePoolBuilder powervs;
  private io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePoolBuilder vsphere;

  public MachinePoolPlatformFluent() {
  }
  
  public MachinePoolPlatformFluent(MachinePoolPlatform instance) {
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
  
  public MachinePool buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool buildBaremetal() {
    return this.baremetal != null ? this.baremetal.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool buildIbmcloud() {
    return this.ibmcloud != null ? this.ibmcloud.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool buildNutanix() {
    return this.nutanix != null ? this.nutanix.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool buildOpenstack() {
    return this.openstack != null ? this.openstack.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool buildOvirt() {
    return this.ovirt != null ? this.ovirt.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.powervc.v1.MachinePool buildPowervc() {
    return this.powervc != null ? this.powervc.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool buildPowervs() {
    return this.powervs != null ? this.powervs.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool buildVsphere() {
    return this.vsphere != null ? this.vsphere.build() : null;
  }
  
  protected void copyInstance(MachinePoolPlatform instance) {
    instance = instance != null ? instance : new MachinePoolPlatform();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withBaremetal(instance.getBaremetal());
        this.withGcp(instance.getGcp());
        this.withIbmcloud(instance.getIbmcloud());
        this.withNutanix(instance.getNutanix());
        this.withOpenstack(instance.getOpenstack());
        this.withOvirt(instance.getOvirt());
        this.withPowervc(instance.getPowervc());
        this.withPowervs(instance.getPowervs());
        this.withVsphere(instance.getVsphere());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public BaremetalNested<A> editBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(null));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public IbmcloudNested<A> editIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(null));
  }
  
  public NutanixNested<A> editNutanix() {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(null));
  }
  
  public OpenstackNested<A> editOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new MachinePoolBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(MachinePool item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public BaremetalNested<A> editOrNewBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(new io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePoolBuilder().build()));
  }
  
  public BaremetalNested<A> editOrNewBaremetalLike(io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool item) {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new io.fabric8.openshift.api.model.installer.gcp.v1.MachinePoolBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(new io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePoolBuilder().build()));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloudLike(io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool item) {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(item));
  }
  
  public NutanixNested<A> editOrNewNutanix() {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(new io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePoolBuilder().build()));
  }
  
  public NutanixNested<A> editOrNewNutanixLike(io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool item) {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(item));
  }
  
  public OpenstackNested<A> editOrNewOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(new io.fabric8.openshift.api.model.installer.openstack.v1.MachinePoolBuilder().build()));
  }
  
  public OpenstackNested<A> editOrNewOpenstackLike(io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool item) {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(item));
  }
  
  public OvirtNested<A> editOrNewOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(new io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePoolBuilder().build()));
  }
  
  public OvirtNested<A> editOrNewOvirtLike(io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool item) {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(item));
  }
  
  public PowervcNested<A> editOrNewPowervc() {
    return this.withNewPowervcLike(Optional.ofNullable(this.buildPowervc()).orElse(new io.fabric8.openshift.api.model.installer.powervc.v1.MachinePoolBuilder().build()));
  }
  
  public PowervcNested<A> editOrNewPowervcLike(io.fabric8.openshift.api.model.installer.powervc.v1.MachinePool item) {
    return this.withNewPowervcLike(Optional.ofNullable(this.buildPowervc()).orElse(item));
  }
  
  public PowervsNested<A> editOrNewPowervs() {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(new io.fabric8.openshift.api.model.installer.powervs.v1.MachinePoolBuilder().build()));
  }
  
  public PowervsNested<A> editOrNewPowervsLike(io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool item) {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(item));
  }
  
  public VsphereNested<A> editOrNewVsphere() {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(new io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePoolBuilder().build()));
  }
  
  public VsphereNested<A> editOrNewVsphereLike(io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool item) {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(item));
  }
  
  public OvirtNested<A> editOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(null));
  }
  
  public PowervcNested<A> editPowervc() {
    return this.withNewPowervcLike(Optional.ofNullable(this.buildPowervc()).orElse(null));
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
    MachinePoolPlatformFluent that = (MachinePoolPlatformFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(baremetal, that.baremetal))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(ibmcloud, that.ibmcloud))) {
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
    if (!(Objects.equals(powervc, that.powervc))) {
      return false;
    }
    if (!(Objects.equals(powervs, that.powervs))) {
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
  
  public Object getAzure() {
    return this.azure;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
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
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public boolean hasIbmcloud() {
    return this.ibmcloud != null;
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
  
  public boolean hasPowervc() {
    return this.powervc != null;
  }
  
  public boolean hasPowervs() {
    return this.powervs != null;
  }
  
  public boolean hasVsphere() {
    return this.vsphere != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, azure, baremetal, gcp, ibmcloud, nutanix, openstack, ovirt, powervc, powervs, vsphere, additionalProperties);
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
    if (!(powervc == null)) {
        sb.append("powervc:");
        sb.append(powervc);
        sb.append(",");
    }
    if (!(powervs == null)) {
        sb.append("powervs:");
        sb.append(powervs);
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
  
  public A withAws(MachinePool aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new MachinePoolBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(Object azure) {
    this.azure = azure;
    return (A) this;
  }
  
  public A withBaremetal(io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool baremetal) {
    this._visitables.remove("baremetal");
    if (baremetal != null) {
        this.baremetal = new io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePoolBuilder(baremetal);
        this._visitables.get("baremetal").add(this.baremetal);
    } else {
        this.baremetal = null;
        this._visitables.get("baremetal").remove(this.baremetal);
    }
    return (A) this;
  }
  
  public A withGcp(io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new io.fabric8.openshift.api.model.installer.gcp.v1.MachinePoolBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withIbmcloud(io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool ibmcloud) {
    this._visitables.remove("ibmcloud");
    if (ibmcloud != null) {
        this.ibmcloud = new io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePoolBuilder(ibmcloud);
        this._visitables.get("ibmcloud").add(this.ibmcloud);
    } else {
        this.ibmcloud = null;
        this._visitables.get("ibmcloud").remove(this.ibmcloud);
    }
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(MachinePool item) {
    return new AwsNested(item);
  }
  
  public BaremetalNested<A> withNewBaremetal() {
    return new BaremetalNested(null);
  }
  
  public BaremetalNested<A> withNewBaremetalLike(io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool item) {
    return new BaremetalNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool item) {
    return new GcpNested(item);
  }
  
  public IbmcloudNested<A> withNewIbmcloud() {
    return new IbmcloudNested(null);
  }
  
  public IbmcloudNested<A> withNewIbmcloudLike(io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool item) {
    return new IbmcloudNested(item);
  }
  
  public NutanixNested<A> withNewNutanix() {
    return new NutanixNested(null);
  }
  
  public NutanixNested<A> withNewNutanixLike(io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool item) {
    return new NutanixNested(item);
  }
  
  public OpenstackNested<A> withNewOpenstack() {
    return new OpenstackNested(null);
  }
  
  public OpenstackNested<A> withNewOpenstackLike(io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool item) {
    return new OpenstackNested(item);
  }
  
  public OvirtNested<A> withNewOvirt() {
    return new OvirtNested(null);
  }
  
  public OvirtNested<A> withNewOvirtLike(io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool item) {
    return new OvirtNested(item);
  }
  
  public PowervcNested<A> withNewPowervc() {
    return new PowervcNested(null);
  }
  
  public PowervcNested<A> withNewPowervcLike(io.fabric8.openshift.api.model.installer.powervc.v1.MachinePool item) {
    return new PowervcNested(item);
  }
  
  public PowervsNested<A> withNewPowervs() {
    return new PowervsNested(null);
  }
  
  public PowervsNested<A> withNewPowervsLike(io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool item) {
    return new PowervsNested(item);
  }
  
  public VsphereNested<A> withNewVsphere() {
    return new VsphereNested(null);
  }
  
  public VsphereNested<A> withNewVsphereLike(io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool item) {
    return new VsphereNested(item);
  }
  
  public A withNutanix(io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool nutanix) {
    this._visitables.remove("nutanix");
    if (nutanix != null) {
        this.nutanix = new io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePoolBuilder(nutanix);
        this._visitables.get("nutanix").add(this.nutanix);
    } else {
        this.nutanix = null;
        this._visitables.get("nutanix").remove(this.nutanix);
    }
    return (A) this;
  }
  
  public A withOpenstack(io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool openstack) {
    this._visitables.remove("openstack");
    if (openstack != null) {
        this.openstack = new io.fabric8.openshift.api.model.installer.openstack.v1.MachinePoolBuilder(openstack);
        this._visitables.get("openstack").add(this.openstack);
    } else {
        this.openstack = null;
        this._visitables.get("openstack").remove(this.openstack);
    }
    return (A) this;
  }
  
  public A withOvirt(io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool ovirt) {
    this._visitables.remove("ovirt");
    if (ovirt != null) {
        this.ovirt = new io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePoolBuilder(ovirt);
        this._visitables.get("ovirt").add(this.ovirt);
    } else {
        this.ovirt = null;
        this._visitables.get("ovirt").remove(this.ovirt);
    }
    return (A) this;
  }
  
  public A withPowervc(io.fabric8.openshift.api.model.installer.powervc.v1.MachinePool powervc) {
    this._visitables.remove("powervc");
    if (powervc != null) {
        this.powervc = new io.fabric8.openshift.api.model.installer.powervc.v1.MachinePoolBuilder(powervc);
        this._visitables.get("powervc").add(this.powervc);
    } else {
        this.powervc = null;
        this._visitables.get("powervc").remove(this.powervc);
    }
    return (A) this;
  }
  
  public A withPowervs(io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool powervs) {
    this._visitables.remove("powervs");
    if (powervs != null) {
        this.powervs = new io.fabric8.openshift.api.model.installer.powervs.v1.MachinePoolBuilder(powervs);
        this._visitables.get("powervs").add(this.powervs);
    } else {
        this.powervs = null;
        this._visitables.get("powervs").remove(this.powervs);
    }
    return (A) this;
  }
  
  public A withVsphere(io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool vsphere) {
    this._visitables.remove("vsphere");
    if (vsphere != null) {
        this.vsphere = new io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePoolBuilder(vsphere);
        this._visitables.get("vsphere").add(this.vsphere);
    } else {
        this.vsphere = null;
        this._visitables.get("vsphere").remove(this.vsphere);
    }
    return (A) this;
  }
  public class AwsNested<N> extends MachinePoolFluent<AwsNested<N>> implements Nested<N>{
  
    MachinePoolBuilder builder;
  
    AwsNested(MachinePool item) {
      this.builder = new MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class BaremetalNested<N> extends io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePoolFluent<BaremetalNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePoolBuilder builder;
  
    BaremetalNested(io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withBaremetal(builder.build());
    }
    
    public N endBaremetal() {
      return and();
    }
    
  }
  public class GcpNested<N> extends io.fabric8.openshift.api.model.installer.gcp.v1.MachinePoolFluent<GcpNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.gcp.v1.MachinePoolBuilder builder;
  
    GcpNested(io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.gcp.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class IbmcloudNested<N> extends io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePoolFluent<IbmcloudNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePoolBuilder builder;
  
    IbmcloudNested(io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withIbmcloud(builder.build());
    }
    
    public N endIbmcloud() {
      return and();
    }
    
  }
  public class NutanixNested<N> extends io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePoolFluent<NutanixNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePoolBuilder builder;
  
    NutanixNested(io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withNutanix(builder.build());
    }
    
    public N endNutanix() {
      return and();
    }
    
  }
  public class OpenstackNested<N> extends io.fabric8.openshift.api.model.installer.openstack.v1.MachinePoolFluent<OpenstackNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.openstack.v1.MachinePoolBuilder builder;
  
    OpenstackNested(io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.openstack.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withOpenstack(builder.build());
    }
    
    public N endOpenstack() {
      return and();
    }
    
  }
  public class OvirtNested<N> extends io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePoolFluent<OvirtNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePoolBuilder builder;
  
    OvirtNested(io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withOvirt(builder.build());
    }
    
    public N endOvirt() {
      return and();
    }
    
  }
  public class PowervcNested<N> extends io.fabric8.openshift.api.model.installer.powervc.v1.MachinePoolFluent<PowervcNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.powervc.v1.MachinePoolBuilder builder;
  
    PowervcNested(io.fabric8.openshift.api.model.installer.powervc.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.powervc.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withPowervc(builder.build());
    }
    
    public N endPowervc() {
      return and();
    }
    
  }
  public class PowervsNested<N> extends io.fabric8.openshift.api.model.installer.powervs.v1.MachinePoolFluent<PowervsNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.powervs.v1.MachinePoolBuilder builder;
  
    PowervsNested(io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.powervs.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withPowervs(builder.build());
    }
    
    public N endPowervs() {
      return and();
    }
    
  }
  public class VsphereNested<N> extends io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePoolFluent<VsphereNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePoolBuilder builder;
  
    VsphereNested(io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool item) {
      this.builder = new io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolPlatformFluent.this.withVsphere(builder.build());
    }
    
    public N endVsphere() {
      return and();
    }
    
  }
}