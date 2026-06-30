package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ISCSIVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.ISCSIVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean chapAuthDiscovery;
  private Boolean chapAuthSession;
  private String fsType;
  private String initiatorName;
  private String iqn;
  private String iscsiInterface;
  private Integer lun;
  private List<String> portals = new ArrayList<String>();
  private Boolean readOnly;
  private LocalObjectReferenceBuilder secretRef;
  private String targetPortal;

  public ISCSIVolumeSourceFluent() {
  }
  
  public ISCSIVolumeSourceFluent(ISCSIVolumeSource instance) {
    this.copyInstance(instance);
  }

  public A addAllToPortals(Collection<String> items) {
    if (this.portals == null) {
      this.portals = new ArrayList();
    }
    for (String item : items) {
      this.portals.add(item);
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
  
  public A addToPortals(String... items) {
    if (this.portals == null) {
      this.portals = new ArrayList();
    }
    for (String item : items) {
      this.portals.add(item);
    }
    return (A) this;
  }
  
  public A addToPortals(int index,String item) {
    if (this.portals == null) {
      this.portals = new ArrayList();
    }
    this.portals.add(index, item);
    return (A) this;
  }
  
  public LocalObjectReference buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  protected void copyInstance(ISCSIVolumeSource instance) {
    instance = instance != null ? instance : new ISCSIVolumeSource();
    if (instance != null) {
        this.withChapAuthDiscovery(instance.getChapAuthDiscovery());
        this.withChapAuthSession(instance.getChapAuthSession());
        this.withFsType(instance.getFsType());
        this.withInitiatorName(instance.getInitiatorName());
        this.withIqn(instance.getIqn());
        this.withIscsiInterface(instance.getIscsiInterface());
        this.withLun(instance.getLun());
        this.withPortals(instance.getPortals());
        this.withReadOnly(instance.getReadOnly());
        this.withSecretRef(instance.getSecretRef());
        this.withTargetPortal(instance.getTargetPortal());
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
    ISCSIVolumeSourceFluent that = (ISCSIVolumeSourceFluent) o;
    if (!(Objects.equals(chapAuthDiscovery, that.chapAuthDiscovery))) {
      return false;
    }
    if (!(Objects.equals(chapAuthSession, that.chapAuthSession))) {
      return false;
    }
    if (!(Objects.equals(fsType, that.fsType))) {
      return false;
    }
    if (!(Objects.equals(initiatorName, that.initiatorName))) {
      return false;
    }
    if (!(Objects.equals(iqn, that.iqn))) {
      return false;
    }
    if (!(Objects.equals(iscsiInterface, that.iscsiInterface))) {
      return false;
    }
    if (!(Objects.equals(lun, that.lun))) {
      return false;
    }
    if (!(Objects.equals(portals, that.portals))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
      return false;
    }
    if (!(Objects.equals(targetPortal, that.targetPortal))) {
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
  
  public Boolean getChapAuthDiscovery() {
    return this.chapAuthDiscovery;
  }
  
  public Boolean getChapAuthSession() {
    return this.chapAuthSession;
  }
  
  public String getFirstPortal() {
    return this.portals.get(0);
  }
  
  public String getFsType() {
    return this.fsType;
  }
  
  public String getInitiatorName() {
    return this.initiatorName;
  }
  
  public String getIqn() {
    return this.iqn;
  }
  
  public String getIscsiInterface() {
    return this.iscsiInterface;
  }
  
  public String getLastPortal() {
    return this.portals.get(portals.size() - 1);
  }
  
  public Integer getLun() {
    return this.lun;
  }
  
  public String getMatchingPortal(Predicate<String> predicate) {
      for (String item : portals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPortal(int index) {
    return this.portals.get(index);
  }
  
  public List<String> getPortals() {
    return this.portals;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public String getTargetPortal() {
    return this.targetPortal;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChapAuthDiscovery() {
    return this.chapAuthDiscovery != null;
  }
  
  public boolean hasChapAuthSession() {
    return this.chapAuthSession != null;
  }
  
  public boolean hasFsType() {
    return this.fsType != null;
  }
  
  public boolean hasInitiatorName() {
    return this.initiatorName != null;
  }
  
  public boolean hasIqn() {
    return this.iqn != null;
  }
  
  public boolean hasIscsiInterface() {
    return this.iscsiInterface != null;
  }
  
  public boolean hasLun() {
    return this.lun != null;
  }
  
  public boolean hasMatchingPortal(Predicate<String> predicate) {
      for (String item : portals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPortals() {
    return this.portals != null && !(this.portals.isEmpty());
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public boolean hasTargetPortal() {
    return this.targetPortal != null;
  }
  
  public int hashCode() {
    return Objects.hash(chapAuthDiscovery, chapAuthSession, fsType, initiatorName, iqn, iscsiInterface, lun, portals, readOnly, secretRef, targetPortal, additionalProperties);
  }
  
  public A removeAllFromPortals(Collection<String> items) {
    if (this.portals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.portals.remove(item);
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
  
  public A removeFromPortals(String... items) {
    if (this.portals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.portals.remove(item);
    }
    return (A) this;
  }
  
  public A setToPortals(int index,String item) {
    if (this.portals == null) {
      this.portals = new ArrayList();
    }
    this.portals.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(chapAuthDiscovery == null)) {
        sb.append("chapAuthDiscovery:");
        sb.append(chapAuthDiscovery);
        sb.append(",");
    }
    if (!(chapAuthSession == null)) {
        sb.append("chapAuthSession:");
        sb.append(chapAuthSession);
        sb.append(",");
    }
    if (!(fsType == null)) {
        sb.append("fsType:");
        sb.append(fsType);
        sb.append(",");
    }
    if (!(initiatorName == null)) {
        sb.append("initiatorName:");
        sb.append(initiatorName);
        sb.append(",");
    }
    if (!(iqn == null)) {
        sb.append("iqn:");
        sb.append(iqn);
        sb.append(",");
    }
    if (!(iscsiInterface == null)) {
        sb.append("iscsiInterface:");
        sb.append(iscsiInterface);
        sb.append(",");
    }
    if (!(lun == null)) {
        sb.append("lun:");
        sb.append(lun);
        sb.append(",");
    }
    if (!(portals == null) && !(portals.isEmpty())) {
        sb.append("portals:");
        sb.append(portals);
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
    if (!(targetPortal == null)) {
        sb.append("targetPortal:");
        sb.append(targetPortal);
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
  
  public A withChapAuthDiscovery() {
    return withChapAuthDiscovery(true);
  }
  
  public A withChapAuthDiscovery(Boolean chapAuthDiscovery) {
    this.chapAuthDiscovery = chapAuthDiscovery;
    return (A) this;
  }
  
  public A withChapAuthSession() {
    return withChapAuthSession(true);
  }
  
  public A withChapAuthSession(Boolean chapAuthSession) {
    this.chapAuthSession = chapAuthSession;
    return (A) this;
  }
  
  public A withFsType(String fsType) {
    this.fsType = fsType;
    return (A) this;
  }
  
  public A withInitiatorName(String initiatorName) {
    this.initiatorName = initiatorName;
    return (A) this;
  }
  
  public A withIqn(String iqn) {
    this.iqn = iqn;
    return (A) this;
  }
  
  public A withIscsiInterface(String iscsiInterface) {
    this.iscsiInterface = iscsiInterface;
    return (A) this;
  }
  
  public A withLun(Integer lun) {
    this.lun = lun;
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
  
  public A withPortals(List<String> portals) {
    if (portals != null) {
        this.portals = new ArrayList();
        for (String item : portals) {
          this.addToPortals(item);
        }
    } else {
      this.portals = null;
    }
    return (A) this;
  }
  
  public A withPortals(String... portals) {
    if (this.portals != null) {
        this.portals.clear();
        _visitables.remove("portals");
    }
    if (portals != null) {
      for (String item : portals) {
        this.addToPortals(item);
      }
    }
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
  
  public A withTargetPortal(String targetPortal) {
    this.targetPortal = targetPortal;
    return (A) this;
  }
  public class SecretRefNested<N> extends LocalObjectReferenceFluent<SecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ISCSIVolumeSourceFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
}