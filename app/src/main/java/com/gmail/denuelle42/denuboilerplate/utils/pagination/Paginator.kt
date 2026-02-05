package com.gmail.denuelle42.denuboilerplate.utils.pagination

interface Paginator<Key, Item> {
   suspend fun loadNextItems()
   suspend fun reset()
}