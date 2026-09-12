
package io.fabric8.openshift.api.model.autoscaling.v1;

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

/**
 * Desired state of ClusterAutoscaler resource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "balanceSimilarNodeGroups",
    "balancingIgnoredLabels",
    "expanders",
    "ignoreDaemonsetsUtilization",
    "logVerbosity",
    "maxNodeProvisionTime",
    "maxPodGracePeriod",
    "podPriorityThreshold",
    "resourceLimits",
    "scaleDown",
    "scaleUp",
    "skipNodesWithLocalStorage"
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
public class ClusterAutoscalerSpec implements Editable<ClusterAutoscalerSpecBuilder>, KubernetesResource
{

    @JsonProperty("balanceSimilarNodeGroups")
    private Boolean balanceSimilarNodeGroups;
    @JsonProperty("balancingIgnoredLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> balancingIgnoredLabels = new ArrayList<>();
    @JsonProperty("expanders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> expanders = new ArrayList<>();
    @JsonProperty("ignoreDaemonsetsUtilization")
    private Boolean ignoreDaemonsetsUtilization;
    @JsonProperty("logVerbosity")
    private Integer logVerbosity;
    @JsonProperty("maxNodeProvisionTime")
    private String maxNodeProvisionTime;
    @JsonProperty("maxPodGracePeriod")
    private Integer maxPodGracePeriod;
    @JsonProperty("podPriorityThreshold")
    private Integer podPriorityThreshold;
    @JsonProperty("resourceLimits")
    private ClusterAutoscalerSpecResourceLimits resourceLimits;
    @JsonProperty("scaleDown")
    private ClusterAutoscalerSpecScaleDown scaleDown;
    @JsonProperty("scaleUp")
    private ClusterAutoscalerSpecScaleUp scaleUp;
    @JsonProperty("skipNodesWithLocalStorage")
    private Boolean skipNodesWithLocalStorage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAutoscalerSpec() {
    }

    public ClusterAutoscalerSpec(Boolean balanceSimilarNodeGroups, List<String> balancingIgnoredLabels, List<String> expanders, Boolean ignoreDaemonsetsUtilization, Integer logVerbosity, String maxNodeProvisionTime, Integer maxPodGracePeriod, Integer podPriorityThreshold, ClusterAutoscalerSpecResourceLimits resourceLimits, ClusterAutoscalerSpecScaleDown scaleDown, ClusterAutoscalerSpecScaleUp scaleUp, Boolean skipNodesWithLocalStorage) {
        super();
        this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
        this.balancingIgnoredLabels = balancingIgnoredLabels;
        this.expanders = expanders;
        this.ignoreDaemonsetsUtilization = ignoreDaemonsetsUtilization;
        this.logVerbosity = logVerbosity;
        this.maxNodeProvisionTime = maxNodeProvisionTime;
        this.maxPodGracePeriod = maxPodGracePeriod;
        this.podPriorityThreshold = podPriorityThreshold;
        this.resourceLimits = resourceLimits;
        this.scaleDown = scaleDown;
        this.scaleUp = scaleUp;
        this.skipNodesWithLocalStorage = skipNodesWithLocalStorage;
    }

    /**
     * BalanceSimilarNodeGroups enables/disables the<br><p> `--balance-similar-node-groups` cluster-autoscaler feature.<br><p> This feature will automatically identify node groups with<br><p> the same instance type and the same set of labels and try<br><p> to keep the respective sizes of those node groups balanced.
     */
    @JsonProperty("balanceSimilarNodeGroups")
    public Boolean getBalanceSimilarNodeGroups() {
        return balanceSimilarNodeGroups;
    }

    /**
     * BalanceSimilarNodeGroups enables/disables the<br><p> `--balance-similar-node-groups` cluster-autoscaler feature.<br><p> This feature will automatically identify node groups with<br><p> the same instance type and the same set of labels and try<br><p> to keep the respective sizes of those node groups balanced.
     */
    @JsonProperty("balanceSimilarNodeGroups")
    public void setBalanceSimilarNodeGroups(Boolean balanceSimilarNodeGroups) {
        this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
    }

    /**
     * BalancingIgnoredLabels sets "--balancing-ignore-label &lt;label name&gt;" flag on cluster-autoscaler for each listed label.<br><p> This option specifies labels that cluster autoscaler should ignore when considering node group similarity.<br><p> For example, if you have nodes with "topology.ebs.csi.aws.com/zone" label, you can add name of this label here<br><p> to prevent cluster autoscaler from spliting nodes into different node groups based on its value.
     */
    @JsonProperty("balancingIgnoredLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBalancingIgnoredLabels() {
        return balancingIgnoredLabels;
    }

    /**
     * BalancingIgnoredLabels sets "--balancing-ignore-label &lt;label name&gt;" flag on cluster-autoscaler for each listed label.<br><p> This option specifies labels that cluster autoscaler should ignore when considering node group similarity.<br><p> For example, if you have nodes with "topology.ebs.csi.aws.com/zone" label, you can add name of this label here<br><p> to prevent cluster autoscaler from spliting nodes into different node groups based on its value.
     */
    @JsonProperty("balancingIgnoredLabels")
    public void setBalancingIgnoredLabels(List<String> balancingIgnoredLabels) {
        this.balancingIgnoredLabels = balancingIgnoredLabels;
    }

    /**
     * Sets the type and order of expanders to be used during scale out operations.<br><p> This option specifies an ordered list, highest priority first, of expanders that<br><p> will be used by the cluster autoscaler to select node groups for expansion<br><p> when scaling out.<br><p> Expanders instruct the autoscaler on how to choose node groups when scaling out<br><p> the cluster. They can be specified in order so that the result from the first expander<br><p> is used as the input to the second, and so forth. For example, if set to `[LeastWaste, Random]`<br><p> the autoscaler will first evaluate node groups to determine which will have the least<br><p> resource waste, if multiple groups are selected the autoscaler will then randomly choose<br><p> between those groups to determine the group for scaling.<br><p> The following expanders are available:<br><p> &#42; LeastWaste - selects the node group that will have the least idle CPU (if tied, unused memory) after scale-up.<br><p> &#42; Priority - selects the node group that has the highest priority assigned by the user. For details, please see https://github.com/openshift/kubernetes-autoscaler/blob/master/cluster-autoscaler/expander/priority/readme.md<br><p> &#42; Random - selects the node group randomly.<br><p> If not specified, the default value is `Random`, available options are: `LeastWaste`, `Priority`, `Random`.
     */
    @JsonProperty("expanders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExpanders() {
        return expanders;
    }

    /**
     * Sets the type and order of expanders to be used during scale out operations.<br><p> This option specifies an ordered list, highest priority first, of expanders that<br><p> will be used by the cluster autoscaler to select node groups for expansion<br><p> when scaling out.<br><p> Expanders instruct the autoscaler on how to choose node groups when scaling out<br><p> the cluster. They can be specified in order so that the result from the first expander<br><p> is used as the input to the second, and so forth. For example, if set to `[LeastWaste, Random]`<br><p> the autoscaler will first evaluate node groups to determine which will have the least<br><p> resource waste, if multiple groups are selected the autoscaler will then randomly choose<br><p> between those groups to determine the group for scaling.<br><p> The following expanders are available:<br><p> &#42; LeastWaste - selects the node group that will have the least idle CPU (if tied, unused memory) after scale-up.<br><p> &#42; Priority - selects the node group that has the highest priority assigned by the user. For details, please see https://github.com/openshift/kubernetes-autoscaler/blob/master/cluster-autoscaler/expander/priority/readme.md<br><p> &#42; Random - selects the node group randomly.<br><p> If not specified, the default value is `Random`, available options are: `LeastWaste`, `Priority`, `Random`.
     */
    @JsonProperty("expanders")
    public void setExpanders(List<String> expanders) {
        this.expanders = expanders;
    }

    /**
     * Enables/Disables `--ignore-daemonsets-utilization` CA feature flag. Should CA ignore DaemonSet pods when calculating resource utilization for scaling down. false by default
     */
    @JsonProperty("ignoreDaemonsetsUtilization")
    public Boolean getIgnoreDaemonsetsUtilization() {
        return ignoreDaemonsetsUtilization;
    }

    /**
     * Enables/Disables `--ignore-daemonsets-utilization` CA feature flag. Should CA ignore DaemonSet pods when calculating resource utilization for scaling down. false by default
     */
    @JsonProperty("ignoreDaemonsetsUtilization")
    public void setIgnoreDaemonsetsUtilization(Boolean ignoreDaemonsetsUtilization) {
        this.ignoreDaemonsetsUtilization = ignoreDaemonsetsUtilization;
    }

    /**
     * Sets the autoscaler log level.<br><p> Default value is 1, level 4 is recommended for DEBUGGING and level 6 will enable almost everything.<br><p> <br><p> This option has priority over log level set by the `CLUSTER_AUTOSCALER_VERBOSITY` environment variable.
     */
    @JsonProperty("logVerbosity")
    public Integer getLogVerbosity() {
        return logVerbosity;
    }

    /**
     * Sets the autoscaler log level.<br><p> Default value is 1, level 4 is recommended for DEBUGGING and level 6 will enable almost everything.<br><p> <br><p> This option has priority over log level set by the `CLUSTER_AUTOSCALER_VERBOSITY` environment variable.
     */
    @JsonProperty("logVerbosity")
    public void setLogVerbosity(Integer logVerbosity) {
        this.logVerbosity = logVerbosity;
    }

    /**
     * Maximum time CA waits for node to be provisioned
     */
    @JsonProperty("maxNodeProvisionTime")
    public String getMaxNodeProvisionTime() {
        return maxNodeProvisionTime;
    }

    /**
     * Maximum time CA waits for node to be provisioned
     */
    @JsonProperty("maxNodeProvisionTime")
    public void setMaxNodeProvisionTime(String maxNodeProvisionTime) {
        this.maxNodeProvisionTime = maxNodeProvisionTime;
    }

    /**
     * Gives pods graceful termination time before scaling down
     */
    @JsonProperty("maxPodGracePeriod")
    public Integer getMaxPodGracePeriod() {
        return maxPodGracePeriod;
    }

    /**
     * Gives pods graceful termination time before scaling down
     */
    @JsonProperty("maxPodGracePeriod")
    public void setMaxPodGracePeriod(Integer maxPodGracePeriod) {
        this.maxPodGracePeriod = maxPodGracePeriod;
    }

    /**
     * To allow users to schedule "best-effort" pods, which shouldn't trigger<br><p> Cluster Autoscaler actions, but only run when there are spare resources available,<br><p> More info: https://github.com/kubernetes/autoscaler/blob/master/cluster-autoscaler/FAQ.md#how-does-cluster-autoscaler-work-with-pod-priority-and-preemption
     */
    @JsonProperty("podPriorityThreshold")
    public Integer getPodPriorityThreshold() {
        return podPriorityThreshold;
    }

    /**
     * To allow users to schedule "best-effort" pods, which shouldn't trigger<br><p> Cluster Autoscaler actions, but only run when there are spare resources available,<br><p> More info: https://github.com/kubernetes/autoscaler/blob/master/cluster-autoscaler/FAQ.md#how-does-cluster-autoscaler-work-with-pod-priority-and-preemption
     */
    @JsonProperty("podPriorityThreshold")
    public void setPodPriorityThreshold(Integer podPriorityThreshold) {
        this.podPriorityThreshold = podPriorityThreshold;
    }

    /**
     * Desired state of ClusterAutoscaler resource
     */
    @JsonProperty("resourceLimits")
    public ClusterAutoscalerSpecResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    /**
     * Desired state of ClusterAutoscaler resource
     */
    @JsonProperty("resourceLimits")
    public void setResourceLimits(ClusterAutoscalerSpecResourceLimits resourceLimits) {
        this.resourceLimits = resourceLimits;
    }

    /**
     * Desired state of ClusterAutoscaler resource
     */
    @JsonProperty("scaleDown")
    public ClusterAutoscalerSpecScaleDown getScaleDown() {
        return scaleDown;
    }

    /**
     * Desired state of ClusterAutoscaler resource
     */
    @JsonProperty("scaleDown")
    public void setScaleDown(ClusterAutoscalerSpecScaleDown scaleDown) {
        this.scaleDown = scaleDown;
    }

    /**
     * Desired state of ClusterAutoscaler resource
     */
    @JsonProperty("scaleUp")
    public ClusterAutoscalerSpecScaleUp getScaleUp() {
        return scaleUp;
    }

    /**
     * Desired state of ClusterAutoscaler resource
     */
    @JsonProperty("scaleUp")
    public void setScaleUp(ClusterAutoscalerSpecScaleUp scaleUp) {
        this.scaleUp = scaleUp;
    }

    /**
     * Enables/Disables `--skip-nodes-with-local-storage` CA feature flag. If true cluster autoscaler will never delete nodes with pods with local storage, e.g. EmptyDir or HostPath. true by default at autoscaler
     */
    @JsonProperty("skipNodesWithLocalStorage")
    public Boolean getSkipNodesWithLocalStorage() {
        return skipNodesWithLocalStorage;
    }

    /**
     * Enables/Disables `--skip-nodes-with-local-storage` CA feature flag. If true cluster autoscaler will never delete nodes with pods with local storage, e.g. EmptyDir or HostPath. true by default at autoscaler
     */
    @JsonProperty("skipNodesWithLocalStorage")
    public void setSkipNodesWithLocalStorage(Boolean skipNodesWithLocalStorage) {
        this.skipNodesWithLocalStorage = skipNodesWithLocalStorage;
    }

    @JsonIgnore
    public ClusterAutoscalerSpecBuilder edit() {
        return new ClusterAutoscalerSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterAutoscalerSpecBuilder toBuilder() {
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
        if (!(o instanceof ClusterAutoscalerSpec)) {
            return false;
        }
        ClusterAutoscalerSpec other = (ClusterAutoscalerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$balanceSimilarNodeGroups = this.getBalanceSimilarNodeGroups();
        Object other$balanceSimilarNodeGroups = other.getBalanceSimilarNodeGroups();
        if (this$balanceSimilarNodeGroups == null ? other$balanceSimilarNodeGroups != null : !this$balanceSimilarNodeGroups.equals(other$balanceSimilarNodeGroups)) {
            return false;
        }
        Object this$balancingIgnoredLabels = this.getBalancingIgnoredLabels();
        Object other$balancingIgnoredLabels = other.getBalancingIgnoredLabels();
        if (this$balancingIgnoredLabels == null ? other$balancingIgnoredLabels != null : !this$balancingIgnoredLabels.equals(other$balancingIgnoredLabels)) {
            return false;
        }
        Object this$expanders = this.getExpanders();
        Object other$expanders = other.getExpanders();
        if (this$expanders == null ? other$expanders != null : !this$expanders.equals(other$expanders)) {
            return false;
        }
        Object this$ignoreDaemonsetsUtilization = this.getIgnoreDaemonsetsUtilization();
        Object other$ignoreDaemonsetsUtilization = other.getIgnoreDaemonsetsUtilization();
        if (this$ignoreDaemonsetsUtilization == null ? other$ignoreDaemonsetsUtilization != null : !this$ignoreDaemonsetsUtilization.equals(other$ignoreDaemonsetsUtilization)) {
            return false;
        }
        Object this$logVerbosity = this.getLogVerbosity();
        Object other$logVerbosity = other.getLogVerbosity();
        if (this$logVerbosity == null ? other$logVerbosity != null : !this$logVerbosity.equals(other$logVerbosity)) {
            return false;
        }
        Object this$maxNodeProvisionTime = this.getMaxNodeProvisionTime();
        Object other$maxNodeProvisionTime = other.getMaxNodeProvisionTime();
        if (this$maxNodeProvisionTime == null ? other$maxNodeProvisionTime != null : !this$maxNodeProvisionTime.equals(other$maxNodeProvisionTime)) {
            return false;
        }
        Object this$maxPodGracePeriod = this.getMaxPodGracePeriod();
        Object other$maxPodGracePeriod = other.getMaxPodGracePeriod();
        if (this$maxPodGracePeriod == null ? other$maxPodGracePeriod != null : !this$maxPodGracePeriod.equals(other$maxPodGracePeriod)) {
            return false;
        }
        Object this$podPriorityThreshold = this.getPodPriorityThreshold();
        Object other$podPriorityThreshold = other.getPodPriorityThreshold();
        if (this$podPriorityThreshold == null ? other$podPriorityThreshold != null : !this$podPriorityThreshold.equals(other$podPriorityThreshold)) {
            return false;
        }
        Object this$resourceLimits = this.getResourceLimits();
        Object other$resourceLimits = other.getResourceLimits();
        if (this$resourceLimits == null ? other$resourceLimits != null : !this$resourceLimits.equals(other$resourceLimits)) {
            return false;
        }
        Object this$scaleDown = this.getScaleDown();
        Object other$scaleDown = other.getScaleDown();
        if (this$scaleDown == null ? other$scaleDown != null : !this$scaleDown.equals(other$scaleDown)) {
            return false;
        }
        Object this$scaleUp = this.getScaleUp();
        Object other$scaleUp = other.getScaleUp();
        if (this$scaleUp == null ? other$scaleUp != null : !this$scaleUp.equals(other$scaleUp)) {
            return false;
        }
        Object this$skipNodesWithLocalStorage = this.getSkipNodesWithLocalStorage();
        Object other$skipNodesWithLocalStorage = other.getSkipNodesWithLocalStorage();
        if (this$skipNodesWithLocalStorage == null ? other$skipNodesWithLocalStorage != null : !this$skipNodesWithLocalStorage.equals(other$skipNodesWithLocalStorage)) {
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
        return other instanceof ClusterAutoscalerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $balanceSimilarNodeGroups = this.getBalanceSimilarNodeGroups();
        result = result * prime + ($balanceSimilarNodeGroups == null ? 43 : $balanceSimilarNodeGroups.hashCode());
        Object $balancingIgnoredLabels = this.getBalancingIgnoredLabels();
        result = result * prime + ($balancingIgnoredLabels == null ? 43 : $balancingIgnoredLabels.hashCode());
        Object $expanders = this.getExpanders();
        result = result * prime + ($expanders == null ? 43 : $expanders.hashCode());
        Object $ignoreDaemonsetsUtilization = this.getIgnoreDaemonsetsUtilization();
        result = result * prime + ($ignoreDaemonsetsUtilization == null ? 43 : $ignoreDaemonsetsUtilization.hashCode());
        Object $logVerbosity = this.getLogVerbosity();
        result = result * prime + ($logVerbosity == null ? 43 : $logVerbosity.hashCode());
        Object $maxNodeProvisionTime = this.getMaxNodeProvisionTime();
        result = result * prime + ($maxNodeProvisionTime == null ? 43 : $maxNodeProvisionTime.hashCode());
        Object $maxPodGracePeriod = this.getMaxPodGracePeriod();
        result = result * prime + ($maxPodGracePeriod == null ? 43 : $maxPodGracePeriod.hashCode());
        Object $podPriorityThreshold = this.getPodPriorityThreshold();
        result = result * prime + ($podPriorityThreshold == null ? 43 : $podPriorityThreshold.hashCode());
        Object $resourceLimits = this.getResourceLimits();
        result = result * prime + ($resourceLimits == null ? 43 : $resourceLimits.hashCode());
        Object $scaleDown = this.getScaleDown();
        result = result * prime + ($scaleDown == null ? 43 : $scaleDown.hashCode());
        Object $scaleUp = this.getScaleUp();
        result = result * prime + ($scaleUp == null ? 43 : $scaleUp.hashCode());
        Object $skipNodesWithLocalStorage = this.getSkipNodesWithLocalStorage();
        result = result * prime + ($skipNodesWithLocalStorage == null ? 43 : $skipNodesWithLocalStorage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterAutoscalerSpec(" + "balanceSimilarNodeGroups=" + this.getBalanceSimilarNodeGroups() + ", balancingIgnoredLabels=" + this.getBalancingIgnoredLabels() + ", expanders=" + this.getExpanders() + ", ignoreDaemonsetsUtilization=" + this.getIgnoreDaemonsetsUtilization() + ", logVerbosity=" + this.getLogVerbosity() + ", maxNodeProvisionTime=" + this.getMaxNodeProvisionTime() + ", maxPodGracePeriod=" + this.getMaxPodGracePeriod() + ", podPriorityThreshold=" + this.getPodPriorityThreshold() + ", resourceLimits=" + this.getResourceLimits() + ", scaleDown=" + this.getScaleDown() + ", scaleUp=" + this.getScaleUp() + ", skipNodesWithLocalStorage=" + this.getSkipNodesWithLocalStorage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
