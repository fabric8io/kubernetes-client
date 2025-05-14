
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
 * APIServiceSpec contains information for locating and communicating with a server. Only https is supported, though you are able to disable certificate verification.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class APIServiceSpec implements Editable<APIServiceSpecBuilder>, KubernetesResource
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

    /**
     * CABundle is a PEM encoded CA bundle which will be used to validate an API server's serving certificate. If unspecified, system trust roots on the apiserver are used.
     */
    @JsonProperty("caBundle")
    public String getCaBundle() {
        return caBundle;
    }

    /**
     * CABundle is a PEM encoded CA bundle which will be used to validate an API server's serving certificate. If unspecified, system trust roots on the apiserver are used.
     */
    @JsonProperty("caBundle")
    public void setCaBundle(String caBundle) {
        this.caBundle = caBundle;
    }

    /**
     * Group is the API group name this server hosts
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * Group is the API group name this server hosts
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * GroupPriorityMinimum is the priority this group should have at least. Higher priority means that the group is preferred by clients over lower priority ones. Note that other versions of this group might specify even higher GroupPriorityMinimum values such that the whole group gets a higher priority. The primary sort is based on GroupPriorityMinimum, ordered highest number to lowest (20 before 10). The secondary sort is based on the alphabetical comparison of the name of the object.  (v1.bar before v1.foo) We'd recommend something like: &#42;.k8s.io (except extensions) at 18000 and PaaSes (OpenShift, Deis) are recommended to be in the 2000s
     */
    @JsonProperty("groupPriorityMinimum")
    public Integer getGroupPriorityMinimum() {
        return groupPriorityMinimum;
    }

    /**
     * GroupPriorityMinimum is the priority this group should have at least. Higher priority means that the group is preferred by clients over lower priority ones. Note that other versions of this group might specify even higher GroupPriorityMinimum values such that the whole group gets a higher priority. The primary sort is based on GroupPriorityMinimum, ordered highest number to lowest (20 before 10). The secondary sort is based on the alphabetical comparison of the name of the object.  (v1.bar before v1.foo) We'd recommend something like: &#42;.k8s.io (except extensions) at 18000 and PaaSes (OpenShift, Deis) are recommended to be in the 2000s
     */
    @JsonProperty("groupPriorityMinimum")
    public void setGroupPriorityMinimum(Integer groupPriorityMinimum) {
        this.groupPriorityMinimum = groupPriorityMinimum;
    }

    /**
     * InsecureSkipTLSVerify disables TLS certificate verification when communicating with this server. This is strongly discouraged.  You should use the CABundle instead.
     */
    @JsonProperty("insecureSkipTLSVerify")
    public Boolean getInsecureSkipTLSVerify() {
        return insecureSkipTLSVerify;
    }

    /**
     * InsecureSkipTLSVerify disables TLS certificate verification when communicating with this server. This is strongly discouraged.  You should use the CABundle instead.
     */
    @JsonProperty("insecureSkipTLSVerify")
    public void setInsecureSkipTLSVerify(Boolean insecureSkipTLSVerify) {
        this.insecureSkipTLSVerify = insecureSkipTLSVerify;
    }

    /**
     * APIServiceSpec contains information for locating and communicating with a server. Only https is supported, though you are able to disable certificate verification.
     */
    @JsonProperty("service")
    public ServiceReference getService() {
        return service;
    }

    /**
     * APIServiceSpec contains information for locating and communicating with a server. Only https is supported, though you are able to disable certificate verification.
     */
    @JsonProperty("service")
    public void setService(ServiceReference service) {
        this.service = service;
    }

    /**
     * Version is the API version this server hosts.  For example, "v1"
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version is the API version this server hosts.  For example, "v1"
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * VersionPriority controls the ordering of this API version inside of its group.  Must be greater than zero. The primary sort is based on VersionPriority, ordered highest to lowest (20 before 10). Since it's inside of a group, the number can be small, probably in the 10s. In case of equal version priorities, the version string will be used to compute the order inside a group. If the version string is "kube-like", it will sort above non "kube-like" version strings, which are ordered lexicographically. "Kube-like" versions start with a "v", then are followed by a number (the major version), then optionally the string "alpha" or "beta" and another number (the minor version). These are sorted first by GA &gt; beta &gt; alpha (where GA is a version with no suffix such as beta or alpha), and then by comparing major version, then minor version. An example sorted list of versions: v10, v2, v1, v11beta2, v10beta3, v3beta1, v12alpha1, v11alpha2, foo1, foo10.
     */
    @JsonProperty("versionPriority")
    public Integer getVersionPriority() {
        return versionPriority;
    }

    /**
     * VersionPriority controls the ordering of this API version inside of its group.  Must be greater than zero. The primary sort is based on VersionPriority, ordered highest to lowest (20 before 10). Since it's inside of a group, the number can be small, probably in the 10s. In case of equal version priorities, the version string will be used to compute the order inside a group. If the version string is "kube-like", it will sort above non "kube-like" version strings, which are ordered lexicographically. "Kube-like" versions start with a "v", then are followed by a number (the major version), then optionally the string "alpha" or "beta" and another number (the minor version). These are sorted first by GA &gt; beta &gt; alpha (where GA is a version with no suffix such as beta or alpha), and then by comparing major version, then minor version. An example sorted list of versions: v10, v2, v1, v11beta2, v10beta3, v3beta1, v12alpha1, v11alpha2, foo1, foo10.
     */
    @JsonProperty("versionPriority")
    public void setVersionPriority(Integer versionPriority) {
        this.versionPriority = versionPriority;
    }

    @JsonIgnore
    public APIServiceSpecBuilder edit() {
        return new APIServiceSpecBuilder(this);
    }

    @JsonIgnore
    public APIServiceSpecBuilder toBuilder() {
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
