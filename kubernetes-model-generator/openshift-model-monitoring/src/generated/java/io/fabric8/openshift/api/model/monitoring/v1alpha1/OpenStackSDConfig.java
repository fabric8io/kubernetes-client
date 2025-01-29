
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allTenants",
    "applicationCredentialId",
    "applicationCredentialName",
    "applicationCredentialSecret",
    "availability",
    "domainID",
    "domainName",
    "identityEndpoint",
    "password",
    "port",
    "projectID",
    "projectName",
    "refreshInterval",
    "region",
    "role",
    "tlsConfig",
    "userid",
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
public class OpenStackSDConfig implements Editable<OpenStackSDConfigBuilder>, KubernetesResource
{

    @JsonProperty("allTenants")
    private Boolean allTenants;
    @JsonProperty("applicationCredentialId")
    private String applicationCredentialId;
    @JsonProperty("applicationCredentialName")
    private String applicationCredentialName;
    @JsonProperty("applicationCredentialSecret")
    private SecretKeySelector applicationCredentialSecret;
    @JsonProperty("availability")
    private String availability;
    @JsonProperty("domainID")
    private String domainID;
    @JsonProperty("domainName")
    private String domainName;
    @JsonProperty("identityEndpoint")
    private String identityEndpoint;
    @JsonProperty("password")
    private SecretKeySelector password;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("projectName")
    private String projectName;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("region")
    private String region;
    @JsonProperty("role")
    private String role;
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonProperty("userid")
    private String userid;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OpenStackSDConfig() {
    }

    public OpenStackSDConfig(Boolean allTenants, String applicationCredentialId, String applicationCredentialName, SecretKeySelector applicationCredentialSecret, String availability, String domainID, String domainName, String identityEndpoint, SecretKeySelector password, Integer port, String projectID, String projectName, String refreshInterval, String region, String role, SafeTLSConfig tlsConfig, String userid, String username) {
        super();
        this.allTenants = allTenants;
        this.applicationCredentialId = applicationCredentialId;
        this.applicationCredentialName = applicationCredentialName;
        this.applicationCredentialSecret = applicationCredentialSecret;
        this.availability = availability;
        this.domainID = domainID;
        this.domainName = domainName;
        this.identityEndpoint = identityEndpoint;
        this.password = password;
        this.port = port;
        this.projectID = projectID;
        this.projectName = projectName;
        this.refreshInterval = refreshInterval;
        this.region = region;
        this.role = role;
        this.tlsConfig = tlsConfig;
        this.userid = userid;
        this.username = username;
    }

    @JsonProperty("allTenants")
    public Boolean getAllTenants() {
        return allTenants;
    }

    @JsonProperty("allTenants")
    public void setAllTenants(Boolean allTenants) {
        this.allTenants = allTenants;
    }

    @JsonProperty("applicationCredentialId")
    public String getApplicationCredentialId() {
        return applicationCredentialId;
    }

    @JsonProperty("applicationCredentialId")
    public void setApplicationCredentialId(String applicationCredentialId) {
        this.applicationCredentialId = applicationCredentialId;
    }

    @JsonProperty("applicationCredentialName")
    public String getApplicationCredentialName() {
        return applicationCredentialName;
    }

    @JsonProperty("applicationCredentialName")
    public void setApplicationCredentialName(String applicationCredentialName) {
        this.applicationCredentialName = applicationCredentialName;
    }

    @JsonProperty("applicationCredentialSecret")
    public SecretKeySelector getApplicationCredentialSecret() {
        return applicationCredentialSecret;
    }

    @JsonProperty("applicationCredentialSecret")
    public void setApplicationCredentialSecret(SecretKeySelector applicationCredentialSecret) {
        this.applicationCredentialSecret = applicationCredentialSecret;
    }

    @JsonProperty("availability")
    public String getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @JsonProperty("domainID")
    public String getDomainID() {
        return domainID;
    }

    @JsonProperty("domainID")
    public void setDomainID(String domainID) {
        this.domainID = domainID;
    }

    @JsonProperty("domainName")
    public String getDomainName() {
        return domainName;
    }

    @JsonProperty("domainName")
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @JsonProperty("identityEndpoint")
    public String getIdentityEndpoint() {
        return identityEndpoint;
    }

    @JsonProperty("identityEndpoint")
    public void setIdentityEndpoint(String identityEndpoint) {
        this.identityEndpoint = identityEndpoint;
    }

    @JsonProperty("password")
    public SecretKeySelector getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(SecretKeySelector password) {
        this.password = password;
    }

    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    @JsonProperty("projectName")
    public String getProjectName() {
        return projectName;
    }

    @JsonProperty("projectName")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("userid")
    public String getUserid() {
        return userid;
    }

    @JsonProperty("userid")
    public void setUserid(String userid) {
        this.userid = userid;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public OpenStackSDConfigBuilder edit() {
        return new OpenStackSDConfigBuilder(this);
    }

    @JsonIgnore
    public OpenStackSDConfigBuilder toBuilder() {
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
