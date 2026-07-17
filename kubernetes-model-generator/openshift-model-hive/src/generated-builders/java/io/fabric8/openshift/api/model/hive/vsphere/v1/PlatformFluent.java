package io.fabric8.openshift.api.model.hive.vsphere.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PlatformFluent<A extends io.fabric8.openshift.api.model.hive.vsphere.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder certificatesSecretRef;
  private String cluster;
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private String datacenter;
  private String defaultDatastore;
  private String folder;
  private String network;
  private String vCenter;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
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
  
  public LocalObjectReference buildCertificatesSecretRef() {
    return this.certificatesSecretRef != null ? this.certificatesSecretRef.build() : null;
  }
  
  public LocalObjectReference buildCredentialsSecretRef() {
    return this.credentialsSecretRef != null ? this.credentialsSecretRef.build() : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withCertificatesSecretRef(instance.getCertificatesSecretRef());
        this.withCluster(instance.getCluster());
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withDatacenter(instance.getDatacenter());
        this.withDefaultDatastore(instance.getDefaultDatastore());
        this.withFolder(instance.getFolder());
        this.withNetwork(instance.getNetwork());
        this.withVCenter(instance.getVCenter());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CertificatesSecretRefNested<A> editCertificatesSecretRef() {
    return this.withNewCertificatesSecretRefLike(Optional.ofNullable(this.buildCertificatesSecretRef()).orElse(null));
  }
  
  public CredentialsSecretRefNested<A> editCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(null));
  }
  
  public CertificatesSecretRefNested<A> editOrNewCertificatesSecretRef() {
    return this.withNewCertificatesSecretRefLike(Optional.ofNullable(this.buildCertificatesSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CertificatesSecretRefNested<A> editOrNewCertificatesSecretRefLike(LocalObjectReference item) {
    return this.withNewCertificatesSecretRefLike(Optional.ofNullable(this.buildCertificatesSecretRef()).orElse(item));
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(certificatesSecretRef, that.certificatesSecretRef))) {
      return false;
    }
    if (!(Objects.equals(cluster, that.cluster))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(datacenter, that.datacenter))) {
      return false;
    }
    if (!(Objects.equals(defaultDatastore, that.defaultDatastore))) {
      return false;
    }
    if (!(Objects.equals(folder, that.folder))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(vCenter, that.vCenter))) {
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
  
  public String getCluster() {
    return this.cluster;
  }
  
  public String getDatacenter() {
    return this.datacenter;
  }
  
  public String getDefaultDatastore() {
    return this.defaultDatastore;
  }
  
  public String getFolder() {
    return this.folder;
  }
  
  public String getNetwork() {
    return this.network;
  }
  
  public String getVCenter() {
    return this.vCenter;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertificatesSecretRef() {
    return this.certificatesSecretRef != null;
  }
  
  public boolean hasCluster() {
    return this.cluster != null;
  }
  
  public boolean hasCredentialsSecretRef() {
    return this.credentialsSecretRef != null;
  }
  
  public boolean hasDatacenter() {
    return this.datacenter != null;
  }
  
  public boolean hasDefaultDatastore() {
    return this.defaultDatastore != null;
  }
  
  public boolean hasFolder() {
    return this.folder != null;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasVCenter() {
    return this.vCenter != null;
  }
  
  public int hashCode() {
    return Objects.hash(certificatesSecretRef, cluster, credentialsSecretRef, datacenter, defaultDatastore, folder, network, vCenter, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(certificatesSecretRef == null)) {
        sb.append("certificatesSecretRef:");
        sb.append(certificatesSecretRef);
        sb.append(",");
    }
    if (!(cluster == null)) {
        sb.append("cluster:");
        sb.append(cluster);
        sb.append(",");
    }
    if (!(credentialsSecretRef == null)) {
        sb.append("credentialsSecretRef:");
        sb.append(credentialsSecretRef);
        sb.append(",");
    }
    if (!(datacenter == null)) {
        sb.append("datacenter:");
        sb.append(datacenter);
        sb.append(",");
    }
    if (!(defaultDatastore == null)) {
        sb.append("defaultDatastore:");
        sb.append(defaultDatastore);
        sb.append(",");
    }
    if (!(folder == null)) {
        sb.append("folder:");
        sb.append(folder);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(vCenter == null)) {
        sb.append("vCenter:");
        sb.append(vCenter);
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
  
  public A withCertificatesSecretRef(LocalObjectReference certificatesSecretRef) {
    this._visitables.remove("certificatesSecretRef");
    if (certificatesSecretRef != null) {
        this.certificatesSecretRef = new LocalObjectReferenceBuilder(certificatesSecretRef);
        this._visitables.get("certificatesSecretRef").add(this.certificatesSecretRef);
    } else {
        this.certificatesSecretRef = null;
        this._visitables.get("certificatesSecretRef").remove(this.certificatesSecretRef);
    }
    return (A) this;
  }
  
  public A withCluster(String cluster) {
    this.cluster = cluster;
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
  
  public A withDatacenter(String datacenter) {
    this.datacenter = datacenter;
    return (A) this;
  }
  
  public A withDefaultDatastore(String defaultDatastore) {
    this.defaultDatastore = defaultDatastore;
    return (A) this;
  }
  
  public A withFolder(String folder) {
    this.folder = folder;
    return (A) this;
  }
  
  public A withNetwork(String network) {
    this.network = network;
    return (A) this;
  }
  
  public CertificatesSecretRefNested<A> withNewCertificatesSecretRef() {
    return new CertificatesSecretRefNested(null);
  }
  
  public A withNewCertificatesSecretRef(String name) {
    return (A) this.withCertificatesSecretRef(new LocalObjectReference(name));
  }
  
  public CertificatesSecretRefNested<A> withNewCertificatesSecretRefLike(LocalObjectReference item) {
    return new CertificatesSecretRefNested(item);
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
  
  public A withVCenter(String vCenter) {
    this.vCenter = vCenter;
    return (A) this;
  }
  public class CertificatesSecretRefNested<N> extends LocalObjectReferenceFluent<CertificatesSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CertificatesSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withCertificatesSecretRef(builder.build());
    }
    
    public N endCertificatesSecretRef() {
      return and();
    }
    
  }
  public class CredentialsSecretRefNested<N> extends LocalObjectReferenceFluent<CredentialsSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
}