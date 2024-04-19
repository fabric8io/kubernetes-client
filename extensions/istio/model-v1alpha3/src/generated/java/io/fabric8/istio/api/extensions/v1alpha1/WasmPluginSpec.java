
package io.fabric8.istio.api.extensions.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.networking.v1alpha1.FailStrategy;
import io.fabric8.istio.api.networking.v1alpha1.PluginPhase;
import io.fabric8.istio.api.networking.v1alpha1.PluginType;
import io.fabric8.istio.api.networking.v1alpha1.PullPolicy;
import io.fabric8.istio.api.networking.v1alpha1.VmConfig;
import io.fabric8.istio.api.networking.v1alpha1.WasmPluginTrafficSelector;
import io.fabric8.istio.api.networking.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.networking.v1beta1.WorkloadSelector;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
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
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
    "type",
    "url",
    "verificationKey",
    "vmConfig"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class WasmPluginSpec implements Editable<WasmPluginSpecBuilder> , KubernetesResource
{

    @JsonProperty("failStrategy")
    private FailStrategy failStrategy;
    @JsonProperty("imagePullPolicy")
    private PullPolicy imagePullPolicy;
    @JsonProperty("imagePullSecret")
    private java.lang.String imagePullSecret;
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WasmPluginTrafficSelector> match = new ArrayList<WasmPluginTrafficSelector>();
    @JsonProperty("phase")
    private PluginPhase phase;
    @JsonProperty("pluginConfig")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> pluginConfig = new LinkedHashMap<String, Object>();
    @JsonProperty("pluginName")
    private java.lang.String pluginName;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonProperty("sha256")
    private java.lang.String sha256;
    @JsonProperty("targetRef")
    private PolicyTargetReference targetRef;
    @JsonProperty("type")
    private PluginType type;
    @JsonProperty("url")
    private java.lang.String url;
    @JsonProperty("verificationKey")
    private java.lang.String verificationKey;
    @JsonProperty("vmConfig")
    private VmConfig vmConfig;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WasmPluginSpec() {
    }

    public WasmPluginSpec(FailStrategy failStrategy, PullPolicy imagePullPolicy, java.lang.String imagePullSecret, List<WasmPluginTrafficSelector> match, PluginPhase phase, Map<String, Object> pluginConfig, java.lang.String pluginName, Integer priority, WorkloadSelector selector, java.lang.String sha256, PolicyTargetReference targetRef, PluginType type, java.lang.String url, java.lang.String verificationKey, VmConfig vmConfig) {
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
        this.type = type;
        this.url = url;
        this.verificationKey = verificationKey;
        this.vmConfig = vmConfig;
    }

    @JsonProperty("failStrategy")
    public FailStrategy getFailStrategy() {
        return failStrategy;
    }

    @JsonProperty("failStrategy")
    public void setFailStrategy(FailStrategy failStrategy) {
        this.failStrategy = failStrategy;
    }

    @JsonProperty("imagePullPolicy")
    public PullPolicy getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(PullPolicy imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    @JsonProperty("imagePullSecret")
    public java.lang.String getImagePullSecret() {
        return imagePullSecret;
    }

    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(java.lang.String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    @JsonProperty("match")
    public List<WasmPluginTrafficSelector> getMatch() {
        return match;
    }

    @JsonProperty("match")
    public void setMatch(List<WasmPluginTrafficSelector> match) {
        this.match = match;
    }

    @JsonProperty("phase")
    public PluginPhase getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(PluginPhase phase) {
        this.phase = phase;
    }

    @JsonProperty("pluginConfig")
    public Map<String, Object> getPluginConfig() {
        return pluginConfig;
    }

    @JsonProperty("pluginConfig")
    public void setPluginConfig(Map<String, Object> pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @JsonProperty("pluginName")
    public java.lang.String getPluginName() {
        return pluginName;
    }

    @JsonProperty("pluginName")
    public void setPluginName(java.lang.String pluginName) {
        this.pluginName = pluginName;
    }

    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("sha256")
    public java.lang.String getSha256() {
        return sha256;
    }

    @JsonProperty("sha256")
    public void setSha256(java.lang.String sha256) {
        this.sha256 = sha256;
    }

    @JsonProperty("targetRef")
    public PolicyTargetReference getTargetRef() {
        return targetRef;
    }

    @JsonProperty("targetRef")
    public void setTargetRef(PolicyTargetReference targetRef) {
        this.targetRef = targetRef;
    }

    @JsonProperty("type")
    public PluginType getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(PluginType type) {
        this.type = type;
    }

    @JsonProperty("url")
    public java.lang.String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    @JsonProperty("verificationKey")
    public java.lang.String getVerificationKey() {
        return verificationKey;
    }

    @JsonProperty("verificationKey")
    public void setVerificationKey(java.lang.String verificationKey) {
        this.verificationKey = verificationKey;
    }

    @JsonProperty("vmConfig")
    public VmConfig getVmConfig() {
        return vmConfig;
    }

    @JsonProperty("vmConfig")
    public void setVmConfig(VmConfig vmConfig) {
        this.vmConfig = vmConfig;
    }

    @JsonIgnore
    public WasmPluginSpecBuilder edit() {
        return new WasmPluginSpecBuilder(this);
    }

    @JsonIgnore
    public WasmPluginSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
