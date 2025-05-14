
package io.fabric8.istio.api.api.extensions.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failStrategy",
    "imagePullPolicy",
    "imagePullSecret",
    "match",
    "phase",
    "pluginConfig",
    "pluginName",
    "priority",
    "selector",
    "sha256",
    "targetRef",
    "targetRefs",
    "type",
    "url",
    "verificationKey",
    "vmConfig"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1alpha1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class WasmPlugin implements Editable<WasmPluginBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("failStrategy")
    private FailStrategy failStrategy;
    @JsonProperty("imagePullPolicy")
    private PullPolicy imagePullPolicy;
    @JsonProperty("imagePullSecret")
    private String imagePullSecret;
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WasmPluginTrafficSelector> match = new ArrayList<>();
    @JsonProperty("phase")
    private PluginPhase phase;
    @JsonProperty("pluginConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object pluginConfig;
    @JsonProperty("pluginName")
    private String pluginName;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonProperty("sha256")
    private String sha256;
    @JsonProperty("targetRef")
    private PolicyTargetReference targetRef;
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyTargetReference> targetRefs = new ArrayList<>();
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
    public WasmPlugin() {
    }

    public WasmPlugin(FailStrategy failStrategy, PullPolicy imagePullPolicy, String imagePullSecret, List<WasmPluginTrafficSelector> match, PluginPhase phase, Object pluginConfig, String pluginName, Integer priority, WorkloadSelector selector, String sha256, PolicyTargetReference targetRef, List<PolicyTargetReference> targetRefs, PluginType type, String url, String verificationKey, VmConfig vmConfig) {
        super();
        this.failStrategy = failStrategy;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecret = imagePullSecret;
        this.match = match;
        this.phase = phase;
        this.pluginConfig = pluginConfig;
        this.pluginName = pluginName;
        this.priority = priority;
        this.selector = selector;
        this.sha256 = sha256;
        this.targetRef = targetRef;
        this.targetRefs = targetRefs;
        this.type = type;
        this.url = url;
        this.verificationKey = verificationKey;
        this.vmConfig = vmConfig;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("failStrategy")
    public FailStrategy getFailStrategy() {
        return failStrategy;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("failStrategy")
    public void setFailStrategy(FailStrategy failStrategy) {
        this.failStrategy = failStrategy;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("imagePullPolicy")
    public PullPolicy getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(PullPolicy imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * Credentials to use for OCI image pulling. Name of a Kubernetes Secret in the same namespace as the `WasmPlugin` that contains a Docker pull secret which is to be used to authenticate against the registry when pulling the image.
     */
    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    /**
     * Credentials to use for OCI image pulling. Name of a Kubernetes Secret in the same namespace as the `WasmPlugin` that contains a Docker pull secret which is to be used to authenticate against the registry when pulling the image.
     */
    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    /**
     * Specifies the criteria to determine which traffic is passed to WasmPlugin. If a traffic satisfies any of TrafficSelectors, the traffic passes the WasmPlugin.
     */
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WasmPluginTrafficSelector> getMatch() {
        return match;
    }

    /**
     * Specifies the criteria to determine which traffic is passed to WasmPlugin. If a traffic satisfies any of TrafficSelectors, the traffic passes the WasmPlugin.
     */
    @JsonProperty("match")
    public void setMatch(List<WasmPluginTrafficSelector> match) {
        this.match = match;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("phase")
    public PluginPhase getPhase() {
        return phase;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("phase")
    public void setPhase(PluginPhase phase) {
        this.phase = phase;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("pluginConfig")
    public Object getPluginConfig() {
        return pluginConfig;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
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
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
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
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("targetRef")
    public PolicyTargetReference getTargetRef() {
        return targetRef;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("targetRef")
    public void setTargetRef(PolicyTargetReference targetRef) {
        this.targetRef = targetRef;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: GatewayClass` with `group: gateway.networking.k8s.io` in the root namespace. &#42; `kind: Service` with `group: ""` or `group: "core"` in the same namespace. This type is only supported for waypoints. &#42; `kind: ServiceEntry` with `group: networking.istio.io` in the same namespace.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTargetReference> getTargetRefs() {
        return targetRefs;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: GatewayClass` with `group: gateway.networking.k8s.io` in the root namespace. &#42; `kind: Service` with `group: ""` or `group: "core"` in the same namespace. This type is only supported for waypoints. &#42; `kind: ServiceEntry` with `group: networking.istio.io` in the same namespace.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    public void setTargetRefs(List<PolicyTargetReference> targetRefs) {
        this.targetRefs = targetRefs;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("type")
    public PluginType getType() {
        return type;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("type")
    public void setType(PluginType type) {
        this.type = type;
    }

    /**
     * URL of a Wasm module or OCI container. If no scheme is present, defaults to `oci://`, referencing an OCI image. Other valid schemes are `file://` for referencing .wasm module files present locally within the proxy container, and `http[s]://` for `.wasm` module files hosted remotely.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL of a Wasm module or OCI container. If no scheme is present, defaults to `oci://`, referencing an OCI image. Other valid schemes are `file://` for referencing .wasm module files present locally within the proxy container, and `http[s]://` for `.wasm` module files hosted remotely.
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
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("vmConfig")
    public VmConfig getVmConfig() {
        return vmConfig;
    }

    /**
     * WasmPlugin provides a mechanism to extend the functionality provided by the Istio proxy through WebAssembly filters.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("vmConfig")
    public void setVmConfig(VmConfig vmConfig) {
        this.vmConfig = vmConfig;
    }

    @JsonIgnore
    public WasmPluginBuilder edit() {
        return new WasmPluginBuilder(this);
    }

    @JsonIgnore
    public WasmPluginBuilder toBuilder() {
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

}
