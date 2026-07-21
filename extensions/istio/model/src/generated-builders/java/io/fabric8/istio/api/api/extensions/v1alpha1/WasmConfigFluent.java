package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class WasmConfigFluent<A extends io.fabric8.istio.api.api.extensions.v1alpha1.WasmConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FailStrategy failStrategy;
  private PullPolicy imagePullPolicy;
  private String imagePullSecret;
  private Object pluginConfig;
  private String pluginName;
  private String sha256;
  private PluginType type;
  private String url;
  private String verificationKey;
  private VmConfigBuilder vmConfig;

  public WasmConfigFluent() {
  }
  
  public WasmConfigFluent(WasmConfig instance) {
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
  
  public VmConfig buildVmConfig() {
    return this.vmConfig != null ? this.vmConfig.build() : null;
  }
  
  protected void copyInstance(WasmConfig instance) {
    instance = instance != null ? instance : new WasmConfig();
    if (instance != null) {
        this.withFailStrategy(instance.getFailStrategy());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecret(instance.getImagePullSecret());
        this.withPluginConfig(instance.getPluginConfig());
        this.withPluginName(instance.getPluginName());
        this.withSha256(instance.getSha256());
        this.withType(instance.getType());
        this.withUrl(instance.getUrl());
        this.withVerificationKey(instance.getVerificationKey());
        this.withVmConfig(instance.getVmConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VmConfigNested<A> editOrNewVmConfig() {
    return this.withNewVmConfigLike(Optional.ofNullable(this.buildVmConfig()).orElse(new VmConfigBuilder().build()));
  }
  
  public VmConfigNested<A> editOrNewVmConfigLike(VmConfig item) {
    return this.withNewVmConfigLike(Optional.ofNullable(this.buildVmConfig()).orElse(item));
  }
  
  public VmConfigNested<A> editVmConfig() {
    return this.withNewVmConfigLike(Optional.ofNullable(this.buildVmConfig()).orElse(null));
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
    WasmConfigFluent that = (WasmConfigFluent) o;
    if (!(Objects.equals(failStrategy, that.failStrategy))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecret, that.imagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(pluginConfig, that.pluginConfig))) {
      return false;
    }
    if (!(Objects.equals(pluginName, that.pluginName))) {
      return false;
    }
    if (!(Objects.equals(sha256, that.sha256))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(verificationKey, that.verificationKey))) {
      return false;
    }
    if (!(Objects.equals(vmConfig, that.vmConfig))) {
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
  
  public FailStrategy getFailStrategy() {
    return this.failStrategy;
  }
  
  public PullPolicy getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public String getImagePullSecret() {
    return this.imagePullSecret;
  }
  
  public Object getPluginConfig() {
    return this.pluginConfig;
  }
  
  public String getPluginName() {
    return this.pluginName;
  }
  
  public String getSha256() {
    return this.sha256;
  }
  
  public PluginType getType() {
    return this.type;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public String getVerificationKey() {
    return this.verificationKey;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailStrategy() {
    return this.failStrategy != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSecret() {
    return this.imagePullSecret != null;
  }
  
  public boolean hasPluginConfig() {
    return this.pluginConfig != null;
  }
  
  public boolean hasPluginName() {
    return this.pluginName != null;
  }
  
  public boolean hasSha256() {
    return this.sha256 != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasVerificationKey() {
    return this.verificationKey != null;
  }
  
  public boolean hasVmConfig() {
    return this.vmConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(failStrategy, imagePullPolicy, imagePullSecret, pluginConfig, pluginName, sha256, type, url, verificationKey, vmConfig, additionalProperties);
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
    if (!(failStrategy == null)) {
        sb.append("failStrategy:");
        sb.append(failStrategy);
        sb.append(",");
    }
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
    if (!(pluginConfig == null)) {
        sb.append("pluginConfig:");
        sb.append(pluginConfig);
        sb.append(",");
    }
    if (!(pluginName == null)) {
        sb.append("pluginName:");
        sb.append(pluginName);
        sb.append(",");
    }
    if (!(sha256 == null)) {
        sb.append("sha256:");
        sb.append(sha256);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(verificationKey == null)) {
        sb.append("verificationKey:");
        sb.append(verificationKey);
        sb.append(",");
    }
    if (!(vmConfig == null)) {
        sb.append("vmConfig:");
        sb.append(vmConfig);
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
  
  public A withFailStrategy(FailStrategy failStrategy) {
    this.failStrategy = failStrategy;
    return (A) this;
  }
  
  public A withImagePullPolicy(PullPolicy imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
    return (A) this;
  }
  
  public VmConfigNested<A> withNewVmConfig() {
    return new VmConfigNested(null);
  }
  
  public VmConfigNested<A> withNewVmConfigLike(VmConfig item) {
    return new VmConfigNested(item);
  }
  
  public A withPluginConfig(Object pluginConfig) {
    this.pluginConfig = pluginConfig;
    return (A) this;
  }
  
  public A withPluginName(String pluginName) {
    this.pluginName = pluginName;
    return (A) this;
  }
  
  public A withSha256(String sha256) {
    this.sha256 = sha256;
    return (A) this;
  }
  
  public A withType(PluginType type) {
    this.type = type;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withVerificationKey(String verificationKey) {
    this.verificationKey = verificationKey;
    return (A) this;
  }
  
  public A withVmConfig(VmConfig vmConfig) {
    this._visitables.remove("vmConfig");
    if (vmConfig != null) {
        this.vmConfig = new VmConfigBuilder(vmConfig);
        this._visitables.get("vmConfig").add(this.vmConfig);
    } else {
        this.vmConfig = null;
        this._visitables.get("vmConfig").remove(this.vmConfig);
    }
    return (A) this;
  }
  public class VmConfigNested<N> extends VmConfigFluent<VmConfigNested<N>> implements Nested<N>{
  
    VmConfigBuilder builder;
  
    VmConfigNested(VmConfig item) {
      this.builder = new VmConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) WasmConfigFluent.this.withVmConfig(builder.build());
    }
    
    public N endVmConfig() {
      return and();
    }
    
  }
}