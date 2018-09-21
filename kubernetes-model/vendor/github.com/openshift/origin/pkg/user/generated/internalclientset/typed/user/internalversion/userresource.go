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
package internalversion

import (
	user "github.com/openshift/origin/pkg/user/apis/user"
	scheme "github.com/openshift/origin/pkg/user/generated/internalclientset/scheme"
	v1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	types "k8s.io/apimachinery/pkg/types"
	watch "k8s.io/apimachinery/pkg/watch"
	rest "k8s.io/client-go/rest"
)

// UsersGetter has a method to return a UserResourceInterface.
// A group's client should implement this interface.
type UsersGetter interface {
	Users() UserResourceInterface
}

// UserResourceInterface has methods to work with UserResource resources.
type UserResourceInterface interface {
	Create(*user.User) (*user.User, error)
	Update(*user.User) (*user.User, error)
	Delete(name string, options *v1.DeleteOptions) error
	DeleteCollection(options *v1.DeleteOptions, listOptions v1.ListOptions) error
	Get(name string, options v1.GetOptions) (*user.User, error)
	List(opts v1.ListOptions) (*user.UserList, error)
	Watch(opts v1.ListOptions) (watch.Interface, error)
	Patch(name string, pt types.PatchType, data []byte, subresources ...string) (result *user.User, err error)
	UserResourceExpansion
}

// users implements UserResourceInterface
type users struct {
	client rest.Interface
}

// newUsers returns a Users
func newUsers(c *UserClient) *users {
	return &users{
		client: c.RESTClient(),
	}
}

// Get takes name of the userResource, and returns the corresponding userResource object, and an error if there is any.
func (c *users) Get(name string, options v1.GetOptions) (result *user.User, err error) {
	result = &user.User{}
	err = c.client.Get().
		Resource("users").
		Name(name).
		VersionedParams(&options, scheme.ParameterCodec).
		Do().
		Into(result)
	return
}

// List takes label and field selectors, and returns the list of Users that match those selectors.
func (c *users) List(opts v1.ListOptions) (result *user.UserList, err error) {
	result = &user.UserList{}
	err = c.client.Get().
		Resource("users").
		VersionedParams(&opts, scheme.ParameterCodec).
		Do().
		Into(result)
	return
}

// Watch returns a watch.Interface that watches the requested users.
func (c *users) Watch(opts v1.ListOptions) (watch.Interface, error) {
	opts.Watch = true
	return c.client.Get().
		Resource("users").
		VersionedParams(&opts, scheme.ParameterCodec).
		Watch()
}

// Create takes the representation of a userResource and creates it.  Returns the server's representation of the userResource, and an error, if there is any.
func (c *users) Create(userResource *user.User) (result *user.User, err error) {
	result = &user.User{}
	err = c.client.Post().
		Resource("users").
		Body(userResource).
		Do().
		Into(result)
	return
}

// Update takes the representation of a userResource and updates it. Returns the server's representation of the userResource, and an error, if there is any.
func (c *users) Update(userResource *user.User) (result *user.User, err error) {
	result = &user.User{}
	err = c.client.Put().
		Resource("users").
		Name(userResource.Name).
		Body(userResource).
		Do().
		Into(result)
	return
}

// Delete takes name of the userResource and deletes it. Returns an error if one occurs.
func (c *users) Delete(name string, options *v1.DeleteOptions) error {
	return c.client.Delete().
		Resource("users").
		Name(name).
		Body(options).
		Do().
		Error()
}

// DeleteCollection deletes a collection of objects.
func (c *users) DeleteCollection(options *v1.DeleteOptions, listOptions v1.ListOptions) error {
	return c.client.Delete().
		Resource("users").
		VersionedParams(&listOptions, scheme.ParameterCodec).
		Body(options).
		Do().
		Error()
}

// Patch applies the patch and returns the patched userResource.
func (c *users) Patch(name string, pt types.PatchType, data []byte, subresources ...string) (result *user.User, err error) {
	result = &user.User{}
	err = c.client.Patch(pt).
		Resource("users").
		SubResource(subresources...).
		Name(name).
		Body(data).
		Do().
		Into(result)
	return
}
