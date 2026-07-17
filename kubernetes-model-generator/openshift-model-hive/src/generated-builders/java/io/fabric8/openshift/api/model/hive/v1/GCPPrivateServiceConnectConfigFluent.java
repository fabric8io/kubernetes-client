package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class GCPPrivateServiceConnectConfigFluent<A extends io.fabric8.openshift.api.model.hive.v1.GCPPrivateServiceConnectConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private ArrayList<GCPPrivateServiceConnectInventoryBuilder> endpointVPCInventory = new ArrayList<GCPPrivateServiceConnectInventoryBuilder>();

  public GCPPrivateServiceConnectConfigFluent() {
  }
  
  public GCPPrivateServiceConnectConfigFluent(GCPPrivateServiceConnectConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToEndpointVPCInventory(Collection<GCPPrivateServiceConnectInventory> items) {
    if (this.endpointVPCInventory == null) {
      this.endpointVPCInventory = new ArrayList();
    }
    for (GCPPrivateServiceConnectInventory item : items) {
        GCPPrivateServiceConnectInventoryBuilder builder = new GCPPrivateServiceConnectInventoryBuilder(item);
        _visitables.get("endpointVPCInventory").add(builder);
        this.endpointVPCInventory.add(builder);
    }
    return (A) this;
  }
  
  public EndpointVPCInventoryNested<A> addNewEndpointVPCInventory() {
    return new EndpointVPCInventoryNested(-1, null);
  }
  
  public EndpointVPCInventoryNested<A> addNewEndpointVPCInventoryLike(GCPPrivateServiceConnectInventory item) {
    return new EndpointVPCInventoryNested(-1, item);
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
  
  public A addToEndpointVPCInventory(GCPPrivateServiceConnectInventory... items) {
    if (this.endpointVPCInventory == null) {
      this.endpointVPCInventory = new ArrayList();
    }
    for (GCPPrivateServiceConnectInventory item : items) {
        GCPPrivateServiceConnectInventoryBuilder builder = new GCPPrivateServiceConnectInventoryBuilder(item);
        _visitables.get("endpointVPCInventory").add(builder);
        this.endpointVPCInventory.add(builder);
    }
    return (A) this;
  }
  
  public A addToEndpointVPCInventory(int index,GCPPrivateServiceConnectInventory item) {
    if (this.endpointVPCInventory == null) {
      this.endpointVPCInventory = new ArrayList();
    }
    GCPPrivateServiceConnectInventoryBuilder builder = new GCPPrivateServiceConnectInventoryBuilder(item);
    if (index < 0 || index >= endpointVPCInventory.size()) {
        _visitables.get("endpointVPCInventory").add(builder);
        endpointVPCInventory.add(builder);
    } else {
        _visitables.get("endpointVPCInventory").add(builder);
        endpointVPCInventory.add(index, builder);
    }
    return (A) this;
  }
  
  public LocalObjectReference buildCredentialsSecretRef() {
    return this.credentialsSecretRef != null ? this.credentialsSecretRef.build() : null;
  }
  
  public List<GCPPrivateServiceConnectInventory> buildEndpointVPCInventory() {
    return this.endpointVPCInventory != null ? build(endpointVPCInventory) : null;
  }
  
  public GCPPrivateServiceConnectInventory buildEndpointVPCInventory(int index) {
    return this.endpointVPCInventory.get(index).build();
  }
  
  public GCPPrivateServiceConnectInventory buildFirstEndpointVPCInventory() {
    return this.endpointVPCInventory.get(0).build();
  }
  
  public GCPPrivateServiceConnectInventory buildLastEndpointVPCInventory() {
    return this.endpointVPCInventory.get(endpointVPCInventory.size() - 1).build();
  }
  
  public GCPPrivateServiceConnectInventory buildMatchingEndpointVPCInventory(Predicate<GCPPrivateServiceConnectInventoryBuilder> predicate) {
      for (GCPPrivateServiceConnectInventoryBuilder item : endpointVPCInventory) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(GCPPrivateServiceConnectConfig instance) {
    instance = instance != null ? instance : new GCPPrivateServiceConnectConfig();
    if (instance != null) {
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withEndpointVPCInventory(instance.getEndpointVPCInventory());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsSecretRefNested<A> editCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(null));
  }
  
  public EndpointVPCInventoryNested<A> editEndpointVPCInventory(int index) {
    if (endpointVPCInventory.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "endpointVPCInventory"));
    }
    return this.setNewEndpointVPCInventoryLike(index, this.buildEndpointVPCInventory(index));
  }
  
  public EndpointVPCInventoryNested<A> editFirstEndpointVPCInventory() {
    if (endpointVPCInventory.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "endpointVPCInventory"));
    }
    return this.setNewEndpointVPCInventoryLike(0, this.buildEndpointVPCInventory(0));
  }
  
  public EndpointVPCInventoryNested<A> editLastEndpointVPCInventory() {
    int index = endpointVPCInventory.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "endpointVPCInventory"));
    }
    return this.setNewEndpointVPCInventoryLike(index, this.buildEndpointVPCInventory(index));
  }
  
  public EndpointVPCInventoryNested<A> editMatchingEndpointVPCInventory(Predicate<GCPPrivateServiceConnectInventoryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < endpointVPCInventory.size();i++) {
      if (predicate.test(endpointVPCInventory.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "endpointVPCInventory"));
    }
    return this.setNewEndpointVPCInventoryLike(index, this.buildEndpointVPCInventory(index));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRefLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(item));
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
    GCPPrivateServiceConnectConfigFluent that = (GCPPrivateServiceConnectConfigFluent) o;
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(endpointVPCInventory, that.endpointVPCInventory))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCredentialsSecretRef() {
    return this.credentialsSecretRef != null;
  }
  
  public boolean hasEndpointVPCInventory() {
    return this.endpointVPCInventory != null && !(this.endpointVPCInventory.isEmpty());
  }
  
  public boolean hasMatchingEndpointVPCInventory(Predicate<GCPPrivateServiceConnectInventoryBuilder> predicate) {
      for (GCPPrivateServiceConnectInventoryBuilder item : endpointVPCInventory) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(credentialsSecretRef, endpointVPCInventory, additionalProperties);
  }
  
  public A removeAllFromEndpointVPCInventory(Collection<GCPPrivateServiceConnectInventory> items) {
    if (this.endpointVPCInventory == null) {
      return (A) this;
    }
    for (GCPPrivateServiceConnectInventory item : items) {
        GCPPrivateServiceConnectInventoryBuilder builder = new GCPPrivateServiceConnectInventoryBuilder(item);
        _visitables.get("endpointVPCInventory").remove(builder);
        this.endpointVPCInventory.remove(builder);
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
  
  public A removeFromEndpointVPCInventory(GCPPrivateServiceConnectInventory... items) {
    if (this.endpointVPCInventory == null) {
      return (A) this;
    }
    for (GCPPrivateServiceConnectInventory item : items) {
        GCPPrivateServiceConnectInventoryBuilder builder = new GCPPrivateServiceConnectInventoryBuilder(item);
        _visitables.get("endpointVPCInventory").remove(builder);
        this.endpointVPCInventory.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEndpointVPCInventory(Predicate<GCPPrivateServiceConnectInventoryBuilder> predicate) {
    if (endpointVPCInventory == null) {
      return (A) this;
    }
    Iterator<GCPPrivateServiceConnectInventoryBuilder> each = endpointVPCInventory.iterator();
    List visitables = _visitables.get("endpointVPCInventory");
    while (each.hasNext()) {
        GCPPrivateServiceConnectInventoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EndpointVPCInventoryNested<A> setNewEndpointVPCInventoryLike(int index,GCPPrivateServiceConnectInventory item) {
    return new EndpointVPCInventoryNested(index, item);
  }
  
  public A setToEndpointVPCInventory(int index,GCPPrivateServiceConnectInventory item) {
    if (this.endpointVPCInventory == null) {
      this.endpointVPCInventory = new ArrayList();
    }
    GCPPrivateServiceConnectInventoryBuilder builder = new GCPPrivateServiceConnectInventoryBuilder(item);
    if (index < 0 || index >= endpointVPCInventory.size()) {
        _visitables.get("endpointVPCInventory").add(builder);
        endpointVPCInventory.add(builder);
    } else {
        _visitables.get("endpointVPCInventory").add(builder);
        endpointVPCInventory.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(credentialsSecretRef == null)) {
        sb.append("credentialsSecretRef:");
        sb.append(credentialsSecretRef);
        sb.append(",");
    }
    if (!(endpointVPCInventory == null) && !(endpointVPCInventory.isEmpty())) {
        sb.append("endpointVPCInventory:");
        sb.append(endpointVPCInventory);
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
  
  public A withCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
    this._visitables.remove("credentialsSecretRef");
    if (credentialsSecretRef != null) {
        this.credentialsSecretRef = new LocalObjectReferenceBuilder(credentialsSecretRef);
        this._visitables.get("credentialsSecretRef").add(this.credentialsSecretRef);
    } else {
        this.credentialsSecretRef = null;
        this._visitables.get("credentialsSecretRef").remove(this.credentialsSecretRef);
    }
    return (A) this;
  }
  
  public A withEndpointVPCInventory(List<GCPPrivateServiceConnectInventory> endpointVPCInventory) {
    if (this.endpointVPCInventory != null) {
      this._visitables.get("endpointVPCInventory").clear();
    }
    if (endpointVPCInventory != null) {
        this.endpointVPCInventory = new ArrayList();
        for (GCPPrivateServiceConnectInventory item : endpointVPCInventory) {
          this.addToEndpointVPCInventory(item);
        }
    } else {
      this.endpointVPCInventory = null;
    }
    return (A) this;
  }
  
  public A withEndpointVPCInventory(GCPPrivateServiceConnectInventory... endpointVPCInventory) {
    if (this.endpointVPCInventory != null) {
        this.endpointVPCInventory.clear();
        _visitables.remove("endpointVPCInventory");
    }
    if (endpointVPCInventory != null) {
      for (GCPPrivateServiceConnectInventory item : endpointVPCInventory) {
        this.addToEndpointVPCInventory(item);
      }
    }
    return (A) this;
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRef() {
    return new CredentialsSecretRefNested(null);
  }
  
  public A withNewCredentialsSecretRef(String name) {
    return (A) this.withCredentialsSecretRef(new LocalObjectReference(name));
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRefLike(LocalObjectReference item) {
    return new CredentialsSecretRefNested(item);
  }
  public class CredentialsSecretRefNested<N> extends LocalObjectReferenceFluent<CredentialsSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPPrivateServiceConnectConfigFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
  public class EndpointVPCInventoryNested<N> extends GCPPrivateServiceConnectInventoryFluent<EndpointVPCInventoryNested<N>> implements Nested<N>{
  
    GCPPrivateServiceConnectInventoryBuilder builder;
    int index;
  
    EndpointVPCInventoryNested(int index,GCPPrivateServiceConnectInventory item) {
      this.index = index;
      this.builder = new GCPPrivateServiceConnectInventoryBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPPrivateServiceConnectConfigFluent.this.setToEndpointVPCInventory(index, builder.build());
    }
    
    public N endEndpointVPCInventory() {
      return and();
    }
    
  }
}