
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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
 * ACMEIssuerDNS01ProviderAzureDNS is a structure containing the configuration for Azure DNS
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientID",
    "clientSecretSecretRef",
    "environment",
    "hostedZoneName",
    "managedIdentity",
    "resourceGroupName",
    "subscriptionID",
    "tenantID",
    "zoneType"
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
public class ACMEIssuerDNS01ProviderAzureDNS implements Editable<ACMEIssuerDNS01ProviderAzureDNSBuilder>, KubernetesResource
{

    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecretSecretRef")
    private SecretKeySelector clientSecretSecretRef;
    @JsonProperty("environment")
    private String environment;
    @JsonProperty("hostedZoneName")
    private String hostedZoneName;
    @JsonProperty("managedIdentity")
    private AzureManagedIdentity managedIdentity;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonProperty("tenantID")
    private String tenantID;
    @JsonProperty("zoneType")
    private String zoneType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerDNS01ProviderAzureDNS() {
    }

    public ACMEIssuerDNS01ProviderAzureDNS(String clientID, SecretKeySelector clientSecretSecretRef, String environment, String hostedZoneName, AzureManagedIdentity managedIdentity, String resourceGroupName, String subscriptionID, String tenantID, String zoneType) {
        super();
        this.clientID = clientID;
        this.clientSecretSecretRef = clientSecretSecretRef;
        this.environment = environment;
        this.hostedZoneName = hostedZoneName;
        this.managedIdentity = managedIdentity;
        this.resourceGroupName = resourceGroupName;
        this.subscriptionID = subscriptionID;
        this.tenantID = tenantID;
        this.zoneType = zoneType;
    }

