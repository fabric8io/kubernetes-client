
package io.fabric8.openshift.api.model.hive.metricsconfig.v1;

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
    "additionalClusterDeploymentLabels",
    "metricsWithDuration"
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
public class MetricsConfig implements Editable<MetricsConfigBuilder>, KubernetesResource
{

    @JsonProperty("additionalClusterDeploymentLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> additionalClusterDeploymentLabels = new LinkedHashMap<>();
    @JsonProperty("metricsWithDuration")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetricsWithDuration> metricsWithDuration = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetricsConfig() {
    }

    public MetricsConfig(Map<String, String> additionalClusterDeploymentLabels, List<MetricsWithDuration> metricsWithDuration) {
        super();
        this.additionalClusterDeploymentLabels = additionalClusterDeploymentLabels;
        this.metricsWithDuration = metricsWithDuration;
    }

    /**
     * AdditionalClusterDeploymentLabels allows configuration of additional labels to be applied to certain metrics. The keys can be any string value suitable for a metric label (see https://prometheus.io/docs/concepts/data_model/#metric-names-and-labels). The values can be any ClusterDeployment label key (from metadata.labels). When observing an affected metric, hive will label it with the specified metric key, and copy the value from the specified ClusterDeployment label. For example, including {"ocp_major_version": "hive.openshift.io/version-major"} will cause affected metrics to include a label key ocp_major_version with the value from the hive.openshift.io/version-major ClusterDeployment label -- e.g. "4". NOTE: Avoid ClusterDeployment labels whose values are unbounded, such as those representing cluster names or IDs, as these will cause your prometheus database to grow indefinitely. Affected metrics are those whose type implements the metricsWithDynamicLabels interface found in pkg/controller/metrics/metrics_with_dynamic_labels.go
     */
    @JsonProperty("additionalClusterDeploymentLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAdditionalClusterDeploymentLabels() {
        return additionalClusterDeploymentLabels;
    }

    /**
     * AdditionalClusterDeploymentLabels allows configuration of additional labels to be applied to certain metrics. The keys can be any string value suitable for a metric label (see https://prometheus.io/docs/concepts/data_model/#metric-names-and-labels). The values can be any ClusterDeployment label key (from metadata.labels). When observing an affected metric, hive will label it with the specified metric key, and copy the value from the specified ClusterDeployment label. For example, including {"ocp_major_version": "hive.openshift.io/version-major"} will cause affected metrics to include a label key ocp_major_version with the value from the hive.openshift.io/version-major ClusterDeployment label -- e.g. "4". NOTE: Avoid ClusterDeployment labels whose values are unbounded, such as those representing cluster names or IDs, as these will cause your prometheus database to grow indefinitely. Affected metrics are those whose type implements the metricsWithDynamicLabels interface found in pkg/controller/metrics/metrics_with_dynamic_labels.go
     */
    @JsonProperty("additionalClusterDeploymentLabels")
    public void setAdditionalClusterDeploymentLabels(Map<String, String> additionalClusterDeploymentLabels) {
        this.additionalClusterDeploymentLabels = additionalClusterDeploymentLabels;
    }

    /**
     * Optional metrics and their configurations
     */
    @JsonProperty("metricsWithDuration")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetricsWithDuration> getMetricsWithDuration() {
        return metricsWithDuration;
    }

    /**
     * Optional metrics and their configurations
     */
    @JsonProperty("metricsWithDuration")
    public void setMetricsWithDuration(List<MetricsWithDuration> metricsWithDuration) {
        this.metricsWithDuration = metricsWithDuration;
    }

    @JsonIgnore
    public MetricsConfigBuilder edit() {
        return new MetricsConfigBuilder(this);
    }

    @JsonIgnore
    public MetricsConfigBuilder toBuilder() {
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
