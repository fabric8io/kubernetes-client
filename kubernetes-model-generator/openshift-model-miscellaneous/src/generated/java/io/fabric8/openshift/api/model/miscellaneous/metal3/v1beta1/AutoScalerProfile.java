
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import java.util.LinkedHashMap;
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
 * AutoScalerProfile parameters to be applied to the cluster-autoscaler. See also [AKS doc], [K8s doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/cluster-autoscaler#use-the-cluster-autoscaler-profile [K8s doc]: https://github.com/kubernetes/autoscaler/blob/master/cluster-autoscaler/FAQ.md#what-are-the-parameters-to-ca Default values are from https://learn.microsoft.com/azure/aks/cluster-autoscaler#using-the-autoscaler-profile
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "balanceSimilarNodeGroups",
    "expander",
    "maxEmptyBulkDelete",
    "maxGracefulTerminationSec",
    "maxNodeProvisionTime",
    "maxTotalUnreadyPercentage",
    "newPodScaleUpDelay",
    "okTotalUnreadyCount",
    "scaleDownDelayAfterAdd",
    "scaleDownDelayAfterDelete",
    "scaleDownDelayAfterFailure",
    "scaleDownUnneededTime",
    "scaleDownUnreadyTime",
    "scaleDownUtilizationThreshold",
    "scanInterval",
    "skipNodesWithLocalStorage",
    "skipNodesWithSystemPods"
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
public class AutoScalerProfile implements Editable<AutoScalerProfileBuilder>, KubernetesResource
{

    @JsonProperty("balanceSimilarNodeGroups")
    private String balanceSimilarNodeGroups;
    @JsonProperty("expander")
    private String expander;
    @JsonProperty("maxEmptyBulkDelete")
    private String maxEmptyBulkDelete;
    @JsonProperty("maxGracefulTerminationSec")
    private String maxGracefulTerminationSec;
    @JsonProperty("maxNodeProvisionTime")
    private String maxNodeProvisionTime;
    @JsonProperty("maxTotalUnreadyPercentage")
    private String maxTotalUnreadyPercentage;
    @JsonProperty("newPodScaleUpDelay")
    private String newPodScaleUpDelay;
    @JsonProperty("okTotalUnreadyCount")
    private String okTotalUnreadyCount;
    @JsonProperty("scaleDownDelayAfterAdd")
    private String scaleDownDelayAfterAdd;
    @JsonProperty("scaleDownDelayAfterDelete")
    private String scaleDownDelayAfterDelete;
    @JsonProperty("scaleDownDelayAfterFailure")
    private String scaleDownDelayAfterFailure;
    @JsonProperty("scaleDownUnneededTime")
    private String scaleDownUnneededTime;
    @JsonProperty("scaleDownUnreadyTime")
    private String scaleDownUnreadyTime;
    @JsonProperty("scaleDownUtilizationThreshold")
    private String scaleDownUtilizationThreshold;
    @JsonProperty("scanInterval")
    private String scanInterval;
    @JsonProperty("skipNodesWithLocalStorage")
    private String skipNodesWithLocalStorage;
    @JsonProperty("skipNodesWithSystemPods")
    private String skipNodesWithSystemPods;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AutoScalerProfile() {
    }

    public AutoScalerProfile(String balanceSimilarNodeGroups, String expander, String maxEmptyBulkDelete, String maxGracefulTerminationSec, String maxNodeProvisionTime, String maxTotalUnreadyPercentage, String newPodScaleUpDelay, String okTotalUnreadyCount, String scaleDownDelayAfterAdd, String scaleDownDelayAfterDelete, String scaleDownDelayAfterFailure, String scaleDownUnneededTime, String scaleDownUnreadyTime, String scaleDownUtilizationThreshold, String scanInterval, String skipNodesWithLocalStorage, String skipNodesWithSystemPods) {
        super();
        this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
        this.expander = expander;
        this.maxEmptyBulkDelete = maxEmptyBulkDelete;
        this.maxGracefulTerminationSec = maxGracefulTerminationSec;
        this.maxNodeProvisionTime = maxNodeProvisionTime;
        this.maxTotalUnreadyPercentage = maxTotalUnreadyPercentage;
        this.newPodScaleUpDelay = newPodScaleUpDelay;
        this.okTotalUnreadyCount = okTotalUnreadyCount;
        this.scaleDownDelayAfterAdd = scaleDownDelayAfterAdd;
        this.scaleDownDelayAfterDelete = scaleDownDelayAfterDelete;
        this.scaleDownDelayAfterFailure = scaleDownDelayAfterFailure;
        this.scaleDownUnneededTime = scaleDownUnneededTime;
        this.scaleDownUnreadyTime = scaleDownUnreadyTime;
        this.scaleDownUtilizationThreshold = scaleDownUtilizationThreshold;
        this.scanInterval = scanInterval;
        this.skipNodesWithLocalStorage = skipNodesWithLocalStorage;
        this.skipNodesWithSystemPods = skipNodesWithSystemPods;
    }

    /**
     * BalanceSimilarNodeGroups - Valid values are 'true' and 'false'. The default is false.
     */
    @JsonProperty("balanceSimilarNodeGroups")
    public String getBalanceSimilarNodeGroups() {
        return balanceSimilarNodeGroups;
    }

    /**
     * BalanceSimilarNodeGroups - Valid values are 'true' and 'false'. The default is false.
     */
    @JsonProperty("balanceSimilarNodeGroups")
    public void setBalanceSimilarNodeGroups(String balanceSimilarNodeGroups) {
        this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
    }

    /**
     * Expander - If not specified, the default is 'random'. See [expanders](https://github.com/kubernetes/autoscaler/blob/master/cluster-autoscaler/FAQ.md#what-are-expanders) for more information.
     */
    @JsonProperty("expander")
    public String getExpander() {
        return expander;
    }

    /**
     * Expander - If not specified, the default is 'random'. See [expanders](https://github.com/kubernetes/autoscaler/blob/master/cluster-autoscaler/FAQ.md#what-are-expanders) for more information.
     */
    @JsonProperty("expander")
    public void setExpander(String expander) {
        this.expander = expander;
    }

    /**
     * MaxEmptyBulkDelete - The default is 10.
     */
    @JsonProperty("maxEmptyBulkDelete")
    public String getMaxEmptyBulkDelete() {
        return maxEmptyBulkDelete;
    }

    /**
     * MaxEmptyBulkDelete - The default is 10.
     */
    @JsonProperty("maxEmptyBulkDelete")
    public void setMaxEmptyBulkDelete(String maxEmptyBulkDelete) {
        this.maxEmptyBulkDelete = maxEmptyBulkDelete;
    }

    /**
     * MaxGracefulTerminationSec - The default is 600.
     */
    @JsonProperty("maxGracefulTerminationSec")
    public String getMaxGracefulTerminationSec() {
        return maxGracefulTerminationSec;
    }

    /**
     * MaxGracefulTerminationSec - The default is 600.
     */
    @JsonProperty("maxGracefulTerminationSec")
    public void setMaxGracefulTerminationSec(String maxGracefulTerminationSec) {
        this.maxGracefulTerminationSec = maxGracefulTerminationSec;
    }

    /**
     * MaxNodeProvisionTime - The default is '15m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("maxNodeProvisionTime")
    public String getMaxNodeProvisionTime() {
        return maxNodeProvisionTime;
    }

    /**
     * MaxNodeProvisionTime - The default is '15m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("maxNodeProvisionTime")
    public void setMaxNodeProvisionTime(String maxNodeProvisionTime) {
        this.maxNodeProvisionTime = maxNodeProvisionTime;
    }

    /**
     * MaxTotalUnreadyPercentage - The default is 45. The maximum is 100 and the minimum is 0.
     */
    @JsonProperty("maxTotalUnreadyPercentage")
    public String getMaxTotalUnreadyPercentage() {
        return maxTotalUnreadyPercentage;
    }

    /**
     * MaxTotalUnreadyPercentage - The default is 45. The maximum is 100 and the minimum is 0.
     */
    @JsonProperty("maxTotalUnreadyPercentage")
    public void setMaxTotalUnreadyPercentage(String maxTotalUnreadyPercentage) {
        this.maxTotalUnreadyPercentage = maxTotalUnreadyPercentage;
    }

    /**
     * NewPodScaleUpDelay - For scenarios like burst/batch scale where you don't want CA to act before the kubernetes scheduler could schedule all the pods, you can tell CA to ignore unscheduled pods before they're a certain age. The default is '0s'. Values must be an integer followed by a unit ('s' for seconds, 'm' for minutes, 'h' for hours, etc).
     */
    @JsonProperty("newPodScaleUpDelay")
    public String getNewPodScaleUpDelay() {
        return newPodScaleUpDelay;
    }

    /**
     * NewPodScaleUpDelay - For scenarios like burst/batch scale where you don't want CA to act before the kubernetes scheduler could schedule all the pods, you can tell CA to ignore unscheduled pods before they're a certain age. The default is '0s'. Values must be an integer followed by a unit ('s' for seconds, 'm' for minutes, 'h' for hours, etc).
     */
    @JsonProperty("newPodScaleUpDelay")
    public void setNewPodScaleUpDelay(String newPodScaleUpDelay) {
        this.newPodScaleUpDelay = newPodScaleUpDelay;
    }

    /**
     * OkTotalUnreadyCount - This must be an integer. The default is 3.
     */
    @JsonProperty("okTotalUnreadyCount")
    public String getOkTotalUnreadyCount() {
        return okTotalUnreadyCount;
    }

    /**
     * OkTotalUnreadyCount - This must be an integer. The default is 3.
     */
    @JsonProperty("okTotalUnreadyCount")
    public void setOkTotalUnreadyCount(String okTotalUnreadyCount) {
        this.okTotalUnreadyCount = okTotalUnreadyCount;
    }

    /**
     * ScaleDownDelayAfterAdd - The default is '10m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("scaleDownDelayAfterAdd")
    public String getScaleDownDelayAfterAdd() {
        return scaleDownDelayAfterAdd;
    }

    /**
     * ScaleDownDelayAfterAdd - The default is '10m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("scaleDownDelayAfterAdd")
    public void setScaleDownDelayAfterAdd(String scaleDownDelayAfterAdd) {
        this.scaleDownDelayAfterAdd = scaleDownDelayAfterAdd;
    }

    /**
     * ScaleDownDelayAfterDelete - The default is the scan-interval. Values must be an integer followed by an 's'. No unit of time other than seconds (s) is supported.
     */
    @JsonProperty("scaleDownDelayAfterDelete")
    public String getScaleDownDelayAfterDelete() {
        return scaleDownDelayAfterDelete;
    }

    /**
     * ScaleDownDelayAfterDelete - The default is the scan-interval. Values must be an integer followed by an 's'. No unit of time other than seconds (s) is supported.
     */
    @JsonProperty("scaleDownDelayAfterDelete")
    public void setScaleDownDelayAfterDelete(String scaleDownDelayAfterDelete) {
        this.scaleDownDelayAfterDelete = scaleDownDelayAfterDelete;
    }

    /**
     * ScaleDownDelayAfterFailure - The default is '3m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("scaleDownDelayAfterFailure")
    public String getScaleDownDelayAfterFailure() {
        return scaleDownDelayAfterFailure;
    }

    /**
     * ScaleDownDelayAfterFailure - The default is '3m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("scaleDownDelayAfterFailure")
    public void setScaleDownDelayAfterFailure(String scaleDownDelayAfterFailure) {
        this.scaleDownDelayAfterFailure = scaleDownDelayAfterFailure;
    }

    /**
     * ScaleDownUnneededTime - The default is '10m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("scaleDownUnneededTime")
    public String getScaleDownUnneededTime() {
        return scaleDownUnneededTime;
    }

    /**
     * ScaleDownUnneededTime - The default is '10m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("scaleDownUnneededTime")
    public void setScaleDownUnneededTime(String scaleDownUnneededTime) {
        this.scaleDownUnneededTime = scaleDownUnneededTime;
    }

    /**
     * ScaleDownUnreadyTime - The default is '20m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("scaleDownUnreadyTime")
    public String getScaleDownUnreadyTime() {
        return scaleDownUnreadyTime;
    }

    /**
     * ScaleDownUnreadyTime - The default is '20m'. Values must be an integer followed by an 'm'. No unit of time other than minutes (m) is supported.
     */
    @JsonProperty("scaleDownUnreadyTime")
    public void setScaleDownUnreadyTime(String scaleDownUnreadyTime) {
        this.scaleDownUnreadyTime = scaleDownUnreadyTime;
    }

    /**
     * ScaleDownUtilizationThreshold - The default is '0.5'.
     */
    @JsonProperty("scaleDownUtilizationThreshold")
    public String getScaleDownUtilizationThreshold() {
        return scaleDownUtilizationThreshold;
    }

    /**
     * ScaleDownUtilizationThreshold - The default is '0.5'.
     */
    @JsonProperty("scaleDownUtilizationThreshold")
    public void setScaleDownUtilizationThreshold(String scaleDownUtilizationThreshold) {
        this.scaleDownUtilizationThreshold = scaleDownUtilizationThreshold;
    }

    /**
     * ScanInterval - How often cluster is reevaluated for scale up or down. The default is '10s'.
     */
    @JsonProperty("scanInterval")
    public String getScanInterval() {
        return scanInterval;
    }

    /**
     * ScanInterval - How often cluster is reevaluated for scale up or down. The default is '10s'.
     */
    @JsonProperty("scanInterval")
    public void setScanInterval(String scanInterval) {
        this.scanInterval = scanInterval;
    }

    /**
     * SkipNodesWithLocalStorage - The default is false.
     */
    @JsonProperty("skipNodesWithLocalStorage")
    public String getSkipNodesWithLocalStorage() {
        return skipNodesWithLocalStorage;
    }

    /**
     * SkipNodesWithLocalStorage - The default is false.
     */
    @JsonProperty("skipNodesWithLocalStorage")
    public void setSkipNodesWithLocalStorage(String skipNodesWithLocalStorage) {
        this.skipNodesWithLocalStorage = skipNodesWithLocalStorage;
    }

    /**
     * SkipNodesWithSystemPods - The default is true.
     */
    @JsonProperty("skipNodesWithSystemPods")
    public String getSkipNodesWithSystemPods() {
        return skipNodesWithSystemPods;
    }

    /**
     * SkipNodesWithSystemPods - The default is true.
     */
    @JsonProperty("skipNodesWithSystemPods")
    public void setSkipNodesWithSystemPods(String skipNodesWithSystemPods) {
        this.skipNodesWithSystemPods = skipNodesWithSystemPods;
    }

    @JsonIgnore
    public AutoScalerProfileBuilder edit() {
        return new AutoScalerProfileBuilder(this);
    }

    @JsonIgnore
    public AutoScalerProfileBuilder toBuilder() {
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
