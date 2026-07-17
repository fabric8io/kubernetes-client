package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Integer;
import java.lang.Long;
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
public class NetworkStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.NetworkStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterNetworkEntryBuilder> clusterNetwork = new ArrayList<ClusterNetworkEntryBuilder>();
  private Integer clusterNetworkMTU;
  private List<Condition> conditions = new ArrayList<Condition>();
  private NetworkMigrationBuilder migration;
  private String networkType;
  private List<String> serviceNetwork = new ArrayList<String>();

  public NetworkStatusFluent() {
  }
  
  public NetworkStatusFluent(NetworkStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").add(builder);
        this.clusterNetwork.add(builder);
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
  
  public A addAllToServiceNetwork(Collection<String> items) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    for (String item : items) {
      this.serviceNetwork.add(item);
    }
    return (A) this;
  }
  
  public ClusterNetworkNested<A> addNewClusterNetwork() {
    return new ClusterNetworkNested(-1, null);
  }
  
  public A addNewClusterNetwork(String cidr,Long hostPrefix) {
    return (A) this.addToClusterNetwork(new ClusterNetworkEntry(cidr, hostPrefix));
  }
  
  public ClusterNetworkNested<A> addNewClusterNetworkLike(ClusterNetworkEntry item) {
    return new ClusterNetworkNested(-1, item);
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
  
  public A addToClusterNetwork(ClusterNetworkEntry... items) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").add(builder);
        this.clusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetwork.size()) {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(builder);
    } else {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(index, builder);
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
  
  public A addToServiceNetwork(String... items) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    for (String item : items) {
      this.serviceNetwork.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceNetwork(int index,String item) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    this.serviceNetwork.add(index, item);
    return (A) this;
  }
  
  public List<ClusterNetworkEntry> buildClusterNetwork() {
    return this.clusterNetwork != null ? build(clusterNetwork) : null;
  }
  
  public ClusterNetworkEntry buildClusterNetwork(int index) {
    return this.clusterNetwork.get(index).build();
  }
  
  public ClusterNetworkEntry buildFirstClusterNetwork() {
    return this.clusterNetwork.get(0).build();
  }
  
  public ClusterNetworkEntry buildLastClusterNetwork() {
    return this.clusterNetwork.get(clusterNetwork.size() - 1).build();
  }
  
  public ClusterNetworkEntry buildMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetwork) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkMigration buildMigration() {
    return this.migration != null ? this.migration.build() : null;
  }
  
  protected void copyInstance(NetworkStatus instance) {
    instance = instance != null ? instance : new NetworkStatus();
    if (instance != null) {
        this.withClusterNetwork(instance.getClusterNetwork());
        this.withClusterNetworkMTU(instance.getClusterNetworkMTU());
        this.withConditions(instance.getConditions());
        this.withMigration(instance.getMigration());
        this.withNetworkType(instance.getNetworkType());
        this.withServiceNetwork(instance.getServiceNetwork());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterNetworkNested<A> editClusterNetwork(int index) {
    if (clusterNetwork.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ClusterNetworkNested<A> editFirstClusterNetwork() {
    if (clusterNetwork.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(0, this.buildClusterNetwork(0));
  }
  
  public ClusterNetworkNested<A> editLastClusterNetwork() {
    int index = clusterNetwork.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ClusterNetworkNested<A> editMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterNetwork.size();i++) {
      if (predicate.test(clusterNetwork.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public MigrationNested<A> editMigration() {
    return this.withNewMigrationLike(Optional.ofNullable(this.buildMigration()).orElse(null));
  }
  
  public MigrationNested<A> editOrNewMigration() {
    return this.withNewMigrationLike(Optional.ofNullable(this.buildMigration()).orElse(new NetworkMigrationBuilder().build()));
  }
  
  public MigrationNested<A> editOrNewMigrationLike(NetworkMigration item) {
    return this.withNewMigrationLike(Optional.ofNullable(this.buildMigration()).orElse(item));
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
    NetworkStatusFluent that = (NetworkStatusFluent) o;
    if (!(Objects.equals(clusterNetwork, that.clusterNetwork))) {
      return false;
    }
    if (!(Objects.equals(clusterNetworkMTU, that.clusterNetworkMTU))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(migration, that.migration))) {
      return false;
    }
    if (!(Objects.equals(networkType, that.networkType))) {
      return false;
    }
    if (!(Objects.equals(serviceNetwork, that.serviceNetwork))) {
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
  
  public Integer getClusterNetworkMTU() {
    return this.clusterNetworkMTU;
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
  
  public String getFirstServiceNetwork() {
    return this.serviceNetwork.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastServiceNetwork() {
    return this.serviceNetwork.get(serviceNetwork.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingServiceNetwork(Predicate<String> predicate) {
      for (String item : serviceNetwork) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetworkType() {
    return this.networkType;
  }
  
  public List<String> getServiceNetwork() {
    return this.serviceNetwork;
  }
  
  public String getServiceNetwork(int index) {
    return this.serviceNetwork.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterNetwork() {
    return this.clusterNetwork != null && !(this.clusterNetwork.isEmpty());
  }
  
  public boolean hasClusterNetworkMTU() {
    return this.clusterNetworkMTU != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetwork) {
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
  
  public boolean hasMatchingServiceNetwork(Predicate<String> predicate) {
      for (String item : serviceNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMigration() {
    return this.migration != null;
  }
  
  public boolean hasNetworkType() {
    return this.networkType != null;
  }
  
  public boolean hasServiceNetwork() {
    return this.serviceNetwork != null && !(this.serviceNetwork.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(clusterNetwork, clusterNetworkMTU, conditions, migration, networkType, serviceNetwork, additionalProperties);
  }
  
  public A removeAllFromClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").remove(builder);
        this.clusterNetwork.remove(builder);
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
  
  public A removeAllFromServiceNetwork(Collection<String> items) {
    if (this.serviceNetwork == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceNetwork.remove(item);
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
  
  public A removeFromClusterNetwork(ClusterNetworkEntry... items) {
    if (this.clusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").remove(builder);
        this.clusterNetwork.remove(builder);
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
  
  public A removeFromServiceNetwork(String... items) {
    if (this.serviceNetwork == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceNetwork.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    if (clusterNetwork == null) {
      return (A) this;
    }
    Iterator<ClusterNetworkEntryBuilder> each = clusterNetwork.iterator();
    List visitables = _visitables.get("clusterNetwork");
    while (each.hasNext()) {
        ClusterNetworkEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterNetworkNested<A> setNewClusterNetworkLike(int index,ClusterNetworkEntry item) {
    return new ClusterNetworkNested(index, item);
  }
  
  public A setToClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetwork.size()) {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(builder);
    } else {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.set(index, builder);
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
  
  public A setToServiceNetwork(int index,String item) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    this.serviceNetwork.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterNetwork == null) && !(clusterNetwork.isEmpty())) {
        sb.append("clusterNetwork:");
        sb.append(clusterNetwork);
        sb.append(",");
    }
    if (!(clusterNetworkMTU == null)) {
        sb.append("clusterNetworkMTU:");
        sb.append(clusterNetworkMTU);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(migration == null)) {
        sb.append("migration:");
        sb.append(migration);
        sb.append(",");
    }
    if (!(networkType == null)) {
        sb.append("networkType:");
        sb.append(networkType);
        sb.append(",");
    }
    if (!(serviceNetwork == null) && !(serviceNetwork.isEmpty())) {
        sb.append("serviceNetwork:");
        sb.append(serviceNetwork);
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
  
  public A withClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
    if (this.clusterNetwork != null) {
      this._visitables.get("clusterNetwork").clear();
    }
    if (clusterNetwork != null) {
        this.clusterNetwork = new ArrayList();
        for (ClusterNetworkEntry item : clusterNetwork) {
          this.addToClusterNetwork(item);
        }
    } else {
      this.clusterNetwork = null;
    }
    return (A) this;
  }
  
  public A withClusterNetwork(ClusterNetworkEntry... clusterNetwork) {
    if (this.clusterNetwork != null) {
        this.clusterNetwork.clear();
        _visitables.remove("clusterNetwork");
    }
    if (clusterNetwork != null) {
      for (ClusterNetworkEntry item : clusterNetwork) {
        this.addToClusterNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withClusterNetworkMTU(Integer clusterNetworkMTU) {
    this.clusterNetworkMTU = clusterNetworkMTU;
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
  
  public A withMigration(NetworkMigration migration) {
    this._visitables.remove("migration");
    if (migration != null) {
        this.migration = new NetworkMigrationBuilder(migration);
        this._visitables.get("migration").add(this.migration);
    } else {
        this.migration = null;
        this._visitables.get("migration").remove(this.migration);
    }
    return (A) this;
  }
  
  public A withNetworkType(String networkType) {
    this.networkType = networkType;
    return (A) this;
  }
  
  public MigrationNested<A> withNewMigration() {
    return new MigrationNested(null);
  }
  
  public MigrationNested<A> withNewMigrationLike(NetworkMigration item) {
    return new MigrationNested(item);
  }
  
  public A withServiceNetwork(List<String> serviceNetwork) {
    if (serviceNetwork != null) {
        this.serviceNetwork = new ArrayList();
        for (String item : serviceNetwork) {
          this.addToServiceNetwork(item);
        }
    } else {
      this.serviceNetwork = null;
    }
    return (A) this;
  }
  
  public A withServiceNetwork(String... serviceNetwork) {
    if (this.serviceNetwork != null) {
        this.serviceNetwork.clear();
        _visitables.remove("serviceNetwork");
    }
    if (serviceNetwork != null) {
      for (String item : serviceNetwork) {
        this.addToServiceNetwork(item);
      }
    }
    return (A) this;
  }
  public class ClusterNetworkNested<N> extends ClusterNetworkEntryFluent<ClusterNetworkNested<N>> implements Nested<N>{
  
    ClusterNetworkEntryBuilder builder;
    int index;
  
    ClusterNetworkNested(int index,ClusterNetworkEntry item) {
      this.index = index;
      this.builder = new ClusterNetworkEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkStatusFluent.this.setToClusterNetwork(index, builder.build());
    }
    
    public N endClusterNetwork() {
      return and();
    }
    
  }
  public class MigrationNested<N> extends NetworkMigrationFluent<MigrationNested<N>> implements Nested<N>{
  
    NetworkMigrationBuilder builder;
  
    MigrationNested(NetworkMigration item) {
      this.builder = new NetworkMigrationBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkStatusFluent.this.withMigration(builder.build());
    }
    
    public N endMigration() {
      return and();
    }
    
  }
}