
package io.fabric8.istio.api.networking.v1alpha3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.istio.api.networking.v1alpha3.StringMatchExact;
import io.fabric8.istio.api.networking.v1alpha3.StringMatchPrefix;
import io.fabric8.istio.api.networking.v1alpha3.StringMatchRegex;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(StringMatchExact.class),
    @JsonSubTypes.Type(StringMatchRegex.class),
    @JsonSubTypes.Type(StringMatchPrefix.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
public interface IsStringMatchMatchType {


}
