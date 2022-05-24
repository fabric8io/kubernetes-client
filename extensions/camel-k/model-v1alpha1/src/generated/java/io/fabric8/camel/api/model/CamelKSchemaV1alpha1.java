
package io.fabric8.camel.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.camelk.v1alpha1.AuthorizationSpec;
import io.fabric8.camelk.v1alpha1.Endpoint;
import io.fabric8.camelk.v1alpha1.ErrorHandlerSpec;
import io.fabric8.camelk.v1alpha1.EventTypeSpec;
import io.fabric8.camelk.v1alpha1.ExternalDocumentation;
import io.fabric8.camelk.v1alpha1.JSONSchemaProp;
import io.fabric8.camelk.v1alpha1.JSONSchemaProps;
import io.fabric8.camelk.v1alpha1.Kamelet;
import io.fabric8.camelk.v1alpha1.KameletBinding;
import io.fabric8.camelk.v1alpha1.KameletBindingCondition;
import io.fabric8.camelk.v1alpha1.KameletBindingList;
import io.fabric8.camelk.v1alpha1.KameletBindingSpec;
import io.fabric8.camelk.v1alpha1.KameletBindingStatus;
import io.fabric8.camelk.v1alpha1.KameletCondition;
import io.fabric8.camelk.v1alpha1.KameletList;
import io.fabric8.camelk.v1alpha1.KameletProperty;
import io.fabric8.camelk.v1alpha1.KameletSpec;
import io.fabric8.camelk.v1alpha1.KameletStatus;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
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
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_AuthorizationSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_Endpoint",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_ErrorHandlerSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_EventTypeSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_ExternalDocumentation",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_JSONSchemaProp",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_JSONSchemaProps",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_Kamelet",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBinding",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingCondition",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingList",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingStatus",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletCondition",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletList",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletProperty",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletSpec",
    "github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletStatus"
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
public class CamelKSchemaV1alpha1 {

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_AuthorizationSpec")
    private AuthorizationSpec githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_Endpoint")
    private Endpoint githubComApacheCamelKPkgApisCamelV1alpha1Endpoint;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_ErrorHandlerSpec")
    private ErrorHandlerSpec githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_EventTypeSpec")
    private EventTypeSpec githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_ExternalDocumentation")
    private ExternalDocumentation githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_JSONSchemaProp")
    private JSONSchemaProp githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_JSONSchemaProps")
    private JSONSchemaProps githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_Kamelet")
    private Kamelet githubComApacheCamelKPkgApisCamelV1alpha1Kamelet;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBinding")
    private KameletBinding githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingCondition")
    private KameletBindingCondition githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingList")
    private KameletBindingList githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingSpec")
    private KameletBindingSpec githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingStatus")
    private KameletBindingStatus githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletCondition")
    private KameletCondition githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletList")
    private KameletList githubComApacheCamelKPkgApisCamelV1alpha1KameletList;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletProperty")
    private KameletProperty githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletSpec")
    private KameletSpec githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec;
    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletStatus")
    private KameletStatus githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CamelKSchemaV1alpha1() {
    }

