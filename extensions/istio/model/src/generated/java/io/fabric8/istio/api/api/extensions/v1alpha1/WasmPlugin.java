
package io.fabric8.istio.api.api.extensions.v1alpha1;

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
     * 
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
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    public Object getPluginConfig() {
        return pluginConfig;
    }

    @JsonProperty("pluginConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setPluginConfig(Object pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @JsonProperty("pluginName")
    public String getPluginName() {
        return pluginName;
    }

    @JsonProperty("pluginName")
    public void setPluginName(String pluginName) {
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
    public String getSha256() {
        return sha256;
    }

    @JsonProperty("sha256")
    public void setSha256(String sha256) {
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

    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTargetReference> getTargetRefs() {
        return targetRefs;
    }

    @JsonProperty("targetRefs")
    public void setTargetRefs(List<PolicyTargetReference> targetRefs) {
        this.targetRefs = targetRefs;
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
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("verificationKey")
    public String getVerificationKey() {
        return verificationKey;
    }

    @JsonProperty("verificationKey")
    public void setVerificationKey(String verificationKey) {
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
    public WasmPluginBuilder edit() {
        return new WasmPluginBuilder(this);
    }

    @JsonIgnore
    public WasmPluginBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
