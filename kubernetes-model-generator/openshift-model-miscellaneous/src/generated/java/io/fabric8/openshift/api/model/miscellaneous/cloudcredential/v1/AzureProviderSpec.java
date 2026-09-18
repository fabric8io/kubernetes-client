
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
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AzureProviderSpec contains the required information to create RBAC role bindings for Azure.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "azureClientID",
    "azureRegion",
    "azureSubscriptionID",
    "azureTenantID",
    "dataPermissions",
    "permissions",
    "roleBindings"
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
@Version("v1")
@Group("cloudcredential.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AzureProviderSpec implements Editable<AzureProviderSpecBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "cloudcredential.openshift.io/v1";
    @JsonProperty("azureClientID")
    private String azureClientID;
    @JsonProperty("azureRegion")
    private String azureRegion;
    @JsonProperty("azureSubscriptionID")
    private String azureSubscriptionID;
    @JsonProperty("azureTenantID")
    private String azureTenantID;
    @JsonProperty("dataPermissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dataPermissions = new ArrayList<>();
    @JsonProperty("kind")
    private String kind = "AzureProviderSpec";
    @JsonProperty("permissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> permissions = new ArrayList<>();
    @JsonProperty("roleBindings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RoleBinding> roleBindings = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureProviderSpec() {
    }

    public AzureProviderSpec(String apiVersion, String azureClientID, String azureRegion, String azureSubscriptionID, String azureTenantID, List<String> dataPermissions, String kind, List<String> permissions, List<RoleBinding> roleBindings) {
        super();
        this.apiVersion = apiVersion;
        this.azureClientID = azureClientID;
        this.azureRegion = azureRegion;
        this.azureSubscriptionID = azureSubscriptionID;
        this.azureTenantID = azureTenantID;
        this.dataPermissions = dataPermissions;
        this.kind = kind;
        this.permissions = permissions;
        this.roleBindings = roleBindings;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * The following fields are only required for Azure Workload Identity. AzureClientID is the ID of the specific application you created in Azure
     */
    @JsonProperty("azureClientID")
    public String getAzureClientID() {
        return azureClientID;
    }

    /**
     * The following fields are only required for Azure Workload Identity. AzureClientID is the ID of the specific application you created in Azure
     */
    @JsonProperty("azureClientID")
    public void setAzureClientID(String azureClientID) {
        this.azureClientID = azureClientID;
    }

    /**
     * AzureRegion is the geographic region of the Azure service.
     */
    @JsonProperty("azureRegion")
    public String getAzureRegion() {
        return azureRegion;
    }

    /**
     * AzureRegion is the geographic region of the Azure service.
     */
    @JsonProperty("azureRegion")
    public void setAzureRegion(String azureRegion) {
        this.azureRegion = azureRegion;
    }

    /**
     * Each Azure subscription has an ID associated with it, as does the tenant to which a subscription belongs. AzureSubscriptionID is the ID of the subscription.
     */
    @JsonProperty("azureSubscriptionID")
    public String getAzureSubscriptionID() {
        return azureSubscriptionID;
    }

    /**
     * Each Azure subscription has an ID associated with it, as does the tenant to which a subscription belongs. AzureSubscriptionID is the ID of the subscription.
     */
    @JsonProperty("azureSubscriptionID")
    public void setAzureSubscriptionID(String azureSubscriptionID) {
        this.azureSubscriptionID = azureSubscriptionID;
    }

    /**
     * AzureTenantID is the ID of the tenant to which the subscription belongs.
     */
    @JsonProperty("azureTenantID")
    public String getAzureTenantID() {
        return azureTenantID;
    }

    /**
     * AzureTenantID is the ID of the tenant to which the subscription belongs.
     */
    @JsonProperty("azureTenantID")
    public void setAzureTenantID(String azureTenantID) {
        this.azureTenantID = azureTenantID;
    }

    /**
     * DataPermissions is the list of Azure data permissions required to create a more fine-grained custom role to satisfy the CredentialsRequest. The DataPermissions field may be provided in addition to RoleBindings. When both fields are specified, the user-assigned managed identity will have union of permissions defined from both DataPermissions and RoleBindings.
     */
    @JsonProperty("dataPermissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDataPermissions() {
        return dataPermissions;
    }

    /**
     * DataPermissions is the list of Azure data permissions required to create a more fine-grained custom role to satisfy the CredentialsRequest. The DataPermissions field may be provided in addition to RoleBindings. When both fields are specified, the user-assigned managed identity will have union of permissions defined from both DataPermissions and RoleBindings.
     */
    @JsonProperty("dataPermissions")
    public void setDataPermissions(List<String> dataPermissions) {
        this.dataPermissions = dataPermissions;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Permissions is the list of Azure permissions required to create a more fine-grained custom role to satisfy the CredentialsRequest. The Permissions field may be provided in addition to RoleBindings. When both fields are specified, the user-assigned managed identity will have union of permissions defined from both Permissions and RoleBindings.
     */
    @JsonProperty("permissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * Permissions is the list of Azure permissions required to create a more fine-grained custom role to satisfy the CredentialsRequest. The Permissions field may be provided in addition to RoleBindings. When both fields are specified, the user-assigned managed identity will have union of permissions defined from both Permissions and RoleBindings.
     */
    @JsonProperty("permissions")
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    /**
     * RoleBindings contains a list of roles that should be associated with the minted credential.
     */
    @JsonProperty("roleBindings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RoleBinding> getRoleBindings() {
        return roleBindings;
    }

    /**
     * RoleBindings contains a list of roles that should be associated with the minted credential.
     */
    @JsonProperty("roleBindings")
    public void setRoleBindings(List<RoleBinding> roleBindings) {
        this.roleBindings = roleBindings;
    }

    @JsonIgnore
    public AzureProviderSpecBuilder edit() {
        return new AzureProviderSpecBuilder(this);
    }

    @JsonIgnore
    public AzureProviderSpecBuilder toBuilder() {
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
        if (!(o instanceof AzureProviderSpec)) {
            return false;
        }
        AzureProviderSpec other = (AzureProviderSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$azureClientID = this.getAzureClientID();
        Object other$azureClientID = other.getAzureClientID();
        if (this$azureClientID == null ? other$azureClientID != null : !this$azureClientID.equals(other$azureClientID)) {
            return false;
        }
        Object this$azureRegion = this.getAzureRegion();
        Object other$azureRegion = other.getAzureRegion();
        if (this$azureRegion == null ? other$azureRegion != null : !this$azureRegion.equals(other$azureRegion)) {
            return false;
        }
        Object this$azureSubscriptionID = this.getAzureSubscriptionID();
        Object other$azureSubscriptionID = other.getAzureSubscriptionID();
        if (this$azureSubscriptionID == null ? other$azureSubscriptionID != null : !this$azureSubscriptionID.equals(other$azureSubscriptionID)) {
            return false;
        }
        Object this$azureTenantID = this.getAzureTenantID();
        Object other$azureTenantID = other.getAzureTenantID();
        if (this$azureTenantID == null ? other$azureTenantID != null : !this$azureTenantID.equals(other$azureTenantID)) {
            return false;
        }
        Object this$dataPermissions = this.getDataPermissions();
        Object other$dataPermissions = other.getDataPermissions();
        if (this$dataPermissions == null ? other$dataPermissions != null : !this$dataPermissions.equals(other$dataPermissions)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$permissions = this.getPermissions();
        Object other$permissions = other.getPermissions();
        if (this$permissions == null ? other$permissions != null : !this$permissions.equals(other$permissions)) {
            return false;
        }
        Object this$roleBindings = this.getRoleBindings();
        Object other$roleBindings = other.getRoleBindings();
        if (this$roleBindings == null ? other$roleBindings != null : !this$roleBindings.equals(other$roleBindings)) {
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
        return other instanceof AzureProviderSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $azureClientID = this.getAzureClientID();
        result = result * prime + ($azureClientID == null ? 43 : $azureClientID.hashCode());
        Object $azureRegion = this.getAzureRegion();
        result = result * prime + ($azureRegion == null ? 43 : $azureRegion.hashCode());
        Object $azureSubscriptionID = this.getAzureSubscriptionID();
        result = result * prime + ($azureSubscriptionID == null ? 43 : $azureSubscriptionID.hashCode());
        Object $azureTenantID = this.getAzureTenantID();
        result = result * prime + ($azureTenantID == null ? 43 : $azureTenantID.hashCode());
        Object $dataPermissions = this.getDataPermissions();
        result = result * prime + ($dataPermissions == null ? 43 : $dataPermissions.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $permissions = this.getPermissions();
        result = result * prime + ($permissions == null ? 43 : $permissions.hashCode());
        Object $roleBindings = this.getRoleBindings();
        result = result * prime + ($roleBindings == null ? 43 : $roleBindings.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureProviderSpec(" + "apiVersion=" + this.getApiVersion() + ", azureClientID=" + this.getAzureClientID() + ", azureRegion=" + this.getAzureRegion() + ", azureSubscriptionID=" + this.getAzureSubscriptionID() + ", azureTenantID=" + this.getAzureTenantID() + ", dataPermissions=" + this.getDataPermissions() + ", kind=" + this.getKind() + ", permissions=" + this.getPermissions() + ", roleBindings=" + this.getRoleBindings() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
