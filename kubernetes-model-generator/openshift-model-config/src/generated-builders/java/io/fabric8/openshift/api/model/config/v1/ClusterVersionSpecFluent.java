package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ClusterVersionSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ClusterVersionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterVersionCapabilitiesSpecBuilder capabilities;
  private String channel;
  private String clusterID;
  private UpdateBuilder desiredUpdate;
  private ArrayList<ComponentOverrideBuilder> overrides = new ArrayList<ComponentOverrideBuilder>();
  private ArrayList<SignatureStoreBuilder> signatureStores = new ArrayList<SignatureStoreBuilder>();
  private String upstream;

  public ClusterVersionSpecFluent() {
  }
  
  public ClusterVersionSpecFluent(ClusterVersionSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToOverrides(Collection<ComponentOverride> items) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    for (ComponentOverride item : items) {
        ComponentOverrideBuilder builder = new ComponentOverrideBuilder(item);
        _visitables.get("overrides").add(builder);
        this.overrides.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSignatureStores(Collection<SignatureStore> items) {
    if (this.signatureStores == null) {
      this.signatureStores = new ArrayList();
    }
    for (SignatureStore item : items) {
        SignatureStoreBuilder builder = new SignatureStoreBuilder(item);
        _visitables.get("signatureStores").add(builder);
        this.signatureStores.add(builder);
    }
    return (A) this;
  }
  
  public OverridesNested<A> addNewOverride() {
    return new OverridesNested(-1, null);
  }
  
  public A addNewOverride(String group,String kind,String name,String namespace,Boolean unmanaged) {
    return (A) this.addToOverrides(new ComponentOverride(group, kind, name, namespace, unmanaged));
  }
  
  public OverridesNested<A> addNewOverrideLike(ComponentOverride item) {
    return new OverridesNested(-1, item);
  }
  
  public SignatureStoresNested<A> addNewSignatureStore() {
    return new SignatureStoresNested(-1, null);
  }
  
  public SignatureStoresNested<A> addNewSignatureStoreLike(SignatureStore item) {
    return new SignatureStoresNested(-1, item);
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
  
  public A addToOverrides(ComponentOverride... items) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    for (ComponentOverride item : items) {
        ComponentOverrideBuilder builder = new ComponentOverrideBuilder(item);
        _visitables.get("overrides").add(builder);
        this.overrides.add(builder);
    }
    return (A) this;
  }
  
  public A addToOverrides(int index,ComponentOverride item) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    ComponentOverrideBuilder builder = new ComponentOverrideBuilder(item);
    if (index < 0 || index >= overrides.size()) {
        _visitables.get("overrides").add(builder);
        overrides.add(builder);
    } else {
        _visitables.get("overrides").add(builder);
        overrides.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSignatureStores(SignatureStore... items) {
    if (this.signatureStores == null) {
      this.signatureStores = new ArrayList();
    }
    for (SignatureStore item : items) {
        SignatureStoreBuilder builder = new SignatureStoreBuilder(item);
        _visitables.get("signatureStores").add(builder);
        this.signatureStores.add(builder);
    }
    return (A) this;
  }
  
  public A addToSignatureStores(int index,SignatureStore item) {
    if (this.signatureStores == null) {
      this.signatureStores = new ArrayList();
    }
    SignatureStoreBuilder builder = new SignatureStoreBuilder(item);
    if (index < 0 || index >= signatureStores.size()) {
        _visitables.get("signatureStores").add(builder);
        signatureStores.add(builder);
    } else {
        _visitables.get("signatureStores").add(builder);
        signatureStores.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterVersionCapabilitiesSpec buildCapabilities() {
    return this.capabilities != null ? this.capabilities.build() : null;
  }
  
  public Update buildDesiredUpdate() {
    return this.desiredUpdate != null ? this.desiredUpdate.build() : null;
  }
  
  public ComponentOverride buildFirstOverride() {
    return this.overrides.get(0).build();
  }
  
  public SignatureStore buildFirstSignatureStore() {
    return this.signatureStores.get(0).build();
  }
  
  public ComponentOverride buildLastOverride() {
    return this.overrides.get(overrides.size() - 1).build();
  }
  
  public SignatureStore buildLastSignatureStore() {
    return this.signatureStores.get(signatureStores.size() - 1).build();
  }
  
  public ComponentOverride buildMatchingOverride(Predicate<ComponentOverrideBuilder> predicate) {
      for (ComponentOverrideBuilder item : overrides) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SignatureStore buildMatchingSignatureStore(Predicate<SignatureStoreBuilder> predicate) {
      for (SignatureStoreBuilder item : signatureStores) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ComponentOverride buildOverride(int index) {
    return this.overrides.get(index).build();
  }
  
  public List<ComponentOverride> buildOverrides() {
    return this.overrides != null ? build(overrides) : null;
  }
  
  public SignatureStore buildSignatureStore(int index) {
    return this.signatureStores.get(index).build();
  }
  
  public List<SignatureStore> buildSignatureStores() {
    return this.signatureStores != null ? build(signatureStores) : null;
  }
  
  protected void copyInstance(ClusterVersionSpec instance) {
    instance = instance != null ? instance : new ClusterVersionSpec();
    if (instance != null) {
        this.withCapabilities(instance.getCapabilities());
        this.withChannel(instance.getChannel());
        this.withClusterID(instance.getClusterID());
        this.withDesiredUpdate(instance.getDesiredUpdate());
        this.withOverrides(instance.getOverrides());
        this.withSignatureStores(instance.getSignatureStores());
        this.withUpstream(instance.getUpstream());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CapabilitiesNested<A> editCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(null));
  }
  
  public DesiredUpdateNested<A> editDesiredUpdate() {
    return this.withNewDesiredUpdateLike(Optional.ofNullable(this.buildDesiredUpdate()).orElse(null));
  }
  
  public OverridesNested<A> editFirstOverride() {
    if (overrides.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "overrides"));
    }
    return this.setNewOverrideLike(0, this.buildOverride(0));
  }
  
  public SignatureStoresNested<A> editFirstSignatureStore() {
    if (signatureStores.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "signatureStores"));
    }
    return this.setNewSignatureStoreLike(0, this.buildSignatureStore(0));
  }
  
  public OverridesNested<A> editLastOverride() {
    int index = overrides.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
  }
  
  public SignatureStoresNested<A> editLastSignatureStore() {
    int index = signatureStores.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "signatureStores"));
    }
    return this.setNewSignatureStoreLike(index, this.buildSignatureStore(index));
  }
  
  public OverridesNested<A> editMatchingOverride(Predicate<ComponentOverrideBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < overrides.size();i++) {
      if (predicate.test(overrides.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
  }
  
  public SignatureStoresNested<A> editMatchingSignatureStore(Predicate<SignatureStoreBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < signatureStores.size();i++) {
      if (predicate.test(signatureStores.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "signatureStores"));
    }
    return this.setNewSignatureStoreLike(index, this.buildSignatureStore(index));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(new ClusterVersionCapabilitiesSpecBuilder().build()));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilitiesLike(ClusterVersionCapabilitiesSpec item) {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(item));
  }
  
  public DesiredUpdateNested<A> editOrNewDesiredUpdate() {
    return this.withNewDesiredUpdateLike(Optional.ofNullable(this.buildDesiredUpdate()).orElse(new UpdateBuilder().build()));
  }
  
  public DesiredUpdateNested<A> editOrNewDesiredUpdateLike(Update item) {
    return this.withNewDesiredUpdateLike(Optional.ofNullable(this.buildDesiredUpdate()).orElse(item));
  }
  
  public OverridesNested<A> editOverride(int index) {
    if (overrides.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
  }
  
  public SignatureStoresNested<A> editSignatureStore(int index) {
    if (signatureStores.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "signatureStores"));
    }
    return this.setNewSignatureStoreLike(index, this.buildSignatureStore(index));
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
    ClusterVersionSpecFluent that = (ClusterVersionSpecFluent) o;
    if (!(Objects.equals(capabilities, that.capabilities))) {
      return false;
    }
    if (!(Objects.equals(channel, that.channel))) {
      return false;
    }
    if (!(Objects.equals(clusterID, that.clusterID))) {
      return false;
    }
    if (!(Objects.equals(desiredUpdate, that.desiredUpdate))) {
      return false;
    }
    if (!(Objects.equals(overrides, that.overrides))) {
      return false;
    }
    if (!(Objects.equals(signatureStores, that.signatureStores))) {
      return false;
    }
    if (!(Objects.equals(upstream, that.upstream))) {
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
  
  public String getChannel() {
    return this.channel;
  }
  
  public String getClusterID() {
    return this.clusterID;
  }
  
  public String getUpstream() {
    return this.upstream;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCapabilities() {
    return this.capabilities != null;
  }
  
  public boolean hasChannel() {
    return this.channel != null;
  }
  
  public boolean hasClusterID() {
    return this.clusterID != null;
  }
  
  public boolean hasDesiredUpdate() {
    return this.desiredUpdate != null;
  }
  
  public boolean hasMatchingOverride(Predicate<ComponentOverrideBuilder> predicate) {
      for (ComponentOverrideBuilder item : overrides) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSignatureStore(Predicate<SignatureStoreBuilder> predicate) {
      for (SignatureStoreBuilder item : signatureStores) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOverrides() {
    return this.overrides != null && !(this.overrides.isEmpty());
  }
  
  public boolean hasSignatureStores() {
    return this.signatureStores != null && !(this.signatureStores.isEmpty());
  }
  
  public boolean hasUpstream() {
    return this.upstream != null;
  }
  
  public int hashCode() {
    return Objects.hash(capabilities, channel, clusterID, desiredUpdate, overrides, signatureStores, upstream, additionalProperties);
  }
  
  public A removeAllFromOverrides(Collection<ComponentOverride> items) {
    if (this.overrides == null) {
      return (A) this;
    }
    for (ComponentOverride item : items) {
        ComponentOverrideBuilder builder = new ComponentOverrideBuilder(item);
        _visitables.get("overrides").remove(builder);
        this.overrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSignatureStores(Collection<SignatureStore> items) {
    if (this.signatureStores == null) {
      return (A) this;
    }
    for (SignatureStore item : items) {
        SignatureStoreBuilder builder = new SignatureStoreBuilder(item);
        _visitables.get("signatureStores").remove(builder);
        this.signatureStores.remove(builder);
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
  
  public A removeFromOverrides(ComponentOverride... items) {
    if (this.overrides == null) {
      return (A) this;
    }
    for (ComponentOverride item : items) {
        ComponentOverrideBuilder builder = new ComponentOverrideBuilder(item);
        _visitables.get("overrides").remove(builder);
        this.overrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSignatureStores(SignatureStore... items) {
    if (this.signatureStores == null) {
      return (A) this;
    }
    for (SignatureStore item : items) {
        SignatureStoreBuilder builder = new SignatureStoreBuilder(item);
        _visitables.get("signatureStores").remove(builder);
        this.signatureStores.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromOverrides(Predicate<ComponentOverrideBuilder> predicate) {
    if (overrides == null) {
      return (A) this;
    }
    Iterator<ComponentOverrideBuilder> each = overrides.iterator();
    List visitables = _visitables.get("overrides");
    while (each.hasNext()) {
        ComponentOverrideBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSignatureStores(Predicate<SignatureStoreBuilder> predicate) {
    if (signatureStores == null) {
      return (A) this;
    }
    Iterator<SignatureStoreBuilder> each = signatureStores.iterator();
    List visitables = _visitables.get("signatureStores");
    while (each.hasNext()) {
        SignatureStoreBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public OverridesNested<A> setNewOverrideLike(int index,ComponentOverride item) {
    return new OverridesNested(index, item);
  }
  
  public SignatureStoresNested<A> setNewSignatureStoreLike(int index,SignatureStore item) {
    return new SignatureStoresNested(index, item);
  }
  
  public A setToOverrides(int index,ComponentOverride item) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    ComponentOverrideBuilder builder = new ComponentOverrideBuilder(item);
    if (index < 0 || index >= overrides.size()) {
        _visitables.get("overrides").add(builder);
        overrides.add(builder);
    } else {
        _visitables.get("overrides").add(builder);
        overrides.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSignatureStores(int index,SignatureStore item) {
    if (this.signatureStores == null) {
      this.signatureStores = new ArrayList();
    }
    SignatureStoreBuilder builder = new SignatureStoreBuilder(item);
    if (index < 0 || index >= signatureStores.size()) {
        _visitables.get("signatureStores").add(builder);
        signatureStores.add(builder);
    } else {
        _visitables.get("signatureStores").add(builder);
        signatureStores.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(capabilities == null)) {
        sb.append("capabilities:");
        sb.append(capabilities);
        sb.append(",");
    }
    if (!(channel == null)) {
        sb.append("channel:");
        sb.append(channel);
        sb.append(",");
    }
    if (!(clusterID == null)) {
        sb.append("clusterID:");
        sb.append(clusterID);
        sb.append(",");
    }
    if (!(desiredUpdate == null)) {
        sb.append("desiredUpdate:");
        sb.append(desiredUpdate);
        sb.append(",");
    }
    if (!(overrides == null) && !(overrides.isEmpty())) {
        sb.append("overrides:");
        sb.append(overrides);
        sb.append(",");
    }
    if (!(signatureStores == null) && !(signatureStores.isEmpty())) {
        sb.append("signatureStores:");
        sb.append(signatureStores);
        sb.append(",");
    }
    if (!(upstream == null)) {
        sb.append("upstream:");
        sb.append(upstream);
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
  
  public A withCapabilities(ClusterVersionCapabilitiesSpec capabilities) {
    this._visitables.remove("capabilities");
    if (capabilities != null) {
        this.capabilities = new ClusterVersionCapabilitiesSpecBuilder(capabilities);
        this._visitables.get("capabilities").add(this.capabilities);
    } else {
        this.capabilities = null;
        this._visitables.get("capabilities").remove(this.capabilities);
    }
    return (A) this;
  }
  
  public A withChannel(String channel) {
    this.channel = channel;
    return (A) this;
  }
  
  public A withClusterID(String clusterID) {
    this.clusterID = clusterID;
    return (A) this;
  }
  
  public A withDesiredUpdate(Update desiredUpdate) {
    this._visitables.remove("desiredUpdate");
    if (desiredUpdate != null) {
        this.desiredUpdate = new UpdateBuilder(desiredUpdate);
        this._visitables.get("desiredUpdate").add(this.desiredUpdate);
    } else {
        this.desiredUpdate = null;
        this._visitables.get("desiredUpdate").remove(this.desiredUpdate);
    }
    return (A) this;
  }
  
  public CapabilitiesNested<A> withNewCapabilities() {
    return new CapabilitiesNested(null);
  }
  
  public CapabilitiesNested<A> withNewCapabilitiesLike(ClusterVersionCapabilitiesSpec item) {
    return new CapabilitiesNested(item);
  }
  
  public DesiredUpdateNested<A> withNewDesiredUpdate() {
    return new DesiredUpdateNested(null);
  }
  
  public A withNewDesiredUpdate(String architecture,Boolean force,String image,String version) {
    return (A) this.withDesiredUpdate(new Update(architecture, force, image, version));
  }
  
  public DesiredUpdateNested<A> withNewDesiredUpdateLike(Update item) {
    return new DesiredUpdateNested(item);
  }
  
  public A withOverrides(List<ComponentOverride> overrides) {
    if (this.overrides != null) {
      this._visitables.get("overrides").clear();
    }
    if (overrides != null) {
        this.overrides = new ArrayList();
        for (ComponentOverride item : overrides) {
          this.addToOverrides(item);
        }
    } else {
      this.overrides = null;
    }
    return (A) this;
  }
  
  public A withOverrides(ComponentOverride... overrides) {
    if (this.overrides != null) {
        this.overrides.clear();
        _visitables.remove("overrides");
    }
    if (overrides != null) {
      for (ComponentOverride item : overrides) {
        this.addToOverrides(item);
      }
    }
    return (A) this;
  }
  
  public A withSignatureStores(List<SignatureStore> signatureStores) {
    if (this.signatureStores != null) {
      this._visitables.get("signatureStores").clear();
    }
    if (signatureStores != null) {
        this.signatureStores = new ArrayList();
        for (SignatureStore item : signatureStores) {
          this.addToSignatureStores(item);
        }
    } else {
      this.signatureStores = null;
    }
    return (A) this;
  }
  
  public A withSignatureStores(SignatureStore... signatureStores) {
    if (this.signatureStores != null) {
        this.signatureStores.clear();
        _visitables.remove("signatureStores");
    }
    if (signatureStores != null) {
      for (SignatureStore item : signatureStores) {
        this.addToSignatureStores(item);
      }
    }
    return (A) this;
  }
  
  public A withUpstream(String upstream) {
    this.upstream = upstream;
    return (A) this;
  }
  public class CapabilitiesNested<N> extends ClusterVersionCapabilitiesSpecFluent<CapabilitiesNested<N>> implements Nested<N>{
  
    ClusterVersionCapabilitiesSpecBuilder builder;
  
    CapabilitiesNested(ClusterVersionCapabilitiesSpec item) {
      this.builder = new ClusterVersionCapabilitiesSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionSpecFluent.this.withCapabilities(builder.build());
    }
    
    public N endCapabilities() {
      return and();
    }
    
  }
  public class DesiredUpdateNested<N> extends UpdateFluent<DesiredUpdateNested<N>> implements Nested<N>{
  
    UpdateBuilder builder;
  
    DesiredUpdateNested(Update item) {
      this.builder = new UpdateBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionSpecFluent.this.withDesiredUpdate(builder.build());
    }
    
    public N endDesiredUpdate() {
      return and();
    }
    
  }
  public class OverridesNested<N> extends ComponentOverrideFluent<OverridesNested<N>> implements Nested<N>{
  
    ComponentOverrideBuilder builder;
    int index;
  
    OverridesNested(int index,ComponentOverride item) {
      this.index = index;
      this.builder = new ComponentOverrideBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionSpecFluent.this.setToOverrides(index, builder.build());
    }
    
    public N endOverride() {
      return and();
    }
    
  }
  public class SignatureStoresNested<N> extends SignatureStoreFluent<SignatureStoresNested<N>> implements Nested<N>{
  
    SignatureStoreBuilder builder;
    int index;
  
    SignatureStoresNested(int index,SignatureStore item) {
      this.index = index;
      this.builder = new SignatureStoreBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionSpecFluent.this.setToSignatureStores(index, builder.build());
    }
    
    public N endSignatureStore() {
      return and();
    }
    
  }
}