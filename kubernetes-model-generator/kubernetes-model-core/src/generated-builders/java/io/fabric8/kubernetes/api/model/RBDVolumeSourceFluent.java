package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class RBDVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.RBDVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fsType;
  private String image;
  private String keyring;
  private List<String> monitors = new ArrayList<String>();
  private String pool;
  private Boolean readOnly;
  private LocalObjectReferenceBuilder secretRef;
  private String user;

  public RBDVolumeSourceFluent() {
  }
  
  public RBDVolumeSourceFluent(RBDVolumeSource instance) {
    this.copyInstance(instance);
  }

  public A addAllToMonitors(Collection<String> items) {
    if (this.monitors == null) {
      this.monitors = new ArrayList();
    }
    for (String item : items) {
      this.monitors.add(item);
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
  
  public A addToMonitors(String... items) {
    if (this.monitors == null) {
      this.monitors = new ArrayList();
    }
    for (String item : items) {
      this.monitors.add(item);
    }
    return (A) this;
  }
  
  public A addToMonitors(int index,String item) {
    if (this.monitors == null) {
      this.monitors = new ArrayList();
    }
    this.monitors.add(index, item);
    return (A) this;
  }
  
  public LocalObjectReference buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  protected void copyInstance(RBDVolumeSource instance) {
    instance = instance != null ? instance : new RBDVolumeSource();
    if (instance != null) {
        this.withFsType(instance.getFsType());
        this.withImage(instance.getImage());
        this.withKeyring(instance.getKeyring());
        this.withMonitors(instance.getMonitors());
        this.withPool(instance.getPool());
        this.withReadOnly(instance.getReadOnly());
        this.withSecretRef(instance.getSecretRef());
        this.withUser(instance.getUser());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretRefNested<A> editOrNewSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public SecretRefNested<A> editOrNewSecretRefLike(LocalObjectReference item) {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(item));
  }
  
  public SecretRefNested<A> editSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(null));
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
    RBDVolumeSourceFluent that = (RBDVolumeSourceFluent) o;
    if (!(Objects.equals(fsType, that.fsType))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(keyring, that.keyring))) {
      return false;
    }
    if (!(Objects.equals(monitors, that.monitors))) {
      return false;
    }
    if (!(Objects.equals(pool, that.pool))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
      return false;
    }
    if (!(Objects.equals(user, that.user))) {
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
  
  public String getFirstMonitor() {
    return this.monitors.get(0);
  }
  
  public String getFsType() {
    return this.fsType;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getKeyring() {
    return this.keyring;
  }
  
  public String getLastMonitor() {
    return this.monitors.get(monitors.size() - 1);
  }
  
  public String getMatchingMonitor(Predicate<String> predicate) {
      for (String item : monitors) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMonitor(int index) {
    return this.monitors.get(index);
  }
  
  public List<String> getMonitors() {
    return this.monitors;
  }
  
  public String getPool() {
    return this.pool;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public String getUser() {
    return this.user;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFsType() {
    return this.fsType != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasKeyring() {
    return this.keyring != null;
  }
  
  public boolean hasMatchingMonitor(Predicate<String> predicate) {
      for (String item : monitors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMonitors() {
    return this.monitors != null && !(this.monitors.isEmpty());
  }
  
  public boolean hasPool() {
    return this.pool != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public boolean hasUser() {
    return this.user != null;
  }
  
  public int hashCode() {
    return Objects.hash(fsType, image, keyring, monitors, pool, readOnly, secretRef, user, additionalProperties);
  }
  
  public A removeAllFromMonitors(Collection<String> items) {
    if (this.monitors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.monitors.remove(item);
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
  
  public A removeFromMonitors(String... items) {
    if (this.monitors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.monitors.remove(item);
    }
    return (A) this;
  }
  
  public A setToMonitors(int index,String item) {
    if (this.monitors == null) {
      this.monitors = new ArrayList();
    }
    this.monitors.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(fsType == null)) {
        sb.append("fsType:");
        sb.append(fsType);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(keyring == null)) {
        sb.append("keyring:");
        sb.append(keyring);
        sb.append(",");
    }
    if (!(monitors == null) && !(monitors.isEmpty())) {
        sb.append("monitors:");
        sb.append(monitors);
        sb.append(",");
    }
    if (!(pool == null)) {
        sb.append("pool:");
        sb.append(pool);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(secretRef == null)) {
        sb.append("secretRef:");
        sb.append(secretRef);
        sb.append(",");
    }
    if (!(user == null)) {
        sb.append("user:");
        sb.append(user);
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
  
  public A withFsType(String fsType) {
    this.fsType = fsType;
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withKeyring(String keyring) {
    this.keyring = keyring;
    return (A) this;
  }
  
  public A withMonitors(List<String> monitors) {
    if (monitors != null) {
        this.monitors = new ArrayList();
        for (String item : monitors) {
          this.addToMonitors(item);
        }
    } else {
      this.monitors = null;
    }
    return (A) this;
  }
  
  public A withMonitors(String... monitors) {
    if (this.monitors != null) {
        this.monitors.clear();
        _visitables.remove("monitors");
    }
    if (monitors != null) {
      for (String item : monitors) {
        this.addToMonitors(item);
      }
    }
    return (A) this;
  }
  
  public SecretRefNested<A> withNewSecretRef() {
    return new SecretRefNested(null);
  }
  
  public A withNewSecretRef(String name) {
    return (A) this.withSecretRef(new LocalObjectReference(name));
  }
  
  public SecretRefNested<A> withNewSecretRefLike(LocalObjectReference item) {
    return new SecretRefNested(item);
  }
  
  public A withPool(String pool) {
    this.pool = pool;
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public A withSecretRef(LocalObjectReference secretRef) {
    this._visitables.remove("secretRef");
    if (secretRef != null) {
        this.secretRef = new LocalObjectReferenceBuilder(secretRef);
        this._visitables.get("secretRef").add(this.secretRef);
    } else {
        this.secretRef = null;
        this._visitables.get("secretRef").remove(this.secretRef);
    }
    return (A) this;
  }
  
  public A withUser(String user) {
    this.user = user;
    return (A) this;
  }
  public class SecretRefNested<N> extends LocalObjectReferenceFluent<SecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) RBDVolumeSourceFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
}