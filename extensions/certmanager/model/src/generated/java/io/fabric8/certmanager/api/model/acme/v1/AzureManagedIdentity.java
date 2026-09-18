
package io.fabric8.certmanager.api.model.acme.v1;

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
 * AzureManagedIdentity contains the configuration for Azure Workload Identity or Azure Managed Service Identity If the AZURE_FEDERATED_TOKEN_FILE environment variable is set, the Azure Workload Identity will be used. Otherwise, we fall back to using Azure Managed Service Identity.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientID",
    "resourceID",
    "tenantID"
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
public class AzureManagedIdentity implements Editable<AzureManagedIdentityBuilder>, KubernetesResource
{

    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("resourceID")
    private String resourceID;
    @JsonProperty("tenantID")
    private String tenantID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureManagedIdentity() {
    }

    public AzureManagedIdentity(String clientID, String resourceID, String tenantID) {
        super();
        this.clientID = clientID;
        this.resourceID = resourceID;
        this.tenantID = tenantID;
    }

    /**
     * client ID of the managed identity, cannot be used at the same time as resourceID
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * client ID of the managed identity, cannot be used at the same time as resourceID
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * resource ID of the managed identity, cannot be used at the same time as clientID Cannot be used for Azure Managed Service Identity
     */
    @JsonProperty("resourceID")
    public String getResourceID() {
        return resourceID;
    }

    /**
     * resource ID of the managed identity, cannot be used at the same time as clientID Cannot be used for Azure Managed Service Identity
     */
    @JsonProperty("resourceID")
    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    /**
     * tenant ID of the managed identity, cannot be used at the same time as resourceID
     */
    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    /**
     * tenant ID of the managed identity, cannot be used at the same time as resourceID
     */
    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    @JsonIgnore
    public AzureManagedIdentityBuilder edit() {
        return new AzureManagedIdentityBuilder(this);
    }

    @JsonIgnore
    public AzureManagedIdentityBuilder toBuilder() {
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
        if (!(o instanceof AzureManagedIdentity)) {
            return false;
        }
        AzureManagedIdentity other = (AzureManagedIdentity) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientID = this.getClientID();
        Object other$clientID = other.getClientID();
        if (this$clientID == null ? other$clientID != null : !this$clientID.equals(other$clientID)) {
            return false;
        }
        Object this$resourceID = this.getResourceID();
        Object other$resourceID = other.getResourceID();
        if (this$resourceID == null ? other$resourceID != null : !this$resourceID.equals(other$resourceID)) {
            return false;
        }
        Object this$tenantID = this.getTenantID();
        Object other$tenantID = other.getTenantID();
        if (this$tenantID == null ? other$tenantID != null : !this$tenantID.equals(other$tenantID)) {
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
        return other instanceof AzureManagedIdentity;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientID = this.getClientID();
        result = result * prime + ($clientID == null ? 43 : $clientID.hashCode());
        Object $resourceID = this.getResourceID();
        result = result * prime + ($resourceID == null ? 43 : $resourceID.hashCode());
        Object $tenantID = this.getTenantID();
        result = result * prime + ($tenantID == null ? 43 : $tenantID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureManagedIdentity(" + "clientID=" + this.getClientID() + ", resourceID=" + this.getResourceID() + ", tenantID=" + this.getTenantID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
