
package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
    "hubCluster",
    "policyName",
    "policyNamespace",
    "policySets",
    "policyViolations",
    "targetClusters"
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
public class ViolationContext implements Editable<ViolationContextBuilder>, KubernetesResource
{

    @JsonProperty("hubCluster")
    private String hubCluster;
    @JsonProperty("policyName")
    private String policyName;
    @JsonProperty("policyNamespace")
    private String policyNamespace;
    @JsonProperty("policySets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> policySets = new ArrayList<>();
    @JsonProperty("policyViolations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, ReplicatedPolicyStatus> policyViolations = new LinkedHashMap<>();
    @JsonProperty("targetClusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetClusters = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ViolationContext() {
    }

    public ViolationContext(String hubCluster, String policyName, String policyNamespace, List<String> policySets, Map<String, ReplicatedPolicyStatus> policyViolations, List<String> targetClusters) {
        super();
        this.hubCluster = hubCluster;
        this.policyName = policyName;
        this.policyNamespace = policyNamespace;
        this.policySets = policySets;
        this.policyViolations = policyViolations;
        this.targetClusters = targetClusters;
    }

    @JsonProperty("hubCluster")
    public String getHubCluster() {
        return hubCluster;
    }

    @JsonProperty("hubCluster")
    public void setHubCluster(String hubCluster) {
        this.hubCluster = hubCluster;
    }

    @JsonProperty("policyName")
    public String getPolicyName() {
        return policyName;
    }

    @JsonProperty("policyName")
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    @JsonProperty("policyNamespace")
    public String getPolicyNamespace() {
        return policyNamespace;
    }

    @JsonProperty("policyNamespace")
    public void setPolicyNamespace(String policyNamespace) {
        this.policyNamespace = policyNamespace;
    }

    @JsonProperty("policySets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPolicySets() {
        return policySets;
    }

    @JsonProperty("policySets")
    public void setPolicySets(List<String> policySets) {
        this.policySets = policySets;
    }

    @JsonProperty("policyViolations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, ReplicatedPolicyStatus> getPolicyViolations() {
        return policyViolations;
    }

    @JsonProperty("policyViolations")
    public void setPolicyViolations(Map<String, ReplicatedPolicyStatus> policyViolations) {
        this.policyViolations = policyViolations;
    }

    @JsonProperty("targetClusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargetClusters() {
        return targetClusters;
    }

    @JsonProperty("targetClusters")
    public void setTargetClusters(List<String> targetClusters) {
        this.targetClusters = targetClusters;
    }

    @JsonIgnore
    public ViolationContextBuilder edit() {
        return new ViolationContextBuilder(this);
    }

    @JsonIgnore
    public ViolationContextBuilder toBuilder() {
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
