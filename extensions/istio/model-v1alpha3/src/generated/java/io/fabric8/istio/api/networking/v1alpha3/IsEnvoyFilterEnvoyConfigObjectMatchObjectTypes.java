
package io.fabric8.istio.api.networking.v1alpha3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchCluster;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchListener;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(EnvoyFilterEnvoyConfigObjectMatchListener.class),
    @JsonSubTypes.Type(EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration.class),
    @JsonSubTypes.Type(EnvoyFilterEnvoyConfigObjectMatchCluster.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
public interface IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes {


}
