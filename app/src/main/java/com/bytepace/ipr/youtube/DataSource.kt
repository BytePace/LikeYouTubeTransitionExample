package com.bytepace.ipr.youtube

object DataSource {
    val items by lazy {
        mutableListOf<Item>().apply {
            repeat(5) {
                add(Item("The Secret Life of Walter Mitty", "Beta",
                    "https://image-ticketfly.imgix.net/00/01/61/65/25-og.jpg?w=500&h=334&fit=crop&crop=top",
                    R.drawable.beta))

                add(Item("Breaking Bad 1.3", "Netflix",
                    "https://ichef.bbci.co.uk/news/660/cpsprodpb/1094D/production/_108471976_95214ef6-d0b9-462c-98e9-9d0a86f2d135.jpg",
                    R.drawable.netflix))

                add(Item("Pulp Fiction - Go into The Story", "Kinopoisk",
                    "https://miro.medium.com/max/2400/1*9QwZkXU_gfk5FJotW-dCnA.jpeg",
                    R.drawable.kinopoisk))

                add(Item("If Joaquin Phoenix Is Willing to Do It?!", "IndieWire",
                    "https://www.indiewire.com/wp-content/uploads/2019/06/joker-movie-fb.jpg?w=768",
                    R.drawable.indiewire))
            }
        }
    }
}

data class Item(
    val name: String,
    val subname: String,
    val previewUrl: String,
    val thumbID: Int
)