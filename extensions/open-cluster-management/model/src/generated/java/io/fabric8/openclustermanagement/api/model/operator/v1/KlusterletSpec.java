
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
@Generated("jsonschema2pojo")
public class KlusterletSpec implements Editable<KlusterletSpecBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @JsonProperty("deployOption")
    public KlusterletDeployOption getDeployOption() {
        return deployOption;
    }

    @JsonProperty("deployOption")
    public void setDeployOption(KlusterletDeployOption deployOption) {
        this.deployOption = deployOption;
    }

    @JsonProperty("externalServerURLs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServerURL> getExternalServerURLs() {
        return externalServerURLs;
    }

    @JsonProperty("externalServerURLs")
    public void setExternalServerURLs(List<ServerURL> externalServerURLs) {
        this.externalServerURLs = externalServerURLs;
    }

    @JsonProperty("hubApiServerHostAlias")
    public HubApiServerHostAlias getHubApiServerHostAlias() {
        return hubApiServerHostAlias;
    }

    @JsonProperty("hubApiServerHostAlias")
    public void setHubApiServerHostAlias(HubApiServerHostAlias hubApiServerHostAlias) {
        this.hubApiServerHostAlias = hubApiServerHostAlias;
    }

    @JsonProperty("imagePullSpec")
    public String getImagePullSpec() {
        return imagePullSpec;
    }

    @JsonProperty("imagePullSpec")
    public void setImagePullSpec(String imagePullSpec) {
        this.imagePullSpec = imagePullSpec;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("nodePlacement")
    public NodePlacement getNodePlacement() {
        return nodePlacement;
    }

    @JsonProperty("nodePlacement")
    public void setNodePlacement(NodePlacement nodePlacement) {
        this.nodePlacement = nodePlacement;
    }

    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    @JsonProperty("registrationConfiguration")
    public RegistrationConfiguration getRegistrationConfiguration() {
        return registrationConfiguration;
    }

    @JsonProperty("registrationConfiguration")
    public void setRegistrationConfiguration(RegistrationConfiguration registrationConfiguration) {
        this.registrationConfiguration = registrationConfiguration;
    }

    @JsonProperty("registrationImagePullSpec")
    public String getRegistrationImagePullSpec() {
        return registrationImagePullSpec;
    }

    @JsonProperty("registrationImagePullSpec")
    public void setRegistrationImagePullSpec(String registrationImagePullSpec) {
        this.registrationImagePullSpec = registrationImagePullSpec;
    }

    @JsonProperty("resourceRequirement")
    public ResourceRequirement getResourceRequirement() {
        return resourceRequirement;
    }

    @JsonProperty("resourceRequirement")
    public void setResourceRequirement(ResourceRequirement resourceRequirement) {
        this.resourceRequirement = resourceRequirement;
    }

    @JsonProperty("workConfiguration")
    public WorkAgentConfiguration getWorkConfiguration() {
        return workConfiguration;
    }

    @JsonProperty("workConfiguration")
    public void setWorkConfiguration(WorkAgentConfiguration workConfiguration) {
        this.workConfiguration = workConfiguration;
    }

    @JsonProperty("workImagePullSpec")
    public String getWorkImagePullSpec() {
        return workImagePullSpec;
    }

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
