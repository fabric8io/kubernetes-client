
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affinity",
    "annotations",
    "env",
    "envFrom",
    "nodeSelector",
    "resources",
    "selector",
    "tolerations",
    "volumeMounts",
    "volumes"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class SubscriptionSpecConfig implements Editable<SubscriptionSpecConfigBuilder> , KubernetesResource
{

    @JsonProperty("affinity")
    private SubscriptionSpecCAffinity affinity;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionSpecCEnv> env = new ArrayList<>();
    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionSpecCEnvFrom> envFrom = new ArrayList<>();
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("resources")
    private SubscriptionSpecCResources resources;
    @JsonProperty("selector")
    private SubscriptionSpecCSelector selector;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionSpecCTolerations> tolerations = new ArrayList<>();
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionSpecCVolumeMounts> volumeMounts = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionSpecCVolumes> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionSpecConfig() {
    }

    public SubscriptionSpecConfig(SubscriptionSpecCAffinity affinity, Map<String, String> annotations, List<SubscriptionSpecCEnv> env, List<SubscriptionSpecCEnvFrom> envFrom, Map<String, String> nodeSelector, SubscriptionSpecCResources resources, SubscriptionSpecCSelector selector, List<SubscriptionSpecCTolerations> tolerations, List<SubscriptionSpecCVolumeMounts> volumeMounts, List<SubscriptionSpecCVolumes> volumes) {
        super();
        this.affinity = affinity;
        this.annotations = annotations;
        this.env = env;
        this.envFrom = envFrom;
        this.nodeSelector = nodeSelector;
        this.resources = resources;
        this.selector = selector;
        this.tolerations = tolerations;
        this.volumeMounts = volumeMounts;
        this.volumes = volumes;
    }

    @JsonProperty("affinity")
    public SubscriptionSpecCAffinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(SubscriptionSpecCAffinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionSpecCEnv> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<SubscriptionSpecCEnv> env) {
        this.env = env;
    }

    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionSpecCEnvFrom> getEnvFrom() {
        return envFrom;
    }

    @JsonProperty("envFrom")
    public void setEnvFrom(List<SubscriptionSpecCEnvFrom> envFrom) {
        this.envFrom = envFrom;
    }

    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("resources")
    public SubscriptionSpecCResources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(SubscriptionSpecCResources resources) {
        this.resources = resources;
    }

    @JsonProperty("selector")
    public SubscriptionSpecCSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(SubscriptionSpecCSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionSpecCTolerations> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<SubscriptionSpecCTolerations> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionSpecCVolumeMounts> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<SubscriptionSpecCVolumeMounts> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionSpecCVolumes> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<SubscriptionSpecCVolumes> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public SubscriptionSpecConfigBuilder edit() {
        return new SubscriptionSpecConfigBuilder(this);
    }

    @JsonIgnore
    public SubscriptionSpecConfigBuilder toBuilder() {
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
