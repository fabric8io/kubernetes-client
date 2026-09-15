
package io.fabric8.kubernetes.api.model.apps;

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

/**
 * DeploymentSpec is the specification of the desired behavior of the Deployment.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minReadySeconds",
    "paused",
    "progressDeadlineSeconds",
    "replicas",
    "revisionHistoryLimit",
    "selector",
    "strategy",
    "template"
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
public class DeploymentSpec implements Editable<DeploymentSpecBuilder>, KubernetesResource
{

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
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("strategy")
    private DeploymentStrategy strategy;
    @JsonProperty("template")
    private PodTemplateSpec template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentSpec() {
    }

    public DeploymentSpec(Integer minReadySeconds, Boolean paused, Integer progressDeadlineSeconds, Integer replicas, Integer revisionHistoryLimit, LabelSelector selector, DeploymentStrategy strategy, PodTemplateSpec template) {
        super();
        this.minReadySeconds = minReadySeconds;
        this.paused = paused;
        this.progressDeadlineSeconds = progressDeadlineSeconds;
        this.replicas = replicas;
        this.revisionHistoryLimit = revisionHistoryLimit;
        this.selector = selector;
        this.strategy = strategy;
        this.template = template;
    }

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * Indicates that the deployment is paused.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * Indicates that the deployment is paused.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    /**
     * The maximum time in seconds for a deployment to make progress before it is considered to be failed. The deployment controller will continue to process failed deployments and a condition with a ProgressDeadlineExceeded reason will be surfaced in the deployment status. Note that progress will not be estimated during the time a deployment is paused. Defaults to 600s.
     */
    @JsonProperty("progressDeadlineSeconds")
    public Integer getProgressDeadlineSeconds() {
        return progressDeadlineSeconds;
    }

    /**
     * The maximum time in seconds for a deployment to make progress before it is considered to be failed. The deployment controller will continue to process failed deployments and a condition with a ProgressDeadlineExceeded reason will be surfaced in the deployment status. Note that progress will not be estimated during the time a deployment is paused. Defaults to 600s.
     */
    @JsonProperty("progressDeadlineSeconds")
    public void setProgressDeadlineSeconds(Integer progressDeadlineSeconds) {
        this.progressDeadlineSeconds = progressDeadlineSeconds;
    }

    /**
     * Number of desired pods. This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Number of desired pods. This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * The number of old ReplicaSets to retain to allow rollback. This is a pointer to distinguish between explicit zero and not specified. Defaults to 10.
     */
    @JsonProperty("revisionHistoryLimit")
    public Integer getRevisionHistoryLimit() {
        return revisionHistoryLimit;
    }

    /**
     * The number of old ReplicaSets to retain to allow rollback. This is a pointer to distinguish between explicit zero and not specified. Defaults to 10.
     */
    @JsonProperty("revisionHistoryLimit")
    public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
    }

    /**
     * DeploymentSpec is the specification of the desired behavior of the Deployment.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * DeploymentSpec is the specification of the desired behavior of the Deployment.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * DeploymentSpec is the specification of the desired behavior of the Deployment.
     */
    @JsonProperty("strategy")
    public DeploymentStrategy getStrategy() {
        return strategy;
    }

    /**
     * DeploymentSpec is the specification of the desired behavior of the Deployment.
     */
    @JsonProperty("strategy")
    public void setStrategy(DeploymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * DeploymentSpec is the specification of the desired behavior of the Deployment.
     */
    @JsonProperty("template")
    public PodTemplateSpec getTemplate() {
        return template;
    }

    /**
     * DeploymentSpec is the specification of the desired behavior of the Deployment.
     */
    @JsonProperty("template")
    public void setTemplate(PodTemplateSpec template) {
        this.template = template;
    }

    @JsonIgnore
    public DeploymentSpecBuilder edit() {
        return new DeploymentSpecBuilder(this);
    }

    @JsonIgnore
    public DeploymentSpecBuilder toBuilder() {
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
        if (!(o instanceof DeploymentSpec)) {
            return false;
        }
        DeploymentSpec other = (DeploymentSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$minReadySeconds = this.getMinReadySeconds();
        Object other$minReadySeconds = other.getMinReadySeconds();
        if (this$minReadySeconds == null ? other$minReadySeconds != null : !this$minReadySeconds.equals(other$minReadySeconds)) {
            return false;
        }
        Object this$paused = this.getPaused();
        Object other$paused = other.getPaused();
        if (this$paused == null ? other$paused != null : !this$paused.equals(other$paused)) {
            return false;
        }
        Object this$progressDeadlineSeconds = this.getProgressDeadlineSeconds();
        Object other$progressDeadlineSeconds = other.getProgressDeadlineSeconds();
        if (this$progressDeadlineSeconds == null ? other$progressDeadlineSeconds != null : !this$progressDeadlineSeconds.equals(other$progressDeadlineSeconds)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$revisionHistoryLimit = this.getRevisionHistoryLimit();
        Object other$revisionHistoryLimit = other.getRevisionHistoryLimit();
        if (this$revisionHistoryLimit == null ? other$revisionHistoryLimit != null : !this$revisionHistoryLimit.equals(other$revisionHistoryLimit)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$strategy = this.getStrategy();
        Object other$strategy = other.getStrategy();
        if (this$strategy == null ? other$strategy != null : !this$strategy.equals(other$strategy)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
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
        return other instanceof DeploymentSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $minReadySeconds = this.getMinReadySeconds();
        result = result * prime + ($minReadySeconds == null ? 43 : $minReadySeconds.hashCode());
        Object $paused = this.getPaused();
        result = result * prime + ($paused == null ? 43 : $paused.hashCode());
        Object $progressDeadlineSeconds = this.getProgressDeadlineSeconds();
        result = result * prime + ($progressDeadlineSeconds == null ? 43 : $progressDeadlineSeconds.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $revisionHistoryLimit = this.getRevisionHistoryLimit();
        result = result * prime + ($revisionHistoryLimit == null ? 43 : $revisionHistoryLimit.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $strategy = this.getStrategy();
        result = result * prime + ($strategy == null ? 43 : $strategy.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeploymentSpec(" + "minReadySeconds=" + this.getMinReadySeconds() + ", paused=" + this.getPaused() + ", progressDeadlineSeconds=" + this.getProgressDeadlineSeconds() + ", replicas=" + this.getReplicas() + ", revisionHistoryLimit=" + this.getRevisionHistoryLimit() + ", selector=" + this.getSelector() + ", strategy=" + this.getStrategy() + ", template=" + this.getTemplate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
