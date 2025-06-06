
package io.fabric8.openshift.api.model;

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
 * LifecycleHook defines a specific deployment lifecycle action. Only one type of action may be specified at any time.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "execNewPod",
    "failurePolicy",
    "tagImages"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LifecycleHook implements Editable<LifecycleHookBuilder>, KubernetesResource
{

    @JsonProperty("execNewPod")
    private ExecNewPodHook execNewPod;
    @JsonProperty("failurePolicy")
    private String failurePolicy;
    @JsonProperty("tagImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TagImageHook> tagImages = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LifecycleHook() {
    }

    public LifecycleHook(ExecNewPodHook execNewPod, String failurePolicy, List<TagImageHook> tagImages) {
        super();
        this.execNewPod = execNewPod;
        this.failurePolicy = failurePolicy;
        this.tagImages = tagImages;
    }

    /**
     * LifecycleHook defines a specific deployment lifecycle action. Only one type of action may be specified at any time.
     */
    @JsonProperty("execNewPod")
    public ExecNewPodHook getExecNewPod() {
        return execNewPod;
    }

    /**
     * LifecycleHook defines a specific deployment lifecycle action. Only one type of action may be specified at any time.
     */
    @JsonProperty("execNewPod")
    public void setExecNewPod(ExecNewPodHook execNewPod) {
        this.execNewPod = execNewPod;
    }

    /**
     * FailurePolicy specifies what action to take if the hook fails.
     */
    @JsonProperty("failurePolicy")
    public String getFailurePolicy() {
        return failurePolicy;
    }

    /**
     * FailurePolicy specifies what action to take if the hook fails.
     */
    @JsonProperty("failurePolicy")
    public void setFailurePolicy(String failurePolicy) {
        this.failurePolicy = failurePolicy;
    }

    /**
     * TagImages instructs the deployer to tag the current image referenced under a container onto an image stream tag.
     */
    @JsonProperty("tagImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TagImageHook> getTagImages() {
        return tagImages;
    }

    /**
     * TagImages instructs the deployer to tag the current image referenced under a container onto an image stream tag.
     */
    @JsonProperty("tagImages")
    public void setTagImages(List<TagImageHook> tagImages) {
        this.tagImages = tagImages;
    }

    @JsonIgnore
    public LifecycleHookBuilder edit() {
        return new LifecycleHookBuilder(this);
    }

    @JsonIgnore
    public LifecycleHookBuilder toBuilder() {
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
