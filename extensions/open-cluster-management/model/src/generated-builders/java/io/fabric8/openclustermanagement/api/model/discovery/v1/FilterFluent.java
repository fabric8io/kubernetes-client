package io.fabric8.openclustermanagement.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class FilterFluent<A extends io.fabric8.openclustermanagement.api.model.discovery.v1.FilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> clusterTypes = new ArrayList<String>();
  private List<String> infrastructureProviders = new ArrayList<String>();
  private Integer lastActive;
  private List<String> openShiftVersions = new ArrayList<String>();
  private List<String> regions = new ArrayList<String>();

  public FilterFluent() {
  }
  
  public FilterFluent(Filter instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterTypes(Collection<String> items) {
    if (this.clusterTypes == null) {
      this.clusterTypes = new ArrayList();
    }
    for (String item : items) {
      this.clusterTypes.add(item);
    }
    return (A) this;
  }
  
  public A addAllToInfrastructureProviders(Collection<String> items) {
    if (this.infrastructureProviders == null) {
      this.infrastructureProviders = new ArrayList();
    }
    for (String item : items) {
      this.infrastructureProviders.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOpenShiftVersions(Collection<String> items) {
    if (this.openShiftVersions == null) {
      this.openShiftVersions = new ArrayList();
    }
    for (String item : items) {
      this.openShiftVersions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRegions(Collection<String> items) {
    if (this.regions == null) {
      this.regions = new ArrayList();
    }
    for (String item : items) {
      this.regions.add(item);
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
  
  public A addToClusterTypes(String... items) {
    if (this.clusterTypes == null) {
      this.clusterTypes = new ArrayList();
    }
    for (String item : items) {
      this.clusterTypes.add(item);
    }
    return (A) this;
  }
  
  public A addToClusterTypes(int index,String item) {
    if (this.clusterTypes == null) {
      this.clusterTypes = new ArrayList();
    }
    this.clusterTypes.add(index, item);
    return (A) this;
  }
  
  public A addToInfrastructureProviders(String... items) {
    if (this.infrastructureProviders == null) {
      this.infrastructureProviders = new ArrayList();
    }
    for (String item : items) {
      this.infrastructureProviders.add(item);
    }
    return (A) this;
  }
  
  public A addToInfrastructureProviders(int index,String item) {
    if (this.infrastructureProviders == null) {
      this.infrastructureProviders = new ArrayList();
    }
    this.infrastructureProviders.add(index, item);
    return (A) this;
  }
  
  public A addToOpenShiftVersions(String... items) {
    if (this.openShiftVersions == null) {
      this.openShiftVersions = new ArrayList();
    }
    for (String item : items) {
      this.openShiftVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToOpenShiftVersions(int index,String item) {
    if (this.openShiftVersions == null) {
      this.openShiftVersions = new ArrayList();
    }
    this.openShiftVersions.add(index, item);
    return (A) this;
  }
  
  public A addToRegions(String... items) {
    if (this.regions == null) {
      this.regions = new ArrayList();
    }
    for (String item : items) {
      this.regions.add(item);
    }
    return (A) this;
  }
  
  public A addToRegions(int index,String item) {
    if (this.regions == null) {
      this.regions = new ArrayList();
    }
    this.regions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Filter instance) {
    instance = instance != null ? instance : new Filter();
    if (instance != null) {
        this.withClusterTypes(instance.getClusterTypes());
        this.withInfrastructureProviders(instance.getInfrastructureProviders());
        this.withLastActive(instance.getLastActive());
        this.withOpenShiftVersions(instance.getOpenShiftVersions());
        this.withRegions(instance.getRegions());
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
    FilterFluent that = (FilterFluent) o;
    if (!(Objects.equals(clusterTypes, that.clusterTypes))) {
      return false;
    }
    if (!(Objects.equals(infrastructureProviders, that.infrastructureProviders))) {
      return false;
    }
    if (!(Objects.equals(lastActive, that.lastActive))) {
      return false;
    }
    if (!(Objects.equals(openShiftVersions, that.openShiftVersions))) {
      return false;
    }
    if (!(Objects.equals(regions, that.regions))) {
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
  
  public String getClusterType(int index) {
    return this.clusterTypes.get(index);
  }
  
  public List<String> getClusterTypes() {
    return this.clusterTypes;
  }
  
  public String getFirstClusterType() {
    return this.clusterTypes.get(0);
  }
  
  public String getFirstInfrastructureProvider() {
    return this.infrastructureProviders.get(0);
  }
  
  public String getFirstOpenShiftVersion() {
    return this.openShiftVersions.get(0);
  }
  
  public String getFirstRegion() {
    return this.regions.get(0);
  }
  
  public String getInfrastructureProvider(int index) {
    return this.infrastructureProviders.get(index);
  }
  
  public List<String> getInfrastructureProviders() {
    return this.infrastructureProviders;
  }
  
  public Integer getLastActive() {
    return this.lastActive;
  }
  
  public String getLastClusterType() {
    return this.clusterTypes.get(clusterTypes.size() - 1);
  }
  
  public String getLastInfrastructureProvider() {
    return this.infrastructureProviders.get(infrastructureProviders.size() - 1);
  }
  
  public String getLastOpenShiftVersion() {
    return this.openShiftVersions.get(openShiftVersions.size() - 1);
  }
  
  public String getLastRegion() {
    return this.regions.get(regions.size() - 1);
  }
  
  public String getMatchingClusterType(Predicate<String> predicate) {
      for (String item : clusterTypes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingInfrastructureProvider(Predicate<String> predicate) {
      for (String item : infrastructureProviders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingOpenShiftVersion(Predicate<String> predicate) {
      for (String item : openShiftVersions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRegion(Predicate<String> predicate) {
      for (String item : regions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOpenShiftVersion(int index) {
    return this.openShiftVersions.get(index);
  }
  
  public List<String> getOpenShiftVersions() {
    return this.openShiftVersions;
  }
  
  public String getRegion(int index) {
    return this.regions.get(index);
  }
  
  public List<String> getRegions() {
    return this.regions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterTypes() {
    return this.clusterTypes != null && !(this.clusterTypes.isEmpty());
  }
  
  public boolean hasInfrastructureProviders() {
    return this.infrastructureProviders != null && !(this.infrastructureProviders.isEmpty());
  }
  
  public boolean hasLastActive() {
    return this.lastActive != null;
  }
  
  public boolean hasMatchingClusterType(Predicate<String> predicate) {
      for (String item : clusterTypes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInfrastructureProvider(Predicate<String> predicate) {
      for (String item : infrastructureProviders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOpenShiftVersion(Predicate<String> predicate) {
      for (String item : openShiftVersions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRegion(Predicate<String> predicate) {
      for (String item : regions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOpenShiftVersions() {
    return this.openShiftVersions != null && !(this.openShiftVersions.isEmpty());
  }
  
  public boolean hasRegions() {
    return this.regions != null && !(this.regions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(clusterTypes, infrastructureProviders, lastActive, openShiftVersions, regions, additionalProperties);
  }
  
  public A removeAllFromClusterTypes(Collection<String> items) {
    if (this.clusterTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusterTypes.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromInfrastructureProviders(Collection<String> items) {
    if (this.infrastructureProviders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.infrastructureProviders.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOpenShiftVersions(Collection<String> items) {
    if (this.openShiftVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.openShiftVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRegions(Collection<String> items) {
    if (this.regions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.regions.remove(item);
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
  
  public A removeFromClusterTypes(String... items) {
    if (this.clusterTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusterTypes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromInfrastructureProviders(String... items) {
    if (this.infrastructureProviders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.infrastructureProviders.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOpenShiftVersions(String... items) {
    if (this.openShiftVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.openShiftVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRegions(String... items) {
    if (this.regions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.regions.remove(item);
    }
    return (A) this;
  }
  
  public A setToClusterTypes(int index,String item) {
    if (this.clusterTypes == null) {
      this.clusterTypes = new ArrayList();
    }
    this.clusterTypes.set(index, item);
    return (A) this;
  }
  
  public A setToInfrastructureProviders(int index,String item) {
    if (this.infrastructureProviders == null) {
      this.infrastructureProviders = new ArrayList();
    }
    this.infrastructureProviders.set(index, item);
    return (A) this;
  }
  
  public A setToOpenShiftVersions(int index,String item) {
    if (this.openShiftVersions == null) {
      this.openShiftVersions = new ArrayList();
    }
    this.openShiftVersions.set(index, item);
    return (A) this;
  }
  
  public A setToRegions(int index,String item) {
    if (this.regions == null) {
      this.regions = new ArrayList();
    }
    this.regions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterTypes == null) && !(clusterTypes.isEmpty())) {
        sb.append("clusterTypes:");
        sb.append(clusterTypes);
        sb.append(",");
    }
    if (!(infrastructureProviders == null) && !(infrastructureProviders.isEmpty())) {
        sb.append("infrastructureProviders:");
        sb.append(infrastructureProviders);
        sb.append(",");
    }
    if (!(lastActive == null)) {
        sb.append("lastActive:");
        sb.append(lastActive);
        sb.append(",");
    }
    if (!(openShiftVersions == null) && !(openShiftVersions.isEmpty())) {
        sb.append("openShiftVersions:");
        sb.append(openShiftVersions);
        sb.append(",");
    }
    if (!(regions == null) && !(regions.isEmpty())) {
        sb.append("regions:");
        sb.append(regions);
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
  
  public A withClusterTypes(List<String> clusterTypes) {
    if (clusterTypes != null) {
        this.clusterTypes = new ArrayList();
        for (String item : clusterTypes) {
          this.addToClusterTypes(item);
        }
    } else {
      this.clusterTypes = null;
    }
    return (A) this;
  }
  
  public A withClusterTypes(String... clusterTypes) {
    if (this.clusterTypes != null) {
        this.clusterTypes.clear();
        _visitables.remove("clusterTypes");
    }
    if (clusterTypes != null) {
      for (String item : clusterTypes) {
        this.addToClusterTypes(item);
      }
    }
    return (A) this;
  }
  
  public A withInfrastructureProviders(List<String> infrastructureProviders) {
    if (infrastructureProviders != null) {
        this.infrastructureProviders = new ArrayList();
        for (String item : infrastructureProviders) {
          this.addToInfrastructureProviders(item);
        }
    } else {
      this.infrastructureProviders = null;
    }
    return (A) this;
  }
  
  public A withInfrastructureProviders(String... infrastructureProviders) {
    if (this.infrastructureProviders != null) {
        this.infrastructureProviders.clear();
        _visitables.remove("infrastructureProviders");
    }
    if (infrastructureProviders != null) {
      for (String item : infrastructureProviders) {
        this.addToInfrastructureProviders(item);
      }
    }
    return (A) this;
  }
  
  public A withLastActive(Integer lastActive) {
    this.lastActive = lastActive;
    return (A) this;
  }
  
  public A withOpenShiftVersions(List<String> openShiftVersions) {
    if (openShiftVersions != null) {
        this.openShiftVersions = new ArrayList();
        for (String item : openShiftVersions) {
          this.addToOpenShiftVersions(item);
        }
    } else {
      this.openShiftVersions = null;
    }
    return (A) this;
  }
  
  public A withOpenShiftVersions(String... openShiftVersions) {
    if (this.openShiftVersions != null) {
        this.openShiftVersions.clear();
        _visitables.remove("openShiftVersions");
    }
    if (openShiftVersions != null) {
      for (String item : openShiftVersions) {
        this.addToOpenShiftVersions(item);
      }
    }
    return (A) this;
  }
  
  public A withRegions(List<String> regions) {
    if (regions != null) {
        this.regions = new ArrayList();
        for (String item : regions) {
          this.addToRegions(item);
        }
    } else {
      this.regions = null;
    }
    return (A) this;
  }
  
  public A withRegions(String... regions) {
    if (this.regions != null) {
        this.regions.clear();
        _visitables.remove("regions");
    }
    if (regions != null) {
      for (String item : regions) {
        this.addToRegions(item);
      }
    }
    return (A) this;
  }
  
}