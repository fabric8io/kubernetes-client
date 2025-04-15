
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
    "attachMetadata",
    "authorization",
    "default",
    "metricRelabelings",
    "name",
    "relabelings",
    "tlsConfig"
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
public class ScrapeClass implements Editable<ScrapeClassBuilder>, KubernetesResource
{

    @JsonProperty("attachMetadata")
    private AttachMetadata attachMetadata;
    @JsonProperty("authorization")
    private Authorization authorization;
    @JsonProperty("default")
    private Boolean _default;
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> metricRelabelings = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> relabelings = new ArrayList<>();
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScrapeClass() {
    }

    public ScrapeClass(AttachMetadata attachMetadata, Authorization authorization, Boolean _default, List<RelabelConfig> metricRelabelings, String name, List<RelabelConfig> relabelings, TLSConfig tlsConfig) {
        super();
        this.attachMetadata = attachMetadata;
        this.authorization = authorization;
        this._default = _default;
        this.metricRelabelings = metricRelabelings;
        this.name = name;
        this.relabelings = relabelings;
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("attachMetadata")
    public AttachMetadata getAttachMetadata() {
        return attachMetadata;
    }

    @JsonProperty("attachMetadata")
    public void setAttachMetadata(AttachMetadata attachMetadata) {
        this.attachMetadata = attachMetadata;
    }

    @JsonProperty("authorization")
    public Authorization getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    /**
     * Default indicates that the scrape applies to all scrape objects that don't configure an explicit scrape class name.<br><p> <br><p> Only one scrape class can be set as the default.
     */
    @JsonProperty("default")
    public Boolean getDefault() {
        return _default;
    }

    /**
     * Default indicates that the scrape applies to all scrape objects that don't configure an explicit scrape class name.<br><p> <br><p> Only one scrape class can be set as the default.
     */
    @JsonProperty("default")
    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    /**
     * MetricRelabelings configures the relabeling rules to apply to all samples before ingestion.<br><p> <br><p> The Operator adds the scrape class metric relabelings defined here. Then the Operator adds the target-specific metric relabelings defined in ServiceMonitors, PodMonitors, Probes and ScrapeConfigs. Then the Operator adds namespace enforcement relabeling rule, specified in '.spec.enforcedNamespaceLabel'.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#metric_relabel_configs
     */
    @JsonProperty("metricRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getMetricRelabelings() {
        return metricRelabelings;
    }

    /**
     * MetricRelabelings configures the relabeling rules to apply to all samples before ingestion.<br><p> <br><p> The Operator adds the scrape class metric relabelings defined here. Then the Operator adds the target-specific metric relabelings defined in ServiceMonitors, PodMonitors, Probes and ScrapeConfigs. Then the Operator adds namespace enforcement relabeling rule, specified in '.spec.enforcedNamespaceLabel'.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#metric_relabel_configs
     */
    @JsonProperty("metricRelabelings")
    public void setMetricRelabelings(List<RelabelConfig> metricRelabelings) {
        this.metricRelabelings = metricRelabelings;
    }

    /**
     * Name of the scrape class.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the scrape class.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Relabelings configures the relabeling rules to apply to all scrape targets.<br><p> <br><p> The Operator automatically adds relabelings for a few standard Kubernetes fields like `__meta_kubernetes_namespace` and `__meta_kubernetes_service_name`. Then the Operator adds the scrape class relabelings defined here. Then the Operator adds the target-specific relabelings defined in the scrape object.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    /**
     * Relabelings configures the relabeling rules to apply to all scrape targets.<br><p> <br><p> The Operator automatically adds relabelings for a few standard Kubernetes fields like `__meta_kubernetes_namespace` and `__meta_kubernetes_service_name`. Then the Operator adds the scrape class relabelings defined here. Then the Operator adds the target-specific relabelings defined in the scrape object.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
     */
    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public ScrapeClassBuilder edit() {
        return new ScrapeClassBuilder(this);
    }

    @JsonIgnore
    public ScrapeClassBuilder toBuilder() {
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
