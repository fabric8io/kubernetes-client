
package io.fabric8.openshift.api.model;

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
    "completionDeadlineSeconds",
    "mountTrustedCA",
    "nodeSelector",
    "output",
    "postCommit",
    "resources",
    "revision",
    "serviceAccount",
    "source",
    "strategy",
    "triggeredBy"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BuildSpec implements KubernetesResource
{

    @JsonProperty("completionDeadlineSeconds")
    private Long completionDeadlineSeconds;
    @JsonProperty("mountTrustedCA")
    private Boolean mountTrustedCA;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<String, String>();
    @JsonProperty("output")
    private BuildOutput output;
    @JsonProperty("postCommit")
    private BuildPostCommitSpec postCommit;
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonProperty("revision")
    private SourceRevision revision;
    @JsonProperty("serviceAccount")
    private java.lang.String serviceAccount;
    @JsonProperty("source")
    private BuildSource source;
    @JsonProperty("strategy")
    private BuildStrategy strategy;
    @JsonProperty("triggeredBy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildTriggerCause> triggeredBy = new ArrayList<BuildTriggerCause>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildSpec() {
    }

    public BuildSpec(Long completionDeadlineSeconds, Boolean mountTrustedCA, Map<String, String> nodeSelector, BuildOutput output, BuildPostCommitSpec postCommit, io.fabric8.kubernetes.api.model.ResourceRequirements resources, SourceRevision revision, java.lang.String serviceAccount, BuildSource source, BuildStrategy strategy, List<BuildTriggerCause> triggeredBy) {
        super();
        this.completionDeadlineSeconds = completionDeadlineSeconds;
        this.mountTrustedCA = mountTrustedCA;
        this.nodeSelector = nodeSelector;
        this.output = output;
        this.postCommit = postCommit;
        this.resources = resources;
        this.revision = revision;
        this.serviceAccount = serviceAccount;
        this.source = source;
        this.strategy = strategy;
        this.triggeredBy = triggeredBy;
    }

    @JsonProperty("completionDeadlineSeconds")
    public Long getCompletionDeadlineSeconds() {
        return completionDeadlineSeconds;
    }

    @JsonProperty("completionDeadlineSeconds")
    public void setCompletionDeadlineSeconds(Long completionDeadlineSeconds) {
        this.completionDeadlineSeconds = completionDeadlineSeconds;
    }

    @JsonProperty("mountTrustedCA")
    public Boolean getMountTrustedCA() {
        return mountTrustedCA;
    }

    @JsonProperty("mountTrustedCA")
    public void setMountTrustedCA(Boolean mountTrustedCA) {
        this.mountTrustedCA = mountTrustedCA;
    }

    @JsonProperty("nodeSelector")
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("output")
    public BuildOutput getOutput() {
        return output;
    }

    @JsonProperty("output")
    public void setOutput(BuildOutput output) {
        this.output = output;
    }

    @JsonProperty("postCommit")
    public BuildPostCommitSpec getPostCommit() {
        return postCommit;
    }

    @JsonProperty("postCommit")
    public void setPostCommit(BuildPostCommitSpec postCommit) {
        this.postCommit = postCommit;
    }

    @JsonProperty("resources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(io.fabric8.kubernetes.api.model.ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonProperty("revision")
    public SourceRevision getRevision() {
        return revision;
    }

    @JsonProperty("revision")
    public void setRevision(SourceRevision revision) {
        this.revision = revision;
    }

    @JsonProperty("serviceAccount")
    public java.lang.String getServiceAccount() {
        return serviceAccount;
    }

    @JsonProperty("serviceAccount")
    public void setServiceAccount(java.lang.String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    @JsonProperty("source")
    public BuildSource getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(BuildSource source) {
        this.source = source;
    }

    @JsonProperty("strategy")
    public BuildStrategy getStrategy() {
        return strategy;
    }

    @JsonProperty("strategy")
    public void setStrategy(BuildStrategy strategy) {
        this.strategy = strategy;
    }

    @JsonProperty("triggeredBy")
    public List<BuildTriggerCause> getTriggeredBy() {
        return triggeredBy;
    }

    @JsonProperty("triggeredBy")
    public void setTriggeredBy(List<BuildTriggerCause> triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
