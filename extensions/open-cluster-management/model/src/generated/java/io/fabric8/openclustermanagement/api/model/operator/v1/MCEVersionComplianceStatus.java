
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * MCEVersionComplianceStatus tracks MultiClusterEngine version compliance against required channel
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentVersion",
    "isCompliant",
    "message",
    "requiredChannel"
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
public class MCEVersionComplianceStatus implements Editable<MCEVersionComplianceStatusBuilder>, KubernetesResource
{

    @JsonProperty("currentVersion")
    private String currentVersion;
    @JsonProperty("isCompliant")
    private Boolean isCompliant;
    @JsonProperty("message")
    private String message;
    @JsonProperty("requiredChannel")
    private String requiredChannel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MCEVersionComplianceStatus() {
    }

    public MCEVersionComplianceStatus(String currentVersion, Boolean isCompliant, String message, String requiredChannel) {
        super();
        this.currentVersion = currentVersion;
        this.isCompliant = isCompliant;
        this.message = message;
        this.requiredChannel = requiredChannel;
    }

    /**
     * CurrentVersion is the actual version of the MCE that is currently installed
     */
    @JsonProperty("currentVersion")
    public String getCurrentVersion() {
        return currentVersion;
    }

    /**
     * CurrentVersion is the actual version of the MCE that is currently installed
     */
    @JsonProperty("currentVersion")
    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    /**
     * IsCompliant indicates whether the current MCE version meets or exceeds the required channel version
     */
    @JsonProperty("isCompliant")
    public Boolean getIsCompliant() {
        return isCompliant;
    }

    /**
     * IsCompliant indicates whether the current MCE version meets or exceeds the required channel version
     */
    @JsonProperty("isCompliant")
    public void setIsCompliant(Boolean isCompliant) {
        this.isCompliant = isCompliant;
    }

    /**
     * Message provides additional details about the compliance status
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message provides additional details about the compliance status
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * RequiredChannel is the channel version that MCE should meet or exceed
     */
    @JsonProperty("requiredChannel")
    public String getRequiredChannel() {
        return requiredChannel;
    }

    /**
     * RequiredChannel is the channel version that MCE should meet or exceed
     */
    @JsonProperty("requiredChannel")
    public void setRequiredChannel(String requiredChannel) {
        this.requiredChannel = requiredChannel;
    }

    @JsonIgnore
    public MCEVersionComplianceStatusBuilder edit() {
        return new MCEVersionComplianceStatusBuilder(this);
    }

    @JsonIgnore
    public MCEVersionComplianceStatusBuilder toBuilder() {
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
        if (!(o instanceof MCEVersionComplianceStatus)) {
            return false;
        }
        MCEVersionComplianceStatus other = (MCEVersionComplianceStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$currentVersion = this.getCurrentVersion();
        Object other$currentVersion = other.getCurrentVersion();
        if (this$currentVersion == null ? other$currentVersion != null : !this$currentVersion.equals(other$currentVersion)) {
            return false;
        }
        Object this$isCompliant = this.getIsCompliant();
        Object other$isCompliant = other.getIsCompliant();
        if (this$isCompliant == null ? other$isCompliant != null : !this$isCompliant.equals(other$isCompliant)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$requiredChannel = this.getRequiredChannel();
        Object other$requiredChannel = other.getRequiredChannel();
        if (this$requiredChannel == null ? other$requiredChannel != null : !this$requiredChannel.equals(other$requiredChannel)) {
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
        return other instanceof MCEVersionComplianceStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $currentVersion = this.getCurrentVersion();
        result = result * prime + ($currentVersion == null ? 43 : $currentVersion.hashCode());
        Object $isCompliant = this.getIsCompliant();
        result = result * prime + ($isCompliant == null ? 43 : $isCompliant.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $requiredChannel = this.getRequiredChannel();
        result = result * prime + ($requiredChannel == null ? 43 : $requiredChannel.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MCEVersionComplianceStatus(" + "currentVersion=" + this.getCurrentVersion() + ", isCompliant=" + this.getIsCompliant() + ", message=" + this.getMessage() + ", requiredChannel=" + this.getRequiredChannel() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
