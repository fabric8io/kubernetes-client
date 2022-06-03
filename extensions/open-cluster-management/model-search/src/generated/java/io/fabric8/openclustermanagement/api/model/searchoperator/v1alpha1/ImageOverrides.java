
package io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    "redisgraph_tls",
    "search_aggregator",
    "search_api",
    "search_collector"
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
public class ImageOverrides implements KubernetesResource
{

    @JsonProperty("redisgraph_tls")
    private String redisgraphTls;
    @JsonProperty("search_aggregator")
    private String searchAggregator;
    @JsonProperty("search_api")
    private String searchApi;
    @JsonProperty("search_collector")
    private String searchCollector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageOverrides() {
    }

    /**
     * 
     * @param searchAggregator
     * @param redisgraphTls
     * @param searchCollector
     * @param searchApi
     */
    public ImageOverrides(String redisgraphTls, String searchAggregator, String searchApi, String searchCollector) {
        super();
        this.redisgraphTls = redisgraphTls;
        this.searchAggregator = searchAggregator;
        this.searchApi = searchApi;
        this.searchCollector = searchCollector;
    }

    @JsonProperty("redisgraph_tls")
    public String getRedisgraphTls() {
        return redisgraphTls;
    }

    @JsonProperty("redisgraph_tls")
    public void setRedisgraphTls(String redisgraphTls) {
        this.redisgraphTls = redisgraphTls;
    }

    @JsonProperty("search_aggregator")
    public String getSearchAggregator() {
        return searchAggregator;
    }

    @JsonProperty("search_aggregator")
    public void setSearchAggregator(String searchAggregator) {
        this.searchAggregator = searchAggregator;
    }

    @JsonProperty("search_api")
    public String getSearchApi() {
        return searchApi;
    }

    @JsonProperty("search_api")
    public void setSearchApi(String searchApi) {
        this.searchApi = searchApi;
    }

    @JsonProperty("search_collector")
    public String getSearchCollector() {
        return searchCollector;
    }

    @JsonProperty("search_collector")
    public void setSearchCollector(String searchCollector) {
        this.searchCollector = searchCollector;
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
