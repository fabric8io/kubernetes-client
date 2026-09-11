
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * EvictionResponder allows you to specify the responder reacting to an Eviction. Responders should observe and communicate through the Eviction Resource API to help with the graceful eviction of a target (e.g. termination of a pod).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "priority"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EvictionResponder implements Editable<EvictionResponderBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("priority")
    private Integer priority;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EvictionResponder() {
    }

    public EvictionResponder(String name, Integer priority) {
        super();
        this.name = name;
        this.priority = priority;
    }

    /**
     * name allows you to identify the responder responding to the Eviction.<br><p> <br><p> It must be a valid domain-prefixed key (such as "acme.io/foo"). Domain names &#42;.k8s.io and &#42;.kubernetes.io are reserved. This field must be unique for each responder. This field is required.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name allows you to identify the responder responding to the Eviction.<br><p> <br><p> It must be a valid domain-prefixed key (such as "acme.io/foo"). Domain names &#42;.k8s.io and &#42;.kubernetes.io are reserved. This field must be unique for each responder. This field is required.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * priority for this responder. Higher priorities are selected first by the evictionrequest-controller. If there are responders with the same priority, the responder whose domain name comes first in the alphabetical higher domain order, will be picked. This means that the top domain labels are compared alphabetically first, followed by the lower domain labels. The key is compared last.<br><p> <br><p> The responder that is the managing controller of the pod should set the value of this field to 10000 to allow both for preemption or fallback registration by other responders.<br><p> <br><p> The minimum value is 0 and the maximum value is 100000. The interval 0-999 is reserved for responders with &#42;.k8s.io suffix. This field is required.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * priority for this responder. Higher priorities are selected first by the evictionrequest-controller. If there are responders with the same priority, the responder whose domain name comes first in the alphabetical higher domain order, will be picked. This means that the top domain labels are compared alphabetically first, followed by the lower domain labels. The key is compared last.<br><p> <br><p> The responder that is the managing controller of the pod should set the value of this field to 10000 to allow both for preemption or fallback registration by other responders.<br><p> <br><p> The minimum value is 0 and the maximum value is 100000. The interval 0-999 is reserved for responders with &#42;.k8s.io suffix. This field is required.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @JsonIgnore
    public EvictionResponderBuilder edit() {
        return new EvictionResponderBuilder(this);
    }

    @JsonIgnore
    public EvictionResponderBuilder toBuilder() {
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
