
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Duration;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appliedManifestWorkEvictionGracePeriod",
    "featureGates",
    "kubeAPIBurst",
    "kubeAPIQPS"
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
public class WorkAgentConfiguration implements Editable<WorkAgentConfigurationBuilder> , KubernetesResource
{

    @JsonProperty("appliedManifestWorkEvictionGracePeriod")
    private Duration appliedManifestWorkEvictionGracePeriod;
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FeatureGate> featureGates = new ArrayList<>();
    @JsonProperty("kubeAPIBurst")
    private Integer kubeAPIBurst;
    @JsonProperty("kubeAPIQPS")
    private Integer kubeAPIQPS;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WorkAgentConfiguration() {
    }

    public WorkAgentConfiguration(Duration appliedManifestWorkEvictionGracePeriod, List<FeatureGate> featureGates, Integer kubeAPIBurst, Integer kubeAPIQPS) {
        super();
        this.appliedManifestWorkEvictionGracePeriod = appliedManifestWorkEvictionGracePeriod;
        this.featureGates = featureGates;
        this.kubeAPIBurst = kubeAPIBurst;
        this.kubeAPIQPS = kubeAPIQPS;
    }

    @JsonProperty("appliedManifestWorkEvictionGracePeriod")
    public Duration getAppliedManifestWorkEvictionGracePeriod() {
        return appliedManifestWorkEvictionGracePeriod;
    }

    @JsonProperty("appliedManifestWorkEvictionGracePeriod")
    public void setAppliedManifestWorkEvictionGracePeriod(Duration appliedManifestWorkEvictionGracePeriod) {
        this.appliedManifestWorkEvictionGracePeriod = appliedManifestWorkEvictionGracePeriod;
    }

    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FeatureGate> getFeatureGates() {
        return featureGates;
    }

    @JsonProperty("featureGates")
    public void setFeatureGates(List<FeatureGate> featureGates) {
        this.featureGates = featureGates;
    }

    @JsonProperty("kubeAPIBurst")
    public Integer getKubeAPIBurst() {
        return kubeAPIBurst;
    }

    @JsonProperty("kubeAPIBurst")
    public void setKubeAPIBurst(Integer kubeAPIBurst) {
        this.kubeAPIBurst = kubeAPIBurst;
    }

    @JsonProperty("kubeAPIQPS")
    public Integer getKubeAPIQPS() {
        return kubeAPIQPS;
    }

    @JsonProperty("kubeAPIQPS")
    public void setKubeAPIQPS(Integer kubeAPIQPS) {
        this.kubeAPIQPS = kubeAPIQPS;
    }

    @JsonIgnore
    public WorkAgentConfigurationBuilder edit() {
        return new WorkAgentConfigurationBuilder(this);
    }

    @JsonIgnore
    public WorkAgentConfigurationBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
