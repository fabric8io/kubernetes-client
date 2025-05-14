
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

}
