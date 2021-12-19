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
package io.fabric8.kubernetes.client.dsl;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.Visitor;

public interface Editable<T> {

    /**
     * Issues a JSON patch against the item based upon the changes made to the object returned by the function.
     * 
     * <p>It is generally convenient to use a Builder constructed off of the item.
     * 
     * @param function to modify the item
     * @return returns deserialized version of api server response
     */
    T edit(UnaryOperator<T> function);

    /**
     * Issues a JSON patch against the item based upon the changes made to the object by the visitors.
     * 
     * @param visitors to modify the Builder
     * @return returns deserialized version of api server response
     */
    T edit(Visitor... visitors);

    /**
     * Issues a JSON patch against the item based upon the changes made to the object by the visitor.
     * 
     * @param visitorType to create a {@link TypedVisitor}
     * @param visitor to modify the Builder
     * @return returns deserialized version of api server response
     */
    <V> T edit(Class<V> visitorType, Visitor<V> visitor);

    /**
     * Issues a JSON patch against the item based upon the changes made by the function provided as argument  
     * 
     * @param function to modify the item
     * @return returns deserialized version of api server response
     */
    T accept(Consumer<T> function);
}
