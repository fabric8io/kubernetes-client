
package io.fabric8.certmanager.api.model.acme.v1alpha2;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "clientID",
    "clientSecretSecretRef",
    "environment",
    "hostedZoneName",
    "resourceGroupName",
    "subscriptionID",
    "tenantID"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ACMEIssuerDNS01ProviderAzureDNS implements KubernetesResource
{

    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecretSecretRef")
    private SecretKeySelector clientSecretSecretRef;
    @JsonProperty("environment")
    private String environment;
    @JsonProperty("hostedZoneName")
    private String hostedZoneName;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonProperty("tenantID")
    private String tenantID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ACMEIssuerDNS01ProviderAzureDNS() {
    }

    /**
     * 
     * @param environment
     * @param clientID
     * @param resourceGroupName
     * @param clientSecretSecretRef
     * @param tenantID
     * @param subscriptionID
     * @param hostedZoneName
     */
    public ACMEIssuerDNS01ProviderAzureDNS(String clientID, SecretKeySelector clientSecretSecretRef, String environment, String hostedZoneName, String resourceGroupName, String subscriptionID, String tenantID) {
        super();
        this.clientID = clientID;
        this.clientSecretSecretRef = clientSecretSecretRef;
        this.environment = environment;
        this.hostedZoneName = hostedZoneName;
        this.resourceGroupName = resourceGroupName;
        this.subscriptionID = subscriptionID;
        this.tenantID = tenantID;
    }

    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    @JsonProperty("clientSecretSecretRef")
    public SecretKeySelector getClientSecretSecretRef() {
        return clientSecretSecretRef;
    }

    @JsonProperty("clientSecretSecretRef")
    public void setClientSecretSecretRef(SecretKeySelector clientSecretSecretRef) {
        this.clientSecretSecretRef = clientSecretSecretRef;
    }

    @JsonProperty("environment")
    public String getEnvironment() {
        return environment;
    }

    @JsonProperty("environment")
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @JsonProperty("hostedZoneName")
    public String getHostedZoneName() {
        return hostedZoneName;
    }

    @JsonProperty("hostedZoneName")
    public void setHostedZoneName(String hostedZoneName) {
        this.hostedZoneName = hostedZoneName;
    }

    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
