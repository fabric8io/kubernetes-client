
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
     * runPolicy describes how the new build created from this build configuration will be scheduled for execution. This is optional, if not specified we default to "Serial".
     */
    @JsonProperty("runPolicy")
    public String getRunPolicy() {
        return runPolicy;
    }

    /**
     * runPolicy describes how the new build created from this build configuration will be scheduled for execution. This is optional, if not specified we default to "Serial".
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BuildConfigSpec)) {
            return false;
        }
        BuildConfigSpec other = (BuildConfigSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$completionDeadlineSeconds = this.getCompletionDeadlineSeconds();
        Object other$completionDeadlineSeconds = other.getCompletionDeadlineSeconds();
        if (this$completionDeadlineSeconds == null ? other$completionDeadlineSeconds != null : !this$completionDeadlineSeconds.equals(other$completionDeadlineSeconds)) {
            return false;
        }
        Object this$failedBuildsHistoryLimit = this.getFailedBuildsHistoryLimit();
        Object other$failedBuildsHistoryLimit = other.getFailedBuildsHistoryLimit();
        if (this$failedBuildsHistoryLimit == null ? other$failedBuildsHistoryLimit != null : !this$failedBuildsHistoryLimit.equals(other$failedBuildsHistoryLimit)) {
            return false;
        }
        Object this$mountTrustedCA = this.getMountTrustedCA();
        Object other$mountTrustedCA = other.getMountTrustedCA();
        if (this$mountTrustedCA == null ? other$mountTrustedCA != null : !this$mountTrustedCA.equals(other$mountTrustedCA)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$output = this.getOutput();
        Object other$output = other.getOutput();
        if (this$output == null ? other$output != null : !this$output.equals(other$output)) {
            return false;
        }
        Object this$postCommit = this.getPostCommit();
        Object other$postCommit = other.getPostCommit();
        if (this$postCommit == null ? other$postCommit != null : !this$postCommit.equals(other$postCommit)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$revision = this.getRevision();
        Object other$revision = other.getRevision();
        if (this$revision == null ? other$revision != null : !this$revision.equals(other$revision)) {
            return false;
        }
        Object this$runPolicy = this.getRunPolicy();
        Object other$runPolicy = other.getRunPolicy();
        if (this$runPolicy == null ? other$runPolicy != null : !this$runPolicy.equals(other$runPolicy)) {
            return false;
        }
        Object this$serviceAccount = this.getServiceAccount();
        Object other$serviceAccount = other.getServiceAccount();
        if (this$serviceAccount == null ? other$serviceAccount != null : !this$serviceAccount.equals(other$serviceAccount)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$strategy = this.getStrategy();
        Object other$strategy = other.getStrategy();
        if (this$strategy == null ? other$strategy != null : !this$strategy.equals(other$strategy)) {
            return false;
        }
        Object this$successfulBuildsHistoryLimit = this.getSuccessfulBuildsHistoryLimit();
        Object other$successfulBuildsHistoryLimit = other.getSuccessfulBuildsHistoryLimit();
        if (this$successfulBuildsHistoryLimit == null ? other$successfulBuildsHistoryLimit != null : !this$successfulBuildsHistoryLimit.equals(other$successfulBuildsHistoryLimit)) {
            return false;
        }
        Object this$triggers = this.getTriggers();
        Object other$triggers = other.getTriggers();
        if (this$triggers == null ? other$triggers != null : !this$triggers.equals(other$triggers)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof BuildConfigSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $completionDeadlineSeconds = this.getCompletionDeadlineSeconds();
        result = result * prime + ($completionDeadlineSeconds == null ? 43 : $completionDeadlineSeconds.hashCode());
        Object $failedBuildsHistoryLimit = this.getFailedBuildsHistoryLimit();
        result = result * prime + ($failedBuildsHistoryLimit == null ? 43 : $failedBuildsHistoryLimit.hashCode());
        Object $mountTrustedCA = this.getMountTrustedCA();
        result = result * prime + ($mountTrustedCA == null ? 43 : $mountTrustedCA.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $output = this.getOutput();
        result = result * prime + ($output == null ? 43 : $output.hashCode());
        Object $postCommit = this.getPostCommit();
        result = result * prime + ($postCommit == null ? 43 : $postCommit.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $revision = this.getRevision();
        result = result * prime + ($revision == null ? 43 : $revision.hashCode());
        Object $runPolicy = this.getRunPolicy();
        result = result * prime + ($runPolicy == null ? 43 : $runPolicy.hashCode());
        Object $serviceAccount = this.getServiceAccount();
        result = result * prime + ($serviceAccount == null ? 43 : $serviceAccount.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $strategy = this.getStrategy();
        result = result * prime + ($strategy == null ? 43 : $strategy.hashCode());
        Object $successfulBuildsHistoryLimit = this.getSuccessfulBuildsHistoryLimit();
        result = result * prime + ($successfulBuildsHistoryLimit == null ? 43 : $successfulBuildsHistoryLimit.hashCode());
        Object $triggers = this.getTriggers();
        result = result * prime + ($triggers == null ? 43 : $triggers.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildConfigSpec(" + "completionDeadlineSeconds=" + this.getCompletionDeadlineSeconds() + ", failedBuildsHistoryLimit=" + this.getFailedBuildsHistoryLimit() + ", mountTrustedCA=" + this.getMountTrustedCA() + ", nodeSelector=" + this.getNodeSelector() + ", output=" + this.getOutput() + ", postCommit=" + this.getPostCommit() + ", resources=" + this.getResources() + ", revision=" + this.getRevision() + ", runPolicy=" + this.getRunPolicy() + ", serviceAccount=" + this.getServiceAccount() + ", source=" + this.getSource() + ", strategy=" + this.getStrategy() + ", successfulBuildsHistoryLimit=" + this.getSuccessfulBuildsHistoryLimit() + ", triggers=" + this.getTriggers() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
