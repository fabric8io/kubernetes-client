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

/**
 * @param <O>   Where to write err and out to.
 * @param <PO>  Where to pipe err and out to
 * @param <PI>  Where to pipe input to
 * @param <I>   Where to read input from.
 * @param <T>   The return type.
 * @param <X>   The exec input.
 * @param <T>   The exec output.
 */
public interface TtyExecInputOutputErrorable<X, O, PO, I, PI, T> extends
        TtyExecOutputErrorable<X, O, PO, T>,
        Inputable<I, PI, TtyExecOutputErrorable<X, O, PO, T>> {

}
