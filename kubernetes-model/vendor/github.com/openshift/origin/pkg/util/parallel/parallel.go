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
package parallel

import (
	"sync"
)

// Run executes the provided functions in parallel and collects any errors they return.
func Run(fns ...func() error) []error {
	wg := sync.WaitGroup{}
	errCh := make(chan error, len(fns))
	wg.Add(len(fns))
	for i := range fns {
		go func(i int) {
			if err := fns[i](); err != nil {
				errCh <- err
			}
			wg.Done()
		}(i)
	}
	wg.Wait()
	close(errCh)
	var errs []error
	for err := range errCh {
		errs = append(errs, err)
	}
	return errs
}
