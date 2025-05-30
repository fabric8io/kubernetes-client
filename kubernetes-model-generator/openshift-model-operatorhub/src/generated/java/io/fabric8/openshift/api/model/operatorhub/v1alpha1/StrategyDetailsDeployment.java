
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
 * StrategyDetailsDeployment represents the parsed details of a Deployment InstallStrategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterPermissions",
    "deployments",
    "permissions"
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
public class StrategyDetailsDeployment implements Editable<StrategyDetailsDeploymentBuilder>, KubernetesResource
{

    @JsonProperty("clusterPermissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StrategyDeploymentPermissions> clusterPermissions = new ArrayList<>();
    @JsonProperty("deployments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StrategyDeploymentSpec> deployments = new ArrayList<>();
    @JsonProperty("permissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StrategyDeploymentPermissions> permissions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StrategyDetailsDeployment() {
    }

    public StrategyDetailsDeployment(List<StrategyDeploymentPermissions> clusterPermissions, List<StrategyDeploymentSpec> deployments, List<StrategyDeploymentPermissions> permissions) {
        super();
        this.clusterPermissions = clusterPermissions;
        this.deployments = deployments;
        this.permissions = permissions;
    }

    /**
     * StrategyDetailsDeployment represents the parsed details of a Deployment InstallStrategy.
     */
    @JsonProperty("clusterPermissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StrategyDeploymentPermissions> getClusterPermissions() {
        return clusterPermissions;
    }

    /**
     * StrategyDetailsDeployment represents the parsed details of a Deployment InstallStrategy.
     */
    @JsonProperty("clusterPermissions")
    public void setClusterPermissions(List<StrategyDeploymentPermissions> clusterPermissions) {
        this.clusterPermissions = clusterPermissions;
    }

    /**
     * StrategyDetailsDeployment represents the parsed details of a Deployment InstallStrategy.
     */
    @JsonProperty("deployments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StrategyDeploymentSpec> getDeployments() {
        return deployments;
    }

    /**
     * StrategyDetailsDeployment represents the parsed details of a Deployment InstallStrategy.
     */
    @JsonProperty("deployments")
    public void setDeployments(List<StrategyDeploymentSpec> deployments) {
        this.deployments = deployments;
    }

    /**
     * StrategyDetailsDeployment represents the parsed details of a Deployment InstallStrategy.
     */
    @JsonProperty("permissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StrategyDeploymentPermissions> getPermissions() {
        return permissions;
    }

    /**
     * StrategyDetailsDeployment represents the parsed details of a Deployment InstallStrategy.
     */
    @JsonProperty("permissions")
    public void setPermissions(List<StrategyDeploymentPermissions> permissions) {
        this.permissions = permissions;
    }

    @JsonIgnore
    public StrategyDetailsDeploymentBuilder edit() {
        return new StrategyDetailsDeploymentBuilder(this);
    }

    @JsonIgnore
    public StrategyDetailsDeploymentBuilder toBuilder() {
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
