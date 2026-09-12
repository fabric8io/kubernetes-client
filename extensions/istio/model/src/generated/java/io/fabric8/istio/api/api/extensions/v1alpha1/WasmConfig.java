
package io.fabric8.istio.api.api.extensions.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failStrategy",
    "imagePullPolicy",
    "imagePullSecret",
    "pluginConfig",
    "pluginName",
    "sha256",
    "type",
    "url",
    "verificationKey",
    "vmConfig"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class WasmConfig implements Editable<WasmConfigBuilder>, KubernetesResource
{

    @JsonProperty("failStrategy")
    private FailStrategy failStrategy;
    @JsonProperty("imagePullPolicy")
    private PullPolicy imagePullPolicy;
    @JsonProperty("imagePullSecret")
    private String imagePullSecret;
    @JsonProperty("pluginConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object pluginConfig;
    @JsonProperty("pluginName")
    private String pluginName;
    @JsonProperty("sha256")
    private String sha256;
    @JsonProperty("type")
    private PluginType type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("verificationKey")
    private String verificationKey;
    @JsonProperty("vmConfig")
    private VmConfig vmConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WasmConfig() {
    }

    public WasmConfig(FailStrategy failStrategy, PullPolicy imagePullPolicy, String imagePullSecret, Object pluginConfig, String pluginName, String sha256, PluginType type, String url, String verificationKey, VmConfig vmConfig) {
        super();
        this.failStrategy = failStrategy;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecret = imagePullSecret;
        this.pluginConfig = pluginConfig;
        this.pluginName = pluginName;
        this.sha256 = sha256;
        this.type = type;
        this.url = url;
        this.verificationKey = verificationKey;
        this.vmConfig = vmConfig;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("failStrategy")
    public FailStrategy getFailStrategy() {
        return failStrategy;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("failStrategy")
    public void setFailStrategy(FailStrategy failStrategy) {
        this.failStrategy = failStrategy;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("imagePullPolicy")
    public PullPolicy getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(PullPolicy imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * Credentials to use for OCI image pulling. Name of a Kubernetes Secret in the same namespace as the `TrafficExtension` that contains a Docker pull secret which is to be used to authenticate against the registry when pulling the image.
     */
    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    /**
     * Credentials to use for OCI image pulling. Name of a Kubernetes Secret in the same namespace as the `TrafficExtension` that contains a Docker pull secret which is to be used to authenticate against the registry when pulling the image.
     */
    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("pluginConfig")
    public Object getPluginConfig() {
        return pluginConfig;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("pluginConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setPluginConfig(Object pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    /**
     * The plugin name to be used in the Envoy configuration (used to be called `rootID`). Some .wasm modules might require this value to select the Wasm plugin to execute.
     */
    @JsonProperty("pluginName")
    public String getPluginName() {
        return pluginName;
    }

    /**
     * The plugin name to be used in the Envoy configuration (used to be called `rootID`). Some .wasm modules might require this value to select the Wasm plugin to execute.
     */
    @JsonProperty("pluginName")
    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    /**
     * SHA256 checksum that will be used to verify Wasm module or OCI container. If the `url` field already references a SHA256 (using the `@sha256:` notation), it must match the value of this field. If an OCI image is referenced by tag and this field is set, its checksum will be verified against the contents of this field after pulling.
     */
    @JsonProperty("sha256")
    public String getSha256() {
        return sha256;
    }

    /**
     * SHA256 checksum that will be used to verify Wasm module or OCI container. If the `url` field already references a SHA256 (using the `@sha256:` notation), it must match the value of this field. If an OCI image is referenced by tag and this field is set, its checksum will be verified against the contents of this field after pulling.
     */
    @JsonProperty("sha256")
    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("type")
    public PluginType getType() {
        return type;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("type")
    public void setType(PluginType type) {
        this.type = type;
    }

    /**
     * URL of a Wasm module or OCI container. If no scheme is present, defaults to `oci://`, referencing an OCI image. Other valid schemes are `file://` for referencing .wasm module files present locally within the proxy container, and `http[s]://` for .wasm module files hosted remotely.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL of a Wasm module or OCI container. If no scheme is present, defaults to `oci://`, referencing an OCI image. Other valid schemes are `file://` for referencing .wasm module files present locally within the proxy container, and `http[s]://` for .wasm module files hosted remotely.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * $hide_from_docs Public key that will be used to verify signatures of signed OCI images or Wasm modules.<br><p> <br><p> At this moment, various ways for signing/verifying are emerging and being proposed. We can observe two major streams for signing OCI images: Cosign from Sigstore and Notary, which is used in Docker Content Trust. In case of Wasm module, multiple approaches are still in discussion.<br><p>   - https://github.com/WebAssembly/design/issues/1413<br><p>   - https://github.com/wasm-signatures/design (various signing tools are enumerated)<br><p> <br><p> In addition, for each method for signing&amp;verifying, we may need to consider to provide additional data or configuration (e.g., key rolling, KMS, root certs, ...) as well.<br><p> <br><p> To deal with this situation, we need to elaborate more generic way to describe how to sign and verify the image or wasm binary, and how to specify relevant data, including this `verification_key`.<br><p> <br><p> Therefore, this field will not be implemented until the detailed design is established. For the future use, just keep this field in proto and hide from documentation.
     */
    @JsonProperty("verificationKey")
    public String getVerificationKey() {
        return verificationKey;
    }

    /**
     * $hide_from_docs Public key that will be used to verify signatures of signed OCI images or Wasm modules.<br><p> <br><p> At this moment, various ways for signing/verifying are emerging and being proposed. We can observe two major streams for signing OCI images: Cosign from Sigstore and Notary, which is used in Docker Content Trust. In case of Wasm module, multiple approaches are still in discussion.<br><p>   - https://github.com/WebAssembly/design/issues/1413<br><p>   - https://github.com/wasm-signatures/design (various signing tools are enumerated)<br><p> <br><p> In addition, for each method for signing&amp;verifying, we may need to consider to provide additional data or configuration (e.g., key rolling, KMS, root certs, ...) as well.<br><p> <br><p> To deal with this situation, we need to elaborate more generic way to describe how to sign and verify the image or wasm binary, and how to specify relevant data, including this `verification_key`.<br><p> <br><p> Therefore, this field will not be implemented until the detailed design is established. For the future use, just keep this field in proto and hide from documentation.
     */
    @JsonProperty("verificationKey")
    public void setVerificationKey(String verificationKey) {
        this.verificationKey = verificationKey;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("vmConfig")
    public VmConfig getVmConfig() {
        return vmConfig;
    }

    /**
     * WasmConfig configures a WebAssembly filter.<br><p> <br><p> Example:<br><p> <br><p> ```yaml wasm:<br><p> <br><p> 	url: oci://gcr.io/myproject/filter:v1.0.0<br><p> 	sha256: abc123...<br><p> 	imagePullPolicy: IfNotPresent<br><p> 	imagePullSecret: gcr-secret<br><p> 	pluginName: my-filter<br><p> 	pluginConfig:<br><p> 	  key1: value1<br><p> 	  key2: value2<br><p> 	failStrategy: FAIL_CLOSE<br><p> 	vmConfig:<br><p> 	  env:<br><p> 	  - name: SOME_ENV_VAR<br><p> 	    value: some_value<br><p> 	type: HTTP<br><p> <br><p> ```
     */
    @JsonProperty("vmConfig")
    public void setVmConfig(VmConfig vmConfig) {
        this.vmConfig = vmConfig;
    }

    @JsonIgnore
    public WasmConfigBuilder edit() {
        return new WasmConfigBuilder(this);
    }

    @JsonIgnore
    public WasmConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WasmConfig)) {
            return false;
        }
        WasmConfig other = (WasmConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$failStrategy = this.getFailStrategy();
        Object other$failStrategy = other.getFailStrategy();
        if (this$failStrategy == null ? other$failStrategy != null : !this$failStrategy.equals(other$failStrategy)) {
            return false;
        }
        Object this$imagePullPolicy = this.getImagePullPolicy();
        Object other$imagePullPolicy = other.getImagePullPolicy();
        if (this$imagePullPolicy == null ? other$imagePullPolicy != null : !this$imagePullPolicy.equals(other$imagePullPolicy)) {
            return false;
        }
        Object this$imagePullSecret = this.getImagePullSecret();
        Object other$imagePullSecret = other.getImagePullSecret();
        if (this$imagePullSecret == null ? other$imagePullSecret != null : !this$imagePullSecret.equals(other$imagePullSecret)) {
            return false;
        }
        Object this$pluginConfig = this.getPluginConfig();
        Object other$pluginConfig = other.getPluginConfig();
        if (this$pluginConfig == null ? other$pluginConfig != null : !this$pluginConfig.equals(other$pluginConfig)) {
            return false;
        }
        Object this$pluginName = this.getPluginName();
        Object other$pluginName = other.getPluginName();
        if (this$pluginName == null ? other$pluginName != null : !this$pluginName.equals(other$pluginName)) {
            return false;
        }
        Object this$sha256 = this.getSha256();
        Object other$sha256 = other.getSha256();
        if (this$sha256 == null ? other$sha256 != null : !this$sha256.equals(other$sha256)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$verificationKey = this.getVerificationKey();
        Object other$verificationKey = other.getVerificationKey();
        if (this$verificationKey == null ? other$verificationKey != null : !this$verificationKey.equals(other$verificationKey)) {
            return false;
        }
        Object this$vmConfig = this.getVmConfig();
        Object other$vmConfig = other.getVmConfig();
        if (this$vmConfig == null ? other$vmConfig != null : !this$vmConfig.equals(other$vmConfig)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof WasmConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $failStrategy = this.getFailStrategy();
        result = result * prime + ($failStrategy == null ? 43 : $failStrategy.hashCode());
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSecret = this.getImagePullSecret();
        result = result * prime + ($imagePullSecret == null ? 43 : $imagePullSecret.hashCode());
        Object $pluginConfig = this.getPluginConfig();
        result = result * prime + ($pluginConfig == null ? 43 : $pluginConfig.hashCode());
        Object $pluginName = this.getPluginName();
        result = result * prime + ($pluginName == null ? 43 : $pluginName.hashCode());
        Object $sha256 = this.getSha256();
        result = result * prime + ($sha256 == null ? 43 : $sha256.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $verificationKey = this.getVerificationKey();
        result = result * prime + ($verificationKey == null ? 43 : $verificationKey.hashCode());
        Object $vmConfig = this.getVmConfig();
        result = result * prime + ($vmConfig == null ? 43 : $vmConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WasmConfig(" + "failStrategy=" + this.getFailStrategy() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecret=" + this.getImagePullSecret() + ", pluginConfig=" + this.getPluginConfig() + ", pluginName=" + this.getPluginName() + ", sha256=" + this.getSha256() + ", type=" + this.getType() + ", url=" + this.getUrl() + ", verificationKey=" + this.getVerificationKey() + ", vmConfig=" + this.getVmConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
