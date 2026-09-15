
package io.fabric8.kubernetes.api.model.apps;

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
 * A StatefulSetSpec is the specification of a StatefulSet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minReadySeconds",
    "ordinals",
    "persistentVolumeClaimRetentionPolicy",
    "podManagementPolicy",
    "replicas",
    "revisionHistoryLimit",
    "selector",
    "serviceName",
    "template",
    "updateStrategy",
    "volumeClaimTemplates"
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
public class StatefulSetSpec implements Editable<StatefulSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("ordinals")
    private StatefulSetOrdinals ordinals;
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    private StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy;
    @JsonProperty("podManagementPolicy")
    private String podManagementPolicy;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("revisionHistoryLimit")
    private Integer revisionHistoryLimit;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("template")
    private PodTemplateSpec template;
    @JsonProperty("updateStrategy")
    private StatefulSetUpdateStrategy updateStrategy;
    @JsonProperty("volumeClaimTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PersistentVolumeClaim> volumeClaimTemplates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatefulSetSpec() {
    }

    public StatefulSetSpec(Integer minReadySeconds, StatefulSetOrdinals ordinals, StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy, String podManagementPolicy, Integer replicas, Integer revisionHistoryLimit, LabelSelector selector, String serviceName, PodTemplateSpec template, StatefulSetUpdateStrategy updateStrategy, List<PersistentVolumeClaim> volumeClaimTemplates) {
        super();
        this.minReadySeconds = minReadySeconds;
        this.ordinals = ordinals;
        this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
        this.podManagementPolicy = podManagementPolicy;
        this.replicas = replicas;
        this.revisionHistoryLimit = revisionHistoryLimit;
        this.selector = selector;
        this.serviceName = serviceName;
        this.template = template;
        this.updateStrategy = updateStrategy;
        this.volumeClaimTemplates = volumeClaimTemplates;
    }

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("ordinals")
    public StatefulSetOrdinals getOrdinals() {
        return ordinals;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("ordinals")
    public void setOrdinals(StatefulSetOrdinals ordinals) {
        this.ordinals = ordinals;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    public StatefulSetPersistentVolumeClaimRetentionPolicy getPersistentVolumeClaimRetentionPolicy() {
        return persistentVolumeClaimRetentionPolicy;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("persistentVolumeClaimRetentionPolicy")
    public void setPersistentVolumeClaimRetentionPolicy(StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy) {
        this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
    }

    /**
     * podManagementPolicy controls how pods are created during initial scale up, when replacing pods on nodes, or when scaling down. The default policy is `OrderedReady`, where pods are created in increasing order (pod-0, then pod-1, etc) and the controller will wait until each pod is ready before continuing. When scaling down, the pods are removed in the opposite order. The alternative policy is `Parallel` which will create pods in parallel to match the desired scale without waiting, and on scale down will delete all pods at once.
     */
    @JsonProperty("podManagementPolicy")
    public String getPodManagementPolicy() {
        return podManagementPolicy;
    }

    /**
     * podManagementPolicy controls how pods are created during initial scale up, when replacing pods on nodes, or when scaling down. The default policy is `OrderedReady`, where pods are created in increasing order (pod-0, then pod-1, etc) and the controller will wait until each pod is ready before continuing. When scaling down, the pods are removed in the opposite order. The alternative policy is `Parallel` which will create pods in parallel to match the desired scale without waiting, and on scale down will delete all pods at once.
     */
    @JsonProperty("podManagementPolicy")
    public void setPodManagementPolicy(String podManagementPolicy) {
        this.podManagementPolicy = podManagementPolicy;
    }

    /**
     * replicas is the desired number of replicas of the given Template. These are replicas in the sense that they are instantiations of the same Template, but individual replicas also have a consistent identity. If unspecified, defaults to 1.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the desired number of replicas of the given Template. These are replicas in the sense that they are instantiations of the same Template, but individual replicas also have a consistent identity. If unspecified, defaults to 1.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * revisionHistoryLimit is the maximum number of revisions that will be maintained in the StatefulSet's revision history. The revision history consists of all revisions not represented by a currently applied StatefulSetSpec version. The default value is 10.
     */
    @JsonProperty("revisionHistoryLimit")
    public Integer getRevisionHistoryLimit() {
        return revisionHistoryLimit;
    }

    /**
     * revisionHistoryLimit is the maximum number of revisions that will be maintained in the StatefulSet's revision history. The revision history consists of all revisions not represented by a currently applied StatefulSetSpec version. The default value is 10.
     */
    @JsonProperty("revisionHistoryLimit")
    public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * serviceName is the name of the service that governs this StatefulSet. This service must exist before the StatefulSet, and is responsible for the network identity of the set. Pods get DNS/hostnames that follow the pattern: pod-specific-string.serviceName.default.svc.cluster.local where "pod-specific-string" is managed by the StatefulSet controller.
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * serviceName is the name of the service that governs this StatefulSet. This service must exist before the StatefulSet, and is responsible for the network identity of the set. Pods get DNS/hostnames that follow the pattern: pod-specific-string.serviceName.default.svc.cluster.local where "pod-specific-string" is managed by the StatefulSet controller.
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("template")
    public PodTemplateSpec getTemplate() {
        return template;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("template")
    public void setTemplate(PodTemplateSpec template) {
        this.template = template;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("updateStrategy")
    public StatefulSetUpdateStrategy getUpdateStrategy() {
        return updateStrategy;
    }

    /**
     * A StatefulSetSpec is the specification of a StatefulSet.
     */
    @JsonProperty("updateStrategy")
    public void setUpdateStrategy(StatefulSetUpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    /**
     * volumeClaimTemplates is a list of claims that pods are allowed to reference. The StatefulSet controller is responsible for mapping network identities to claims in a way that maintains the identity of a pod. Every claim in this list must have at least one matching (by name) volumeMount in one container in the template. A claim in this list takes precedence over any volumes in the template, with the same name.
     */
    @JsonProperty("volumeClaimTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PersistentVolumeClaim> getVolumeClaimTemplates() {
        return volumeClaimTemplates;
    }

    /**
     * volumeClaimTemplates is a list of claims that pods are allowed to reference. The StatefulSet controller is responsible for mapping network identities to claims in a way that maintains the identity of a pod. Every claim in this list must have at least one matching (by name) volumeMount in one container in the template. A claim in this list takes precedence over any volumes in the template, with the same name.
     */
    @JsonProperty("volumeClaimTemplates")
    public void setVolumeClaimTemplates(List<PersistentVolumeClaim> volumeClaimTemplates) {
        this.volumeClaimTemplates = volumeClaimTemplates;
    }

    @JsonIgnore
    public StatefulSetSpecBuilder edit() {
        return new StatefulSetSpecBuilder(this);
    }

    @JsonIgnore
    public StatefulSetSpecBuilder toBuilder() {
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
        if (!(o instanceof StatefulSetSpec)) {
            return false;
        }
        StatefulSetSpec other = (StatefulSetSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$minReadySeconds = this.getMinReadySeconds();
        Object other$minReadySeconds = other.getMinReadySeconds();
        if (this$minReadySeconds == null ? other$minReadySeconds != null : !this$minReadySeconds.equals(other$minReadySeconds)) {
            return false;
        }
        Object this$ordinals = this.getOrdinals();
        Object other$ordinals = other.getOrdinals();
        if (this$ordinals == null ? other$ordinals != null : !this$ordinals.equals(other$ordinals)) {
            return false;
        }
        Object this$persistentVolumeClaimRetentionPolicy = this.getPersistentVolumeClaimRetentionPolicy();
        Object other$persistentVolumeClaimRetentionPolicy = other.getPersistentVolumeClaimRetentionPolicy();
        if (this$persistentVolumeClaimRetentionPolicy == null ? other$persistentVolumeClaimRetentionPolicy != null : !this$persistentVolumeClaimRetentionPolicy.equals(other$persistentVolumeClaimRetentionPolicy)) {
            return false;
        }
        Object this$podManagementPolicy = this.getPodManagementPolicy();
        Object other$podManagementPolicy = other.getPodManagementPolicy();
        if (this$podManagementPolicy == null ? other$podManagementPolicy != null : !this$podManagementPolicy.equals(other$podManagementPolicy)) {
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
        Object this$serviceName = this.getServiceName();
        Object other$serviceName = other.getServiceName();
        if (this$serviceName == null ? other$serviceName != null : !this$serviceName.equals(other$serviceName)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
            return false;
        }
        Object this$updateStrategy = this.getUpdateStrategy();
        Object other$updateStrategy = other.getUpdateStrategy();
        if (this$updateStrategy == null ? other$updateStrategy != null : !this$updateStrategy.equals(other$updateStrategy)) {
            return false;
        }
        Object this$volumeClaimTemplates = this.getVolumeClaimTemplates();
        Object other$volumeClaimTemplates = other.getVolumeClaimTemplates();
        if (this$volumeClaimTemplates == null ? other$volumeClaimTemplates != null : !this$volumeClaimTemplates.equals(other$volumeClaimTemplates)) {
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
        return other instanceof StatefulSetSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $minReadySeconds = this.getMinReadySeconds();
        result = result * prime + ($minReadySeconds == null ? 43 : $minReadySeconds.hashCode());
        Object $ordinals = this.getOrdinals();
        result = result * prime + ($ordinals == null ? 43 : $ordinals.hashCode());
        Object $persistentVolumeClaimRetentionPolicy = this.getPersistentVolumeClaimRetentionPolicy();
        result = result * prime + ($persistentVolumeClaimRetentionPolicy == null ? 43 : $persistentVolumeClaimRetentionPolicy.hashCode());
        Object $podManagementPolicy = this.getPodManagementPolicy();
        result = result * prime + ($podManagementPolicy == null ? 43 : $podManagementPolicy.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $revisionHistoryLimit = this.getRevisionHistoryLimit();
        result = result * prime + ($revisionHistoryLimit == null ? 43 : $revisionHistoryLimit.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $serviceName = this.getServiceName();
        result = result * prime + ($serviceName == null ? 43 : $serviceName.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $updateStrategy = this.getUpdateStrategy();
        result = result * prime + ($updateStrategy == null ? 43 : $updateStrategy.hashCode());
        Object $volumeClaimTemplates = this.getVolumeClaimTemplates();
        result = result * prime + ($volumeClaimTemplates == null ? 43 : $volumeClaimTemplates.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StatefulSetSpec(" + "minReadySeconds=" + this.getMinReadySeconds() + ", ordinals=" + this.getOrdinals() + ", persistentVolumeClaimRetentionPolicy=" + this.getPersistentVolumeClaimRetentionPolicy() + ", podManagementPolicy=" + this.getPodManagementPolicy() + ", replicas=" + this.getReplicas() + ", revisionHistoryLimit=" + this.getRevisionHistoryLimit() + ", selector=" + this.getSelector() + ", serviceName=" + this.getServiceName() + ", template=" + this.getTemplate() + ", updateStrategy=" + this.getUpdateStrategy() + ", volumeClaimTemplates=" + this.getVolumeClaimTemplates() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
