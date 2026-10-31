
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import java.util.LinkedHashMap;
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
 * OSImageStreamSpec defines the desired state of a OSImageStream.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class OSImageStreamSpec implements Editable<OSImageStreamSpecBuilder>, KubernetesResource
{

    @JsonProperty("defaultStream")
    private String defaultStream;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OSImageStreamSpec() {
    }

    public OSImageStreamSpec(String defaultStream) {
        super();
        this.defaultStream = defaultStream;
    }

    /**
     * defaultStream is the desired name of the stream that should be used as the default when no specific stream is requested by a MachineConfigPool.<br><p> <br><p> This field is set by the installer during installation. Users may need to update it if the currently selected stream is no longer available, for example when the stream has reached its End of Life. The MachineConfigOperator uses this value to determine which stream from status.availableStreams to apply as the default for MachineConfigPools that do not specify a stream override.<br><p> <br><p> When status.availableStreams has been populated by the operator, updating this field requires that the new value references the name of one of the streams in status.availableStreams. Status-only updates by the operator are not subject to this constraint, allowing the operator to update availableStreams independently of this field. During initial creation, before the operator has populated status, any valid value is accepted.<br><p> <br><p> When omitted, the operator determines the default stream automatically. Once set, this field cannot be removed.<br><p> <br><p> It must be a valid RFC 1123 subdomain between 1 and 253 characters in length, consisting of lowercase alphanumeric characters, hyphens ('-'), and periods ('.').
     */
    @JsonProperty("defaultStream")
    public String getDefaultStream() {
        return defaultStream;
    }

    /**
     * defaultStream is the desired name of the stream that should be used as the default when no specific stream is requested by a MachineConfigPool.<br><p> <br><p> This field is set by the installer during installation. Users may need to update it if the currently selected stream is no longer available, for example when the stream has reached its End of Life. The MachineConfigOperator uses this value to determine which stream from status.availableStreams to apply as the default for MachineConfigPools that do not specify a stream override.<br><p> <br><p> When status.availableStreams has been populated by the operator, updating this field requires that the new value references the name of one of the streams in status.availableStreams. Status-only updates by the operator are not subject to this constraint, allowing the operator to update availableStreams independently of this field. During initial creation, before the operator has populated status, any valid value is accepted.<br><p> <br><p> When omitted, the operator determines the default stream automatically. Once set, this field cannot be removed.<br><p> <br><p> It must be a valid RFC 1123 subdomain between 1 and 253 characters in length, consisting of lowercase alphanumeric characters, hyphens ('-'), and periods ('.').
     */
    @JsonProperty("defaultStream")
    public void setDefaultStream(String defaultStream) {
        this.defaultStream = defaultStream;
    }

    @JsonIgnore
    public OSImageStreamSpecBuilder edit() {
        return new OSImageStreamSpecBuilder(this);
    }

    @JsonIgnore
    public OSImageStreamSpecBuilder toBuilder() {
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
