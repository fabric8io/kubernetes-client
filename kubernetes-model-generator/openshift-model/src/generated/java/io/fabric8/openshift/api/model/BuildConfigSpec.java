
package io.fabric8.openshift.api.model;

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
 * BuildConfigSpec describes when and how builds are created
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "completionDeadlineSeconds",
    "failedBuildsHistoryLimit",
    "mountTrustedCA",
    "nodeSelector",
    "output",
    "postCommit",
    "resources",
    "revision",
    "runPolicy",
    "serviceAccount",
    "source",
    "strategy",
    "successfulBuildsHistoryLimit",
    "triggers"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildConfigSpec implements Editable<BuildConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("completionDeadlineSeconds")
    private Long completionDeadlineSeconds;
    @JsonProperty("failedBuildsHistoryLimit")
    private Integer failedBuildsHistoryLimit;
    @JsonProperty("mountTrustedCA")
    private Boolean mountTrustedCA;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("output")
    private BuildOutput output;
    @JsonProperty("postCommit")
    private BuildPostCommitSpec postCommit;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("revision")
    private SourceRevision revision;
    @JsonProperty("runPolicy")
    private String runPolicy;
    @JsonProperty("serviceAccount")
    private String serviceAccount;
    @JsonProperty("source")
    private BuildSource source;
    @JsonProperty("strategy")
    private BuildStrategy strategy;
    @JsonProperty("successfulBuildsHistoryLimit")
    private Integer successfulBuildsHistoryLimit;
    @JsonProperty("triggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildTriggerPolicy> triggers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildConfigSpec() {
    }

    public BuildConfigSpec(Long completionDeadlineSeconds, Integer failedBuildsHistoryLimit, Boolean mountTrustedCA, Map<String, String> nodeSelector, BuildOutput output, BuildPostCommitSpec postCommit, ResourceRequirements resources, SourceRevision revision, String runPolicy, String serviceAccount, BuildSource source, BuildStrategy strategy, Integer successfulBuildsHistoryLimit, List<BuildTriggerPolicy> triggers) {
        super();
        this.completionDeadlineSeconds = completionDeadlineSeconds;
        this.failedBuildsHistoryLimit = failedBuildsHistoryLimit;
        this.mountTrustedCA = mountTrustedCA;
        this.nodeSelector = nodeSelector;
        this.output = output;
        this.postCommit = postCommit;
        this.resources = resources;
        this.revision = revision;
        this.runPolicy = runPolicy;
        this.serviceAccount = serviceAccount;
        this.source = source;
        this.strategy = strategy;
        this.successfulBuildsHistoryLimit = successfulBuildsHistoryLimit;
        this.triggers = triggers;
    }

    /**
     * completionDeadlineSeconds is an optional duration in seconds, counted from the time when a build pod gets scheduled in the system, that the build may be active on a node before the system actively tries to terminate the build; value must be positive integer
     */
    @JsonProperty("completionDeadlineSeconds")
    public Long getCompletionDeadlineSeconds() {
        return completionDeadlineSeconds;
    }

    /**
     * completionDeadlineSeconds is an optional duration in seconds, counted from the time when a build pod gets scheduled in the system, that the build may be active on a node before the system actively tries to terminate the build; value must be positive integer
     */
    @JsonProperty("completionDeadlineSeconds")
    public void setCompletionDeadlineSeconds(Long completionDeadlineSeconds) {
        this.completionDeadlineSeconds = completionDeadlineSeconds;
    }

    /**
     * failedBuildsHistoryLimit is the number of old failed builds to retain. When a BuildConfig is created, the 5 most recent failed builds are retained unless this value is set. If removed after the BuildConfig has been created, all failed builds are retained.
     */
    @JsonProperty("failedBuildsHistoryLimit")
    public Integer getFailedBuildsHistoryLimit() {
        return failedBuildsHistoryLimit;
    }

    /**
     * failedBuildsHistoryLimit is the number of old failed builds to retain. When a BuildConfig is created, the 5 most recent failed builds are retained unless this value is set. If removed after the BuildConfig has been created, all failed builds are retained.
     */
    @JsonProperty("failedBuildsHistoryLimit")
    public void setFailedBuildsHistoryLimit(Integer failedBuildsHistoryLimit) {
        this.failedBuildsHistoryLimit = failedBuildsHistoryLimit;
    }

    /**
     * mountTrustedCA bind mounts the cluster's trusted certificate authorities, as defined in the cluster's proxy configuration, into the build. This lets processes within a build trust components signed by custom PKI certificate authorities, such as private artifact repositories and HTTPS proxies.<br><p> <br><p> When this field is set to true, the contents of `/etc/pki/ca-trust` within the build are managed by the build container, and any changes to this directory or its subdirectories (for example - within a Dockerfile `RUN` instruction) are not persisted in the build's output image.
     */
    @JsonProperty("mountTrustedCA")
    public Boolean getMountTrustedCA() {
        return mountTrustedCA;
    }

    /**
     * mountTrustedCA bind mounts the cluster's trusted certificate authorities, as defined in the cluster's proxy configuration, into the build. This lets processes within a build trust components signed by custom PKI certificate authorities, such as private artifact repositories and HTTPS proxies.<br><p> <br><p> When this field is set to true, the contents of `/etc/pki/ca-trust` within the build are managed by the build container, and any changes to this directory or its subdirectories (for example - within a Dockerfile `RUN` instruction) are not persisted in the build's output image.
     */
    @JsonProperty("mountTrustedCA")
    public void setMountTrustedCA(Boolean mountTrustedCA) {
        this.mountTrustedCA = mountTrustedCA;
    }

    /**
     * nodeSelector is a selector which must be true for the build pod to fit on a node If nil, it can be overridden by default build nodeselector values for the cluster. If set to an empty map or a map with any values, default build nodeselector values are ignored.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * nodeSelector is a selector which must be true for the build pod to fit on a node If nil, it can be overridden by default build nodeselector values for the cluster. If set to an empty map or a map with any values, default build nodeselector values are ignored.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("output")
    public BuildOutput getOutput() {
        return output;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("output")
    public void setOutput(BuildOutput output) {
        this.output = output;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("postCommit")
    public BuildPostCommitSpec getPostCommit() {
        return postCommit;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("postCommit")
    public void setPostCommit(BuildPostCommitSpec postCommit) {
        this.postCommit = postCommit;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("revision")
    public SourceRevision getRevision() {
        return revision;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("revision")
    public void setRevision(SourceRevision revision) {
        this.revision = revision;
    }

    /**
     * RunPolicy describes how the new build created from this build configuration will be scheduled for execution. This is optional, if not specified we default to "Serial".
     */
    @JsonProperty("runPolicy")
    public String getRunPolicy() {
        return runPolicy;
    }

    /**
     * RunPolicy describes how the new build created from this build configuration will be scheduled for execution. This is optional, if not specified we default to "Serial".
     */
    @JsonProperty("runPolicy")
    public void setRunPolicy(String runPolicy) {
        this.runPolicy = runPolicy;
    }

    /**
     * serviceAccount is the name of the ServiceAccount to use to run the pod created by this build. The pod will be allowed to use secrets referenced by the ServiceAccount
     */
    @JsonProperty("serviceAccount")
    public String getServiceAccount() {
        return serviceAccount;
    }

    /**
     * serviceAccount is the name of the ServiceAccount to use to run the pod created by this build. The pod will be allowed to use secrets referenced by the ServiceAccount
     */
    @JsonProperty("serviceAccount")
    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("source")
    public BuildSource getSource() {
        return source;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("source")
    public void setSource(BuildSource source) {
        this.source = source;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("strategy")
    public BuildStrategy getStrategy() {
        return strategy;
    }

    /**
     * BuildConfigSpec describes when and how builds are created
     */
    @JsonProperty("strategy")
    public void setStrategy(BuildStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * successfulBuildsHistoryLimit is the number of old successful builds to retain. When a BuildConfig is created, the 5 most recent successful builds are retained unless this value is set. If removed after the BuildConfig has been created, all successful builds are retained.
     */
    @JsonProperty("successfulBuildsHistoryLimit")
    public Integer getSuccessfulBuildsHistoryLimit() {
        return successfulBuildsHistoryLimit;
    }

    /**
     * successfulBuildsHistoryLimit is the number of old successful builds to retain. When a BuildConfig is created, the 5 most recent successful builds are retained unless this value is set. If removed after the BuildConfig has been created, all successful builds are retained.
     */
    @JsonProperty("successfulBuildsHistoryLimit")
    public void setSuccessfulBuildsHistoryLimit(Integer successfulBuildsHistoryLimit) {
        this.successfulBuildsHistoryLimit = successfulBuildsHistoryLimit;
    }

    /**
     * triggers determine how new Builds can be launched from a BuildConfig. If no triggers are defined, a new build can only occur as a result of an explicit client build creation.
     */
    @JsonProperty("triggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BuildTriggerPolicy> getTriggers() {
        return triggers;
    }

    /**
     * triggers determine how new Builds can be launched from a BuildConfig. If no triggers are defined, a new build can only occur as a result of an explicit client build creation.
     */
    @JsonProperty("triggers")
    public void setTriggers(List<BuildTriggerPolicy> triggers) {
        this.triggers = triggers;
    }

    @JsonIgnore
    public BuildConfigSpecBuilder edit() {
        return new BuildConfigSpecBuilder(this);
    }

    @JsonIgnore
    public BuildConfigSpecBuilder toBuilder() {
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
