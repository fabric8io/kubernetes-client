
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
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
    "caBundle",
    "group",
    "groupPriorityMinimum",
    "insecureSkipTLSVerify",
    "service",
    "version",
    "versionPriority"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class APIServiceSpec implements KubernetesResource
{

    @JsonProperty("caBundle")
    private String caBundle;
    @JsonProperty("group")
    private String group;
    @JsonProperty("groupPriorityMinimum")
    private Integer groupPriorityMinimum;
    @JsonProperty("insecureSkipTLSVerify")
    private Boolean insecureSkipTLSVerify;
    @JsonProperty("service")
    private ServiceReference service;
    @JsonProperty("version")
    private String version;
    @JsonProperty("versionPriority")
    private Integer versionPriority;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public APIServiceSpec() {
    }

    public APIServiceSpec(String caBundle, String group, Integer groupPriorityMinimum, Boolean insecureSkipTLSVerify, ServiceReference service, String version, Integer versionPriority) {
        super();
        this.caBundle = caBundle;
        this.group = group;
        this.groupPriorityMinimum = groupPriorityMinimum;
        this.insecureSkipTLSVerify = insecureSkipTLSVerify;
        this.service = service;
        this.version = version;
        this.versionPriority = versionPriority;
    }

    @JsonProperty("caBundle")
    public String getCaBundle() {
        return caBundle;
    }

    @JsonProperty("caBundle")
    public void setCaBundle(String caBundle) {
        this.caBundle = caBundle;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("groupPriorityMinimum")
    public Integer getGroupPriorityMinimum() {
        return groupPriorityMinimum;
    }

    @JsonProperty("groupPriorityMinimum")
    public void setGroupPriorityMinimum(Integer groupPriorityMinimum) {
        this.groupPriorityMinimum = groupPriorityMinimum;
    }

    @JsonProperty("insecureSkipTLSVerify")
    public Boolean getInsecureSkipTLSVerify() {
        return insecureSkipTLSVerify;
    }

    @JsonProperty("insecureSkipTLSVerify")
    public void setInsecureSkipTLSVerify(Boolean insecureSkipTLSVerify) {
        this.insecureSkipTLSVerify = insecureSkipTLSVerify;
    }

    @JsonProperty("service")
    public ServiceReference getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(ServiceReference service) {
        this.service = service;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("versionPriority")
    public Integer getVersionPriority() {
        return versionPriority;
    }

    @JsonProperty("versionPriority")
    public void setVersionPriority(Integer versionPriority) {
        this.versionPriority = versionPriority;
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
