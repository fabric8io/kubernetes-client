
package io.fabric8.openshift.api.model.operator.v1;

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

/**
 * IrreconcilableValidationOverrides holds the irreconcilable validations overrides to be applied on each rendered MachineConfig generation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "storage"
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
public class IrreconcilableValidationOverrides implements Editable<IrreconcilableValidationOverridesBuilder>, KubernetesResource
{

    @JsonProperty("storage")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> storage = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IrreconcilableValidationOverrides() {
    }

    public IrreconcilableValidationOverrides(List<String> storage) {
        super();
        this.storage = storage;
    }

    /**
     * storage can be used to allow making irreconcilable changes to the selected sections under the `spec.config.storage` field of MachineConfig CRs It must have at least one item, may not exceed 3 items and must not contain duplicates. Allowed element values are "Disks", "FileSystems", "Raid" and omitted. When contains "Disks" changes to the `spec.config.storage.disks` section of MachineConfig CRs are allowed. When contains "FileSystems" changes to the `spec.config.storage.filesystems` section of MachineConfig CRs are allowed. When contains "Raid" changes to the `spec.config.storage.raid` section of MachineConfig CRs are allowed. When omitted changes to the `spec.config.storage` section are forbidden.
     */
    @JsonProperty("storage")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getStorage() {
        return storage;
    }

    /**
     * storage can be used to allow making irreconcilable changes to the selected sections under the `spec.config.storage` field of MachineConfig CRs It must have at least one item, may not exceed 3 items and must not contain duplicates. Allowed element values are "Disks", "FileSystems", "Raid" and omitted. When contains "Disks" changes to the `spec.config.storage.disks` section of MachineConfig CRs are allowed. When contains "FileSystems" changes to the `spec.config.storage.filesystems` section of MachineConfig CRs are allowed. When contains "Raid" changes to the `spec.config.storage.raid` section of MachineConfig CRs are allowed. When omitted changes to the `spec.config.storage` section are forbidden.
     */
    @JsonProperty("storage")
    public void setStorage(List<String> storage) {
        this.storage = storage;
    }

    @JsonIgnore
    public IrreconcilableValidationOverridesBuilder edit() {
        return new IrreconcilableValidationOverridesBuilder(this);
    }

    @JsonIgnore
    public IrreconcilableValidationOverridesBuilder toBuilder() {
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
        if (!(o instanceof IrreconcilableValidationOverrides)) {
            return false;
        }
        IrreconcilableValidationOverrides other = (IrreconcilableValidationOverrides) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$storage = this.getStorage();
        Object other$storage = other.getStorage();
        if (this$storage == null ? other$storage != null : !this$storage.equals(other$storage)) {
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
        return other instanceof IrreconcilableValidationOverrides;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $storage = this.getStorage();
        result = result * prime + ($storage == null ? 43 : $storage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IrreconcilableValidationOverrides(" + "storage=" + this.getStorage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