    /**
     * Auth: Azure Service Principal: The ClientID of the Azure Service Principal used to authenticate with Azure DNS. If set, ClientSecret and TenantID must also be set.
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * Auth: Azure Service Principal: The ClientID of the Azure Service Principal used to authenticate with Azure DNS. If set, ClientSecret and TenantID must also be set.
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * ACMEIssuerDNS01ProviderAzureDNS is a structure containing the configuration for Azure DNS
     */
    @JsonProperty("clientSecretSecretRef")
    public SecretKeySelector getClientSecretSecretRef() {
        return clientSecretSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderAzureDNS is a structure containing the configuration for Azure DNS
     */
    @JsonProperty("clientSecretSecretRef")
    public void setClientSecretSecretRef(SecretKeySelector clientSecretSecretRef) {
        this.clientSecretSecretRef = clientSecretSecretRef;
    }

    /**
     * name of the Azure environment (default AzurePublicCloud)
     */
    @JsonProperty("environment")
    public String getEnvironment() {
        return environment;
    }

    /**
     * name of the Azure environment (default AzurePublicCloud)
     */
    @JsonProperty("environment")
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * name of the DNS zone that should be used
     */
    @JsonProperty("hostedZoneName")
    public String getHostedZoneName() {
        return hostedZoneName;
    }

    /**
     * name of the DNS zone that should be used
     */
    @JsonProperty("hostedZoneName")
    public void setHostedZoneName(String hostedZoneName) {
        this.hostedZoneName = hostedZoneName;
    }

    /**
     * ACMEIssuerDNS01ProviderAzureDNS is a structure containing the configuration for Azure DNS
     */
    @JsonProperty("managedIdentity")
    public AzureManagedIdentity getManagedIdentity() {
        return managedIdentity;
    }

    /**
     * ACMEIssuerDNS01ProviderAzureDNS is a structure containing the configuration for Azure DNS
     */
    @JsonProperty("managedIdentity")
    public void setManagedIdentity(AzureManagedIdentity managedIdentity) {
        this.managedIdentity = managedIdentity;
    }

    /**
     * resource group the DNS zone is located in
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * resource group the DNS zone is located in
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * ID of the Azure subscription
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * ID of the Azure subscription
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    /**
     * Auth: Azure Service Principal: The TenantID of the Azure Service Principal used to authenticate with Azure DNS. If set, ClientID and ClientSecret must also be set.
     */
    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    /**
     * Auth: Azure Service Principal: The TenantID of the Azure Service Principal used to authenticate with Azure DNS. If set, ClientID and ClientSecret must also be set.
     */
    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    /**
     * ZoneType determines which type of Azure DNS zone to use.<br><p> <br><p> Valid values are:<br><p>   - AzurePublicZone  (default): Use a public Azure DNS zone.<br><p>   - AzurePrivateZone: Use an Azure Private DNS zone.<br><p> <br><p> If not specified, AzurePublicZone is used.<br><p> <br><p> Support for Azure Private DNS zones is currently experimental and may change in future releases.
     */
    @JsonProperty("zoneType")
    public String getZoneType() {
        return zoneType;
    }

    /**
     * ZoneType determines which type of Azure DNS zone to use.<br><p> <br><p> Valid values are:<br><p>   - AzurePublicZone  (default): Use a public Azure DNS zone.<br><p>   - AzurePrivateZone: Use an Azure Private DNS zone.<br><p> <br><p> If not specified, AzurePublicZone is used.<br><p> <br><p> Support for Azure Private DNS zones is currently experimental and may change in future releases.
     */
    @JsonProperty("zoneType")
    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderAzureDNSBuilder edit() {
        return new ACMEIssuerDNS01ProviderAzureDNSBuilder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderAzureDNSBuilder toBuilder() {
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
        if (!(o instanceof ACMEIssuerDNS01ProviderAzureDNS)) {
            return false;
        }
        ACMEIssuerDNS01ProviderAzureDNS other = (ACMEIssuerDNS01ProviderAzureDNS) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientID = this.getClientID();
        Object other$clientID = other.getClientID();
        if (this$clientID == null ? other$clientID != null : !this$clientID.equals(other$clientID)) {
            return false;
        }
        Object this$clientSecretSecretRef = this.getClientSecretSecretRef();
        Object other$clientSecretSecretRef = other.getClientSecretSecretRef();
        if (this$clientSecretSecretRef == null ? other$clientSecretSecretRef != null : !this$clientSecretSecretRef.equals(other$clientSecretSecretRef)) {
            return false;
        }
        Object this$environment = this.getEnvironment();
        Object other$environment = other.getEnvironment();
        if (this$environment == null ? other$environment != null : !this$environment.equals(other$environment)) {
            return false;
        }
        Object this$hostedZoneName = this.getHostedZoneName();
        Object other$hostedZoneName = other.getHostedZoneName();
        if (this$hostedZoneName == null ? other$hostedZoneName != null : !this$hostedZoneName.equals(other$hostedZoneName)) {
            return false;
        }
        Object this$managedIdentity = this.getManagedIdentity();
        Object other$managedIdentity = other.getManagedIdentity();
        if (this$managedIdentity == null ? other$managedIdentity != null : !this$managedIdentity.equals(other$managedIdentity)) {
            return false;
        }
        Object this$resourceGroupName = this.getResourceGroupName();
        Object other$resourceGroupName = other.getResourceGroupName();
        if (this$resourceGroupName == null ? other$resourceGroupName != null : !this$resourceGroupName.equals(other$resourceGroupName)) {
            return false;
        }
        Object this$subscriptionID = this.getSubscriptionID();
        Object other$subscriptionID = other.getSubscriptionID();
        if (this$subscriptionID == null ? other$subscriptionID != null : !this$subscriptionID.equals(other$subscriptionID)) {
            return false;
        }
        Object this$tenantID = this.getTenantID();
        Object other$tenantID = other.getTenantID();
        if (this$tenantID == null ? other$tenantID != null : !this$tenantID.equals(other$tenantID)) {
            return false;
        }
        Object this$zoneType = this.getZoneType();
        Object other$zoneType = other.getZoneType();
        if (this$zoneType == null ? other$zoneType != null : !this$zoneType.equals(other$zoneType)) {
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
        return other instanceof ACMEIssuerDNS01ProviderAzureDNS;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientID = this.getClientID();
        result = result * prime + ($clientID == null ? 43 : $clientID.hashCode());
        Object $clientSecretSecretRef = this.getClientSecretSecretRef();
        result = result * prime + ($clientSecretSecretRef == null ? 43 : $clientSecretSecretRef.hashCode());
        Object $environment = this.getEnvironment();
        result = result * prime + ($environment == null ? 43 : $environment.hashCode());
        Object $hostedZoneName = this.getHostedZoneName();
        result = result * prime + ($hostedZoneName == null ? 43 : $hostedZoneName.hashCode());
        Object $managedIdentity = this.getManagedIdentity();
        result = result * prime + ($managedIdentity == null ? 43 : $managedIdentity.hashCode());
        Object $resourceGroupName = this.getResourceGroupName();
        result = result * prime + ($resourceGroupName == null ? 43 : $resourceGroupName.hashCode());
        Object $subscriptionID = this.getSubscriptionID();
        result = result * prime + ($subscriptionID == null ? 43 : $subscriptionID.hashCode());
        Object $tenantID = this.getTenantID();
        result = result * prime + ($tenantID == null ? 43 : $tenantID.hashCode());
        Object $zoneType = this.getZoneType();
        result = result * prime + ($zoneType == null ? 43 : $zoneType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEIssuerDNS01ProviderAzureDNS(" + "clientID=" + this.getClientID() + ", clientSecretSecretRef=" + this.getClientSecretSecretRef() + ", environment=" + this.getEnvironment() + ", hostedZoneName=" + this.getHostedZoneName() + ", managedIdentity=" + this.getManagedIdentity() + ", resourceGroupName=" + this.getResourceGroupName() + ", subscriptionID=" + this.getSubscriptionID() + ", tenantID=" + this.getTenantID() + ", zoneType=" + this.getZoneType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
