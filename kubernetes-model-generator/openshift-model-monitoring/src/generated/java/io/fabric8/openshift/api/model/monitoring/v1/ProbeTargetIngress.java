
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
 * ProbeTargetIngress defines the set of Ingress objects considered for probing. The operator configures a target for each host/path combination of each ingress object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "namespaceSelector",
    "relabelingConfigs",
    "selector"
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
public class ProbeTargetIngress implements Editable<ProbeTargetIngressBuilder>, KubernetesResource
{

    @JsonProperty("namespaceSelector")
    private NamespaceSelector namespaceSelector;
    @JsonProperty("relabelingConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> relabelingConfigs = new ArrayList<>();
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProbeTargetIngress() {
    }

    public ProbeTargetIngress(NamespaceSelector namespaceSelector, List<RelabelConfig> relabelingConfigs, LabelSelector selector) {
        super();
        this.namespaceSelector = namespaceSelector;
        this.relabelingConfigs = relabelingConfigs;
        this.selector = selector;
    }

    /**
     * ProbeTargetIngress defines the set of Ingress objects considered for probing. The operator configures a target for each host/path combination of each ingress object.
     */
    @JsonProperty("namespaceSelector")
    public NamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * ProbeTargetIngress defines the set of Ingress objects considered for probing. The operator configures a target for each host/path combination of each ingress object.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(NamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * relabelingConfigs to apply to the label set of the target before it gets scraped. The original ingress address is available via the `__tmp_prometheus_ingress_address` label. It can be used to customize the probed URL. The original scrape job's name is available via the `__tmp_prometheus_job_name` label. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelingConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelingConfigs() {
        return relabelingConfigs;
    }

    /**
     * relabelingConfigs to apply to the label set of the target before it gets scraped. The original ingress address is available via the `__tmp_prometheus_ingress_address` label. It can be used to customize the probed URL. The original scrape job's name is available via the `__tmp_prometheus_job_name` label. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelingConfigs")
    public void setRelabelingConfigs(List<RelabelConfig> relabelingConfigs) {
        this.relabelingConfigs = relabelingConfigs;
    }

    /**
     * ProbeTargetIngress defines the set of Ingress objects considered for probing. The operator configures a target for each host/path combination of each ingress object.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * ProbeTargetIngress defines the set of Ingress objects considered for probing. The operator configures a target for each host/path combination of each ingress object.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public ProbeTargetIngressBuilder edit() {
        return new ProbeTargetIngressBuilder(this);
    }

    @JsonIgnore
    public ProbeTargetIngressBuilder toBuilder() {
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
        if (!(o instanceof ProbeTargetIngress)) {
            return false;
        }
        ProbeTargetIngress other = (ProbeTargetIngress) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$namespaceSelector = this.getNamespaceSelector();
        Object other$namespaceSelector = other.getNamespaceSelector();
        if (this$namespaceSelector == null ? other$namespaceSelector != null : !this$namespaceSelector.equals(other$namespaceSelector)) {
            return false;
        }
        Object this$relabelingConfigs = this.getRelabelingConfigs();
        Object other$relabelingConfigs = other.getRelabelingConfigs();
        if (this$relabelingConfigs == null ? other$relabelingConfigs != null : !this$relabelingConfigs.equals(other$relabelingConfigs)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
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
        return other instanceof ProbeTargetIngress;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $namespaceSelector = this.getNamespaceSelector();
        result = result * prime + ($namespaceSelector == null ? 43 : $namespaceSelector.hashCode());
        Object $relabelingConfigs = this.getRelabelingConfigs();
        result = result * prime + ($relabelingConfigs == null ? 43 : $relabelingConfigs.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ProbeTargetIngress(" + "namespaceSelector=" + this.getNamespaceSelector() + ", relabelingConfigs=" + this.getRelabelingConfigs() + ", selector=" + this.getSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
