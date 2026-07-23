package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Taint;
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
public class MachineSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.MachineSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authoritativeAPI;
  private LifecycleHooksBuilder lifecycleHooks;
  private ObjectMetaBuilder metadata;
  private String providerID;
  private ProviderSpecBuilder providerSpec;
  private List<Taint> taints = new ArrayList<Taint>();

  public MachineSpecFluent() {
  }
  
  public MachineSpecFluent(MachineSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTaints(Collection<Taint> items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
      this.taints.add(item);
    }
    return (A) this;
  }
  
  public A addNewTaint(String effect,String key,String timeAdded,String value) {
    return (A) this.addToTaints(new Taint(effect, key, timeAdded, value));
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
  
  public A addToTaints(Taint... items) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    for (Taint item : items) {
      this.taints.add(item);
    }
    return (A) this;
  }
  
  public A addToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    this.taints.add(index, item);
    return (A) this;
  }
  
  public LifecycleHooks buildLifecycleHooks() {
    return this.lifecycleHooks != null ? this.lifecycleHooks.build() : null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ProviderSpec buildProviderSpec() {
    return this.providerSpec != null ? this.providerSpec.build() : null;
  }
  
  protected void copyInstance(MachineSpec instance) {
    instance = instance != null ? instance : new MachineSpec();
    if (instance != null) {
        this.withAuthoritativeAPI(instance.getAuthoritativeAPI());
        this.withLifecycleHooks(instance.getLifecycleHooks());
        this.withMetadata(instance.getMetadata());
        this.withProviderID(instance.getProviderID());
        this.withProviderSpec(instance.getProviderSpec());
        this.withTaints(instance.getTaints());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LifecycleHooksNested<A> editLifecycleHooks() {
    return this.withNewLifecycleHooksLike(Optional.ofNullable(this.buildLifecycleHooks()).orElse(null));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public LifecycleHooksNested<A> editOrNewLifecycleHooks() {
    return this.withNewLifecycleHooksLike(Optional.ofNullable(this.buildLifecycleHooks()).orElse(new LifecycleHooksBuilder().build()));
  }
  
  public LifecycleHooksNested<A> editOrNewLifecycleHooksLike(LifecycleHooks item) {
    return this.withNewLifecycleHooksLike(Optional.ofNullable(this.buildLifecycleHooks()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public ProviderSpecNested<A> editOrNewProviderSpec() {
    return this.withNewProviderSpecLike(Optional.ofNullable(this.buildProviderSpec()).orElse(new ProviderSpecBuilder().build()));
  }
  
  public ProviderSpecNested<A> editOrNewProviderSpecLike(ProviderSpec item) {
    return this.withNewProviderSpecLike(Optional.ofNullable(this.buildProviderSpec()).orElse(item));
  }
  
  public ProviderSpecNested<A> editProviderSpec() {
    return this.withNewProviderSpecLike(Optional.ofNullable(this.buildProviderSpec()).orElse(null));
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
    MachineSpecFluent that = (MachineSpecFluent) o;
    if (!(Objects.equals(authoritativeAPI, that.authoritativeAPI))) {
      return false;
    }
    if (!(Objects.equals(lifecycleHooks, that.lifecycleHooks))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(providerID, that.providerID))) {
      return false;
    }
    if (!(Objects.equals(providerSpec, that.providerSpec))) {
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
  
  public String getAuthoritativeAPI() {
    return this.authoritativeAPI;
  }
  
  public Taint getFirstTaint() {
    return this.taints.get(0);
  }
  
  public Taint getLastTaint() {
    return this.taints.get(taints.size() - 1);
  }
  
  public Taint getMatchingTaint(Predicate<Taint> predicate) {
      for (Taint item : taints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getProviderID() {
    return this.providerID;
  }
  
  public Taint getTaint(int index) {
    return this.taints.get(index);
  }
  
  public List<Taint> getTaints() {
    return this.taints;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthoritativeAPI() {
    return this.authoritativeAPI != null;
  }
  
  public boolean hasLifecycleHooks() {
    return this.lifecycleHooks != null;
  }
  
  public boolean hasMatchingTaint(Predicate<Taint> predicate) {
      for (Taint item : taints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasProviderID() {
    return this.providerID != null;
  }
  
  public boolean hasProviderSpec() {
    return this.providerSpec != null;
  }
  
  public boolean hasTaints() {
    return this.taints != null && !(this.taints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(authoritativeAPI, lifecycleHooks, metadata, providerID, providerSpec, taints, additionalProperties);
  }
  
  public A removeAllFromTaints(Collection<Taint> items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
      this.taints.remove(item);
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
  
  public A removeFromTaints(Taint... items) {
    if (this.taints == null) {
      return (A) this;
    }
    for (Taint item : items) {
      this.taints.remove(item);
    }
    return (A) this;
  }
  
  public A setToTaints(int index,Taint item) {
    if (this.taints == null) {
      this.taints = new ArrayList();
    }
    this.taints.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authoritativeAPI == null)) {
        sb.append("authoritativeAPI:");
        sb.append(authoritativeAPI);
        sb.append(",");
    }
    if (!(lifecycleHooks == null)) {
        sb.append("lifecycleHooks:");
        sb.append(lifecycleHooks);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(providerID == null)) {
        sb.append("providerID:");
        sb.append(providerID);
        sb.append(",");
    }
    if (!(providerSpec == null)) {
        sb.append("providerSpec:");
        sb.append(providerSpec);
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
  
  public A withAuthoritativeAPI(String authoritativeAPI) {
    this.authoritativeAPI = authoritativeAPI;
    return (A) this;
  }
  
  public A withLifecycleHooks(LifecycleHooks lifecycleHooks) {
    this._visitables.remove("lifecycleHooks");
    if (lifecycleHooks != null) {
        this.lifecycleHooks = new LifecycleHooksBuilder(lifecycleHooks);
        this._visitables.get("lifecycleHooks").add(this.lifecycleHooks);
    } else {
        this.lifecycleHooks = null;
        this._visitables.get("lifecycleHooks").remove(this.lifecycleHooks);
    }
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public LifecycleHooksNested<A> withNewLifecycleHooks() {
    return new LifecycleHooksNested(null);
  }
  
  public LifecycleHooksNested<A> withNewLifecycleHooksLike(LifecycleHooks item) {
    return new LifecycleHooksNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public ProviderSpecNested<A> withNewProviderSpec() {
    return new ProviderSpecNested(null);
  }
  
  public A withNewProviderSpec(Object value) {
    return (A) this.withProviderSpec(new ProviderSpec(value));
  }
  
  public ProviderSpecNested<A> withNewProviderSpecLike(ProviderSpec item) {
    return new ProviderSpecNested(item);
  }
  
  public A withProviderID(String providerID) {
    this.providerID = providerID;
    return (A) this;
  }
  
  public A withProviderSpec(ProviderSpec providerSpec) {
    this._visitables.remove("providerSpec");
    if (providerSpec != null) {
        this.providerSpec = new ProviderSpecBuilder(providerSpec);
        this._visitables.get("providerSpec").add(this.providerSpec);
    } else {
        this.providerSpec = null;
        this._visitables.get("providerSpec").remove(this.providerSpec);
    }
    return (A) this;
  }
  
  public A withTaints(List<Taint> taints) {
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
  public class LifecycleHooksNested<N> extends LifecycleHooksFluent<LifecycleHooksNested<N>> implements Nested<N>{
  
    LifecycleHooksBuilder builder;
  
    LifecycleHooksNested(LifecycleHooks item) {
      this.builder = new LifecycleHooksBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineSpecFluent.this.withLifecycleHooks(builder.build());
    }
    
    public N endLifecycleHooks() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineSpecFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class ProviderSpecNested<N> extends ProviderSpecFluent<ProviderSpecNested<N>> implements Nested<N>{
  
    ProviderSpecBuilder builder;
  
    ProviderSpecNested(ProviderSpec item) {
      this.builder = new ProviderSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineSpecFluent.this.withProviderSpec(builder.build());
    }
    
    public N endProviderSpec() {
      return and();
    }
    
  }
}