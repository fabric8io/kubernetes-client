
package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditions",
    "lastSyncCloudCredsSecretResourceVersion",
    "lastSyncGeneration",
    "lastSyncTimestamp",
    "providerStatus",
    "provisioned"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class CredentialsRequestStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CredentialsRequestCondition> conditions = new ArrayList<CredentialsRequestCondition>();
    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    private java.lang.String lastSyncCloudCredsSecretResourceVersion;
    @JsonProperty("lastSyncGeneration")
    private Long lastSyncGeneration;
    @JsonProperty("lastSyncTimestamp")
    private String lastSyncTimestamp;
    @JsonProperty("providerStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> providerStatus = new LinkedHashMap<String, Object>();
    @JsonProperty("provisioned")
    private Boolean provisioned;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CredentialsRequestStatus() {
    }

    public CredentialsRequestStatus(List<CredentialsRequestCondition> conditions, java.lang.String lastSyncCloudCredsSecretResourceVersion, Long lastSyncGeneration, String lastSyncTimestamp, Map<String, Object> providerStatus, Boolean provisioned) {
        super();
        this.conditions = conditions;
        this.lastSyncCloudCredsSecretResourceVersion = lastSyncCloudCredsSecretResourceVersion;
        this.lastSyncGeneration = lastSyncGeneration;
        this.lastSyncTimestamp = lastSyncTimestamp;
        this.providerStatus = providerStatus;
        this.provisioned = provisioned;
    }

    @JsonProperty("conditions")
    public List<CredentialsRequestCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<CredentialsRequestCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    public java.lang.String getLastSyncCloudCredsSecretResourceVersion() {
        return lastSyncCloudCredsSecretResourceVersion;
    }

    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    public void setLastSyncCloudCredsSecretResourceVersion(java.lang.String lastSyncCloudCredsSecretResourceVersion) {
        this.lastSyncCloudCredsSecretResourceVersion = lastSyncCloudCredsSecretResourceVersion;
    }

    @JsonProperty("lastSyncGeneration")
    public Long getLastSyncGeneration() {
        return lastSyncGeneration;
    }

    @JsonProperty("lastSyncGeneration")
    public void setLastSyncGeneration(Long lastSyncGeneration) {
        this.lastSyncGeneration = lastSyncGeneration;
    }

    @JsonProperty("lastSyncTimestamp")
    public String getLastSyncTimestamp() {
        return lastSyncTimestamp;
    }

    @JsonProperty("lastSyncTimestamp")
    public void setLastSyncTimestamp(String lastSyncTimestamp) {
        this.lastSyncTimestamp = lastSyncTimestamp;
    }

    @JsonProperty("providerStatus")
    public Map<String, Object> getProviderStatus() {
        return providerStatus;
    }

    @JsonProperty("providerStatus")
    public void setProviderStatus(Map<String, Object> providerStatus) {
        this.providerStatus = providerStatus;
    }

    @JsonProperty("provisioned")
    public Boolean getProvisioned() {
        return provisioned;
    }

    @JsonProperty("provisioned")
    public void setProvisioned(Boolean provisioned) {
        this.provisioned = provisioned;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
