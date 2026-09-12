
package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

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
 * CredentialsRequestStatus defines the observed state of CredentialsRequest
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "lastSyncCloudCredsSecretResourceVersion",
    "lastSyncGeneration",
    "lastSyncInfrastructureResourceVersion",
    "lastSyncTimestamp",
    "providerStatus",
    "provisioned"
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
public class CredentialsRequestStatus implements Editable<CredentialsRequestStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CredentialsRequestCondition> conditions = new ArrayList<>();
    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    private String lastSyncCloudCredsSecretResourceVersion;
    @JsonProperty("lastSyncGeneration")
    private Long lastSyncGeneration;
    @JsonProperty("lastSyncInfrastructureResourceVersion")
    private String lastSyncInfrastructureResourceVersion;
    @JsonProperty("lastSyncTimestamp")
    private String lastSyncTimestamp;
    @JsonProperty("providerStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object providerStatus;
    @JsonProperty("provisioned")
    private Boolean provisioned;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CredentialsRequestStatus() {
    }

    public CredentialsRequestStatus(List<CredentialsRequestCondition> conditions, String lastSyncCloudCredsSecretResourceVersion, Long lastSyncGeneration, String lastSyncInfrastructureResourceVersion, String lastSyncTimestamp, Object providerStatus, Boolean provisioned) {
        super();
        this.conditions = conditions;
        this.lastSyncCloudCredsSecretResourceVersion = lastSyncCloudCredsSecretResourceVersion;
        this.lastSyncGeneration = lastSyncGeneration;
        this.lastSyncInfrastructureResourceVersion = lastSyncInfrastructureResourceVersion;
        this.lastSyncTimestamp = lastSyncTimestamp;
        this.providerStatus = providerStatus;
        this.provisioned = provisioned;
    }

    /**
     * Conditions includes detailed status for the CredentialsRequest
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CredentialsRequestCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions includes detailed status for the CredentialsRequest
     */
    @JsonProperty("conditions")
    public void setConditions(List<CredentialsRequestCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * LastSyncCloudCredsSecretResourceVersion is the resource version of the cloud credentials secret resource when the credentials request resource was last synced. Used to determine if the cloud credentials have been updated since the last sync.
     */
    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    public String getLastSyncCloudCredsSecretResourceVersion() {
        return lastSyncCloudCredsSecretResourceVersion;
    }

    /**
     * LastSyncCloudCredsSecretResourceVersion is the resource version of the cloud credentials secret resource when the credentials request resource was last synced. Used to determine if the cloud credentials have been updated since the last sync.
     */
    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    public void setLastSyncCloudCredsSecretResourceVersion(String lastSyncCloudCredsSecretResourceVersion) {
        this.lastSyncCloudCredsSecretResourceVersion = lastSyncCloudCredsSecretResourceVersion;
    }

    /**
     * LastSyncGeneration is the generation of the credentials request resource that was last synced. Used to determine if the object has changed and requires a sync.
     */
    @JsonProperty("lastSyncGeneration")
    public Long getLastSyncGeneration() {
        return lastSyncGeneration;
    }

    /**
     * LastSyncGeneration is the generation of the credentials request resource that was last synced. Used to determine if the object has changed and requires a sync.
     */
    @JsonProperty("lastSyncGeneration")
    public void setLastSyncGeneration(Long lastSyncGeneration) {
        this.lastSyncGeneration = lastSyncGeneration;
    }

    /**
     * LastSyncInfrastructureResourceVersion is the resource version of the Infrastructure resource. It is used to determine if the user provided tags have been updated since the last sync.
     */
    @JsonProperty("lastSyncInfrastructureResourceVersion")
    public String getLastSyncInfrastructureResourceVersion() {
        return lastSyncInfrastructureResourceVersion;
    }

    /**
     * LastSyncInfrastructureResourceVersion is the resource version of the Infrastructure resource. It is used to determine if the user provided tags have been updated since the last sync.
     */
    @JsonProperty("lastSyncInfrastructureResourceVersion")
    public void setLastSyncInfrastructureResourceVersion(String lastSyncInfrastructureResourceVersion) {
        this.lastSyncInfrastructureResourceVersion = lastSyncInfrastructureResourceVersion;
    }

    /**
     * CredentialsRequestStatus defines the observed state of CredentialsRequest
     */
    @JsonProperty("lastSyncTimestamp")
    public String getLastSyncTimestamp() {
        return lastSyncTimestamp;
    }

    /**
     * CredentialsRequestStatus defines the observed state of CredentialsRequest
     */
    @JsonProperty("lastSyncTimestamp")
    public void setLastSyncTimestamp(String lastSyncTimestamp) {
        this.lastSyncTimestamp = lastSyncTimestamp;
    }

    /**
     * CredentialsRequestStatus defines the observed state of CredentialsRequest
     */
    @JsonProperty("providerStatus")
    public Object getProviderStatus() {
        return providerStatus;
    }

    /**
     * CredentialsRequestStatus defines the observed state of CredentialsRequest
     */
    @JsonProperty("providerStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setProviderStatus(Object providerStatus) {
        this.providerStatus = providerStatus;
    }

    /**
     * Provisioned is true once the credentials have been initially provisioned.
     */
    @JsonProperty("provisioned")
    public Boolean getProvisioned() {
        return provisioned;
    }

    /**
     * Provisioned is true once the credentials have been initially provisioned.
     */
    @JsonProperty("provisioned")
    public void setProvisioned(Boolean provisioned) {
        this.provisioned = provisioned;
    }

    @JsonIgnore
    public CredentialsRequestStatusBuilder edit() {
        return new CredentialsRequestStatusBuilder(this);
    }

    @JsonIgnore
    public CredentialsRequestStatusBuilder toBuilder() {
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
        if (!(o instanceof CredentialsRequestStatus)) {
            return false;
        }
        CredentialsRequestStatus other = (CredentialsRequestStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$lastSyncCloudCredsSecretResourceVersion = this.getLastSyncCloudCredsSecretResourceVersion();
        Object other$lastSyncCloudCredsSecretResourceVersion = other.getLastSyncCloudCredsSecretResourceVersion();
        if (this$lastSyncCloudCredsSecretResourceVersion == null ? other$lastSyncCloudCredsSecretResourceVersion != null : !this$lastSyncCloudCredsSecretResourceVersion.equals(other$lastSyncCloudCredsSecretResourceVersion)) {
            return false;
        }
        Object this$lastSyncGeneration = this.getLastSyncGeneration();
        Object other$lastSyncGeneration = other.getLastSyncGeneration();
        if (this$lastSyncGeneration == null ? other$lastSyncGeneration != null : !this$lastSyncGeneration.equals(other$lastSyncGeneration)) {
            return false;
        }
        Object this$lastSyncInfrastructureResourceVersion = this.getLastSyncInfrastructureResourceVersion();
        Object other$lastSyncInfrastructureResourceVersion = other.getLastSyncInfrastructureResourceVersion();
        if (this$lastSyncInfrastructureResourceVersion == null ? other$lastSyncInfrastructureResourceVersion != null : !this$lastSyncInfrastructureResourceVersion.equals(other$lastSyncInfrastructureResourceVersion)) {
            return false;
        }
        Object this$lastSyncTimestamp = this.getLastSyncTimestamp();
        Object other$lastSyncTimestamp = other.getLastSyncTimestamp();
        if (this$lastSyncTimestamp == null ? other$lastSyncTimestamp != null : !this$lastSyncTimestamp.equals(other$lastSyncTimestamp)) {
            return false;
        }
        Object this$providerStatus = this.getProviderStatus();
        Object other$providerStatus = other.getProviderStatus();
        if (this$providerStatus == null ? other$providerStatus != null : !this$providerStatus.equals(other$providerStatus)) {
            return false;
        }
        Object this$provisioned = this.getProvisioned();
        Object other$provisioned = other.getProvisioned();
        if (this$provisioned == null ? other$provisioned != null : !this$provisioned.equals(other$provisioned)) {
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
        return other instanceof CredentialsRequestStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $lastSyncCloudCredsSecretResourceVersion = this.getLastSyncCloudCredsSecretResourceVersion();
        result = result * prime + ($lastSyncCloudCredsSecretResourceVersion == null ? 43 : $lastSyncCloudCredsSecretResourceVersion.hashCode());
        Object $lastSyncGeneration = this.getLastSyncGeneration();
        result = result * prime + ($lastSyncGeneration == null ? 43 : $lastSyncGeneration.hashCode());
        Object $lastSyncInfrastructureResourceVersion = this.getLastSyncInfrastructureResourceVersion();
        result = result * prime + ($lastSyncInfrastructureResourceVersion == null ? 43 : $lastSyncInfrastructureResourceVersion.hashCode());
        Object $lastSyncTimestamp = this.getLastSyncTimestamp();
        result = result * prime + ($lastSyncTimestamp == null ? 43 : $lastSyncTimestamp.hashCode());
        Object $providerStatus = this.getProviderStatus();
        result = result * prime + ($providerStatus == null ? 43 : $providerStatus.hashCode());
        Object $provisioned = this.getProvisioned();
        result = result * prime + ($provisioned == null ? 43 : $provisioned.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CredentialsRequestStatus(" + "conditions=" + this.getConditions() + ", lastSyncCloudCredsSecretResourceVersion=" + this.getLastSyncCloudCredsSecretResourceVersion() + ", lastSyncGeneration=" + this.getLastSyncGeneration() + ", lastSyncInfrastructureResourceVersion=" + this.getLastSyncInfrastructureResourceVersion() + ", lastSyncTimestamp=" + this.getLastSyncTimestamp() + ", providerStatus=" + this.getProviderStatus() + ", provisioned=" + this.getProvisioned() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
