
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AzureOAuth defines the Azure OAuth settings.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientId",
    "clientSecret",
    "tenantId"
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
public class AzureOAuth implements Editable<AzureOAuthBuilder>, KubernetesResource
{

    @JsonProperty("clientId")
    private String clientId;
    @JsonProperty("clientSecret")
    private SecretKeySelector clientSecret;
    @JsonProperty("tenantId")
    private String tenantId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureOAuth() {
    }

    public AzureOAuth(String clientId, SecretKeySelector clientSecret, String tenantId) {
        super();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tenantId = tenantId;
    }

    /**
     * clientId defines the clientId of the Azure Active Directory application that is being used to authenticate.
     */
    @JsonProperty("clientId")
    public String getClientId() {
        return clientId;
    }

    /**
     * clientId defines the clientId of the Azure Active Directory application that is being used to authenticate.
     */
    @JsonProperty("clientId")
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * AzureOAuth defines the Azure OAuth settings.
     */
    @JsonProperty("clientSecret")
    public SecretKeySelector getClientSecret() {
        return clientSecret;
    }

    /**
     * AzureOAuth defines the Azure OAuth settings.
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretKeySelector clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * tenantId is the tenant ID of the Azure Active Directory application that is being used to authenticate.
     */
    @JsonProperty("tenantId")
    public String getTenantId() {
        return tenantId;
    }

    /**
     * tenantId is the tenant ID of the Azure Active Directory application that is being used to authenticate.
     */
    @JsonProperty("tenantId")
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @JsonIgnore
    public AzureOAuthBuilder edit() {
        return new AzureOAuthBuilder(this);
    }

    @JsonIgnore
    public AzureOAuthBuilder toBuilder() {
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
        if (!(o instanceof AzureOAuth)) {
            return false;
        }
        AzureOAuth other = (AzureOAuth) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientId = this.getClientId();
        Object other$clientId = other.getClientId();
        if (this$clientId == null ? other$clientId != null : !this$clientId.equals(other$clientId)) {
            return false;
        }
        Object this$clientSecret = this.getClientSecret();
        Object other$clientSecret = other.getClientSecret();
        if (this$clientSecret == null ? other$clientSecret != null : !this$clientSecret.equals(other$clientSecret)) {
            return false;
        }
        Object this$tenantId = this.getTenantId();
        Object other$tenantId = other.getTenantId();
        if (this$tenantId == null ? other$tenantId != null : !this$tenantId.equals(other$tenantId)) {
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
        return other instanceof AzureOAuth;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientId = this.getClientId();
        result = result * prime + ($clientId == null ? 43 : $clientId.hashCode());
        Object $clientSecret = this.getClientSecret();
        result = result * prime + ($clientSecret == null ? 43 : $clientSecret.hashCode());
        Object $tenantId = this.getTenantId();
        result = result * prime + ($tenantId == null ? 43 : $tenantId.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureOAuth(" + "clientId=" + this.getClientId() + ", clientSecret=" + this.getClientSecret() + ", tenantId=" + this.getTenantId() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
