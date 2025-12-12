
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * MachineDeploymentSpec defines the desired state of MachineDeployment.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterName",
    "machineNamingStrategy",
    "minReadySeconds",
    "paused",
    "progressDeadlineSeconds",
    "replicas",
    "revisionHistoryLimit",
    "rolloutAfter",
    "selector",
    "strategy",
    "template"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class MachineDeploymentSpec implements Editable<MachineDeploymentSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("machineNamingStrategy")
    private MachineNamingStrategy machineNamingStrategy;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("progressDeadlineSeconds")
    private Integer progressDeadlineSeconds;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("revisionHistoryLimit")
    private Integer revisionHistoryLimit;
    @JsonProperty("rolloutAfter")
    private String rolloutAfter;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("strategy")
    private MachineDeploymentStrategy strategy;
    @JsonProperty("template")
    private MachineTemplateSpec template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineDeploymentSpec() {
    }

    public MachineDeploymentSpec(String clusterName, MachineNamingStrategy machineNamingStrategy, Integer minReadySeconds, Boolean paused, Integer progressDeadlineSeconds, Integer replicas, Integer revisionHistoryLimit, String rolloutAfter, LabelSelector selector, MachineDeploymentStrategy strategy, MachineTemplateSpec template) {
        super();
        this.clusterName = clusterName;
        this.machineNamingStrategy = machineNamingStrategy;
        this.minReadySeconds = minReadySeconds;
        this.paused = paused;
        this.progressDeadlineSeconds = progressDeadlineSeconds;
        this.replicas = replicas;
        this.revisionHistoryLimit = revisionHistoryLimit;
        this.rolloutAfter = rolloutAfter;
        this.selector = selector;
        this.strategy = strategy;
        this.template = template;
    }

    /**
     * clusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * clusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("machineNamingStrategy")
    public MachineNamingStrategy getMachineNamingStrategy() {
        return machineNamingStrategy;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("machineNamingStrategy")
    public void setMachineNamingStrategy(MachineNamingStrategy machineNamingStrategy) {
        this.machineNamingStrategy = machineNamingStrategy;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a Node for a newly created machine should be ready before considering the replica available. Defaults to 0 (machine will be considered available as soon as the Node is ready)
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a Node for a newly created machine should be ready before considering the replica available. Defaults to 0 (machine will be considered available as soon as the Node is ready)
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * paused indicates that the deployment is paused.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * paused indicates that the deployment is paused.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    /**
     * progressDeadlineSeconds is the maximum time in seconds for a deployment to make progress before it is considered to be failed. The deployment controller will continue to process failed deployments and a condition with a ProgressDeadlineExceeded reason will be surfaced in the deployment status. Note that progress will not be estimated during the time a deployment is paused. Defaults to 600s.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/issues/11470 for more details.
     */
    @JsonProperty("progressDeadlineSeconds")
    public Integer getProgressDeadlineSeconds() {
        return progressDeadlineSeconds;
    }

    /**
     * progressDeadlineSeconds is the maximum time in seconds for a deployment to make progress before it is considered to be failed. The deployment controller will continue to process failed deployments and a condition with a ProgressDeadlineExceeded reason will be surfaced in the deployment status. Note that progress will not be estimated during the time a deployment is paused. Defaults to 600s.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/issues/11470 for more details.
     */
    @JsonProperty("progressDeadlineSeconds")
    public void setProgressDeadlineSeconds(Integer progressDeadlineSeconds) {
        this.progressDeadlineSeconds = progressDeadlineSeconds;
    }

    /**
     * replicas is the number of desired machines. This is a pointer to distinguish between explicit zero and not specified.<br><p> <br><p> Defaults to: &#42; if the Kubernetes autoscaler min size and max size annotations are set:<br><p>   - if it's a new MachineDeployment, use min size<br><p>   - if the replicas field of the old MachineDeployment is &lt; min size, use min size<br><p>   - if the replicas field of the old MachineDeployment is &gt; max size, use max size<br><p>   - if the replicas field of the old MachineDeployment is in the (min size, max size) range, keep the value from the oldMD<br><p> &#42; otherwise use 1 Note: Defaulting will be run whenever the replicas field is not set: &#42; A new MachineDeployment is created with replicas not set. &#42; On an existing MachineDeployment the replicas field was first set and is now unset. Those cases are especially relevant for the following Kubernetes autoscaler use cases: &#42; A new MachineDeployment is created and replicas should be managed by the autoscaler &#42; An existing MachineDeployment which initially wasn't controlled by the autoscaler<br><p>   should be later controlled by the autoscaler
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the number of desired machines. This is a pointer to distinguish between explicit zero and not specified.<br><p> <br><p> Defaults to: &#42; if the Kubernetes autoscaler min size and max size annotations are set:<br><p>   - if it's a new MachineDeployment, use min size<br><p>   - if the replicas field of the old MachineDeployment is &lt; min size, use min size<br><p>   - if the replicas field of the old MachineDeployment is &gt; max size, use max size<br><p>   - if the replicas field of the old MachineDeployment is in the (min size, max size) range, keep the value from the oldMD<br><p> &#42; otherwise use 1 Note: Defaulting will be run whenever the replicas field is not set: &#42; A new MachineDeployment is created with replicas not set. &#42; On an existing MachineDeployment the replicas field was first set and is now unset. Those cases are especially relevant for the following Kubernetes autoscaler use cases: &#42; A new MachineDeployment is created and replicas should be managed by the autoscaler &#42; An existing MachineDeployment which initially wasn't controlled by the autoscaler<br><p>   should be later controlled by the autoscaler
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * revisionHistoryLimit is the number of old MachineSets to retain to allow rollback. This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/issues/10479 for more details.
     */
    @JsonProperty("revisionHistoryLimit")
    public Integer getRevisionHistoryLimit() {
        return revisionHistoryLimit;
    }

    /**
     * revisionHistoryLimit is the number of old MachineSets to retain to allow rollback. This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/issues/10479 for more details.
     */
    @JsonProperty("revisionHistoryLimit")
    public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("rolloutAfter")
    public String getRolloutAfter() {
        return rolloutAfter;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("rolloutAfter")
    public void setRolloutAfter(String rolloutAfter) {
        this.rolloutAfter = rolloutAfter;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("strategy")
    public MachineDeploymentStrategy getStrategy() {
        return strategy;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("strategy")
    public void setStrategy(MachineDeploymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("template")
    public MachineTemplateSpec getTemplate() {
        return template;
    }

    /**
     * MachineDeploymentSpec defines the desired state of MachineDeployment.
     */
    @JsonProperty("template")
    public void setTemplate(MachineTemplateSpec template) {
        this.template = template;
    }

    @JsonIgnore
    public MachineDeploymentSpecBuilder edit() {
        return new MachineDeploymentSpecBuilder(this);
    }

    @JsonIgnore
    public MachineDeploymentSpecBuilder toBuilder() {
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
