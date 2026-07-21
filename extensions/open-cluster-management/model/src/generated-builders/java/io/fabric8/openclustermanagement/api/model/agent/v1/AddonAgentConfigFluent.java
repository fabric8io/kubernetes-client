package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedCluster;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterBuilder;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterFluent;
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
public class AddonAgentConfigFluent<A extends io.fabric8.openclustermanagement.api.model.agent.v1.AddonAgentConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String imagePullPolicy;
  private String imagePullSecret;
  private String imagePullSecretNamespace;
  private KlusterletAddonConfigBuilder klusterletAddonConfig;
  private ManagedClusterBuilder managedCluster;
  private Map<String,String> nodeSelector;

  public AddonAgentConfigFluent() {
  }
  
  public AddonAgentConfigFluent(AddonAgentConfig instance) {
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public KlusterletAddonConfig buildKlusterletAddonConfig() {
    return this.klusterletAddonConfig != null ? this.klusterletAddonConfig.build() : null;
  }
  
  public ManagedCluster buildManagedCluster() {
    return this.managedCluster != null ? this.managedCluster.build() : null;
  }
  
  protected void copyInstance(AddonAgentConfig instance) {
    instance = instance != null ? instance : new AddonAgentConfig();
    if (instance != null) {
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecret(instance.getImagePullSecret());
        this.withImagePullSecretNamespace(instance.getImagePullSecretNamespace());
        this.withKlusterletAddonConfig(instance.getKlusterletAddonConfig());
        this.withManagedCluster(instance.getManagedCluster());
        this.withNodeSelector(instance.getNodeSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KlusterletAddonConfigNested<A> editKlusterletAddonConfig() {
    return this.withNewKlusterletAddonConfigLike(Optional.ofNullable(this.buildKlusterletAddonConfig()).orElse(null));
  }
  
  public ManagedClusterNested<A> editManagedCluster() {
    return this.withNewManagedClusterLike(Optional.ofNullable(this.buildManagedCluster()).orElse(null));
  }
  
  public KlusterletAddonConfigNested<A> editOrNewKlusterletAddonConfig() {
    return this.withNewKlusterletAddonConfigLike(Optional.ofNullable(this.buildKlusterletAddonConfig()).orElse(new KlusterletAddonConfigBuilder().build()));
  }
  
  public KlusterletAddonConfigNested<A> editOrNewKlusterletAddonConfigLike(KlusterletAddonConfig item) {
    return this.withNewKlusterletAddonConfigLike(Optional.ofNullable(this.buildKlusterletAddonConfig()).orElse(item));
  }
  
  public ManagedClusterNested<A> editOrNewManagedCluster() {
    return this.withNewManagedClusterLike(Optional.ofNullable(this.buildManagedCluster()).orElse(new ManagedClusterBuilder().build()));
  }
  
  public ManagedClusterNested<A> editOrNewManagedClusterLike(ManagedCluster item) {
    return this.withNewManagedClusterLike(Optional.ofNullable(this.buildManagedCluster()).orElse(item));
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
    AddonAgentConfigFluent that = (AddonAgentConfigFluent) o;
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecret, that.imagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecretNamespace, that.imagePullSecretNamespace))) {
      return false;
    }
    if (!(Objects.equals(klusterletAddonConfig, that.klusterletAddonConfig))) {
      return false;
    }
    if (!(Objects.equals(managedCluster, that.managedCluster))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
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
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public String getImagePullSecret() {
    return this.imagePullSecret;
  }
  
  public String getImagePullSecretNamespace() {
    return this.imagePullSecretNamespace;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSecret() {
    return this.imagePullSecret != null;
  }
  
  public boolean hasImagePullSecretNamespace() {
    return this.imagePullSecretNamespace != null;
  }
  
  public boolean hasKlusterletAddonConfig() {
    return this.klusterletAddonConfig != null;
  }
  
  public boolean hasManagedCluster() {
    return this.managedCluster != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(imagePullPolicy, imagePullSecret, imagePullSecretNamespace, klusterletAddonConfig, managedCluster, nodeSelector, additionalProperties);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(imagePullSecret == null)) {
        sb.append("imagePullSecret:");
        sb.append(imagePullSecret);
        sb.append(",");
    }
    if (!(imagePullSecretNamespace == null)) {
        sb.append("imagePullSecretNamespace:");
        sb.append(imagePullSecretNamespace);
        sb.append(",");
    }
    if (!(klusterletAddonConfig == null)) {
        sb.append("klusterletAddonConfig:");
        sb.append(klusterletAddonConfig);
        sb.append(",");
    }
    if (!(managedCluster == null)) {
        sb.append("managedCluster:");
        sb.append(managedCluster);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
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
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
    return (A) this;
  }
  
  public A withImagePullSecretNamespace(String imagePullSecretNamespace) {
    this.imagePullSecretNamespace = imagePullSecretNamespace;
    return (A) this;
  }
  
  public A withKlusterletAddonConfig(KlusterletAddonConfig klusterletAddonConfig) {
    this._visitables.remove("klusterletAddonConfig");
    if (klusterletAddonConfig != null) {
        this.klusterletAddonConfig = new KlusterletAddonConfigBuilder(klusterletAddonConfig);
        this._visitables.get("klusterletAddonConfig").add(this.klusterletAddonConfig);
    } else {
        this.klusterletAddonConfig = null;
        this._visitables.get("klusterletAddonConfig").remove(this.klusterletAddonConfig);
    }
    return (A) this;
  }
  
  public A withManagedCluster(ManagedCluster managedCluster) {
    this._visitables.remove("managedCluster");
    if (managedCluster != null) {
        this.managedCluster = new ManagedClusterBuilder(managedCluster);
        this._visitables.get("managedCluster").add(this.managedCluster);
    } else {
        this.managedCluster = null;
        this._visitables.get("managedCluster").remove(this.managedCluster);
    }
    return (A) this;
  }
  
  public KlusterletAddonConfigNested<A> withNewKlusterletAddonConfig() {
    return new KlusterletAddonConfigNested(null);
  }
  
  public KlusterletAddonConfigNested<A> withNewKlusterletAddonConfigLike(KlusterletAddonConfig item) {
    return new KlusterletAddonConfigNested(item);
  }
  
  public ManagedClusterNested<A> withNewManagedCluster() {
    return new ManagedClusterNested(null);
  }
  
  public ManagedClusterNested<A> withNewManagedClusterLike(ManagedCluster item) {
    return new ManagedClusterNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  public class KlusterletAddonConfigNested<N> extends KlusterletAddonConfigFluent<KlusterletAddonConfigNested<N>> implements Nested<N>{
  
    KlusterletAddonConfigBuilder builder;
  
    KlusterletAddonConfigNested(KlusterletAddonConfig item) {
      this.builder = new KlusterletAddonConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AddonAgentConfigFluent.this.withKlusterletAddonConfig(builder.build());
    }
    
    public N endKlusterletAddonConfig() {
      return and();
    }
    
  }
  public class ManagedClusterNested<N> extends ManagedClusterFluent<ManagedClusterNested<N>> implements Nested<N>{
  
    ManagedClusterBuilder builder;
  
    ManagedClusterNested(ManagedCluster item) {
      this.builder = new ManagedClusterBuilder(this, item);
    }
  
    public N and() {
      return (N) AddonAgentConfigFluent.this.withManagedCluster(builder.build());
    }
    
    public N endManagedCluster() {
      return and();
    }
    
  }
}