
package io.fabric8.openshift.api.model.insights.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * insightsReport provides Insights health check report based on the most recently sent Insights data.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "downloadedAt",
    "healthChecks",
    "uri"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class InsightsReport implements Editable<InsightsReportBuilder>, KubernetesResource
{

    @JsonProperty("downloadedAt")
    private String downloadedAt;
    @JsonProperty("healthChecks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HealthCheck> healthChecks = new ArrayList<>();
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InsightsReport() {
    }

    public InsightsReport(String downloadedAt, List<HealthCheck> healthChecks, String uri) {
        super();
        this.downloadedAt = downloadedAt;
        this.healthChecks = healthChecks;
        this.uri = uri;
    }

    /**
     * insightsReport provides Insights health check report based on the most recently sent Insights data.
     */
    @JsonProperty("downloadedAt")
    public String getDownloadedAt() {
        return downloadedAt;
    }

    /**
     * insightsReport provides Insights health check report based on the most recently sent Insights data.
     */
    @JsonProperty("downloadedAt")
    public void setDownloadedAt(String downloadedAt) {
        this.downloadedAt = downloadedAt;
    }

    /**
     * healthChecks provides basic information about active Insights health checks in a cluster.
     */
    @JsonProperty("healthChecks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HealthCheck> getHealthChecks() {
        return healthChecks;
    }

    /**
     * healthChecks provides basic information about active Insights health checks in a cluster.
     */
    @JsonProperty("healthChecks")
    public void setHealthChecks(List<HealthCheck> healthChecks) {
        this.healthChecks = healthChecks;
    }

    /**
     * uri is optional field that provides the URL link from which the report was downloaded. The link must be a valid HTTPS URL and the maximum length is 2048 characters.
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * uri is optional field that provides the URL link from which the report was downloaded. The link must be a valid HTTPS URL and the maximum length is 2048 characters.
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonIgnore
    public InsightsReportBuilder edit() {
        return new InsightsReportBuilder(this);
    }

    @JsonIgnore
    public InsightsReportBuilder toBuilder() {
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
