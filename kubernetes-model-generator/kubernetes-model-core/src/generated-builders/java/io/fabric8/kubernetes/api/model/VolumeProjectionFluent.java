package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class VolumeProjectionFluent<A extends io.fabric8.kubernetes.api.model.VolumeProjectionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterTrustBundleProjectionBuilder clusterTrustBundle;
  private ConfigMapProjectionBuilder configMap;
  private DownwardAPIProjectionBuilder downwardAPI;
  private PodCertificateProjectionBuilder podCertificate;
  private SecretProjectionBuilder secret;
  private ServiceAccountTokenProjectionBuilder serviceAccountToken;

  public VolumeProjectionFluent() {
  }
  
  public VolumeProjectionFluent(VolumeProjection instance) {
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
  
  public ClusterTrustBundleProjection buildClusterTrustBundle() {
    return this.clusterTrustBundle != null ? this.clusterTrustBundle.build() : null;
  }
  
  public ConfigMapProjection buildConfigMap() {
    return this.configMap != null ? this.configMap.build() : null;
  }
  
  public DownwardAPIProjection buildDownwardAPI() {
    return this.downwardAPI != null ? this.downwardAPI.build() : null;
  }
  
  public PodCertificateProjection buildPodCertificate() {
    return this.podCertificate != null ? this.podCertificate.build() : null;
  }
  
  public SecretProjection buildSecret() {
    return this.secret != null ? this.secret.build() : null;
  }
  
  public ServiceAccountTokenProjection buildServiceAccountToken() {
    return this.serviceAccountToken != null ? this.serviceAccountToken.build() : null;
  }
  
  protected void copyInstance(VolumeProjection instance) {
    instance = instance != null ? instance : new VolumeProjection();
    if (instance != null) {
        this.withClusterTrustBundle(instance.getClusterTrustBundle());
        this.withConfigMap(instance.getConfigMap());
        this.withDownwardAPI(instance.getDownwardAPI());
        this.withPodCertificate(instance.getPodCertificate());
        this.withSecret(instance.getSecret());
        this.withServiceAccountToken(instance.getServiceAccountToken());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterTrustBundleNested<A> editClusterTrustBundle() {
    return this.withNewClusterTrustBundleLike(Optional.ofNullable(this.buildClusterTrustBundle()).orElse(null));
  }
  
  public ConfigMapNested<A> editConfigMap() {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(null));
  }
  
  public DownwardAPINested<A> editDownwardAPI() {
    return this.withNewDownwardAPILike(Optional.ofNullable(this.buildDownwardAPI()).orElse(null));
  }
  
  public ClusterTrustBundleNested<A> editOrNewClusterTrustBundle() {
    return this.withNewClusterTrustBundleLike(Optional.ofNullable(this.buildClusterTrustBundle()).orElse(new ClusterTrustBundleProjectionBuilder().build()));
  }
  
  public ClusterTrustBundleNested<A> editOrNewClusterTrustBundleLike(ClusterTrustBundleProjection item) {
    return this.withNewClusterTrustBundleLike(Optional.ofNullable(this.buildClusterTrustBundle()).orElse(item));
  }
  
  public ConfigMapNested<A> editOrNewConfigMap() {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(new ConfigMapProjectionBuilder().build()));
  }
  
  public ConfigMapNested<A> editOrNewConfigMapLike(ConfigMapProjection item) {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(item));
  }
  
  public DownwardAPINested<A> editOrNewDownwardAPI() {
    return this.withNewDownwardAPILike(Optional.ofNullable(this.buildDownwardAPI()).orElse(new DownwardAPIProjectionBuilder().build()));
  }
  
  public DownwardAPINested<A> editOrNewDownwardAPILike(DownwardAPIProjection item) {
    return this.withNewDownwardAPILike(Optional.ofNullable(this.buildDownwardAPI()).orElse(item));
  }
  
  public PodCertificateNested<A> editOrNewPodCertificate() {
    return this.withNewPodCertificateLike(Optional.ofNullable(this.buildPodCertificate()).orElse(new PodCertificateProjectionBuilder().build()));
  }
  
  public PodCertificateNested<A> editOrNewPodCertificateLike(PodCertificateProjection item) {
    return this.withNewPodCertificateLike(Optional.ofNullable(this.buildPodCertificate()).orElse(item));
  }
  
  public SecretNested<A> editOrNewSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(new SecretProjectionBuilder().build()));
  }
  
  public SecretNested<A> editOrNewSecretLike(SecretProjection item) {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(item));
  }
  
  public ServiceAccountTokenNested<A> editOrNewServiceAccountToken() {
    return this.withNewServiceAccountTokenLike(Optional.ofNullable(this.buildServiceAccountToken()).orElse(new ServiceAccountTokenProjectionBuilder().build()));
  }
  
  public ServiceAccountTokenNested<A> editOrNewServiceAccountTokenLike(ServiceAccountTokenProjection item) {
    return this.withNewServiceAccountTokenLike(Optional.ofNullable(this.buildServiceAccountToken()).orElse(item));
  }
  
  public PodCertificateNested<A> editPodCertificate() {
    return this.withNewPodCertificateLike(Optional.ofNullable(this.buildPodCertificate()).orElse(null));
  }
  
  public SecretNested<A> editSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(null));
  }
  
  public ServiceAccountTokenNested<A> editServiceAccountToken() {
    return this.withNewServiceAccountTokenLike(Optional.ofNullable(this.buildServiceAccountToken()).orElse(null));
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
    VolumeProjectionFluent that = (VolumeProjectionFluent) o;
    if (!(Objects.equals(clusterTrustBundle, that.clusterTrustBundle))) {
      return false;
    }
    if (!(Objects.equals(configMap, that.configMap))) {
      return false;
    }
    if (!(Objects.equals(downwardAPI, that.downwardAPI))) {
      return false;
    }
    if (!(Objects.equals(podCertificate, that.podCertificate))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountToken, that.serviceAccountToken))) {
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
  
  public boolean hasClusterTrustBundle() {
    return this.clusterTrustBundle != null;
  }
  
  public boolean hasConfigMap() {
    return this.configMap != null;
  }
  
  public boolean hasDownwardAPI() {
    return this.downwardAPI != null;
  }
  
  public boolean hasPodCertificate() {
    return this.podCertificate != null;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public boolean hasServiceAccountToken() {
    return this.serviceAccountToken != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterTrustBundle, configMap, downwardAPI, podCertificate, secret, serviceAccountToken, additionalProperties);
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
    if (!(clusterTrustBundle == null)) {
        sb.append("clusterTrustBundle:");
        sb.append(clusterTrustBundle);
        sb.append(",");
    }
    if (!(configMap == null)) {
        sb.append("configMap:");
        sb.append(configMap);
        sb.append(",");
    }
    if (!(downwardAPI == null)) {
        sb.append("downwardAPI:");
        sb.append(downwardAPI);
        sb.append(",");
    }
    if (!(podCertificate == null)) {
        sb.append("podCertificate:");
        sb.append(podCertificate);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(serviceAccountToken == null)) {
        sb.append("serviceAccountToken:");
        sb.append(serviceAccountToken);
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
  
  public A withClusterTrustBundle(ClusterTrustBundleProjection clusterTrustBundle) {
    this._visitables.remove("clusterTrustBundle");
    if (clusterTrustBundle != null) {
        this.clusterTrustBundle = new ClusterTrustBundleProjectionBuilder(clusterTrustBundle);
        this._visitables.get("clusterTrustBundle").add(this.clusterTrustBundle);
    } else {
        this.clusterTrustBundle = null;
        this._visitables.get("clusterTrustBundle").remove(this.clusterTrustBundle);
    }
    return (A) this;
  }
  
  public A withConfigMap(ConfigMapProjection configMap) {
    this._visitables.remove("configMap");
    if (configMap != null) {
        this.configMap = new ConfigMapProjectionBuilder(configMap);
        this._visitables.get("configMap").add(this.configMap);
    } else {
        this.configMap = null;
        this._visitables.get("configMap").remove(this.configMap);
    }
    return (A) this;
  }
  
  public A withDownwardAPI(DownwardAPIProjection downwardAPI) {
    this._visitables.remove("downwardAPI");
    if (downwardAPI != null) {
        this.downwardAPI = new DownwardAPIProjectionBuilder(downwardAPI);
        this._visitables.get("downwardAPI").add(this.downwardAPI);
    } else {
        this.downwardAPI = null;
        this._visitables.get("downwardAPI").remove(this.downwardAPI);
    }
    return (A) this;
  }
  
  public ClusterTrustBundleNested<A> withNewClusterTrustBundle() {
    return new ClusterTrustBundleNested(null);
  }
  
  public ClusterTrustBundleNested<A> withNewClusterTrustBundleLike(ClusterTrustBundleProjection item) {
    return new ClusterTrustBundleNested(item);
  }
  
  public ConfigMapNested<A> withNewConfigMap() {
    return new ConfigMapNested(null);
  }
  
  public ConfigMapNested<A> withNewConfigMapLike(ConfigMapProjection item) {
    return new ConfigMapNested(item);
  }
  
  public DownwardAPINested<A> withNewDownwardAPI() {
    return new DownwardAPINested(null);
  }
  
  public DownwardAPINested<A> withNewDownwardAPILike(DownwardAPIProjection item) {
    return new DownwardAPINested(item);
  }
  
  public PodCertificateNested<A> withNewPodCertificate() {
    return new PodCertificateNested(null);
  }
  
  public PodCertificateNested<A> withNewPodCertificateLike(PodCertificateProjection item) {
    return new PodCertificateNested(item);
  }
  
  public SecretNested<A> withNewSecret() {
    return new SecretNested(null);
  }
  
  public SecretNested<A> withNewSecretLike(SecretProjection item) {
    return new SecretNested(item);
  }
  
  public ServiceAccountTokenNested<A> withNewServiceAccountToken() {
    return new ServiceAccountTokenNested(null);
  }
  
  public A withNewServiceAccountToken(String audience,Long expirationSeconds,String path) {
    return (A) this.withServiceAccountToken(new ServiceAccountTokenProjection(audience, expirationSeconds, path));
  }
  
  public ServiceAccountTokenNested<A> withNewServiceAccountTokenLike(ServiceAccountTokenProjection item) {
    return new ServiceAccountTokenNested(item);
  }
  
  public A withPodCertificate(PodCertificateProjection podCertificate) {
    this._visitables.remove("podCertificate");
    if (podCertificate != null) {
        this.podCertificate = new PodCertificateProjectionBuilder(podCertificate);
        this._visitables.get("podCertificate").add(this.podCertificate);
    } else {
        this.podCertificate = null;
        this._visitables.get("podCertificate").remove(this.podCertificate);
    }
    return (A) this;
  }
  
  public A withSecret(SecretProjection secret) {
    this._visitables.remove("secret");
    if (secret != null) {
        this.secret = new SecretProjectionBuilder(secret);
        this._visitables.get("secret").add(this.secret);
    } else {
        this.secret = null;
        this._visitables.get("secret").remove(this.secret);
    }
    return (A) this;
  }
  
  public A withServiceAccountToken(ServiceAccountTokenProjection serviceAccountToken) {
    this._visitables.remove("serviceAccountToken");
    if (serviceAccountToken != null) {
        this.serviceAccountToken = new ServiceAccountTokenProjectionBuilder(serviceAccountToken);
        this._visitables.get("serviceAccountToken").add(this.serviceAccountToken);
    } else {
        this.serviceAccountToken = null;
        this._visitables.get("serviceAccountToken").remove(this.serviceAccountToken);
    }
    return (A) this;
  }
  public class ClusterTrustBundleNested<N> extends ClusterTrustBundleProjectionFluent<ClusterTrustBundleNested<N>> implements Nested<N>{
  
    ClusterTrustBundleProjectionBuilder builder;
  
    ClusterTrustBundleNested(ClusterTrustBundleProjection item) {
      this.builder = new ClusterTrustBundleProjectionBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeProjectionFluent.this.withClusterTrustBundle(builder.build());
    }
    
    public N endClusterTrustBundle() {
      return and();
    }
    
  }
  public class ConfigMapNested<N> extends ConfigMapProjectionFluent<ConfigMapNested<N>> implements Nested<N>{
  
    ConfigMapProjectionBuilder builder;
  
    ConfigMapNested(ConfigMapProjection item) {
      this.builder = new ConfigMapProjectionBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeProjectionFluent.this.withConfigMap(builder.build());
    }
    
    public N endConfigMap() {
      return and();
    }
    
  }
  public class DownwardAPINested<N> extends DownwardAPIProjectionFluent<DownwardAPINested<N>> implements Nested<N>{
  
    DownwardAPIProjectionBuilder builder;
  
    DownwardAPINested(DownwardAPIProjection item) {
      this.builder = new DownwardAPIProjectionBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeProjectionFluent.this.withDownwardAPI(builder.build());
    }
    
    public N endDownwardAPI() {
      return and();
    }
    
  }
  public class PodCertificateNested<N> extends PodCertificateProjectionFluent<PodCertificateNested<N>> implements Nested<N>{
  
    PodCertificateProjectionBuilder builder;
  
    PodCertificateNested(PodCertificateProjection item) {
      this.builder = new PodCertificateProjectionBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeProjectionFluent.this.withPodCertificate(builder.build());
    }
    
    public N endPodCertificate() {
      return and();
    }
    
  }
  public class SecretNested<N> extends SecretProjectionFluent<SecretNested<N>> implements Nested<N>{
  
    SecretProjectionBuilder builder;
  
    SecretNested(SecretProjection item) {
      this.builder = new SecretProjectionBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeProjectionFluent.this.withSecret(builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
  public class ServiceAccountTokenNested<N> extends ServiceAccountTokenProjectionFluent<ServiceAccountTokenNested<N>> implements Nested<N>{
  
    ServiceAccountTokenProjectionBuilder builder;
  
    ServiceAccountTokenNested(ServiceAccountTokenProjection item) {
      this.builder = new ServiceAccountTokenProjectionBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeProjectionFluent.this.withServiceAccountToken(builder.build());
    }
    
    public N endServiceAccountToken() {
      return and();
    }
    
  }
}