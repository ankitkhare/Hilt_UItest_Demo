package com.example.myapplication

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

class PostViewScreen : Screen<PostViewScreen>() {
    val recycler: KRecyclerView = KRecyclerView({
        withId(R.id.recycler)
    }, itemTypeBuilder = {
        itemType(::PostItem)
    })
}

class PostItem(parent: Matcher<View>) : KRecyclerItem<PostItem>(parent) {
    val title = KTextView(parent) { withId(R.id.title) }
    val body = KTextView(parent) { withId(R.id.body) }
}