
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "lastSyncCloudCredsSecretResourceVersion",
    "lastSyncGeneration",
    "lastSyncTimestamp",
    "providerStatus",
    "provisioned"
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
public class CredentialsRequestStatus implements Editable<CredentialsRequestStatusBuilder> , KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CredentialsRequestCondition> conditions = new ArrayList<>();
    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    private String lastSyncCloudCredsSecretResourceVersion;
    @JsonProperty("lastSyncGeneration")
    private Long lastSyncGeneration;
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
     * 
     */
    public CredentialsRequestStatus() {
    }

    public CredentialsRequestStatus(List<CredentialsRequestCondition> conditions, String lastSyncCloudCredsSecretResourceVersion, Long lastSyncGeneration, String lastSyncTimestamp, Object providerStatus, Boolean provisioned) {
        super();
        this.conditions = conditions;
        this.lastSyncCloudCredsSecretResourceVersion = lastSyncCloudCredsSecretResourceVersion;
        this.lastSyncGeneration = lastSyncGeneration;
        this.lastSyncTimestamp = lastSyncTimestamp;
        this.providerStatus = providerStatus;
        this.provisioned = provisioned;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CredentialsRequestCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<CredentialsRequestCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    public String getLastSyncCloudCredsSecretResourceVersion() {
        return lastSyncCloudCredsSecretResourceVersion;
    }

    @JsonProperty("lastSyncCloudCredsSecretResourceVersion")
    public void setLastSyncCloudCredsSecretResourceVersion(String lastSyncCloudCredsSecretResourceVersion) {
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
    public Object getProviderStatus() {
        return providerStatus;
    }

    @JsonProperty("providerStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setProviderStatus(Object providerStatus) {
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

    @JsonIgnore
    public CredentialsRequestStatusBuilder edit() {
        return new CredentialsRequestStatusBuilder(this);
    }

    @JsonIgnore
    public CredentialsRequestStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
