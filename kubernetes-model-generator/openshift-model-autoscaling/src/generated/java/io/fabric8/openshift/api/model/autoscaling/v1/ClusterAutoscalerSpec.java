
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "skipNodesWithLocalStorage"
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
    @JsonProperty("skipNodesWithLocalStorage")
    private Boolean skipNodesWithLocalStorage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAutoscalerSpec() {
    }

    public ClusterAutoscalerSpec(Boolean balanceSimilarNodeGroups, List<String> balancingIgnoredLabels, List<String> expanders, Boolean ignoreDaemonsetsUtilization, Integer logVerbosity, String maxNodeProvisionTime, Integer maxPodGracePeriod, Integer podPriorityThreshold, ClusterAutoscalerSpecResourceLimits resourceLimits, ClusterAutoscalerSpecScaleDown scaleDown, Boolean skipNodesWithLocalStorage) {
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
        this.skipNodesWithLocalStorage = skipNodesWithLocalStorage;
    }

    /**
     * BalanceSimilarNodeGroups enables/disables the `--balance-similar-node-groups` cluster-autoscaler feature. This feature will automatically identify node groups with the same instance type and the same set of labels and try to keep the respective sizes of those node groups balanced.
     */
    @JsonProperty("balanceSimilarNodeGroups")
    public Boolean getBalanceSimilarNodeGroups() {
        return balanceSimilarNodeGroups;
    }

    /**
     * BalanceSimilarNodeGroups enables/disables the `--balance-similar-node-groups` cluster-autoscaler feature. This feature will automatically identify node groups with the same instance type and the same set of labels and try to keep the respective sizes of those node groups balanced.
     */
    @JsonProperty("balanceSimilarNodeGroups")
    public void setBalanceSimilarNodeGroups(Boolean balanceSimilarNodeGroups) {
        this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
    }

    /**
     * BalancingIgnoredLabels sets "--balancing-ignore-label &lt;label name&gt;" flag on cluster-autoscaler for each listed label. This option specifies labels that cluster autoscaler should ignore when considering node group similarity. For example, if you have nodes with "topology.ebs.csi.aws.com/zone" label, you can add name of this label here to prevent cluster autoscaler from spliting nodes into different node groups based on its value.
     */
    @JsonProperty("balancingIgnoredLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBalancingIgnoredLabels() {
        return balancingIgnoredLabels;
    }

    /**
     * BalancingIgnoredLabels sets "--balancing-ignore-label &lt;label name&gt;" flag on cluster-autoscaler for each listed label. This option specifies labels that cluster autoscaler should ignore when considering node group similarity. For example, if you have nodes with "topology.ebs.csi.aws.com/zone" label, you can add name of this label here to prevent cluster autoscaler from spliting nodes into different node groups based on its value.
     */
    @JsonProperty("balancingIgnoredLabels")
    public void setBalancingIgnoredLabels(List<String> balancingIgnoredLabels) {
        this.balancingIgnoredLabels = balancingIgnoredLabels;
    }

    /**
     * Sets the type and order of expanders to be used during scale out operations. This option specifies an ordered list, highest priority first, of expanders that will be used by the cluster autoscaler to select node groups for expansion when scaling out. Expanders instruct the autoscaler on how to choose node groups when scaling out the cluster. They can be specified in order so that the result from the first expander is used as the input to the second, and so forth. For example, if set to `[LeastWaste, Random]` the autoscaler will first evaluate node groups to determine which will have the least resource waste, if multiple groups are selected the autoscaler will then randomly choose between those groups to determine the group for scaling. The following expanders are available: &#42; LeastWaste - selects the node group that will have the least idle CPU (if tied, unused memory) after scale-up. &#42; Priority - selects the node group that has the highest priority assigned by the user. For details, please see https://github.com/openshift/kubernetes-autoscaler/blob/master/cluster-autoscaler/expander/priority/readme.md &#42; Random - selects the node group randomly. If not specified, the default value is `Random`, available options are: `LeastWaste`, `Priority`, `Random`.
     */
    @JsonProperty("expanders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExpanders() {
        return expanders;
    }

    /**
     * Sets the type and order of expanders to be used during scale out operations. This option specifies an ordered list, highest priority first, of expanders that will be used by the cluster autoscaler to select node groups for expansion when scaling out. Expanders instruct the autoscaler on how to choose node groups when scaling out the cluster. They can be specified in order so that the result from the first expander is used as the input to the second, and so forth. For example, if set to `[LeastWaste, Random]` the autoscaler will first evaluate node groups to determine which will have the least resource waste, if multiple groups are selected the autoscaler will then randomly choose between those groups to determine the group for scaling. The following expanders are available: &#42; LeastWaste - selects the node group that will have the least idle CPU (if tied, unused memory) after scale-up. &#42; Priority - selects the node group that has the highest priority assigned by the user. For details, please see https://github.com/openshift/kubernetes-autoscaler/blob/master/cluster-autoscaler/expander/priority/readme.md &#42; Random - selects the node group randomly. If not specified, the default value is `Random`, available options are: `LeastWaste`, `Priority`, `Random`.
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
     * Sets the autoscaler log level. Default value is 1, level 4 is recommended for DEBUGGING and level 6 will enable almost everything. <br><p>  This option has priority over log level set by the `CLUSTER_AUTOSCALER_VERBOSITY` environment variable.
     */
    @JsonProperty("logVerbosity")
    public Integer getLogVerbosity() {
        return logVerbosity;
    }

    /**
     * Sets the autoscaler log level. Default value is 1, level 4 is recommended for DEBUGGING and level 6 will enable almost everything. <br><p>  This option has priority over log level set by the `CLUSTER_AUTOSCALER_VERBOSITY` environment variable.
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
     * To allow users to schedule "best-effort" pods, which shouldn't trigger Cluster Autoscaler actions, but only run when there are spare resources available, More info: https://github.com/kubernetes/autoscaler/blob/master/cluster-autoscaler/FAQ.md#how-does-cluster-autoscaler-work-with-pod-priority-and-preemption
     */
    @JsonProperty("podPriorityThreshold")
    public Integer getPodPriorityThreshold() {
        return podPriorityThreshold;
    }

    /**
     * To allow users to schedule "best-effort" pods, which shouldn't trigger Cluster Autoscaler actions, but only run when there are spare resources available, More info: https://github.com/kubernetes/autoscaler/blob/master/cluster-autoscaler/FAQ.md#how-does-cluster-autoscaler-work-with-pod-priority-and-preemption
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

}
