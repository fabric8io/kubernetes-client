
package io.fabric8.kubernetes.api.model.clusterapi.metal3.v1alpha1;

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
 * HostUpdatePolicySpec defines the desired state of HostUpdatePolicy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "firmwareSettings",
    "firmwareUpdates"
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
public class HostUpdatePolicySpec implements Editable<HostUpdatePolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("firmwareSettings")
    private String firmwareSettings;
    @JsonProperty("firmwareUpdates")
    private String firmwareUpdates;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostUpdatePolicySpec() {
    }

    public HostUpdatePolicySpec(String firmwareSettings, String firmwareUpdates) {
        super();
        this.firmwareSettings = firmwareSettings;
        this.firmwareUpdates = firmwareUpdates;
    }

    /**
     * Defines policy for changing firmware settings
     */
    @JsonProperty("firmwareSettings")
    public String getFirmwareSettings() {
        return firmwareSettings;
    }

    /**
     * Defines policy for changing firmware settings
     */
    @JsonProperty("firmwareSettings")
    public void setFirmwareSettings(String firmwareSettings) {
        this.firmwareSettings = firmwareSettings;
    }

    /**
     * Defines policy for updating firmware
     */
    @JsonProperty("firmwareUpdates")
    public String getFirmwareUpdates() {
        return firmwareUpdates;
    }

    /**
     * Defines policy for updating firmware
     */
    @JsonProperty("firmwareUpdates")
    public void setFirmwareUpdates(String firmwareUpdates) {
        this.firmwareUpdates = firmwareUpdates;
    }

    @JsonIgnore
    public HostUpdatePolicySpecBuilder edit() {
        return new HostUpdatePolicySpecBuilder(this);
    }

    @JsonIgnore
    public HostUpdatePolicySpecBuilder toBuilder() {
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
