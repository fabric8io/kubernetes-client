package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ManagedClusterSpecFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean hubAcceptsClient;
  private Integer leaseDurationSeconds;
  private ArrayList<ClientConfigBuilder> managedClusterClientConfigs = new ArrayList<ClientConfigBuilder>();
  private ArrayList<TaintBuilder> taints = new ArrayList<TaintBuilder>();

  public ManagedClusterSpecFluent() {
  }
  
  public ManagedClusterSpecFluent(ManagedClusterSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToManagedClusterClientConfigs(Collection<ClientConfig> items) {
    if (this.managedClusterClientConfigs == null) {
      this.managedClusterClientConfigs = new ArrayList();
    }
    for (ClientConfig item : items) {
        ClientConfigBuilder builder = new ClientConfigBuilder(item);
        _visitables.get("managedClusterClientConfigs").add(builder);
        this.managedClusterClientConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTaints(Collection<Taint> items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
        TaintBuilder builder = new TaintBuilder(item);
        _visitables.get("taints").add(builder);
        this.taints.add(builder);
    }
    return (A) this;
  }
  
  public ManagedClusterClientConfigsNested<A> addNewManagedClusterClientConfig() {
    return new ManagedClusterClientConfigsNested(-1, null);
  }
  
  public A addNewManagedClusterClientConfig(String caBundle,String url) {
    return (A) this.addToManagedClusterClientConfigs(new ClientConfig(caBundle, url));
  }
  
  public ManagedClusterClientConfigsNested<A> addNewManagedClusterClientConfigLike(ClientConfig item) {
    return new ManagedClusterClientConfigsNested(-1, item);
  }
  
  public TaintsNested<A> addNewTaint() {
    return new TaintsNested(-1, null);
  }
  
  public A addNewTaint(String effect,String key,String timeAdded,String value) {
    return (A) this.addToTaints(new Taint(effect, key, timeAdded, value));
  }
  
  public TaintsNested<A> addNewTaintLike(Taint item) {
    return new TaintsNested(-1, item);
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
  
  public A addToManagedClusterClientConfigs(ClientConfig... items) {
    if (this.managedClusterClientConfigs == null) {
      this.managedClusterClientConfigs = new ArrayList();
    }
    for (ClientConfig item : items) {
        ClientConfigBuilder builder = new ClientConfigBuilder(item);
        _visitables.get("managedClusterClientConfigs").add(builder);
        this.managedClusterClientConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToManagedClusterClientConfigs(int index,ClientConfig item) {
    if (this.managedClusterClientConfigs == null) {
      this.managedClusterClientConfigs = new ArrayList();
    }
    ClientConfigBuilder builder = new ClientConfigBuilder(item);
    if (index < 0 || index >= managedClusterClientConfigs.size()) {
        _visitables.get("managedClusterClientConfigs").add(builder);
        managedClusterClientConfigs.add(builder);
    } else {
        _visitables.get("managedClusterClientConfigs").add(builder);
        managedClusterClientConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTaints(Taint... items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
        TaintBuilder builder = new TaintBuilder(item);
        _visitables.get("taints").add(builder);
        this.taints.add(builder);
    }
    return (A) this;
  }
  
  public A addToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    TaintBuilder builder = new TaintBuilder(item);
    if (index < 0 || index >= taints.size()) {
        _visitables.get("taints").add(builder);
        taints.add(builder);
    } else {
        _visitables.get("taints").add(builder);
        taints.add(index, builder);
    }
    return (A) this;
  }
  
  public ClientConfig buildFirstManagedClusterClientConfig() {
    return this.managedClusterClientConfigs.get(0).build();
  }
  
  public Taint buildFirstTaint() {
    return this.taints.get(0).build();
  }
  
  public ClientConfig buildLastManagedClusterClientConfig() {
    return this.managedClusterClientConfigs.get(managedClusterClientConfigs.size() - 1).build();
  }
  
  public Taint buildLastTaint() {
    return this.taints.get(taints.size() - 1).build();
  }
  
  public ClientConfig buildManagedClusterClientConfig(int index) {
    return this.managedClusterClientConfigs.get(index).build();
  }
  
  public List<ClientConfig> buildManagedClusterClientConfigs() {
    return this.managedClusterClientConfigs != null ? build(managedClusterClientConfigs) : null;
  }
  
  public ClientConfig buildMatchingManagedClusterClientConfig(Predicate<ClientConfigBuilder> predicate) {
      for (ClientConfigBuilder item : managedClusterClientConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Taint buildMatchingTaint(Predicate<TaintBuilder> predicate) {
      for (TaintBuilder item : taints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Taint buildTaint(int index) {
    return this.taints.get(index).build();
  }
  
  public List<Taint> buildTaints() {
    return this.taints != null ? build(taints) : null;
  }
  
  protected void copyInstance(ManagedClusterSpec instance) {
    instance = instance != null ? instance : new ManagedClusterSpec();
    if (instance != null) {
        this.withHubAcceptsClient(instance.getHubAcceptsClient());
        this.withLeaseDurationSeconds(instance.getLeaseDurationSeconds());
        this.withManagedClusterClientConfigs(instance.getManagedClusterClientConfigs());
        this.withTaints(instance.getTaints());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ManagedClusterClientConfigsNested<A> editFirstManagedClusterClientConfig() {
    if (managedClusterClientConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "managedClusterClientConfigs"));
    }
    return this.setNewManagedClusterClientConfigLike(0, this.buildManagedClusterClientConfig(0));
  }
  
  public TaintsNested<A> editFirstTaint() {
    if (taints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "taints"));
    }
    return this.setNewTaintLike(0, this.buildTaint(0));
  }
  
  public ManagedClusterClientConfigsNested<A> editLastManagedClusterClientConfig() {
    int index = managedClusterClientConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "managedClusterClientConfigs"));
    }
    return this.setNewManagedClusterClientConfigLike(index, this.buildManagedClusterClientConfig(index));
  }
  
  public TaintsNested<A> editLastTaint() {
    int index = taints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
  }
  
  public ManagedClusterClientConfigsNested<A> editManagedClusterClientConfig(int index) {
    if (managedClusterClientConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "managedClusterClientConfigs"));
    }
    return this.setNewManagedClusterClientConfigLike(index, this.buildManagedClusterClientConfig(index));
  }
  
  public ManagedClusterClientConfigsNested<A> editMatchingManagedClusterClientConfig(Predicate<ClientConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < managedClusterClientConfigs.size();i++) {
      if (predicate.test(managedClusterClientConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "managedClusterClientConfigs"));
    }
    return this.setNewManagedClusterClientConfigLike(index, this.buildManagedClusterClientConfig(index));
  }
  
  public TaintsNested<A> editMatchingTaint(Predicate<TaintBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < taints.size();i++) {
      if (predicate.test(taints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
  }
  
  public TaintsNested<A> editTaint(int index) {
    if (taints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "taints"));
    }
    return this.setNewTaintLike(index, this.buildTaint(index));
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
    ManagedClusterSpecFluent that = (ManagedClusterSpecFluent) o;
    if (!(Objects.equals(hubAcceptsClient, that.hubAcceptsClient))) {
      return false;
    }
    if (!(Objects.equals(leaseDurationSeconds, that.leaseDurationSeconds))) {
      return false;
    }
    if (!(Objects.equals(managedClusterClientConfigs, that.managedClusterClientConfigs))) {
      return false;
    }
    if (!(Objects.equals(taints, that.taints))) {
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
  
  public Boolean getHubAcceptsClient() {
    return this.hubAcceptsClient;
  }
  
  public Integer getLeaseDurationSeconds() {
    return this.leaseDurationSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHubAcceptsClient() {
    return this.hubAcceptsClient != null;
  }
  
  public boolean hasLeaseDurationSeconds() {
    return this.leaseDurationSeconds != null;
  }
  
  public boolean hasManagedClusterClientConfigs() {
    return this.managedClusterClientConfigs != null && !(this.managedClusterClientConfigs.isEmpty());
  }
  
  public boolean hasMatchingManagedClusterClientConfig(Predicate<ClientConfigBuilder> predicate) {
      for (ClientConfigBuilder item : managedClusterClientConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTaint(Predicate<TaintBuilder> predicate) {
      for (TaintBuilder item : taints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTaints() {
    return this.taints != null && !(this.taints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(hubAcceptsClient, leaseDurationSeconds, managedClusterClientConfigs, taints, additionalProperties);
  }
  
  public A removeAllFromManagedClusterClientConfigs(Collection<ClientConfig> items) {
    if (this.managedClusterClientConfigs == null) {
      return (A) this;
    }
    for (ClientConfig item : items) {
        ClientConfigBuilder builder = new ClientConfigBuilder(item);
        _visitables.get("managedClusterClientConfigs").remove(builder);
        this.managedClusterClientConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTaints(Collection<Taint> items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
        TaintBuilder builder = new TaintBuilder(item);
        _visitables.get("taints").remove(builder);
        this.taints.remove(builder);
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
  
  public A removeFromManagedClusterClientConfigs(ClientConfig... items) {
    if (this.managedClusterClientConfigs == null) {
      return (A) this;
    }
    for (ClientConfig item : items) {
        ClientConfigBuilder builder = new ClientConfigBuilder(item);
        _visitables.get("managedClusterClientConfigs").remove(builder);
        this.managedClusterClientConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTaints(Taint... items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
        TaintBuilder builder = new TaintBuilder(item);
        _visitables.get("taints").remove(builder);
        this.taints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromManagedClusterClientConfigs(Predicate<ClientConfigBuilder> predicate) {
    if (managedClusterClientConfigs == null) {
      return (A) this;
    }
    Iterator<ClientConfigBuilder> each = managedClusterClientConfigs.iterator();
    List visitables = _visitables.get("managedClusterClientConfigs");
    while (each.hasNext()) {
        ClientConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTaints(Predicate<TaintBuilder> predicate) {
    if (taints == null) {
      return (A) this;
    }
    Iterator<TaintBuilder> each = taints.iterator();
    List visitables = _visitables.get("taints");
    while (each.hasNext()) {
        TaintBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ManagedClusterClientConfigsNested<A> setNewManagedClusterClientConfigLike(int index,ClientConfig item) {
    return new ManagedClusterClientConfigsNested(index, item);
  }
  
  public TaintsNested<A> setNewTaintLike(int index,Taint item) {
    return new TaintsNested(index, item);
  }
  
  public A setToManagedClusterClientConfigs(int index,ClientConfig item) {
    if (this.managedClusterClientConfigs == null) {
      this.managedClusterClientConfigs = new ArrayList();
    }
    ClientConfigBuilder builder = new ClientConfigBuilder(item);
    if (index < 0 || index >= managedClusterClientConfigs.size()) {
        _visitables.get("managedClusterClientConfigs").add(builder);
        managedClusterClientConfigs.add(builder);
    } else {
        _visitables.get("managedClusterClientConfigs").add(builder);
        managedClusterClientConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    TaintBuilder builder = new TaintBuilder(item);
    if (index < 0 || index >= taints.size()) {
        _visitables.get("taints").add(builder);
        taints.add(builder);
    } else {
        _visitables.get("taints").add(builder);
        taints.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hubAcceptsClient == null)) {
        sb.append("hubAcceptsClient:");
        sb.append(hubAcceptsClient);
        sb.append(",");
    }
    if (!(leaseDurationSeconds == null)) {
        sb.append("leaseDurationSeconds:");
        sb.append(leaseDurationSeconds);
        sb.append(",");
    }
    if (!(managedClusterClientConfigs == null) && !(managedClusterClientConfigs.isEmpty())) {
        sb.append("managedClusterClientConfigs:");
        sb.append(managedClusterClientConfigs);
        sb.append(",");
    }
    if (!(taints == null) && !(taints.isEmpty())) {
        sb.append("taints:");
        sb.append(taints);
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
  
  public A withHubAcceptsClient() {
    return withHubAcceptsClient(true);
  }
  
  public A withHubAcceptsClient(Boolean hubAcceptsClient) {
    this.hubAcceptsClient = hubAcceptsClient;
    return (A) this;
  }
  
  public A withLeaseDurationSeconds(Integer leaseDurationSeconds) {
    this.leaseDurationSeconds = leaseDurationSeconds;
    return (A) this;
  }
  
  public A withManagedClusterClientConfigs(List<ClientConfig> managedClusterClientConfigs) {
    if (this.managedClusterClientConfigs != null) {
      this._visitables.get("managedClusterClientConfigs").clear();
    }
    if (managedClusterClientConfigs != null) {
        this.managedClusterClientConfigs = new ArrayList();
        for (ClientConfig item : managedClusterClientConfigs) {
          this.addToManagedClusterClientConfigs(item);
        }
    } else {
      this.managedClusterClientConfigs = null;
    }
    return (A) this;
  }
  
  public A withManagedClusterClientConfigs(ClientConfig... managedClusterClientConfigs) {
    if (this.managedClusterClientConfigs != null) {
        this.managedClusterClientConfigs.clear();
        _visitables.remove("managedClusterClientConfigs");
    }
    if (managedClusterClientConfigs != null) {
      for (ClientConfig item : managedClusterClientConfigs) {
        this.addToManagedClusterClientConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withTaints(List<Taint> taints) {
    if (this.taints != null) {
      this._visitables.get("taints").clear();
    }
    if (taints != null) {
        this.taints = new ArrayList();
        for (Taint item : taints) {
          this.addToTaints(item);
        }
    } else {
      this.taints = null;
    }
    return (A) this;
  }
  
  public A withTaints(Taint... taints) {
    if (this.taints != null) {
        this.taints.clear();
        _visitables.remove("taints");
    }
    if (taints != null) {
      for (Taint item : taints) {
        this.addToTaints(item);
      }
    }
    return (A) this;
  }
  public class ManagedClusterClientConfigsNested<N> extends ClientConfigFluent<ManagedClusterClientConfigsNested<N>> implements Nested<N>{
  
    ClientConfigBuilder builder;
    int index;
  
    ManagedClusterClientConfigsNested(int index,ClientConfig item) {
      this.index = index;
      this.builder = new ClientConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ManagedClusterSpecFluent.this.setToManagedClusterClientConfigs(index, builder.build());
    }
    
    public N endManagedClusterClientConfig() {
      return and();
    }
    
  }
  public class TaintsNested<N> extends TaintFluent<TaintsNested<N>> implements Nested<N>{
  
    TaintBuilder builder;
    int index;
  
    TaintsNested(int index,Taint item) {
      this.index = index;
      this.builder = new TaintBuilder(this, item);
    }
  
    public N and() {
      return (N) ManagedClusterSpecFluent.this.setToTaints(index, builder.build());
    }
    
    public N endTaint() {
      return and();
    }
    
  }
}