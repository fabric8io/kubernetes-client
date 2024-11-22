
package io.fabric8.istio.api.api.networking.v1alpha3;

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
    "filterChain",
    "listenerFilter",
    "name",
    "portName",
    "portNumber"
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
public class EnvoyFilterListenerMatch implements Editable<EnvoyFilterListenerMatchBuilder> , KubernetesResource
{

    @JsonProperty("filterChain")
    private EnvoyFilterListenerMatchFilterChainMatch filterChain;
    @JsonProperty("listenerFilter")
    private String listenerFilter;
    @JsonProperty("name")
    private String name;
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("portNumber")
    private Long portNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnvoyFilterListenerMatch() {
    }

    public EnvoyFilterListenerMatch(EnvoyFilterListenerMatchFilterChainMatch filterChain, String listenerFilter, String name, String portName, Long portNumber) {
        super();
        this.filterChain = filterChain;
        this.listenerFilter = listenerFilter;
        this.name = name;
        this.portName = portName;
        this.portNumber = portNumber;
    }

    @JsonProperty("filterChain")
    public EnvoyFilterListenerMatchFilterChainMatch getFilterChain() {
        return filterChain;
    }

    @JsonProperty("filterChain")
    public void setFilterChain(EnvoyFilterListenerMatchFilterChainMatch filterChain) {
        this.filterChain = filterChain;
    }

    @JsonProperty("listenerFilter")
    public String getListenerFilter() {
        return listenerFilter;
    }

    @JsonProperty("listenerFilter")
    public void setListenerFilter(String listenerFilter) {
        this.listenerFilter = listenerFilter;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("portName")
    public String getPortName() {
        return portName;
    }

    @JsonProperty("portName")
    public void setPortName(String portName) {
        this.portName = portName;
    }

    @JsonProperty("portNumber")
    public Long getPortNumber() {
        return portNumber;
    }

    @JsonProperty("portNumber")
    public void setPortNumber(Long portNumber) {
        this.portNumber = portNumber;
    }

    @JsonIgnore
    public EnvoyFilterListenerMatchBuilder edit() {
        return new EnvoyFilterListenerMatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterListenerMatchBuilder toBuilder() {
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
