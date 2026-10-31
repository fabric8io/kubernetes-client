
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * OSImageStreamStatus describes the current state of a OSImageStream
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableStreams",
    "defaultStream"
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
public class OSImageStreamStatus implements Editable<OSImageStreamStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableStreams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OSImageStreamSet> availableStreams = new ArrayList<>();
    @JsonProperty("defaultStream")
    private String defaultStream;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OSImageStreamStatus() {
    }

    public OSImageStreamStatus(List<OSImageStreamSet> availableStreams, String defaultStream) {
        super();
        this.availableStreams = availableStreams;
        this.defaultStream = defaultStream;
    }

    /**
     * availableStreams is a list of the available OS Image Streams that can be used as the base image for MachineConfigPools. availableStreams is required, must have at least one item, must not exceed 100 items, and must have unique entries keyed on the name field.
     */
    @JsonProperty("availableStreams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OSImageStreamSet> getAvailableStreams() {
        return availableStreams;
    }

    /**
     * availableStreams is a list of the available OS Image Streams that can be used as the base image for MachineConfigPools. availableStreams is required, must have at least one item, must not exceed 100 items, and must have unique entries keyed on the name field.
     */
    @JsonProperty("availableStreams")
    public void setAvailableStreams(List<OSImageStreamSet> availableStreams) {
        this.availableStreams = availableStreams;
    }

    /**
     * defaultStream is the name of the stream that should be used as the default when no specific stream is requested by a MachineConfigPool.<br><p> <br><p> It must be a valid RFC 1123 subdomain between 1 and 253 characters in length, consisting of lowercase alphanumeric characters, hyphens ('-'), and periods ('.'), and must reference the name of one of the streams in availableStreams.
     */
    @JsonProperty("defaultStream")
    public String getDefaultStream() {
        return defaultStream;
    }

    /**
     * defaultStream is the name of the stream that should be used as the default when no specific stream is requested by a MachineConfigPool.<br><p> <br><p> It must be a valid RFC 1123 subdomain between 1 and 253 characters in length, consisting of lowercase alphanumeric characters, hyphens ('-'), and periods ('.'), and must reference the name of one of the streams in availableStreams.
     */
    @JsonProperty("defaultStream")
    public void setDefaultStream(String defaultStream) {
        this.defaultStream = defaultStream;
    }

    @JsonIgnore
    public OSImageStreamStatusBuilder edit() {
        return new OSImageStreamStatusBuilder(this);
    }

    @JsonIgnore
    public OSImageStreamStatusBuilder toBuilder() {
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
