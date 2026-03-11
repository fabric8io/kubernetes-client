
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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

/**
 * OpenStackSDConfig allow retrieving scrape targets from OpenStack Nova instances. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#openstack_sd_config
 */
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

    /**
     * allTenants defines whether the service discovery should list all instances for all projects. It is only relevant for the 'instance' role and usually requires admin permissions.
     */
    @JsonProperty("allTenants")
    public Boolean getAllTenants() {
        return allTenants;
    }

    /**
     * allTenants defines whether the service discovery should list all instances for all projects. It is only relevant for the 'instance' role and usually requires admin permissions.
     */
    @JsonProperty("allTenants")
    public void setAllTenants(Boolean allTenants) {
        this.allTenants = allTenants;
    }

    /**
     * applicationCredentialId defines the OpenStack applicationCredentialId.
     */
    @JsonProperty("applicationCredentialId")
    public String getApplicationCredentialId() {
        return applicationCredentialId;
    }

    /**
     * applicationCredentialId defines the OpenStack applicationCredentialId.
     */
    @JsonProperty("applicationCredentialId")
    public void setApplicationCredentialId(String applicationCredentialId) {
        this.applicationCredentialId = applicationCredentialId;
    }

    /**
     * applicationCredentialName defines the ApplicationCredentialID or ApplicationCredentialName fields are required if using an application credential to authenticate. Some providers allow you to create an application credential to authenticate rather than a password.
     */
    @JsonProperty("applicationCredentialName")
    public String getApplicationCredentialName() {
        return applicationCredentialName;
    }

    /**
     * applicationCredentialName defines the ApplicationCredentialID or ApplicationCredentialName fields are required if using an application credential to authenticate. Some providers allow you to create an application credential to authenticate rather than a password.
     */
    @JsonProperty("applicationCredentialName")
    public void setApplicationCredentialName(String applicationCredentialName) {
        this.applicationCredentialName = applicationCredentialName;
    }

    /**
     * OpenStackSDConfig allow retrieving scrape targets from OpenStack Nova instances. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#openstack_sd_config
     */
    @JsonProperty("applicationCredentialSecret")
    public SecretKeySelector getApplicationCredentialSecret() {
        return applicationCredentialSecret;
    }

    /**
     * OpenStackSDConfig allow retrieving scrape targets from OpenStack Nova instances. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#openstack_sd_config
     */
    @JsonProperty("applicationCredentialSecret")
    public void setApplicationCredentialSecret(SecretKeySelector applicationCredentialSecret) {
        this.applicationCredentialSecret = applicationCredentialSecret;
    }

    /**
     * availability defines the availability of the endpoint to connect to.
     */
    @JsonProperty("availability")
    public String getAvailability() {
        return availability;
    }

    /**
     * availability defines the availability of the endpoint to connect to.
     */
    @JsonProperty("availability")
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * domainID defines The OpenStack domainID.
     */
    @JsonProperty("domainID")
    public String getDomainID() {
        return domainID;
    }

    /**
     * domainID defines The OpenStack domainID.
     */
    @JsonProperty("domainID")
    public void setDomainID(String domainID) {
        this.domainID = domainID;
    }

    /**
     * domainName defines at most one of domainId and domainName that must be provided if using username with Identity V3. Otherwise, either are optional.
     */
    @JsonProperty("domainName")
    public String getDomainName() {
        return domainName;
    }

    /**
     * domainName defines at most one of domainId and domainName that must be provided if using username with Identity V3. Otherwise, either are optional.
     */
    @JsonProperty("domainName")
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * identityEndpoint defines the HTTP endpoint that is required to work with the Identity API of the appropriate version.
     */
    @JsonProperty("identityEndpoint")
    public String getIdentityEndpoint() {
        return identityEndpoint;
    }

    /**
     * identityEndpoint defines the HTTP endpoint that is required to work with the Identity API of the appropriate version.
     */
    @JsonProperty("identityEndpoint")
    public void setIdentityEndpoint(String identityEndpoint) {
        this.identityEndpoint = identityEndpoint;
    }

    /**
     * OpenStackSDConfig allow retrieving scrape targets from OpenStack Nova instances. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#openstack_sd_config
     */
    @JsonProperty("password")
    public SecretKeySelector getPassword() {
        return password;
    }

    /**
     * OpenStackSDConfig allow retrieving scrape targets from OpenStack Nova instances. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#openstack_sd_config
     */
    @JsonProperty("password")
    public void setPassword(SecretKeySelector password) {
        this.password = password;
    }

    /**
     * port defines the port to scrape metrics from. If using the public IP address, this must instead be specified in the relabeling rule.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * port defines the port to scrape metrics from. If using the public IP address, this must instead be specified in the relabeling rule.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * projectID defines the OpenStack projectID.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * projectID defines the OpenStack projectID.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * projectName defines an optional field for the Identity V2 API. Some providers allow you to specify a ProjectName instead of the ProjectId. Some require both. Your provider's authentication policies will determine how these fields influence authentication.
     */
    @JsonProperty("projectName")
    public String getProjectName() {
        return projectName;
    }

    /**
     * projectName defines an optional field for the Identity V2 API. Some providers allow you to specify a ProjectName instead of the ProjectId. Some require both. Your provider's authentication policies will determine how these fields influence authentication.
     */
    @JsonProperty("projectName")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * refreshInterval defines the time after which the provided names are refreshed. If not set, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * refreshInterval defines the time after which the provided names are refreshed. If not set, Prometheus uses its default value.
     */
    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /**
     * region defines the OpenStack Region.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region defines the OpenStack Region.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * role defines the OpenStack role of entities that should be discovered.<br><p> <br><p> Note: The `LoadBalancer` role requires Prometheus &gt;= v3.2.0.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * role defines the OpenStack role of entities that should be discovered.<br><p> <br><p> Note: The `LoadBalancer` role requires Prometheus &gt;= v3.2.0.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * OpenStackSDConfig allow retrieving scrape targets from OpenStack Nova instances. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#openstack_sd_config
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * OpenStackSDConfig allow retrieving scrape targets from OpenStack Nova instances. See https://prometheus.io/docs/prometheus/latest/configuration/configuration/#openstack_sd_config
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * userid defines the OpenStack userid.
     */
    @JsonProperty("userid")
    public String getUserid() {
        return userid;
    }

    /**
     * userid defines the OpenStack userid.
     */
    @JsonProperty("userid")
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * username defines the username required if using Identity V2 API. Consult with your provider's control panel to discover your account's username. In Identity V3, either userid or a combination of username and domainId or domainName are needed
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * username defines the username required if using Identity V2 API. Consult with your provider's control panel to discover your account's username. In Identity V3, either userid or a combination of username and domainId or domainName are needed
     */
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
