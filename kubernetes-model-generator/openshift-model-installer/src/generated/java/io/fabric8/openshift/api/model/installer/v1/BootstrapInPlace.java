
package io.fabric8.openshift.api.model.installer.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * BootstrapInPlace defines the configuration for bootstrap-in-place installation
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "installationDisk"
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
public class BootstrapInPlace implements Editable<BootstrapInPlaceBuilder>, KubernetesResource
{

    @JsonProperty("installationDisk")
    private String installationDisk;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BootstrapInPlace() {
    }

    public BootstrapInPlace(String installationDisk) {
        super();
        this.installationDisk = installationDisk;
    }

    /**
     * InstallationDisk is the target disk drive for coreos-installer
     */
    @JsonProperty("installationDisk")
    public String getInstallationDisk() {
        return installationDisk;
    }

    /**
     * InstallationDisk is the target disk drive for coreos-installer
     */
    @JsonProperty("installationDisk")
    public void setInstallationDisk(String installationDisk) {
        this.installationDisk = installationDisk;
    }

    @JsonIgnore
    public BootstrapInPlaceBuilder edit() {
        return new BootstrapInPlaceBuilder(this);
    }

    @JsonIgnore
    public BootstrapInPlaceBuilder toBuilder() {
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
        if (!(o instanceof BootstrapInPlace)) {
            return false;
        }
        BootstrapInPlace other = (BootstrapInPlace) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$installationDisk = this.getInstallationDisk();
        Object other$installationDisk = other.getInstallationDisk();
        if (this$installationDisk == null ? other$installationDisk != null : !this$installationDisk.equals(other$installationDisk)) {
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
        return other instanceof BootstrapInPlace;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $installationDisk = this.getInstallationDisk();
        result = result * prime + ($installationDisk == null ? 43 : $installationDisk.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BootstrapInPlace(" + "installationDisk=" + this.getInstallationDisk() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
