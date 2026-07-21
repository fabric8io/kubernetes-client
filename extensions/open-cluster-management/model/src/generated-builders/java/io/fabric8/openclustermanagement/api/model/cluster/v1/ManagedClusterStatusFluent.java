package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class ManagedClusterStatusFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Quantity> allocatable;
  private Map<String,Quantity> capacity;
  private ArrayList<ManagedClusterClaimBuilder> clusterClaims = new ArrayList<ManagedClusterClaimBuilder>();
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<ClusterSetManagedNamespaceConfigBuilder> managedNamespaces = new ArrayList<ClusterSetManagedNamespaceConfigBuilder>();
  private ManagedClusterVersionBuilder version;

  public ManagedClusterStatusFluent() {
  }
  
  public ManagedClusterStatusFluent(ManagedClusterStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterClaims(Collection<ManagedClusterClaim> items) {
    if (this.clusterClaims == null) {
      this.clusterClaims = new ArrayList();
    }
    for (ManagedClusterClaim item : items) {
        ManagedClusterClaimBuilder builder = new ManagedClusterClaimBuilder(item);
        _visitables.get("clusterClaims").add(builder);
        this.clusterClaims.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToManagedNamespaces(Collection<ClusterSetManagedNamespaceConfig> items) {
    if (this.managedNamespaces == null) {
      this.managedNamespaces = new ArrayList();
    }
    for (ClusterSetManagedNamespaceConfig item : items) {
        ClusterSetManagedNamespaceConfigBuilder builder = new ClusterSetManagedNamespaceConfigBuilder(item);
        _visitables.get("managedNamespaces").add(builder);
        this.managedNamespaces.add(builder);
    }
    return (A) this;
  }
  
  public ClusterClaimsNested<A> addNewClusterClaim() {
    return new ClusterClaimsNested(-1, null);
  }
  
  public A addNewClusterClaim(String name,String value) {
    return (A) this.addToClusterClaims(new ManagedClusterClaim(name, value));
  }
  
  public ClusterClaimsNested<A> addNewClusterClaimLike(ManagedClusterClaim item) {
    return new ClusterClaimsNested(-1, item);
  }
  
  public ManagedNamespacesNested<A> addNewManagedNamespace() {
    return new ManagedNamespacesNested(-1, null);
  }
  
  public ManagedNamespacesNested<A> addNewManagedNamespaceLike(ClusterSetManagedNamespaceConfig item) {
    return new ManagedNamespacesNested(-1, item);
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
  
  public A addToAllocatable(Map<String,Quantity> map) {
    if (this.allocatable == null && map != null) {
      this.allocatable = new LinkedHashMap();
    }
    if (map != null) {
      this.allocatable.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAllocatable(String key,Quantity value) {
    if (this.allocatable == null && key != null && value != null) {
      this.allocatable = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.allocatable.put(key, value);
    }
    return (A) this;
  }
  
  public A addToCapacity(Map<String,Quantity> map) {
    if (this.capacity == null && map != null) {
      this.capacity = new LinkedHashMap();
    }
    if (map != null) {
      this.capacity.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCapacity(String key,Quantity value) {
    if (this.capacity == null && key != null && value != null) {
      this.capacity = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.capacity.put(key, value);
    }
    return (A) this;
  }
  
  public A addToClusterClaims(ManagedClusterClaim... items) {
    if (this.clusterClaims == null) {
      this.clusterClaims = new ArrayList();
    }
    for (ManagedClusterClaim item : items) {
        ManagedClusterClaimBuilder builder = new ManagedClusterClaimBuilder(item);
        _visitables.get("clusterClaims").add(builder);
        this.clusterClaims.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterClaims(int index,ManagedClusterClaim item) {
    if (this.clusterClaims == null) {
      this.clusterClaims = new ArrayList();
    }
    ManagedClusterClaimBuilder builder = new ManagedClusterClaimBuilder(item);
    if (index < 0 || index >= clusterClaims.size()) {
        _visitables.get("clusterClaims").add(builder);
        clusterClaims.add(builder);
    } else {
        _visitables.get("clusterClaims").add(builder);
        clusterClaims.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToManagedNamespaces(ClusterSetManagedNamespaceConfig... items) {
    if (this.managedNamespaces == null) {
      this.managedNamespaces = new ArrayList();
    }
    for (ClusterSetManagedNamespaceConfig item : items) {
        ClusterSetManagedNamespaceConfigBuilder builder = new ClusterSetManagedNamespaceConfigBuilder(item);
        _visitables.get("managedNamespaces").add(builder);
        this.managedNamespaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToManagedNamespaces(int index,ClusterSetManagedNamespaceConfig item) {
    if (this.managedNamespaces == null) {
      this.managedNamespaces = new ArrayList();
    }
    ClusterSetManagedNamespaceConfigBuilder builder = new ClusterSetManagedNamespaceConfigBuilder(item);
    if (index < 0 || index >= managedNamespaces.size()) {
        _visitables.get("managedNamespaces").add(builder);
        managedNamespaces.add(builder);
    } else {
        _visitables.get("managedNamespaces").add(builder);
        managedNamespaces.add(index, builder);
    }
    return (A) this;
  }
  
  public ManagedClusterClaim buildClusterClaim(int index) {
    return this.clusterClaims.get(index).build();
  }
  
  public List<ManagedClusterClaim> buildClusterClaims() {
    return this.clusterClaims != null ? build(clusterClaims) : null;
  }
  
  public ManagedClusterClaim buildFirstClusterClaim() {
    return this.clusterClaims.get(0).build();
  }
  
  public ClusterSetManagedNamespaceConfig buildFirstManagedNamespace() {
    return this.managedNamespaces.get(0).build();
  }
  
  public ManagedClusterClaim buildLastClusterClaim() {
    return this.clusterClaims.get(clusterClaims.size() - 1).build();
  }
  
  public ClusterSetManagedNamespaceConfig buildLastManagedNamespace() {
    return this.managedNamespaces.get(managedNamespaces.size() - 1).build();
  }
  
  public ClusterSetManagedNamespaceConfig buildManagedNamespace(int index) {
    return this.managedNamespaces.get(index).build();
  }
  
  public List<ClusterSetManagedNamespaceConfig> buildManagedNamespaces() {
    return this.managedNamespaces != null ? build(managedNamespaces) : null;
  }
  
  public ManagedClusterClaim buildMatchingClusterClaim(Predicate<ManagedClusterClaimBuilder> predicate) {
      for (ManagedClusterClaimBuilder item : clusterClaims) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterSetManagedNamespaceConfig buildMatchingManagedNamespace(Predicate<ClusterSetManagedNamespaceConfigBuilder> predicate) {
      for (ClusterSetManagedNamespaceConfigBuilder item : managedNamespaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ManagedClusterVersion buildVersion() {
    return this.version != null ? this.version.build() : null;
  }
  
  protected void copyInstance(ManagedClusterStatus instance) {
    instance = instance != null ? instance : new ManagedClusterStatus();
    if (instance != null) {
        this.withAllocatable(instance.getAllocatable());
        this.withCapacity(instance.getCapacity());
        this.withClusterClaims(instance.getClusterClaims());
        this.withConditions(instance.getConditions());
        this.withManagedNamespaces(instance.getManagedNamespaces());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterClaimsNested<A> editClusterClaim(int index) {
    if (clusterClaims.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterClaims"));
    }
    return this.setNewClusterClaimLike(index, this.buildClusterClaim(index));
  }
  
  public ClusterClaimsNested<A> editFirstClusterClaim() {
    if (clusterClaims.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterClaims"));
    }
    return this.setNewClusterClaimLike(0, this.buildClusterClaim(0));
  }
  
  public ManagedNamespacesNested<A> editFirstManagedNamespace() {
    if (managedNamespaces.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "managedNamespaces"));
    }
    return this.setNewManagedNamespaceLike(0, this.buildManagedNamespace(0));
  }
  
  public ClusterClaimsNested<A> editLastClusterClaim() {
    int index = clusterClaims.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterClaims"));
    }
    return this.setNewClusterClaimLike(index, this.buildClusterClaim(index));
  }
  
  public ManagedNamespacesNested<A> editLastManagedNamespace() {
    int index = managedNamespaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "managedNamespaces"));
    }
    return this.setNewManagedNamespaceLike(index, this.buildManagedNamespace(index));
  }
  
  public ManagedNamespacesNested<A> editManagedNamespace(int index) {
    if (managedNamespaces.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "managedNamespaces"));
    }
    return this.setNewManagedNamespaceLike(index, this.buildManagedNamespace(index));
  }
  
  public ClusterClaimsNested<A> editMatchingClusterClaim(Predicate<ManagedClusterClaimBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterClaims.size();i++) {
      if (predicate.test(clusterClaims.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterClaims"));
    }
    return this.setNewClusterClaimLike(index, this.buildClusterClaim(index));
  }
  
  public ManagedNamespacesNested<A> editMatchingManagedNamespace(Predicate<ClusterSetManagedNamespaceConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < managedNamespaces.size();i++) {
      if (predicate.test(managedNamespaces.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "managedNamespaces"));
    }
    return this.setNewManagedNamespaceLike(index, this.buildManagedNamespace(index));
  }
  
  public VersionNested<A> editOrNewVersion() {
    return this.withNewVersionLike(Optional.ofNullable(this.buildVersion()).orElse(new ManagedClusterVersionBuilder().build()));
  }
  
  public VersionNested<A> editOrNewVersionLike(ManagedClusterVersion item) {
    return this.withNewVersionLike(Optional.ofNullable(this.buildVersion()).orElse(item));
  }
  
  public VersionNested<A> editVersion() {
    return this.withNewVersionLike(Optional.ofNullable(this.buildVersion()).orElse(null));
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
    ManagedClusterStatusFluent that = (ManagedClusterStatusFluent) o;
    if (!(Objects.equals(allocatable, that.allocatable))) {
      return false;
    }
    if (!(Objects.equals(capacity, that.capacity))) {
      return false;
    }
    if (!(Objects.equals(clusterClaims, that.clusterClaims))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(managedNamespaces, that.managedNamespaces))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public Map<String,Quantity> getAllocatable() {
    return this.allocatable;
  }
  
  public Map<String,Quantity> getCapacity() {
    return this.capacity;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocatable() {
    return this.allocatable != null;
  }
  
  public boolean hasCapacity() {
    return this.capacity != null;
  }
  
  public boolean hasClusterClaims() {
    return this.clusterClaims != null && !(this.clusterClaims.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasManagedNamespaces() {
    return this.managedNamespaces != null && !(this.managedNamespaces.isEmpty());
  }
  
  public boolean hasMatchingClusterClaim(Predicate<ManagedClusterClaimBuilder> predicate) {
      for (ManagedClusterClaimBuilder item : clusterClaims) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingManagedNamespace(Predicate<ClusterSetManagedNamespaceConfigBuilder> predicate) {
      for (ClusterSetManagedNamespaceConfigBuilder item : managedNamespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocatable, capacity, clusterClaims, conditions, managedNamespaces, version, additionalProperties);
  }
  
  public A removeAllFromClusterClaims(Collection<ManagedClusterClaim> items) {
    if (this.clusterClaims == null) {
      return (A) this;
    }
    for (ManagedClusterClaim item : items) {
        ManagedClusterClaimBuilder builder = new ManagedClusterClaimBuilder(item);
        _visitables.get("clusterClaims").remove(builder);
        this.clusterClaims.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromManagedNamespaces(Collection<ClusterSetManagedNamespaceConfig> items) {
    if (this.managedNamespaces == null) {
      return (A) this;
    }
    for (ClusterSetManagedNamespaceConfig item : items) {
        ClusterSetManagedNamespaceConfigBuilder builder = new ClusterSetManagedNamespaceConfigBuilder(item);
        _visitables.get("managedNamespaces").remove(builder);
        this.managedNamespaces.remove(builder);
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
  
  public A removeFromAllocatable(String key) {
    if (this.allocatable == null) {
      return (A) this;
    }
    if (key != null && this.allocatable != null) {
      this.allocatable.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAllocatable(Map<String,Quantity> map) {
    if (this.allocatable == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.allocatable != null) {
          this.allocatable.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromCapacity(String key) {
    if (this.capacity == null) {
      return (A) this;
    }
    if (key != null && this.capacity != null) {
      this.capacity.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCapacity(Map<String,Quantity> map) {
    if (this.capacity == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.capacity != null) {
          this.capacity.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromClusterClaims(ManagedClusterClaim... items) {
    if (this.clusterClaims == null) {
      return (A) this;
    }
    for (ManagedClusterClaim item : items) {
        ManagedClusterClaimBuilder builder = new ManagedClusterClaimBuilder(item);
        _visitables.get("clusterClaims").remove(builder);
        this.clusterClaims.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromManagedNamespaces(ClusterSetManagedNamespaceConfig... items) {
    if (this.managedNamespaces == null) {
      return (A) this;
    }
    for (ClusterSetManagedNamespaceConfig item : items) {
        ClusterSetManagedNamespaceConfigBuilder builder = new ClusterSetManagedNamespaceConfigBuilder(item);
        _visitables.get("managedNamespaces").remove(builder);
        this.managedNamespaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterClaims(Predicate<ManagedClusterClaimBuilder> predicate) {
    if (clusterClaims == null) {
      return (A) this;
    }
    Iterator<ManagedClusterClaimBuilder> each = clusterClaims.iterator();
    List visitables = _visitables.get("clusterClaims");
    while (each.hasNext()) {
        ManagedClusterClaimBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromManagedNamespaces(Predicate<ClusterSetManagedNamespaceConfigBuilder> predicate) {
    if (managedNamespaces == null) {
      return (A) this;
    }
    Iterator<ClusterSetManagedNamespaceConfigBuilder> each = managedNamespaces.iterator();
    List visitables = _visitables.get("managedNamespaces");
    while (each.hasNext()) {
        ClusterSetManagedNamespaceConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterClaimsNested<A> setNewClusterClaimLike(int index,ManagedClusterClaim item) {
    return new ClusterClaimsNested(index, item);
  }
  
  public ManagedNamespacesNested<A> setNewManagedNamespaceLike(int index,ClusterSetManagedNamespaceConfig item) {
    return new ManagedNamespacesNested(index, item);
  }
  
  public A setToClusterClaims(int index,ManagedClusterClaim item) {
    if (this.clusterClaims == null) {
      this.clusterClaims = new ArrayList();
    }
    ManagedClusterClaimBuilder builder = new ManagedClusterClaimBuilder(item);
    if (index < 0 || index >= clusterClaims.size()) {
        _visitables.get("clusterClaims").add(builder);
        clusterClaims.add(builder);
    } else {
        _visitables.get("clusterClaims").add(builder);
        clusterClaims.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToManagedNamespaces(int index,ClusterSetManagedNamespaceConfig item) {
    if (this.managedNamespaces == null) {
      this.managedNamespaces = new ArrayList();
    }
    ClusterSetManagedNamespaceConfigBuilder builder = new ClusterSetManagedNamespaceConfigBuilder(item);
    if (index < 0 || index >= managedNamespaces.size()) {
        _visitables.get("managedNamespaces").add(builder);
        managedNamespaces.add(builder);
    } else {
        _visitables.get("managedNamespaces").add(builder);
        managedNamespaces.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocatable == null) && !(allocatable.isEmpty())) {
        sb.append("allocatable:");
        sb.append(allocatable);
        sb.append(",");
    }
    if (!(capacity == null) && !(capacity.isEmpty())) {
        sb.append("capacity:");
        sb.append(capacity);
        sb.append(",");
    }
    if (!(clusterClaims == null) && !(clusterClaims.isEmpty())) {
        sb.append("clusterClaims:");
        sb.append(clusterClaims);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(managedNamespaces == null) && !(managedNamespaces.isEmpty())) {
        sb.append("managedNamespaces:");
        sb.append(managedNamespaces);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public <K,V>A withAllocatable(Map<String,Quantity> allocatable) {
    if (allocatable == null) {
      this.allocatable = null;
    } else {
      this.allocatable = new LinkedHashMap(allocatable);
    }
    return (A) this;
  }
  
  public <K,V>A withCapacity(Map<String,Quantity> capacity) {
    if (capacity == null) {
      this.capacity = null;
    } else {
      this.capacity = new LinkedHashMap(capacity);
    }
    return (A) this;
  }
  
  public A withClusterClaims(List<ManagedClusterClaim> clusterClaims) {
    if (this.clusterClaims != null) {
      this._visitables.get("clusterClaims").clear();
    }
    if (clusterClaims != null) {
        this.clusterClaims = new ArrayList();
        for (ManagedClusterClaim item : clusterClaims) {
          this.addToClusterClaims(item);
        }
    } else {
      this.clusterClaims = null;
    }
    return (A) this;
  }
  
  public A withClusterClaims(ManagedClusterClaim... clusterClaims) {
    if (this.clusterClaims != null) {
        this.clusterClaims.clear();
        _visitables.remove("clusterClaims");
    }
    if (clusterClaims != null) {
      for (ManagedClusterClaim item : clusterClaims) {
        this.addToClusterClaims(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withManagedNamespaces(List<ClusterSetManagedNamespaceConfig> managedNamespaces) {
    if (this.managedNamespaces != null) {
      this._visitables.get("managedNamespaces").clear();
    }
    if (managedNamespaces != null) {
        this.managedNamespaces = new ArrayList();
        for (ClusterSetManagedNamespaceConfig item : managedNamespaces) {
          this.addToManagedNamespaces(item);
        }
    } else {
      this.managedNamespaces = null;
    }
    return (A) this;
  }
  
  public A withManagedNamespaces(ClusterSetManagedNamespaceConfig... managedNamespaces) {
    if (this.managedNamespaces != null) {
        this.managedNamespaces.clear();
        _visitables.remove("managedNamespaces");
    }
    if (managedNamespaces != null) {
      for (ClusterSetManagedNamespaceConfig item : managedNamespaces) {
        this.addToManagedNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public VersionNested<A> withNewVersion() {
    return new VersionNested(null);
  }
  
  public A withNewVersion(String kubernetes) {
    return (A) this.withVersion(new ManagedClusterVersion(kubernetes));
  }
  
  public VersionNested<A> withNewVersionLike(ManagedClusterVersion item) {
    return new VersionNested(item);
  }
  
  public A withVersion(ManagedClusterVersion version) {
    this._visitables.remove("version");
    if (version != null) {
        this.version = new ManagedClusterVersionBuilder(version);
        this._visitables.get("version").add(this.version);
    } else {
        this.version = null;
        this._visitables.get("version").remove(this.version);
    }
    return (A) this;
  }
  public class ClusterClaimsNested<N> extends ManagedClusterClaimFluent<ClusterClaimsNested<N>> implements Nested<N>{
  
    ManagedClusterClaimBuilder builder;
    int index;
  
    ClusterClaimsNested(int index,ManagedClusterClaim item) {
      this.index = index;
      this.builder = new ManagedClusterClaimBuilder(this, item);
    }
  
    public N and() {
      return (N) ManagedClusterStatusFluent.this.setToClusterClaims(index, builder.build());
    }
    
    public N endClusterClaim() {
      return and();
    }
    
  }
  public class ManagedNamespacesNested<N> extends ClusterSetManagedNamespaceConfigFluent<ManagedNamespacesNested<N>> implements Nested<N>{
  
    ClusterSetManagedNamespaceConfigBuilder builder;
    int index;
  
    ManagedNamespacesNested(int index,ClusterSetManagedNamespaceConfig item) {
      this.index = index;
      this.builder = new ClusterSetManagedNamespaceConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ManagedClusterStatusFluent.this.setToManagedNamespaces(index, builder.build());
    }
    
    public N endManagedNamespace() {
      return and();
    }
    
  }
  public class VersionNested<N> extends ManagedClusterVersionFluent<VersionNested<N>> implements Nested<N>{
  
    ManagedClusterVersionBuilder builder;
  
    VersionNested(ManagedClusterVersion item) {
      this.builder = new ManagedClusterVersionBuilder(this, item);
    }
  
    public N and() {
      return (N) ManagedClusterStatusFluent.this.withVersion(builder.build());
    }
    
    public N endVersion() {
      return and();
    }
    
  }
}