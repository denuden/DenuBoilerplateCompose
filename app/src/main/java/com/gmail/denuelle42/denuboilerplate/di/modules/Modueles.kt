package com.gmail.denuelle42.denuboilerplate.di.modules


/**
 *
 * The @InstallIn annotation tells Dagger which lifecycle a dependency should live within,
 * like the application, an activity, or a ViewModel. It basically decides how long a dependency will live.
 * On the other hand, adding a scope annotation, like @Singleton,
 * defines how many instances will exist during that lifecycle. So, for example,
 * @InstallIn(SingletonComponent::class) makes the dependency available for the whole app lifecycle,
 * while @Singleton ensures there's only one instance of it across that lifecycle.
 *
 *
 * installin component is saying that this dependency will live based on its lifecycle. But scoping a dependency defines how many instance will it make in the duration of its lifecycle
 */
class Modueles {
}