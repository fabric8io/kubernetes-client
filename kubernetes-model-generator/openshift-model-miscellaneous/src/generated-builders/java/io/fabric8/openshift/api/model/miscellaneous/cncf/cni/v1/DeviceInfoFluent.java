package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
public class DeviceInfoFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.DeviceInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MemifDeviceBuilder memif;
  private PciDeviceBuilder pci;
  private String type;
  private VdpaDeviceBuilder vdpa;
  private String version;
  private VhostDeviceBuilder vhostUser;

  public DeviceInfoFluent() {
  }
  
  public DeviceInfoFluent(DeviceInfo instance) {
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
  
  public MemifDevice buildMemif() {
    return this.memif != null ? this.memif.build() : null;
  }
  
  public PciDevice buildPci() {
    return this.pci != null ? this.pci.build() : null;
  }
  
  public VdpaDevice buildVdpa() {
    return this.vdpa != null ? this.vdpa.build() : null;
  }
  
  public VhostDevice buildVhostUser() {
    return this.vhostUser != null ? this.vhostUser.build() : null;
  }
  
  protected void copyInstance(DeviceInfo instance) {
    instance = instance != null ? instance : new DeviceInfo();
    if (instance != null) {
        this.withMemif(instance.getMemif());
        this.withPci(instance.getPci());
        this.withType(instance.getType());
        this.withVdpa(instance.getVdpa());
        this.withVersion(instance.getVersion());
        this.withVhostUser(instance.getVhostUser());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MemifNested<A> editMemif() {
    return this.withNewMemifLike(Optional.ofNullable(this.buildMemif()).orElse(null));
  }
  
  public MemifNested<A> editOrNewMemif() {
    return this.withNewMemifLike(Optional.ofNullable(this.buildMemif()).orElse(new MemifDeviceBuilder().build()));
  }
  
  public MemifNested<A> editOrNewMemifLike(MemifDevice item) {
    return this.withNewMemifLike(Optional.ofNullable(this.buildMemif()).orElse(item));
  }
  
  public PciNested<A> editOrNewPci() {
    return this.withNewPciLike(Optional.ofNullable(this.buildPci()).orElse(new PciDeviceBuilder().build()));
  }
  
  public PciNested<A> editOrNewPciLike(PciDevice item) {
    return this.withNewPciLike(Optional.ofNullable(this.buildPci()).orElse(item));
  }
  
  public VdpaNested<A> editOrNewVdpa() {
    return this.withNewVdpaLike(Optional.ofNullable(this.buildVdpa()).orElse(new VdpaDeviceBuilder().build()));
  }
  
  public VdpaNested<A> editOrNewVdpaLike(VdpaDevice item) {
    return this.withNewVdpaLike(Optional.ofNullable(this.buildVdpa()).orElse(item));
  }
  
  public VhostUserNested<A> editOrNewVhostUser() {
    return this.withNewVhostUserLike(Optional.ofNullable(this.buildVhostUser()).orElse(new VhostDeviceBuilder().build()));
  }
  
  public VhostUserNested<A> editOrNewVhostUserLike(VhostDevice item) {
    return this.withNewVhostUserLike(Optional.ofNullable(this.buildVhostUser()).orElse(item));
  }
  
  public PciNested<A> editPci() {
    return this.withNewPciLike(Optional.ofNullable(this.buildPci()).orElse(null));
  }
  
  public VdpaNested<A> editVdpa() {
    return this.withNewVdpaLike(Optional.ofNullable(this.buildVdpa()).orElse(null));
  }
  
  public VhostUserNested<A> editVhostUser() {
    return this.withNewVhostUserLike(Optional.ofNullable(this.buildVhostUser()).orElse(null));
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
    DeviceInfoFluent that = (DeviceInfoFluent) o;
    if (!(Objects.equals(memif, that.memif))) {
      return false;
    }
    if (!(Objects.equals(pci, that.pci))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(vdpa, that.vdpa))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
      return false;
    }
    if (!(Objects.equals(vhostUser, that.vhostUser))) {
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
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMemif() {
    return this.memif != null;
  }
  
  public boolean hasPci() {
    return this.pci != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasVdpa() {
    return this.vdpa != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public boolean hasVhostUser() {
    return this.vhostUser != null;
  }
  
  public int hashCode() {
    return Objects.hash(memif, pci, type, vdpa, version, vhostUser, additionalProperties);
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
    if (!(memif == null)) {
        sb.append("memif:");
        sb.append(memif);
        sb.append(",");
    }
    if (!(pci == null)) {
        sb.append("pci:");
        sb.append(pci);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(vdpa == null)) {
        sb.append("vdpa:");
        sb.append(vdpa);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
        sb.append(",");
    }
    if (!(vhostUser == null)) {
        sb.append("vhostUser:");
        sb.append(vhostUser);
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
  
  public A withMemif(MemifDevice memif) {
    this._visitables.remove("memif");
    if (memif != null) {
        this.memif = new MemifDeviceBuilder(memif);
        this._visitables.get("memif").add(this.memif);
    } else {
        this.memif = null;
        this._visitables.get("memif").remove(this.memif);
    }
    return (A) this;
  }
  
  public MemifNested<A> withNewMemif() {
    return new MemifNested(null);
  }
  
  public A withNewMemif(String mode,String path,String role) {
    return (A) this.withMemif(new MemifDevice(mode, path, role));
  }
  
  public MemifNested<A> withNewMemifLike(MemifDevice item) {
    return new MemifNested(item);
  }
  
  public PciNested<A> withNewPci() {
    return new PciNested(null);
  }
  
  public A withNewPci(String pciAddress,String pfPciAddress,String rdmaDevice,String representorDevice,String vhostNet) {
    return (A) this.withPci(new PciDevice(pciAddress, pfPciAddress, rdmaDevice, representorDevice, vhostNet));
  }
  
  public PciNested<A> withNewPciLike(PciDevice item) {
    return new PciNested(item);
  }
  
  public VdpaNested<A> withNewVdpa() {
    return new VdpaNested(null);
  }
  
  public VdpaNested<A> withNewVdpaLike(VdpaDevice item) {
    return new VdpaNested(item);
  }
  
  public VhostUserNested<A> withNewVhostUser() {
    return new VhostUserNested(null);
  }
  
  public A withNewVhostUser(String mode,String path) {
    return (A) this.withVhostUser(new VhostDevice(mode, path));
  }
  
  public VhostUserNested<A> withNewVhostUserLike(VhostDevice item) {
    return new VhostUserNested(item);
  }
  
  public A withPci(PciDevice pci) {
    this._visitables.remove("pci");
    if (pci != null) {
        this.pci = new PciDeviceBuilder(pci);
        this._visitables.get("pci").add(this.pci);
    } else {
        this.pci = null;
        this._visitables.get("pci").remove(this.pci);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withVdpa(VdpaDevice vdpa) {
    this._visitables.remove("vdpa");
    if (vdpa != null) {
        this.vdpa = new VdpaDeviceBuilder(vdpa);
        this._visitables.get("vdpa").add(this.vdpa);
    } else {
        this.vdpa = null;
        this._visitables.get("vdpa").remove(this.vdpa);
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
  public A withVhostUser(VhostDevice vhostUser) {
    this._visitables.remove("vhostUser");
    if (vhostUser != null) {
        this.vhostUser = new VhostDeviceBuilder(vhostUser);
        this._visitables.get("vhostUser").add(this.vhostUser);
    } else {
        this.vhostUser = null;
        this._visitables.get("vhostUser").remove(this.vhostUser);
    }
    return (A) this;
  }
  public class MemifNested<N> extends MemifDeviceFluent<MemifNested<N>> implements Nested<N>{
  
    MemifDeviceBuilder builder;
  
    MemifNested(MemifDevice item) {
      this.builder = new MemifDeviceBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceInfoFluent.this.withMemif(builder.build());
    }
    
    public N endMemif() {
      return and();
    }
    
  }
  public class PciNested<N> extends PciDeviceFluent<PciNested<N>> implements Nested<N>{
  
    PciDeviceBuilder builder;
  
    PciNested(PciDevice item) {
      this.builder = new PciDeviceBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceInfoFluent.this.withPci(builder.build());
    }
    
    public N endPci() {
      return and();
    }
    
  }
  public class VdpaNested<N> extends VdpaDeviceFluent<VdpaNested<N>> implements Nested<N>{
  
    VdpaDeviceBuilder builder;
  
    VdpaNested(VdpaDevice item) {
      this.builder = new VdpaDeviceBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceInfoFluent.this.withVdpa(builder.build());
    }
    
    public N endVdpa() {
      return and();
    }
    
  }
  public class VhostUserNested<N> extends VhostDeviceFluent<VhostUserNested<N>> implements Nested<N>{
  
    VhostDeviceBuilder builder;
  
    VhostUserNested(VhostDevice item) {
      this.builder = new VhostDeviceBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceInfoFluent.this.withVhostUser(builder.build());
    }
    
    public N endVhostUser() {
      return and();
    }
    
  }
}