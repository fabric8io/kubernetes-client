
package io.fabric8.knative.sources.v1alpha1;

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
import io.fabric8.knative.duck.v1.Destination;
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
 * CouchDbSourceSpec defines the desired state of CouchDbSource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "credentials",
    "database",
    "feed",
    "serviceAccountName",
    "sink"
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
public class CouchDbSourceSpec implements Editable<CouchDbSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("credentials")
    private ObjectReference credentials;
    @JsonProperty("database")
    private String database;
    @JsonProperty("feed")
    private String feed;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sink")
    private Destination sink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CouchDbSourceSpec() {
    }

    public CouchDbSourceSpec(ObjectReference credentials, String database, String feed, String serviceAccountName, Destination sink) {
        super();
        this.credentials = credentials;
        this.database = database;
        this.feed = feed;
        this.serviceAccountName = serviceAccountName;
        this.sink = sink;
    }

    /**
     * CouchDbSourceSpec defines the desired state of CouchDbSource
     */
    @JsonProperty("credentials")
    public ObjectReference getCredentials() {
        return credentials;
    }

    /**
     * CouchDbSourceSpec defines the desired state of CouchDbSource
     */
    @JsonProperty("credentials")
    public void setCredentials(ObjectReference credentials) {
        this.credentials = credentials;
    }

    /**
     * Database is the database to watch for changes
     */
    @JsonProperty("database")
    public String getDatabase() {
        return database;
    }

    /**
     * Database is the database to watch for changes
     */
    @JsonProperty("database")
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Feed changes how CouchDB sends the response. More information: https://docs.couchdb.org/en/stable/api/database/changes.html#changes-feeds
     */
    @JsonProperty("feed")
    public String getFeed() {
        return feed;
    }

    /**
     * Feed changes how CouchDB sends the response. More information: https://docs.couchdb.org/en/stable/api/database/changes.html#changes-feeds
     */
    @JsonProperty("feed")
    public void setFeed(String feed) {
        this.feed = feed;
    }

    /**
     * ServiceAccountName holds the name of the Kubernetes service account as which the underlying K8s resources should be run. If unspecified this will default to the "default" service account for the namespace in which the CouchDbSource exists.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName holds the name of the Kubernetes service account as which the underlying K8s resources should be run. If unspecified this will default to the "default" service account for the namespace in which the CouchDbSource exists.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * CouchDbSourceSpec defines the desired state of CouchDbSource
     */
    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    /**
     * CouchDbSourceSpec defines the desired state of CouchDbSource
     */
    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    @JsonIgnore
    public CouchDbSourceSpecBuilder edit() {
        return new CouchDbSourceSpecBuilder(this);
    }

    @JsonIgnore
    public CouchDbSourceSpecBuilder toBuilder() {
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
