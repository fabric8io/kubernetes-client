
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpConfig",
    "maxConnections",
    "pageTitle",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PrometheusSpecWeb implements Editable<PrometheusSpecWebBuilder> , KubernetesResource
{

    @JsonProperty("httpConfig")
    private PrometheusSpecWHttpConfig httpConfig;
    @JsonProperty("maxConnections")
    private Integer maxConnections;
    @JsonProperty("pageTitle")
    private String pageTitle;
    @JsonProperty("tlsConfig")
    private PrometheusSpecWTlsConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusSpecWeb() {
    }

    public PrometheusSpecWeb(PrometheusSpecWHttpConfig httpConfig, Integer maxConnections, String pageTitle, PrometheusSpecWTlsConfig tlsConfig) {
        super();
        this.httpConfig = httpConfig;
        this.maxConnections = maxConnections;
        this.pageTitle = pageTitle;
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("httpConfig")
    public PrometheusSpecWHttpConfig getHttpConfig() {
        return httpConfig;
    }

    @JsonProperty("httpConfig")
    public void setHttpConfig(PrometheusSpecWHttpConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    @JsonProperty("maxConnections")
    public Integer getMaxConnections() {
        return maxConnections;
    }

    @JsonProperty("maxConnections")
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    @JsonProperty("pageTitle")
    public String getPageTitle() {
        return pageTitle;
    }

    @JsonProperty("pageTitle")
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    @JsonProperty("tlsConfig")
    public PrometheusSpecWTlsConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(PrometheusSpecWTlsConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public PrometheusSpecWebBuilder edit() {
        return new PrometheusSpecWebBuilder(this);
    }

    @JsonIgnore
    public PrometheusSpecWebBuilder toBuilder() {
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
