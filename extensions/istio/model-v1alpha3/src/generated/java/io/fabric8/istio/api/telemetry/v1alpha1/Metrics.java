
package io.fabric8.istio.api.telemetry.v1alpha1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "overrides",
    "providers",
    "reportingInterval"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class Metrics implements Editable<MetricsBuilder> , KubernetesResource
{

    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetricsOverrides> overrides = new ArrayList<MetricsOverrides>();
    @JsonProperty("providers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProviderRef> providers = new ArrayList<ProviderRef>();
    @JsonProperty("reportingInterval")
    private String reportingInterval;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metrics() {
    }

    public Metrics(List<MetricsOverrides> overrides, List<ProviderRef> providers, String reportingInterval) {
        super();
        this.overrides = overrides;
        this.providers = providers;
        this.reportingInterval = reportingInterval;
    }

    @JsonProperty("overrides")
    public List<MetricsOverrides> getOverrides() {
        return overrides;
    }

    @JsonProperty("overrides")
    public void setOverrides(List<MetricsOverrides> overrides) {
        this.overrides = overrides;
    }

    @JsonProperty("providers")
    public List<ProviderRef> getProviders() {
        return providers;
    }

    @JsonProperty("providers")
    public void setProviders(List<ProviderRef> providers) {
        this.providers = providers;
    }

    @JsonProperty("reportingInterval")
    public String getReportingInterval() {
        return reportingInterval;
    }

    @JsonProperty("reportingInterval")
    public void setReportingInterval(String reportingInterval) {
        this.reportingInterval = reportingInterval;
    }

    @JsonIgnore
    public MetricsBuilder edit() {
        return new MetricsBuilder(this);
    }

    @JsonIgnore
    public MetricsBuilder toBuilder() {
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

}
