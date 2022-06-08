
package io.fabric8.openclustermanagement.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.ImageOverrides;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.PodResource;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomization;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomizationList;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomizationSpec;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomizationStatus;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperator;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperatorList;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperatorSpec;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperatorStatus;
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
    "github_com_open-cluster-management_search-operator_api_v1alpha1_ImageOverrides",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_PodResource",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomization",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationList",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationSpec",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationStatus",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperator",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorList",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorSpec",
    "github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorStatus"
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
public class OpenClusterManagementSearchSchema {

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_ImageOverrides")
    private ImageOverrides githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_PodResource")
    private PodResource githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomization")
    private SearchCustomization githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationList")
    private SearchCustomizationList githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationSpec")
    private SearchCustomizationSpec githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationStatus")
    private SearchCustomizationStatus githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperator")
    private SearchOperator githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorList")
    private SearchOperatorList githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorSpec")
    private SearchOperatorSpec githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec;
    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorStatus")
    private SearchOperatorStatus githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenClusterManagementSearchSchema() {
    }

    /**
     * 
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization
     * @param githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator
     */
    public OpenClusterManagementSearchSchema(ImageOverrides githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides, PodResource githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource, SearchCustomization githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization, SearchCustomizationList githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList, SearchCustomizationSpec githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec, SearchCustomizationStatus githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus, SearchOperator githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator, SearchOperatorList githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList, SearchOperatorSpec githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec, SearchOperatorStatus githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus) {
        super();
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides = githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource = githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec;
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_ImageOverrides")
    public ImageOverrides getGithubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_ImageOverrides")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides(ImageOverrides githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides = githubComOpenClusterManagementSearchOperatorApiV1alpha1ImageOverrides;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_PodResource")
    public PodResource getGithubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_PodResource")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource(PodResource githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource = githubComOpenClusterManagementSearchOperatorApiV1alpha1PodResource;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomization")
    public SearchCustomization getGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomization")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization(SearchCustomization githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomization;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationList")
    public SearchCustomizationList getGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationList")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList(SearchCustomizationList githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationList;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationSpec")
    public SearchCustomizationSpec getGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationSpec")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec(SearchCustomizationSpec githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationSpec;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationStatus")
    public SearchCustomizationStatus getGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchCustomizationStatus")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus(SearchCustomizationStatus githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchCustomizationStatus;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperator")
    public SearchOperator getGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperator")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator(SearchOperator githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperator;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorList")
    public SearchOperatorList getGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorList")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList(SearchOperatorList githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorList;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorSpec")
    public SearchOperatorSpec getGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorSpec")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec(SearchOperatorSpec githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorSpec;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorStatus")
    public SearchOperatorStatus getGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus() {
        return githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus;
    }

    @JsonProperty("github_com_open-cluster-management_search-operator_api_v1alpha1_SearchOperatorStatus")
    public void setGithubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus(SearchOperatorStatus githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus) {
        this.githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus = githubComOpenClusterManagementSearchOperatorApiV1alpha1SearchOperatorStatus;
    }

}
