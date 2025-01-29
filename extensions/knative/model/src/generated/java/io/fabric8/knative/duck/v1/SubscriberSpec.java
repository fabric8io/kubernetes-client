
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
 * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
 */
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SubscriberSpec implements Editable<SubscriberSpecBuilder>, KubernetesResource
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

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    /**
     * Generation of the origin of the subscriber with uid:UID.
     */
    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    /**
     * Generation of the origin of the subscriber with uid:UID.
     */
    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    /**
     * Name is used to identify the original subscription object.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is used to identify the original subscription object.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ReplyAudience is the OIDC audience for the replyUri.
     */
    @JsonProperty("replyAudience")
    public String getReplyAudience() {
        return replyAudience;
    }

    /**
     * ReplyAudience is the OIDC audience for the replyUri.
     */
    @JsonProperty("replyAudience")
    public void setReplyAudience(String replyAudience) {
        this.replyAudience = replyAudience;
    }

    /**
     * ReplyCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 for the replyUri.
     */
    @JsonProperty("replyCACerts")
    public String getReplyCACerts() {
        return replyCACerts;
    }

    /**
     * ReplyCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 for the replyUri.
     */
    @JsonProperty("replyCACerts")
    public void setReplyCACerts(String replyCACerts) {
        this.replyCACerts = replyCACerts;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("replyUri")
    public String getReplyUri() {
        return replyUri;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("replyUri")
    public void setReplyUri(String replyUri) {
        this.replyUri = replyUri;
    }

    /**
     * SubscriberAudience is the OIDC audience for the subscriberUri.
     */
    @JsonProperty("subscriberAudience")
    public String getSubscriberAudience() {
        return subscriberAudience;
    }

    /**
     * SubscriberAudience is the OIDC audience for the subscriberUri.
     */
    @JsonProperty("subscriberAudience")
    public void setSubscriberAudience(String subscriberAudience) {
        this.subscriberAudience = subscriberAudience;
    }

    /**
     * SubscriberCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 for the subscriberUri
     */
    @JsonProperty("subscriberCACerts")
    public String getSubscriberCACerts() {
        return subscriberCACerts;
    }

    /**
     * SubscriberCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 for the subscriberUri
     */
    @JsonProperty("subscriberCACerts")
    public void setSubscriberCACerts(String subscriberCACerts) {
        this.subscriberCACerts = subscriberCACerts;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("subscriberUri")
    public String getSubscriberUri() {
        return subscriberUri;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("subscriberUri")
    public void setSubscriberUri(String subscriberUri) {
        this.subscriberUri = subscriberUri;
    }

    /**
     * UID is used to understand the origin of the subscriber.
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * UID is used to understand the origin of the subscriber.
     */
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
