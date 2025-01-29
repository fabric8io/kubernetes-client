
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
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("cloudcredential.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AzureProviderSpec implements Editable<AzureProviderSpecBuilder>, KubernetesResource, Namespaced
{

    /**
     * (Required)
     */
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
    /**
     * (Required)
     */
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
     * (Required)
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * (Required)
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("azureClientID")
    public String getAzureClientID() {
        return azureClientID;
    }

    @JsonProperty("azureClientID")
    public void setAzureClientID(String azureClientID) {
        this.azureClientID = azureClientID;
    }

    @JsonProperty("azureRegion")
    public String getAzureRegion() {
        return azureRegion;
    }

    @JsonProperty("azureRegion")
    public void setAzureRegion(String azureRegion) {
        this.azureRegion = azureRegion;
    }

    @JsonProperty("azureSubscriptionID")
    public String getAzureSubscriptionID() {
        return azureSubscriptionID;
    }

    @JsonProperty("azureSubscriptionID")
    public void setAzureSubscriptionID(String azureSubscriptionID) {
        this.azureSubscriptionID = azureSubscriptionID;
    }

    @JsonProperty("azureTenantID")
    public String getAzureTenantID() {
        return azureTenantID;
    }

    @JsonProperty("azureTenantID")
    public void setAzureTenantID(String azureTenantID) {
        this.azureTenantID = azureTenantID;
    }

    @JsonProperty("dataPermissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDataPermissions() {
        return dataPermissions;
    }

    @JsonProperty("dataPermissions")
    public void setDataPermissions(List<String> dataPermissions) {
        this.dataPermissions = dataPermissions;
    }

    /**
     * (Required)
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * (Required)
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("permissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPermissions() {
        return permissions;
    }

    @JsonProperty("permissions")
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @JsonProperty("roleBindings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RoleBinding> getRoleBindings() {
        return roleBindings;
    }

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
