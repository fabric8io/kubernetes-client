
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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

/**
 * FirmwareComponentStatus defines the status of a firmware component.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "component",
    "currentVersion",
    "initialVersion",
    "lastVersionFlashed",
    "updatedAt"
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
public class FirmwareComponentStatus implements Editable<FirmwareComponentStatusBuilder>, KubernetesResource
{

    @JsonProperty("component")
    private String component;
    @JsonProperty("currentVersion")
    private String currentVersion;
    @JsonProperty("initialVersion")
    private String initialVersion;
    @JsonProperty("lastVersionFlashed")
    private String lastVersionFlashed;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FirmwareComponentStatus() {
    }

    public FirmwareComponentStatus(String component, String currentVersion, String initialVersion, String lastVersionFlashed, String updatedAt) {
        super();
        this.component = component;
        this.currentVersion = currentVersion;
        this.initialVersion = initialVersion;
        this.lastVersionFlashed = lastVersionFlashed;
        this.updatedAt = updatedAt;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("component")
    public String getComponent() {
        return component;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("component")
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("currentVersion")
    public String getCurrentVersion() {
        return currentVersion;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("currentVersion")
    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("initialVersion")
    public String getInitialVersion() {
        return initialVersion;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("initialVersion")
    public void setInitialVersion(String initialVersion) {
        this.initialVersion = initialVersion;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("lastVersionFlashed")
    public String getLastVersionFlashed() {
        return lastVersionFlashed;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("lastVersionFlashed")
    public void setLastVersionFlashed(String lastVersionFlashed) {
        this.lastVersionFlashed = lastVersionFlashed;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * FirmwareComponentStatus defines the status of a firmware component.
     */
    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    public FirmwareComponentStatusBuilder edit() {
        return new FirmwareComponentStatusBuilder(this);
    }

    @JsonIgnore
    public FirmwareComponentStatusBuilder toBuilder() {
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
        if (!(o instanceof FirmwareComponentStatus)) {
            return false;
        }
        FirmwareComponentStatus other = (FirmwareComponentStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$component = this.getComponent();
        Object other$component = other.getComponent();
        if (this$component == null ? other$component != null : !this$component.equals(other$component)) {
            return false;
        }
        Object this$currentVersion = this.getCurrentVersion();
        Object other$currentVersion = other.getCurrentVersion();
        if (this$currentVersion == null ? other$currentVersion != null : !this$currentVersion.equals(other$currentVersion)) {
            return false;
        }
        Object this$initialVersion = this.getInitialVersion();
        Object other$initialVersion = other.getInitialVersion();
        if (this$initialVersion == null ? other$initialVersion != null : !this$initialVersion.equals(other$initialVersion)) {
            return false;
        }
        Object this$lastVersionFlashed = this.getLastVersionFlashed();
        Object other$lastVersionFlashed = other.getLastVersionFlashed();
        if (this$lastVersionFlashed == null ? other$lastVersionFlashed != null : !this$lastVersionFlashed.equals(other$lastVersionFlashed)) {
            return false;
        }
        Object this$updatedAt = this.getUpdatedAt();
        Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) {
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
        return other instanceof FirmwareComponentStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $component = this.getComponent();
        result = result * prime + ($component == null ? 43 : $component.hashCode());
        Object $currentVersion = this.getCurrentVersion();
        result = result * prime + ($currentVersion == null ? 43 : $currentVersion.hashCode());
        Object $initialVersion = this.getInitialVersion();
        result = result * prime + ($initialVersion == null ? 43 : $initialVersion.hashCode());
        Object $lastVersionFlashed = this.getLastVersionFlashed();
        result = result * prime + ($lastVersionFlashed == null ? 43 : $lastVersionFlashed.hashCode());
        Object $updatedAt = this.getUpdatedAt();
        result = result * prime + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FirmwareComponentStatus(" + "component=" + this.getComponent() + ", currentVersion=" + this.getCurrentVersion() + ", initialVersion=" + this.getInitialVersion() + ", lastVersionFlashed=" + this.getLastVersionFlashed() + ", updatedAt=" + this.getUpdatedAt() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
