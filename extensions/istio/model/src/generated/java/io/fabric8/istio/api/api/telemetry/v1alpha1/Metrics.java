
package io.fabric8.istio.api.api.telemetry.v1alpha1;

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
 * Metrics defines the workload-level overrides for metrics generation behavior within a mesh. It can be used to enable/disable metrics generation, as well as to customize the dimensions of the generated metrics.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "overrides",
    "providers",
    "reportingInterval"
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
public class Metrics implements Editable<MetricsBuilder>, KubernetesResource
{

    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetricsOverrides> overrides = new ArrayList<>();
    @JsonProperty("providers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProviderRef> providers = new ArrayList<>();
    @JsonProperty("reportingInterval")
    private String reportingInterval;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metrics() {
    }

    public Metrics(List<MetricsOverrides> overrides, List<ProviderRef> providers, String reportingInterval) {
        super();
        this.overrides = overrides;
        this.providers = providers;
        this.reportingInterval = reportingInterval;
    }

    /**
     * Optional. Ordered list of overrides to metrics generation behavior.<br><p> <br><p> Specified overrides will be applied in order. They will be applied on top of inherited overrides from other resources in the hierarchy in the following order: 1. Mesh-scoped overrides 2. Namespace-scoped overrides 3. Workload-scoped overrides<br><p> <br><p> Because overrides are applied in order, users are advised to order their overrides from least specific to most specific matches. That is, it is a best practice to list any universal overrides first, with tailored overrides following them.
     */
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetricsOverrides> getOverrides() {
        return overrides;
    }

    /**
     * Optional. Ordered list of overrides to metrics generation behavior.<br><p> <br><p> Specified overrides will be applied in order. They will be applied on top of inherited overrides from other resources in the hierarchy in the following order: 1. Mesh-scoped overrides 2. Namespace-scoped overrides 3. Workload-scoped overrides<br><p> <br><p> Because overrides are applied in order, users are advised to order their overrides from least specific to most specific matches. That is, it is a best practice to list any universal overrides first, with tailored overrides following them.
     */
    @JsonProperty("overrides")
    public void setOverrides(List<MetricsOverrides> overrides) {
        this.overrides = overrides;
    }

    /**
     * Optional. Name of providers to which this configuration should apply. If a provider is not specified, the [default metrics provider](https://istio.io/docs/reference/config/istio.mesh.v1alpha1/#MeshConfig-DefaultProviders) will be used.
     */
    @JsonProperty("providers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ProviderRef> getProviders() {
        return providers;
    }

    /**
     * Optional. Name of providers to which this configuration should apply. If a provider is not specified, the [default metrics provider](https://istio.io/docs/reference/config/istio.mesh.v1alpha1/#MeshConfig-DefaultProviders) will be used.
     */
    @JsonProperty("providers")
    public void setProviders(List<ProviderRef> providers) {
        this.providers = providers;
    }

    /**
     * Metrics defines the workload-level overrides for metrics generation behavior within a mesh. It can be used to enable/disable metrics generation, as well as to customize the dimensions of the generated metrics.
     */
    @JsonProperty("reportingInterval")
    public String getReportingInterval() {
        return reportingInterval;
    }

    /**
     * Metrics defines the workload-level overrides for metrics generation behavior within a mesh. It can be used to enable/disable metrics generation, as well as to customize the dimensions of the generated metrics.
     */
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
