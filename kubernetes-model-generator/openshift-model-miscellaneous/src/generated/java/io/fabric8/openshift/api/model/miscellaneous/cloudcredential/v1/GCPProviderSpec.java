
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

/**
 * GCPProviderSpec contains the required information to create a service account with policy bindings in GCP.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "audience",
    "permissions",
    "predefinedRoles",
    "serviceAccountEmail",
    "skipServiceCheck"
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
public class GCPProviderSpec implements Editable<GCPProviderSpecBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "cloudcredential.openshift.io/v1";
    @JsonProperty("audience")
    private String audience;
    @JsonProperty("kind")
    private String kind = "GCPProviderSpec";
    @JsonProperty("permissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> permissions = new ArrayList<>();
    @JsonProperty("predefinedRoles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> predefinedRoles = new ArrayList<>();
    @JsonProperty("serviceAccountEmail")
    private String serviceAccountEmail;
    @JsonProperty("skipServiceCheck")
    private Boolean skipServiceCheck;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPProviderSpec() {
    }

    public GCPProviderSpec(String apiVersion, String audience, String kind, List<String> permissions, List<String> predefinedRoles, String serviceAccountEmail, Boolean skipServiceCheck) {
        super();
        this.apiVersion = apiVersion;
        this.audience = audience;
        this.kind = kind;
        this.permissions = permissions;
        this.predefinedRoles = predefinedRoles;
        this.serviceAccountEmail = serviceAccountEmail;
        this.skipServiceCheck = skipServiceCheck;
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
     * Audience that will be used with Workload Identity Federation. It should be formatted as follows: "//iam.googleapis.com/projects/&lt;PROJECT_NUMBER&gt;/locations/global/workloadIdentityPools/&lt;POOL_ID&gt;/providers/&lt;PROVIDER_ID&gt;" For more information see https://cloud.google.com/iam/docs/workload-identity-federation-with-other-providers#create-credential-config
     */
    @JsonProperty("audience")
    public String getAudience() {
        return audience;
    }

    /**
     * Audience that will be used with Workload Identity Federation. It should be formatted as follows: "//iam.googleapis.com/projects/&lt;PROJECT_NUMBER&gt;/locations/global/workloadIdentityPools/&lt;POOL_ID&gt;/providers/&lt;PROVIDER_ID&gt;" For more information see https://cloud.google.com/iam/docs/workload-identity-federation-with-other-providers#create-credential-config
     */
    @JsonProperty("audience")
    public void setAudience(String audience) {
        this.audience = audience;
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
     * Permissions is the list of GCP permissions required to create a more fine-grained custom role to satisfy the CredentialsRequest. The Permissions field may be provided in addition to PredefinedRoles. When both fields are specified, the service account will have union of permissions defined from both Permissions and PredefinedRoles.
     */
    @JsonProperty("permissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * Permissions is the list of GCP permissions required to create a more fine-grained custom role to satisfy the CredentialsRequest. The Permissions field may be provided in addition to PredefinedRoles. When both fields are specified, the service account will have union of permissions defined from both Permissions and PredefinedRoles.
     */
    @JsonProperty("permissions")
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    /**
     * PredefinedRoles is the list of GCP pre-defined roles that the CredentialsRequest requires.
     */
    @JsonProperty("predefinedRoles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPredefinedRoles() {
        return predefinedRoles;
    }

    /**
     * PredefinedRoles is the list of GCP pre-defined roles that the CredentialsRequest requires.
     */
    @JsonProperty("predefinedRoles")
    public void setPredefinedRoles(List<String> predefinedRoles) {
        this.predefinedRoles = predefinedRoles;
    }

    /**
     * ServiceAccountEmail that will be impersonated during Workload Identity Federation.
     */
    @JsonProperty("serviceAccountEmail")
    public String getServiceAccountEmail() {
        return serviceAccountEmail;
    }

    /**
     * ServiceAccountEmail that will be impersonated during Workload Identity Federation.
     */
    @JsonProperty("serviceAccountEmail")
    public void setServiceAccountEmail(String serviceAccountEmail) {
        this.serviceAccountEmail = serviceAccountEmail;
    }

    /**
     * SkipServiceCheck can be set to true to skip the check whether the requested roles or permissions have the necessary services enabled
     */
    @JsonProperty("skipServiceCheck")
    public Boolean getSkipServiceCheck() {
        return skipServiceCheck;
    }

    /**
     * SkipServiceCheck can be set to true to skip the check whether the requested roles or permissions have the necessary services enabled
     */
    @JsonProperty("skipServiceCheck")
    public void setSkipServiceCheck(Boolean skipServiceCheck) {
        this.skipServiceCheck = skipServiceCheck;
    }

    @JsonIgnore
    public GCPProviderSpecBuilder edit() {
        return new GCPProviderSpecBuilder(this);
    }

    @JsonIgnore
    public GCPProviderSpecBuilder toBuilder() {
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
