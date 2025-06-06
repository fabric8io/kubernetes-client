
package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

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

/**
 * PerUserAPIRequestCount contains logs of a user's requests.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "byVerb",
    "requestCount",
    "userAgent",
    "username"
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
public class PerUserAPIRequestCount implements Editable<PerUserAPIRequestCountBuilder>, KubernetesResource
{

    @JsonProperty("byVerb")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PerVerbAPIRequestCount> byVerb = new ArrayList<>();
    @JsonProperty("requestCount")
    private Long requestCount;
    @JsonProperty("userAgent")
    private String userAgent;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PerUserAPIRequestCount() {
    }

    public PerUserAPIRequestCount(List<PerVerbAPIRequestCount> byVerb, Long requestCount, String userAgent, String username) {
        super();
        this.byVerb = byVerb;
        this.requestCount = requestCount;
        this.userAgent = userAgent;
        this.username = username;
    }

    /**
     * byVerb details by verb.
     */
    @JsonProperty("byVerb")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PerVerbAPIRequestCount> getByVerb() {
        return byVerb;
    }

    /**
     * byVerb details by verb.
     */
    @JsonProperty("byVerb")
    public void setByVerb(List<PerVerbAPIRequestCount> byVerb) {
        this.byVerb = byVerb;
    }

    /**
     * requestCount of requests by the user across all verbs.
     */
    @JsonProperty("requestCount")
    public Long getRequestCount() {
        return requestCount;
    }

    /**
     * requestCount of requests by the user across all verbs.
     */
    @JsonProperty("requestCount")
    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    /**
     * userAgent that made the request. The same user often has multiple binaries which connect (pods with many containers).  The different binaries will have different userAgents, but the same user.  In addition, we have userAgents with version information embedded and the userName isn't likely to change.
     */
    @JsonProperty("userAgent")
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * userAgent that made the request. The same user often has multiple binaries which connect (pods with many containers).  The different binaries will have different userAgents, but the same user.  In addition, we have userAgents with version information embedded and the userName isn't likely to change.
     */
    @JsonProperty("userAgent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * userName that made the request.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * userName that made the request.
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public PerUserAPIRequestCountBuilder edit() {
        return new PerUserAPIRequestCountBuilder(this);
    }

    @JsonIgnore
    public PerUserAPIRequestCountBuilder toBuilder() {
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
