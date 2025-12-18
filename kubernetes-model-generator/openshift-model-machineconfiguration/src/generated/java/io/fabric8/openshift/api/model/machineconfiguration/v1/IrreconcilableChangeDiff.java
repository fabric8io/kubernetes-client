
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * IrreconcilableChangeDiff holds an individual diff between the initial install-time MachineConfig and the latest applied one caused by the presence of irreconcilable changes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "diff",
    "fieldPath"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class IrreconcilableChangeDiff implements Editable<IrreconcilableChangeDiffBuilder>, KubernetesResource
{

    @JsonProperty("diff")
    private String diff;
    @JsonProperty("fieldPath")
    private String fieldPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IrreconcilableChangeDiff() {
    }

    public IrreconcilableChangeDiff(String diff, String fieldPath) {
        super();
        this.diff = diff;
        this.fieldPath = fieldPath;
    }

    /**
     * diff is a required field containing the difference between the nodes current configuration and the latest rendered MachineConfig for the field specified in fieldPath. Must not be an empty string and must not exceed 4096 characters in length.
     */
    @JsonProperty("diff")
    public String getDiff() {
        return diff;
    }

    /**
     * diff is a required field containing the difference between the nodes current configuration and the latest rendered MachineConfig for the field specified in fieldPath. Must not be an empty string and must not exceed 4096 characters in length.
     */
    @JsonProperty("diff")
    public void setDiff(String diff) {
        this.diff = diff;
    }

    /**
     * fieldPath is a required reference to the path in the latest rendered MachineConfig that differs from this nodes configuration. Must not be empty and must not exceed 70 characters in length. Must begin with the prefix 'spec.' and only contain alphanumeric characters, square brackets ('[]'), or dots ('.').
     */
    @JsonProperty("fieldPath")
    public String getFieldPath() {
        return fieldPath;
    }

    /**
     * fieldPath is a required reference to the path in the latest rendered MachineConfig that differs from this nodes configuration. Must not be empty and must not exceed 70 characters in length. Must begin with the prefix 'spec.' and only contain alphanumeric characters, square brackets ('[]'), or dots ('.').
     */
    @JsonProperty("fieldPath")
    public void setFieldPath(String fieldPath) {
        this.fieldPath = fieldPath;
    }

    @JsonIgnore
    public IrreconcilableChangeDiffBuilder edit() {
        return new IrreconcilableChangeDiffBuilder(this);
    }

    @JsonIgnore
    public IrreconcilableChangeDiffBuilder toBuilder() {
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
