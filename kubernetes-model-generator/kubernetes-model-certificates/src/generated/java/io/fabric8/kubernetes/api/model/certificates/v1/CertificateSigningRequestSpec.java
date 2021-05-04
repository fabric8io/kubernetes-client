
package io.fabric8.kubernetes.api.model.certificates.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "extra",
    "groups",
    "request",
    "signerName",
    "uid",
    "usages",
    "username"
})
@ToString
@EqualsAndHashCode
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
public class CertificateSigningRequestSpec implements KubernetesResource
{

    @JsonProperty("extra")
    private Map<String, ArrayList<String>> extra;
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> groups = new ArrayList<java.lang.String>();
    @JsonProperty("request")
    private java.lang.String request;
    @JsonProperty("signerName")
    private java.lang.String signerName;
    @JsonProperty("uid")
    private java.lang.String uid;
    @JsonProperty("usages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> usages = new ArrayList<java.lang.String>();
    @JsonProperty("username")
    private java.lang.String username;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CertificateSigningRequestSpec() {
    }

    /**
     * 
     * @param request
     * @param uid
     * @param extra
     * @param groups
     * @param usages
     * @param signerName
     * @param username
     */
    public CertificateSigningRequestSpec(Map<String, ArrayList<String>> extra, List<java.lang.String> groups, java.lang.String request, java.lang.String signerName, java.lang.String uid, List<java.lang.String> usages, java.lang.String username) {
        super();
        this.extra = extra;
        this.groups = groups;
        this.request = request;
        this.signerName = signerName;
        this.uid = uid;
        this.usages = usages;
        this.username = username;
    }

    @JsonProperty("extra")
    public Map<String, ArrayList<String>> getExtra() {
        return extra;
    }

    @JsonProperty("extra")
    public void setExtra(Map<String, ArrayList<String>> extra) {
        this.extra = extra;
    }

    @JsonProperty("groups")
    public List<java.lang.String> getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(List<java.lang.String> groups) {
        this.groups = groups;
    }

    @JsonProperty("request")
    public java.lang.String getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(java.lang.String request) {
        this.request = request;
    }

    @JsonProperty("signerName")
    public java.lang.String getSignerName() {
        return signerName;
    }

    @JsonProperty("signerName")
    public void setSignerName(java.lang.String signerName) {
        this.signerName = signerName;
    }

    @JsonProperty("uid")
    public java.lang.String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    @JsonProperty("usages")
    public List<java.lang.String> getUsages() {
        return usages;
    }

    @JsonProperty("usages")
    public void setUsages(List<java.lang.String> usages) {
        this.usages = usages;
    }

    @JsonProperty("username")
    public java.lang.String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