    /**
     * 
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletList
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty
     * @param githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec
     * @param githubComApacheCamelKPkgApisCamelV1alpha1Kamelet
     * @param githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp
     * @param githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps
     * @param githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation
     * @param githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec
     * @param githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec
     * @param githubComApacheCamelKPkgApisCamelV1alpha1Endpoint
     * @param githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition
     */
    public CamelKSchemaV1alpha1(AuthorizationSpec githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec, Endpoint githubComApacheCamelKPkgApisCamelV1alpha1Endpoint, ErrorHandlerSpec githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec, EventTypeSpec githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec, ExternalDocumentation githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation, JSONSchemaProp githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp, JSONSchemaProps githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps, Kamelet githubComApacheCamelKPkgApisCamelV1alpha1Kamelet, KameletBinding githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding, KameletBindingCondition githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition, KameletBindingList githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList, KameletBindingSpec githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec, KameletBindingStatus githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus, KameletCondition githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition, KameletList githubComApacheCamelKPkgApisCamelV1alpha1KameletList, KameletProperty githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty, KameletSpec githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec, KameletStatus githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus) {
        super();
        this.githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec = githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec;
        this.githubComApacheCamelKPkgApisCamelV1alpha1Endpoint = githubComApacheCamelKPkgApisCamelV1alpha1Endpoint;
        this.githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec = githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec;
        this.githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec = githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec;
        this.githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation = githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation;
        this.githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp = githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp;
        this.githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps = githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps;
        this.githubComApacheCamelKPkgApisCamelV1alpha1Kamelet = githubComApacheCamelKPkgApisCamelV1alpha1Kamelet;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding = githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition = githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList = githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec = githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus = githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition = githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletList = githubComApacheCamelKPkgApisCamelV1alpha1KameletList;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty = githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec = githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec;
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus = githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_AuthorizationSpec")
    public AuthorizationSpec getGithubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec() {
        return githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_AuthorizationSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec(AuthorizationSpec githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec = githubComApacheCamelKPkgApisCamelV1alpha1AuthorizationSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_Endpoint")
    public Endpoint getGithubComApacheCamelKPkgApisCamelV1alpha1Endpoint() {
        return githubComApacheCamelKPkgApisCamelV1alpha1Endpoint;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_Endpoint")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1Endpoint(Endpoint githubComApacheCamelKPkgApisCamelV1alpha1Endpoint) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1Endpoint = githubComApacheCamelKPkgApisCamelV1alpha1Endpoint;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_ErrorHandlerSpec")
    public ErrorHandlerSpec getGithubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec() {
        return githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_ErrorHandlerSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec(ErrorHandlerSpec githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec = githubComApacheCamelKPkgApisCamelV1alpha1ErrorHandlerSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_EventTypeSpec")
    public EventTypeSpec getGithubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec() {
        return githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_EventTypeSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec(EventTypeSpec githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec = githubComApacheCamelKPkgApisCamelV1alpha1EventTypeSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_ExternalDocumentation")
    public ExternalDocumentation getGithubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation() {
        return githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_ExternalDocumentation")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation(ExternalDocumentation githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation = githubComApacheCamelKPkgApisCamelV1alpha1ExternalDocumentation;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_JSONSchemaProp")
    public JSONSchemaProp getGithubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp() {
        return githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_JSONSchemaProp")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp(JSONSchemaProp githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp = githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProp;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_JSONSchemaProps")
    public JSONSchemaProps getGithubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps() {
        return githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_JSONSchemaProps")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps(JSONSchemaProps githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps = githubComApacheCamelKPkgApisCamelV1alpha1JSONSchemaProps;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_Kamelet")
    public Kamelet getGithubComApacheCamelKPkgApisCamelV1alpha1Kamelet() {
        return githubComApacheCamelKPkgApisCamelV1alpha1Kamelet;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_Kamelet")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1Kamelet(Kamelet githubComApacheCamelKPkgApisCamelV1alpha1Kamelet) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1Kamelet = githubComApacheCamelKPkgApisCamelV1alpha1Kamelet;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBinding")
    public KameletBinding getGithubComApacheCamelKPkgApisCamelV1alpha1KameletBinding() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBinding")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletBinding(KameletBinding githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding = githubComApacheCamelKPkgApisCamelV1alpha1KameletBinding;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingCondition")
    public KameletBindingCondition getGithubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingCondition")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition(KameletBindingCondition githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition = githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingList")
    public KameletBindingList getGithubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingList")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList(KameletBindingList githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList = githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingSpec")
    public KameletBindingSpec getGithubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec(KameletBindingSpec githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec = githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingStatus")
    public KameletBindingStatus getGithubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletBindingStatus")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus(KameletBindingStatus githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus = githubComApacheCamelKPkgApisCamelV1alpha1KameletBindingStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletCondition")
    public KameletCondition getGithubComApacheCamelKPkgApisCamelV1alpha1KameletCondition() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletCondition")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletCondition(KameletCondition githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition = githubComApacheCamelKPkgApisCamelV1alpha1KameletCondition;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletList")
    public KameletList getGithubComApacheCamelKPkgApisCamelV1alpha1KameletList() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletList")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletList(KameletList githubComApacheCamelKPkgApisCamelV1alpha1KameletList) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletList = githubComApacheCamelKPkgApisCamelV1alpha1KameletList;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletProperty")
    public KameletProperty getGithubComApacheCamelKPkgApisCamelV1alpha1KameletProperty() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletProperty")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletProperty(KameletProperty githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty = githubComApacheCamelKPkgApisCamelV1alpha1KameletProperty;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletSpec")
    public KameletSpec getGithubComApacheCamelKPkgApisCamelV1alpha1KameletSpec() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletSpec")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletSpec(KameletSpec githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec = githubComApacheCamelKPkgApisCamelV1alpha1KameletSpec;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletStatus")
    public KameletStatus getGithubComApacheCamelKPkgApisCamelV1alpha1KameletStatus() {
        return githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus;
    }

    @JsonProperty("github_com_apache_camel-k_pkg_apis_camel_v1alpha1_KameletStatus")
    public void setGithubComApacheCamelKPkgApisCamelV1alpha1KameletStatus(KameletStatus githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus) {
        this.githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus = githubComApacheCamelKPkgApisCamelV1alpha1KameletStatus;
    }

}
