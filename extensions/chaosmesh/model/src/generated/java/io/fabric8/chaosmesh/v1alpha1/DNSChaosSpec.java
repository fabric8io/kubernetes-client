
package io.fabric8.chaosmesh.v1alpha1;

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
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * DNSChaosSpec defines the desired state of DNSChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "containerNames",
    "duration",
    "mode",
    "patterns",
    "remoteCluster",
    "selector",
    "value"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DNSChaosSpec implements Editable<DNSChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containerNames = new ArrayList<>();
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("patterns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> patterns = new ArrayList<>();
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSChaosSpec() {
    }

    public DNSChaosSpec(String action, List<String> containerNames, String duration, String mode, List<String> patterns, String remoteCluster, PodSelectorSpec selector, String value) {
        super();
        this.action = action;
        this.containerNames = containerNames;
        this.duration = duration;
        this.mode = mode;
        this.patterns = patterns;
        this.remoteCluster = remoteCluster;
        this.selector = selector;
        this.value = value;
    }

    /**
     * Action defines the specific DNS chaos action. Supported action: error, random Default action: error
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Action defines the specific DNS chaos action. Supported action: error, random Default action: error
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * ContainerNames indicates list of the name of affected container. If not set, the first container will be injected
     */
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerNames() {
        return containerNames;
    }

    /**
     * ContainerNames indicates list of the name of affected container. If not set, the first container will be injected
     */
    @JsonProperty("containerNames")
    public void setContainerNames(List<String> containerNames) {
        this.containerNames = containerNames;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Choose which domain names to take effect, support the placeholder ? and wildcard &#42;, or the Specified domain name. Note:<br><p>      1. The wildcard &#42; must be at the end of the string. For example, chaos-&#42;.org is invalid.<br><p>      2. if the patterns is empty, will take effect on all the domain names.<br><p> For example:<br><p> 		The value is ["google.com", "github.&#42;", "chaos-mes?.org"],<br><p> 		will take effect on "google.com", "github.com" and "chaos-mesh.org"
     */
    @JsonProperty("patterns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPatterns() {
        return patterns;
    }

    /**
     * Choose which domain names to take effect, support the placeholder ? and wildcard &#42;, or the Specified domain name. Note:<br><p>      1. The wildcard &#42; must be at the end of the string. For example, chaos-&#42;.org is invalid.<br><p>      2. if the patterns is empty, will take effect on all the domain names.<br><p> For example:<br><p> 		The value is ["google.com", "github.&#42;", "chaos-mes?.org"],<br><p> 		will take effect on "google.com", "github.com" and "chaos-mesh.org"
     */
    @JsonProperty("patterns")
    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    /**
     * DNSChaosSpec defines the desired state of DNSChaos
     */
    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    /**
     * DNSChaosSpec defines the desired state of DNSChaos
     */
    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public DNSChaosSpecBuilder edit() {
        return new DNSChaosSpecBuilder(this);
    }

    @JsonIgnore
    public DNSChaosSpecBuilder toBuilder() {
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
