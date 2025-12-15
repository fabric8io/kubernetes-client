
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * AzureKeyVaultKms service settings for the security profile. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/use-kms-etcd-encryption#update-key-vault-mode
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enabled",
    "keyID",
    "keyVaultNetworkAccess",
    "keyVaultResourceID"
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
public class AzureKeyVaultKms implements Editable<AzureKeyVaultKmsBuilder>, KubernetesResource
{

    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("keyID")
    private String keyID;
    @JsonProperty("keyVaultNetworkAccess")
    private String keyVaultNetworkAccess;
    @JsonProperty("keyVaultResourceID")
    private String keyVaultResourceID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureKeyVaultKms() {
    }

    public AzureKeyVaultKms(Boolean enabled, String keyID, String keyVaultNetworkAccess, String keyVaultResourceID) {
        super();
        this.enabled = enabled;
        this.keyID = keyID;
        this.keyVaultNetworkAccess = keyVaultNetworkAccess;
        this.keyVaultResourceID = keyVaultResourceID;
    }

    /**
     * Enabled enables the Azure Key Vault key management service. The default is false.
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Enabled enables the Azure Key Vault key management service. The default is false.
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * KeyID defines the Identifier of Azure Key Vault key. When Azure Key Vault key management service is enabled, this field is required and must be a valid key identifier.
     */
    @JsonProperty("keyID")
    public String getKeyID() {
        return keyID;
    }

    /**
     * KeyID defines the Identifier of Azure Key Vault key. When Azure Key Vault key management service is enabled, this field is required and must be a valid key identifier.
     */
    @JsonProperty("keyID")
    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    /**
     * KeyVaultNetworkAccess defines the network access of key vault. The possible values are Public and Private. Public means the key vault allows public access from all networks. Private means the key vault disables public access and enables private link. The default value is Public.
     */
    @JsonProperty("keyVaultNetworkAccess")
    public String getKeyVaultNetworkAccess() {
        return keyVaultNetworkAccess;
    }

    /**
     * KeyVaultNetworkAccess defines the network access of key vault. The possible values are Public and Private. Public means the key vault allows public access from all networks. Private means the key vault disables public access and enables private link. The default value is Public.
     */
    @JsonProperty("keyVaultNetworkAccess")
    public void setKeyVaultNetworkAccess(String keyVaultNetworkAccess) {
        this.keyVaultNetworkAccess = keyVaultNetworkAccess;
    }

    /**
     * KeyVaultResourceID is the Resource ID of key vault. When keyVaultNetworkAccess is Private, this field is required and must be a valid resource ID.
     */
    @JsonProperty("keyVaultResourceID")
    public String getKeyVaultResourceID() {
        return keyVaultResourceID;
    }

    /**
     * KeyVaultResourceID is the Resource ID of key vault. When keyVaultNetworkAccess is Private, this field is required and must be a valid resource ID.
     */
    @JsonProperty("keyVaultResourceID")
    public void setKeyVaultResourceID(String keyVaultResourceID) {
        this.keyVaultResourceID = keyVaultResourceID;
    }

    @JsonIgnore
    public AzureKeyVaultKmsBuilder edit() {
        return new AzureKeyVaultKmsBuilder(this);
    }

    @JsonIgnore
    public AzureKeyVaultKmsBuilder toBuilder() {
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
