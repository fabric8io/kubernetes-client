
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
    "approval",
    "approved",
    "clusterServiceVersionNames",
    "generation",
    "source",
    "sourceNamespace"
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
public class InstallPlanSpec implements KubernetesResource
{

    @JsonProperty("approval")
    private String approval;
    @JsonProperty("approved")
    private Boolean approved;
    @JsonProperty("clusterServiceVersionNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> clusterServiceVersionNames = new ArrayList<String>();
    @JsonProperty("generation")
    private Integer generation;
    @JsonProperty("source")
    private String source;
    @JsonProperty("sourceNamespace")
    private String sourceNamespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InstallPlanSpec() {
    }

    public InstallPlanSpec(String approval, Boolean approved, List<String> clusterServiceVersionNames, Integer generation, String source, String sourceNamespace) {
        super();
        this.approval = approval;
        this.approved = approved;
        this.clusterServiceVersionNames = clusterServiceVersionNames;
        this.generation = generation;
        this.source = source;
        this.sourceNamespace = sourceNamespace;
    }

    @JsonProperty("approval")
    public String getApproval() {
        return approval;
    }

    @JsonProperty("approval")
    public void setApproval(String approval) {
        this.approval = approval;
    }

    @JsonProperty("approved")
    public Boolean getApproved() {
        return approved;
    }

    @JsonProperty("approved")
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @JsonProperty("clusterServiceVersionNames")
    public List<String> getClusterServiceVersionNames() {
        return clusterServiceVersionNames;
    }

    @JsonProperty("clusterServiceVersionNames")
    public void setClusterServiceVersionNames(List<String> clusterServiceVersionNames) {
        this.clusterServiceVersionNames = clusterServiceVersionNames;
    }

    @JsonProperty("generation")
    public Integer getGeneration() {
        return generation;
    }

    @JsonProperty("generation")
    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
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
