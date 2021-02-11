/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client;

import static io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A base class for implementing a custom resource kind. Implementations must be annotated with
 * {@link io.fabric8.kubernetes.model.annotation.Group} and {@link io.fabric8.kubernetes.model.annotation.Version}.
 *
 * Properties are set up automatically as follows:
 * <ul>
 *   <li>group is set using {@link HasMetadata#getGroup(Class)}</li>
 *   <li>version is set using {@link HasMetadata#getVersion(Class)}</li>
 *   <li>singular is set using {@link CustomResourceMetadata#getSingular(Class)}</li>
 *   <li>plural is set using {@link CustomResourceMetadata#getPlural(Class)}</li>
 *   <li>computed CRD name using {@link CustomResourceMetadata#getCRDName(Class)}</li>
 * </ul>
 *
 * In addition, {@link #setApiVersion(String)} is overridden to not do anything since these values
 * are set.
 *
 * @param <S> the class providing the {@code Spec} part of this CustomResource
 * @param <T> the class providing the {@code Status} part of this CustomResource
 */
@JsonDeserialize(
  using = JsonDeserializer.None.class
)
@JsonPropertyOrder({
  "apiVersion",
  "kind",
  "metadata",
  "spec",
  "status"
})
@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
public abstract class CustomResource<S, T> implements HasMetadata, CustomResourceMetadata<S, T> {

  private static final Logger LOG = LoggerFactory.getLogger(CustomResource.class);

  private ObjectMeta metadata = new ObjectMeta();

  @JsonProperty("spec")
  protected S spec;

  @JsonProperty("status")
  protected T status;

  private final String apiVersion;

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
  public CustomResource() {
    final Class<? extends CustomResourceMetadata> clazz = getClass();

    // first check if the subclass overrode the getApiVersion method
    String apiVersion = getApiVersion();
    if (isNullOrEmpty(apiVersion)) {
      // try to get the default version from group and version annotations
      apiVersion = CustomResourceMetadata.super.getApiVersion();
      if (isNullOrEmpty(apiVersion)) {
        // if we still don't have a valid apiVersion, fail
        throw new IllegalArgumentException(
          clazz.getName() + " CustomResource must provide an API version using @"
            + Group.class.getName() + " and @" + Version.class.getName() + " annotations");
      }
    }

    // now that we have an API version, get group and version
    this.apiVersion = apiVersion;
    String group = ApiVersionUtil.trimGroup(apiVersion);
    checkCoherence(clazz, group, true);
    String version = ApiVersionUtil.trimVersion(apiVersion);
    checkCoherence(clazz, version,false);

    this.spec = initSpec();
    this.status = initStatus();
  }

  private void checkCoherence(Class<? extends CustomResourceMetadata> clazz, String fromApiVersion, boolean checkGroup) {
    final String fromAnnotation =
      checkGroup ? HasMetadata.getGroup(clazz) : HasMetadata.getVersion(clazz);
    final String type = checkGroup ? "group" : "version";
    if (fromAnnotation != null && !fromApiVersion.equals(fromAnnotation)) {
      throw new IllegalArgumentException(
        clazz.getName() + " CustomResource provides inconsistent " + type
          + " information: '" + fromAnnotation + "' from annotation, '" + fromApiVersion
          + "' from apiVersion");
    }
  }


  /**
   * Override to provide your own Spec instance
   * @return a new Spec instance
   */
  protected S initSpec() {
    if (spec == null) {
      return (S) genericInit(0);
    }
    return spec;
  }

  /**
   * Override to provide your own Status instance
   * @return a new Status instance
   */
  protected T initStatus() {
    if (status == null) {
      return (T) genericInit(1);
    }
    return status;
  }

  @Override
  public String toString() {
    return "CustomResource{" +
      "kind='" + getKind() + '\'' +
      ", apiVersion='" + getApiVersion() + '\'' +
      ", metadata=" + metadata +
      ", spec=" + spec +
      ", status=" + status +
      '}';
  }

  @Override
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  public void setApiVersion(String version) {
    // already set in constructor
    LOG.debug(
      "Calling CustomResource#setApiVersion doesn't do anything because the API version is computed and shouldn't be changed");
  }

  @Override
  public ObjectMeta getMetadata() {
    return metadata;
  }

  @Override
  public void setMetadata(ObjectMeta metadata) {
    this.metadata = metadata;
  }

  public S getSpec() {
    return spec;
  }

  public void setSpec(S spec) {
    this.spec = spec;
  }

  public T getStatus() {
    return status;
  }

  public void setStatus(T status) {
    this.status = status;
  }

  private final static String TYPE_NAME = CustomResource.class.getTypeName();
  private final static String VOID_TYPE_NAME = Void.class.getTypeName();
  private final static Map<String, Instantiator> instantiators = new ConcurrentHashMap<>();

  /**
   * Encapsulates an instantiation means. Needed to provide no-op when needed.
   */
  @FunctionalInterface
  private interface Instantiator {

    Object instantiate() throws Exception;

    /**
     * No-op instantiator.
     */
    Instantiator NULL = () -> null;
  }

  /**
   * Returns the {@link Instantiator} instance associated with the type parameter associated with the specified index in the
   * generic type definition. Records the result so that it's only done once per CustomResource implementation.
   *
   * @param genericTypeIndex the index of the parameter type we want to instantiate in the CustomResource definition, i.e. with
   *                         the CustomResource<S,T> definition, {@code 0} corresponds to the {@code S} type (i.e. the Spec type)
   *                         while {@code 1} corresponds to the {@code T} (i.e. Status) type.
   * @return the {@link Instantiator} for the desired type
   * @throws Exception if the generic type cannot be identified or instantiated
   */
  private Instantiator getInstantiator(int genericTypeIndex) throws Exception {
    final String key = getKey(getClass(), genericTypeIndex);
    Instantiator instantiator = instantiators.get(key);
    if (instantiator == null) {
      instantiator = Instantiator.NULL;

      // walk the type hierarchy until we reach CustomResource or a ParameterizedType
      Type genericSuperclass = getClass().getGenericSuperclass();
      String typeName = genericSuperclass.getTypeName();
      while (!TYPE_NAME.equals(typeName) && !(genericSuperclass instanceof ParameterizedType)) {
        genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
        typeName = genericSuperclass.getTypeName();
      }

      // this works because CustomResource is an abstract class
      if (genericSuperclass instanceof ParameterizedType) {
        final Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (types.length != 2) {
          throw new IllegalArgumentException(
            "Automatic instantiation of Spec and Status only works for CustomResource implementations parameterized with both types, consider overriding initSpec and/or initStatus");
        }
        // get the associated class from the type name, if not Void
        String className = types[genericTypeIndex].getTypeName();
        if (!VOID_TYPE_NAME.equals(className)) {
          final Class<?> clazz = Thread.currentThread().getContextClassLoader()
            .loadClass(className);
          if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
            throw new IllegalArgumentException(
              "Cannot instantiate interface/abstract type " + className);
          }

          // record the instantiator associated with the identified type
          instantiator = () -> {
            final Constructor<?> constructor;
            try {
              // get the no-arg (declared needed if implicit) constructor
              constructor = clazz.getDeclaredConstructor();
              constructor.setAccessible(true); // and make it accessible
            } catch (NoSuchMethodException | SecurityException e) {
              throw new IllegalArgumentException(
                "Cannot find a no-arg constructor for " + className);
            }
            return constructor.newInstance();
          };
        }
      }
      instantiators.put(key, instantiator);
    }
    return instantiator;
  }

  private Object genericInit(int genericTypeIndex) {
    try {
      return getInstantiator(genericTypeIndex).instantiate();
    } catch (Exception e) {
      final String fieldName = genericTypeIndex == 0 ? "Spec" : "Status";
      throw new IllegalArgumentException(
        "Cannot instantiate " + fieldName + ", consider overriding init" + fieldName + ": "
          + e.getMessage(), e);
    }
  }

  private final static String getKey(Class<? extends CustomResource> clazz, int genericTypeIndex) {
    return clazz.getCanonicalName() + "_" + genericTypeIndex;
  }
}
