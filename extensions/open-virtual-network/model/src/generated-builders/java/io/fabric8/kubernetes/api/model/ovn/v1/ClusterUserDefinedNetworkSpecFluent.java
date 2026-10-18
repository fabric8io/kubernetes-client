package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class ClusterUserDefinedNetworkSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.ClusterUserDefinedNetworkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder namespaceSelector;
  private NetworkSpecBuilder network;
  private List<String> uplinks = new ArrayList<String>();

  public ClusterUserDefinedNetworkSpecFluent() {
  }
  
  public ClusterUserDefinedNetworkSpecFluent(ClusterUserDefinedNetworkSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToUplinks(Collection<String> items) {
    if (this.uplinks == null) {
      this.uplinks = new ArrayList();
    }
    for (String item : items) {
      this.uplinks.add(item);
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
  
  public A addToUplinks(String... items) {
    if (this.uplinks == null) {
      this.uplinks = new ArrayList();
    }
    for (String item : items) {
      this.uplinks.add(item);
    }
    return (A) this;
  }
  
  public A addToUplinks(int index,String item) {
    if (this.uplinks == null) {
      this.uplinks = new ArrayList();
    }
    this.uplinks.add(index, item);
    return (A) this;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public NetworkSpec buildNetwork() {
    return this.network != null ? this.network.build() : null;
  }
  
  protected void copyInstance(ClusterUserDefinedNetworkSpec instance) {
    instance = instance != null ? instance : new ClusterUserDefinedNetworkSpec();
    if (instance != null) {
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withNetwork(instance.getNetwork());
        this.withUplinks(instance.getUplinks());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public NetworkNested<A> editNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(null));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public NetworkNested<A> editOrNewNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(new NetworkSpecBuilder().build()));
  }
  
  public NetworkNested<A> editOrNewNetworkLike(NetworkSpec item) {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(item));
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
    ClusterUserDefinedNetworkSpecFluent that = (ClusterUserDefinedNetworkSpecFluent) o;
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(uplinks, that.uplinks))) {
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
  
  public String getFirstUplink() {
    return this.uplinks.get(0);
  }
  
  public String getLastUplink() {
    return this.uplinks.get(uplinks.size() - 1);
  }
  
  public String getMatchingUplink(Predicate<String> predicate) {
      for (String item : uplinks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getUplink(int index) {
    return this.uplinks.get(index);
  }
  
  public List<String> getUplinks() {
    return this.uplinks;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingUplink(Predicate<String> predicate) {
      for (String item : uplinks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasUplinks() {
    return this.uplinks != null && !(this.uplinks.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(namespaceSelector, network, uplinks, additionalProperties);
  }
  
  public A removeAllFromUplinks(Collection<String> items) {
    if (this.uplinks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.uplinks.remove(item);
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
  
  public A removeFromUplinks(String... items) {
    if (this.uplinks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.uplinks.remove(item);
    }
    return (A) this;
  }
  
  public A setToUplinks(int index,String item) {
    if (this.uplinks == null) {
      this.uplinks = new ArrayList();
    }
    this.uplinks.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(uplinks == null) && !(uplinks.isEmpty())) {
        sb.append("uplinks:");
        sb.append(uplinks);
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
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public A withNetwork(NetworkSpec network) {
    this._visitables.remove("network");
    if (network != null) {
        this.network = new NetworkSpecBuilder(network);
        this._visitables.get("network").add(this.network);
    } else {
        this.network = null;
        this._visitables.get("network").remove(this.network);
    }
    return (A) this;
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public NetworkNested<A> withNewNetwork() {
    return new NetworkNested(null);
  }
  
  public NetworkNested<A> withNewNetworkLike(NetworkSpec item) {
    return new NetworkNested(item);
  }
  
  public A withUplinks(List<String> uplinks) {
    if (uplinks != null) {
        this.uplinks = new ArrayList();
        for (String item : uplinks) {
          this.addToUplinks(item);
        }
    } else {
      this.uplinks = null;
    }
    return (A) this;
  }
  
  public A withUplinks(String... uplinks) {
    if (this.uplinks != null) {
        this.uplinks.clear();
        _visitables.remove("uplinks");
    }
    if (uplinks != null) {
      for (String item : uplinks) {
        this.addToUplinks(item);
      }
    }
    return (A) this;
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterUserDefinedNetworkSpecFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class NetworkNested<N> extends NetworkSpecFluent<NetworkNested<N>> implements Nested<N>{
  
    NetworkSpecBuilder builder;
  
    NetworkNested(NetworkSpec item) {
      this.builder = new NetworkSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterUserDefinedNetworkSpecFluent.this.withNetwork(builder.build());
    }
    
    public N endNetwork() {
      return and();
    }
    
  }
}