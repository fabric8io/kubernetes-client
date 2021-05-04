
package io.fabric8.kubernetes.api.model.apps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "podManagementPolicy",
    "replicas",
    "revisionHistoryLimit",
    "selector",
    "serviceName",
    "template",
    "updateStrategy",
    "volumeClaimTemplates"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.PersistentVolumeClaim.class)
})
public class StatefulSetSpec implements KubernetesResource
{

    @JsonProperty("podManagementPolicy")
    private String podManagementPolicy;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("revisionHistoryLimit")
    private Integer revisionHistoryLimit;
    @JsonProperty("selector")
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("template")
    private io.fabric8.kubernetes.api.model.PodTemplateSpec template;
    @JsonProperty("updateStrategy")
    private StatefulSetUpdateStrategy updateStrategy;
    @JsonProperty("volumeClaimTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.PersistentVolumeClaim> volumeClaimTemplates = new ArrayList<io.fabric8.kubernetes.api.model.PersistentVolumeClaim>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StatefulSetSpec() {
    }

    /**
     * 
     * @param template
     * @param podManagementPolicy
     * @param updateStrategy
     * @param replicas
     * @param revisionHistoryLimit
     * @param selector
     * @param serviceName
     * @param volumeClaimTemplates
     */
    public StatefulSetSpec(String podManagementPolicy, Integer replicas, Integer revisionHistoryLimit, io.fabric8.kubernetes.api.model.LabelSelector selector, String serviceName, io.fabric8.kubernetes.api.model.PodTemplateSpec template, StatefulSetUpdateStrategy updateStrategy, List<io.fabric8.kubernetes.api.model.PersistentVolumeClaim> volumeClaimTemplates) {
        super();
        this.podManagementPolicy = podManagementPolicy;
        this.replicas = replicas;
        this.revisionHistoryLimit = revisionHistoryLimit;
        this.selector = selector;
        this.serviceName = serviceName;
        this.template = template;
        this.updateStrategy = updateStrategy;
        this.volumeClaimTemplates = volumeClaimTemplates;
    }

    @JsonProperty("podManagementPolicy")
    public String getPodManagementPolicy() {
        return podManagementPolicy;
    }

    @JsonProperty("podManagementPolicy")
    public void setPodManagementPolicy(String podManagementPolicy) {
        this.podManagementPolicy = podManagementPolicy;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("revisionHistoryLimit")
    public Integer getRevisionHistoryLimit() {
        return revisionHistoryLimit;
    }

    @JsonProperty("revisionHistoryLimit")
    public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonProperty("template")
    public io.fabric8.kubernetes.api.model.PodTemplateSpec getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(io.fabric8.kubernetes.api.model.PodTemplateSpec template) {
        this.template = template;
    }

    @JsonProperty("updateStrategy")
    public StatefulSetUpdateStrategy getUpdateStrategy() {
        return updateStrategy;
    }

    @JsonProperty("updateStrategy")
    public void setUpdateStrategy(StatefulSetUpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    @JsonProperty("volumeClaimTemplates")
    public List<io.fabric8.kubernetes.api.model.PersistentVolumeClaim> getVolumeClaimTemplates() {
        return volumeClaimTemplates;
    }

    @JsonProperty("volumeClaimTemplates")
    public void setVolumeClaimTemplates(List<io.fabric8.kubernetes.api.model.PersistentVolumeClaim> volumeClaimTemplates) {
        this.volumeClaimTemplates = volumeClaimTemplates;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
