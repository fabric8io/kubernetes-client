
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ProbeTargetStaticConfig defines the set of static targets considered for probing.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labels",
    "relabelingConfigs",
    "static"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ProbeTargetStaticConfig implements Editable<ProbeTargetStaticConfigBuilder>, KubernetesResource
{

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("relabelingConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> relabelingConfigs = new ArrayList<>();
    @JsonProperty("static")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> _static = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProbeTargetStaticConfig() {
    }

    public ProbeTargetStaticConfig(Map<String, String> labels, List<RelabelConfig> relabelingConfigs, List<String> _static) {
        super();
        this.labels = labels;
        this.relabelingConfigs = relabelingConfigs;
        this._static = _static;
    }

    /**
     * labels defines all labels assigned to all metrics scraped from the targets.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * labels defines all labels assigned to all metrics scraped from the targets.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * relabelingConfigs defines relabelings to be apply to the label set of the targets before it gets scraped. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelingConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelingConfigs() {
        return relabelingConfigs;
    }

    /**
     * relabelingConfigs defines relabelings to be apply to the label set of the targets before it gets scraped. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelingConfigs")
    public void setRelabelingConfigs(List<RelabelConfig> relabelingConfigs) {
        this.relabelingConfigs = relabelingConfigs;
    }

    /**
     * static defines the list of hosts to probe.
     */
    @JsonProperty("static")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getStatic() {
        return _static;
    }

    /**
     * static defines the list of hosts to probe.
     */
    @JsonProperty("static")
    public void setStatic(List<String> _static) {
        this._static = _static;
    }

    @JsonIgnore
    public ProbeTargetStaticConfigBuilder edit() {
        return new ProbeTargetStaticConfigBuilder(this);
    }

    @JsonIgnore
    public ProbeTargetStaticConfigBuilder toBuilder() {
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
        if (!(o instanceof ProbeTargetStaticConfig)) {
            return false;
        }
        ProbeTargetStaticConfig other = (ProbeTargetStaticConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$labels = this.getLabels();
        Object other$labels = other.getLabels();
        if (this$labels == null ? other$labels != null : !this$labels.equals(other$labels)) {
            return false;
        }
        Object this$relabelingConfigs = this.getRelabelingConfigs();
        Object other$relabelingConfigs = other.getRelabelingConfigs();
        if (this$relabelingConfigs == null ? other$relabelingConfigs != null : !this$relabelingConfigs.equals(other$relabelingConfigs)) {
            return false;
        }
        Object this$_static = this.getStatic();
        Object other$_static = other.getStatic();
        if (this$_static == null ? other$_static != null : !this$_static.equals(other$_static)) {
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
        return other instanceof ProbeTargetStaticConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $labels = this.getLabels();
        result = result * prime + ($labels == null ? 43 : $labels.hashCode());
        Object $relabelingConfigs = this.getRelabelingConfigs();
        result = result * prime + ($relabelingConfigs == null ? 43 : $relabelingConfigs.hashCode());
        Object $_static = this.getStatic();
        result = result * prime + ($_static == null ? 43 : $_static.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ProbeTargetStaticConfig(" + "labels=" + this.getLabels() + ", relabelingConfigs=" + this.getRelabelingConfigs() + ", _static=" + this.getStatic() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
