
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
 * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterName",
    "deployOption",
    "externalServerURLs",
    "hubApiServerHostAlias",
    "imagePullSpec",
    "namespace",
    "nodePlacement",
    "priorityClassName",
    "registrationConfiguration",
    "registrationImagePullSpec",
    "resourceRequirement",
    "workConfiguration",
    "workImagePullSpec"
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
public class KlusterletSpec implements Editable<KlusterletSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("deployOption")
    private KlusterletDeployOption deployOption;
    @JsonProperty("externalServerURLs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServerURL> externalServerURLs = new ArrayList<>();
    @JsonProperty("hubApiServerHostAlias")
    private HubApiServerHostAlias hubApiServerHostAlias;
    @JsonProperty("imagePullSpec")
    private String imagePullSpec;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("nodePlacement")
    private NodePlacement nodePlacement;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("registrationConfiguration")
    private RegistrationConfiguration registrationConfiguration;
    @JsonProperty("registrationImagePullSpec")
    private String registrationImagePullSpec;
    @JsonProperty("resourceRequirement")
    private ResourceRequirement resourceRequirement;
    @JsonProperty("workConfiguration")
    private WorkAgentConfiguration workConfiguration;
    @JsonProperty("workImagePullSpec")
    private String workImagePullSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KlusterletSpec() {
    }

    public KlusterletSpec(String clusterName, KlusterletDeployOption deployOption, List<ServerURL> externalServerURLs, HubApiServerHostAlias hubApiServerHostAlias, String imagePullSpec, String namespace, NodePlacement nodePlacement, String priorityClassName, RegistrationConfiguration registrationConfiguration, String registrationImagePullSpec, ResourceRequirement resourceRequirement, WorkAgentConfiguration workConfiguration, String workImagePullSpec) {
        super();
        this.clusterName = clusterName;
        this.deployOption = deployOption;
        this.externalServerURLs = externalServerURLs;
        this.hubApiServerHostAlias = hubApiServerHostAlias;
        this.imagePullSpec = imagePullSpec;
        this.namespace = namespace;
        this.nodePlacement = nodePlacement;
        this.priorityClassName = priorityClassName;
        this.registrationConfiguration = registrationConfiguration;
        this.registrationImagePullSpec = registrationImagePullSpec;
        this.resourceRequirement = resourceRequirement;
        this.workConfiguration = workConfiguration;
        this.workImagePullSpec = workImagePullSpec;
    }

    /**
     * ClusterName is the name of the managed cluster to be created on hub. The Klusterlet agent generates a random name if it is not set, or discovers the appropriate cluster name on OpenShift.
     */
    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * ClusterName is the name of the managed cluster to be created on hub. The Klusterlet agent generates a random name if it is not set, or discovers the appropriate cluster name on OpenShift.
     */
    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("deployOption")
    public KlusterletDeployOption getDeployOption() {
        return deployOption;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("deployOption")
    public void setDeployOption(KlusterletDeployOption deployOption) {
        this.deployOption = deployOption;
    }

    /**
     * ExternalServerURLs represents a list of apiserver urls and ca bundles that is accessible externally If it is set empty, managed cluster has no externally accessible url that hub cluster can visit.
     */
    @JsonProperty("externalServerURLs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServerURL> getExternalServerURLs() {
        return externalServerURLs;
    }

    /**
     * ExternalServerURLs represents a list of apiserver urls and ca bundles that is accessible externally If it is set empty, managed cluster has no externally accessible url that hub cluster can visit.
     */
    @JsonProperty("externalServerURLs")
    public void setExternalServerURLs(List<ServerURL> externalServerURLs) {
        this.externalServerURLs = externalServerURLs;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("hubApiServerHostAlias")
    public HubApiServerHostAlias getHubApiServerHostAlias() {
        return hubApiServerHostAlias;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("hubApiServerHostAlias")
    public void setHubApiServerHostAlias(HubApiServerHostAlias hubApiServerHostAlias) {
        this.hubApiServerHostAlias = hubApiServerHostAlias;
    }

    /**
     * ImagePullSpec represents the desired image configuration of agent, it takes effect only when singleton mode is set. quay.io/open-cluster-management.io/registration-operator:latest will be used if unspecified
     */
    @JsonProperty("imagePullSpec")
    public String getImagePullSpec() {
        return imagePullSpec;
    }

    /**
     * ImagePullSpec represents the desired image configuration of agent, it takes effect only when singleton mode is set. quay.io/open-cluster-management.io/registration-operator:latest will be used if unspecified
     */
    @JsonProperty("imagePullSpec")
    public void setImagePullSpec(String imagePullSpec) {
        this.imagePullSpec = imagePullSpec;
    }

    /**
     * Namespace is the namespace to deploy the agent on the managed cluster. The namespace must have a prefix of "open-cluster-management-", and if it is not set, the namespace of "open-cluster-management-agent" is used to deploy agent. In addition, the add-ons are deployed to the namespace of "{Namespace}-addon". In the Hosted mode, this namespace still exists on the managed cluster to contain necessary resources, like service accounts, roles and rolebindings, while the agent is deployed to the namespace with the same name as klusterlet on the management cluster.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespace is the namespace to deploy the agent on the managed cluster. The namespace must have a prefix of "open-cluster-management-", and if it is not set, the namespace of "open-cluster-management-agent" is used to deploy agent. In addition, the add-ons are deployed to the namespace of "{Namespace}-addon". In the Hosted mode, this namespace still exists on the managed cluster to contain necessary resources, like service accounts, roles and rolebindings, while the agent is deployed to the namespace with the same name as klusterlet on the management cluster.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("nodePlacement")
    public NodePlacement getNodePlacement() {
        return nodePlacement;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("nodePlacement")
    public void setNodePlacement(NodePlacement nodePlacement) {
        this.nodePlacement = nodePlacement;
    }

    /**
     * PriorityClassName is the name of the PriorityClass that will be used by the deployed klusterlet agent. It will be ignored when the PriorityClass/v1 API is not available on the managed cluster.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * PriorityClassName is the name of the PriorityClass that will be used by the deployed klusterlet agent. It will be ignored when the PriorityClass/v1 API is not available on the managed cluster.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("registrationConfiguration")
    public RegistrationConfiguration getRegistrationConfiguration() {
        return registrationConfiguration;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("registrationConfiguration")
    public void setRegistrationConfiguration(RegistrationConfiguration registrationConfiguration) {
        this.registrationConfiguration = registrationConfiguration;
    }

    /**
     * RegistrationImagePullSpec represents the desired image configuration of registration agent. quay.io/open-cluster-management.io/registration:latest will be used if unspecified.
     */
    @JsonProperty("registrationImagePullSpec")
    public String getRegistrationImagePullSpec() {
        return registrationImagePullSpec;
    }

    /**
     * RegistrationImagePullSpec represents the desired image configuration of registration agent. quay.io/open-cluster-management.io/registration:latest will be used if unspecified.
     */
    @JsonProperty("registrationImagePullSpec")
    public void setRegistrationImagePullSpec(String registrationImagePullSpec) {
        this.registrationImagePullSpec = registrationImagePullSpec;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("resourceRequirement")
    public ResourceRequirement getResourceRequirement() {
        return resourceRequirement;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("resourceRequirement")
    public void setResourceRequirement(ResourceRequirement resourceRequirement) {
        this.resourceRequirement = resourceRequirement;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("workConfiguration")
    public WorkAgentConfiguration getWorkConfiguration() {
        return workConfiguration;
    }

    /**
     * KlusterletSpec represents the desired deployment configuration of Klusterlet agent.
     */
    @JsonProperty("workConfiguration")
    public void setWorkConfiguration(WorkAgentConfiguration workConfiguration) {
        this.workConfiguration = workConfiguration;
    }

    /**
     * WorkImagePullSpec represents the desired image configuration of work agent. quay.io/open-cluster-management.io/work:latest will be used if unspecified.
     */
    @JsonProperty("workImagePullSpec")
    public String getWorkImagePullSpec() {
        return workImagePullSpec;
    }

    /**
     * WorkImagePullSpec represents the desired image configuration of work agent. quay.io/open-cluster-management.io/work:latest will be used if unspecified.
     */
    @JsonProperty("workImagePullSpec")
    public void setWorkImagePullSpec(String workImagePullSpec) {
        this.workImagePullSpec = workImagePullSpec;
    }

    @JsonIgnore
    public KlusterletSpecBuilder edit() {
        return new KlusterletSpecBuilder(this);
    }

    @JsonIgnore
    public KlusterletSpecBuilder toBuilder() {
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
