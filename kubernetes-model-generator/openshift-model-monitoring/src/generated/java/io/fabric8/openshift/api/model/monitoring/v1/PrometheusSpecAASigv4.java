
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
    "accessKey",
    "profile",
    "region",
    "roleArn",
    "secretKey"
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
public class PrometheusSpecAASigv4 implements Editable<PrometheusSpecAASigv4Builder> , KubernetesResource
{

    @JsonProperty("accessKey")
    private PrometheusSpecAASAccessKey accessKey;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("region")
    private String region;
    @JsonProperty("roleArn")
    private String roleArn;
    @JsonProperty("secretKey")
    private PrometheusSpecAASSecretKey secretKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusSpecAASigv4() {
    }

    public PrometheusSpecAASigv4(PrometheusSpecAASAccessKey accessKey, String profile, String region, String roleArn, PrometheusSpecAASSecretKey secretKey) {
        super();
        this.accessKey = accessKey;
        this.profile = profile;
        this.region = region;
        this.roleArn = roleArn;
        this.secretKey = secretKey;
    }

    @JsonProperty("accessKey")
    public PrometheusSpecAASAccessKey getAccessKey() {
        return accessKey;
    }

    @JsonProperty("accessKey")
    public void setAccessKey(PrometheusSpecAASAccessKey accessKey) {
        this.accessKey = accessKey;
    }

    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("roleArn")
    public String getRoleArn() {
        return roleArn;
    }

    @JsonProperty("roleArn")
    public void setRoleArn(String roleArn) {
        this.roleArn = roleArn;
    }

    @JsonProperty("secretKey")
    public PrometheusSpecAASSecretKey getSecretKey() {
        return secretKey;
    }

    @JsonProperty("secretKey")
    public void setSecretKey(PrometheusSpecAASSecretKey secretKey) {
        this.secretKey = secretKey;
    }

    @JsonIgnore
    public PrometheusSpecAASigv4Builder edit() {
        return new PrometheusSpecAASigv4Builder(this);
    }

    @JsonIgnore
    public PrometheusSpecAASigv4Builder toBuilder() {
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
