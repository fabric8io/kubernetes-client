
package io.fabric8.servicecatalog.api.model;

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
import io.fabric8.kubernetes.api.model.Duration;
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
    "authInfo",
    "caBundle",
    "catalogRestrictions",
    "insecureSkipTLSVerify",
    "relistBehavior",
    "relistDuration",
    "relistRequests",
    "url"
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
public class ServiceBrokerSpec implements KubernetesResource
{

    @JsonProperty("authInfo")
    private ServiceBrokerAuthInfo authInfo;
    @JsonProperty("caBundle")
    private String caBundle;
    @JsonProperty("catalogRestrictions")
    private CatalogRestrictions catalogRestrictions;
    @JsonProperty("insecureSkipTLSVerify")
    private Boolean insecureSkipTLSVerify;
    @JsonProperty("relistBehavior")
    private String relistBehavior;
    @JsonProperty("relistDuration")
    private Duration relistDuration;
    @JsonProperty("relistRequests")
    private Long relistRequests;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceBrokerSpec() {
    }

    /**
     * 
     * @param caBundle
     * @param catalogRestrictions
     * @param relistDuration
     * @param insecureSkipTLSVerify
     * @param relistRequests
     * @param relistBehavior
     * @param url
     * @param authInfo
     */
    public ServiceBrokerSpec(ServiceBrokerAuthInfo authInfo, String caBundle, CatalogRestrictions catalogRestrictions, Boolean insecureSkipTLSVerify, String relistBehavior, Duration relistDuration, Long relistRequests, String url) {
        super();
        this.authInfo = authInfo;
        this.caBundle = caBundle;
        this.catalogRestrictions = catalogRestrictions;
        this.insecureSkipTLSVerify = insecureSkipTLSVerify;
        this.relistBehavior = relistBehavior;
        this.relistDuration = relistDuration;
        this.relistRequests = relistRequests;
        this.url = url;
    }

    @JsonProperty("authInfo")
    public ServiceBrokerAuthInfo getAuthInfo() {
        return authInfo;
    }

    @JsonProperty("authInfo")
    public void setAuthInfo(ServiceBrokerAuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    @JsonProperty("caBundle")
    public String getCaBundle() {
        return caBundle;
    }

    @JsonProperty("caBundle")
    public void setCaBundle(String caBundle) {
        this.caBundle = caBundle;
    }

    @JsonProperty("catalogRestrictions")
    public CatalogRestrictions getCatalogRestrictions() {
        return catalogRestrictions;
    }

    @JsonProperty("catalogRestrictions")
    public void setCatalogRestrictions(CatalogRestrictions catalogRestrictions) {
        this.catalogRestrictions = catalogRestrictions;
    }

    @JsonProperty("insecureSkipTLSVerify")
    public Boolean getInsecureSkipTLSVerify() {
        return insecureSkipTLSVerify;
    }

    @JsonProperty("insecureSkipTLSVerify")
    public void setInsecureSkipTLSVerify(Boolean insecureSkipTLSVerify) {
        this.insecureSkipTLSVerify = insecureSkipTLSVerify;
    }

    @JsonProperty("relistBehavior")
    public String getRelistBehavior() {
        return relistBehavior;
    }

    @JsonProperty("relistBehavior")
    public void setRelistBehavior(String relistBehavior) {
        this.relistBehavior = relistBehavior;
    }

    @JsonProperty("relistDuration")
    public Duration getRelistDuration() {
        return relistDuration;
    }

    @JsonProperty("relistDuration")
    public void setRelistDuration(Duration relistDuration) {
        this.relistDuration = relistDuration;
    }

    @JsonProperty("relistRequests")
    public Long getRelistRequests() {
        return relistRequests;
    }

    @JsonProperty("relistRequests")
    public void setRelistRequests(Long relistRequests) {
        this.relistRequests = relistRequests;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
