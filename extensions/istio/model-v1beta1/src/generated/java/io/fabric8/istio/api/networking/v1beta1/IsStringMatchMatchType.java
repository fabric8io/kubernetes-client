
package io.fabric8.istio.api.networking.v1beta1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.istio.api.networking.v1beta1.StringMatchExact;
import io.fabric8.istio.api.networking.v1beta1.StringMatchPrefix;
import io.fabric8.istio.api.networking.v1beta1.StringMatchRegex;

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
