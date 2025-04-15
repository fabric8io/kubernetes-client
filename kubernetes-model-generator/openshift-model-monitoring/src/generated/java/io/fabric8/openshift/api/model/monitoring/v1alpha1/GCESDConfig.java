
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.LinkedHashMap;
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
 * GCESDConfig configures scrape targets from GCP GCE instances. The private IP address is used by default, but may be changed to the public IP address with relabeling. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#gce_sd_config<br><p> <br><p> The GCE service discovery will load the Google Cloud credentials from the file specified by the GOOGLE_APPLICATION_CREDENTIALS environment variable. See https://cloud.google.com/kubernetes-engine/docs/tutorials/authenticating-to-cloud-platform<br><p> <br><p> A pre-requisite for using GCESDConfig is that a Secret containing valid Google Cloud credentials is mounted into the Prometheus or PrometheusAgent pod via the `.spec.secrets` field and that the GOOGLE_APPLICATION_CREDENTIALS environment variable is set to /etc/prometheus/secrets/&lt;secret-name&gt;/&lt;credentials-filename.json&gt;.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filter",
    "port",
    "project",
    "refreshInterval",
    "tagSeparator",
    "zone"
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
public class GCESDConfig implements Editable<GCESDConfigBuilder>, KubernetesResource
{

    @JsonProperty("filter")
    private String filter;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("project")
    private String project;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("tagSeparator")
    private String tagSeparator;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCESDConfig() {
    }

    public GCESDConfig(String filter, Integer port, String project, String refreshInterval, String tagSeparator, String zone) {
        super();
        this.filter = filter;
        this.port = port;
        this.project = project;
        this.refreshInterval = refreshInterval;
        this.tagSeparator = tagSeparator;
        this.zone = zone;
    }

    /**
     * Filter can be used optionally to filter the instance list by other criteria Syntax of this filter is described in the filter query parameter section: https://cloud.google.com/compute/docs/reference/latest/instances/list
     */
    @JsonProperty("filter")
    public String getFilter() {
        return filter;
    }

    /**
     * Filter can be used optionally to filter the instance list by other criteria Syntax of this filter is described in the filter query parameter section: https://cloud.google.com/compute/docs/reference/latest/instances/list
     */
    @JsonProperty("filter")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    /**
     * The port to scrape metrics from. If using the public IP address, this must instead be specified in the relabeling rule.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * The port to scrape metrics from. If using the public IP address, this must instead be specified in the relabeling rule.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * The Google Cloud Project ID
     */
    @JsonProperty("project")
    public String getProject() {
        return project;
    }

    /**
     * The Google Cloud Project ID
     */
    @JsonProperty("project")
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * RefreshInterval configures the refresh interval at which Prometheus will re-read the instance list.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * RefreshInterval configures the refresh interval at which Prometheus will re-read the instance list.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * The tag separator is used to separate the tags on concatenation
     */
    @JsonProperty("tagSeparator")
    public String getTagSeparator() {
        return tagSeparator;
    }

    /**
     * The tag separator is used to separate the tags on concatenation
     */
    @JsonProperty("tagSeparator")
    public void setTagSeparator(String tagSeparator) {
        this.tagSeparator = tagSeparator;
    }

    /**
     * The zone of the scrape targets. If you need multiple zones use multiple GCESDConfigs.
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * The zone of the scrape targets. If you need multiple zones use multiple GCESDConfigs.
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public GCESDConfigBuilder edit() {
        return new GCESDConfigBuilder(this);
    }

    @JsonIgnore
    public GCESDConfigBuilder toBuilder() {
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
