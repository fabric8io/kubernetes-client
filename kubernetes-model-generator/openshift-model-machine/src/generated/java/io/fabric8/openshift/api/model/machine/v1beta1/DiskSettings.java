
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * DiskSettings describe ephemeral disk settings for the os disk.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ephemeralStorageLocation"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class DiskSettings implements Editable<DiskSettingsBuilder>, KubernetesResource
{

    @JsonProperty("ephemeralStorageLocation")
    private String ephemeralStorageLocation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DiskSettings() {
    }

    public DiskSettings(String ephemeralStorageLocation) {
        super();
        this.ephemeralStorageLocation = ephemeralStorageLocation;
    }

    /**
     * ephemeralStorageLocation enables ephemeral OS when set to 'Local'. Possible values include: 'Local'. See https://docs.microsoft.com/en-us/azure/virtual-machines/ephemeral-os-disks for full details. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is that disks are saved to remote Azure storage.
     */
    @JsonProperty("ephemeralStorageLocation")
    public String getEphemeralStorageLocation() {
        return ephemeralStorageLocation;
    }

    /**
     * ephemeralStorageLocation enables ephemeral OS when set to 'Local'. Possible values include: 'Local'. See https://docs.microsoft.com/en-us/azure/virtual-machines/ephemeral-os-disks for full details. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is that disks are saved to remote Azure storage.
     */
    @JsonProperty("ephemeralStorageLocation")
    public void setEphemeralStorageLocation(String ephemeralStorageLocation) {
        this.ephemeralStorageLocation = ephemeralStorageLocation;
    }

    @JsonIgnore
    public DiskSettingsBuilder edit() {
        return new DiskSettingsBuilder(this);
    }

    @JsonIgnore
    public DiskSettingsBuilder toBuilder() {
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
        if (!(o instanceof DiskSettings)) {
            return false;
        }
        DiskSettings other = (DiskSettings) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ephemeralStorageLocation = this.getEphemeralStorageLocation();
        Object other$ephemeralStorageLocation = other.getEphemeralStorageLocation();
        if (this$ephemeralStorageLocation == null ? other$ephemeralStorageLocation != null : !this$ephemeralStorageLocation.equals(other$ephemeralStorageLocation)) {
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
        return other instanceof DiskSettings;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ephemeralStorageLocation = this.getEphemeralStorageLocation();
        result = result * prime + ($ephemeralStorageLocation == null ? 43 : $ephemeralStorageLocation.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DiskSettings(" + "ephemeralStorageLocation=" + this.getEphemeralStorageLocation() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
