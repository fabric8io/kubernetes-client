
package io.fabric8.knative.duck.v1;

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
    "auth",
    "delivery",
    "generation",
    "name",
    "replyAudience",
    "replyCACerts",
    "replyUri",
    "subscriberAudience",
    "subscriberCACerts",
    "subscriberUri",
    "uid"
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
public class SubscriberSpec implements Editable<SubscriberSpecBuilder> , KubernetesResource
{

    @JsonProperty("auth")
    private AuthStatus auth;
    @JsonProperty("delivery")
    private DeliverySpec delivery;
    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("name")
    private String name;
    @JsonProperty("replyAudience")
    private String replyAudience;
    @JsonProperty("replyCACerts")
    private String replyCACerts;
    @JsonProperty("replyUri")
    private String replyUri;
    @JsonProperty("subscriberAudience")
    private String subscriberAudience;
    @JsonProperty("subscriberCACerts")
    private String subscriberCACerts;
    @JsonProperty("subscriberUri")
    private String subscriberUri;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriberSpec() {
    }

    public SubscriberSpec(AuthStatus auth, DeliverySpec delivery, Long generation, String name, String replyAudience, String replyCACerts, String replyUri, String subscriberAudience, String subscriberCACerts, String subscriberUri, String uid) {
        super();
        this.auth = auth;
        this.delivery = delivery;
        this.generation = generation;
        this.name = name;
        this.replyAudience = replyAudience;
        this.replyCACerts = replyCACerts;
        this.replyUri = replyUri;
        this.subscriberAudience = subscriberAudience;
        this.subscriberCACerts = subscriberCACerts;
        this.subscriberUri = subscriberUri;
        this.uid = uid;
    }

    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
    }

    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("replyAudience")
    public String getReplyAudience() {
        return replyAudience;
    }

    @JsonProperty("replyAudience")
    public void setReplyAudience(String replyAudience) {
        this.replyAudience = replyAudience;
    }

    @JsonProperty("replyCACerts")
    public String getReplyCACerts() {
        return replyCACerts;
    }

    @JsonProperty("replyCACerts")
    public void setReplyCACerts(String replyCACerts) {
        this.replyCACerts = replyCACerts;
    }

    @JsonProperty("replyUri")
    public String getReplyUri() {
        return replyUri;
    }

    @JsonProperty("replyUri")
    public void setReplyUri(String replyUri) {
        this.replyUri = replyUri;
    }

    @JsonProperty("subscriberAudience")
    public String getSubscriberAudience() {
        return subscriberAudience;
    }

    @JsonProperty("subscriberAudience")
    public void setSubscriberAudience(String subscriberAudience) {
        this.subscriberAudience = subscriberAudience;
    }

    @JsonProperty("subscriberCACerts")
    public String getSubscriberCACerts() {
        return subscriberCACerts;
    }

    @JsonProperty("subscriberCACerts")
    public void setSubscriberCACerts(String subscriberCACerts) {
        this.subscriberCACerts = subscriberCACerts;
    }

    @JsonProperty("subscriberUri")
    public String getSubscriberUri() {
        return subscriberUri;
    }

    @JsonProperty("subscriberUri")
    public void setSubscriberUri(String subscriberUri) {
        this.subscriberUri = subscriberUri;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public SubscriberSpecBuilder edit() {
        return new SubscriberSpecBuilder(this);
    }

    @JsonIgnore
    public SubscriberSpecBuilder toBuilder() {
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
