package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Long;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class VSphereCSIDriverConfigSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.VSphereCSIDriverConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long globalMaxSnapshotsPerBlockVolume;
  private Long granularMaxSnapshotsPerBlockVolumeInVSAN;
  private Long granularMaxSnapshotsPerBlockVolumeInVVOL;
  private Integer maxAllowedBlockVolumesPerNode;
  private List<String> topologyCategories = new ArrayList<String>();

  public VSphereCSIDriverConfigSpecFluent() {
  }
  
  public VSphereCSIDriverConfigSpecFluent(VSphereCSIDriverConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTopologyCategories(Collection<String> items) {
    if (this.topologyCategories == null) {
      this.topologyCategories = new ArrayList();
    }
    for (String item : items) {
      this.topologyCategories.add(item);
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
  
  public A addToTopologyCategories(String... items) {
    if (this.topologyCategories == null) {
      this.topologyCategories = new ArrayList();
    }
    for (String item : items) {
      this.topologyCategories.add(item);
    }
    return (A) this;
  }
  
  public A addToTopologyCategories(int index,String item) {
    if (this.topologyCategories == null) {
      this.topologyCategories = new ArrayList();
    }
    this.topologyCategories.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(VSphereCSIDriverConfigSpec instance) {
    instance = instance != null ? instance : new VSphereCSIDriverConfigSpec();
    if (instance != null) {
        this.withGlobalMaxSnapshotsPerBlockVolume(instance.getGlobalMaxSnapshotsPerBlockVolume());
        this.withGranularMaxSnapshotsPerBlockVolumeInVSAN(instance.getGranularMaxSnapshotsPerBlockVolumeInVSAN());
        this.withGranularMaxSnapshotsPerBlockVolumeInVVOL(instance.getGranularMaxSnapshotsPerBlockVolumeInVVOL());
        this.withMaxAllowedBlockVolumesPerNode(instance.getMaxAllowedBlockVolumesPerNode());
        this.withTopologyCategories(instance.getTopologyCategories());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    VSphereCSIDriverConfigSpecFluent that = (VSphereCSIDriverConfigSpecFluent) o;
    if (!(Objects.equals(globalMaxSnapshotsPerBlockVolume, that.globalMaxSnapshotsPerBlockVolume))) {
      return false;
    }
    if (!(Objects.equals(granularMaxSnapshotsPerBlockVolumeInVSAN, that.granularMaxSnapshotsPerBlockVolumeInVSAN))) {
      return false;
    }
    if (!(Objects.equals(granularMaxSnapshotsPerBlockVolumeInVVOL, that.granularMaxSnapshotsPerBlockVolumeInVVOL))) {
      return false;
    }
    if (!(Objects.equals(maxAllowedBlockVolumesPerNode, that.maxAllowedBlockVolumesPerNode))) {
      return false;
    }
    if (!(Objects.equals(topologyCategories, that.topologyCategories))) {
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
  
  public String getFirstTopologyCategory() {
    return this.topologyCategories.get(0);
  }
  
  public Long getGlobalMaxSnapshotsPerBlockVolume() {
    return this.globalMaxSnapshotsPerBlockVolume;
  }
  
  public Long getGranularMaxSnapshotsPerBlockVolumeInVSAN() {
    return this.granularMaxSnapshotsPerBlockVolumeInVSAN;
  }
  
  public Long getGranularMaxSnapshotsPerBlockVolumeInVVOL() {
    return this.granularMaxSnapshotsPerBlockVolumeInVVOL;
  }
  
  public String getLastTopologyCategory() {
    return this.topologyCategories.get(topologyCategories.size() - 1);
  }
  
  public String getMatchingTopologyCategory(Predicate<String> predicate) {
      for (String item : topologyCategories) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMaxAllowedBlockVolumesPerNode() {
    return this.maxAllowedBlockVolumesPerNode;
  }
  
  public List<String> getTopologyCategories() {
    return this.topologyCategories;
  }
  
  public String getTopologyCategory(int index) {
    return this.topologyCategories.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGlobalMaxSnapshotsPerBlockVolume() {
    return this.globalMaxSnapshotsPerBlockVolume != null;
  }
  
  public boolean hasGranularMaxSnapshotsPerBlockVolumeInVSAN() {
    return this.granularMaxSnapshotsPerBlockVolumeInVSAN != null;
  }
  
  public boolean hasGranularMaxSnapshotsPerBlockVolumeInVVOL() {
    return this.granularMaxSnapshotsPerBlockVolumeInVVOL != null;
  }
  
  public boolean hasMatchingTopologyCategory(Predicate<String> predicate) {
      for (String item : topologyCategories) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxAllowedBlockVolumesPerNode() {
    return this.maxAllowedBlockVolumesPerNode != null;
  }
  
  public boolean hasTopologyCategories() {
    return this.topologyCategories != null && !(this.topologyCategories.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(globalMaxSnapshotsPerBlockVolume, granularMaxSnapshotsPerBlockVolumeInVSAN, granularMaxSnapshotsPerBlockVolumeInVVOL, maxAllowedBlockVolumesPerNode, topologyCategories, additionalProperties);
  }
  
  public A removeAllFromTopologyCategories(Collection<String> items) {
    if (this.topologyCategories == null) {
      return (A) this;
    }
    for (String item : items) {
      this.topologyCategories.remove(item);
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
  
  public A removeFromTopologyCategories(String... items) {
    if (this.topologyCategories == null) {
      return (A) this;
    }
    for (String item : items) {
      this.topologyCategories.remove(item);
    }
    return (A) this;
  }
  
  public A setToTopologyCategories(int index,String item) {
    if (this.topologyCategories == null) {
      this.topologyCategories = new ArrayList();
    }
    this.topologyCategories.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(globalMaxSnapshotsPerBlockVolume == null)) {
        sb.append("globalMaxSnapshotsPerBlockVolume:");
        sb.append(globalMaxSnapshotsPerBlockVolume);
        sb.append(",");
    }
    if (!(granularMaxSnapshotsPerBlockVolumeInVSAN == null)) {
        sb.append("granularMaxSnapshotsPerBlockVolumeInVSAN:");
        sb.append(granularMaxSnapshotsPerBlockVolumeInVSAN);
        sb.append(",");
    }
    if (!(granularMaxSnapshotsPerBlockVolumeInVVOL == null)) {
        sb.append("granularMaxSnapshotsPerBlockVolumeInVVOL:");
        sb.append(granularMaxSnapshotsPerBlockVolumeInVVOL);
        sb.append(",");
    }
    if (!(maxAllowedBlockVolumesPerNode == null)) {
        sb.append("maxAllowedBlockVolumesPerNode:");
        sb.append(maxAllowedBlockVolumesPerNode);
        sb.append(",");
    }
    if (!(topologyCategories == null) && !(topologyCategories.isEmpty())) {
        sb.append("topologyCategories:");
        sb.append(topologyCategories);
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
  
  public A withGlobalMaxSnapshotsPerBlockVolume(Long globalMaxSnapshotsPerBlockVolume) {
    this.globalMaxSnapshotsPerBlockVolume = globalMaxSnapshotsPerBlockVolume;
    return (A) this;
  }
  
  public A withGranularMaxSnapshotsPerBlockVolumeInVSAN(Long granularMaxSnapshotsPerBlockVolumeInVSAN) {
    this.granularMaxSnapshotsPerBlockVolumeInVSAN = granularMaxSnapshotsPerBlockVolumeInVSAN;
    return (A) this;
  }
  
  public A withGranularMaxSnapshotsPerBlockVolumeInVVOL(Long granularMaxSnapshotsPerBlockVolumeInVVOL) {
    this.granularMaxSnapshotsPerBlockVolumeInVVOL = granularMaxSnapshotsPerBlockVolumeInVVOL;
    return (A) this;
  }
  
  public A withMaxAllowedBlockVolumesPerNode(Integer maxAllowedBlockVolumesPerNode) {
    this.maxAllowedBlockVolumesPerNode = maxAllowedBlockVolumesPerNode;
    return (A) this;
  }
  
  public A withTopologyCategories(List<String> topologyCategories) {
    if (topologyCategories != null) {
        this.topologyCategories = new ArrayList();
        for (String item : topologyCategories) {
          this.addToTopologyCategories(item);
        }
    } else {
      this.topologyCategories = null;
    }
    return (A) this;
  }
  
  public A withTopologyCategories(String... topologyCategories) {
    if (this.topologyCategories != null) {
        this.topologyCategories.clear();
        _visitables.remove("topologyCategories");
    }
    if (topologyCategories != null) {
      for (String item : topologyCategories) {
        this.addToTopologyCategories(item);
      }
    }
    return (A) this;
  }
  
}