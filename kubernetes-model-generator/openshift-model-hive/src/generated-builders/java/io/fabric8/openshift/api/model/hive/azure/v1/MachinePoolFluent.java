package io.fabric8.openshift.api.model.hive.azure.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.hive.azure.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String computeSubnet;
  private String networkResourceGroupName;
  private OSDiskBuilder osDisk;
  private OSImageBuilder osImage;
  private String type;
  private String virtualNetwork;
  private String vmNetworkingType;
  private List<String> zones = new ArrayList<String>();

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
  }

  public A addAllToZones(Collection<String> items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
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
  
  public A addToZones(String... items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
  }
  
  public A addToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.add(index, item);
    return (A) this;
  }
  
  public OSDisk buildOsDisk() {
    return this.osDisk != null ? this.osDisk.build() : null;
  }
  
  public OSImage buildOsImage() {
    return this.osImage != null ? this.osImage.build() : null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withComputeSubnet(instance.getComputeSubnet());
        this.withNetworkResourceGroupName(instance.getNetworkResourceGroupName());
        this.withOsDisk(instance.getOsDisk());
        this.withOsImage(instance.getOsImage());
        this.withType(instance.getType());
        this.withVirtualNetwork(instance.getVirtualNetwork());
        this.withVmNetworkingType(instance.getVmNetworkingType());
        this.withZones(instance.getZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OsDiskNested<A> editOrNewOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(new OSDiskBuilder().build()));
  }
  
  public OsDiskNested<A> editOrNewOsDiskLike(OSDisk item) {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(item));
  }
  
  public OsImageNested<A> editOrNewOsImage() {
    return this.withNewOsImageLike(Optional.ofNullable(this.buildOsImage()).orElse(new OSImageBuilder().build()));
  }
  
  public OsImageNested<A> editOrNewOsImageLike(OSImage item) {
    return this.withNewOsImageLike(Optional.ofNullable(this.buildOsImage()).orElse(item));
  }
  
  public OsDiskNested<A> editOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(null));
  }
  
  public OsImageNested<A> editOsImage() {
    return this.withNewOsImageLike(Optional.ofNullable(this.buildOsImage()).orElse(null));
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
    MachinePoolFluent that = (MachinePoolFluent) o;
    if (!(Objects.equals(computeSubnet, that.computeSubnet))) {
      return false;
    }
    if (!(Objects.equals(networkResourceGroupName, that.networkResourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(osDisk, that.osDisk))) {
      return false;
    }
    if (!(Objects.equals(osImage, that.osImage))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(virtualNetwork, that.virtualNetwork))) {
      return false;
    }
    if (!(Objects.equals(vmNetworkingType, that.vmNetworkingType))) {
      return false;
    }
    if (!(Objects.equals(zones, that.zones))) {
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
  
  public String getComputeSubnet() {
    return this.computeSubnet;
  }
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public String getMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetworkResourceGroupName() {
    return this.networkResourceGroupName;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getVirtualNetwork() {
    return this.virtualNetwork;
  }
  
  public String getVmNetworkingType() {
    return this.vmNetworkingType;
  }
  
  public String getZone(int index) {
    return this.zones.get(index);
  }
  
  public List<String> getZones() {
    return this.zones;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComputeSubnet() {
    return this.computeSubnet != null;
  }
  
  public boolean hasMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkResourceGroupName() {
    return this.networkResourceGroupName != null;
  }
  
  public boolean hasOsDisk() {
    return this.osDisk != null;
  }
  
  public boolean hasOsImage() {
    return this.osImage != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasVirtualNetwork() {
    return this.virtualNetwork != null;
  }
  
  public boolean hasVmNetworkingType() {
    return this.vmNetworkingType != null;
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(computeSubnet, networkResourceGroupName, osDisk, osImage, type, virtualNetwork, vmNetworkingType, zones, additionalProperties);
  }
  
  public A removeAllFromZones(Collection<String> items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
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
  
  public A removeFromZones(String... items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
    }
    return (A) this;
  }
  
  public A setToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(computeSubnet == null)) {
        sb.append("computeSubnet:");
        sb.append(computeSubnet);
        sb.append(",");
    }
    if (!(networkResourceGroupName == null)) {
        sb.append("networkResourceGroupName:");
        sb.append(networkResourceGroupName);
        sb.append(",");
    }
    if (!(osDisk == null)) {
        sb.append("osDisk:");
        sb.append(osDisk);
        sb.append(",");
    }
    if (!(osImage == null)) {
        sb.append("osImage:");
        sb.append(osImage);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(virtualNetwork == null)) {
        sb.append("virtualNetwork:");
        sb.append(virtualNetwork);
        sb.append(",");
    }
    if (!(vmNetworkingType == null)) {
        sb.append("vmNetworkingType:");
        sb.append(vmNetworkingType);
        sb.append(",");
    }
    if (!(zones == null) && !(zones.isEmpty())) {
        sb.append("zones:");
        sb.append(zones);
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
  
  public A withComputeSubnet(String computeSubnet) {
    this.computeSubnet = computeSubnet;
    return (A) this;
  }
  
  public A withNetworkResourceGroupName(String networkResourceGroupName) {
    this.networkResourceGroupName = networkResourceGroupName;
    return (A) this;
  }
  
  public OsDiskNested<A> withNewOsDisk() {
    return new OsDiskNested(null);
  }
  
  public OsDiskNested<A> withNewOsDiskLike(OSDisk item) {
    return new OsDiskNested(item);
  }
  
  public OsImageNested<A> withNewOsImage() {
    return new OsImageNested(null);
  }
  
  public A withNewOsImage(String offer,String publisher,String sku,String version) {
    return (A) this.withOsImage(new OSImage(offer, publisher, sku, version));
  }
  
  public OsImageNested<A> withNewOsImageLike(OSImage item) {
    return new OsImageNested(item);
  }
  
  public A withOsDisk(OSDisk osDisk) {
    this._visitables.remove("osDisk");
    if (osDisk != null) {
        this.osDisk = new OSDiskBuilder(osDisk);
        this._visitables.get("osDisk").add(this.osDisk);
    } else {
        this.osDisk = null;
        this._visitables.get("osDisk").remove(this.osDisk);
    }
    return (A) this;
  }
  
  public A withOsImage(OSImage osImage) {
    this._visitables.remove("osImage");
    if (osImage != null) {
        this.osImage = new OSImageBuilder(osImage);
        this._visitables.get("osImage").add(this.osImage);
    } else {
        this.osImage = null;
        this._visitables.get("osImage").remove(this.osImage);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withVirtualNetwork(String virtualNetwork) {
    this.virtualNetwork = virtualNetwork;
    return (A) this;
  }
  
  public A withVmNetworkingType(String vmNetworkingType) {
    this.vmNetworkingType = vmNetworkingType;
    return (A) this;
  }
  
  public A withZones(List<String> zones) {
    if (zones != null) {
        this.zones = new ArrayList();
        for (String item : zones) {
          this.addToZones(item);
        }
    } else {
      this.zones = null;
    }
    return (A) this;
  }
  
  public A withZones(String... zones) {
    if (this.zones != null) {
        this.zones.clear();
        _visitables.remove("zones");
    }
    if (zones != null) {
      for (String item : zones) {
        this.addToZones(item);
      }
    }
    return (A) this;
  }
  public class OsDiskNested<N> extends OSDiskFluent<OsDiskNested<N>> implements Nested<N>{
  
    OSDiskBuilder builder;
  
    OsDiskNested(OSDisk item) {
      this.builder = new OSDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withOsDisk(builder.build());
    }
    
    public N endOsDisk() {
      return and();
    }
    
  }
  public class OsImageNested<N> extends OSImageFluent<OsImageNested<N>> implements Nested<N>{
  
    OSImageBuilder builder;
  
    OsImageNested(OSImage item) {
      this.builder = new OSImageBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withOsImage(builder.build());
    }
    
    public N endOsImage() {
      return and();
    }
    
  }
}