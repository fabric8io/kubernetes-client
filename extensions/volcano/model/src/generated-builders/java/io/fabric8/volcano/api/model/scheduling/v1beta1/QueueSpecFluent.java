package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class QueueSpecFluent<A extends io.fabric8.volcano.api.model.scheduling.v1beta1.QueueSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AffinityBuilder affinity;
  private Map<String,Quantity> capability;
  private Map<String,Quantity> deserved;
  private ArrayList<ClusterBuilder> extendClusters = new ArrayList<ClusterBuilder>();
  private GuaranteeBuilder guarantee;
  private String parent;
  private Integer priority;
  private Boolean reclaimable;
  private String type;
  private Integer weight;

  public QueueSpecFluent() {
  }
  
  public QueueSpecFluent(QueueSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToExtendClusters(Collection<Cluster> items) {
    if (this.extendClusters == null) {
      this.extendClusters = new ArrayList();
    }
    for (Cluster item : items) {
        ClusterBuilder builder = new ClusterBuilder(item);
        _visitables.get("extendClusters").add(builder);
        this.extendClusters.add(builder);
    }
    return (A) this;
  }
  
  public ExtendClustersNested<A> addNewExtendCluster() {
    return new ExtendClustersNested(-1, null);
  }
  
  public ExtendClustersNested<A> addNewExtendClusterLike(Cluster item) {
    return new ExtendClustersNested(-1, item);
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
  
  public A addToCapability(Map<String,Quantity> map) {
    if (this.capability == null && map != null) {
      this.capability = new LinkedHashMap();
    }
    if (map != null) {
      this.capability.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCapability(String key,Quantity value) {
    if (this.capability == null && key != null && value != null) {
      this.capability = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.capability.put(key, value);
    }
    return (A) this;
  }
  
  public A addToDeserved(Map<String,Quantity> map) {
    if (this.deserved == null && map != null) {
      this.deserved = new LinkedHashMap();
    }
    if (map != null) {
      this.deserved.putAll(map);
    }
    return (A) this;
  }
  
  public A addToDeserved(String key,Quantity value) {
    if (this.deserved == null && key != null && value != null) {
      this.deserved = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.deserved.put(key, value);
    }
    return (A) this;
  }
  
  public A addToExtendClusters(Cluster... items) {
    if (this.extendClusters == null) {
      this.extendClusters = new ArrayList();
    }
    for (Cluster item : items) {
        ClusterBuilder builder = new ClusterBuilder(item);
        _visitables.get("extendClusters").add(builder);
        this.extendClusters.add(builder);
    }
    return (A) this;
  }
  
  public A addToExtendClusters(int index,Cluster item) {
    if (this.extendClusters == null) {
      this.extendClusters = new ArrayList();
    }
    ClusterBuilder builder = new ClusterBuilder(item);
    if (index < 0 || index >= extendClusters.size()) {
        _visitables.get("extendClusters").add(builder);
        extendClusters.add(builder);
    } else {
        _visitables.get("extendClusters").add(builder);
        extendClusters.add(index, builder);
    }
    return (A) this;
  }
  
  public Affinity buildAffinity() {
    return this.affinity != null ? this.affinity.build() : null;
  }
  
  public Cluster buildExtendCluster(int index) {
    return this.extendClusters.get(index).build();
  }
  
  public List<Cluster> buildExtendClusters() {
    return this.extendClusters != null ? build(extendClusters) : null;
  }
  
  public Cluster buildFirstExtendCluster() {
    return this.extendClusters.get(0).build();
  }
  
  public Guarantee buildGuarantee() {
    return this.guarantee != null ? this.guarantee.build() : null;
  }
  
  public Cluster buildLastExtendCluster() {
    return this.extendClusters.get(extendClusters.size() - 1).build();
  }
  
  public Cluster buildMatchingExtendCluster(Predicate<ClusterBuilder> predicate) {
      for (ClusterBuilder item : extendClusters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(QueueSpec instance) {
    instance = instance != null ? instance : new QueueSpec();
    if (instance != null) {
        this.withAffinity(instance.getAffinity());
        this.withCapability(instance.getCapability());
        this.withDeserved(instance.getDeserved());
        this.withExtendClusters(instance.getExtendClusters());
        this.withGuarantee(instance.getGuarantee());
        this.withParent(instance.getParent());
        this.withPriority(instance.getPriority());
        this.withReclaimable(instance.getReclaimable());
        this.withType(instance.getType());
        this.withWeight(instance.getWeight());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AffinityNested<A> editAffinity() {
    return this.withNewAffinityLike(Optional.ofNullable(this.buildAffinity()).orElse(null));
  }
  
  public ExtendClustersNested<A> editExtendCluster(int index) {
    if (extendClusters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "extendClusters"));
    }
    return this.setNewExtendClusterLike(index, this.buildExtendCluster(index));
  }
  
  public ExtendClustersNested<A> editFirstExtendCluster() {
    if (extendClusters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "extendClusters"));
    }
    return this.setNewExtendClusterLike(0, this.buildExtendCluster(0));
  }
  
  public GuaranteeNested<A> editGuarantee() {
    return this.withNewGuaranteeLike(Optional.ofNullable(this.buildGuarantee()).orElse(null));
  }
  
  public ExtendClustersNested<A> editLastExtendCluster() {
    int index = extendClusters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "extendClusters"));
    }
    return this.setNewExtendClusterLike(index, this.buildExtendCluster(index));
  }
  
  public ExtendClustersNested<A> editMatchingExtendCluster(Predicate<ClusterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < extendClusters.size();i++) {
      if (predicate.test(extendClusters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "extendClusters"));
    }
    return this.setNewExtendClusterLike(index, this.buildExtendCluster(index));
  }
  
  public AffinityNested<A> editOrNewAffinity() {
    return this.withNewAffinityLike(Optional.ofNullable(this.buildAffinity()).orElse(new AffinityBuilder().build()));
  }
  
  public AffinityNested<A> editOrNewAffinityLike(Affinity item) {
    return this.withNewAffinityLike(Optional.ofNullable(this.buildAffinity()).orElse(item));
  }
  
  public GuaranteeNested<A> editOrNewGuarantee() {
    return this.withNewGuaranteeLike(Optional.ofNullable(this.buildGuarantee()).orElse(new GuaranteeBuilder().build()));
  }
  
  public GuaranteeNested<A> editOrNewGuaranteeLike(Guarantee item) {
    return this.withNewGuaranteeLike(Optional.ofNullable(this.buildGuarantee()).orElse(item));
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
    QueueSpecFluent that = (QueueSpecFluent) o;
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(capability, that.capability))) {
      return false;
    }
    if (!(Objects.equals(deserved, that.deserved))) {
      return false;
    }
    if (!(Objects.equals(extendClusters, that.extendClusters))) {
      return false;
    }
    if (!(Objects.equals(guarantee, that.guarantee))) {
      return false;
    }
    if (!(Objects.equals(parent, that.parent))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(reclaimable, that.reclaimable))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(weight, that.weight))) {
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
  
  public Map<String,Quantity> getCapability() {
    return this.capability;
  }
  
  public Map<String,Quantity> getDeserved() {
    return this.deserved;
  }
  
  public String getParent() {
    return this.parent;
  }
  
  public Integer getPriority() {
    return this.priority;
  }
  
  public Boolean getReclaimable() {
    return this.reclaimable;
  }
  
  public String getType() {
    return this.type;
  }
  
  public Integer getWeight() {
    return this.weight;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasCapability() {
    return this.capability != null;
  }
  
  public boolean hasDeserved() {
    return this.deserved != null;
  }
  
  public boolean hasExtendClusters() {
    return this.extendClusters != null && !(this.extendClusters.isEmpty());
  }
  
  public boolean hasGuarantee() {
    return this.guarantee != null;
  }
  
  public boolean hasMatchingExtendCluster(Predicate<ClusterBuilder> predicate) {
      for (ClusterBuilder item : extendClusters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParent() {
    return this.parent != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasReclaimable() {
    return this.reclaimable != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasWeight() {
    return this.weight != null;
  }
  
  public int hashCode() {
    return Objects.hash(affinity, capability, deserved, extendClusters, guarantee, parent, priority, reclaimable, type, weight, additionalProperties);
  }
  
  public A removeAllFromExtendClusters(Collection<Cluster> items) {
    if (this.extendClusters == null) {
      return (A) this;
    }
    for (Cluster item : items) {
        ClusterBuilder builder = new ClusterBuilder(item);
        _visitables.get("extendClusters").remove(builder);
        this.extendClusters.remove(builder);
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
  
  public A removeFromCapability(String key) {
    if (this.capability == null) {
      return (A) this;
    }
    if (key != null && this.capability != null) {
      this.capability.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCapability(Map<String,Quantity> map) {
    if (this.capability == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.capability != null) {
          this.capability.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromDeserved(String key) {
    if (this.deserved == null) {
      return (A) this;
    }
    if (key != null && this.deserved != null) {
      this.deserved.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromDeserved(Map<String,Quantity> map) {
    if (this.deserved == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.deserved != null) {
          this.deserved.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromExtendClusters(Cluster... items) {
    if (this.extendClusters == null) {
      return (A) this;
    }
    for (Cluster item : items) {
        ClusterBuilder builder = new ClusterBuilder(item);
        _visitables.get("extendClusters").remove(builder);
        this.extendClusters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExtendClusters(Predicate<ClusterBuilder> predicate) {
    if (extendClusters == null) {
      return (A) this;
    }
    Iterator<ClusterBuilder> each = extendClusters.iterator();
    List visitables = _visitables.get("extendClusters");
    while (each.hasNext()) {
        ClusterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExtendClustersNested<A> setNewExtendClusterLike(int index,Cluster item) {
    return new ExtendClustersNested(index, item);
  }
  
  public A setToExtendClusters(int index,Cluster item) {
    if (this.extendClusters == null) {
      this.extendClusters = new ArrayList();
    }
    ClusterBuilder builder = new ClusterBuilder(item);
    if (index < 0 || index >= extendClusters.size()) {
        _visitables.get("extendClusters").add(builder);
        extendClusters.add(builder);
    } else {
        _visitables.get("extendClusters").add(builder);
        extendClusters.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(capability == null) && !(capability.isEmpty())) {
        sb.append("capability:");
        sb.append(capability);
        sb.append(",");
    }
    if (!(deserved == null) && !(deserved.isEmpty())) {
        sb.append("deserved:");
        sb.append(deserved);
        sb.append(",");
    }
    if (!(extendClusters == null) && !(extendClusters.isEmpty())) {
        sb.append("extendClusters:");
        sb.append(extendClusters);
        sb.append(",");
    }
    if (!(guarantee == null)) {
        sb.append("guarantee:");
        sb.append(guarantee);
        sb.append(",");
    }
    if (!(parent == null)) {
        sb.append("parent:");
        sb.append(parent);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(reclaimable == null)) {
        sb.append("reclaimable:");
        sb.append(reclaimable);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(weight == null)) {
        sb.append("weight:");
        sb.append(weight);
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
  
  public A withAffinity(Affinity affinity) {
    this._visitables.remove("affinity");
    if (affinity != null) {
        this.affinity = new AffinityBuilder(affinity);
        this._visitables.get("affinity").add(this.affinity);
    } else {
        this.affinity = null;
        this._visitables.get("affinity").remove(this.affinity);
    }
    return (A) this;
  }
  
  public <K,V>A withCapability(Map<String,Quantity> capability) {
    if (capability == null) {
      this.capability = null;
    } else {
      this.capability = new LinkedHashMap(capability);
    }
    return (A) this;
  }
  
  public <K,V>A withDeserved(Map<String,Quantity> deserved) {
    if (deserved == null) {
      this.deserved = null;
    } else {
      this.deserved = new LinkedHashMap(deserved);
    }
    return (A) this;
  }
  
  public A withExtendClusters(List<Cluster> extendClusters) {
    if (this.extendClusters != null) {
      this._visitables.get("extendClusters").clear();
    }
    if (extendClusters != null) {
        this.extendClusters = new ArrayList();
        for (Cluster item : extendClusters) {
          this.addToExtendClusters(item);
        }
    } else {
      this.extendClusters = null;
    }
    return (A) this;
  }
  
  public A withExtendClusters(Cluster... extendClusters) {
    if (this.extendClusters != null) {
        this.extendClusters.clear();
        _visitables.remove("extendClusters");
    }
    if (extendClusters != null) {
      for (Cluster item : extendClusters) {
        this.addToExtendClusters(item);
      }
    }
    return (A) this;
  }
  
  public A withGuarantee(Guarantee guarantee) {
    this._visitables.remove("guarantee");
    if (guarantee != null) {
        this.guarantee = new GuaranteeBuilder(guarantee);
        this._visitables.get("guarantee").add(this.guarantee);
    } else {
        this.guarantee = null;
        this._visitables.get("guarantee").remove(this.guarantee);
    }
    return (A) this;
  }
  
  public AffinityNested<A> withNewAffinity() {
    return new AffinityNested(null);
  }
  
  public AffinityNested<A> withNewAffinityLike(Affinity item) {
    return new AffinityNested(item);
  }
  
  public GuaranteeNested<A> withNewGuarantee() {
    return new GuaranteeNested(null);
  }
  
  public GuaranteeNested<A> withNewGuaranteeLike(Guarantee item) {
    return new GuaranteeNested(item);
  }
  
  public A withParent(String parent) {
    this.parent = parent;
    return (A) this;
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withReclaimable() {
    return withReclaimable(true);
  }
  
  public A withReclaimable(Boolean reclaimable) {
    this.reclaimable = reclaimable;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withWeight(Integer weight) {
    this.weight = weight;
    return (A) this;
  }
  public class AffinityNested<N> extends AffinityFluent<AffinityNested<N>> implements Nested<N>{
  
    AffinityBuilder builder;
  
    AffinityNested(Affinity item) {
      this.builder = new AffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) QueueSpecFluent.this.withAffinity(builder.build());
    }
    
    public N endAffinity() {
      return and();
    }
    
  }
  public class ExtendClustersNested<N> extends ClusterFluent<ExtendClustersNested<N>> implements Nested<N>{
  
    ClusterBuilder builder;
    int index;
  
    ExtendClustersNested(int index,Cluster item) {
      this.index = index;
      this.builder = new ClusterBuilder(this, item);
    }
  
    public N and() {
      return (N) QueueSpecFluent.this.setToExtendClusters(index, builder.build());
    }
    
    public N endExtendCluster() {
      return and();
    }
    
  }
  public class GuaranteeNested<N> extends GuaranteeFluent<GuaranteeNested<N>> implements Nested<N>{
  
    GuaranteeBuilder builder;
  
    GuaranteeNested(Guarantee item) {
      this.builder = new GuaranteeBuilder(this, item);
    }
  
    public N and() {
      return (N) QueueSpecFluent.this.withGuarantee(builder.build());
    }
    
    public N endGuarantee() {
      return and();
    }
    
  }
}