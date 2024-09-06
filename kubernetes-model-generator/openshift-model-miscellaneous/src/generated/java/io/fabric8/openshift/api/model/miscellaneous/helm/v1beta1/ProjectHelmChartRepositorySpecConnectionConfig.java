
package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

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
    "basicAuthConfig",
    "ca",
    "tlsClientConfig",
    "url"
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
public class ProjectHelmChartRepositorySpecConnectionConfig implements Editable<ProjectHelmChartRepositorySpecConnectionConfigBuilder> , KubernetesResource
{

    @JsonProperty("basicAuthConfig")
    private ProjectHelmChartRepositorySpecCCBasicAuthConfig basicAuthConfig;
    @JsonProperty("ca")
    private ProjectHelmChartRepositorySpecCCCa ca;
    @JsonProperty("tlsClientConfig")
    private ProjectHelmChartRepositorySpecCCTlsClientConfig tlsClientConfig;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProjectHelmChartRepositorySpecConnectionConfig() {
    }

    public ProjectHelmChartRepositorySpecConnectionConfig(ProjectHelmChartRepositorySpecCCBasicAuthConfig basicAuthConfig, ProjectHelmChartRepositorySpecCCCa ca, ProjectHelmChartRepositorySpecCCTlsClientConfig tlsClientConfig, String url) {
        super();
        this.basicAuthConfig = basicAuthConfig;
        this.ca = ca;
        this.tlsClientConfig = tlsClientConfig;
        this.url = url;
    }

    @JsonProperty("basicAuthConfig")
    public ProjectHelmChartRepositorySpecCCBasicAuthConfig getBasicAuthConfig() {
        return basicAuthConfig;
    }

    @JsonProperty("basicAuthConfig")
    public void setBasicAuthConfig(ProjectHelmChartRepositorySpecCCBasicAuthConfig basicAuthConfig) {
        this.basicAuthConfig = basicAuthConfig;
    }

    @JsonProperty("ca")
    public ProjectHelmChartRepositorySpecCCCa getCa() {
        return ca;
    }

    @JsonProperty("ca")
    public void setCa(ProjectHelmChartRepositorySpecCCCa ca) {
        this.ca = ca;
    }

    @JsonProperty("tlsClientConfig")
    public ProjectHelmChartRepositorySpecCCTlsClientConfig getTlsClientConfig() {
        return tlsClientConfig;
    }

    @JsonProperty("tlsClientConfig")
    public void setTlsClientConfig(ProjectHelmChartRepositorySpecCCTlsClientConfig tlsClientConfig) {
        this.tlsClientConfig = tlsClientConfig;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public ProjectHelmChartRepositorySpecConnectionConfigBuilder edit() {
        return new ProjectHelmChartRepositorySpecConnectionConfigBuilder(this);
    }

    @JsonIgnore
    public ProjectHelmChartRepositorySpecConnectionConfigBuilder toBuilder() {
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
