
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
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureClusterIdentitySpec defines the parameters that are used to create an AzureIdentity.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedNamespaces",
    "certPath",
    "clientID",
    "clientSecret",
    "resourceID",
    "tenantID",
    "type",
    "userAssignedIdentityCredentialsCloudType",
    "userAssignedIdentityCredentialsPath"
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
public class AzureClusterIdentitySpec implements Editable<AzureClusterIdentitySpecBuilder>, KubernetesResource
{

    @JsonProperty("allowedNamespaces")
    private AllowedNamespaces allowedNamespaces;
    @JsonProperty("certPath")
    private String certPath;
    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecret")
    private SecretReference clientSecret;
    @JsonProperty("resourceID")
    private String resourceID;
    @JsonProperty("tenantID")
    private String tenantID;
    @JsonProperty("type")
    private String type;
    @JsonProperty("userAssignedIdentityCredentialsCloudType")
    private String userAssignedIdentityCredentialsCloudType;
    @JsonProperty("userAssignedIdentityCredentialsPath")
    private String userAssignedIdentityCredentialsPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureClusterIdentitySpec() {
    }

    public AzureClusterIdentitySpec(AllowedNamespaces allowedNamespaces, String certPath, String clientID, SecretReference clientSecret, String resourceID, String tenantID, String type, String userAssignedIdentityCredentialsCloudType, String userAssignedIdentityCredentialsPath) {
        super();
        this.allowedNamespaces = allowedNamespaces;
        this.certPath = certPath;
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.resourceID = resourceID;
        this.tenantID = tenantID;
        this.type = type;
        this.userAssignedIdentityCredentialsCloudType = userAssignedIdentityCredentialsCloudType;
        this.userAssignedIdentityCredentialsPath = userAssignedIdentityCredentialsPath;
    }

    /**
     * AzureClusterIdentitySpec defines the parameters that are used to create an AzureIdentity.
     */
    @JsonProperty("allowedNamespaces")
    public AllowedNamespaces getAllowedNamespaces() {
        return allowedNamespaces;
    }

    /**
     * AzureClusterIdentitySpec defines the parameters that are used to create an AzureIdentity.
     */
    @JsonProperty("allowedNamespaces")
    public void setAllowedNamespaces(AllowedNamespaces allowedNamespaces) {
        this.allowedNamespaces = allowedNamespaces;
    }

    /**
     * CertPath is the path where certificates exist. When set, it takes precedence over ClientSecret for types that use certs like ServicePrincipalCertificate.
     */
    @JsonProperty("certPath")
    public String getCertPath() {
        return certPath;
    }

    /**
     * CertPath is the path where certificates exist. When set, it takes precedence over ClientSecret for types that use certs like ServicePrincipalCertificate.
     */
    @JsonProperty("certPath")
    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    /**
     * ClientID is the service principal client ID. Both User Assigned MSI and SP can use this field.
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * ClientID is the service principal client ID. Both User Assigned MSI and SP can use this field.
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * AzureClusterIdentitySpec defines the parameters that are used to create an AzureIdentity.
     */
    @JsonProperty("clientSecret")
    public SecretReference getClientSecret() {
        return clientSecret;
    }

    /**
     * AzureClusterIdentitySpec defines the parameters that are used to create an AzureIdentity.
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretReference clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * ResourceID is the Azure resource ID for the User Assigned MSI resource. Only applicable when type is UserAssignedMSI.<br><p> <br><p> Deprecated: This field no longer has any effect.
     */
    @JsonProperty("resourceID")
    public String getResourceID() {
        return resourceID;
    }

    /**
     * ResourceID is the Azure resource ID for the User Assigned MSI resource. Only applicable when type is UserAssignedMSI.<br><p> <br><p> Deprecated: This field no longer has any effect.
     */
    @JsonProperty("resourceID")
    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    /**
     * TenantID is the service principal primary tenant id.
     */
    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    /**
     * TenantID is the service principal primary tenant id.
     */
    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    /**
     * Type is the type of Azure Identity used. ServicePrincipal, ServicePrincipalCertificate, UserAssignedMSI, ManualServicePrincipal, UserAssignedIdentityCredential, or WorkloadIdentity.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the type of Azure Identity used. ServicePrincipal, ServicePrincipalCertificate, UserAssignedMSI, ManualServicePrincipal, UserAssignedIdentityCredential, or WorkloadIdentity.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * UserAssignedIdentityCredentialsCloudType is used with UserAssignedIdentityCredentialsPath to specify the Cloud type. Can only be one of the following values: public, china, or usgovernment If a value is not specified, defaults to public
     */
    @JsonProperty("userAssignedIdentityCredentialsCloudType")
    public String getUserAssignedIdentityCredentialsCloudType() {
        return userAssignedIdentityCredentialsCloudType;
    }

    /**
     * UserAssignedIdentityCredentialsCloudType is used with UserAssignedIdentityCredentialsPath to specify the Cloud type. Can only be one of the following values: public, china, or usgovernment If a value is not specified, defaults to public
     */
    @JsonProperty("userAssignedIdentityCredentialsCloudType")
    public void setUserAssignedIdentityCredentialsCloudType(String userAssignedIdentityCredentialsCloudType) {
        this.userAssignedIdentityCredentialsCloudType = userAssignedIdentityCredentialsCloudType;
    }

    /**
     * UserAssignedIdentityCredentialsPath is the path where an existing JSON file exists containing the JSON format of a UserAssignedIdentityCredentials struct. See the msi-dataplane for more details on UserAssignedIdentityCredentials - https://github.com/Azure/msi-dataplane/blob/main/pkg/dataplane/internal/client/models.go#L125
     */
    @JsonProperty("userAssignedIdentityCredentialsPath")
    public String getUserAssignedIdentityCredentialsPath() {
        return userAssignedIdentityCredentialsPath;
    }

    /**
     * UserAssignedIdentityCredentialsPath is the path where an existing JSON file exists containing the JSON format of a UserAssignedIdentityCredentials struct. See the msi-dataplane for more details on UserAssignedIdentityCredentials - https://github.com/Azure/msi-dataplane/blob/main/pkg/dataplane/internal/client/models.go#L125
     */
    @JsonProperty("userAssignedIdentityCredentialsPath")
    public void setUserAssignedIdentityCredentialsPath(String userAssignedIdentityCredentialsPath) {
        this.userAssignedIdentityCredentialsPath = userAssignedIdentityCredentialsPath;
    }

    @JsonIgnore
    public AzureClusterIdentitySpecBuilder edit() {
        return new AzureClusterIdentitySpecBuilder(this);
    }

    @JsonIgnore
    public AzureClusterIdentitySpecBuilder toBuilder() {
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
