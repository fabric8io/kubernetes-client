
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "ingress"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class LoadBalancerStatus implements KubernetesResource
{

    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LoadBalancerIngress> ingress = new ArrayList<LoadBalancerIngress>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoadBalancerStatus() {
    }

    /**
     * 
     * @param ingress
     */
    public LoadBalancerStatus(List<LoadBalancerIngress> ingress) {
        super();
        this.ingress = ingress;
    }

    @JsonProperty("ingress")
    public List<LoadBalancerIngress> getIngress() {
        return ingress;
    }

    @JsonProperty("ingress")
    public void setIngress(List<LoadBalancerIngress> ingress) {
        this.ingress = ingress;
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
