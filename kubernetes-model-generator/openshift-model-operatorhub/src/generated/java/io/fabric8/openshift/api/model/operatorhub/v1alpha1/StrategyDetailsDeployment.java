
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "clusterPermissions",
    "deployments",
    "permissions"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class StrategyDetailsDeployment implements KubernetesResource
{

    @JsonProperty("clusterPermissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StrategyDeploymentPermissions> clusterPermissions = new ArrayList<StrategyDeploymentPermissions>();
    @JsonProperty("deployments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StrategyDeploymentSpec> deployments = new ArrayList<StrategyDeploymentSpec>();
    @JsonProperty("permissions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StrategyDeploymentPermissions> permissions = new ArrayList<StrategyDeploymentPermissions>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StrategyDetailsDeployment() {
    }

    public StrategyDetailsDeployment(List<StrategyDeploymentPermissions> clusterPermissions, List<StrategyDeploymentSpec> deployments, List<StrategyDeploymentPermissions> permissions) {
        super();
        this.clusterPermissions = clusterPermissions;
        this.deployments = deployments;
        this.permissions = permissions;
    }

    @JsonProperty("clusterPermissions")
    public List<StrategyDeploymentPermissions> getClusterPermissions() {
        return clusterPermissions;
    }

    @JsonProperty("clusterPermissions")
    public void setClusterPermissions(List<StrategyDeploymentPermissions> clusterPermissions) {
        this.clusterPermissions = clusterPermissions;
    }

    @JsonProperty("deployments")
    public List<StrategyDeploymentSpec> getDeployments() {
        return deployments;
    }

    @JsonProperty("deployments")
    public void setDeployments(List<StrategyDeploymentSpec> deployments) {
        this.deployments = deployments;
    }

    @JsonProperty("permissions")
    public List<StrategyDeploymentPermissions> getPermissions() {
        return permissions;
    }

    @JsonProperty("permissions")
    public void setPermissions(List<StrategyDeploymentPermissions> permissions) {
        this.permissions = permissions;
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
